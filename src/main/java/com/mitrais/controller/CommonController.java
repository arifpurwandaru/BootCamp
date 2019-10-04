package com.mitrais.controller;

import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.Constants;


public class CommonController {

	public CommonResponse<String> generalException(String data){
		return new CommonResponse<>(Constants.GENERAL_ERROR_CD, Constants.GENERAL_ERROR_MSG, data);
		
	}
}
