package com.cmcc.simulator.module;

import java.util.List;

public class NetworkSliceSubnet {

	private String[] mfIdList;
	private NsInstanceInfo nsInfo;
	private List<SliceProfile> sliceProfileList;

	public NetworkSliceSubnet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetworkSliceSubnet(String[] mfIdList, NsInstanceInfo nsInfo, List<SliceProfile> sliceProfileList) {
		super();
		this.mfIdList = mfIdList;
		this.nsInfo = nsInfo;
		this.sliceProfileList = sliceProfileList;
	}

	public String[] getMfIdList() {
		return mfIdList;
	}

	public void setMfIdList(String[] mfIdList) {
		this.mfIdList = mfIdList;
	}

	public NsInstanceInfo getNsInfo() {
		return nsInfo;
	}

	public void setNsInfo(NsInstanceInfo nsInfo) {
		this.nsInfo = nsInfo;
	}

	public List<SliceProfile> getSliceProfileList() {
		return sliceProfileList;
	}

	public void setSliceProfileList(List<SliceProfile> sliceProfileList) {
		this.sliceProfileList = sliceProfileList;
	}

}
