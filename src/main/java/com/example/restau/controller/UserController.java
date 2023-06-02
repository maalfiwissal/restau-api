package com.example.restau.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restau.dto.LoginDto;
import com.example.restau.entities.User;
import com.example.restau.repository.UserRepository;


@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {
@Autowired
	private UserRepository userRepository;
	
@PostMapping("login")
public User authenticate(@RequestBody LoginDto user) throws UnsupportedEncodingException {
	User foundUser = userRepository.findByEmail(user.getEmail());
	if(foundUser == null) {
		return null;
	}
	Base64.Decoder decoder = Base64.getDecoder();
	byte[] decodedPassword = decoder.decode(foundUser.getPassword());
	if(new String(decodedPassword, "UTF-8").equals(user.getPassword())) {
		return foundUser;
	}
	return null;
	
}
/*		@PostMapping("/save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}		
*/	
}
