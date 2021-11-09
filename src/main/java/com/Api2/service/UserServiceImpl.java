package com.Api2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api2.Entity.Users;
import com.Api2.exception.UserException;
import com.Api2.model.UserResponse;
import com.Api2.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

//	private static List<Users> list=new ArrayList<>();
//	static {
//		Users u=new Users();
//			u.setName("Anija");
//			u.setDob("25-02-1997");
//			u.setEmail("anijakjohn1@gmail.com");
//			u.setMobno("9497799593");
//			list.add(u);
//				}

	@Override
	public List<Users> getUsers() {
		return repo.findAll();
		// return list;
	}

	@Override
	public UserResponse saveUser(Users user) {
		try {

			return this.getResponse(repo.save(user), "The user was saved");
		} catch (Exception e) {

			return this.getResponse(null, "Email id already Present");

		}
	}

	public UserResponse getSingleUser(Long id) {
		Optional<Users> user = repo.findById(id);
		if (user.isPresent()) {
			return this.getResponse(user.get(), "User was found");
		}
		return this.getResponse(null, "User not found");

	}

	public UserResponse deleteUser(Long id) {
		Optional<Users> user = repo.findById(id);
		if (user.isPresent()) {
			repo.deleteById(id);
			return this.getResponse(null, "User was deleted");
		}

		return this.getResponse(null, "User was not found");
	}

	public UserResponse updateUser(Users user) {
		Optional<Users> optUserById = repo.findById(user.getId());
		if (optUserById.isEmpty()) {
			return this.getResponse(null, "User not found");
		}
		try {
			Users updatedUser = repo.save(user);
			return this.getResponse(updatedUser, "User Updated");
		} catch (Exception e) {
			return this.getResponse(null, "Email id already present");
		}

	}

	private UserResponse getResponse(Users user, String message) {

		UserResponse response = new UserResponse();
		response.setUser(user);
		response.setMessage(message);
		return response;
	}
}

//	@Override
//	public Users fetchUserByEmail(String tempEmail) {
//	return repo.findByEmailId(tempEmail);

//	}
//}
