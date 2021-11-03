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
public class UserServiceImpl implements UserService{
	
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
	public List<Users> getUsers(){
		return repo.findAll();
				//return list;
	}


	@Override
	public Users saveUser(Users user) {
		return repo.save(user);
	}
	

//	//find an Employee
//	@Override
//	public Users getSingleUser (Long id) {
//		// TODO Auto-generated method stub
//		Optional<Users> optionalEmployee = repo.findById(id);
//	return optionalEmployee.orElseThrow(()->
//			//new EmployeeException("Employee Not Found","Invalid Employee ID, check "+id));
//			new UserException("not fooound"));
//	}
	@Override
	public Users getSingleUser (Long id) {
		Optional<Users> user= repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("Employee is not found for the id" +id);
			
		}
//	@Override
//	public Users  deleteUser (Long id) {
//		return repo.deleteById(id);
//		
//	}
	public void deleteUser(Long id) {
		// return employeeRepository.deleteById(id).orElseThrow(());
		repo.findById(id).orElseThrow(
				//()-> new EmployeeException("Employee Not Found","Enter correct Employee ID "+id+ " is Invalid"));
				()-> new UserException("noot here"));
		repo.deleteById(id);
	}


	@Override
	public UserResponse updateUser(Users user) {
		Optional<Users> optUser=repo.findById(user.getId());
		if(!optUser.isPresent())
		{
			return this.getResponse(null,"User not found");
		}
		Users userInDb = optUser.get();
		System.out.println(userInDb.toString());
		Optional<Users> optUserByEmail =repo.findByEmail(user.getEmail());
		if(optUserByEmail.isEmpty() || user.getEmail().equals(optUserByEmail.get().getEmail()))
		{
			userInDb.setDob(user.getDob());
			userInDb.setEmail(user.getEmail());
			userInDb.setMobno(user.getMobno());
			userInDb.setName(user.getName());
			return this.getResponse( repo.save(userInDb),"User was updated");
		}
		
	
		return this.getResponse( null,"Email already exist");
		
	}


	private UserResponse getResponse(Users user, String message) {
		
		UserResponse response=new UserResponse();
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


