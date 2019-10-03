package com.mitrais.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.Constants;


public class CommonController {

	public CommonResponse<String> generalException(String data){
		return new CommonResponse<String>(Constants.GENERAL_ERROR_CD, Constants.GENERAL_ERROR_MSG, data);
		
	}
}
