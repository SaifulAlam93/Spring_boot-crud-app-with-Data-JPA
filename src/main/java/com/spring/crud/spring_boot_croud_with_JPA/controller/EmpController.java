package com.spring.crud.spring_boot_croud_with_JPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.spring_boot_croud_with_JPA.model.Employee;
import com.spring.crud.spring_boot_croud_with_JPA.service.Service;

@RestController
@RequestMapping(path="emp")
public class EmpController {
	
	
	
	@Autowired
	private Service service;
	
	@GetMapping("employee")
	public List<Employee> getall() {
		return service.getAll();
	}
	
	@GetMapping("employeebyid/{id}")
	public Employee getByID(@PathVariable long id) {
		return service.getById(id);
	}
	
	@GetMapping("employee/{name}")
	public Employee getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@PostMapping("employee")
	public Employee create(@RequestBody Employee emp) {
		return service.create(emp);
	}
	
	@PostMapping("multipleemployee")
	public String createAll(@RequestBody List<Employee> emp) {
		return service.createAll(emp);
	}
	
	@PutMapping("employee")
	public Employee update(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}
	
	
	@PutMapping("employeeall")
	public void updateEmployee(@PathVariable long id, 
			                       @RequestParam(required=false) String name,
			                       @RequestParam(required=false) String mail) {
		 service.updateEmployee_other(id,name,mail);
	}
	
	@DeleteMapping("employee/{id}")
	public String delete(@PathVariable long id) {
		return service.deleteEmp(id);
	}

}
