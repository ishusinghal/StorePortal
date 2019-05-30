package com.xebia.StorePortal.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.usertype.UserType;

@Entity
@Table(name = "discount")
public class Discount implements Serializable {
	
	
	@Id
	@GeneratedValue
	@Column(name = "dis_id")
	private Integer disId;
	
	@Column(name = "percent_discount")
	private Integer perDiscount;
	
	@Column(name="dis_for")
	private Integer discountFor;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	public Discount() {
	}
	
	public Discount(Integer disId, Integer perDiscount, Date createdDate, String createdBy) {
		this.disId = disId;
		this.perDiscount = perDiscount;
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

	public Integer getDiscountFor() {
		return discountFor;
	}

	public void setDiscountFor(Integer discountFor) {
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
