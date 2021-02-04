package com.cmcc.simulator.module;

import java.util.List;

public class NsInstanceInfo {

	private String nsInstanceId;
	private String nsInstanceName;
	private String nsState;
	private String nsInstanceDescription;
	private String nsdId;
	private String flavorId;
	private List<VnfInstance> vnfInstance; // 企标样例和参数定义不一致，以样例为准
	private List<PnfInfo> pnfInfo; // 企标样例和参数定义不一致，以样例为准
	private List<NestedNsInstance> nestedNsInstance;

	public NsInstanceInfo() {
		super();
	}

	public NsInstanceInfo(String nsInstanceId, String nsInstanceName, String nsState, String nsInstanceDescription,
			String nsdId, String flavorId, List<VnfInstance> vnfInstanceList, List<PnfInfo> pnfInfoList,
			List<NestedNsInstance> nestedNsInstance) {
		super();
		this.nsInstanceId = nsInstanceId;
		this.nsInstanceName = nsInstanceName;
		this.nsState = nsState;
		this.nsInstanceDescription = nsInstanceDescription;
		this.nsdId = nsdId;
		this.flavorId = flavorId;
		this.vnfInstance = vnfInstanceList;
		this.pnfInfo = pnfInfoList;
		this.nestedNsInstance = nestedNsInstance;
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

	public String getNsState() {
		return nsState;
	}

	public void setNsState(String nsState) {
		this.nsState = nsState;
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

	public String getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

	public List<VnfInstance> getVnfInstance() {
		return vnfInstance;
	}

	public void setVnfInstance(List<VnfInstance> vnfInstanceList) {
		this.vnfInstance = vnfInstanceList;
	}

	public List<PnfInfo> getPnfInfo() {
		return pnfInfo;
	}

	public void setPnfInfo(List<PnfInfo> pnfInfoList) {
		this.pnfInfo = pnfInfoList;
	}

	public List<NestedNsInstance> getNestedNsInstance() {
		return nestedNsInstance;
	}

	public void setNestedNsInstance(List<NestedNsInstance> nestedNsInstance) {
		this.nestedNsInstance = nestedNsInstance;
	}

}
