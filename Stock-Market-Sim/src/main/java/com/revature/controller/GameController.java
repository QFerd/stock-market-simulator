package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;

public interface GameController {
	//CRUD
	public void setGame(Game game);
	
	public Game getGame(User user, HttpServletRequest request);
}
