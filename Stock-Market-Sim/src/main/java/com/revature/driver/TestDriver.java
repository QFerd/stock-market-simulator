package com.revature.driver;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repository.UserRepositoryImpl;

public class TestDriver {
	public static void main(String[] args) {
		User u = new User("Teach", "tpw", new UserRole(1));
		UserRepositoryImpl userRepo = new UserRepositoryImpl();
		userRepo.register(u);
	}
}
