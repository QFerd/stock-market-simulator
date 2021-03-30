package com.revature.mocktests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repository.GameRepositoryImpl;

//Consult this for reference! - https://github.com/210222-reston-java-msa/demos/blob/main/week2/EmployeeDBServlets/src/test/java/com/revature/tests/ServiceTests.java

public class GameRepoTest {
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	private GameRepositoryImpl gameRepository;

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void happyPathCreate() {
		List<User> ulist = new ArrayList<User>();
		Game game = new Game("01-01-2000", 0, ulist); //startDate, phase, userList.
		when(gameRepository.createGame(game)).thenReturn(10);
		
		
	}
	
	@Test
	public void badUserCreate() {
		
	}
	
	@Test
	public void emptyUserCreate() {
		
	}
	
	@Test
	public void getGameHappyPath() {
		
	}
	
	@Test
	public void getMalformedGame() {
		
	}
	
	@Test
	public void getEmptyGame() {
		
	}
	
	@Test
	public void updateGameTest() {
		
	}

	/*
	 * 
	 * public Game(String startDate, int phase, List<User> userList) {
		super();
		this.startDate = startDate;
		this.phase = phase;
		this.userList = userList;
	}
	 * 
	 * 
	@Override
	public int createGame(Game game) {
		logger.info("Attempting to create game from GameRepository.");
		return (int) sessionFactory.getCurrentSession().save(game);
		
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Game getGame(int gameId) {
		logger.info("Attempting to get game from GameRepository.");
		try {
			return (Game) sessionFactory.getCurrentSession().get(Game.class, gameId);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

	public void updateGame(Game game) {
		logger.info("Attempting to update game from GameRepository.");
		sessionFactory.getCurrentSession().update(game);
		
	}
	 */
}
