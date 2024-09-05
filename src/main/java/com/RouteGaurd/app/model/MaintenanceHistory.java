package com.RouteGaurd.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_history")
public class MaintenanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleMaster vehicle;

    private LocalDateTime maintenanceDate;
    private String maintenanceType;
    private String maintenanceDetails;
    private Double cost;
    private LocalDateTime nextScheduledMaintenance;
    private String vendorName;
    private String vendorPhone;
    private String vendorAddress;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
    
    public MaintenanceHistory() { }
    
	public MaintenanceHistory(Long id, VehicleMaster vehicle, LocalDateTime maintenanceDate, String maintenanceType,
			String maintenanceDetails, Double cost, LocalDateTime nextScheduledMaintenance, String vendorName,
			String vendorPhone, String vendorAddress, String createdBy, LocalDateTime createdAt, String modifiedBy,
			LocalDateTime modifiedAt) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.maintenanceDate = maintenanceDate;
		this.maintenanceType = maintenanceType;
		this.maintenanceDetails = maintenanceDetails;
		this.cost = cost;
		this.nextScheduledMaintenance = nextScheduledMaintenance;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorAddress = vendorAddress;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VehicleMaster getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleMaster vehicle) {
		this.vehicle = vehicle;
	}
	public LocalDateTime getMaintenanceDate() {
		return maintenanceDate;
	}
	public void setMaintenanceDate(LocalDateTime maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}
	public String getMaintenanceType() {
		return maintenanceType;
	}
	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}
	public String getMaintenanceDetails() {
		return maintenanceDetails;
	}
	public void setMaintenanceDetails(String maintenanceDetails) {
		this.maintenanceDetails = maintenanceDetails;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public LocalDateTime getNextScheduledMaintenance() {
		return nextScheduledMaintenance;
	}
	public void setNextScheduledMaintenance(LocalDateTime nextScheduledMaintenance) {
		this.nextScheduledMaintenance = nextScheduledMaintenance;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	@Override
	public String toString() {
		return "MaintenanceHistory [id=" + id + ", vehicle=" + vehicle + ", maintenanceDate=" + maintenanceDate
				+ ", maintenanceType=" + maintenanceType + ", maintenanceDetails=" + maintenanceDetails + ", cost="
				+ cost + ", nextScheduledMaintenance=" + nextScheduledMaintenance + ", vendorName=" + vendorName
				+ ", vendorPhone=" + vendorPhone + ", vendorAddress=" + vendorAddress + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
	}

    
}

