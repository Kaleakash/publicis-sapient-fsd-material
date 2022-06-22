package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.beans.User;
import com.example.model.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class MyRestApi {

	// auto-inject service 
	@Autowired
	private UserServiceImpl service;
	
	// storing the user
	@PostMapping
	public User store(@RequestBody User user) {
		User createdUser = service.storeUser(user);
		return createdUser;
	}
	// fetching all the users
	@GetMapping
	public List<User> fetchUsers() {
		return service.getAllUsers();
	}
}
