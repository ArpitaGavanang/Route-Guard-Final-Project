package com.RouteGaurd.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RouteGaurd.app.model.CustomerRegistration;
import com.RouteGaurd.app.service.CustomerRegistrationService;

@RestController
@RequestMapping("/api/registerCustomers")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<CustomerRegistration> addCustomer(@RequestBody CustomerRegistration customerRegistration) {
        try {
            CustomerRegistration registeredCustomer = customerRegistrationService.addCustomer(customerRegistration);
            return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
 // Get all customers
    @GetMapping("/all")
    public ResponseEntity<List<CustomerRegistration>> getAllCustomers() {
        try {
            List<CustomerRegistration> customers = customerRegistrationService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerRegistration> getCustomerById(@PathVariable Long id) {
        try {
            Optional<CustomerRegistration> customer = customerRegistrationService.getCustomerById(id);
            if (customer.isPresent()) {
                return new ResponseEntity<>(customer.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}










//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.RouteGaurd.app.model.CustomerRegistration;
//import com.RouteGaurd.app.service.CustomerRegistrationService;
//
//@RestController
//@RequestMapping("/api/registerCustomers")
//public class CustomerRegistrationController {
//
//    @Autowired
//    private CustomerRegistrationService customerRegistrationService;
//
//    @PostMapping("/register")
//    public ResponseEntity<CustomerRegistration> addCustomer(@RequestBody CustomerRegistration customerRegistration) {
//        try {
//            CustomerRegistration registeredCustomer = customerRegistrationService.addCustomer(customerRegistration);
//            return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    
// // Get all customers
//    @GetMapping("/all")
//    public ResponseEntity<List<CustomerRegistration>> getAllCustomers() {
//        try {
//            List<CustomerRegistration> customers = customerRegistrationService.getAllCustomers();
//            return new ResponseEntity<>(customers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Get a customer by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<CustomerRegistration> getCustomerById(@PathVariable Long id) {
//        try {
//            Optional<CustomerRegistration> customer = customerRegistrationService.getCustomerById(id);
//            if (customer.isPresent()) {
//                return new ResponseEntity<>(customer.get(), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}





//package com.RouteGaurd.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.RouteGaurd.app.model.CustomerRegistration;
//import com.RouteGaurd.app.service.CustomerRegistrationService;
//
//@RestController
//@RequestMapping("/api/registerCustomers")
//public class CustomerRegistrationController {
//	 @Autowired
//	    private CustomerRegistrationService customerRegistrationService;
//
//	    @PostMapping("/register")
//	    public ResponseEntity<CustomerRegistration> addCustomer(@RequestBody CustomerRegistration customerRegistration) {
//	        try {
//	        	CustomerRegistration registeredCustomer = customerRegistrationService.addCustomer(customerRegistration);
//	            return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
//	        } catch (Exception e) {
//	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    }
//
//
//}
