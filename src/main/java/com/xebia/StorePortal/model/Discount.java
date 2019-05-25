package com.xebia.StorePortal.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.usertype.UserType;

@Entity
@Table(name = "discount")
public class Discount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "dis_id")
	private Integer disId;
	
	@Column(name = "percent_discount")
	private Integer perDiscount;
	
	@Column(name = "dis_for")
	private UserType discountFor;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	protected Discount() {
	}
	
	public Discount(Integer disId, Integer perDiscount, UserType discountFor, Date createdDate, String createdBy) {
		super();
		this.disId = disId;
		this.perDiscount = perDiscount;
		this.discountFor = discountFor;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Integer getDisId() {
		return disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	public Integer getPerDiscount() {
		return perDiscount;
	}

	public void setPerDiscount(Integer perDiscount) {
		this.perDiscount = perDiscount;
	}

	public UserType getDiscountFor() {
		return discountFor;
	}

	public void setDiscountFor(UserType discountFor) {
		this.discountFor = discountFor;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
