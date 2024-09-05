package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RouteGaurd.app.model.VehicleMaster;

@Repository
public interface VehicleMasterRepository extends JpaRepository<VehicleMaster, Long> {

	List<VehicleMaster> findAll();
	Optional<VehicleMaster> findById(Long id);
	VehicleMaster save(VehicleMaster vehicleMaster);
	boolean existsById(Long id);
	void deleteById(Long id);
	
}
