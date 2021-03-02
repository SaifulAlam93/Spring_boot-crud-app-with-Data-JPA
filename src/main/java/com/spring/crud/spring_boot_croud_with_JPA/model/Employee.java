package com.spring.crud.spring_boot_croud_with_JPA.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "Employee")
public class Employee {
	
	
	@Id
	@SequenceGenerator(name = "employee_sequence",
    sequenceName =  "employee_sequence",
    allocationSize = 1
   )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE ,
			generator = "employee_sequence"
			)
	private long id;
	private String name;
	private LocalDate date;
	
	@Transient
	private Integer age;
	private String mail;
	private String address;
	
	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Integer getAge() {
		return Period.between(this.date, LocalDate.now()).getYears();
	}


	public void setAge(Integer age) {
		this.age = Period.between(this.date, LocalDate.now()).getYears();
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Employee() {
		super();
	}


	public Employee(String name, LocalDate date, Integer age, String mail, String address) {
		super();
		this.name = name;
		this.date = date;
		this.age = age;
		this.mail = mail;
		this.address = address;
	}




	public Employee(long id, String name, LocalDate date, Integer age, String mail, String address) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.age = age;
		this.mail = mail;
		this.address = address;
	}
	
	
	

}
