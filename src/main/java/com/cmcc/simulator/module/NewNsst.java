package com.cmcc.simulator.module;

public class NewNsst {

	private String nsstId;
	private String flavorId;

	public NewNsst() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewNsst(String nsstId, String flavorId) {
		super();
		this.nsstId = nsstId;
		this.flavorId = flavorId;
	}

	public String getNsstId() {
		return nsstId;
	}

	public void setNsstId(String nsstId) {
		this.nsstId = nsstId;
	}

	public String getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

}
