package com.sharath.model;

import java.util.ArrayList;

public class Pledge {
private long id;
private String name;
private String statement;
private ArrayList<String> hobies=new ArrayList<String>();
private ArrayList<Users> users;
private Users user= new Users();







public void setUser(Users user) {
	this.user = user;
}



public Pledge() {
	
this.users=new ArrayList<Users>();
}



public ArrayList<Users> getUsers() {
	return users;
}



public void setUsers(ArrayList<Users> users) {
	this.users = users;
}



public ArrayList<String> getHobies() {
	return hobies;
}

public void setHobies(ArrayList<String> hobies) {
	this.hobies = hobies;
}

public Pledge(long id, String name, String statement) {

	this.id = id;
	this.name = name;
	this.statement = statement;
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	
	this.id = id;
	
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStatement() {
	return statement;
}
public void setStatement(String statement) {
	this.statement = statement;
}



}
