package com.cmcc.simulator.module;

public class PerfReqEmbb {

	private int expDataRateDL;
	private int expDataRateUL;
	private int areaTrafficCapDL;
	private int areaTrafficCapUL;
	private int activityFactor;

	public PerfReqEmbb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfReqEmbb(int expDataRateDL, int expDataRateUL, int areaTrafficCapDL, int areaTrafficCapUL,
			int activityFactor) {
		super();
		this.expDataRateDL = expDataRateDL;
		this.expDataRateUL = expDataRateUL;
		this.areaTrafficCapDL = areaTrafficCapDL;
		this.areaTrafficCapUL = areaTrafficCapUL;
		this.activityFactor = activityFactor;
	}

	public int getExpDataRateDL() {
		return expDataRateDL;
	}

	public void setExpDataRateDL(int expDataRateDL) {
		this.expDataRateDL = expDataRateDL;
	}

	public int getExpDataRateUL() {
		return expDataRateUL;
	}

	public void setExpDataRateUL(int expDataRateUL) {
		this.expDataRateUL = expDataRateUL;
	}

	public int getAreaTrafficCapDL() {
		return areaTrafficCapDL;
	}

	public void setAreaTrafficCapDL(int areaTrafficCapDL) {
		this.areaTrafficCapDL = areaTrafficCapDL;
	}

	public int getAreaTrafficCapUL() {
		return areaTrafficCapUL;
	}

	public void setAreaTrafficCapUL(int areaTrafficCapUL) {
		this.areaTrafficCapUL = areaTrafficCapUL;
	}

	public int getActivityFactor() {
		return activityFactor;
	}

	public void setActivityFactor(int activityFactor) {
		this.activityFactor = activityFactor;
	}

}
