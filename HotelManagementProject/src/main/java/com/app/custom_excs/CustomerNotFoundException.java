package com.app.custom_excs;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String mesg) {
		super(mesg);
	}
}
