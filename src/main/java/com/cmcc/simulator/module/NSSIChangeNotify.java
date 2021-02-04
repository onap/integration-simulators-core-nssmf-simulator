package com.cmcc.simulator.module;

public class NSSIChangeNotify {

	private String[] changedNssiList;

	public NSSIChangeNotify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NSSIChangeNotify(String[] changedNssiList) {
		super();
		this.changedNssiList = changedNssiList;
	}

	public String[] getChangedNssiList() {
		return changedNssiList;
	}

	public void setChangedNssiList(String[] changedNssiList) {
		this.changedNssiList = changedNssiList;
	}

}
