package com.insurancepolicy.service;

import java.util.List;

import com.insurancepolicy.model.User;

public interface IUserService {

	List<User> getAllUsers();

	User addUser(User user);

	User getUser(int userId);

	User updateUser(User user);

	List<User> deleteUser(int userId);


}
