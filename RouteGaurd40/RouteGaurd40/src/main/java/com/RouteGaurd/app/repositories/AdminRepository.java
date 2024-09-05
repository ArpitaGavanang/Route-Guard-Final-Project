package com.RouteGaurd.app.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RouteGaurd.app.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

//	Optional<Admin> findByUsername(String username);
	Optional <Admin>findByEmail(String email);
    // You can define custom query methods if needed
//	boolean existsByPassword(String password);
//
	//Admin findByUserName(String username);
}

