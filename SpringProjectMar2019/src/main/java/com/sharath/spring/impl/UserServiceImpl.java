package com.sharath.spring.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sharath.spring.UserRepository;
import com.sharath.spring.io.entity.ProfileEntity;
import com.sharath.spring.io.entity.UserEntity;
import com.sharath.spring.shared.Utils;
import com.sharath.spring.shared.dto.AddressDTO;
import com.sharath.spring.shared.dto.ProfileDTO;
import com.sharath.spring.shared.dto.UserDto;
import com.sharath.spring.ui.model.response.UserRest;
import com.sharath.spring.ws.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto user) {

		UserEntity storedUserDetails1 = userRepository.findByEmail(user.getEmail());

		if (storedUserDetails1 != null)
			throw new RuntimeException("record already exist");
		//
		if(user.getAddresses().size()>0) {
		for (int i = 0; i < user.getAddresses().size(); i++) {
			AddressDTO address = user.getAddresses().get(i);
			address.setUserDetails(user);
			address.setAddressId(utils.generateAddressId(30));
			user.getAddresses().set(i, address);
		}
		}

		ProfileDTO profiledto = user.getProfile();
		profiledto.setProfilesId(utils.generateProfileId(30));
		// user.getProfile().setProfilesId(utils.generateProfileId(30));
		// profiledto.setUserDetails(user);

		user.setProfile(profiledto);
		profiledto.setUserDetails(user);
		

		// UserEntity userEntity = new UserEntity();
		// BeanUtils.copyProperties(user, userEntity);
		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);

		userEntity.setEncryptedPassword("test");
		String publicUserID = utils.generateRandomString(30);
		userEntity.setUserId(publicUserID);
	
		
	

		UserEntity storedUserDetails = userRepository.save(userEntity);

		// UserDto retrunValue = new UserDto();
		// BeanUtils.copyProperties(storedUserDetails, retrunValue);
		UserDto retrunValue = modelMapper.map(storedUserDetails, UserDto.class);

		return retrunValue;
	}

	@Override
	public UserDto getUserByUserID(String userId) {
		UserDto retrunValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		BeanUtils.copyProperties(userEntity, retrunValue);
		return retrunValue;
	}

	@Override
	public UserDto updateUser(String userName, UserDto user) {
		UserDto retrunValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserName(userName);
		if (userEntity == null)
			throw new UsernameNotFoundException(userName);

		if (user.getFname() != null) {
			userEntity.setFname(user.getFname());
		} else if (user.getLname() != null) {
			userEntity.setLname(user.getLname());
		}

		UserEntity updatedUserDetails = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetails, retrunValue);
		return retrunValue;
	}

	@Override
	public UserDto getUserByUserNAME(String userName) {
		UserDto retrunValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserName(userName);
		if (userEntity == null)
			throw new UsernameNotFoundException(userName);

		BeanUtils.copyProperties(userEntity, retrunValue);
		return retrunValue;
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {

		List<UserDto> returnValue = new ArrayList<>();
		// PageRequest p=new PageRequest(page, limit);
		// Pageable p1=p;

		Page<UserEntity> usersPage = userRepository.findAll(new PageRequest(page, limit));
		List<UserEntity> users = usersPage.getContent();

		for (UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			returnValue.add(userDto);
		}

		return returnValue;
	}

}
