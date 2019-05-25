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
	
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "user_id")
	private List<EmpUser> empUser;
	
	@Column(name = "bill_amount")
	private Double billAmount;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "tx_date")
	private Date txDate;

	protected Transactions() {
		
	}

	
	public Transactions(Integer tid, List<EmpUser> empUser, Double billAmount, String productType, Date txDate) {
		super();
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

	public List<EmpUser> getEmpUser() {
		return empUser;
	}

	public void setEmpUser(List<EmpUser> empUser) {
		this.empUser = empUser;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	
}
