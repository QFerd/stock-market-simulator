package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void register(User user) {
		userRepository.register(user);
		logger.info(user.getUserId() != 0);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User getUser(String username) {
		return userRepository.getUser(username);
	}
	

}
