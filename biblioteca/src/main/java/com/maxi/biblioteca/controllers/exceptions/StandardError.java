package com.maxi.biblioteca.controllers.exceptions;

public class StandardError {
	
	private Long timestemp;
	private Integer status;
	private String error;
	
	public StandardError() {
	}

	public StandardError(Long timestemp, Integer status, String error) {
		super();
		this.timestemp = timestemp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Long timestemp) {
		this.timestemp = timestemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
}
