package com.revature.repository;

import java.util.List;

import com.revature.models.User;

public interface UserRepository {
	
	
	void register(User user);
	
	List<User> getAllUsers();
	
	//List<User> getUserByClassroom();
	
	User getUser(String username);
}
