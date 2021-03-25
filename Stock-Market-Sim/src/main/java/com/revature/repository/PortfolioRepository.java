package com.revature.repository;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.Position;
import com.revature.models.User;

public interface PortfolioRepository {
	
	void newPortfolio(Portfolio portfolio);
	
	double getTotalValue(User user, Game game);
	
	double getStockValue(User user, Game game);
	
	double getCashValue(User user, Game game);

	Portfolio getPortfolio(User user, Game game);

}
