package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.model.CompanyTrip;
import com.RouteGaurd.app.repositories.CompanyTripRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyTripService {

    @Autowired
    private CompanyTripRepository repository;

    public List<CompanyTrip> getAllCompanyTrips() {
        return repository.findAll();
    }

    public Optional<CompanyTrip> getCompanyTripById(Long id) {
        return repository.findById(id);
    }

    public CompanyTrip saveCompanyTrip(CompanyTrip companyTrip) {
        return repository.save(companyTrip);
    }

    public void deleteCompanyTrip(Long id) {
        repository.deleteById(id);
    }
}
