package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RouteGaurd.app.model.DriverMaster;

@Repository
public interface DriverMasterRepository extends JpaRepository<DriverMaster, Long> {

	List<DriverMaster> findAll();
	Optional<DriverMaster> findById(Long id);
	DriverMaster save(DriverMaster driver);
	boolean existsById(Long id);
	void deleteById(Long id);
	DriverMaster findByPhoneNumber(String username);
}
