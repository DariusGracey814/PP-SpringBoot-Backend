package com.planetpreserve.restfulapi.SpringMVC.service;

import com.planetpreserve.restfulapi.SpringMVC.entity.User;

public interface UserService {
	Boolean retrieveUser(String username, String password);
	User addUser(User user);
	User removeUser(int id);
}
