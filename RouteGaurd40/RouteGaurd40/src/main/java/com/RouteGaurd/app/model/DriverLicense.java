package com.RouteGaurd.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "driver_license")
public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverMaster driver;

    private String licenseNumber;
    private LocalDateTime licenseStartDate;
    private LocalDateTime licenseExpireDate;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
    
    public DriverLicense() { }
    
	public DriverLicense(Long id, DriverMaster driver, String licenseNumber, LocalDateTime licenseStartDate,
			LocalDateTime licenseExpireDate, String createdBy, LocalDateTime createdAt, String modifiedBy,
			LocalDateTime modifiedAt) {
		super();
		this.id = id;
		this.driver = driver;
		this.licenseNumber = licenseNumber;
		this.licenseStartDate = licenseStartDate;
		this.licenseExpireDate = licenseExpireDate;
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
	public DriverMaster getDriver() {
		return driver;
	}
	public void setDriver(DriverMaster driver) {
		this.driver = driver;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public LocalDateTime getLicenseStartDate() {
		return licenseStartDate;
	}
	public void setLicenseStartDate(LocalDateTime licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}
	public LocalDateTime getLicenseExpireDate() {
		return licenseExpireDate;
	}
	public void setLicenseExpireDate(LocalDateTime licenseExpireDate) {
		this.licenseExpireDate = licenseExpireDate;
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
		return "DriverLicense [id=" + id + ", driver=" + driver + ", licenseNumber=" + licenseNumber
				+ ", licenseStartDate=" + licenseStartDate + ", licenseExpireDate=" + licenseExpireDate + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt
				+ "]";
	}

    // Getters and Setters
    
}

