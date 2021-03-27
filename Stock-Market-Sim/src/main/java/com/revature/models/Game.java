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
	
	@Id
	@Column(name="GAME_ID", nullable=false)
	private int gameId;

	@Column(name="START_DATE", nullable=false)
	private String startDate;
	
	@Column(name="PHASE", nullable=false)
	private int phase;
	

	
}	
