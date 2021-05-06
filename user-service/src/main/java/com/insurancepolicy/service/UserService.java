package com.insurancepolicy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancepolicy.controller.UserController;
import com.insurancepolicy.exception.NotFoundException;
import com.insurancepolicy.model.User;
import com.insurancepolicy.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Override
	public List<User> getAllUsers() {
		logger.info("All Users returned from User Service");
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		if((userRepository.findByEmail(user.getEmail()))!=null){
			throw new NotFoundException("Account already exist");
		}
		logger.info("Added user from User Service");
		return userRepository.save(user);
	}

	@Override
	public User getUser(int userId) {
		logger.info("Returned  user from User Service");
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User updateUser(User user) {
		User userDetails = userRepository.findById(user.getUserId()).orElse(null);
		if(userDetails!=null) {
			userRepository.save(user);
		}
		logger.info("Updated user from User Service");
		return user;
	}

	@Override
	public List<User> deleteUser(int userId) {
		User userDetails = userRepository.findById(userId).orElse(null);
		if(userDetails!=null) {
			userRepository.delete(userDetails);
		}
		logger.info("Deleted user from User Service");
		return userRepository.findAll();
	}
	@Override
	public boolean loginUser(String email, String password) {
		boolean flag = false;
		User user = userRepository.findByEmail(email);
		if(user!=null && user.getPassword().equals(password)) {
				flag = true;			
		}
		logger.info("Login Returned from User Service");
		return flag;
	}
	@Override
	public User getUserByEmail(String email) {
		logger.info("Returned User by email from User Service");
		return userRepository.findByEmail(email);
	}

}
