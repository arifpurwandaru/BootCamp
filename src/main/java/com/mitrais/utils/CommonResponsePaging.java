package com.mitrais.utils;

public class CommonResponsePaging<T> {
	
	private String respCode;
	private String respMsg;
	private CommonPaging<T> paging;
	
	public CommonResponsePaging() {}
	
	public CommonResponsePaging(String respCode, String respMsg, CommonPaging<T> paging) {
		this.respCode = respCode;
		this.respMsg = respMsg;
		this.paging = paging;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public CommonPaging<T> getPaging() {
		return paging;
	}

	public void setPaging(CommonPaging<T> paging) {
		this.paging = paging;
	}
}
