package com.RouteGaurd.app.repositories;

import com.RouteGaurd.app.model.DriverMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverMaster, Long> {
}
