package com.example.restau.dao;

import java.util.List;

import com.example.restau.dto.ReservationDto;
import com.example.restau.entities.Reservation;

public interface IDao<T> {
   T findById(int id);
   List<T> findAll();
   void update (T o);
  // void delete(T o);
   void delete(int id);
   T save(T o);
   long count();
  // Reservation reserver(int idRestau, int idUser, ReservationDto reservation);

   
}
