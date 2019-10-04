package com.mitrais.utils;

public class CommonResponse<T> {

	private String respCode;
	private String respMsg;
	private T data;
	
	public CommonResponse(){
		respCode = Constants.SUCCESS_CD;
		respMsg = Constants.SUCCESS_MSG;
	}
	
	public CommonResponse(T data){
		this.data = data;
	}
	
	public CommonResponse(String respCode, String respMsg, T data){
		this.respCode = respCode;
		this.respMsg = respMsg;
		this.data = data;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
