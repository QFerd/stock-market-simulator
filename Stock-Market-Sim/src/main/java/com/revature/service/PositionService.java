package com.revature.service;

import java.util.List;

import com.revature.models.Game;
import com.revature.models.Position;
import com.revature.models.User;

public interface PositionService {
	public List<Position> getPositionsForUser(User user, Game game);

	Position getPosition(User user, Game game, String stockSymbol);

	void createOrUpdatePosition(Position position);

}
