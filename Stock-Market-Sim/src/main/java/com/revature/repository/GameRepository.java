package com.revature.repository;

import com.revature.models.Game;

public interface GameRepository {
	
	public void createOrUpdateGame(Game game);
	
	public Game getGame(int userId);
	

}
