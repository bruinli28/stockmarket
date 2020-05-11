package com.iiht.stock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iiht.stock.entity.UserEntity;

public interface UserService {

	/**
	 * 分页查询用户列表
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<UserEntity> findAll(int page, int pageSize);
	
	/**
	 * 查询所有用户列表
	 * 
	 * @return
	 */
	public List<UserEntity> findAllUsers();
	
	/**
	 * 根据ID查询一个用户
	 * 
	 * @param 
	 * @return
	 */
	public UserEntity findUserById(Integer id);
	
	/**
	 * 注册一个用户
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity registUser(UserEntity user);
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity updateUser(UserEntity user);
	
	/**
	 * 激活用户
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity activeUser(Integer id);
	
	/**
	 * 删除一个用户
	 * 
	 * @param id
	 */
	public void delete(Integer id);
}
