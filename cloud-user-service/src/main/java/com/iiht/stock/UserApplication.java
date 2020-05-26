package com.iiht.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import com.iiht.stock.util.UserContextInterceptor;

@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
public class UserApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(UserApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	@Primary
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
		if (interceptors == null) {
			interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		}
		
		interceptors.add(new UserContextInterceptor());
		template.setInterceptors(interceptors);
		return template;
	}
}
