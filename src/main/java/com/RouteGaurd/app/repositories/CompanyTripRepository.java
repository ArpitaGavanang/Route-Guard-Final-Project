package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RouteGaurd.app.model.CompanyTrip;

public interface CompanyTripRepository extends JpaRepository<CompanyTrip, Long> {

	List<CompanyTrip> findAll();
	Optional<CompanyTrip> findById(Long id);
	CompanyTrip save(CompanyTrip companyTrip);
	void deleteById(Long id);
}

