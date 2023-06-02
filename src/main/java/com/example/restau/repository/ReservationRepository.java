package com.example.restau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restau.entities.Reservation;
import com.example.restau.entities.User;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByUser(User user);
}
