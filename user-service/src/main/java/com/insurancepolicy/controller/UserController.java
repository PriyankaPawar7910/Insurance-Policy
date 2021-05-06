package com.insurancepolicy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurancepolicy.model.User;
import com.insurancepolicy.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		logger.info("All Users returned from User Controller");
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		logger.info("Added user from User Controller");
		return userService.addUser(user);
	}
	@GetMapping("/login/{email}/{pwd}")
	public boolean loginUser(@PathVariable("email") String email,@PathVariable("pwd") String password) {
		logger.info("Login Returned from User Controller");
		return userService.loginUser(email,password);
	}
	@GetMapping("/getUserByEmail/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		logger.info("Returned User by email from User Controller");
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int userId) {
		logger.info("Returned  user from User Controller");
		return userService.getUser(userId);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		logger.info("Updated user from User Controller");
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<User> deleteUser(@PathVariable("id") int userId){
		logger.info("Deleted user from User Controller");
		return userService.deleteUser(userId);
	}

}
