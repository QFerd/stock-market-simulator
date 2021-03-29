package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.Game;
import com.revature.models.User;

public class GameTest {

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void testGameId() {
		Game game = new Game();
		game.setGameId(1);
		assertEquals(1, game.getGameId());
}
	
	@Test
	public void testStartDate() {
		Game game = new Game();
		game.setStartDate("January 1st, 2000");
		assertEquals("January 1st, 2000", game.getStartDate());
	}
	
	@Test
	public void testPhase() {
		Game game = new Game();
		game.setPhase(1);
		assertEquals(1, game.getPhase());
	}
	
	@Test
	public void testUserList() {
		Game game = new Game();
		User u = new User();
		List<User> ulist = new ArrayList<User>();
		game.setUserList(ulist);
		assertEquals(ulist, game.getUserList());
	}

}
