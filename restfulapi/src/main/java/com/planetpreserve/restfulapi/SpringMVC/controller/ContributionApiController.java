package com.planetpreserve.restfulapi.SpringMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planetpreserve.restfulapi.SpringMVC.entity.Contribution;
import com.planetpreserve.restfulapi.SpringMVC.entity.User;
import com.planetpreserve.restfulapi.SpringMVC.service.ContributionService;
import com.planetpreserve.restfulapi.SpringMVC.service.UserService;
import com.planetpreserve.restfulapi.exception.UserNotFoundException;

@RestController
public class ContributionApiController {
	
	// Service
	@Autowired
	private ContributionService contributionService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/planet-preserve/all-contributions", method = RequestMethod.GET)
	List<Contribution> allContributions() {
		return contributionService.getAllContributions();
	}
	
	
	@GetMapping(path = "/planet-preserve/{username}/{authenticated}/get-contribution")
	List<Contribution> getContributions(@PathVariable String username, @PathVariable Boolean authenticated) {
		// Get current user by username
		User user = userService.getByUsername(username);
		
		// get that user contributions
		if (user == null || !authenticated) {
			throw new UserNotFoundException("No user was found with the username: " + username);
		}
		
		List<Contribution> contributions = user.getContributions();
		
		return contributions;
	}
	
	@PostMapping(path = "/planet-preserve/{username}/{authenticated}/add-contribution")
	String addUserContribution(@PathVariable String username, @PathVariable Boolean authenticated, @RequestBody Contribution contribution ) {
		System.out.println(contribution);
		
		
		// if user is authenticated -> logged in get current user id by (username)
		if (authenticated) {
			// Current user
			User user = (User) userService.getByUsername(username);
			
			// Only add if type - description - are not null
			if (contribution.getType() != null && contribution.getDescription() != null && contribution.getTimestamp() != null) {
				
				Contribution addedContribution = new Contribution(contribution.getContributionId(), contribution.getType(), 
						contribution.getDescription(), 
						contribution.getTimestamp(), contribution.getLatitude(), contribution.getLongitude(), user);

				contributionService.addContribution(addedContribution);
			}
			
		} else {
			throw new UserNotFoundException("No user was found with the username: " + username);
		}
		
		return "Successfully added user contribution";
		}
	
	
	
	@PatchMapping(path = "/planet-preserve/edit-contribution/{username}")
	public Contribution editContribution(@RequestBody Contribution contribution, @PathVariable String username) {
		User user = userService.getByUsername(username);
		
		if (user != null) {
			throw new UserNotFoundException("No user found with the username: " + username);
		}
		
		contributionService.editContribution(contribution);
		
		return contribution;
	}
	
	
	@DeleteMapping(path = "/planet-preserve/delete-contribution/{contributionId}")
	public void deletedContribution(@PathVariable int contributionId) {
		contributionService.deleteContribution(contributionId);
		System.out.println("Successfully deleted contribution");
	}

}



