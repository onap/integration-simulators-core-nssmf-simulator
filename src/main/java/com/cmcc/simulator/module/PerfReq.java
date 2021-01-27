package com.cmcc.simulator.module;

import java.util.List;

public class PerfReq {

	private List<PerfReqEmbb> perfReqEmbbList;
	private List<PerfReqUrllc> perfReqUrllcList;

	public PerfReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfReq(List<PerfReqEmbb> perfReqEmbbList, List<PerfReqUrllc> perfReqUrllcList) {
		super();
		this.perfReqEmbbList = perfReqEmbbList;
		this.perfReqUrllcList = perfReqUrllcList;
	}

	public List<PerfReqEmbb> getPerfReqEmbbList() {
		return perfReqEmbbList;
	}

	public void setPerfReqEmbbList(List<PerfReqEmbb> perfReqEmbbList) {
		this.perfReqEmbbList = perfReqEmbbList;
	}

	public List<PerfReqUrllc> getPerfReqUrllcList() {
		return perfReqUrllcList;
	}

	public void setPerfReqUrllcList(List<PerfReqUrllc> perfReqUrllcList) {
		this.perfReqUrllcList = perfReqUrllcList;
	}

}
