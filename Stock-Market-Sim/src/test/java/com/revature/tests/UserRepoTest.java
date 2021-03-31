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
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class UserRepoTest {
	
	// class to be tested
		private UserServiceImpl userv;

		// dependencies that our service layer needs in order to make contact with DB
		private UserRepositoryImpl uRepo;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
		userv = new UserServiceImpl();
		
		// fake database connection & tricking service layer
		uRepo = mock(UserRepositoryImpl.class);
		
	}
	
	private UserRepositoryImpl userRepository;

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> ulist = new ArrayList<User>();
		when(uRepo.getAllUsers()).thenReturn(ulist);
		List<User> ulist2 = uRepo.getAllUsers();
		assertEquals(ulist, ulist2);
	}
	
	@Test
	public void getUserTest() {
		User u = new User();
		when(uRepo.getUser("Test")).thenReturn(u);
		User u2 = uRepo.getUser("Test");
		assertEquals(u, u2);
	}
}
