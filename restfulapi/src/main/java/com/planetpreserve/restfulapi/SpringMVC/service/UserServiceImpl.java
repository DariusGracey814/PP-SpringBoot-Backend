package com.planetpreserve.restfulapi.SpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.planetpreserve.restfulapi.SpringMVC.dao.UserDao;
import com.planetpreserve.restfulapi.SpringMVC.entity.User;
import com.planetpreserve.restfulapi.exception.UserNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	// Retrieve User
	public Boolean retrieveUser(String username, String password) {
		Boolean results = dao.retrieveByUsername(username, password);
		
		if (results == null) {
			throw new UserNotFoundException("Error! no user with the username: " + username + " exists.");
		}
		
		return results;
		
	}
	
	// Add User
	public User addUser(User user) {
		User savedUser = dao.addUser(user);
		
		if (savedUser.getEmail() == "" || savedUser.getUsername() == "" || savedUser.getPassword() == "") {
			throw new UserNotFoundException("Error! Cannot add empty user add required fields");
		}
		
		return user;
	}
	
	
	// Delete User
	public User removeUser(int id) {
		User deletedUser = dao.deleteUser(id);
		
		if (deletedUser == null) {
			throw new UserNotFoundException("Error! no user with the id: " + id + " exists.");
		}
		
		return deletedUser;
	}

	public User getById(int id) {
		User foundUser = dao.getById(id);
		
		if (foundUser == null) {
			throw new UserNotFoundException("No user found with the id: " + id);
		}
		
		return foundUser;
	}

	public User getByUsername(String username) {
		
		User foundUser = dao.getByUsername(username);
		
		if (foundUser == null) {
			throw new UserNotFoundException("No user found with the username: " + username);
		}
		
		return foundUser;
	}
	
	
}
