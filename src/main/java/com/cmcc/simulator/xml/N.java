package com.cmcc.simulator.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class N {
	String i;
	String value;

	public N() {
		super();
		// TODO Auto-generated constructor stub
	}

	public N(String i, String value) {
		super();
		this.i = i;
		this.value = value;
	}

	@XmlAttribute(name = "i")
	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getValue() {
		return value;
	}

	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}
	
}
