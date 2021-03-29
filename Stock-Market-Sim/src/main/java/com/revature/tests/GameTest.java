package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;

public class GameTest {

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void testUserId() {
		User u = new User();
		u.setUserId(1);
		assertEquals(1, u.getUserId());
}

	@Test
	public void testUsername() {
		User u = new User();
		u.setUsername("JTest");
		assertEquals("JTest", u.getUsername());
	}
	
	@Test
	public void testPassword() {
		User u = new User();
		u.setPassword("Testpass");
		assertEquals("Testpass", u.getPassword());
	}
	
	@Test
	public void testUserRole() { //1st UserRole test.
		User u = new User();
		u.setUserRole("Student");
		assertEquals("Student", u.getUserRole());
	}
	
	@Test
	public void testPortfolio() { //1st Portfolio test.
		User u = new User();
		Portfolio port = new Portfolio();
		u.setPortfolio(port);
		assertEquals(port, u.getPortfolio());
	}
	
	@Test
	public void testGame() { //1st Game test.
		User u = new User();
		Game game = new Game();
		u.setGame(game);
		assertEquals(game, u.getGame());
	}
}