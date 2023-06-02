package com.example.restau.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class RestaurantDto {

	private String latitude;
	private String longitude;
	private String address;
	@Temporal(TemporalType.DATE)
	private Date close;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date open;
	@JsonIgnore	
	private int rank;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
