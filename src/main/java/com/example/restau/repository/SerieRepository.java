package com.example.restau.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restau.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	
	Serie findByNom(String nom);
	
}