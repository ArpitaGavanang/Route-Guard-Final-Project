package com.RouteGaurd.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RouteGaurd.app.model.DriverRegistration;
import com.RouteGaurd.app.service.DriverRegistrationService;

@RestController
@RequestMapping("/api/registerDrivers")
public class DriverRegistrationController {
	 @Autowired
	    private DriverRegistrationService driverRegistrationService;

	    @PostMapping("/register")
	    public ResponseEntity<DriverRegistration> registerDriver(@RequestBody DriverRegistration driver) {
	        LocalDate now = LocalDate.now();
	        DriverRegistration savedDriver = driverRegistrationService.save(driver);
	        return ResponseEntity.ok(savedDriver);
	    }

}
