package com.sharath.spring.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharath.exceptions.AppExceptionsHandler;
import com.sharath.exceptions.UserServiceException;
import com.sharath.spring.shared.dto.UserDto;
import com.sharath.spring.ui.model.request.UserDetailRequestModel;
import com.sharath.spring.ui.model.response.ErrorMessages;
import com.sharath.spring.ui.model.response.UserRest;
import com.sharath.spring.ws.service.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest getUsers(@PathVariable String userName) {

		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserNAME(userName);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}

	@PostMapping(

			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) throws Exception {
		UserRest returnValue = new UserRest();
		if (userDetails.getFname().isEmpty()) {

			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		}

		System.out.println("here1");
		// UserDto userDto=new UserDto();
		// BeanUtils.copyProperties(userDetails, userDto);

		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		// UserDto createdUser=userService.createUser(userDto);
		// BeanUtils.copyProperties(createdUser, returnValue);

		UserDto createdUser = userService.createUser(userDto);
		returnValue = modelMapper.map(createdUser, UserRest.class);

		return returnValue;

	}

	@PutMapping(path = "/{userName}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userName, @RequestBody UserDetailRequestModel userDetails) {

		UserRest retrunValue = new UserRest();
		System.out.println("here1");
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		// ModelMapper modelMapper = new ModelMapper();
		// if(userDto.getEmail()
		// UserDto createdUser=userService.createUser(userDto);
		// BeanUtils.copyProperties(createdUser, retrunValue);

		UserDto updatedUser = userService.updateUser(userName, userDto);
		BeanUtils.copyProperties(updatedUser, retrunValue);
		return retrunValue;
	}

	@DeleteMapping
	public String deleteUser() {

		return "for delete";
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {

		List<UserRest> retrunValue = new ArrayList();
		List<UserDto> users = userService.getUsers(page, limit);

		for (UserDto userDto : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			retrunValue.add(userModel);

		}

		return retrunValue;

	}
}
