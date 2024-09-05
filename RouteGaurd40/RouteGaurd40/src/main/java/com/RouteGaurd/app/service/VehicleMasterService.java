package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.model.VehicleMaster;
import com.RouteGaurd.app.repositories.VehicleMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMasterService {

    @Autowired
    private VehicleMasterRepository repository;

    public List<VehicleMaster> getAllVehicles() {
        return repository.findAll();
    }

    public Optional<VehicleMaster> getVehicleById(Long id) {
        return repository.findById(id);
    }

    public VehicleMaster saveVehicle(VehicleMaster vehicle) {
        return repository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}

