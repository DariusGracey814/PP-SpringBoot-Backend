package com.planetpreserve.restfulapi.SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetpreserve.restfulapi.SpringMVC.dao.ContributionDao;
import com.planetpreserve.restfulapi.SpringMVC.entity.Contribution;

import jakarta.transaction.Transactional;

@Service
public class ContributionServiceImpl implements ContributionService {
	
	@Autowired
	private ContributionDao dao;
	
	@Override
	@Transactional
	public Contribution addContribution(Contribution contribution) {
		if (contribution == null) {
			throw new Error("Contribution object is null");
		}
		
		return dao.addContribution(contribution);
	}

	@Override
	@Transactional
	public List<Contribution> getAllContributions() {
		
		List<Contribution> contributions = dao.getAllContributions();
		
		if (contributions == null) {
			throw new Error("No contributions found...");
		}
		
		return dao.getAllContributions();
	}

	@Override
	@Transactional
	public void deleteContribution(int contributionId) {
		dao.deleteContribution(contributionId);
	}

	@Override
	@Transactional
	public Contribution editContribution(Contribution contribution) {
		return dao.editContribution(contribution);
	}

	
	

}
