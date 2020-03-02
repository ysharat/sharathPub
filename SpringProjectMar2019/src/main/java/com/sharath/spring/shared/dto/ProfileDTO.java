package com.sharath.spring.shared.dto;

public class ProfileDTO {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfilesId() {
		return profilesId;
	}
	public void setProfilesId(String profilesId) {
		this.profilesId = profilesId;
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
	public UserDto getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}
	private long id;
	private String profilesId;
	private String age;
	private String gender;
	private UserDto userDetails;

	
}
