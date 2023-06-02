package com.example.restau.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restau.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
	
	Specialite findByNom(String nom);
	
}