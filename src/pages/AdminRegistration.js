import React from 'react';
import axios from 'axios';
import { TextField, Button, Card, CardContent, Typography, MenuItem } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import dayjs from 'dayjs';
import { LocalizationProvider, DatePicker } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import * as yup from 'yup';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import Layout from '../components/Layout/Layout';

// Validation schema with yup
const validationSchema = yup.object({
  username: yup.string()
      .matches(/^[^.\s]*$/, 'Username should not contain special characters like dots')
      .required('Username is required'),
  email: yup.string().email('Invalid email address').required('Email is required'),
  role: yup.string().required('Role is required'),
  dob: yup.date()
      .required('Date of Birth is required')
      .nullable()
      .notOneOf([dayjs().startOf('day').toDate()], 'Date of Birth cannot be today')
      .test('age', 'Must be at least 18 years old', value => {
          if (!value) return false;
          const today = dayjs();
          const birthDate = dayjs(value);
          return today.diff(birthDate, 'year') >= 18;
      }),
  address: yup.string().required('Address is required'),
  password: yup.string().min(6, 'Password must be at least 6 characters').required('Password is required'),
  confirmPassword: yup.string().oneOf([yup.ref('password'), null], 'Passwords must match').required('Confirm Password is required')
});

const AdminRegistration = () => {
    const navigate = useNavigate();

    const handleSubmit = async (values, { setSubmitting, setErrors }) => {
        setSubmitting(true);

        try {
            const response = await axios.post('http://localhost:8080/api/admins/register', {
                username: values.username,
                email: values.email,
                role: values.role,
                dob: values.dob.format('YYYY-MM-DDTHH:mm:ss'),
                address: values.address,
                password: values.password,
            });

            await axios.post(`http://localhost:8080/api/email/send?toEmail=${values.email}&username=${values.username}&password=${values.password}`);

            if (response.status === 201) {
                navigate('/admin-dashBoard');
            }
        } catch (error) {
            setErrors({ server: 'Registration failed. Please try again.' });
        } finally {
            setSubmitting(false);
        }
    };

    return (
        <Layout>
            <div className="registration-container">
                <Card sx={{ maxWidth: 400, margin: 'auto', padding: 2 }}>
                    <CardContent>
                        <Typography variant="h5" component="div" gutterBottom>
                            Admin Registration
                        </Typography>
                        <Formik
                            initialValues={{
                                username: '',
                                email: '',
                                role: '',
                                dob: dayjs(),
                                address: '',
                                password: '',
                                confirmPassword: '',
                            }}
                            validationSchema={validationSchema}
                            onSubmit={handleSubmit}
                        >
                            {({ isSubmitting, setFieldValue }) => (
                                <Form>
                                    <Field name="username">
                                        {({ field, meta }) => (
                                            <TextField
                                                fullWidth
                                                margin="normal"
                                                label="Username"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            />
                                        )}
                                    </Field>
                                    <Field name="email">
                                        {({ field, meta }) => (
                                            <TextField
                                                fullWidth
                                                margin="normal"
                                                label="Email"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            />
                                        )}
                                    </Field>
                                    <Field name="role">
                                        {({ field, meta }) => (
                                            <TextField
                                                select
                                                fullWidth
                                                margin="normal"
                                                label="Role"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            >
                                                <MenuItem value="SuperAdmin">SuperAdmin</MenuItem>
                                                <MenuItem value="Admin">Admin</MenuItem>
                                            </TextField>
                                        )}
                                    </Field>
                                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                                        <Field name="dob">
                                            {({ field, form }) => (
                                                <DatePicker
                                                    label="Date of Birth"
                                                    value={form.values.dob}
                                                    onChange={(newValue) => setFieldValue('dob', newValue)}
                                                    renderInput={(params) => (
                                                        <TextField
                                                            fullWidth
                                                            margin="normal"
                                                            {...params}
                                                            error={form.touched.dob && Boolean(form.errors.dob)}
                                                            helperText={form.touched.dob && form.errors.dob}
                                                        />
                                                    )}
                                                />
                                            )}
                                        </Field>
                                    </LocalizationProvider>
                                    <Field name="address">
                                        {({ field, meta }) => (
                                            <TextField
                                                fullWidth
                                                margin="normal"
                                                label="Address"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            />
                                        )}
                                    </Field>
                                    <Field name="password">
                                        {({ field, meta }) => (
                                            <TextField
                                                fullWidth
                                                margin="normal"
                                                label="Password"
                                                type="password"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            />
                                        )}
                                    </Field>
                                    <Field name="confirmPassword">
                                        {({ field, meta }) => (
                                            <TextField
                                                fullWidth
                                                margin="normal"
                                                label="Confirm Password"
                                                type="password"
                                                variant="outlined"
                                                {...field}
                                                error={meta.touched && Boolean(meta.error)}
                                                helperText={meta.touched && meta.error}
                                            />
                                        )}
                                    </Field>
                                    <Button
                                        type="submit"
                                        variant="contained"
                                        color="primary"
                                        fullWidth
                                        disabled={isSubmitting}
                                        sx={{ marginTop: 2 }}
                                    >
                                        {isSubmitting ? 'Registering...' : 'Register'}
                                    </Button>
                                    <ErrorMessage name="server" component="div" style={{ color: 'red' }} />
                                </Form>
                            )}
                        </Formik>
                    </CardContent>
                </Card>
            </div>
        </Layout>
    );
};

export default AdminRegistration;







// import React, { useState } from 'react';
// import axios from 'axios';
// import { TextField, Button, Card, CardContent, Typography, MenuItem } from '@mui/material';
// import { useNavigate } from 'react-router-dom';
// import dayjs from 'dayjs';
// import { LocalizationProvider, DatePicker } from '@mui/x-date-pickers';
// import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
// import NavLinks from '../components/Navbar/NavBar';
// import Footer from '../components/Footer';
// import Layout from '../components/Layout/Layout';



// const AdminRegistration = () => {
//     const [username, setName] = useState('');
//     const[email,setEmail]=useState('');
//     const [role, setRole] = useState('');
//     const [dob, setDob] = useState(dayjs());
//     const [address, setAddress] = useState('');
//     const [password, setPassword] = useState('');
//     const [confirmPassword, setConfirmPassword] = useState('');
//     const [error, setError] = useState('');
//     const [loading, setLoading] = useState(false);
//     const navigate = useNavigate();
  
//     const roles = ['SuperAdmin', 'Admin']; 
  
//     const handleSubmit = async (e) => {
//       e.preventDefault();
//       setLoading(true);
//       setError('');
  
//       if (password !== confirmPassword) {
//         setError('Passwords do not match');
//         setLoading(false);
//         return;
//       }
  
//       try {
//         const response = await axios.post('http://localhost:8080/api/admins/register', {
//           username,
//           email,
//           role,
//           dob: dob.format('YYYY-MM-DDTHH:mm:ss'), 
//           address,
//           password,
//         });
//         const emailData= await axios.post(`http://localhost:8080/api/email/send?toEmail=${email}&username=${username}&password=${password}`)
//         console.log(emailData,"email data")

//         if (response.status === 201) {
//                   setLoading(false);
//                 navigate('/admin-dashBoard');
//         }
//       } catch (error) {
//         setError('Registration failed. Please try again.');
//         setLoading(false);
//       }
//     };
  
//     return (
//        <Layout> <div className="registration-container">
//        <Card sx={{ maxWidth: 400, margin: 'auto', padding: 2 }}>
//          <CardContent>
//            <Typography variant="h5" component="div" gutterBottom>
//              Admin Registration
//            </Typography>
//            {error && <Typography color="error" variant="body2">{error}</Typography>}
//            <form onSubmit={handleSubmit}>
//              <TextField
//                fullWidth
//                margin="normal"
//                label="UserName"
//                variant="outlined"
//                value={username}
//                onChange={(e) => setName(e.target.value)}
//                required
//              />
//               <TextField
//                fullWidth
//                margin="normal"
//                label="Email"
//                variant="outlined"
//                value={email}
//                onChange={(e) => setEmail(e.target.value)}
//                required
//              />
//              <TextField
//                select
//                fullWidth
//                margin="normal"
//                label="Role"
//                variant="outlined"
//                value={role}
//                onChange={(e) => setRole(e.target.value)}
//                required
//              >
//                {roles.map((role) => (
//                  <MenuItem key={role} value={role}>
//                    {role}
//                  </MenuItem>
//                ))}
//              </TextField>
//              <LocalizationProvider dateAdapter={AdapterDayjs}>
//                <DatePicker
//                  label="Date of Birth"
//                  value={dob}
//                  onChange={(newValue) => setDob(newValue)}
//                  //renderInput={(params) => <TextField fullWidth margin="normal" {...params} />}
//                  required
//                />
//              </LocalizationProvider>
//              <TextField
//                fullWidth
//                margin="normal"
//                label="Address"
//                variant="outlined"
//                value={address}
//                onChange={(e) => setAddress(e.target.value)}
//                required
//              />
//              <TextField
//                fullWidth
//                margin="normal"
//                label="Password"
//                type="password"
//                variant="outlined"
//                value={password}
//                onChange={(e) => setPassword(e.target.value)}
//                required
//              />
//              <TextField
//                fullWidth
//                margin="normal"
//                label="Confirm Password"
//                type="password"
//                variant="outlined"
//                value={confirmPassword}
//                onChange={(e) => setConfirmPassword(e.target.value)}
//                required
//              />
//              <Button
//                type="submit"
//                variant="contained"
//                color="primary"
//                fullWidth
//                disabled={loading}
//                sx={{ marginTop: 2 }}
//              >
//                {loading ? 'Registering...' : 'Register'}
//              </Button>
//            </form>
//          </CardContent>
//        </Card>
//      </div>
//      </Layout>
       
       
      
//     );
//   };
  
//   export default AdminRegistration;
  








