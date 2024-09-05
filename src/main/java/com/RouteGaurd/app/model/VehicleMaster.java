package com.RouteGaurd.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
@Table(name = "vehicle_master")
public class VehicleMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String vehicleName;
    private String vehicleModelNumber;
    private String puc;
    private String accidentHistory;
    private String carryingCapacity;
   
    
    public VehicleMaster() {  }
    
	public VehicleMaster(Long id, String vehicleNumber, String vehicleName, String vehicleModelNumber, String puc,
			String accidentHistory, String carryingCapacity) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.vehicleModelNumber = vehicleModelNumber;
		this.puc = puc;
		this.accidentHistory = accidentHistory;
		this.carryingCapacity = carryingCapacity;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleModelNumber() {
		return vehicleModelNumber;
	}
	public void setVehicleModelNumber(String vehicleModelNumber) {
		this.vehicleModelNumber = vehicleModelNumber;
	}
	public String getPuc() {
		return puc;
	}
	public void setPuc(String puc) {
		this.puc = puc;
	}
	public String getAccidentHistory() {
		return accidentHistory;
	}
	public void setAccidentHistory(String accidentHistory) {
		this.accidentHistory = accidentHistory;
	}
	public String getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(String carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}
	
	@Override
	public String toString() {
		return "VehicleMaster [id=" + id + ", vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName
				+ ", vehicleModelNumber=" + vehicleModelNumber + ", puc=" + puc + ", accidentHistory=" + accidentHistory
				+ ", carryingCapacity=" + carryingCapacity +  "]";
	}

    // Getters and Setters
    
}

