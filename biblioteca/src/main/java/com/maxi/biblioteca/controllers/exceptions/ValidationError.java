package com.maxi.biblioteca.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> erros = new ArrayList<>();
	

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestemp, Integer status, String error) {
		super(timestemp, status, error);
		// TODO Auto-generated constructor stub
	}
	
	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addErros(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName,  message));
	}
	

}
