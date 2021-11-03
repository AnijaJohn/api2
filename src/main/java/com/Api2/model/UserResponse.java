package com.Api2.model;

import com.Api2.Entity.Users;

public class UserResponse {
	
	Users user;
	String message;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserResponse [user=" + user + ", message=" + message + "]";
	}
	
	
}