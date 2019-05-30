package com.xebia.StorePortal.utilty;

import java.io.Serializable;

public class StorePortalException extends Exception implements Serializable {

	private static final long serialVersionUID = 8470787679591607287L;

	
	private StackTraceElement[] elements;

	private String errorCode;

	private String errorType;

	private String errorDescription;

	private String moreInfo;

	private String location;
	
	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public StackTraceElement[] getElements() {
		return elements;
	}

	public void setElements(StackTraceElement[] elements) {
		this.elements = elements;
	}	
	
	public StorePortalException(String errorCode, String errorType, String errorDescription, String moreInfo,
			String location, int statusCode,Exception e) {
		super(e.getMessage());
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorType = errorType;
		this.moreInfo = moreInfo;
		this.location = location;
		this.statusCode=statusCode;
	}

	public StorePortalException(String errorCode, String errorType, String errorDescription, int statusCode,Exception e) {
		super(e.getMessage());
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorType = errorType;
		this.moreInfo = e.getMessage();		
		this.statusCode=statusCode;
	}
	public StorePortalException(String errorCode, String errorType, String errorDescription, int statusCode) {
		super(errorDescription);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorType = errorType;		
		this.statusCode=statusCode;
	}
	public StorePortalException(String errorCode, String errorType, String errorDescription, String moreInfo,int statusCode) {
		super(errorDescription);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorType = errorType;
		this.moreInfo = moreInfo;		
		this.statusCode=statusCode;
	}

}
