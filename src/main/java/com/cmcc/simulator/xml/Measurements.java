package com.cmcc.simulator.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Measurements {

	String objectType;
	List<N> n;
	PmData pmData;
	public Measurements() {
		super();
	}

	public Measurements(String objectType, List<N> n, PmData pmData) {
		super();
		this.objectType = objectType;
		this.n = n;
		this.pmData = pmData;
	}

	@XmlElementWrapper(name = "PmName")
	@XmlElement(name = "N")
	public List<N> getN() {
		return n;
	}

	public void setN(List<N> n) {
		this.n = n;
	}

	@XmlElement(name = "ObjectType")
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	@XmlElement(name = "PmData")
	public PmData getPmData() {
		return pmData;
	}

	public void setPmData(PmData pmData) {
		this.pmData = pmData;
	}

}
