package com.cmcc.simulator.module;

public class NestedPnfInfo {

	private String pnfId;
	private String pnfName;
	private String pnfdId;

	public NestedPnfInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NestedPnfInfo(String pnfId, String pnfName, String pnfdId) {
		super();
		this.pnfId = pnfId;
		this.pnfName = pnfName;
		this.pnfdId = pnfdId;
	}

	public String getPnfId() {
		return pnfId;
	}

	public void setPnfId(String pnfId) {
		this.pnfId = pnfId;
	}

	public String getPnfName() {
		return pnfName;
	}

	public void setPnfName(String pnfName) {
		this.pnfName = pnfName;
	}

	public String getPnfdId() {
		return pnfdId;
	}

	public void setPnfdId(String pnfdId) {
		this.pnfdId = pnfdId;
	}

}
