package com.RouteGaurd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.CompanyTrip;
import com.RouteGaurd.app.service.CompanyTripService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company-trips")
public class CompanyTripController {

    @Autowired
    private CompanyTripService service;

    @GetMapping
    public ResponseEntity<List<CompanyTrip>> getAllCompanyTrips() {
        List<CompanyTrip> trips = service.getAllCompanyTrips();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyTrip> getCompanyTripById(@PathVariable Long id) {
        Optional<CompanyTrip> trip = service.getCompanyTripById(id);
        return trip.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CompanyTrip> createCompanyTrip(@RequestBody CompanyTrip companyTrip) {
        CompanyTrip savedTrip = service.saveCompanyTrip(companyTrip);
        return new ResponseEntity<>(savedTrip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyTrip> updateCompanyTrip(@PathVariable Long id, @RequestBody CompanyTrip companyTrip) {
        if (!service.getCompanyTripById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyTrip.setId(id);
        CompanyTrip updatedTrip = service.saveCompanyTrip(companyTrip);
        return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyTrip(@PathVariable Long id) {
        if (!service.getCompanyTripById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteCompanyTrip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

