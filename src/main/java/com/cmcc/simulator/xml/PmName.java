package com.cmcc.simulator.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class PmName {

	List<N> ns;

	@XmlElement(name = "N")
	public List<N> getNs() {
		return ns;
	}

	public void setNs(List<N> ns) {
		this.ns = ns;
	}

}
