package com.RouteGaurd.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripID;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverID", nullable = false)
    private DriverMaster driver;
    
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleID", nullable = false)
    private VehicleMaster vehicle;

    @Column(nullable = false, length = 255)
    private String source;

    @Column(nullable = false, length = 255)
    private String destination;

    @Column(nullable = false)
    private LocalDate departureTime;

    @Column
    private LocalDate arrivalTime;

    
    @Column(nullable = false, length = 50)
    private String status;



    
    public Trip() { }
    

	public Trip(Long tripID, DriverMaster driver,VehicleMaster vehicle,  String source, String destination,
			LocalDate departureTime, LocalDate arrivalTime,  String status ) {
		super();
		this.tripID = tripID;
		this.driver = driver;
		this.vehicle = vehicle;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		
	}

	public Long getTripID() {
		return tripID;
	}

	public void setTripID(Long tripID) {
		this.tripID = tripID;
	}
	

	public DriverMaster getDriver() {
		return driver;
	}

	public void setDriver(DriverMaster driver) {
		this.driver = driver;
	}

	public VehicleMaster getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleMaster vehicle) {
		this.vehicle = vehicle;
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

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
    // Getters and Setters
    // Constructors
}


























//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "trip_master")
//public class Trip {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private DriverMaster driver;   // Assume Driver is another entity
//    private VehicleMaster vehicle; // Assume Vehicle is another entity
//    //private CustomerData customer; // Assume Customer is another entity
//    private String route;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//    private String status;
//
//    // Constructors
//    public Trip() {
//    }
//
//    public Trip(Long id, DriverMaster driver, VehicleMaster vehicle, String route,
//                LocalDateTime startDate, LocalDateTime endDate, String status) {
//        this.id = id;
//        this.driver = driver;
//        this.vehicle = vehicle;
//        this.route = route;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.status = status;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public DriverMaster getDriver() {
//        return driver;
//    }
//
//    public void setDriver(DriverMaster driver) {
//        this.driver = driver;
//    }
//
//    public VehicleMaster getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(VehicleMaster vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public String getRoute() {
//        return route;
//    }
//
//    public void setRoute(String route) {
//        this.route = route;
//    }
//
//    public LocalDateTime getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDateTime startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDateTime getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDateTime endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}




//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "trip")
//public class Trip {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long tripId;
//
//    @ManyToOne
//    @JoinColumn(name = "vehicle_id")
//    private VehicleMaster vehicle;
//
//    @ManyToOne
//    @JoinColumn(name = "driver_id")
//    private DriverMaster driver;
//
//    private String source;
//    private String destination;
//    private LocalDateTime departureTime;
//    private LocalDateTime arrivalTime;
//
//    @ManyToOne
//    @JoinColumn(name = "goods_id")
//    private Goods goods; // Changed to Good entity
//
//    private String status;
//    private String chalan;
//    private String createdBy;
//    private LocalDateTime createdAt;
//    private String modifiedBy;
//    private LocalDateTime modifiedAt;
//
//    public Trip() { }
//
//    public Trip(Long tripId, VehicleMaster vehicle, DriverMaster driver, String source, String destination,
//                LocalDateTime departureTime, LocalDateTime arrivalTime, Goods goods, // Changed to Good entity
//                String status, String chalan, String createdBy, LocalDateTime createdAt,
//                String modifiedBy, LocalDateTime modifiedAt) {
//        this.tripId = tripId;
//        this.vehicle = vehicle;
//        this.driver = driver;
//        this.source = source;
//        this.destination = destination;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.goods = goods; // Changed to Good entity
//        this.status = status;
//        this.chalan = chalan;
//        this.createdBy = createdBy;
//        this.createdAt = createdAt;
//        this.modifiedBy = modifiedBy;
//        this.modifiedAt = modifiedAt;
//    }
//
//    public Long getTripId() {
//        return tripId;
//    }
//
//    public void setTripId(Long tripId) {
//        this.tripId = tripId;
//    }
//
//    public VehicleMaster getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(VehicleMaster vehicle_master) {
//        this.vehicle = vehicle_master;
//    }
//
//    public DriverMaster getDriver() {
//        return driver;
//    }
//
//    public void setDriver(DriverMaster driver_master) {
//        this.driver = driver_master;
//    }
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//
//    public LocalDateTime getDepartureTime() {
//        return departureTime;
//    }
//
//    public void setDepartureTime(LocalDateTime departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public LocalDateTime getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public void setArrivalTime(LocalDateTime arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }
//
//    public Goods getGoods() { // Changed to Good entity
//        return goods;
//    }
//
//    public void setGoods(Goods goods) { // Changed to Good entity
//        this.goods = goods;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getChalan() {
//        return chalan;
//    }
//
//    public void setChalan(String chalan) {
//        this.chalan = chalan;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//
//    public LocalDateTime getModifiedAt() {
//        return modifiedAt;
//    }
//
//    public void setModifiedAt(LocalDateTime modifiedAt) {
//        this.modifiedAt = modifiedAt;
//    }
//
//    @Override
//    public String toString() {
//        return "Trip [tripId=" + tripId + ", vehicle_master=" + vehicle + ", driver_master=" + driver + ", source=" + source
//                + ", destination=" + destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
//                + ", goods=" + goods + ", status=" + status + ", chalan=" + chalan + ", createdBy=" + createdBy
//                + ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
//    }
//}






//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "trip")
//public class Trip {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long tripId;
//
//    @ManyToOne
//    @JoinColumn(name = "vehicle_id")
//    private VehicleMaster vehicle;
//
//    @ManyToOne
//    @JoinColumn(name = "driver_id")
//    private DriverMaster driver;
//
//    private String source;
//    private String destination;
//    private LocalDateTime departureTime;
//    private LocalDateTime arrivalTime;
//
//    @ManyToOne
//    @JoinColumn(name = "goods_id")
//    private Good goods;
//
//    private String status;
//    private String chalan;
//    private String createdBy;
//    private LocalDateTime createdAt;
//    private String modifiedBy;
//    private LocalDateTime modifiedAt;
//    
//    public Trip() { }
//    
//	public Trip(Long tripId, VehicleMaster vehicle, DriverMaster driver, String source, String destination,
//			LocalDateTime departureTime, LocalDateTime arrivalTime, int goodId, String status, String chalan,
//			String createdBy, LocalDateTime createdAt, String modifiedBy, LocalDateTime modifiedAt) {
//		super();
//		this.tripId = tripId;
//		this.vehicle = vehicle;
//		this.driver = driver;
//		this.source = source;
//		this.destination = destination;
//		this.departureTime = departureTime;
//		this.arrivalTime = arrivalTime;
//		this.goodsId = goodId;
//		this.status = status;
//		this.chalan = chalan;
//		this.createdBy = createdBy;
//		this.createdAt = createdAt;
//		this.modifiedBy = modifiedBy;
//		this.modifiedAt = modifiedAt;
//	}
//	public Long getTripId() {
//		return tripId;
//	}
//	public void setTripId(Long tripId) {
//		this.tripId = tripId;
//	}
//	public VehicleMaster getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(VehicleMaster vehicle) {
//		this.vehicle = vehicle;
//	}
//	public DriverMaster getDriver() {
//		return driver;
//	}
//	public void setDriver(DriverMaster driver) {
//		this.driver = driver;
//	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public String getDestination() {
//		return destination;
//	}
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//	public LocalDateTime getDepartureTime() {
//		return departureTime;
//	}
//	public void setDepartureTime(LocalDateTime departureTime) {
//		this.departureTime = departureTime;
//	}
//	public LocalDateTime getArrivalTime() {
//		return arrivalTime;
//	}
//	public void setArrivalTime(LocalDateTime arrivalTime) {
//		this.arrivalTime = arrivalTime;
//	}
//	public long getGoodId() {
//		return goodsId;
//	}
//	public void setGoodId(int goodId) {
//		this.goodsId = goodId;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getChalan() {
//		return chalan;
//	}
//	public void setChalan(String chalan) {
//		this.chalan = chalan;
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
//	@Override
//	public String toString() {
//		return "Trip [tripId=" + tripId + ", vehicle=" + vehicle + ", driver=" + driver + ", source=" + source
//				+ ", destination=" + destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
//				+ ", goodId=" + goodsId + ", status=" + status + ", chalan=" + chalan + ", createdBy=" + createdBy
//				+ ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + "]";
//	}
//
//    
//}
