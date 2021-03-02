package com.spring.crud.spring_boot_croud_with_JPA.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.spring_boot_croud_with_JPA.model.Employee;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByName(String name);

	Optional<Employee> findBymail(String mail);

}
