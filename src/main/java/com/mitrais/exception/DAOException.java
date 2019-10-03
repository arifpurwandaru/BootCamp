package com.mitrais.exception;

public class DAOException extends GeneralException {
	static final long serialVersionUID = -7034897810745766939L;
	
	public DAOException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
