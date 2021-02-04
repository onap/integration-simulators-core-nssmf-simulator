package com.cmcc.simulator.authmodule;

/*
 * "grantType": "password", 
    "userName": "test", 
"value": "XXXXXX" 

 * */
public class AuthRequest {

	private String grantType;
	private String userName;
	private String value;

	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRequest(String grantType, String userName, String value) {
		super();
		this.grantType = grantType;
		this.userName = userName;
		this.value = value;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
