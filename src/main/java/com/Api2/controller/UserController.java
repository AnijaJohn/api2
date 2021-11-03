package com.Api2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Api2.Entity.Users;
import com.Api2.model.UserResponse;
import com.Api2.service.UserService;

@RestController

public class UserController {

//	
	@Autowired
	private UserService service;
//	
//	@GetMapping("/users")
//	public List<Users>getUsers()
//	{
//		
//		return service.getUsers();
//		
//	}

//	@GetMapping("/users")
//	public Users getUsers(@RequestBody Users user)throws Exception {
//		
//		String tempEmail=user.getEmail();
//		if(tempEmail!=null && ! "".equals(tempEmail)) {
//			Users userobj=service.fetchUserByEmail(tempEmail);
//			if(userobj!=null) {
//				throw new Exception("Use with" +tempEmail+ " is already exist");
//			}
//		}
//		Users userobj=null;
//		userobj=service.saveUser(user);
//		return userobj;
//	
//		}

	@GetMapping("/users")
	public ResponseEntity<List<Users>> getUsers() {

		List<Users> user = service.getUsers();
		return new ResponseEntity<List<Users>>(user, HttpStatus.OK);
	}
//	
//	@GetMapping("/users/{id}")
//	public Users getUsers(@PathVariable Long id){
//		return service.getSingleUser(id);
//		
//	}

	@GetMapping("users/{id}")
	public ResponseEntity<Users> getUser(@PathVariable Long id) {
		Users user = service.getSingleUser(id);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

//	@PostMapping("/users")
//	public Users saveUsers(@RequestBody Users user)
//	{
//		return service.saveUser(user);
//	}
	@PostMapping("/users")
	public ResponseEntity<Users> save(@RequestBody Users user) {
		Users b = service.saveUser(user);
		return new ResponseEntity<Users>(b, HttpStatus.OK);
	}

//	@PutMapping("/users/{id}")
//	public Users updateUsers(@PathVariable Long id,@RequestBody Users user) {
//		user.setId(id);
//		return service.updateUser(user);
//	}
//	
	@PutMapping("/users/update")
	public ResponseEntity<UserResponse> update(@RequestBody Users user) {

		return new ResponseEntity<UserResponse>(service.updateUser(user), HttpStatus.OK);
	}

//@DeleteMapping("/users")
//public void deleteUser(@RequestParam Long id) {
//	service.deleteUser(id);
//}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	}

}
