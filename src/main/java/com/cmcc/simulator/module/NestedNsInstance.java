package com.cmcc.simulator.module;

import java.util.List;

public class NestedNsInstance {

	private String nsInstanceId;
	private String nsInstanceName;
	private String nsInstanceDescription;
	private String nsdId;
	private List<NestedVnfInstance> nestedVnfInstanceList;
	private List<NestedPnfInfo> nestedPnfInfoList;
	private String[] nestedNsInstanceId;
	private String nsState;

	public NestedNsInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NestedNsInstance(String nsInstanceId, String nsInstanceName, String nsInstanceDescription, String nsdId,
			List<NestedVnfInstance> nestedVnfInstanceList, List<NestedPnfInfo> nestedPnfInfoList, String[]  nestedNsInstanceId,
			String nsState) {
		super();
		this.nsInstanceId = nsInstanceId;
		this.nsInstanceName = nsInstanceName;
		this.nsInstanceDescription = nsInstanceDescription;
		this.nsdId = nsdId;
		this.nestedVnfInstanceList = nestedVnfInstanceList;
		this.nestedPnfInfoList = nestedPnfInfoList;
		this.nestedNsInstanceId = nestedNsInstanceId;
		this.nsState = nsState;
	}

	public String getNsInstanceId() {
		return nsInstanceId;
	}

	public void setNsInstanceId(String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}

	public String getNsInstanceName() {
		return nsInstanceName;
	}

	public void setNsInstanceName(String nsInstanceName) {
		this.nsInstanceName = nsInstanceName;
	}

	public String getNsInstanceDescription() {
		return nsInstanceDescription;
	}

	public void setNsInstanceDescription(String nsInstanceDescription) {
		this.nsInstanceDescription = nsInstanceDescription;
	}

	public String getNsdId() {
		return nsdId;
	}

	public void setNsdId(String nsdId) {
		this.nsdId = nsdId;
	}

	public List<NestedVnfInstance> getNestedVnfInstanceList() {
		return nestedVnfInstanceList;
	}

	public void setNestedVnfInstanceList(List<NestedVnfInstance> nestedVnfInstanceList) {
		this.nestedVnfInstanceList = nestedVnfInstanceList;
	}

	public List<NestedPnfInfo> getNestedPnfInfoList() {
		return nestedPnfInfoList;
	}

	public void setNestedPnfInfoList(List<NestedPnfInfo> nestedPnfInfoList) {
		this.nestedPnfInfoList = nestedPnfInfoList;
	}

	public String[]  getNestedNsInstanceId() {
		return nestedNsInstanceId;
	}

	public void setNestedNsInstanceId(String[]  nestedNsInstanceId) {
		this.nestedNsInstanceId = nestedNsInstanceId;
	}

	public String getNsState() {
		return nsState;
	}

	public void setNsState(String nsState) {
		this.nsState = nsState;
	}

}
