package com.RouteGaurd.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "company_trip")
public class CompanyTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerData customer;

    private String source;
    private String destination;
    private String goodsCategory;
    private Double goodsWeight;
    private LocalDateTime dateToBeDeparted;
    private Double goodsCost;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
    
    public CompanyTrip() { }
    
	public CompanyTrip(Long id, CustomerData customer, String source, String destination, String goodsCategory,
			Double goodsWeight, LocalDateTime dateToBeDeparted, Double goodsCost, String createdBy,
			LocalDateTime createdAt, String modifiedBy, LocalDateTime modifiedAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.source = source;
		this.destination = destination;
		this.goodsCategory = goodsCategory;
		this.goodsWeight = goodsWeight;
		this.dateToBeDeparted = dateToBeDeparted;
		this.goodsCost = goodsCost;
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
	public CustomerData getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerData customer) {
		this.customer = customer;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	public Double getGoodsWeight() {
		return goodsWeight;
	}
	public void setGoodsWeight(Double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	public LocalDateTime getDateToBeDeparted() {
		return dateToBeDeparted;
	}
	public void setDateToBeDeparted(LocalDateTime dateToBeDeparted) {
		this.dateToBeDeparted = dateToBeDeparted;
	}
	public Double getGoodsCost() {
		return goodsCost;
	}
	public void setGoodsCost(Double goodsCost) {
		this.goodsCost = goodsCost;
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
		return "CompanyTrip [id=" + id + ", customer=" + customer + ", source=" + source + ", destination="
				+ destination + ", goodsCategory=" + goodsCategory + ", goodsWeight=" + goodsWeight
				+ ", dateToBeDeparted=" + dateToBeDeparted + ", goodsCost=" + goodsCost + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
	}

    
}
