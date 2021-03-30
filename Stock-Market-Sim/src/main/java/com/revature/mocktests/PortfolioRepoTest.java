package com.revature.mocktests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class PortfolioRepoTest {
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void newPortfolioValid() {
		
	}
	
	@Test
	public void newPortfolioInvalid() {
		
	}
	
	@Test
	public void newPortfolioEmpty() {
		
	}
	
	/*
	 * @Override
	public void newPortfolio(Portfolio portfolio) {
		logger.info("Attempting to add new portfolio to DB with PortfolioRepository.");
		sessionFactory.getCurrentSession().save(portfolio);
	}
	 */
	
	/*
	 * public Portfolio(int portfolioId, double totalValue, double stockValue, double cashValue, List<Position> positionList) {
		super();
		this.portfolio_Id = portfolioId;
		this.totalValue = totalValue;
		this.stockValue = stockValue;
		this.cashValue = cashValue;
		this.positionList = positionList;
	}
	 */

}
