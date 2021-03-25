package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;

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
	public void createOrUpdateGame(Game game) {
		sessionFactory.getCurrentSession().saveOrUpdate(game);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public Game getGameState() {
	
		try {
			List<Game> gameList = (List<Game>) sessionFactory.getCurrentSession().createCriteria(Game.class).list();
			logger.info("GameRepositoryImpl: Retrieved game list:" + gameList);
			return (Game) sessionFactory.getCurrentSession().createCriteria(Game.class).list().get(gameList.size() - 1);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}
	}
