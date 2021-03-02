package com.spring.crud.spring_boot_croud_with_JPA.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class RecorceNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;


	public RecorceNotFoundException(String massege) {
		   super(massege);
	};
	
	
	public RecorceNotFoundException(String massege, Throwable throwable) {
		   super(massege,throwable);
	};
}
