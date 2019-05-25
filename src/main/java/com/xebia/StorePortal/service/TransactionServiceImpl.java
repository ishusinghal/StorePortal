package com.xebia.StorePortal.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.Discount;
import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.model.UsersType;
import com.xebia.StorePortal.pojo.ProductType;
import com.xebia.StorePortal.pojo.Transaction;
import com.xebia.StorePortal.pojo.UType;
import com.xebia.StorePortal.repository.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao tranDao;

//	@Autowired
//	Disc
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Transactions saveTransaction(Transaction transaction) {

		// need to validate the bean and set for the Domain model
		// I am considering here to get the Transaction Domain Model object

		Transaction domTx = new Transaction();

		return tranDao.save(transaction);
	}

	@Override
	public Double findNetPayableAmount(Transactions transactions) {

		if (!transactions.getProductType().equalsIgnoreCase(ProductType.GROCERY.getKey())) {
			if (transactions.getEmpUser().get(0).getUserType().get(0).getUserId() == UType.EMPLOYEE.getValue()) {
				
				//netPayAmount should be reduced by 30 %		
				//return netPayAmount;
			}
			
			if(transactions.getEmpUser().get(0).getUserType().get(0).getUserId() == UType.AFFILIATE.getValue()) {
				
				//netPayAmount should be reduced by 20 %	
				//return netPayAmount;
			}
		
			if(transactions.getEmpUser().get(0).getUserType().get(0).getUserId() == UType.CUSTOMER.getValue()) {
				
//				Date txDate = new java.util.Date(transactions.getEmpUser().get(0).getUserId()
//						getTxDate().getTime()
				
			
		//if the user duration with store is less than 2 year we will not give 5% discount
				
				
			//if user is 2 year old + 
				// we will give 5% discount which should be fetched from db 
				
				//netPayAmount should be reduced by 5 %		
				//return netPayAmount;
			//else
				//if amount is $100+ , for every 100$ we will give 5$ discount 
					// netPayamt = amount * 5 / 100 
				
				//return netPayAmount;
				//if not $100 
				//nothing is discounted
				
			}

		return null;
	}
		return null;
	}

}
