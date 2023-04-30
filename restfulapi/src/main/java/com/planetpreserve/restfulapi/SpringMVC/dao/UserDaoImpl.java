package com.planetpreserve.restfulapi.SpringMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.planetpreserve.restfulapi.SpringMVC.entity.User;
import com.planetpreserve.restfulapi.exception.UserNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PasswordEncoder encoder;
	
	// Add user
	public User addUser(User user) {
		// Hash valid password
		String hashedPassword = encoder.encode(user.getPassword());
		
		User registeredUser = new User(
				user.getId(),
				user.getUsername(),
				user.getEmail(),  
				hashedPassword);
		
		
		 entityManager.merge(registeredUser);
		 return registeredUser;
	}
	
	// Retrieve user 
	public Boolean retrieveByUsername(String username, String password) {
		// Find user
		String select = "SELECT u FROM users u WHERE u.username=:username";
		Query query = entityManager.createQuery(select);
		query.setParameter("username", username);
		
		// User with user name
		User user = (User) query.getSingleResult();
	
		// Check if entered login user password matches user in the database hashed password
		Boolean passwordMatches = encoder.matches(password, user.getPassword());
		
		// If user name and passwords matches return authenticated user
		return passwordMatches;
		
	}
	
	public User getById(int id) {
		System.out.println("ID: " + id);
		return entityManager.find(User.class, id);
	}

	public User getByUsername(String username) {
		String select = "SELECT u FROM users u WHERE u.username=:username";
		Query query = entityManager.createQuery(select);
		query.setParameter("username", username);
		
		// User with user name
		User user = (User) query.getSingleResult();
		return user;
	}
	
	// Delete User
	public User deleteUser(int id) {
	 // Find user
	 User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		return user;
	 }

}
