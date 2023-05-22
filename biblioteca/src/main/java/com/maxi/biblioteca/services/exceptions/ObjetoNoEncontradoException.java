package com.maxi.biblioteca.services.exceptions;

public class ObjetoNoEncontradoException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public ObjetoNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNoEncontradoException(String message) {
		super(message);
	}
	
	

}
