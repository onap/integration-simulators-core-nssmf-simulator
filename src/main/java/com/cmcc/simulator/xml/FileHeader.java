package com.cmcc.simulator.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class FileHeader {
	private String vendorName;
	private String elementType;
	private String pmVersion;
	private String timeZone;
	private int period;
	private String timeStamp;
	private String startTime;

	public FileHeader() {
	}

	public FileHeader(String vendorName, String elementType, String pmVersion, String timeZone, int period,
			String timeStamp, String startTime) {
		super();
		this.vendorName = vendorName;
		this.elementType = elementType;
		this.pmVersion = pmVersion;
		this.timeZone = timeZone;
		this.period = period;
		this.timeStamp = timeStamp;
		this.startTime = startTime;
	}

	@XmlElement(name="VendorName") 
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@XmlElement(name="ElementType") 
	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	@XmlElement(name="PmVersion") 
	public String getPmVersion() {
		return pmVersion;
	}

	public void setPmVersion(String pmVersion) {
		this.pmVersion = pmVersion;
	}

	@XmlElement(name="TimeZone") 
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@XmlElement(name="Period") 
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@XmlElement(name="TimeStamp") 
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@XmlElement(name="StartTime") 
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
