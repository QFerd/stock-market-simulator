package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.models.User;

public interface UserController {
	public ClientMessage registerUser(User user);
	
	public User loginUser(User user, HttpServletRequest request);
	
	public void setUser(User user, HttpServletRequest request);
	
	public List<User> getAllUsers();
}
