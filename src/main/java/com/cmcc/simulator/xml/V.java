package com.cmcc.simulator.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class V {
	String v;
	int value;

	public V() {
		super();
	}

	public V(String i, int value) {
		super();
		this.v = i;
		this.value = value;
	}

	@XmlAttribute(name = "i")
	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public int getValue() {
		return value;
	}

	@XmlValue
	public void setValue(int value) {
		this.value = value;
	}
	
}
