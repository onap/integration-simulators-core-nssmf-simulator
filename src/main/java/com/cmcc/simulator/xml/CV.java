package com.cmcc.simulator.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class CV {

	private List<SN> sns;
	private String i;

	public CV() {
		super();
	}

	public CV(List<SN> sns, String i) {
		super();
		this.sns = sns;
		this.i = i;
	}

	public List<SN> getSns() {
		return sns;
	}

	public void setSns(List<SN> sns) {
		this.sns = sns;
	}

	@XmlAttribute(name = "i")
	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

}
