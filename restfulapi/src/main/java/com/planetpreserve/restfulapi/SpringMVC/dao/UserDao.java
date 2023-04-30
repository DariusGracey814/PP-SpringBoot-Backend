package com.planetpreserve.restfulapi.SpringMVC.dao;

import com.planetpreserve.restfulapi.SpringMVC.entity.User;

public interface UserDao {
	Boolean retrieveByUsername(String username, String password);
	User getByUsername(String username);
	User getById(int id);
	User addUser(User user);
	User deleteUser(int id);
}
