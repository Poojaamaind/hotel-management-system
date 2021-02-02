package com.app.custom_excs;

@SuppressWarnings("serial")
public class AdminNotFoundException2 extends RuntimeException {
	public AdminNotFoundException2(String mesg) {
		super(mesg);
	}
}
