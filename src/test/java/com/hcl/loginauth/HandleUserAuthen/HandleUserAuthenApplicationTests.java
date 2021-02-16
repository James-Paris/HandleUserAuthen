package com.hcl.loginauth.HandleUserAuthen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.hcl.loginauth.models.UserEntity;
import com.hcl.loginauth.services.LoginService;

@DataJpaTest
public class HandleUserAuthenApplicationTests {
	
	@Autowired
	LoginService service;
	
	@TestConfiguration
	static class HandleUserAuthenApplicationTestsConfiguration {
		@Bean
		public LoginService loginService() {
			return new LoginService();
		}
		
	}
	
	@Test
	public void addingNulledUser() {
		UserEntity user = new UserEntity();
		user = null;
		
		boolean isAdded = service.AddUser(user);
		
		//assert false, since we know it should be false
		assertFalse(isAdded);
		
	}
	
	@Test
	public void addingNormalUser() {
		UserEntity user = new UserEntity();
		user.setName("Lorem");
		user.setEmail("ipsum@fake.com");
		user.setPassword("123");
		
		//adding user action attempt
		boolean isAdded = service.AddUser(user);
		
		//we want it to be: (true)
		assertTrue(isAdded);
	}
	
	@Test
	public void attemptGoodLogin() {
		UserEntity user = new UserEntity();
		user.setName("Lorem");
		user.setEmail("ipsum@fake.com");
		user.setPassword("123");
		
		boolean isAllowed = service.AuthenticateUser(user, "123");
		
		assertTrue(isAllowed);
	}
	
	@Test
	public void attemptBadLogin() {
		UserEntity user = new UserEntity();
		user.setName("Lorem");
		user.setEmail("ipsum@fake.com");
		user.setPassword("123");
		
		boolean isAllowed = service.AuthenticateUser(user, "clearlywrongpassword");
		
		assertFalse(isAllowed);
		
	}
	
	@Test
	public void loginFromUserAndPassDB() {
		UserEntity newUser = new UserEntity();
		
		newUser.setName("john");
		newUser.setEmail("john@fake.com");
		newUser.setPassword("passw0rd");
		
		service.AddUser(newUser);
		
		UserEntity scanUsers = service.GetUserByName("john");
		
		assertEquals(newUser.getName(), scanUsers.getName());
		assertEquals(newUser.getPassword(), scanUsers.getPassword());
	}


}
