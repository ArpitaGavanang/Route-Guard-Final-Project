package com.RouteGaurd.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RouteGaurd.app.model.DriverRegistration;

public interface DriverRegistrationRepository extends JpaRepository<DriverRegistration, Long> {
    // You can add custom query methods here if needed
	DriverRegistration save(DriverRegistration driverRegistration);
}
