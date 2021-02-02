package com.app.custom_excs;

@SuppressWarnings("serial")
public class StaffNotFoundException3 extends RuntimeException {
	public StaffNotFoundException3(String mesg) {
		super(mesg);
	}
}
