package com.cmcc.simulator.module;

public class NsiInfo {

	private String nsiId;
	private String nsiName;

	public NsiInfo() {
		super();
	}

	public NsiInfo(String nsiId, String nsiName) {
		super();
		this.nsiId = nsiId;
		this.nsiName = nsiName;
	}

	public String getNsiId() {
		return nsiId;
	}

	public void setNsiId(String nsiId) {
		this.nsiId = nsiId;
	}

	public String getNsiName() {
		return nsiName;
	}

	public void setNsiName(String nsiName) {
		this.nsiName = nsiName;
	}

}
