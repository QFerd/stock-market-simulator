package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;
import com.revature.models.User;

@Repository("gameRepository")
@Transactional
public class GameRepositoryImpl implements GameRepository {
	
	private static Logger logger = Logger.getLogger(GameRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GameRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public int createGame(Game game) {
		logger.info("Attempting to create game from GameRepository.");
		return (int) sessionFactory.getCurrentSession().save(game);
		
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Game getGame(int gameId) {
		logger.info("Attempting to get game from GameRepository.");
		try {
			return (Game) sessionFactory.getCurrentSession().createCriteria(Game.class).add(Restrictions.like("gameId", gameId));
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

	public void updateGame(Game game) {
		logger.info("Attempting to update game from GameRepository.");
		sessionFactory.getCurrentSession().update(game);
		
	}
	
	}
