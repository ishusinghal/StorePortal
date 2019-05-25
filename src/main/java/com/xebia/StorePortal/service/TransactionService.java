package com.xebia.StorePortal.service;

import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.Transaction;

public interface TransactionService {

	public Transactions saveTransaction(Transaction transaction);
	
	public Double findNetPayableAmount(Transactions transactions);
	
}
