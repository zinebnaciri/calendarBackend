package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	
	
	  @GetMapping("/find/{username}")
	  public Optional<User> findByMatricule(@PathVariable String username) {
		  Optional<User> user = userRepository.findByUsername(username);
		return user;
	}
}
