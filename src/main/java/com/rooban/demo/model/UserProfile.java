package com.rooban.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public UserProfile() {
	}

	public UserProfile(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}
	

}
