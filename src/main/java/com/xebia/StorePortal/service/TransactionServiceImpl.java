package com.xebia.StorePortal.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.DiscountResponse;
import com.xebia.StorePortal.model.EmpUser;
import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.pojo.ProductType;
import com.xebia.StorePortal.pojo.Transaction;
import com.xebia.StorePortal.pojo.UType;
import com.xebia.StorePortal.repository.TransactionDao;
import com.xebia.StorePortal.utilty.StorePortalException;
import com.xebia.StorePortal.utilty.UserConstants;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	TransactionDao tranDao;

	@Autowired
	UserService userServiceImpl;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Transactions saveTransaction(Transaction transaction) throws Exception {
		logger.debug("saveTransaction" + transaction);

		Transactions tranModel = new Transactions();
		tranModel.setBillAmount(transaction.getBillAmount());
		tranModel.setProductType(transaction.getProductType().getKey());
		tranModel.setTxDate(new Timestamp(new Date().getTime()));
		tranModel.setEmpUser(transaction.getUserId());

		return tranDao.save(tranModel);
	}

	@Override
	public EmpUser getEmpUserByUserTypeId(int userId) {
		logger.debug("getEmpUserByUserTypeId" + userId);
		Criteria ctr = em.unwrap(Session.class).createCriteria(EmpUser.class);
		ctr.add(Restrictions.eq("userId", userId));
		List<EmpUser> empUserList = ctr.list();
		return empUserList.get(0);
	}

	@Override
	public DiscountResponse findNetPayableAmount(Transactions transactions) throws Exception {
		logger.debug("findNetPayableAmount" + transactions);

		BigDecimal netPayAmt = new BigDecimal(0.0);
		DiscountResponse prepareResponse = null;

		if (!transactions.getProductType().equalsIgnoreCase(ProductType.GROCERY.getKey())) {
			if (transactions.getEmpUser() == UType.EMPLOYEE.getValue()) {
				netPayAmt = transactions.getBillAmount()
						.subtract(transactions.getBillAmount().multiply(new BigDecimal(.30)));
				// netPayAmount should be reduced by 30 %
				prepareResponse = new DiscountResponse();
				prepareResponse.setNetPayableAmount(netPayAmt.setScale(2,RoundingMode.CEILING));
				return prepareResponse;
			}

			if (transactions.getEmpUser() == UType.AFFILIATE.getValue()) {

				netPayAmt = transactions.getBillAmount()
						.subtract(transactions.getBillAmount().multiply(new BigDecimal(.20)));
				// netPayAmount should be reduced by 20 %
				prepareResponse = new DiscountResponse();
				prepareResponse.setNetPayableAmount(netPayAmt.setScale(2,RoundingMode.CEILING));
				return prepareResponse;
			}

			if (transactions.getEmpUser() == UType.CUSTOMER.getValue()) {

//				Transactions trans =  tranDao.findCustomerTransactionFromLastTwoYear(transactions.getEmpUser()).get(0);
//				if(trans!=null){
				
//				BigDecimal rem = transactions.getBillAmount().divide(new BigDecimal(100)).setScale(0, RoundingMode.CEILING);
				
				netPayAmt = transactions.getBillAmount()
						.subtract(transactions.getBillAmount().multiply(new BigDecimal(.05)));
				
				// netPayAmount should be reduced by 5 %
				prepareResponse = new DiscountResponse();
				prepareResponse.setNetPayableAmount(netPayAmt.setScale(2,RoundingMode.CEILING));
				return prepareResponse;

/*				}else{
					logger.info("Discount is not given as user has not been a customer");
					
					throw new StorePortalException(UserConstants.discountNotAvailableErrorCode,
							UserConstants.discountNotAvailableErrorDescription, UserConstants.discountNotAvailableErrorType,
							UserConstants.BAD_REQUEST);
				}
*/			}

		} else {
			logger.info("Discount is not applicable for GROCERY");

			throw new StorePortalException(UserConstants.discountNotAvailableErrorCode,
					UserConstants.discountNotAvailableErrorDescription, UserConstants.discountNotAvailableErrorType,
					UserConstants.BAD_REQUEST);

		}
		return prepareResponse;
	}

}
