package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repository.GameRepositoryImpl;
import com.revature.service.GameServiceImpl;

public class GameRepoTest {
	
	// class to be tested
		private GameServiceImpl gserv;

		// dependencies that our service layer needs in order to make contact with DB
		private GameRepositoryImpl gRepo;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
		gserv = new GameServiceImpl();
		
		// fake database connection & tricking service layer
		gRepo = mock(GameRepositoryImpl.class);
		
	}
	
	private GameRepositoryImpl gameRepository;

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void happyPathCreate() { //Create returns *int* from sessionFactory.getCurrentSession().save(game)
		List<User> ulist = new ArrayList<User>();
		Game game = new Game("01-01-2000", 0, ulist); //startDate, phase, userList.
		when(gRepo.createGame(game)).thenReturn(10);
		int rtn = gRepo.createGame(game);
		assertEquals(rtn, 10);
	}
	
	@Test
	public void getGameHappyPath() { //Returns game found by gameId.
		List<User> ulist = new ArrayList<User>();
		Game game = new Game("01-01-2000", 0, ulist); //startDate, phase, userList.
		when(gRepo.getGame(1)).thenReturn(game);
		Game g2 = gRepo.getGame(1);
		assertEquals(game, g2);
	}
}
