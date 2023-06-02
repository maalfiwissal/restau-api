package com.example.restau.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@JsonIgnore
	@ManyToOne
	private Ville ville;
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.EAGER)
	private List<Restaurant> restaurants;
	
	public Zone() {
		super();
		
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	


	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public List<Restaurant> getRestaurents() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public Ville getVille() {
		return ville;
				
		}
	
}
