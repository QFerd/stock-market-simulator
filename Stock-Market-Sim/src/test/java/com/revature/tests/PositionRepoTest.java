package com.revature.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class PositionRepoTest {
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	/*
	 * 	@Override
	public void createOrUpdatePosition(Position position) {
		logger.info("Attempting to create or update position with PositionRepository.");
		sessionFactory.getCurrentSession().saveOrUpdate(position);
	}
	 */
	
	/* 
	 * public Position(int positionId, String stockSymbol, int quantity) {
		super();
		this.positionId = positionId;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
	}
	 */

}
