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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PORTFOLIOS")
public class Portfolio {
	
	
	
	public Portfolio() {
		super();
	}
	
	

	public Portfolio(double totalValue, double stockValue, double cashValue, Game gameHolder,
			List<Position> positionList) {
		super();
		this.totalValue = totalValue;
		this.stockValue = stockValue;
		this.cashValue = cashValue;
		this.gameHolder = gameHolder;
		this.positionList = positionList;
	}



	public Portfolio(int portfolioId, double totalValue, double stockValue, double cashValue,
			Game gameHolder, List<Position> positionList) {
		super();
		this.portfolio_Id = portfolioId;
		this.totalValue = totalValue;
		this.stockValue = stockValue;
		this.cashValue = cashValue;
		this.gameHolder = gameHolder;
		this.positionList = positionList;
	}
	
	@Id
	@Column(name="portfolio_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="portfolioSequence")
	@SequenceGenerator(name="portfolioSequence", sequenceName="PORTFOLIO_SEQ", allocationSize=1)
	private int portfolio_Id;
	
	@Column(name="TOTAL_VALUE")
	private double totalValue;
	
	@Column(name="STOCK_VALUE")
	private double stockValue;
	
	@Column(name="CASH_VALUE")
	private double cashValue;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to Games
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Game_FK")
	private Game gameHolder;
	
	@OneToOne(mappedBy = "portfolio")
	private User user;
	
	//Link to position
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="portfolio_id_fk")
	private List<Position> positionList = new ArrayList<Position>();

	public int getPortfolioId() {
		return portfolio_Id;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolio_Id = portfolioId;
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
		return "Portfolio [portfolioId=" + portfolio_Id + ", totalValue=" + totalValue + ", stockValue=" + stockValue
				+ ", cashValue=" + cashValue  + ", gameHolder=" + gameHolder
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
		result = prime * result + portfolio_Id;
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

		if (portfolio_Id != other.portfolio_Id)
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
