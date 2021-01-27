package com.cmcc.simulator.module;

public class PerfReqUrllc {

	private int e2eLatency;
	private int jitter;
	private int survivalTime;
	private int csAvailability;
	private int reliability;
	private int expDataRate;
	private int payloadSize;
	private int trafficDensity;
	private int connDensity;
	private int serviceAreaDimension;

	public PerfReqUrllc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfReqUrllc(int e2eLatency, int jitter, int survivalTime, int csAvailability, int reliability,
			int expDataRate, int payloadSize, int trafficDensity, int connDensity, int serviceAreaDimension) {
		super();
		this.e2eLatency = e2eLatency;
		this.jitter = jitter;
		this.survivalTime = survivalTime;
		this.csAvailability = csAvailability;
		this.reliability = reliability;
		this.expDataRate = expDataRate;
		this.payloadSize = payloadSize;
		this.trafficDensity = trafficDensity;
		this.connDensity = connDensity;
		this.serviceAreaDimension = serviceAreaDimension;
	}

	public int getE2eLatency() {
		return e2eLatency;
	}

	public void setE2eLatency(int e2eLatency) {
		this.e2eLatency = e2eLatency;
	}

	public int getJitter() {
		return jitter;
	}

	public void setJitter(int jitter) {
		this.jitter = jitter;
	}

	public int getSurvivalTime() {
		return survivalTime;
	}

	public void setSurvivalTime(int survivalTime) {
		this.survivalTime = survivalTime;
	}

	public int getCsAvailability() {
		return csAvailability;
	}

	public void setCsAvailability(int csAvailability) {
		this.csAvailability = csAvailability;
	}

	public int getReliability() {
		return reliability;
	}

	public void setReliability(int reliability) {
		this.reliability = reliability;
	}

	public int getExpDataRate() {
		return expDataRate;
	}

	public void setExpDataRate(int expDataRate) {
		this.expDataRate = expDataRate;
	}

	public int getPayloadSize() {
		return payloadSize;
	}

	public void setPayloadSize(int payloadSize) {
		this.payloadSize = payloadSize;
	}

	public int getTrafficDensity() {
		return trafficDensity;
	}

	public void setTrafficDensity(int trafficDensity) {
		this.trafficDensity = trafficDensity;
	}

	public int getConnDensity() {
		return connDensity;
	}

	public void setConnDensity(int connDensity) {
		this.connDensity = connDensity;
	}

	public int getServiceAreaDimension() {
		return serviceAreaDimension;
	}

	public void setServiceAreaDimension(int serviceAreaDimension) {
		this.serviceAreaDimension = serviceAreaDimension;
	}

}
