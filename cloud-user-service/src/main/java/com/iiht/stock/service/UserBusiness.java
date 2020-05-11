package com.iiht.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.UserEntity;
import com.iiht.stock.repository.UserRepository;

@Service
public class UserBusiness implements UserService{
	@Autowired
	private UserRepository userRepository;

	public Page<UserEntity> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public List<UserEntity> findAllUsers(){
		return userRepository.findAll();
	}
	
	/**
	 * ����һ��USER��
	 */
	public UserEntity registUser(UserEntity user){
		return userRepository.saveAndFlush(user);
	}

	/**
	 * ����USER��Ϣ��JPA����ID�������޸ģ�
	 */
	public UserEntity update(UserEntity user) {
		return userRepository.save(user);
	}


	public UserEntity updateUser(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity activeUser(Integer id) {
		int flag = userRepository.activeUser(id);
		return userRepository.findById(id);
	}

	public void delete(Integer id) {
		userRepository.delete(id);
	}
}
