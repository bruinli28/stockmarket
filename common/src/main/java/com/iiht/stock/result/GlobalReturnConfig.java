/**  
 * Project Name:common  
 * File Name:GlobalReturnConfig.java  
 * Package Name:com.iiht.stock.result  
 * Date:2020年5月17日上午11:25:30  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock.result;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.iiht.stock.exception.FieldErrorResource;
import com.iiht.stock.exception.StockBusinessException;
import com.iiht.stock.exception.StockRequestException;

/**  
 * ClassName:GlobalReturnConfig <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2020年5月17日 上午11:25:30 <br/>  
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@EnableWebMvc
@Configuration
public class GlobalReturnConfig {
	@RestControllerAdvice("com.iiht.stock.controller")
	static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object>{
		@Override
		public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
			return true;
		}

		@Override
		public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
			if (body instanceof CommonResult){
				return body;
			}

			return new CommonResult<Object>(body);
		}
	}
	
	@RestControllerAdvice("com.iiht.stock")
	static class StockExceptionHandler{

	    @ExceptionHandler(StockRequestException.class)
	    public CommonResult<Void> handleRequestException(StockRequestException e){

	        List<FieldErrorResource> errorResources = e.getErrors().getFieldErrors().stream().map(fieldError ->
	            new FieldErrorResource(fieldError.getObjectName(), 
	            		fieldError.getField(), 
	            		fieldError.getCode(), 
	            		fieldError.getDefaultMessage()))
	        		.collect(Collectors.toList());

	        return CommonResult.errorResult(e.getErrorCode(), e.getErrorMsg(), errorResources);
	    }
	    
	    @ExceptionHandler(StockBusinessException.class)
	    public CommonResult<Void> handleBusinessException(StockBusinessException e){
	    	return CommonResult.errorResult(e.getErrorCode(), e.getErrorMsg());
	    }
	}
}
  
