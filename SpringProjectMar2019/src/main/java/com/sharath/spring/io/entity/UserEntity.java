package com.sharath.spring.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sharath.spring.ui.model.request.Profile;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 4686612407920092585L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;
	
	@Column(nullable=false, length=50)
	private String fname;
	
	@Column(nullable=false, length=50)
	private String userName;
	
	@Column(nullable=false, length=50)
	private String lname;
	
	@Column(nullable=false, length=100, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	private String encryptedPassword;
	private String emailVerficationToken;
	
	@Column(nullable=false)
	private Boolean emailVerfiationStatus=false;
	
	@OneToMany(mappedBy="userDetails", cascade=CascadeType.ALL)
	private List<AddressEntity> addresses;
	
	@OneToOne(cascade =  CascadeType.ALL,mappedBy="userDetails")
	private ProfileEntity profile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerficationToken() {
		return emailVerficationToken;
	}

	public void setEmailVerficationToken(String emailVerficationToken) {
		this.emailVerficationToken = emailVerficationToken;
	}

	public Boolean getEmailVerfiationStatus() {
		return emailVerfiationStatus;
	}

	public void setEmailVerfiationStatus(Boolean emailVerfiationStatus) {
		this.emailVerfiationStatus = emailVerfiationStatus;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}






}