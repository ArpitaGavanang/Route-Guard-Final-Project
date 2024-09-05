//package com.RouteGaurd.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.RouteGaurd.app.model.Trip;
//import com.RouteGaurd.app.service.TripService;
//
//import jakarta.transaction.Transactional;
//
//@RestController
//@RequestMapping("/api/trips")
//public class TripController {
//
//    @Autowired
//    private TripService tripService;
//
//    @GetMapping("/getTrips")
//    public List<Trip> getAllTrips() {
//        return tripService.getAllTrips();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
//        Trip trip = tripService.getTripById(id);
//        if (trip != null) {
//            return ResponseEntity.ok(trip);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/postTrip")
//    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
//        try {
//            Trip createdTrip = tripService.createTrip(trip);
//            return ResponseEntity.ok(createdTrip);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    @Transactional
//    @PutMapping("/{id}")
//    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
//        Trip updatedTrip = tripService.updateTrip(id, tripDetails);
//        if (updatedTrip != null) {
//            return ResponseEntity.ok(updatedTrip);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @Transactional
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
//        tripService.deleteTrip(id);
//        return ResponseEntity.noContent().build();
//    }
//}



//========================================================================================================================
package com.RouteGaurd.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.Trip;
import com.RouteGaurd.app.repositories.TripRepository;
import com.RouteGaurd.app.service.TripService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;
    
    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/getTrips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        Trip trip = tripService.getTripById(id);
        if (trip != null) {
            return ResponseEntity.ok(trip);
        }
        return ResponseEntity.notFound().build();
    }

 
    @PostMapping("/postTrip")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        try {
            Trip createdTrip = tripService.createTrip(trip);
            return ResponseEntity.ok(createdTrip);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
        Trip updatedTrip = tripService.updateTrip(id, tripDetails);
        if (updatedTrip != null) {
            return ResponseEntity.ok(updatedTrip);
        }
        return ResponseEntity.notFound().build();
    }
    
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Long id) {
    	System.out.print(id);
        if (tripRepository.existsById(id)) {
        tripRepository.deleteById(id);
        return ResponseEntity.ok("Trip Deleted Successfully"); // Return 204 No Content if deletion is successful
    }
        else {
      	  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Trip Not Found");
      }
  }
   
}














////////==========================
//@Transactional
//@DeleteMapping("/{id}")
//public ResponseEntity<?> deleteTrip(@PathVariable Long id) {
//	System.out.print(id);
//    if (id == null || !tripRepository.existsById(id)) {
//        return ResponseEntity.badRequest().build(); // Return 400 Bad Request for missing or invalid ID
//    }
//    
//    tripRepository.deleteById(id);
//    return ResponseEntity.noContent().build(); // Return 204 No Content if deletion is successful
//}
//=======================================


//=============================================
//package com.RouteGaurd.app.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.RouteGaurd.app.model.Trip;
//import com.RouteGaurd.app.service.TripService;
//
//@RestController
//@RequestMapping("/api/trips")
//public class TripController {
//
//    @Autowired
//    private TripService tripService;
//
//    @GetMapping("/getTrips")
//    public List<Trip> getAllTrips() {
//        return tripService.getAllTrips();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Trip> getTripById(@PathVariable int id) {
//        Trip trip = tripService.getTripById(id);
//        if (trip != null) {
//            return ResponseEntity.ok(trip);
//        }
//        return ResponseEntity.notFound().build();
//    }
//    @Transactional
//    @PostMapping("/postTrip")
//    public Trip createTrip(@RequestBody Trip trip) {
//        return tripService.createTrip(trip);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Trip> updateTrip(@PathVariable int id, @RequestBody Trip tripDetails) {
//        Trip updatedTrip = tripService.updateTrip(id, tripDetails);
//        if (updatedTrip != null) {
//            return ResponseEntity.ok(updatedTrip);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTrip(@PathVariable int id) {
//        tripService.deleteTrip(id);
//        return ResponseEntity.noContent().build();
//    }
//}





