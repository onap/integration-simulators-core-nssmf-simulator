package com.cmcc.simulator.module;

import java.util.List;

public class ResponseDescriptor {

	private String status;
	private int progress;
	private String statusDescription;
	private String errorCode;
	private List<VnfError> vnfErrorList;
	private List<PnfError> pnfErrorList;
	private String responseId;
	private List<ResponseHistory> responseHistoryList;

	public ResponseDescriptor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseDescriptor(String status, int progress, String statusDescription, String errorCode,
			List<VnfError> vnfErrorList, List<PnfError> pnfErrorList, String responseId,
			List<ResponseHistory> responseHistoryList) {
		super();
		this.status = status;
		this.progress = progress;
		this.statusDescription = statusDescription;
		this.errorCode = errorCode;
		this.vnfErrorList = vnfErrorList;
		this.pnfErrorList = pnfErrorList;
		this.responseId = responseId;
		this.responseHistoryList = responseHistoryList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<VnfError> getVnfErrorList() {
		return vnfErrorList;
	}

	public void setVnfErrorList(List<VnfError> vnfErrorList) {
		this.vnfErrorList = vnfErrorList;
	}

	public List<PnfError> getPnfErrorList() {
		return pnfErrorList;
	}

	public void setPnfErrorList(List<PnfError> pnfErrorList) {
		this.pnfErrorList = pnfErrorList;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public List<ResponseHistory> getResponseHistoryList() {
		return responseHistoryList;
	}

	public void setResponseHistoryList(List<ResponseHistory> responseHistoryList) {
		this.responseHistoryList = responseHistoryList;
	}

}
