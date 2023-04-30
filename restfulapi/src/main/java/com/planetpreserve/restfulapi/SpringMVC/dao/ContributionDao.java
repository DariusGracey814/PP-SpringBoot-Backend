package com.planetpreserve.restfulapi.SpringMVC.dao;

import java.util.List;

import com.planetpreserve.restfulapi.SpringMVC.entity.Contribution;

public interface ContributionDao {
	Contribution addContribution(Contribution contribution);
	List<Contribution> getAllContributions();
	String deleteContribution(int contributionId);
	Contribution editContribution(Contribution contribution);
}
