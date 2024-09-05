package com.RouteGaurd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerRegistration_data")
public class CustomerRegistration {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String companyName;
	    private String companyAddress;
	    private String gstNumber;
	    private String phoneNumber;
	    private String email;
	    private LocalDate establishedDate;
	    private String createdBy;
	    private LocalDateTime createdAt;
	   
	    
	    public CustomerRegistration() { }
	    
		public CustomerRegistration(Long id, String companyName, String companyAddress, String gstNumber, String phoneNumber,
				String email, LocalDate establishedDate, String createdBy, LocalDateTime createdAt) {
			super();
			this.id = id;
			this.companyName = companyName;
			this.companyAddress = companyAddress;
			this.gstNumber = gstNumber;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.establishedDate = establishedDate;
			this.createdBy = createdBy;
			this.createdAt = createdAt;
			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyAddress() {
			return companyAddress;
		}
		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}
		public String getGstNumber() {
			return gstNumber;
		}
		public void setGstNumber(String gstNumber) {
			this.gstNumber = gstNumber;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LocalDate getEstablishedDate() {
			return establishedDate;
		}
		public void setEstablishedDate(LocalDate establishedDate) {
			this.establishedDate = establishedDate;
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
		
		@Override
		public String toString() {
			return "CustomerData [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
					+ ", gstNumber=" + gstNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
					+ ", establishedDate=" + establishedDate + ", createdBy=" + createdBy + ", createdAt=" + createdAt
					 + "]";
		}

}
