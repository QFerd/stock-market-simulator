package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.service.GameService;

@Controller("gameController")
@CrossOrigin(origins = "http://localhost:4200")
public class GameControllerImpl implements GameController {
	
	//Should use dependency injection 
	private static ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private GameService gameService;

	@PostMapping("/setGame")
	public @ResponseBody int setGame(@RequestBody Game game,  HttpServletRequest request) {
		request.getSession();
		return gameService.createGame(game);

	}
	
	@PostMapping("/getGame")
	public @ResponseBody Game getGameByUser(@RequestBody User user, HttpServletRequest request) {
		request.getSession();
		return gameService.getGame(user.getGame().getGameId());

	}

	@PostMapping("/updateGame")
	public @ResponseBody ClientMessage update(@RequestBody Game game,  HttpServletRequest request) {
		request.getSession();
		gameService.updateGame(game);
		return UPDATE_SUCCESFULL;
	}
	
}
