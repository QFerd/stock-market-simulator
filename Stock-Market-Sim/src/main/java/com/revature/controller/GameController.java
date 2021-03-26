package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;

public interface GameController {
	//CRUD
	ClientMessage setGame(Game game);
}
