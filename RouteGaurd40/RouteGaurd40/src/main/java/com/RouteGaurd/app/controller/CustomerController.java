package com.RouteGaurd.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.CustomerData;
import com.RouteGaurd.app.service.CustomerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @GetMapping
//    public List<CustomerData> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
    
    @GetMapping("/getCustomer")
    public ResponseEntity<List<CustomerData>> getAllCustomers() {
        List<CustomerData> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerData> getCustomerById(@PathVariable Long id) {
        Optional<CustomerData> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public CustomerData createCustomer(@RequestBody CustomerData customer) {
//        return customerService.createCustomer(customer);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerData> updateCustomer(@PathVariable Long id, @RequestBody CustomerData updatedCustomer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updatedCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerData> registerCustomer(@RequestBody CustomerData customer) {
        // Set the created and modified timestamps
        LocalDateTime now = LocalDateTime.now();
  

        CustomerData savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    

//    @PostMapping//("/addCustomer")
//    public ResponseEntity<CustomerData> addCustomer(@RequestBody CustomerData customer) {
//        CustomerData savedCustomer = customerService.addCustomer(customer);
//        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
//    }

}

