package com.RouteGaurd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.MaintenanceHistory;
import com.RouteGaurd.app.service.MaintenanceHistoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance-history")
public class MaintenanceHistoryController {

    @Autowired
    private MaintenanceHistoryService service;

    @GetMapping
    public ResponseEntity<List<MaintenanceHistory>> getAllMaintenanceHistories() {
        List<MaintenanceHistory> histories = service.getAllMaintenanceHistories();
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceHistory> getMaintenanceHistoryById(@PathVariable Long id) {
        Optional<MaintenanceHistory> history = service.getMaintenanceHistoryById(id);
        return history.map(ResponseEntity::ok)
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MaintenanceHistory> createMaintenanceHistory(@RequestBody MaintenanceHistory maintenanceHistory) {
        MaintenanceHistory savedHistory = service.saveMaintenanceHistory(maintenanceHistory);
        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceHistory> updateMaintenanceHistory(@PathVariable Long id, @RequestBody MaintenanceHistory maintenanceHistory) {
        if (!service.getMaintenanceHistoryById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        maintenanceHistory.setId(id);
        MaintenanceHistory updatedHistory = service.saveMaintenanceHistory(maintenanceHistory);
        return new ResponseEntity<>(updatedHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenanceHistory(@PathVariable Long id) {
        if (!service.getMaintenanceHistoryById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteMaintenanceHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
