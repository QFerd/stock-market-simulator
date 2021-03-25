package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.repository.GameRepository;

import jdk.internal.org.jline.utils.Log;

@Service("gameService")
public class GameServiceImpl implements GameService{
	
	private static Logger logger = Logger.getLogger(GameServiceImpl.class);

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public void createOrUpdateGame(Game game) {
		Log.info("Attempting to create or update a game.");
		gameRepository.createOrUpdateGame(game);
		
	}

	@Override
	public Game getGameState() {
		try {
		return gameRepository.getGameState();
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
	}

}
