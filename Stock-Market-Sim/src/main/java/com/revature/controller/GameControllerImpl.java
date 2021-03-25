package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.service.GameService;

@Controller("gameController")
public class GameControllerImpl implements GameController {
	
	@Autowired
	private GameService gameService;

	@PostMapping("/setgame")
	public @ResponseBody ClientMessage setGame(@RequestBody Game game) {
		gameService.createOrUpdateGame(game);
		return (game.getGameId() != 0) ? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}

	
}
