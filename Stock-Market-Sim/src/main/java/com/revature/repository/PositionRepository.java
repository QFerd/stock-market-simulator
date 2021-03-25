package com.revature.repository;

import java.util.List;

import com.revature.models.Game;
import com.revature.models.Position;
import com.revature.models.User;

public interface PositionRepository {
	
	public List<Position> getPositionsForUser(User user, Game game);

	Position getPosition(User user, Game game, String stockSymbol);

	void createOrUpdatePosition(Position position);

}
