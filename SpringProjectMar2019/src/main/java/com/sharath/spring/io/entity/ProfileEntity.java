package com.sharath.spring.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="profile")
public class ProfileEntity implements Serializable {

	private static final long serialVersionUID = 7809200551672852690L;
	
	@Id
	@GeneratedValue
	private long id;
	
	
	private String profileId;
	
	
	private String age;
	

	private String gender;
	
	
	
	@OneToOne
	@JoinColumn(name="users_id")
	private UserEntity userDetails;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public UserEntity getUserDetails() {
		return userDetails;
	}



	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}



	public String getProfileId() {
		return profileId;
	}



	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}










	



	
	

}
