package com.RouteGaurd.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.model.DriverMaster;
import com.RouteGaurd.app.repositories.DriverMasterRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverMasterService {

    @Autowired
    private DriverMasterRepository driverMasterRepository;

    public List<DriverMaster> getAllDrivers() {
        return driverMasterRepository.findAll();
    }

    public Optional<DriverMaster> getDriverById(Long id) {
        return driverMasterRepository.findById(id);
    }

    public DriverMaster saveDriver(DriverMaster driver) {
        return driverMasterRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        driverMasterRepository.deleteById(id);
    }
   
    
    

}
