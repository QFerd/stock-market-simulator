package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;
import com.revature.service.PortfolioService;

public class PortfolioControllerImpl implements PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;
	
	@PostMapping("/registerPortfolio")
	public @ResponseBody ClientMessage registerPortfolio(@RequestBody Portfolio portfolio) {
		portfolioService.newPortfolio(portfolio);
		return (portfolio.getPortfolioId() != 0) ? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}
	
	/*@PostMapping("/checkPortfolio") TODO: Re-add this once we figure out how to get it working.
	public @ResponseBody ClientMessage checkPortfolio(@RequestBody User user, Game game) {
		Portfolio port = portfolioService.getPortfolio(user, game);
		double portCashVal = port.getCashValue();
		double portStockVal = port.getStockValue();
		double portTotalVal = port.getTotalValue();
		return ; //TODO: How should I get a ClientMessage here?
	}*/

}