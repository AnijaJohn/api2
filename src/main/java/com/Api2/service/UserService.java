package com.Api2.service;

import java.util.List;

import com.Api2.Entity.Users;
import com.Api2.model.UserResponse;

public interface UserService {
	List<Users> getUsers();

	Users saveUser(Users user);
	
	Users getSingleUser (Long id);
	
	void deleteUser(Long id);
	
	UserResponse updateUser(Users user);

//	Users fetchUserByEmail(String tempEmail);

	

}
