package com.revature.repository;

import java.util.List;

import com.revature.models.Game;
import com.revature.models.Position;
import com.revature.models.User;

public interface PositionRepository {
	

	void createOrUpdatePosition(Position position);

}
