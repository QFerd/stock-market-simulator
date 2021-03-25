package com.revature.service;

import com.revature.models.Game;

public interface GameService {
	
	public void createOrUpdateGame(Game game);
	
	public Game getGameState();

}
