package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.Position;
import com.revature.models.User;

public class PositionTest {

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	@Test
	public void testPositionId() {
		Position pos = new Position();
		pos.setPositionId(1);
		assertEquals(1, pos.getPositionId());
}
	
	@Test
	public void testStockSymbol() {
		Position pos = new Position();
		pos.setStockSymbol("POS");
		assertEquals("POS", pos.getStockSymbol());
}
	
	@Test
	public void testQuantity() {
		Position pos = new Position();
		pos.setQuantity(1);
		assertEquals(1, pos.getQuantity());
}
	
}
