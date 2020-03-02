package com.sharath.spring.ws.service;

import java.util.List;

import com.sharath.spring.shared.dto.UserDto;
import com.sharath.spring.ui.model.response.UserRest;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getUserByUserID(String userId);
	UserDto getUserByUserNAME(String userName);
	UserDto updateUser(String userName,UserDto user);
	List<UserDto> getUsers(int page,int limit);
	
	
	
	
	//UserDto getUserbyEmail(String email);

}
