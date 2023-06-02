package com.example.restau.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restau.entities.Ville;


public interface VilleRepository extends JpaRepository<Ville, Integer> {
	//Ville findById(int id);
	Ville findById(int id);
	
	Ville findByNom(String ville);
	
}