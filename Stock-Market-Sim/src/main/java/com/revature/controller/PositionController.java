package com.revature.controller;

import com.revature.ajax.ClientMessage;
import com.revature.models.Position;
import com.revature.models.User;

public interface PositionController {
	
	public ClientMessage registerPosition(Position position);
	
	public ClientMessage updatePosition(Position position);
	
	public ClientMessage getPositionValues(Position position, User user);
	
	//public ClientMessage checkPortfolio(User user, Game game); //TODO: Re-add pending full implementation.

}
