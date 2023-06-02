package com.example.restau.controller;






import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restau.entities.Restaurant;
import com.example.restau.entities.Serie;
import com.example.restau.entities.Specialite;
import com.example.restau.entities.Ville;
import com.example.restau.entities.Zone;
import com.example.restau.repository.RestaurantRepository;
import com.example.restau.repository.SerieRepository;
import com.example.restau.repository.SpecialiteRepository;
import com.example.restau.repository.VilleRepository;
import com.example.restau.repository.ZoneRepository;
import com.example.restau.service.RestaurantService;
import com.example.restau.service.VilleService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("villes")
public class VilleController {
	
	
	@Autowired
	private VilleService villeService;
	

	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	@GetMapping("")
	public List<Ville> findAll(){
		return villeService.findAll();
	}
	
	 @GetMapping("/{id}")
	    public Ville getVilleById(@PathVariable int id) {
	        return villeService.findById(id);
	    }
	 
	 
	  @PostMapping("")
	    public Ville createVille(@RequestBody Ville ville) {
	        return villeService.save(ville);
	    }
	  

	
	    @PutMapping("/{id}")
	    public Ville updateVille(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingCity = villeService.findById(id);
	        if (existingCity != null) {
	            existingCity.setNom(ville.getNom());
	            return villeService.save(existingCity);
	        }
	        return null;
	    }
	  
	  

	  @DeleteMapping("/{id}")
	    public void deleteVille(@PathVariable int id) {
	        villeService.delete(id);
	    }
	  
	  
	  @GetMapping("/{ville}/zones")
		public List<Zone> getZones(@PathVariable int ville) {
			Ville foundVille = villeRepository.findById(ville);
			return zoneRepository.findByVille(foundVille);
	  }
	  
	  
	  
	  @GetMapping("/{ville}/zones/{zone}/restaurants")
			public List<Restaurant> getRestaurants(@PathVariable int ville, @PathVariable String zone) {
				 Ville foundVille = villeRepository.findById(ville);
				 Zone foundZone = zoneRepository.findByNomAndVille(zone, foundVille);
				 return restaurantRepository.findByZone(foundZone);
				 
			}
	  
		@GetMapping("/{ville}/zones/{zone}/restaurants/{id}")
		public Restaurant getRestaurant(@PathVariable int ville, @PathVariable String zone, @PathVariable Integer id) {
			Ville foundVille = villeService.findById(ville);
			 Zone foundZone = zoneRepository.findByNomAndVille(zone, foundVille);
			 return restaurantRepository.findByIdAndZone(id, foundZone);
			 }
	  
	  
/*	  @GetMapping("/{ville}/zones/{zone}/restaurants")
		public List<Restaurant> getRestaurants(@PathVariable int ville, @PathVariable String zone, 
			   @RequestParam("specialite") Optional<String> specialite, @RequestParam("chaine") Optional<String> chaine) {
			 Ville foundVille = villeRepository.findById(ville);
			 Zone foundZone = zoneRepository.findByNomAndVille(zone, foundVille);
			 List<Restaurant> restaurants = restaurantRepository.findByZone(foundZone);
			 if(specialite.isPresent()) {
		     Specialite foundSpecialite = specialiteRepository.findByNom(specialite.orElse(""));
			 restaurants = restaurants.stream().filter(restaurant -> restaurant.getSpecilites().contains(foundSpecialite)).collect(Collectors.toList());
			 }
			 if(chaine.isPresent()) {
				 Serie foundSerie = serieRepository.findByNom(chaine.orElse(""));
				 restaurants = restaurants.stream().filter(restaurant -> restaurant.getSerie().equals(foundSerie)).collect(Collectors.toList());
			 }
			 return restaurants;
		}
*/
	  
	  
/*	
	
	@GetMapping("/{ville}/zones")
	public List<Zone> getZones(@PathVariable int ville) {
		Ville foundVille = villeService.findById(ville);
		return zoneRepository.findByVille(foundVille);
	}
	  
	@GetMapping("/{ville}/zones/{zone}/restaurants")
	public List<Restaurant> getRestaurants(@PathVariable int ville, @PathVariable String zone, 
			@RequestParam("specialite") Optional<String> specialite, @RequestParam("chaine") Optional<String> chaine) {
		 Ville foundVille = villeService.findById(ville);
		 Zone foundZone = zoneRepository.findByNomAndVille(zone, foundVille);
		 List<Restaurant> restaurants = restaurantRepository.findByZone(foundZone);
		 if(specialite.isPresent()) {
	     Specialite foundSpecialite = specialiteRepository.findByNom(specialite.orElse(""));
		 restaurants = restaurants.stream().filter(restaurant -> restaurant.getSpecilites().contains(foundSpecialite)).collect(Collectors.toList());
		 }
		 if(chaine.isPresent()) {
			 Serie foundSerie = serieRepository.findByNom(chaine.orElse(""));
			 restaurants = restaurants.stream().filter(restaurant -> restaurant.getSerie().equals(foundSerie)).collect(Collectors.toList());
		 }
		 return restaurants;
	}
	
	@GetMapping("/{ville}/zones/{zone}/restaurants/{id}")
	public Restaurant getRestaurant(@PathVariable int ville, @PathVariable String zone, @PathVariable Integer id) {
		Ville foundVille = villeService.findById(ville);
		 Zone foundZone = zoneRepository.findByNomAndVille(zone, foundVille);
		 return restaurantRepository.findByIdAndZone(id, foundZone);
		 }
*/	
	
}
