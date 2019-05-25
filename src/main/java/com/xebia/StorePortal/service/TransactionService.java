package com.xebia.StorePortal.service;

import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.Transaction;

@Service
public interface TransactionService {

	public Transactions saveTransaction(Transaction transaction);
	
}
