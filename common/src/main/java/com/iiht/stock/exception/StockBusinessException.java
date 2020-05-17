/**  
 * Project Name:common  
 * File Name:StockBusinessException.java  
 * Package Name:com.iiht.stock.exception  
 * Date:2020年5月17日上午11:42:02  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.iiht.stock.exception;

/**
 * ClassName:StockBusinessException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年5月17日 上午11:42:02 <br/>
 * 
 * @author bruin.li
 * @version
 * @since JDK 1.6
 * @see
 */
@SuppressWarnings("serial")
public class StockBusinessException extends RuntimeException {
	private String errorCode;
	private String errorMsg;

	public StockBusinessException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
