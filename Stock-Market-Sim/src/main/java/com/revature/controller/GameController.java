package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;

public interface GameController {
	//CRUD
	public int setGame(Game game,  HttpServletRequest request);
	
	public void update(Game game,  HttpServletRequest request);
	
	public Game getGameByUser(User user, HttpServletRequest request);
}
