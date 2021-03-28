package com.revature.repository;

import com.revature.models.Game;

public interface GameRepository {
	
	public int createGame(Game game);
	
	public void updateGame(Game game);
	
	public Game getGame(int userId);
	

}
