package com.planetpreserve.restfulapi.SpringMVC.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contributions")
public class Contribution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contribution_id")
	private int contributionId;
	
	@Column(name="contribution_type")
	private String type;
	
	@Column(name="contribution_desc")
	private String description;
	
	@Column(name="contribution_date")
	private Long timestamp;
	
	@Column(name="latitude")
	private Double latitude;
	
	@Column(name="longitude")
	private Double longitude;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	public int getContributionId() {
		return contributionId;
	}
	
	protected Contribution() {
		
	}

	public Contribution(int contributionId, String type, String description, Long timestamp, Double latitude,
			Double longitude, User user) {
		super();
		this.contributionId = contributionId;
		this.type = type;
		this.description = description;
		this.timestamp = timestamp;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
	}

	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setContributionId(int contributionId) {
		this.contributionId = contributionId;
	}

	@Override
	public String toString() {
		return "Contribution [contributionId=" + contributionId + ", type=" + type + ", description=" + description
				+ ", timestamp=" + timestamp + ", latitude=" + latitude + ", longitude=" + longitude + ", user=" + user
				+ "]";
	}
	
}
