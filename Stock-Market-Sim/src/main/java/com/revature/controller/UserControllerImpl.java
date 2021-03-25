package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.revature.util.ClientMessageUtil.*;

import com.revature.ajax.ClientMessage;
import com.revature.models.User;
import com.revature.service.UserService;

@Controller("userController")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
		userService.register(user);
		return (user.getUserId() != 0) ? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}

}
