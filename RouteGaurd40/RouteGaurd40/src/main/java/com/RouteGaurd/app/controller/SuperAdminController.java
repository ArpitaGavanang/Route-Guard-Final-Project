package com.RouteGaurd.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RouteGaurd.app.model.LoginResponse;
import com.RouteGaurd.app.model.SuperAdmin;
import com.RouteGaurd.app.service.EmailService;
import com.RouteGaurd.app.service.SuperAdminService;

@RestController
@RequestMapping("/api/superadmins")
public class SuperAdminController {
	
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	    private SuperAdminService superAdminService;
	 
	 @PostMapping
	 public ResponseEntity<SuperAdmin> createSuperAdmin(@RequestBody SuperAdmin superAdmin) {
	     SuperAdmin createdSuperAdmin = superAdminService.createSuperAdmin(superAdmin);

	     // Send email after creation
	     emailService.sendAdminCredentials(superAdmin.getEmail(), superAdmin.getUsername(), superAdmin.getPassword());

	     return new ResponseEntity<>(createdSuperAdmin, HttpStatus.CREATED);
	 }

//	    @PostMapping
//	    public ResponseEntity<SuperAdmin> createSuperAdmin(@RequestBody SuperAdmin superAdmin) {
//	        return new ResponseEntity<>(superAdminService.createSuperAdmin(superAdmin), HttpStatus.CREATED);
//	        emailService.sendAdminCredentials(superAdmin.getEmail(), superAdmin.getUsername(), superAdmin.getPassword());
//	    }

	    @GetMapping
	    public List<SuperAdmin> getAllSuperAdmins() {
	        return superAdminService.getAllSuperAdmins();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<SuperAdmin> getSuperAdminById(@PathVariable Long id) {
	        return ResponseEntity.ok(superAdminService.getSuperAdminById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<SuperAdmin> updateSuperAdmin(@PathVariable Long id, @RequestBody SuperAdmin superAdminDetails) {
	        return ResponseEntity.ok(superAdminService.updateSuperAdmin(id, superAdminDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSuperAdmin(@PathVariable Long id) {
	        superAdminService.deleteSuperAdmin(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	
	    
//    @PostMapping("/SuperAdminlogin")
//	    public ResponseEntity<String> login(@RequestBody SuperAdmin loginRequest) {
//	        boolean isAuthenticated = superAdminService.authenticateSuperAdmin(loginRequest.getId(), loginRequest.getPassword());
//	        if (isAuthenticated) {
//	            return ResponseEntity.ok({"message":"Login successful",role:"superAdmin"});
//	        } else {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//	        }
//	    }
	    
	    
	    @PostMapping("/SuperAdminlogin")
	    public ResponseEntity<LoginResponse> login(@RequestBody SuperAdmin loginRequest) {
	        boolean isAuthenticated = superAdminService.authenticateSuperAdmin(loginRequest.getId(), loginRequest.getPassword());
	        
	        if (isAuthenticated) {
	             String id=loginRequest.getId().toString();
	            String token = superAdminService.generateToken(id);
	            
	            System.out.println(id);
	            System.out.println(token);
	            System.out.println(loginRequest.getId());
	            System.out.println(loginRequest.getPassword());
	            
	            LoginResponse response = new LoginResponse("Login successful", "superAdmin", token);
	            return ResponseEntity.ok(response);
	        } else {
	           
	            LoginResponse response = new LoginResponse("Invalid credentials", null, null);
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
	    }	    
}

