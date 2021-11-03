package com.Api2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Api2.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

	Optional<Users> findByEmail(String tempEmail);
	
	

}
