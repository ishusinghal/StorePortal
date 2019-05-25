package com.xebia.StorePortal.service;

import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.Transaction;

public interface TransactionService {

	public Transactions saveTransaction(Transaction transaction);
	
}
