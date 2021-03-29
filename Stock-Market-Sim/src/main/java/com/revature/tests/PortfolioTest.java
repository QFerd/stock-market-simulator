package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.Portfolio;
import com.revature.models.Position;

public class PortfolioTest {

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void testPortfolioId() {
		Portfolio port = new Portfolio();
		port.setPortfolioId(1);
		assertEquals(1, port.getPortfolioId());
	}
	
	@Test
	public void testTotalValue() {
		Portfolio port = new Portfolio();
		port.setTotalValue(0);
		assertEquals(0, port.getTotalValue(), .1);
	}
	
	@Test
	public void testStockValue() {
		Portfolio port = new Portfolio();
		port.setStockValue(0);
		assertEquals(0, port.getStockValue(), .1);
	}
	
	@Test
	public void testCashValue() {
		Portfolio port = new Portfolio();
		port.setCashValue(0);
		assertEquals(0, port.getCashValue(), .1);
	}
	
	@Test
	public void testPositionList() {
		Portfolio port = new Portfolio();
		Position pos = new Position();
		List<Position> plist = new ArrayList<Position>();
		plist.add(pos);
		port.setPositionList(plist);
		assertEquals(plist, port.getPositionList());
	}

}
