package com.revature.models;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="GAME")
public class Game {
	
	
	
	public Game() {}
	
	public Game(LocalDate gameStartDate, LocalDate gameCurrentDate, GamePhase gamePhaseHolder) {
		super();
		this.gameStartDate = gameStartDate;
		this.gameCurrentDate = gameCurrentDate;
		this.gamePhaseHolder = gamePhaseHolder;

	}
	
	public Game(LocalDate gameStartDate, LocalDate gameCurrentDate, GamePhase gamePhaseHolder,
			List<Portfolio> portfolioList) {
		super();
		this.gameStartDate = gameStartDate;
		this.gameCurrentDate = gameCurrentDate;
		this.gamePhaseHolder = gamePhaseHolder;
		this.portfolioList = portfolioList;
	}



	public Game(int gameId, LocalDate gameStartDate, LocalDate gameCurrentDate, GamePhase gamePhaseHolder,
			List<Portfolio> portfolioList) {
		super();
		this.gameId = gameId;
		this.gameStartDate = gameStartDate;
		this.gameCurrentDate = gameCurrentDate;
		this.gamePhaseHolder = gamePhaseHolder;
		this.portfolioList = portfolioList;
	}

	@Id
	@Column(name="game_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameSequence")
	@SequenceGenerator(name="gameSequence", sequenceName="GAME_SEQ", allocationSize=1)
	private int gameId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="GAME_START_DATE", nullable=false)
	private LocalDate gameStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="GAME_CURRENT_DATE", nullable=false)
	private LocalDate gameCurrentDate;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to GamePhase
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="GamePhase_FK")
	private GamePhase gamePhaseHolder;
	
	//Link to Portfolio
	@OneToMany(mappedBy="gameHolder", fetch = FetchType.LAZY)
	private List<Portfolio> portfolioList = new ArrayList<Portfolio>();

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public LocalDate getGameStartDate() {
		return gameStartDate;
	}

	public void setGameStartDate(LocalDate gameStartDate) {
		this.gameStartDate = gameStartDate;
	}

	public LocalDate getGameCurrentDate() {
		return gameCurrentDate;
	}

	public void setGameCurrentDate(LocalDate gameCurrentDate) {
		this.gameCurrentDate = gameCurrentDate;
	}

	public GamePhase getGamePhaseHolder() {
		return gamePhaseHolder;
	}

	public void setGamePhaseHolder(GamePhase gamePhaseHolder) {
		this.gamePhaseHolder = gamePhaseHolder;
	}

	public List<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(List<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameCurrentDate == null) ? 0 : gameCurrentDate.hashCode());
		result = prime * result + gameId;
		result = prime * result + ((gamePhaseHolder == null) ? 0 : gamePhaseHolder.hashCode());
		result = prime * result + ((gameStartDate == null) ? 0 : gameStartDate.hashCode());
		result = prime * result + ((portfolioList == null) ? 0 : portfolioList.hashCode());
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
		Game other = (Game) obj;
		if (gameCurrentDate == null) {
			if (other.gameCurrentDate != null)
				return false;
		} else if (!gameCurrentDate.equals(other.gameCurrentDate))
			return false;
		if (gameId != other.gameId)
			return false;
		if (gamePhaseHolder == null) {
			if (other.gamePhaseHolder != null)
				return false;
		} else if (!gamePhaseHolder.equals(other.gamePhaseHolder))
			return false;
		if (gameStartDate == null) {
			if (other.gameStartDate != null)
				return false;
		} else if (!gameStartDate.equals(other.gameStartDate))
			return false;
		if (portfolioList == null) {
			if (other.portfolioList != null)
				return false;
		} else if (!portfolioList.equals(other.portfolioList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameStartDate=" + gameStartDate + ", gameCurrentDate=" + gameCurrentDate
				+ "]";
	}

	
}	
