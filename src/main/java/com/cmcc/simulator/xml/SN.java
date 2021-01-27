package com.cmcc.simulator.xml;

import javax.xml.bind.annotation.XmlElement;

public class SN {

	private String sn;
	private int sv;

	public SN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SN(String sn, int sv) {
		super();
		this.sn = sn;
		this.sv = sv;
	}

	@XmlElement(name = "SN")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@XmlElement(name = "SV")
	public int getSv() {
		return sv;
	}

	public void setSv(int sv) {
		this.sv = sv;
	}

}
