package com.cts.swrbd.model;

import java.io.Serializable;

public class AppSecurityToken implements Serializable{
	private static final long serialVersionUID = -52323502552262323L;
	private final String jwttoken;
	
	public AppSecurityToken(String jwttoken) {
		this.jwttoken= jwttoken;
		
	}
	public String getToken() {
		return this.jwttoken;
	}

}
