package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PORTFOLIOS")
public class Portfolio {
	
	
	
	public Portfolio() {
		super();
	}
	
	

	public Portfolio(double totalValue, double stockValue, double cashValue, User playerHolder, Game gameHolder,
			List<Position> positionList) {
		super();
		this.totalValue = totalValue;
		this.stockValue = stockValue;
		this.cashValue = cashValue;
		this.playerHolder = playerHolder;
		this.gameHolder = gameHolder;
		this.positionList = positionList;
	}



	public Portfolio(int portfolioId, double totalValue, double stockValue, double cashValue, User playerHolder,
			Game gameHolder, List<Position> positionList) {
		super();
		this.portfolioId = portfolioId;
		this.totalValue = totalValue;
		this.stockValue = stockValue;
		this.cashValue = cashValue;
		this.playerHolder = playerHolder;
		this.gameHolder = gameHolder;
		this.positionList = positionList;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="portfolioSequence")
	@SequenceGenerator(name="portfolioSequence", sequenceName="PORTFOLIO_SEQ", allocationSize=1)
	int portfolioId;
	
	@Column(name="TOTAL_VALUE")
	double totalValue;
	
	@Column(name="STOCK_VALUE")
	double stockValue;
	
	@Column(name="CASH_VALUE")
	double cashValue;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to Users
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="User_FK")
	private User playerHolder;
	
	//Link to Games
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Game_FK")
	private Game gameHolder;
	
	//Link to position
	@OneToMany(mappedBy="portfolioHolder", fetch = FetchType.LAZY)
	private List<Position> positionList = new ArrayList<Position>();

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public double getCashValue() {
		return cashValue;
	}

	public void setCashValue(double cashValue) {
		this.cashValue = cashValue;
	}

	public User getPlayerHolder() {
		return playerHolder;
	}

	public void setPlayerHolder(User playerHolder) {
		this.playerHolder = playerHolder;
	}

	public Game getGameHolder() {
		return gameHolder;
	}

	public void setGameHolder(Game gameHolder) {
		this.gameHolder = gameHolder;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", totalValue=" + totalValue + ", stockValue=" + stockValue
				+ ", cashValue=" + cashValue + ", playerHolder=" + playerHolder + ", gameHolder=" + gameHolder
				+ ", positionList=" + positionList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cashValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((gameHolder == null) ? 0 : gameHolder.hashCode());
		result = prime * result + ((playerHolder == null) ? 0 : playerHolder.hashCode());
		result = prime * result + portfolioId;
		result = prime * result + ((positionList == null) ? 0 : positionList.hashCode());
		temp = Double.doubleToLongBits(stockValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		if (Double.doubleToLongBits(cashValue) != Double.doubleToLongBits(other.cashValue))
			return false;
		if (gameHolder == null) {
			if (other.gameHolder != null)
				return false;
		} else if (!gameHolder.equals(other.gameHolder))
			return false;
		if (playerHolder == null) {
			if (other.playerHolder != null)
				return false;
		} else if (!playerHolder.equals(other.playerHolder))
			return false;
		if (portfolioId != other.portfolioId)
			return false;
		if (positionList == null) {
			if (other.positionList != null)
				return false;
		} else if (!positionList.equals(other.positionList))
			return false;
		if (Double.doubleToLongBits(stockValue) != Double.doubleToLongBits(other.stockValue))
			return false;
		if (Double.doubleToLongBits(totalValue) != Double.doubleToLongBits(other.totalValue))
			return false;
		return true;
	}
	
	
	
}
