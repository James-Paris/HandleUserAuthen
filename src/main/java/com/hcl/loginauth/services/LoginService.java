package com.hcl.loginauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.loginauth.models.UserEntity;
import com.hcl.loginauth.repositories.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean AddUser(UserEntity newUser) {
		if(newUser == null)
			return false;
		
		userRepository.save(newUser);
		return true;
	}
	
	public UserEntity GetUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public UserEntity GetUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public boolean AuthenticateByEmail(String email, String password) {
		return userRepository.existsByEmailAndPassword(email, password);
	}
	
	public boolean AuthenticateUser(UserEntity user, String passwordAttempt) {
		return user.getPassword().equals(passwordAttempt);
	}
	

}
