package com.xebia.StorePortal.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "emp_user")
public class EmpUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "user_type")
	private List<UsersType> userType;

	@Column(name = "created_date")
	private Date createdDate;

	public EmpUser() {

	}

	public EmpUser(Integer userId, String userName, List<UsersType> userType, Date createdDate) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, type=%s]", userId, userName, userType);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UsersType> getUserType() {
		return userType;
	}

	public void setUserType(List<UsersType> userType) {
		this.userType = userType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
