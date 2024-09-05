package com.RouteGaurd.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.exception.ResourceNotFoundException;
import com.RouteGaurd.app.model.DriverLicense;
import com.RouteGaurd.app.repositories.DriverLicenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DriverLicenseService {

    @Autowired
    private DriverLicenseRepository driverLicenseRepository;

    public List<DriverLicense> getAllDriverLicenses() {
        return driverLicenseRepository.findAll();
    }

    public Optional<DriverLicense> getDriverLicenseById(Long id) {
        return driverLicenseRepository.findById(id);
    }

    public DriverLicense createDriverLicense(DriverLicense driverLicense) {
        return driverLicenseRepository.save(driverLicense);
    }

    public DriverLicense updateDriverLicense(Long id, DriverLicense updatedDriverLicense) {
        return driverLicenseRepository.findById(id)
            .map(driverLicense -> {
                driverLicense.setDriver(updatedDriverLicense.getDriver());
                driverLicense.setLicenseNumber(updatedDriverLicense.getLicenseNumber());
                driverLicense.setLicenseStartDate(updatedDriverLicense.getLicenseStartDate());
                driverLicense.setLicenseExpireDate(updatedDriverLicense.getLicenseExpireDate());
                driverLicense.setModifiedAt(updatedDriverLicense.getModifiedAt());
                driverLicense.setModifiedBy(updatedDriverLicense.getModifiedBy());
                return driverLicenseRepository.save(driverLicense);
            })
            .orElseThrow(() -> new ResourceNotFoundException("DriverLicense not found with id " + id));
    }

    public void deleteDriverLicense(Long id) {
        driverLicenseRepository.deleteById(id);
    }
}
