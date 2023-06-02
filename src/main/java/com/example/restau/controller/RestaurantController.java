package com.example.restau.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restau.dto.ReservationDto;
import com.example.restau.dto.RestaurantDto;
import com.example.restau.entities.Reservation;
import com.example.restau.entities.Restaurant;
import com.example.restau.entities.Zone;
import com.example.restau.service.RestaurantService;
import com.example.restau.service.VilleService;
import com.example.restau.service.ZoneService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("restaurants")

public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private VilleService villeService;
	@Autowired
	private ZoneService zoneService;
	
	@GetMapping("")
	public List<Restaurant> findAll(){
		return restaurantService.findAll();
	}
	
	 @GetMapping("/{id}")
	    public Restaurant getRestaurantById(@PathVariable int id) {
	        return restaurantService.findById(id);
	    }
	 
	 
	  @PostMapping("/zone/{idZone}")
	    public Restaurant createRestaurant(@RequestBody RestaurantDto restaurant, @PathVariable int idZone) {
		  	Zone zone = zoneService.findById(idZone);
		  	Restaurant restau = new Restaurant(0, restaurant.getLatitude(), restaurant.getLongitude(), restaurant.getAddress(),
		  			Collections.emptyList(), Collections.emptyList(), null, restaurant.getNom(), null, null, zone, null, restaurant.getRank(), "weekend");
	        return restaurantService.save(restau);    
	  }
	  
	    @PutMapping("/{id}")
	    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
	        Restaurant existingRestaurant = restaurantService.findById(id);
	        if (existingRestaurant != null) {
	            existingRestaurant.setNom(restaurant.getNom());
	            return restaurantService.save(existingRestaurant);
	        }
	        return null;
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteRestaurant(@PathVariable int id) {
	        restaurantService.delete(id);
	    }
	    
	    @PostMapping("/reserver/restau/{restauId}/user/{userId}")
	    public Reservation reserver(@PathVariable int restauId,@PathVariable int userId, @RequestBody ReservationDto reservation) {
	    	return restaurantService.reserver(restauId, userId, reservation);
	    }
	    
	    @GetMapping("/reservations/user/{userId}")
	    public List<Reservation> mesReservations(@PathVariable int userId) {
	    	return restaurantService.mesReservations(userId);
	    }
	  
	    @DeleteMapping("/reservation/{idReservation}")
	    public void annulerReservation(@PathVariable int idReservation) {
	    	 restaurantService.annulerReservation(idReservation);
	    }
	/*
		
		@Autowired
		private RestaurantRepository restaurantRepository;
		
		@GetMapping("")
		public List<Restaurant> getRestaurants() {
			return restaurantRepository.findByZone(null);
		}
*/
}
