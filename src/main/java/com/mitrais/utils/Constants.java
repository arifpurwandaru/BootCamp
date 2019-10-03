package com.mitrais.utils;

public class Constants {
	
	//date format
	public static final String DDMMYYYY = "dd/MM/yyyy";
	public static final String DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";
	

	public static final String UNAUTHORIZED_MESSAGE = "You do not have authorization";
	
	public static final String SESSION_COOKIE = "WALANGSESSION";

	public static final String USER_SESSION_KEY_ATTR = "userSession";
	public static final String TRANS_TOKEN_KEY_ATTR = "transactionToken";
	
	
	//ERROR MSG
	public static final String SUCCESS_CD="00";
	public static final String SUCCESS_MSG = "Success";
	
	public static final String USER_NOT_FOUND_CD="01";
	public static final String USER_NOT_FOUND_MSG="User tidak ditemukan";
	
	public static final String GENERAL_ERROR_CD="02";
	public static final String GENERAL_ERROR_MSG="General Error";
	
	public static final String USER_EXIST_CD = "04";
	public static final String USER_ALREADY_EXIST = "Nomer HP sudah terdaftar";
	
	public static final String DATA_NOT_FOUND_CD = "05";
	public static final String DATA_NOT_FOUND_VL = "Data Not Found";
	
	//other constants
	public static final String DEFAULT_PAGE="1";
	public static final String DEFAULT_ROW_PERPAGE = "10";
}
