package com.cmcc.simulator.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class PmData {

	List<Instance> objects;

	public PmData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PmData(List<Instance> objects) {
		super();
		this.objects = objects;
	}

	@XmlElement(name="Object") 
	public List<Instance> getObjects() {
		return objects;
	}

	public void setObjects(List<Instance> objects) {
		this.objects = objects;
	}

}
