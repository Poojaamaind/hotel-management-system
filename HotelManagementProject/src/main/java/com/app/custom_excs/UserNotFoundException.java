package com.app.custom_excs;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String mesg) {
		super(mesg);
	}
}
