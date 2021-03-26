package com.revature.models;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
//	@JsonIgnore 
	//Trying eager loading instead of JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="UserRole_FK")
	private UserRole userRoleHolder;
	
	//Link to Portfolios
//	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, fetch	= FetchType.EAGER)
	@JoinColumn(name = "portfolio_id", referencedColumnName = "portfolio_id")
	private Portfolio portfolio;
	
	
	public User() {};
	
	
	//For creating new users
	public User(String username, String password, UserRole userRoleHolder) {
		super();
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
	}



	public User(int userId, String username, String password, UserRole userRoleHolder, Portfolio portfolio) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
		this.portfolio = portfolio;
	}

	public User(String username, String password, UserRole userRoleHolder, Portfolio portfolio) {
		super();
		this.username = username;
		this.password = password;
		this.userRoleHolder = userRoleHolder;
		this.portfolio = portfolio;
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

	public Portfolio getportfolio() {
		return portfolio;
	}

	public void setportfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
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
		if (portfolio == null) {
			if (other.portfolio != null)
				return false;
		} else if (!portfolio.equals(other.portfolio))
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
