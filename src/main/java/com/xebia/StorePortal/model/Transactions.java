package com.xebia.StorePortal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "tid")
	private Integer tid;
	
	@Column(name = "user_id")
	private Integer empUser;
	
	@Column(name = "bill_amount")
	private BigDecimal billAmount;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "tx_date")
	private Timestamp txDate;

	public Transactions() {
		
	}

	
	public Transactions(Integer tid, Integer empUser, BigDecimal billAmount, String productType, Timestamp txDate) {
		this.tid = tid;
		this.empUser = empUser;
		this.billAmount = billAmount;
		this.productType = productType;
		this.txDate = txDate;
	}


	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	
	public Integer getEmpUser() {
		return empUser;
	}


	public void setEmpUser(Integer empUser) {
		this.empUser = empUser;
	}


	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Timestamp getTxDate() {
		return txDate;
	}

	public void setTxDate(Timestamp txDate) {
		this.txDate = txDate;
	}

	
}
