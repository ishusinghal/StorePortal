package com.xebia.StorePortal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.Transaction;
import com.xebia.StorePortal.repository.TransactionDao;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao tranDao;
	
	@Override
	public Transactions saveTransaction(Transaction transaction) {

		//need to validate the bean and set for the Domain model 
		return tranDao.save(transaction);
	}

}
