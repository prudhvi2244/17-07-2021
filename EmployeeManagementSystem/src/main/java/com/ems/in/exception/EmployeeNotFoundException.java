package com.ems.in.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private String msg;

	public EmployeeNotFoundException(String msg) {
		super(msg);
		this.msg = msg;

	}

}
