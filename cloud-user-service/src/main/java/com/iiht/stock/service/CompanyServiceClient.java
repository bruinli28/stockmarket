/**  
 * Project Name:cloud-user-service  
 * File Name:CompanyServiceClient.java  
 * Package Name:com.iiht.stock.service  
 * Date:2020年5月26日上午7:38:08  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iiht.stock.entity.CompanyEntity;

/**  
 * ClassName:CompanyServiceClient <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2020年5月26日 上午7:38:08 <br/>  
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@FeignClient("cloud-company-service")
public interface CompanyServiceClient {
	@RequestMapping(
			method=RequestMethod.GET,
			value="/api/company/{id}",
			consumes="application/json"
			)
	public CompanyEntity queryCompanyEntityById(Long id);
}
  
