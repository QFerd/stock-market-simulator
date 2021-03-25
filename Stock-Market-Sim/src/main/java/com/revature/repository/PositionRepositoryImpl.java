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
	public Position getPosition(User user, Game game, String stockSymbol) {
		Portfolio port = portfolioService.getPortfolio(user, game);
		try {
			return (Position) sessionFactory.getCurrentSession().createCriteria(Position.class).add(Restrictions.like("portfolio_id", port.getPortfolioId())).add(Restrictions.like("stock_symbol", stockSymbol))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getPositionsForUser(User user, Game game) {
		Portfolio port = portfolioService.getPortfolio(user, game);
		return (List<Position>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("portfolio_id", port.getPortfolioId()))
				.list(); //Unchecked cast to List<Position>.
	}
	
	@Override
	public void createOrUpdatePosition(Position position) {
		sessionFactory.getCurrentSession().saveOrUpdate(position);
	}
	
	
}
