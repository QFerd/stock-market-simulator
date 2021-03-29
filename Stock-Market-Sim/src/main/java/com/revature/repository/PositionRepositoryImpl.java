package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.Position;
import com.revature.models.User;
import com.revature.service.PortfolioService;

@Repository("positionRepository")
@Transactional
public class PositionRepositoryImpl implements PositionRepository{
	private static Logger logger = Logger.getLogger(PositionRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private PortfolioService portfolioService;
	
	public PositionRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
	

	
	@Override
	public void createOrUpdatePosition(Position position) {
		logger.info("Attempting to create or update position with PositionRepository.");
		sessionFactory.getCurrentSession().saveOrUpdate(position);
	}
	
	
}
