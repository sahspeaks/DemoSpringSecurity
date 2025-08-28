package com.abhishek.DemoSpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		return "Home Page"+request.getSession().getId();
	}

	@GetMapping("/user")
	public String user() {
		return "Welcome to the user page!";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Welcome to the admin page!";
	}
}
