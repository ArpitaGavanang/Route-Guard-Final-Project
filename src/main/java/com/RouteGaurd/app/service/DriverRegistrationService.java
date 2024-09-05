package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.model.DriverRegistration;
import com.RouteGaurd.app.repositories.DriverRegistrationRepository;

@Service
public class DriverRegistrationService {
	
	 @Autowired
	    private DriverRegistrationRepository driverRegistrationRepository;
	
	 public DriverRegistration save(DriverRegistration driver) {
	        return driverRegistrationRepository.save(driver);
	    }

//	public DriverRegistration save(DriverRegistration driver) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
