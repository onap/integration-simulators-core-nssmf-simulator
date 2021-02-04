package com.cmcc.simulator.authmodule;

/*
 * “accessToken”：”7512eb3feb5249eca5ddd742fedddd39”,
“expires”:1800

 * */

public class AuthResponse {

	private String accessToken;
	private int expires;

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String accessToken, int expires) {
		super();
		this.accessToken = accessToken;
		this.expires = expires;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpires() {
		return expires;
	}

	public void setExpires(int expires) {
		this.expires = expires;
	}

}
