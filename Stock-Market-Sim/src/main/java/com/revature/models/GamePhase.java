package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GAME_PHASES")
public class GamePhase {
	
	
	
	public GamePhase() {
		super();
	}
	

	public GamePhase(int phaseId, String phaseName) {
		super();
		this.phaseId = phaseId;
		this.phaseName = phaseName;
	}

	public GamePhase(int phaseId, String phaseName, List<Game> gameList) {
		super();
		this.phaseId = phaseId;
		this.phaseName = phaseName;
		this.gameList = gameList;
	}



	@Id
	@Column(name="phase_id")
	private int phaseId;
	
	@Column(name="PHASE_NAME", unique=true, nullable=false)
	private String phaseName;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	@OneToMany(mappedBy="gamePhaseHolder", fetch	= FetchType.LAZY)
	private List<Game> gameList = new ArrayList<Game>();

	public int getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}

	@Override
	public String toString() {
		return "GamePhase [phaseId=" + phaseId + ", phaseName=" + phaseName + ", gameList=" + gameList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameList == null) ? 0 : gameList.hashCode());
		result = prime * result + phaseId;
		result = prime * result + ((phaseName == null) ? 0 : phaseName.hashCode());
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
		GamePhase other = (GamePhase) obj;
		if (gameList == null) {
			if (other.gameList != null)
				return false;
		} else if (!gameList.equals(other.gameList))
			return false;
		if (phaseId != other.phaseId)
			return false;
		if (phaseName == null) {
			if (other.phaseName != null)
				return false;
		} else if (!phaseName.equals(other.phaseName))
			return false;
		return true;
	}
	
	
}
