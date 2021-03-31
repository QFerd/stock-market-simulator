package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;
import com.revature.repository.PortfolioRepositoryImpl;
import com.revature.service.PortfolioServiceImpl;

public class PortfolioRepoTest {
	
	// class to be tested
		private PortfolioServiceImpl portServ;

		// dependencies that our service layer needs in order to make contact with DB
		private PortfolioRepositoryImpl portRepo;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
		portServ = new PortfolioServiceImpl();
		
		// fake database connection & tricking service layer
		portRepo = mock(PortfolioRepositoryImpl.class);
		
	}
	
	private PortfolioRepositoryImpl portRepository;

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}

}
