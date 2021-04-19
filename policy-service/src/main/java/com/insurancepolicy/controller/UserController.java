package com.insurancepolicy.controller;

import java.util.List;

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
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<User> deleteUser(@PathVariable("id") int userId){
		return userService.deleteUser(userId);
	}

}
