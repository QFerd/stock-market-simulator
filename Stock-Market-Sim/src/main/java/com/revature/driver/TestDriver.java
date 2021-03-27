package com.revature.driver;



import java.time.LocalDate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repository.GameRepository;
import com.revature.repository.GameRepositoryImpl;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

public class TestDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
//	public static FoodRepo foodRepo = appContext.getBean("foodRepo", FoodRepo.class);
	
	public static UserRepository userRepo = appContext.getBean("userRepository", UserRepository.class);
	
	public static GameRepository gameRepo = appContext.getBean("gameRepository", GameRepository.class);
	
	public static void main(String[] args) {
		System.out.println(userRepo.getUser("JSmith"));
		
	}
	
	public static void insertInitialTeacher() {
		
		User u = new User("Teach", "tpw", "Teacher");
		userRepo.register(u);

		
	}
	
	public static void insertInitialGame() {
		

	}
	

}
