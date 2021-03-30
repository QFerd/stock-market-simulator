package com.revature.mocktests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class UserRepoTest {
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSuiteTest() { //A test of the JUnit Testing Suite.
		assertEquals("This is a test.", "This is a test.");
	}
	
	/*
	 * @Override
	public void register(User user) {
		logger.info("Attempting to register user from UserRepository.");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("Attempting to list all users from UserRepository.");
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(String username) {
		try {
			logger.info("Attempting to get user from UserRepository.");
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}	

	}
	

	
	@Override
	public void createOrUpdateUser(User user) {
		logger.info("Attempting to create or update user from UserRepository.");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	 * 
	 * 
	 * 
	 * 	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;

	}
	

	public User(String username, String password, String userRole, Portfolio portfolio) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.portfolio = portfolio;
	}


	public User(String username, String password, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}



	public User(String username, String password, String userRole, Game game) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.game = game;
	}


	public User(int userId, String username, String password, String userRole, Portfolio portfolio) {

		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.portfolio = portfolio;
	}
	 */

}
