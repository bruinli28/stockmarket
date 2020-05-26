/**  
 * Project Name:cloud-company-service  
 * File Name:CompanyService.java  
 * Package Name:com.iiht.stock.service  
 * Date:2020年5月25日下午9:26:13  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock.service;

import com.iiht.stock.entity.CompanyEntity;

/**  
 * ClassName:CompanyService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2020年5月25日 下午9:26:13 <br/>  
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface CompanyService {
	/**
	 * 
	 * 根据ID获取公司信息
	 *  
	 * @author bruin.li  
	 * @param id
	 * @return  
	 * @since JDK 1.6
	 */
	public CompanyEntity queryCompanyEntityById(Long id);
}
  
