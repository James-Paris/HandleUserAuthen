package com.hcl.loginauth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.loginauth.models.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	public UserEntity findByName(String name);
	public UserEntity findByEmail(String email);
	public boolean existsByEmailAndPassword(String email, String password);
	
}
