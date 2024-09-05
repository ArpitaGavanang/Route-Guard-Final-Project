package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RouteGaurd.app.model.CustomerRegistration;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Long> {
    // You can add custom query methods here if needed
	CustomerRegistration save(CustomerRegistration customerRegistration);
	List<CustomerRegistration> findAll();
	Optional<CustomerRegistration> findById(Long id);
}
