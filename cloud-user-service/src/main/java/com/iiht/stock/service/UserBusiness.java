package com.iiht.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iiht.stock.entity.CompanyEntity;
import com.iiht.stock.entity.UserEntity;
import com.iiht.stock.exception.StockBusinessException;
import com.iiht.stock.repository.UserRepository;
import com.iiht.stock.result.CommonResult;

@Service
public class UserBusiness implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	final String SERVICE_NAME = "cloud-company-service";
	
	public Page<UserEntity> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public UserEntity findUserByUserName(String userName){
		return userRepository.findByUserName(userName);
	}
	
	public List<UserEntity> findAllUsers(){
		CommonResult<CompanyEntity> result = restTemplate.getForObject("http://cloud-company-service/api/company/1", CommonResult.class);
		System.out.println("entity name: " + result.getResultBody().getName());
		
		return userRepository.findAll();
	}
	

	public UserEntity registUser(UserEntity user){
		throw new StockBusinessException("500001", "Failed to regist user.");
//		return userRepository.saveAndFlush(user);
	}


	/**
	 * 
	 * 创建或者更新一个用户
	 *  
	 * @author bruin.li  
	 * @param user
	 * @return  
	 * @since JDK 1.6
	 */
	public UserEntity createUser(UserEntity user) {
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
