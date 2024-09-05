package com.RouteGaurd.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.DriverLicense;
import com.RouteGaurd.app.service.DriverLicenseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/driver-licenses")
public class DriverLicenseController {

    @Autowired
    private DriverLicenseService driverLicenseService;

    @GetMapping
    public List<DriverLicense> getAllDriverLicenses() {
        return driverLicenseService.getAllDriverLicenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverLicense> getDriverLicenseById(@PathVariable Long id) {
        Optional<DriverLicense> driverLicense = driverLicenseService.getDriverLicenseById(id);
        return driverLicense.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DriverLicense createDriverLicense(@RequestBody DriverLicense driverLicense) {
        return driverLicenseService.createDriverLicense(driverLicense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverLicense> updateDriverLicense(@PathVariable Long id, @RequestBody DriverLicense updatedDriverLicense) {
        return ResponseEntity.ok(driverLicenseService.updateDriverLicense(id, updatedDriverLicense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverLicense(@PathVariable Long id) {
        driverLicenseService.deleteDriverLicense(id);
        return ResponseEntity.noContent().build();
    }
}

