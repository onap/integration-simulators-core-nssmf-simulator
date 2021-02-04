package com.cmcc.simulator.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Instance {
	List<V> vs;
	List<CV> cvs;

	public Instance() {
		super();
	}

	public Instance(List<V> vs, List<CV> cvs) {
		super();
		this.vs = vs;
		this.cvs = cvs;
	}

	@XmlElement(name="V") 
	public List<V> getVs() {
		return vs;
	}

	public void setVs(List<V> vs) {
		this.vs = vs;
	}

	@XmlElement(name="CV") 
	public List<CV> getCvs() {
		return cvs;
	}

	public void setCvs(List<CV> cvs) {
		this.cvs = cvs;
	}

}
