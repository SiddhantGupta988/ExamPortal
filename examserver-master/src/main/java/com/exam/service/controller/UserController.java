package com.exam.service.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/test")
	public String test(){
		return "Welcome to backend api";
	}
	@PostMapping("/")
	public User createUser(@RequestBody User user)
	{

		Role r1 = new Role();
		r1.setRole_id(45L);
		r1.setRole("Normal");

		user.setPassword(this.passwordEncoder.encode((user.getPassword())));
		UserRole user_role = new UserRole();

		user_role.setUser(user);
		user_role.setRole(r1);
		Set<UserRole> user_role_set = new HashSet<>();
		user_role_set.add(user_role);
		return this.userservice.createUser(user, user_role_set);
		
		
		
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username ) {
		
		return this.userservice.findUser(username);
	}
	
}
