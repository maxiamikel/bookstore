package com.maxi.biblioteca.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maxi.biblioteca.services.exceptions.DataIntegrityViolationExceptions;
import com.maxi.biblioteca.services.exceptions.ObjetoNoEncontradoException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjetoNoEncontradoException.class)
	public ResponseEntity<StandardError> erroNoEncontrado(ObjetoNoEncontradoException e,  ServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationExceptions.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationExceptions e,  ServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e,  ServletRequest request){
		ValidationError erro = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos de entrados");
		
		for(FieldError x: e.getBindingResult().getFieldErrors()) {
			erro.addErros(x.getField(), x.getObjectName());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
