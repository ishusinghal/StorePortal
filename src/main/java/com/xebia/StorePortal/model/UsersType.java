package com.xebia.StorePortal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_type")
public class UsersType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue
	@Column(name = "u_id")
	private Integer userId;

	@Column(name = "u_type")
	private String userType;

	protected UsersType() {

	}

	public UsersType(Integer userId, String userType) {
		super();
		this.userId = userId;
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserId"+this.userId+"userType"+this.userType;
	}
	
}
