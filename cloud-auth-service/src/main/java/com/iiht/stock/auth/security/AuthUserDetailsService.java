package com.iiht.stock.auth.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iiht.stock.auth.entity.UserEntity;
import com.iiht.stock.auth.repository.UserRepository;

public class AuthUserDetailsService implements UserDetailsService{
	private UserRepository userRepository;
	
	public AuthUserDetailsService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findUserByUserName(username);
		if(user != null){
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			return new User(user.getUserName(), user.getPassword(), authorities);
		}
		
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

}
