package com.RouteGaurd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SuperAdmin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private LocalDate dob;
    private String address;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private String email;
    private String username;      // Add this field  
    
    public SuperAdmin() {  }
    
    public SuperAdmin(Long id, String name, String role, LocalDate dob, String address, String password,
			LocalDateTime createdAt, LocalDateTime modifiedAt, String modifiedBy, String email, String username) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
		this.email = email;
		this.username = username;
	}
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Override
	public String toString() {
		return "SuperAdmin [id=" + id + ", name=" + name + ", role=" + role + ", dob=" + dob + ", address=" + address
				+ ", password=" + password + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", modifiedBy="
				+ modifiedBy + "]";
	}


	
    
    

}
