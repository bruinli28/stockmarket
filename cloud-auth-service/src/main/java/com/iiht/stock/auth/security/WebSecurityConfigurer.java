package com.iiht.stock.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.iiht.stock.auth.repository.UserRepository;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
//	UsernamePasswordAuthenticationFilter user;
//	DelegatingFilterProxy proxy;
//	SecurityContextHolderAwareRequestFilter a;
//	JdbcUserDetailsManager d;
	@Autowired
	private UserRepository userRepository;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("user")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN", "USER", "ANONYMOUS");
		
//		auth.userDetailsService(this.userDetailsServiceBean());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.antMatchers("/auth/**").permitAll()//.anyRequest().hasAnyRole("ANONYMOUS, USER")
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest().authenticated()
			.and()
				.httpBasic()
			.and()
				.csrf().disable();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

}
