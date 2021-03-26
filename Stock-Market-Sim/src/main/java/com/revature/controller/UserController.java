package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.models.User;

public interface UserController {
	ClientMessage registerUser(User user);
	
	User loginUser(User user, HttpServletRequest request);
}
