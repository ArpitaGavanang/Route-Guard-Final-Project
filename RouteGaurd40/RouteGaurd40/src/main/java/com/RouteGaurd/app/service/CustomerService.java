package com.RouteGaurd.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.exception.ResourceNotFoundException;
import com.RouteGaurd.app.model.Admin;
import com.RouteGaurd.app.model.CustomerData;
import com.RouteGaurd.app.repositories.AdminRepository;
import com.RouteGaurd.app.repositories.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerData> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<CustomerData> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public CustomerData createCustomer(CustomerData customer) {
        return customerRepository.save(customer);
    }

    public CustomerData updateCustomer(Long id, CustomerData updatedCustomer) {
        return customerRepository.findById(id)
            .map(customer -> {
                customer.setCompanyName(updatedCustomer.getCompanyName());
                customer.setCompanyAddress(updatedCustomer.getCompanyAddress());
                customer.setGstNumber(updatedCustomer.getGstNumber());
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setEstablishedDate(updatedCustomer.getEstablishedDate());
                customer.setCreatedBy(updatedCustomer.getCreatedBy());
                return customerRepository.save(customer);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

//    @Autowired
//    private CustomerRepository customerRepository;

//    public CustomerData addCustomer(CustomerData customer) {
//        // Validate customer data (optional, can add more validations if needed)
//        if (customer == null) {
//            throw new IllegalArgumentException("Customer data must not be null");
//        }
//
//        // Save customer to the database
//        return customerRepository.save(customer);
//    }
    
}

