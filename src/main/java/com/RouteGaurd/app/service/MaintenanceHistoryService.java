package com.RouteGaurd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RouteGaurd.app.model.MaintenanceHistory;
import com.RouteGaurd.app.repositories.MaintenanceHistoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceHistoryService {

    @Autowired
    private MaintenanceHistoryRepository repository;

    public List<MaintenanceHistory> getAllMaintenanceHistories() {
        return repository.findAll();
    }

    public Optional<MaintenanceHistory> getMaintenanceHistoryById(Long id) {
        return repository.findById(id);
    }

    public MaintenanceHistory saveMaintenanceHistory(MaintenanceHistory maintenanceHistory) {
        return repository.save(maintenanceHistory);
    }

    public void deleteMaintenanceHistory(Long id) {
        repository.deleteById(id);
    }
}

