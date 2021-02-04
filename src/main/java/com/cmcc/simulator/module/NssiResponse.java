package com.cmcc.simulator.module;

public class NssiResponse {

	private String nssiId;
	private String jobId;

	public NssiResponse() {
		super();
	}

	public NssiResponse(String nssiId, String jobId) {
		super();
		this.nssiId = nssiId;
		this.jobId = jobId;
	}

	public String getNssiId() {
		return nssiId;
	}

	public void setNssiId(String nssiId) {
		this.nssiId = nssiId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
