package com.xebia.StorePortal.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xebia.StorePortal.model.DiscountResponse;
import com.xebia.StorePortal.model.ErrorResponse;
import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.model.UsersType;
import com.xebia.StorePortal.pojo.Transaction;
import com.xebia.StorePortal.service.TransactionService;
import com.xebia.StorePortal.service.UserService;
import com.xebia.StorePortal.utilty.StorePortalException;
import com.xebia.StorePortal.utilty.UserConstants;
import com.xebia.StorePortal.utilty.UserUtility;

@RestController
@RequestMapping("/private/v1/")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userServiceImpl;
	
	@Autowired
	TransactionService tranServiceImpl;
		
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public List<UsersType> getAllUsers() {
		return  userServiceImpl.getAllUsers();
	}
	
	@RequestMapping(value = "/findNetPayableAmount",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> findNetPayableAmount(@RequestBody Transaction transaction) throws Exception{
		logger.debug("findNetPayableAmount called");

		ErrorResponse errorResponse = null;
		Boolean userIdValidationFlag = null;

		userIdValidationFlag = UserUtility.validateUserIDForTransactionRequest(transaction);
		logger.debug("User Validation Flag" + userIdValidationFlag);
		try {
			if (userIdValidationFlag) {
				logger.debug("User Validation Flag is successful");

				Transactions savedTran = tranServiceImpl.saveTransaction(transaction);
				
				DiscountResponse prepareResponse  = tranServiceImpl.findNetPayableAmount(savedTran);

				return new ResponseEntity<DiscountResponse>(prepareResponse, HttpStatus.OK);
			
			} else {
				logger.debug("Invalid UserId");
				errorResponse = UserUtility.mapErrorResponse(UserConstants.invalidErrorType,
						UserConstants.invalidErrorCode, UserConstants.badRequestErrorDescription, "",
						"Invalid UserId");
				return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
			}
		} catch (StorePortalException e) {
			logger.error("Store Portal Exception occured. Details are Error Code:" + e.getErrorCode()
					+ " Error Type:" + e.getErrorType() + "Error Description:" + e.getErrorDescription());
			errorResponse = UserUtility.mapErrorResponse(e.getErrorCode(), e.getErrorType(), e.getErrorDescription(),
					e);
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(e.getStatusCode()));
		} catch (Exception e) {
			logger.error("Exception occured. Details are Error Code:" + e.getMessage());
			logger.error("Sending the response with 500 Status code");
			errorResponse = UserUtility.mapErrorResponse("error", "serverUnavailable",
					"The request failed due to an internal error", e);
			e.printStackTrace();
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
}
