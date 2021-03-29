package com.revature.repository;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;

@Repository("portfolioRepository")
@Transactional
public class PortfolioRepositoryImpl implements PortfolioRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public PortfolioRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void newPortfolio(Portfolio portfolio) {
		logger.info("Attempting to add new portfolio to DB with PortfolioRepository.");
		sessionFactory.getCurrentSession().save(portfolio);
	}


}
