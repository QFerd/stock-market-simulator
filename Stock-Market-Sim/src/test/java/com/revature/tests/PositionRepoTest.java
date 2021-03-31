package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.revature.models.Position;
import com.revature.repository.PositionRepositoryImpl;
import com.revature.service.PositionServiceImpl;

public class PositionRepoTest {
	
	// class to be tested
		private PositionServiceImpl posServ;

		// dependencies that our service layer needs in order to make contact with DB
		private PositionRepositoryImpl posRepo;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
		posServ = new PositionServiceImpl();
		
		// fake database connection & tricking service layer
		posRepo = mock(PositionRepositoryImpl.class);
		
	}
	
	private PositionRepositoryImpl positionRepository;

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
}
