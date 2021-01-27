package com.cmcc.simulator.module;

public class PnfError {

	private String pnfId;
	private String pnfErrorDesc;

	public PnfError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PnfError(String pnfId, String pnfErrorDesc) {
		super();
		this.pnfId = pnfId;
		this.pnfErrorDesc = pnfErrorDesc;
	}

	public String getPnfId() {
		return pnfId;
	}

	public void setPnfId(String pnfId) {
		this.pnfId = pnfId;
	}

	public String getPnfErrorDesc() {
		return pnfErrorDesc;
	}

	public void setPnfErrorDesc(String pnfErrorDesc) {
		this.pnfErrorDesc = pnfErrorDesc;
	}

}
