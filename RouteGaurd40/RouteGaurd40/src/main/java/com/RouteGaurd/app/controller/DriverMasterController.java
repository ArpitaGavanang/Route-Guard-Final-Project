package com.RouteGaurd.app.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.RouteGaurd.app.model.DriverMaster;
import com.RouteGaurd.app.repositories.DriverMasterRepository;
import com.RouteGaurd.app.repositories.DriverRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/drivers")
public class DriverMasterController {

    @Autowired
    private DriverMasterRepository driverMasterRepository;

    // Get all drivers
    @GetMapping("/getDrivers")
    public List<DriverMaster> getAllDrivers() {
        return driverMasterRepository.findAll();
    }

    // Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverMaster> getDriverById(@PathVariable Long id) {
        Optional<DriverMaster> driver = driverMasterRepository.findById(id);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing driver
    @PutMapping("/{id}")
    //@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<DriverMaster> updateDriver(@PathVariable Long id, @RequestBody DriverMaster driverDetails) {
        Optional<DriverMaster> driver = driverMasterRepository.findById(id);

        if (driver.isPresent()) {
            DriverMaster existingDriver = driver.get();
            existingDriver.setPhoneNumber(driverDetails.getPhoneNumber());
            existingDriver.setAdharNumber(driverDetails.getAdharNumber());
            existingDriver.setPanNumber(driverDetails.getPanNumber());
            existingDriver.setDriverName(driverDetails.getDriverName());
            existingDriver.setDob(driverDetails.getDob());
            existingDriver.setAddress(driverDetails.getAddress());
            existingDriver.setNationality(driverDetails.getNationality());
            

            final DriverMaster updatedDriver = driverMasterRepository.save(existingDriver);
            return ResponseEntity.ok(updatedDriver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a driver
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id) {
    	System.out.print(id);
        if (driverMasterRepository.existsById(id)) {
            driverMasterRepository.deleteById(id);
            return ResponseEntity.ok("Driver Deleted Successfully");
        } else {
        	  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Driver Not Found");
        }
    }
    
    @PostMapping("/register")
  public ResponseEntity<DriverMaster> registerDriver(@RequestBody DriverMaster driver) {
      LocalDateTime now = LocalDateTime.now();
      //driver.setCreatedAt(now);
              DriverMaster savedDriver = driverMasterRepository.save(driver);
      return ResponseEntity.ok(savedDriver);
   }
    
    
}   
    
