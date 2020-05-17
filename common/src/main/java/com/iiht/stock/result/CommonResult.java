/**  
 * Project Name:common  
 * File Name:CommonResult.java  
 * Package Name:com.iiht.stock.result  
 * Date:2020年5月17日上午11:18:06  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock.result;

import java.util.List;

import com.iiht.stock.exception.FieldErrorResource;

/**  
 * ClassName:CommonResult <br/>  
 * 定义API全局统一的返回数据格式
 * 
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class CommonResult<T> {
	// 状态码，标识请求成功与否，如 [1:成功；-1:失败]
	private int status = 1;
	// 错误码，给出明确错误码，更好的应对业务异常；请求成功该值可为空
	private String errorCode = "";
	// 错误消息，与错误码相对应，更具体的描述异常信息
	private String errorMsg = "";
	// 前端字段的输入数据的验证错误信息
	private List<FieldErrorResource> fieldErrors;
	
	// 返回结果，通常是 Bean 对象对应的 JSON 数据, 通常为了应对不同返回值类型，将其声明为泛型类型
	private T resultBody;
	
	public CommonResult() {
	}

	public CommonResult(T resultBody) {
		this.resultBody = resultBody;
	}
	
	public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg){
	    CommonResult<T> commonResult = new CommonResult<>();
	    commonResult.errorCode = errorCode;
	    commonResult.errorMsg = errorMsg;
	    commonResult.status = -1;
	    return commonResult;
	}
	
	public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg, List<FieldErrorResource> fieldErrors){
		CommonResult<T> commonResult = new CommonResult<>();
		commonResult.errorCode = errorCode;
		commonResult.errorMsg = errorMsg;
		commonResult.status = -1;
		commonResult.fieldErrors = fieldErrors;
		return commonResult;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public T getResultBody() {
		return resultBody;
	}

	public void setResultBody(T resultBody) {
		this.resultBody = resultBody;
	}

	public List<FieldErrorResource> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
  
