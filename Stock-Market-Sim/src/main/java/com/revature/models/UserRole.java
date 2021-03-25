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
@Table(name="USER_ROLES")
public class UserRole {
	
	
	
	public UserRole() {
		super();
	}
	
	

	public UserRole(String roleName, List<User> userList) {
		super();
		this.roleName = roleName;
		this.userList = userList;
	}

	public UserRole(int roleId, String roleName, List<User> userList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userList = userList;
	}





	@Id
	int roleId;
	
	@Column(name="ROLE_NAME", unique=true, nullable=false)
	String roleName;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to Users
	@OneToMany(mappedBy="userRoleHolder", fetch	= FetchType.LAZY)
	private List<User> userList = new ArrayList<User>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		result = prime * result + roleId;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
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
		UserRole other = (UserRole) obj;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + ", userList=" + userList + "]";
	}
	
	
}
