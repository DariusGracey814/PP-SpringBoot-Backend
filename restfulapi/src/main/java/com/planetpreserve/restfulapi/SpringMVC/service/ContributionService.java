package com.planetpreserve.restfulapi.SpringMVC.service;

import java.util.List;

import com.planetpreserve.restfulapi.SpringMVC.entity.Contribution;

public interface ContributionService {
	Contribution addContribution(Contribution contribution);
	Contribution editContribution(Contribution contribution);
	List<Contribution> getAllContributions();
	void deleteContribution(int contributionId);
}
