package com.planetpreserve.restfulapi.SpringMVC.service;

import com.planetpreserve.restfulapi.SpringMVC.entity.User;

public interface UserService {
	Boolean retrieveUser(String username, String password);
	User getByUsername(String username);
	User getById(int id);
	User addUser(User user);
	User removeUser(int id);
}
