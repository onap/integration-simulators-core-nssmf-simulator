package com.cmcc.simulator.module;

public class JobInfo {
	private ResponseDescriptor responseDescriptor;

	public JobInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobInfo(ResponseDescriptor responseDescriptor) {
		super();
		this.responseDescriptor = responseDescriptor;
	}

	public ResponseDescriptor getResponseDescriptor() {
		return responseDescriptor;
	}

	public void setResponseDescriptor(ResponseDescriptor responseDescriptor) {
		this.responseDescriptor = responseDescriptor;
	}

}
