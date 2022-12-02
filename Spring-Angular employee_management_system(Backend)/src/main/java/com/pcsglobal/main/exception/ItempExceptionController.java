package com.pcsglobal.main.exception;


	
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class ItempExceptionController {
		
		@ExceptionHandler(value= ItempNotFoundException.class)
		
		public ResponseEntity<Object> exception(ItempNotFoundException exception){
			return new  ResponseEntity<>("It employee record not found .. try again" ,HttpStatus.NOT_FOUND); //response Entity is collection object that here can out any msg.
			
			
		}

	}



