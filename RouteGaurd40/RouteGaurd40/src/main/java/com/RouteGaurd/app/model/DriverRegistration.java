package com.RouteGaurd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "driverRegistration_master")
public class DriverRegistration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String adharNumber;
    private String panNumber;
    private String driverName;
    private LocalDate dob;
    private String address;
    private String nationality;
//    private String createdBy;
//    private LocalDateTime createdAt;
//    private String modifiedBy;
//    private LocalDateTime modifiedAt;
    
    public DriverRegistration() { }
    
	public DriverRegistration(Long id, String phoneNumber, String adharNumber, String panNumber, String driverName,
			LocalDate dob, String address, String nationality
			) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.driverName = driverName;
		this.dob = dob;
		this.address = address;
		this.nationality = nationality;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public String toString() {
		return "DriverMaster [id=" + id + ", phoneNumber=" + phoneNumber + ", adharNumber=" + adharNumber
				+ ", panNumber=" + panNumber + ", driverName=" + driverName + ", dob=" + dob + ", address=" + address
				+ ", nationality=" + nationality  + "]";
	}

}
