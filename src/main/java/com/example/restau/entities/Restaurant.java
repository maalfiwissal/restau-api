package com.example.restau.entities;



import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity

public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String latitude;
	private String longitude;
	private String address;
	
	@ManyToMany
	private List<Specialite> specialites;
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Photo> photos;
	
	@Temporal(TemporalType.DATE)
	private Date close;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date open;
	
	@ManyToOne
	private Serie serie;

	
	public Restaurant(int id, String latitude, String longitude, String address, List<Specialite> specialites,
			List<Photo> photos, Date close, String nom, Date open, Serie serie, Zone zone, User user, int rank,
			String weekend) {
		
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.specialites = specialites;
		this.photos = photos;
		this.close = close;
		this.nom = nom;
		this.open = open;
		this.serie = serie;
		this.zone = zone;
		this.user = user;
		this.rank = rank;
		this.weekend = weekend;
	}
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	@JsonIgnore
	@ManyToOne
	private Zone zone;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	private int rank;
	

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getClose() {
		return close;
	}
	public void setClose(Date close) {
		this.close = close;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getOpen() {
		return open;
	}
	public void setOpen(Date open) {
		this.open = open;
	}
	public String getWeekend() {
		return weekend;
	}
	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	private String weekend;
	
	public List<Photo> getPhotos() {
		return photos;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	

	public List<Specialite> getSpecilites() {
		return specialites;
	}
	
	public void setRestaurents(List<Specialite> specialites) {
		this.specialites = specialites;
		}

	
}
