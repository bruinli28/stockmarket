package com.iiht.stock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iiht.stock.entity.UserEntity;

public interface UserService {

	public Page<UserEntity> findAll(int page, int pageSize);
	
	public List<UserEntity> findAllUsers();
	
	public UserEntity findUserById(Integer id);
	
	public UserEntity findUserByUserName(String userName);
	
	public UserEntity registUser(UserEntity user);
	
	public UserEntity updateUser(UserEntity user);
	
	public UserEntity activeUser(Integer id);
	
	public void delete(Integer id);
	
}
