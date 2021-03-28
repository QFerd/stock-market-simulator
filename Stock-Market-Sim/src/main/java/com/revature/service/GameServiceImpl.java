package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repository.GameRepository;

import jdk.internal.org.jline.utils.Log;

@Service("gameService")
public class GameServiceImpl implements GameService{
	
	private static Logger logger = Logger.getLogger(GameServiceImpl.class);

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public int createGame(Game game) {
		Log.info("Attempting to create or update a game.");
		System.out.println("Game Service: ");
		return gameRepository.createGame(game);
		
	}

	@Override
	public Game getGame(int gameId) {
		try {
			return gameRepository.getGame(gameId);
		} catch (Exception ex) {
			ex.printStackTrace();
		return null;
		}

	}

	@Override
	public void updateGame(Game game) {
		gameRepository.updateGame(game);
		
	}
}
