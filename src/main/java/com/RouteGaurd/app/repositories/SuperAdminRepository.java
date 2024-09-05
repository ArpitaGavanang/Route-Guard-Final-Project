package com.RouteGaurd.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RouteGaurd.app.model.SuperAdmin;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {
//
//	boolean existsByPassword(String password);
//
//	SuperAdmin findByName(String username);
//	
}
