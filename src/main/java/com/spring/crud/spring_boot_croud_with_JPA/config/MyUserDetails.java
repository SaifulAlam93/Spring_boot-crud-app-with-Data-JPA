package com.spring.crud.spring_boot_croud_with_JPA.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.crud.spring_boot_croud_with_JPA.model.Users;

public class MyUserDetails implements UserDetails {

	private Users users;
	
	public MyUserDetails(Users users) {
		this.users = users;
	}

	public MyUserDetails() {
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority= new SimpleGrantedAuthority(users.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
