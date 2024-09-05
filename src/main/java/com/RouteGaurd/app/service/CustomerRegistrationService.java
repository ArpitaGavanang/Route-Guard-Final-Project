package com.RouteGaurd.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RouteGaurd.app.model.CustomerRegistration;
import com.RouteGaurd.app.repositories.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationService {

    @Autowired
    private CustomerRegistrationRepository customerRegistrationRepository;

    public CustomerRegistration addCustomer(CustomerRegistration customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer data must not be null");
        }

        // Save customer to the database
        return customerRegistrationRepository.save(customer);
    }

	public List<CustomerRegistration> getAllCustomers() {
		 return customerRegistrationRepository.findAll();

	}

	public Optional<CustomerRegistration> getCustomerById(Long id) {
		 return customerRegistrationRepository.findById(id);

	}
}




//package com.RouteGaurd.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.RouteGaurd.app.model.CustomerData;
//import com.RouteGaurd.app.model.CustomerRegistration;
//import com.RouteGaurd.app.repositories.CustomerRegistrationRepository;
//
//public class CustomerRegistrationService {
//
//	@Autowired
//    private CustomerRegistrationRepository customerRegistrationRepository;
//	
//  public CustomerRegistration addCustomer(CustomerRegistration customer) {
//      if (customer == null) {
//          throw new IllegalArgumentException("Customer data must not be null");
//      }
//
//      // Save customer to the database
//      return customerRegistrationRepository.save(customer);
//    }
//
//}
