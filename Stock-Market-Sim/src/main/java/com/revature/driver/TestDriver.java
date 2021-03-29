package com.revature.driver;



import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.Position;
import com.revature.models.User;
import com.revature.repository.GameRepository;
import com.revature.repository.UserRepository;



public class TestDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
//	public static FoodRepo foodRepo = appContext.getBean("foodRepo", FoodRepo.class);
	
	public static UserRepository userRepo = appContext.getBean("userRepository", UserRepository.class);
	
	public static GameRepository gameRepo = appContext.getBean("gameRepository", GameRepository.class);
	
	public static void main(String[] args) {
		System.out.println(insertGame());
		System.out.println("working");
	}
	
	public static void insertUser() {
		

		Position pos1 = new Position("abc", 1);
		List<Position> positionList = new ArrayList<Position>();
		positionList.add(pos1);
		Portfolio p = new Portfolio(3,3,3, positionList);
		User u = new User("Teach", "tpw", "Teacher", p);
		
		 userRepo.register(u);

		
	}
	
	public static int insertGame() {
		
		Game g = new Game("2005-04-01", 1);
		return gameRepo.createGame(g);
	}
	
	public static void updateGame() {
		
		Game g = new Game(2, "2000-01-01", 2);
		gameRepo.updateGame(g);
	}

}
