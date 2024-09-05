package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RouteGaurd.app.model.Trip;
import com.RouteGaurd.app.model.VehicleMaster;
import com.RouteGaurd.app.repositories.DriverMasterRepository;
import com.RouteGaurd.app.repositories.TripRepository;
import com.RouteGaurd.app.repositories.VehicleMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private VehicleMasterRepository vehicleRepository;
    
    @Autowired
    private DriverMasterRepository driverMasterRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }
    
    @Transactional
    public void saveTrip(Trip trip) {
        // Ensure VehicleMaster and DriverMaster are saved before saving Trip
        vehicleRepository.save(trip.getVehicle());
        driverMasterRepository.save(trip.getDriver());
        tripRepository.save(trip);
    }


    @Transactional
    public Trip createTrip(Trip trip) {
        // Ensure VehicleMaster exists
        if (trip.getVehicle() != null && trip.getVehicle().getId() != null) {
            VehicleMaster vehicle = vehicleRepository.findById(trip.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
            trip.setVehicle(vehicle);
        }
        return tripRepository.save(trip);
    }

    @Transactional
    public Trip updateTrip(Long id, Trip tripDetails) {
        Trip existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip != null) {
            // Update vehicle reference if needed
            if (tripDetails.getVehicle() != null && tripDetails.getVehicle().getId() != null) {
                VehicleMaster vehicle = vehicleRepository.findById(tripDetails.getVehicle().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
                existingTrip.setVehicle(vehicle);
            }
            existingTrip.setSource(tripDetails.getSource());
            existingTrip.setDestination(tripDetails.getDestination());
            existingTrip.setDepartureTime(tripDetails.getDepartureTime());
            existingTrip.setArrivalTime(tripDetails.getArrivalTime());
            existingTrip.setStatus(tripDetails.getStatus());
            return tripRepository.save(existingTrip);
        }
        return null;
    }

    @Transactional
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

}











//package com.RouteGaurd.app.service;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.RouteGaurd.app.model.Trip;
//import com.RouteGaurd.app.repositories.TripRepository;
//
//@Service
//public class TripService {
//
//    @Autowired
//    private TripRepository tripRepository;
//
//    public List<Trip> getAllTrips() {
//        return tripRepository.findAll();
//    }
//
//    public Trip getTripById(int id) {
//        return tripRepository.findById(id).orElse(null);
//    }
//    @Transactional
//    public Trip createTrip(Trip trip) {
//        return tripRepository.save(trip);
//    }
//
//    public Trip updateTrip(int id, Trip tripDetails) {
//        Trip trip = tripRepository.findById(id).orElse(null);
//        if (trip != null) {
//            trip.setVehicle(tripDetails.getVehicle());
//            trip.setDriver(tripDetails.getDriver());
//            trip.setSource(tripDetails.getSource());
//            trip.setDestination(tripDetails.getDestination());
//            trip.setDepartureTime(tripDetails.getDepartureTime());
//            trip.setArrivalTime(tripDetails.getArrivalTime());
//            trip.setStatus(tripDetails.getStatus());
//            
//            return tripRepository.save(trip);
//        }
//        return null;
//    }
//
//    public void deleteTrip(int id) {
//        tripRepository.deleteById(id);
//    }
//}


