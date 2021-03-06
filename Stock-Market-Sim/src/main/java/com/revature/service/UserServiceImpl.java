package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repository.UserRepository;

import jdk.internal.org.jline.utils.Log;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void register(User user) {
		logger.info("Attempting to register user with UserService.");
		userRepository.register(user);
		logger.info(user.getUserId() != 0);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Attempting to register user with UserService.");
		return userRepository.getAllUsers();
	}

	@Override
	public User getUser(String username) {
		logger.info("Attempting to get user with UserService.");
		return userRepository.getUser(username);
	}
	
	@Override
	public void createOrUpdateUser(User user) {
		logger.info("Attempting to create or update a user with UserService.");
		userRepository.createOrUpdateUser(user);
		
	}
	
}
