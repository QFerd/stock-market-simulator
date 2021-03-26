package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.service.GameService;

@Controller("gameController")
public class GameControllerImpl implements GameController {
	
	//Should use dependency injection 
	private static ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private GameService gameService;

	@PostMapping("/setgame")
	public @ResponseBody ClientMessage setGame(@RequestBody Game game) {
		gameService.createOrUpdateGame(game);
		return (game.getGameId() != 0) ? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}
	
	@PostMapping("/setGame")
	public @ResponseBody void setGameTest(@RequestBody HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		
		Game game = om.readValue(body, Game.class);
	}

	
}
