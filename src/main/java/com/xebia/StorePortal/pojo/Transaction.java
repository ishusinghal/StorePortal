package com.xebia.StorePortal.pojo;

import java.math.BigDecimal;

public class Transaction {
	
	private Integer userId;
	
	private BigDecimal billAmount;
	
	private ProductType productType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
	
}
