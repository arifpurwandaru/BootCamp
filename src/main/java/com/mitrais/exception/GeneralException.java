package com.mitrais.exception;

public class GeneralException extends Exception {
	static final long serialVersionUID = -7034897191245766939L;
	
	public final String errorCode;

	public GeneralException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

}
