/**  
 * Project Name:common  
 * File Name:UserModel.java  
 * Package Name:com.iiht.stock.entity  
 * Date:2020年5月12日下午7:37:29  
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.iiht.stock.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 定义一用户实体扩展类，用于界面显示
 * 
 * Date: 2020年5月12日 下午7:37:29 <br/>
 * 
 * @author bruin.li
 * @version
 * @since JDK 1.6
 * @see
 */
public class UserModel extends UserEntity{
	@NotBlank
	private String userName;
	
	private String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
