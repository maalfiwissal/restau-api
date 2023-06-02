package com.example.restau.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restau.entities.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
	User findByEmail(String email);

}
