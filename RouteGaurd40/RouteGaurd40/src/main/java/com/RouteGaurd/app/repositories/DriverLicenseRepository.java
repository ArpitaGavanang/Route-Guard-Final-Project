package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RouteGaurd.app.model.DriverLicense;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long> {

	List<DriverLicense> findAll();
	Optional<DriverLicense> findById(Long id);
	DriverLicense save(DriverLicense driverLicense);
	void deleteById(Long id);
	
}