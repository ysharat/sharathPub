package com.sharath.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sharath.spring.io.entity.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	


	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);
	UserEntity findByUserName(String userName);
	
	

}
