package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RouteGaurd.app.model.CustomerData;

public interface CustomerRepository extends JpaRepository<CustomerData, Long> {
    // Additional query methods can be defined here if needed
    List<CustomerData> findAll(); 
    Optional<CustomerData> findById(Long id);
    CustomerData save(CustomerData customerData);
    boolean existsById(Long id);
    void deleteById(Long id);
	CustomerData findByPhoneNumber(String username);
}