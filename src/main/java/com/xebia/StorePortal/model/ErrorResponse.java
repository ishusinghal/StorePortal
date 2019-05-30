/*
* Copyright (C) 2016 by Citigroup. All rights reserved.
* Citigroup claims copyright in this computer program as an unpublished work,
* one or more versions of which were first used to provide services to
* customers on the dates indicated in the foregoing notice. Claim of
* copyright does not imply waiver of other rights.
*
* NOTICE OF PROPRIETARY RIGHTS
*
* This program is a confidential trade secret and the property of Citigroup.
* Use, examination, reproduction, disassembly, decompiling, transfer and/or
* disclosure to others of all or any part of this software program are
* strictly prohibited except by express written agreement with Citigroup.
*/

package com.xebia.StorePortal.model;

/**
 * ErrorResponse
 */
public class ErrorResponse {
	/**
	 * Invalid - Request did not confirm to the specification and was
	 * unprocessed and rejected. Please fix the value and try again
	 */

	private String code;

	private String type;

	private String details;

	private String location;

	private Object moreInfo;

	/**
	 * Invalid - Request did not confirm to the specification and was
	 * unprocessed and rejected. Please fix the value and try again
	 * 
	 * @return type
	 **/

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Error code which qualifies the error
	 * 
	 * @return code
	 **/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Human readable explanation specific to the occurrence of the problem
	 * 
	 * @return details
	 **/

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * The name of the field that resulted in the error
	 * 
	 * @return location
	 **/

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * URI to human readable documentation of the error
	 * 
	 * @return moreInfo
	 **/

	public Object getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(Object moreInfo) {
		this.moreInfo = moreInfo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorResponse {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
		sb.append("    location: ").append(toIndentedString(location)).append("\n");
		sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
