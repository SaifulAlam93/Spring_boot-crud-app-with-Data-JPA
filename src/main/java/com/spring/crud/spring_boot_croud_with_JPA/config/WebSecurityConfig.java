package com.spring.crud.spring_boot_croud_with_JPA.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.crud.spring_boot_croud_with_JPA.repository.UserRepository;


@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	public UserDetailsService  userditailservice;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
//	@Bean
//	public UserDetailsService  userditailservice() {
//		return new UsersDetailsServiceImp();
//	};
	
	 @Bean
     public BCryptPasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
     }
	 
	 
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authprovider= new DaoAuthenticationProvider();
		 authprovider.setUserDetailsService(userDetailsService());
		 authprovider.setPasswordEncoder(passwordEncoder());
		 
		return authprovider;
	 }

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    .authorizeRequests()                                                                
//	        .antMatchers("/resources/**", "/signup", "/about").permitAll()                  
//	        .antMatchers("/admin/**").hasRole("ADMIN")                                      
//	        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
	        .anyRequest().authenticated()                                                   
	        .and()
	    // ...
	    .formLogin().permitAll()
	    .and()
	    .logout().permitAll();
	};
	 

	 
}
