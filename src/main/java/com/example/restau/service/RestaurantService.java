package com.example.restau.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restau.dao.IDao;
import com.example.restau.dto.ReservationDto;
import com.example.restau.entities.Reservation;
import com.example.restau.entities.Restaurant;
import com.example.restau.entities.User;
import com.example.restau.repository.ReservationRepository;
import com.example.restau.repository.RestaurantRepository;
import com.example.restau.repository.UserRepository;





@Service
public class RestaurantService implements IDao<Restaurant> {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Restaurant findById(int id) {
		
		return  restaurantRepository.findById(id);
	}

	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
		
	}

	@Override
	public void update(Restaurant o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		restaurantRepository.deleteById(id);
		
		
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Reservation reserver(int idRestau, int idUser, ReservationDto reservation) {
		User foundUser = userRepository.findById(idUser);
		Restaurant foundRestaurant = restaurantRepository.findById(idRestau);
		Reservation reservationToSave = new Reservation();
		reservationToSave.setUser(foundUser);
		reservationToSave.setRestaurant(foundRestaurant);
		reservationToSave.setDateReservation(reservation.getDateReservation());
		reservationToSave.setRestaurant(foundRestaurant);
		return reservationRepository.save(reservationToSave);
		
	}
	
	public List<Reservation> mesReservations(int idUser) {
		User foundUser = userRepository.findById(idUser);
		return reservationRepository.findByUser(foundUser);
	}
	
	public void annulerReservation(int idReservation) {
		reservationRepository.deleteById(idReservation);
	}
	 

	


}
