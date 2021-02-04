package com.cmcc.simulator.module;

public class VnfInstance {

	private String vnfInstanceId;
	private String vnfInstanceName;
	private String vnfdId;
	private String instantiationState;

	public VnfInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VnfInstance(String vnfInstanceId, String vnfInstanceName, String vnfdId, String instantiationState) {
		super();
		this.vnfInstanceId = vnfInstanceId;
		this.vnfInstanceName = vnfInstanceName;
		this.vnfdId = vnfdId;
		this.instantiationState = instantiationState;
	}

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	public void setVnfInstanceName(String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public String getInstantiationState() {
		return instantiationState;
	}

	public void setInstantiationState(String instantiationState) {
		this.instantiationState = instantiationState;
	}

}
