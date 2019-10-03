package com.mitrais.exception;

public class SessionException extends GeneralException {
	static final long serialVersionUID = -7034899290745766939L;
	
	public SessionException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
