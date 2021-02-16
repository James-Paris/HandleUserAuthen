package com.hcl.loginauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	@GetMapping("/")
	public String welcome(ModelMap map) {
		return "index";
	}
	
	@GetMapping("/login")
	public String displayLogin(ModelMap map) {
		return "login";
	}
	
	@PostMapping("/login") 
	public String performLogin(@RequestParam String username, @RequestParam String password) {
		return "validated";
	}
	
}
