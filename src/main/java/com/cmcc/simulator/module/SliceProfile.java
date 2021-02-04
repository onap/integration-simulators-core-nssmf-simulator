package com.cmcc.simulator.module;

public class SliceProfile {
	private String[] snssaiList;
	private String sliceProfileId;
	private String[] plmnIdList;
	private PerfReq perfReq;

	private int maxNumberofUEs;
	private int maxNumberofPDUSession;
	private int totalDataVolume;
	private String upfDeployLocation;
	private String[] coverageAreaTAList;
	private int latency;
	private String ueMobilityLevel;
	private String resourceSharingLevel;

	private int terminateNssiOption = 0;
	private String scriptName = "CN1";

	private String nssiId;

	public SliceProfile() {
		super();
	}

	public SliceProfile(String[] snssaiList, String sliceProfileId, String[] plmnIdList, PerfReq perfReq,
			int maxNumberofUEs, int maxNumberofPDUSession, int totalDataVolume, String upfDeployLocation,
			String[] coverageAreaTAList, int latency, String ueMobilityLevel, String resourceSharingLevel,
			int terminateNssiOption, String scriptName) {
		super();
		this.snssaiList = snssaiList;
		this.sliceProfileId = sliceProfileId;
		this.plmnIdList = plmnIdList;
		this.perfReq = perfReq;
		this.maxNumberofUEs = maxNumberofUEs;
		this.maxNumberofPDUSession = maxNumberofPDUSession;
		this.totalDataVolume = totalDataVolume;
		this.upfDeployLocation = upfDeployLocation;
		this.coverageAreaTAList = coverageAreaTAList;
		this.latency = latency;
		this.ueMobilityLevel = ueMobilityLevel;
		this.resourceSharingLevel = resourceSharingLevel;
		this.scriptName = scriptName;
		this.terminateNssiOption = terminateNssiOption;
	}

	public String[] getSnssaiList() {
		return snssaiList;
	}

	public void setSnssaiList(String[] snssaiList) {
		this.snssaiList = snssaiList;
	}

	public String getSliceProfileId() {
		return sliceProfileId;
	}

	public void setSliceProfileId(String sliceProfileId) {
		this.sliceProfileId = sliceProfileId;
	}

	public String[] getPlmnIdList() {
		return plmnIdList;
	}

	public void setPlmnIdList(String[] plmnIdList) {
		this.plmnIdList = plmnIdList;
	}

	public PerfReq getPerfReq() {
		return perfReq;
	}

	public void setPerfReq(PerfReq perfReq) {
		this.perfReq = perfReq;
	}

	public int getMaxNumberofUEs() {
		return maxNumberofUEs;
	}

	public void setMaxNumberofUEs(int maxNumberofUEs) {
		this.maxNumberofUEs = maxNumberofUEs;
	}

	public int getMaxNumberofPDUSession() {
		return maxNumberofPDUSession;
	}

	public void setMaxNumberofPDUSession(int maxNumberofPDUSession) {
		this.maxNumberofPDUSession = maxNumberofPDUSession;
	}

	public int getTotalDataVolume() {
		return totalDataVolume;
	}

	public void setTotalDataVolume(int totalDataVolume) {
		this.totalDataVolume = totalDataVolume;
	}

	public String getUpfDeployLocation() {
		return upfDeployLocation;
	}

	public void setUpfDeployLocation(String upfDeployLocation) {
		this.upfDeployLocation = upfDeployLocation;
	}

	public String[] getCoverageAreaTAList() {
		return coverageAreaTAList;
	}

	public void setCoverageAreaTAList(String[] coverageAreaTAList) {
		this.coverageAreaTAList = coverageAreaTAList;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public String getUeMobilityLevel() {
		return ueMobilityLevel;
	}

	public void setUeMobilityLevel(String ueMobilityLevel) {
		this.ueMobilityLevel = ueMobilityLevel;
	}

	public String getResourceSharingLevel() {
		return resourceSharingLevel;
	}

	public void setResourceSharingLevel(String resourceSharingLevel) {
		this.resourceSharingLevel = resourceSharingLevel;
	}

	public String getNssiId() {
		return nssiId;
	}

	public void setNssiId(String nssiId) {
		this.nssiId = nssiId;
	}

	public int getTerminateNssiOption() {
		return terminateNssiOption;
	}

	public void setTerminateNssiOption(int terminateNssiOption) {
		this.terminateNssiOption = terminateNssiOption;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

}
