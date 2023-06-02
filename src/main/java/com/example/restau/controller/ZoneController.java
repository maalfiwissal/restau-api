package com.example.restau.controller;





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
import com.example.restau.entities.Zone;

import com.example.restau.service.ZoneService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("zones")
public class ZoneController {
	
	@Autowired
	private ZoneService zoneService;
	

	
	@GetMapping("")
	public List<Zone> getAllVilles() {
		return zoneService.findAll();
	}
	
	@GetMapping("/{id}")
	public Zone getZoneById(@PathVariable int id) {
		return zoneService.findById(id);
	}
	
	@GetMapping("/ville/{villeId}")
	public List<Zone> getZonesByVilleId(@PathVariable int villeId) {
		return zoneService.getZonesByVilleId(villeId);
	}
	
	@PostMapping("/save")
	 public Zone createZone(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }
	

	
	/*
	  public Zone createZone(@RequestBody Zone zone) {
		
		/*ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(zone);
		System.out.println(json);
		return zoneService.createZone(zone);
	}
	*/
	
	@PutMapping("/{id}")
	public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
		zone.setId(id);
		return zoneService.save(zone);
	}
	
	@DeleteMapping("/{id}")
	public void deleteZone(@PathVariable int id) {
		zoneService.delete(id);
	}
	

	
/*	@Autowired
	private ZoneRepository zoneRepository;
	
	@GetMapping("")
	public List<Zone> getZones() {
		return zoneRepository.findByVille(null);
	}
	*/
}
