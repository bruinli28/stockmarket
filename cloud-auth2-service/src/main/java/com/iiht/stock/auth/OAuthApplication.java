package com.iiht.stock.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class OAuthApplication {
	private static final String KEY_USER = "user";
	private static final String KEY_AUTHORITIES = "authorities";
	
	/**
	 * 当试图访问由OAuth2保护的服务时，将会调用到这个方法
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value= {"/user"}, produces="application/json")
	public Map<String, Object> auth(OAuth2Authentication user){
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put(KEY_USER, user.getUserAuthentication().getPrincipal());
		userInfo.put(KEY_AUTHORITIES, AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		
		return userInfo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}
}
