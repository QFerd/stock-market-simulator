package com.revature.service;

import com.revature.models.Game;

public interface GameService {
	
	public int createGame(Game game);
	
	public void updateGame(Game game);
	
	public Game getGame(int gameId);

}
