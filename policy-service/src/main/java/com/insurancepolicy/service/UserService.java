package com.insurancepolicy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancepolicy.model.User;
import com.insurancepolicy.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User updateUser(User user) {
		User userDetails = userRepository.findById(user.getUserId()).orElse(null);
		if(userDetails!=null) {
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public List<User> deleteUser(int userId) {
		User userDetails = userRepository.findById(userId).orElse(null);
		if(userDetails!=null) {
			userRepository.delete(userDetails);
		}
		return userRepository.findAll();
	}

}
