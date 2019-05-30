package com.xebia.StorePortal.utilty;

import com.xebia.StorePortal.model.ErrorResponse;
import com.xebia.StorePortal.pojo.Transaction;

public class UserUtility {

	public static Boolean validateUserId(Integer userId) {
		if (userId != null)
			return true;
		else
			return false;
	}
	
	public static Boolean validateUserIDForTransactionRequest(Transaction transaction) {
		
		Boolean validationFlag=validateUserId(transaction.getUserId());
		if(validationFlag.booleanValue()==false){
			return false;
		}
		else if(transaction.getBillAmount()!=null && transaction.getProductType()!=null){
			return true;
		}
		else 			
		return false;	
	}

	public static ErrorResponse mapErrorResponse(String errorType, String errorCode, String errorDescription,String moreInfo,String location) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(errorCode);
		errorResponse.setDetails(errorDescription);
		errorResponse.setType(errorType);
		errorResponse.setMoreInfo(moreInfo);
		errorResponse.setLocation(location);
		return errorResponse;
	}
	
	public static ErrorResponse mapErrorResponse(String errorType, String errorCode, String errorDescription,Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(errorCode);
		errorResponse.setDetails(errorDescription);
		errorResponse.setType(errorType);
		errorResponse.setMoreInfo(e.getMessage());
		return errorResponse;
	}


}
