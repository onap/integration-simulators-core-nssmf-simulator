package com.cmcc.simulator.module;

public class Nssi {

	private String nsstId;

	private String nssiName;
	private String flavorId;
	private String scriptName;
	private String extension;

	private String nssiId;
	private String nssiDesc;
	private SliceProfile sliceProfile;
	private NsiInfo nsiInfo;

	private int terminateNssiOption;

	private String nssiState;
	private NetworkSliceSubnet networkSliceSubnet;

	private String snssai;
	private NewNsst newNsst;
	private String jobId;

	public Nssi() {
	}

	public Nssi(String nsstId, String nssiName, String flavorId, String scriptName, String extension, String nssiId,
			String nssiDesc, SliceProfile sliceProfile, NsiInfo nsiInfo, int terminateNssiOption, String nssiState,
			NetworkSliceSubnet networkSliceSubnet) {
		super();
		this.nsstId = nsstId;
		this.nssiName = nssiName;
		this.flavorId = flavorId;
		this.scriptName = scriptName;
		this.extension = extension;
		this.nssiId = nssiId;
		this.nssiDesc = nssiDesc;
		this.sliceProfile = sliceProfile;
		this.nsiInfo = nsiInfo;
		this.terminateNssiOption = terminateNssiOption;
		this.nssiState = nssiState;
		this.networkSliceSubnet = networkSliceSubnet;
	}

	public String getNsstId() {
		return nsstId;
	}

	public void setNsstId(String nsstId) {
		this.nsstId = nsstId;
	}

	public String getNssiName() {
		return nssiName;
	}

	public void setNssiName(String nssiName) {
		this.nssiName = nssiName;
	}

	public String getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(String flavorId) {
		this.flavorId = flavorId;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNssiId() {
		return nssiId;
	}

	public void setNssiId(String nssiId) {
		this.nssiId = nssiId;
	}

	public String getNssiDesc() {
		return nssiDesc;
	}

	public void setNssiDesc(String nssiDesc) {
		this.nssiDesc = nssiDesc;
	}

	public SliceProfile getSliceProfile() {
		return sliceProfile;
	}

	public void setSliceProfile(SliceProfile sliceProfile) {
		this.sliceProfile = sliceProfile;
	}

	public NsiInfo getNsiInfo() {
		return nsiInfo;
	}

	public void setNsiInfo(NsiInfo nsiInfo) {
		this.nsiInfo = nsiInfo;
	}

	public int getTerminateNssiOption() {
		return terminateNssiOption;
	}

	public void setTerminateNssiOption(int terminateNssiOption) {
		this.terminateNssiOption = terminateNssiOption;
	}

	public String getNssiState() {
		return nssiState;
	}

	public void setNssiState(String nssiState) {
		this.nssiState = nssiState;
	}

	public NetworkSliceSubnet getNetworkSliceSubnet() {
		return networkSliceSubnet;
	}

	public void setNetworkSliceSubnet(NetworkSliceSubnet networkSliceSubnet) {
		this.networkSliceSubnet = networkSliceSubnet;
	}

	public String getSnssai() {
		return snssai;
	}

	public void setSnssai(String snssai) {
		this.snssai = snssai;
	}

	public NewNsst getNewNsst() {
		return newNsst;
	}

	public void setNewNsst(NewNsst newNsst) {
		this.newNsst = newNsst;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


}
