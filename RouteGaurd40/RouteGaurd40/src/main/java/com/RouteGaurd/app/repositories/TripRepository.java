package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RouteGaurd.app.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	List<Trip> findAll();
	Optional<Trip> findById(Long id);
	Trip save(Trip trip);
	boolean existsById(Long tripID);
	void deleteById(Long id);
}













//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.RouteGaurd.app.model.Trip;
//
//public interface TripRepository extends JpaRepository<Trip, Long> {
//
//	List<Trip> findAll();
//	Optional<Trip> findById(Long id);
//	Trip save(Trip trip);
//	void deleteById(Long id);
//}