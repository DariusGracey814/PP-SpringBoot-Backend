package com.planetpreserve.restfulapi.SpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planetpreserve.restfulapi.SpringMVC.entity.User;
import com.planetpreserve.restfulapi.SpringMVC.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	
	// Find user attempting to login make sure it is a authenticated user
	@GetMapping(path = "/planet-preserve/login-check=authentication/{username}/{password}")
	public Boolean getUser(@PathVariable String username, @PathVariable String password) {
		return userService.retrieveUser(username, password);
	}
	
	@GetMapping(path = "/planet-preserve/get-user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getById(id);
	}

	// Add registering user with hashed password
	@PostMapping(path = "/planet-preserve/signup")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	
	@DeleteMapping(path = "/planet/users/{id}")
	public User deleteUser(@PathVariable int id) {
		return userService.removeUser(id);
	}
	
}
