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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="GAME")
public class Game {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameSequence")
	@SequenceGenerator(name="gameSequence", sequenceName="GAME_SEQ", allocationSize=1)
	@Column(name="GAME_ID", nullable=false)
	private int gameId;

	@Column(name="START_DATE", nullable=false)
	private String startDate;
	
	@Column(name="PHASE", nullable=false)
	private int phase;
	
	//-------------------FK/PK RELATIONSHIPS
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="game_id_fk")
	private List<User> userList = new ArrayList<User>();
	

	
	public Game() {
		super();
	}
	
	
	
	
	public Game(int gameId) {
		super();
		this.gameId = gameId;
	}




	public Game(String startDate, int phase, List<User> userList) {
		super();
		this.startDate = startDate;
		this.phase = phase;
		this.userList = userList;
	}




	public Game(String startDate, int phase) {
		super();
		this.startDate = startDate;
		this.phase = phase;
	}



	public Game(int gameId, String startDate, int phase) {
		super();
		this.gameId = gameId;
		this.startDate = startDate;
		this.phase = phase;
	}



	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	



	public List<User> getUserList() {
		return userList;
	}



	public void setUserList(List<User> userList) {
		this.userList = userList;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + phase;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (gameId != other.gameId)
			return false;
		if (phase != other.phase)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", startDate=" + startDate + ", phase=" + phase + "]";
	}



	
	
	
}	
