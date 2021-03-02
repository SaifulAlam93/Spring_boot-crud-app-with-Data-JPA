package com.spring.crud.spring_boot_croud_with_JPA.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.crud.spring_boot_croud_with_JPA.model.Users;
import com.spring.crud.spring_boot_croud_with_JPA.repository.UserRepository;

public class UsersDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Users user=repository.getUsersByName(username);
         
         
         if(user==null) {
        	 throw new UsernameNotFoundException("Could not find the User by "+username);
         }
         return new MyUserDetails(user);
	}

}
