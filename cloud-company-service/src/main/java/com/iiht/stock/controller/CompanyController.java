/**  
 * Project Name:cloud-company-service  
 * File Name:CompanyController.java  
 * Package Name:com.iiht.stock.controller  
 * Date:2020年5月25日下午9:30:07  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.CompanyEntity;
import com.iiht.stock.exception.StockRequestException;
import com.iiht.stock.service.CompanyService;

/**  
 * ClassName:CompanyController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2020年5月25日 下午9:30:07 <br/>  
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RestController 
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/{id}")
	public CompanyEntity getCompany(@PathVariable Long id)throws RuntimeException{
		if(id == null){
			throw new StockRequestException("", "The parameter [id] is null.");
		}
		
		return companyService.queryCompanyEntityById(id);
	}
}
  
