package com.cmcc.simulator.xml;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FileReadyEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nfvoid;
	private String datasource;
	private String sourceid;
	private String createat;
	private List<String> fileuri;

	public String getNfvoid() {
		return nfvoid;
	}

	public void setNfvoid(String nfvoid) {
		this.nfvoid = nfvoid;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getSourceid() {
		return sourceid;
	}

	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}

	public String getCreateat() {
		return createat;
	}

	public void setCreateat(String createat) {
		this.createat = createat;
	}

	public List<String> getFileuri() {
		return fileuri;
	}

	public void setFileuri(List<String> fileuri) {
		this.fileuri = fileuri;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
