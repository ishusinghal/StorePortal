package com.xebia.StorePortal.service;


import com.xebia.StorePortal.model.DiscountResponse;
import com.xebia.StorePortal.model.EmpUser;
import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.Transaction;

public interface TransactionService {

	public Transactions saveTransaction(Transaction transaction)  throws Exception;
	
	public DiscountResponse findNetPayableAmount(Transactions transactions)  throws Exception;
	
	public EmpUser getEmpUserByUserTypeId(int userId)  throws Exception;
	
}
