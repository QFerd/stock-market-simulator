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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="user_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	private int userId;
	
	@Column(name="USERNAME", unique=true, nullable=false)
	private String username;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to UserRoles
	@JsonIgnore 
	//Trying eager loading instead of JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="UserRole_FK")
	private UserRole userRoleHolder;
	
	// I think that the user and portfolio is a ONE to ONE
	// But position is Manyto ONe portfolio
	
	//Link to Portfolios
	@JsonIgnore
	@OneToMany(mappedBy="playerHolder", fetch= FetchType.LAZY)
	private List<Portfolio> portfolioList = new ArrayList<Portfolio>();
	
	
	public User() {};
	
	
	//For creating new users
	public User(String username, String password, UserRole userRoleHolder) {
		super();
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
	}
	

	public User(int userId, String username, String password, List<Portfolio> portfolioList) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.portfolioList = portfolioList;
	}


	public User(int userId, String username, String password, UserRole userRoleHolder, List<Portfolio> portfolioList) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
		this.portfolioList = portfolioList;
	}

	public User(String username, String password, UserRole userRoleHolder, List<Portfolio> portfolioList) {
		super();
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
		this.portfolioList = portfolioList;
	}
	
	
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRoleHolder() {
		return userRoleHolder;
	}

	public void setUserRoleHolder(UserRole userRoleHolder) {
		this.userRoleHolder = userRoleHolder;
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
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((portfolioList == null) ? 0 : portfolioList.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userRoleHolder == null) ? 0 : userRoleHolder.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (portfolioList == null) {
			if (other.portfolioList != null)
				return false;
		} else if (!portfolioList.equals(other.portfolioList))
			return false;
		if (userId != other.userId)
			return false;
		if (userRoleHolder == null) {
			if (other.userRoleHolder != null)
				return false;
		} else if (!userRoleHolder.equals(other.userRoleHolder))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
