package com.example.restau.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restau.dao.IDao;
import com.example.restau.entities.Zone;
import com.example.restau.repository.ZoneRepository;

@Service
public class ZoneService implements IDao<Zone> {

	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public Zone findById(int id) {
		 return zoneRepository.findById(id);
	
	}
	
	public List<Zone> getZonesByVilleId(int villeId) {
		return zoneRepository.findByVilleId(villeId);
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
		
	}

	@Override
	public void update(Zone o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		Zone zone = zoneRepository.findById(id);
		zoneRepository.delete(zone);
		
	}

	@Override
	public Zone save(Zone zone) {
		return zoneRepository.save(zone);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	


	
/*	
	public List<Zone> getAllZones() {
		return zoneRepository.findAll();
	}

	public List<Zone> getZonesByVilleId(int villeId) {
		return zoneRepository.findByVilleId(villeId);
	}
	

	 public Zone getZoneById(int id) {
		 return zoneRepository.findById(id);
	    }
	 
	public Zone createZone(Zone zone) {
		return zoneRepository.save(zone);
	}
	
	public Zone updateZone(int id, Zone zone) {
		Zone z = zoneRepository.findById(id);
		z.setNom(zone.getNom());
		z.setVille(zone.getVille());
		return zoneRepository.save(z);
	}
	
	public void deleteZone(int id) {
		Zone zone = zoneRepository.findById(id);
		zoneRepository.delete(zone);
	}
*/	
}
