/**  
 * Project Name:cloud-company-service  
 * File Name:CompanyApplication.java  
 * Package Name:com.iiht.stock  
 * Date:2020年5月25日下午9:21:53  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.iiht.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**  
 * ClassName:CompanyApplication <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2020年5月25日 下午9:21:53 <br/>  
 * @author   bruin.li  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
public class CompanyApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(CompanyApplication.class, args);
	}
}
  
