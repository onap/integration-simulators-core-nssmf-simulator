package com.cmcc.simulator.module;

public class VnfError {

	private String vnfInstanceId;
	private String vnfErrorDesc;

	public VnfError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VnfError(String vnfInstanceId, String vnfErrorDesc) {
		super();
		this.vnfInstanceId = vnfInstanceId;
		this.vnfErrorDesc = vnfErrorDesc;
	}

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public String getVnfErrorDesc() {
		return vnfErrorDesc;
	}

	public void setVnfErrorDesc(String vnfErrorDesc) {
		this.vnfErrorDesc = vnfErrorDesc;
	}

}
