package com.iiht.stock.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.iiht.stock.auth.repository.UserRepository;

/**
 * AuthorizationServerConfigurerAdapter类是Spring Security的核心部分，它提供了执行关键验证和授权功能的基本机制
 * 
 * 1， 定义那些客户端将注册到服务；
 * 2，配置AuthenticationManager和UserDetailsService；
 * 
 * @author bruin.li
 *
 */
//现在使用JWT的配置，暂时注销
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	/**
	 * 定义那些客户端将注册到服务
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("cloudsimpleservice")
			.secret("mysecret")
			.authorizedGrantTypes(
				"refesh_token",
				"password",
				"client_credentials")
			.scopes("webclient", "mobileclient");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()");
	}

	/**
	 * 定义了AuthorizationServerConfigurer中使用的不同组件。
	 * 这里使用spring提供的默认验证管理器和用户详细信息服务
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}

}
