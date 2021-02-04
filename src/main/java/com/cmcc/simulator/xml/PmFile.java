package com.cmcc.simulator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PmFile")
public class PmFile {

	private FileHeader fileHeader;
	private Measurements measurements;

	public PmFile() {
		super();
	}

	public PmFile(FileHeader fileHeader, Measurements measurements) {
		super();
		this.fileHeader = fileHeader;
		this.measurements = measurements;
	}

	@XmlElement(name="FileHeader") 
	public FileHeader getFileHeader() {
		return fileHeader;
	}

	public void setFileHeader(FileHeader fileHeader) {
		this.fileHeader = fileHeader;
	}

	@XmlElement(name="Measurements") 
	public Measurements getMeasurements() {
		return measurements;
	}

	public void setMeasurements(Measurements measurements) {
		this.measurements = measurements;
	}

}
