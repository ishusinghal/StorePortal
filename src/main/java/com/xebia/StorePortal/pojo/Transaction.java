package com.xebia.StorePortal.pojo;

public class Transaction {
	
	private Integer tid;
	
	private Integer usersType;
	
	private Double billAmount;
	
	private String productType;
	
	private String txDate;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getUsersType() {
		return usersType;
	}

	public void setUsersType(Integer usersType) {
		this.usersType = usersType;
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

	public String getTxDate() {
		return txDate;
	}

	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}

	
	
}
