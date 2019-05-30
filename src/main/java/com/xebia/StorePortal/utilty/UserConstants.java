package com.xebia.StorePortal.utilty;

public class UserConstants {
	
	public static int BAD_REQUEST = 400;
	public static int AUTHORIZATION_ERROR = 401;
	public static int ACCESS_FORBIDDEN = 403;
	public static String badRequestErrorDescription = "Missing or Invalid Parameters";
	public static String invalidErrorType = "invalid";
	public static String invalidErrorCode = "invalidRequest";
	public static String serverErrorType = "error";
	public static String serverErrorCode = "serverUnavailable";
	public static String serverErrorDescription= "The request failed due to an internal error";
	public static int SERVER_ERROR_CODE = 500;
	//public static String SERVER_UNAVAILABLE = "500";
	public static String invalidUserErrorDescription = "Invalid User Details";
	public static String invalidUserErrorType = "invalid";
	public static String invalidUserErrorCode = "invalidUser";
	public static String multipleUsersErrorCode = "multipleUsersRetrieved";
	public static String multipleUsersErrorDescription = "Multiple users are retrieved for the user id";
	public static String userAlreadyErrorType = "error";
	public static String userAlreadyExistsErrorCode = "userAlreadyExists";
	public static String userAlreadyExistsErrorDescription = "User already exists";

	public static String discountNotAvailableErrorType = "error";
	public static String discountNotAvailableErrorCode = "Discounts not applicable for GROCERY products";
	public static String discountNotAvailableErrorDescription = "Discount Not Applicable";
	

	
	

}
