package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;
import com.revature.repository.PortfolioRepository;

@Service("portfolioService")
public class PortfolioServiceImpl implements PortfolioService{
	
private static Logger logger = Logger.getLogger(PortfolioServiceImpl.class);
	
	@Autowired
	private PortfolioRepository portfolioRepository;

	@Override
	public void newPortfolio(Portfolio portfolio) {
		logger.info("Portfolio Service attempting to make new Portfolio.");
		portfolioRepository.newPortfolio(portfolio);
		logger.info("Success: " + (portfolio.getPortfolioId() != 0));
		
	}


}
