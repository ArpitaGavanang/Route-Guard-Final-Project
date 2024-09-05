package com.RouteGaurd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.Admin;
import com.RouteGaurd.app.model.LoginResponse;
import com.RouteGaurd.app.service.AdminService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	
		
	@GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAdminDashboard() {
        // Endpoint logic
        return ResponseEntity.ok().build();
    }

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/postAdmin")
//    public Admin createAdmin(@RequestBody Admin admin) {
//        return adminService.createAdmin(admin);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        return ResponseEntity.ok(adminService.updateAdmin(id, updatedAdmin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PostMapping("/Adminlogin")
    public ResponseEntity<LoginResponse> login(@RequestBody Admin loginRequest) {
        boolean isAuthenticated = adminService.authenticateAdmin(loginRequest.getEmail(), loginRequest.getPassword());
        System.out.print("Admin login");
        if (isAuthenticated) {
            String email=loginRequest.getEmail().toString();
            String token = adminService.generateToken(email);
            
            System.out.println(email);
            System.out.println(token);
            System.out.println(loginRequest.getEmail());
            System.out.println(loginRequest.getPassword());
            
            LoginResponse response = new LoginResponse("Login successful", "admin", token);
            return ResponseEntity.ok(response);
        } else {
           
            LoginResponse response = new LoginResponse("Invalid credentials", null, null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }	    
    
       
    @PostMapping("/register")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        try {
            System.out.println("Received admin data: " + admin.toString());
            Admin adminRegister = adminService.addAdmin(admin);
            return new ResponseEntity<>(adminRegister, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
  
}
