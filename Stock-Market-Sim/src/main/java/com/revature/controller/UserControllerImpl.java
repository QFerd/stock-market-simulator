package com.revature.controller;




import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.service.UserService;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
		userService.register(user);
		return (user.getUserId() != 0) ? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}

	@PostMapping("/login")
	public @ResponseBody User loginUser(@RequestBody User user, HttpServletRequest request) {
		request.getSession();
		return userService.getUser(user.getUsername());
	}
	
	@PostMapping("/userId")
	public @ResponseBody String getUserId(@RequestBody User user, HttpServletRequest request) {
		request.getSession();
		return userService.getUser(user.getUsername()).getUserRole();
	}
	

	@PostMapping("/setUser")
	public @ResponseBody ClientMessage setUser(@RequestBody User user, HttpServletRequest request) {
		userService.createOrUpdateUser(user);
		return  UPDATE_SUCCESFULL;
		
	}
	
	@GetMapping("/userList")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
