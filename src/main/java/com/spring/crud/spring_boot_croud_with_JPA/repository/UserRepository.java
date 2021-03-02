package com.spring.crud.spring_boot_croud_with_JPA.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.crud.spring_boot_croud_with_JPA.model.Users;

public interface UserRepository extends CrudRepository<Users, Long>{
	
	@Query("SELECT u FROM Users u WHERE u.username = :username")
	public Users getUsersByName(@Param("username") String username);
	

}
