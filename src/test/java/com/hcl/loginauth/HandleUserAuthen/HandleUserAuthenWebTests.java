package com.hcl.loginauth.HandleUserAuthen;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.loginauth.controllers.LoginController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HandleUserAuthenWebTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private LoginController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void grabDefaultMessage() throws Exception {
		//System.out.println("PING - PONG");
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void grabLogin() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}

}
