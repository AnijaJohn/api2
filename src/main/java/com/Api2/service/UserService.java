package com.Api2.service;

import java.util.List;

import com.Api2.Entity.Users;
import com.Api2.model.UserResponse;

public interface UserService {
	List<Users> getUsers();

	UserResponse saveUser(Users user);
	
	UserResponse getSingleUser (Long id);
	
	UserResponse deleteUser(Long id);
	
	UserResponse updateUser(Users user);

//	Users fetchUserByEmail(String tempEmail);

	

}
