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
		logger.info("Attempting to add new portfolio to DB.");
		sessionFactory.getCurrentSession().save(portfolio);
	}

	@Override
	public double getTotalValue(User user, Game game) {
		return getStockValue(user, game) + getCashValue(user, game);
	}

	@Override
	public double getStockValue(User user, Game game) {
		Portfolio port = getPortfolio(user, game);
		port.getStockValue();
		return 0;
	}

	@Override
	public double getCashValue(User user, Game game) {
		Portfolio port = getPortfolio(user, game);	
		port.getCashValue();
		return 0;
	}

	@Override
	public Portfolio getPortfolio(User user, Game game) {
		try {
			int uid = user.getUserId();
			int gid = game.getGameId();
			return (Portfolio) sessionFactory.getCurrentSession().createCriteria(Portfolio.class).add(Restrictions.like("player_id", uid)).add(Restrictions.like("game_id", gid)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

}
