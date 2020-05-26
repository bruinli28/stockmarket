/**  
 * Project Name:cloud-company-service  
 * File Name:CompanyBusiness.java  
 * Package Name:com.iiht.stock.service  
 * Date:2020年5月25日下午9:35:18  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.iiht.stock.service;

import org.springframework.stereotype.Service;

import com.iiht.stock.entity.CompanyEntity;

/**
 * ClassName:CompanyBusiness <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年5月25日 下午9:35:18 <br/>
 * 
 * @author bruin.li
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class CompanyBusiness implements CompanyService {

	@Override
	public CompanyEntity queryCompanyEntityById(Long id) {
		CompanyEntity company = new CompanyEntity();
		company.setId(1L);
		company.setName("IBM");
		
		return company;
	}

}
