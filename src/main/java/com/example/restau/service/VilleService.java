package com.example.restau.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restau.dao.IDao;
import com.example.restau.entities.Ville;
import com.example.restau.repository.VilleRepository;

import java.util.List;



@Service
public class VilleService implements IDao<Ville>  {
	
	@Autowired
	private VilleRepository villeRepository;
	@Override
	public Ville findById(int id) {
		 return villeRepository.findById(id);
		
	}

	@Override
	public List<Ville> findAll() {
		 return villeRepository.findAll();
		
	}

	@Override
	public void update(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		villeRepository.deleteById(id);
		
	}

	@Override
	public Ville save(Ville ville) {
		return villeRepository.save(ville);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}








	
/*
	@Autowired
	private VilleRepository villeRepository;
	
	
	public List<Ville> getAllVilles() {
	  // villeRepository.findById(id);
		return villeRepository.findAll();
		
	}
	
	
	 public Ville getVilleById(int id) {
		 return villeRepository.findById(id);
	    }
	 

	public Ville save(Ville ville) {
		return villeRepository.save(ville);
			
		}
	
	public void delete(int id) {
		villeRepository.deleteById(id);
		}
	
*/		
	


}
