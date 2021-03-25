package com.revature.service;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;

public interface PortfolioService {
	
	public void newPortfolio(Portfolio portfolio);

	
	public double getTotalValue(User user, Game game);

	
	public double getStockValue(User user, Game game);

	
	public double getCashValue(User user, Game game);

	
	public Portfolio getPortfolio(User user, Game game);
	
}
