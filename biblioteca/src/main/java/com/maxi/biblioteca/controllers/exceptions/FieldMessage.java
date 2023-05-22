package com.maxi.biblioteca.controllers.exceptions;

public class FieldMessage extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String fileName;
	public FieldMessage(String message, String fileName) {
		super();
		this.message = message;
		this.fileName = fileName;
	}
	public FieldMessage() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
