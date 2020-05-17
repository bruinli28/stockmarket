package com.iiht.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.UserEntity;
import com.iiht.stock.entity.UserModel;
import com.iiht.stock.exception.StockEXConstants;
import com.iiht.stock.exception.StockRequestException;
import com.iiht.stock.service.UserService;

/**
 * 
 * ClassName: UserController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2020年5月12日 下午7:33:18 <br/>  
 *  
 * @author bruin.li  
 * @version   
 * @since JDK 1.6
 */
@RestController
@RequestMapping("/api/user")
// @CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<UserEntity> findAllUsers() {

		return userService.findAllUsers();
	}

	@PostMapping
	public ResponseEntity<UserEntity> regist(@RequestBody @Valid UserModel user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		
		UserEntity existedUser = userService.findUserByUserName(user.getUserName());
		if(existedUser != null){
			bindingResult.rejectValue("userName", "400001", "the user name is existed.");
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		
		UserEntity userEntity = userService.registUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
	}

	@PutMapping
	public ResponseEntity<UserEntity> update(UserEntity user) {
		UserEntity userEntity = userService.updateUser(user);
		return ResponseEntity.ok(userEntity);
	}

	@GetMapping("/active/{id}")
	public ResponseEntity<UserEntity> active(@PathVariable Integer id) {
		UserEntity user = userService.activeUser(id);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		userService.delete(id);
		return ResponseEntity.ok("Delete user successfully.");
	}
}
