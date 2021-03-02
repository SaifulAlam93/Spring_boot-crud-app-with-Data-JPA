package com.spring.crud.spring_boot_croud_with_JPA.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.crud.spring_boot_croud_with_JPA.exception.RecorceNotFoundException;
import com.spring.crud.spring_boot_croud_with_JPA.model.Employee;
import com.spring.crud.spring_boot_croud_with_JPA.repository.Repository;




@org.springframework.stereotype.Service
public class Service {
	
@Autowired
private Repository repository;

public List<Employee> getAll(){	
	return repository.findAll();
}


//public Employee getById(long id){	
//	return repository.getOne(id);
//}

public Employee getById(long id){	
	
	Optional<Employee> emp=repository.findById(id);
	if(emp.isPresent()) {
		return emp.get();
	}else {
		throw new RecorceNotFoundException("Record not found with this id ="+id); 

	}

}


public Employee getByName(String name){	
	Optional<Employee> emp=repository.findByName(name);
	return emp.get();
}


public Employee create(Employee employee){	
	return repository.save(employee);
}

public String createAll(List<Employee> employee){	
	 repository.saveAll(employee);
	 return "Data saved";
}

public Employee updateEmployee(Employee employee){	
	
	Optional<Employee> emp=repository.findById(employee.getId());
	if(emp.isPresent()) {
		repository.save(employee);
		return employee;
	}else {
		throw new RecorceNotFoundException("Record not found with this id ="+employee.getId()); 
	}
		
}

public String deleteEmp(long id) {
	
	
////	another Way
//	boolean tt=repository.existsById(id);
//	
//	if(!tt) {
//		throw new RecorceNotFoundException("Record not found with this id="+id);
//	}else {
//		repository.deleteById(id);
//	}
		
	
	Optional<Employee> emp=repository.findById(id);
	if(emp.isPresent()) {
		repository.delete(emp.get());
		return " Data Deleted.";
	}else {
		throw new RecorceNotFoundException("Record not found with this id ="+id); 
	}
	
	
}

@Transactional
public void updateEmployee_other(long id, String name, String mail) {
      Employee emp=repository.findById(id).orElseThrow(()-> new IllegalStateException("Employee with id "+ id+" doesn't exeist"));

if(name != null &&
name.length()>0 &&
!Objects.equals(emp.getName(), name)) {
	emp.setName(name);
}

if(mail != null &&
mail.length()>0 &&
!Objects.equals(emp.getMail(), mail)) {
	Optional<Employee> op_emp=repository.findBymail(mail);
	if(op_emp.isPresent()) {
		throw new  RecorceNotFoundException(mail+" Email is already exeist ="); 
	}
	emp.setMail(mail);
}





}



}
