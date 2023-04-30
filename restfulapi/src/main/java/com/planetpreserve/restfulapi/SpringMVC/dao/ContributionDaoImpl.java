package com.planetpreserve.restfulapi.SpringMVC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.planetpreserve.restfulapi.SpringMVC.entity.Contribution;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class ContributionDaoImpl implements ContributionDao {
	
	@PersistenceContext
	private EntityManager entity;


	@Override
	public Contribution addContribution(Contribution contribution) {
		Contribution addedContribution = entity.merge(contribution);
		return addedContribution;
	}

	public List<Contribution> getAllContributions() {
		TypedQuery<Contribution> query = entity.createQuery("SELECT c FROM Contribution c", 
				Contribution.class);
		
		return query.getResultList();
	}

	public String deleteContribution(int contributionId) {
		// Find contributions
	    Contribution deleted = entity.find(Contribution.class, contributionId);
		entity.remove(deleted);
		return "Successfully deleted contribution";
	}

	@Override
	public Contribution editContribution(Contribution contribution) {
//		TypedQuery<Contribution> query = entity.createQuery("UPDATE c Contribution c WHERE c.user");
		return null;
	}
	
	

}
