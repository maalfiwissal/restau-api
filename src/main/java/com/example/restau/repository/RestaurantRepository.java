package com.example.restau.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restau.entities.Restaurant;
import com.example.restau.entities.Zone;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	List<Restaurant> findByZone(Zone zone);	
	Restaurant findByIdAndZone(Integer id, Zone zone);
	
	
	
	Restaurant findById(int id);
	

}
