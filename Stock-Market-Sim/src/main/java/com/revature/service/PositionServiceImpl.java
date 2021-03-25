package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.Position;
import com.revature.models.User;
import com.revature.repository.PositionRepository;

@Service("positionService")
public class PositionServiceImpl implements PositionService{
	
	@Autowired
	PositionRepository positionRepository;

	@Override
	public List<Position> getPositionsForUser(User user, Game game) {
		positionRepository.getPositionsForUser(user, game);
		return null;
	}

	@Override
	public Position getPosition(User user, Game game, String stockSymbol) {
		positionRepository.getPosition(user, game, stockSymbol);
		return null;
	}

	@Override
	public void createOrUpdatePosition(Position position) {
		positionRepository.createOrUpdatePosition(position);
	}

}
