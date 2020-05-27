package com.discovery.app.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.discovery.app.user.data.entity.UserEntity;

public interface UsersRepositoty extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
	
}
