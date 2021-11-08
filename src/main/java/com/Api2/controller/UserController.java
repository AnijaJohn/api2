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
import com.Api2.model.UserRequest;
import com.Api2.model.UserResponse;
import com.Api2.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public ResponseEntity<List<Users>> getUsers() {

		List<Users> user = service.getUsers();
		return new ResponseEntity<List<Users>>(user, HttpStatus.OK);
	}

	@GetMapping("users/{id}")
	public ResponseEntity<Users> getUser(@PathVariable Long id) {
		Users user = service.getSingleUser(id);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Users> save(@RequestBody UserRequest req) {
		Users b = service.saveUser(this.requestToUserForSave(req));
		return new ResponseEntity<Users>(b, HttpStatus.OK);
	}

	private Users requestToUserForSave(UserRequest req) {
		Users user = new Users();
		user.setName(req.getRname());
		user.setDob(req.getRdob());
		user.setEmail(req.getRemail());
		user.setMobno(req.getRmobno());
		return user;

	}

	@PutMapping("/users/update")
	public ResponseEntity<UserResponse> update(@RequestBody UserRequest req) {

		return new ResponseEntity<UserResponse>(service.updateUser(this.requestToUser(req)), HttpStatus.OK);
	}

	private Users requestToUser(UserRequest req) {
		Users user = new Users();
		user.setId(req.getRid());
		user.setName(req.getRname());
		user.setDob(req.getRdob());
		user.setEmail(req.getRemail());
		user.setMobno(req.getRmobno());
		return user;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	}

}
