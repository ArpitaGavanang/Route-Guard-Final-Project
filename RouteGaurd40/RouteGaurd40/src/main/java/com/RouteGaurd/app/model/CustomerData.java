package com.RouteGaurd.app.model;

import java.time.LocalDate;

import com.RouteGaurd.app.converter.LocalDateAttributeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_data")
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyAddress;
    private String gstNumber;
    private String phoneNumber;
    private String email;
    
    @Column(name = "established_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate establishedDate;
    
    private String createdBy;
    
    public CustomerData() { }
    
    public CustomerData(Long id, String companyName, String companyAddress, String gstNumber, String phoneNumber,
                        String email, LocalDate establishedDate, String createdBy) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.gstNumber = gstNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.establishedDate = establishedDate;
        this.createdBy = createdBy;
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

    @Override
    public String toString() {
        return "CustomerData [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
                + ", gstNumber=" + gstNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", establishedDate=" + establishedDate + ", createdBy=" + createdBy + "]";
    }
}

















//
//package com.RouteGaurd.app.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "customer_data")
//public class CustomerData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String gstNumber;
//    private String phoneNumber;
//    private String email;
//    private LocalDateTime establishedDate;
//    private String createdBy;
//    private LocalDateTime createdAt;
//    private String modifiedBy;
//    private LocalDateTime modifiedAt;
//    
//    public CustomerData() { }
//    
//	public CustomerData(Long id, String companyName, String companyAddress, String gstNumber, String phoneNumber,
//			String email, LocalDateTime establishedDate, String createdBy, LocalDateTime createdAt, String modifiedBy,
//			LocalDateTime modifiedAt) {
//		super();
//		this.id = id;
//		this.companyName = companyName;
//		this.companyAddress = companyAddress;
//		this.gstNumber = gstNumber;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.establishedDate = establishedDate;
//		this.createdBy = createdBy;
//		this.createdAt = createdAt;
//		this.modifiedBy = modifiedBy;
//		this.modifiedAt = modifiedAt;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getCompanyName() {
//		return companyName;
//	}
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//	public String getCompanyAddress() {
//		return companyAddress;
//	}
//	public void setCompanyAddress(String companyAddress) {
//		this.companyAddress = companyAddress;
//	}
//	public String getGstNumber() {
//		return gstNumber;
//	}
//	public void setGstNumber(String gstNumber) {
//		this.gstNumber = gstNumber;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public LocalDateTime getEstablishedDate() {
//		return establishedDate;
//	}
//	public void setEstablishedDate(LocalDateTime establishedDate) {
//		this.establishedDate = establishedDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//	public LocalDateTime getModifiedAt() {
//		return modifiedAt;
//	}
//	public void setModifiedAt(LocalDateTime modifiedAt) {
//		this.modifiedAt = modifiedAt;
//	}
//	
//	@Override
//	public String toString() {
//		return "CustomerData [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
//				+ ", gstNumber=" + gstNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
//				+ ", establishedDate=" + establishedDate + ", createdBy=" + createdBy + ", createdAt=" + createdAt
//				+ ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
//	}
//
//    
//}
//



//import java.time.LocalDate;
//
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
//
//import jakarta.persistence.Convert;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "customer_data")
//public class CustomerData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String gstNumber;
//    private String phoneNumber;
//    private String email;
//   
//    //@Column(name = "establishedDate", columnDefinition = "DATE")
//    //@Convert(converter = LocalDateConverter.class)
//    private LocalDate establishedDate;
//    private String createdBy;
//    
//   
//    
//    public CustomerData() { }
//    
//	public CustomerData(Long id, String companyName, String companyAddress, String gstNumber, String phoneNumber,
//			String email, LocalDate establishedDate, String createdBy) {
//		super();
//		this.id = id;
//		this.companyName = companyName;
//		this.companyAddress = companyAddress;
//		this.gstNumber = gstNumber;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.establishedDate = establishedDate;
//		this.createdBy = createdBy;
//		
//		
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getCompanyName() {
//		return companyName;
//	}
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//	public String getCompanyAddress() {
//		return companyAddress;
//	}
//	public void setCompanyAddress(String companyAddress) {
//		this.companyAddress = companyAddress;
//	}
//	public String getGstNumber() {
//		return gstNumber;
//	}
//	public void setGstNumber(String gstNumber) {
//		this.gstNumber = gstNumber;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public LocalDate getEstablishedDate() {
//		return establishedDate;
//	}
//	public void setEstablishedDate(LocalDate establishedDate) {
//		this.establishedDate = establishedDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	
//	@Override
//	public String toString() {
//		return "CustomerData [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
//				+ ", gstNumber=" + gstNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
//				+ ", establishedDate=" + establishedDate + ", createdBy=" + createdBy 
//				 + "]";
//	}
//
//    
//}







//
//import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "customer_data")
//public class CustomerData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String gstNumber;
//    private String phoneNumber;
//    private String email;
//    //@Convert(converter = LocalDateConverter.class)
//    private LocalDate establishedDate;
//    private String createdBy;
//    
//   
//    
//    public CustomerData() { }
//    
//	public CustomerData(Long id, String companyName, String companyAddress, String gstNumber, String phoneNumber,
//			String email, LocalDate establishedDate, String createdBy) {
//		super();
//		this.id = id;
//		this.companyName = companyName;
//		this.companyAddress = companyAddress;
//		this.gstNumber = gstNumber;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.establishedDate = establishedDate;
//		this.createdBy = createdBy;
//		
//		
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getCompanyName() {
//		return companyName;
//	}
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//	public String getCompanyAddress() {
//		return companyAddress;
//	}
//	public void setCompanyAddress(String companyAddress) {
//		this.companyAddress = companyAddress;
//	}
//	public String getGstNumber() {
//		return gstNumber;
//	}
//	public void setGstNumber(String gstNumber) {
//		this.gstNumber = gstNumber;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public LocalDate getEstablishedDate() {
//		return establishedDate;
//	}
//	public void setEstablishedDate(LocalDate establishedDate) {
//		this.establishedDate = establishedDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	
//	@Override
//	public String toString() {
//		return "CustomerData [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
//				+ ", gstNumber=" + gstNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
//				+ ", establishedDate=" + establishedDate + ", createdBy=" + createdBy 
//				 + "]";
//	}
//
//    
//}
