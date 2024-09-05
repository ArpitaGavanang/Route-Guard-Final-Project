package com.RouteGaurd.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RouteGaurd.app.model.VehicleMaster;
import com.RouteGaurd.app.repositories.VehicleMasterRepository;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleMasterController {

    @Autowired
    private VehicleMasterRepository vehicleMasterRepository;

    // Get all vehicles
    @GetMapping("/GetVehicles")
    public List<VehicleMaster> getAllVehicles() {
        return vehicleMasterRepository.findAll();
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleMaster> getVehicleById(@PathVariable Long id) {
        Optional<VehicleMaster> vehicle = vehicleMasterRepository.findById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new vehicle
    @PostMapping("/addvehicle")
    public VehicleMaster createVehicle(@RequestBody VehicleMaster vehicleMaster) {
        return vehicleMasterRepository.save(vehicleMaster);
    }

    // Update an existing vehicle
    @PutMapping("/{id}")
    public ResponseEntity<VehicleMaster> updateVehicle(@PathVariable Long id, @RequestBody VehicleMaster vehicleDetails) {
        Optional<VehicleMaster> vehicle = vehicleMasterRepository.findById(id);

        if (vehicle.isPresent()) {
            VehicleMaster existingVehicle = vehicle.get();
            existingVehicle.setVehicleNumber(vehicleDetails.getVehicleNumber());
            existingVehicle.setVehicleName(vehicleDetails.getVehicleName());
            existingVehicle.setVehicleModelNumber(vehicleDetails.getVehicleModelNumber());
            existingVehicle.setPuc(vehicleDetails.getPuc());
            existingVehicle.setAccidentHistory(vehicleDetails.getAccidentHistory());
            existingVehicle.setCarryingCapacity(vehicleDetails.getCarryingCapacity());
           
            final VehicleMaster updatedVehicle = vehicleMasterRepository.save(existingVehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        if (vehicleMasterRepository.existsById(id)) {
            vehicleMasterRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}