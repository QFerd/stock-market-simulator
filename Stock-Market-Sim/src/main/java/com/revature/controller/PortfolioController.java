package com.revature.controller;

import com.revature.ajax.ClientMessage;
import com.revature.models.Portfolio;

public interface PortfolioController {
	
	public ClientMessage registerPortfolio(Portfolio portfolio);
	
	//public ClientMessage checkPortfolio(User user, Game game); //TODO: Re-add pending full implementation.

}
