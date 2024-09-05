package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.exception.ResourceNotFoundException;
import com.RouteGaurd.app.model.Admin;
import com.RouteGaurd.app.model.SuperAdmin;
import com.RouteGaurd.app.repositories.AdminRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Admin createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id)
            .map(admin -> {
                admin.setUsername(updatedAdmin.getUsername());
                admin.setEmail(updatedAdmin.getEmail());
                admin.setRole(updatedAdmin.getRole());
                admin.setDob(updatedAdmin.getDob());
                admin.setAddress(updatedAdmin.getAddress());
                admin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
                admin.setConfirmPassword(passwordEncoder.encode(updatedAdmin.getConfirmPassword()));
                
                return adminRepository.save(admin);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
    
    
    public Admin addAdmin(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("Admin data must not be null");
        }

       
        return adminRepository.save(admin);
    }

	public boolean authenticateAdmin(String email, String password) {
		 
        Admin admin = adminRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with email " + email));
        
        return password.equals(admin.getPassword());
	}

	public String generateToken(String email) { //String userId
		String secretKey = "route-gaurd";

        return Jwts.builder()
                .setSubject(email)//String userId
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000)) // 10 days
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
	}
}








//package com.RouteGaurd.app.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.RouteGaurd.app.exception.ResourceNotFoundException;
//import com.RouteGaurd.app.model.Admin;
//import com.RouteGaurd.app.model.CustomerRegistration;
//import com.RouteGaurd.app.model.SuperAdmin;
//import com.RouteGaurd.app.repositories.AdminRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AdminService {
//	
////	@Autowired
////    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public List<Admin> getAllAdmins() {
//        return adminRepository.findAll();
//    }
//
//    public Optional<Admin> getAdminById(Long id) {
//        return adminRepository.findById(id);
//    }
//
//    public Admin createAdmin(Admin admin) {
//        return adminRepository.save(admin);
//    }
//
//    public Admin updateAdmin(Long id, Admin updatedAdmin) {
//        return adminRepository.findById(id)
//            .map(admin -> {
//                admin.setUserName(updatedAdmin.getUserName());
//                admin.setRole(updatedAdmin.getRole());
//                admin.setDob(updatedAdmin.getDob());
//                admin.setAddress(updatedAdmin.getAddress());
//                admin.setPassword(updatedAdmin.getPassword());
//                admin.setModifiedAt(updatedAdmin.getModifiedAt());
//                admin.setModifiedBy(updatedAdmin.getModifiedBy());
//                return adminRepository.save(admin);
//            })
//            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + id));
//    }
//
//    public void deleteAdmin(Long id) {
//        adminRepository.deleteById(id);
//    }
//
////	public boolean authenticateAdmin(String userName, String password) {
////		// TODO Auto-generated method stub
////		return false;
////	}
//	
//
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//    
//	 public boolean authenticateAdmin(String username, String password) {
//	    	
//		    
//	        Admin admin = adminRepository.findByUsername(username)
//	            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with UserName " + username));
//	        
//	        return password.equals(admin.getPassword());
//	    }
//
////	public Admin addAdmin(Admin admin) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	
//
//    public Admin addAdmin( Admin admin) {
//        if (admin == null) {
//            throw new IllegalArgumentException("Admin data must not be null");
//        }
//
//        // Save customer to the database
//        return adminRepository.save(admin);
//    }
//
//	
//
//
//	
//}
//    
