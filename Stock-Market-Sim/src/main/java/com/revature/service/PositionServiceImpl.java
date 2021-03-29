package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.Position;
import com.revature.models.User;
import com.revature.repository.PositionRepository;

import jdk.internal.org.jline.utils.Log;

@Service("positionService")
public class PositionServiceImpl implements PositionService{
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	PositionRepository positionRepository;


	@Override
	public void createOrUpdatePosition(Position position) {
		logger.info("Attempting to create or update a position with the PositionService.");
		positionRepository.createOrUpdatePosition(position);
	}



}
