package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="POSITIONS")
public class Position {
	
	
	
	public Position() {
		super();
	}
	
	

	public Position(String stockSymbol, int quantity) {
		super();
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
	}
	

	public Position(int positionId, String stockSymbol, int quantity) {
		super();
		this.positionId = positionId;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
	}





	@Id
	@Column(name="position_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="positionSequence")
	@SequenceGenerator(name="positionSequence", sequenceName="POSITION_SEQ", allocationSize=1)
	private int positionId;
	
	//Stocks should be seperated with a comma
	@Column(name="STOCK_SYMBOL")
	private String stockSymbol;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Portfolio portfolio;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", stockSymbol=" + stockSymbol + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionId;
		result = prime * result + quantity;
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
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
		Position other = (Position) obj;
		if (positionId != other.positionId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		return true;
	}
	
	
}
