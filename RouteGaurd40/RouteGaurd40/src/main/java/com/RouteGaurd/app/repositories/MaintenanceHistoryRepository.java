package com.RouteGaurd.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RouteGaurd.app.model.MaintenanceHistory;

public interface MaintenanceHistoryRepository extends JpaRepository<MaintenanceHistory, Long> {
}

