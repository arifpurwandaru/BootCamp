package com.mitrais.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mitrais.annotation.AuthenticateThis;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.persistence.service.UserDAO;
import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.Constants;
import com.mitrais.utils.JsonUtil;

@RestController
public class SimpleCrudController extends CommonController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDAO dao;
	
	@GetMapping(path="/getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	@AuthenticateThis
	public String getAll() throws JsonProcessingException {
		try {
			List<MUser> list = dao.getAll();
			CommonResponse<List<MUser>> resp = new CommonResponse<>(Constants.SUCCESS_CD,"",list);
			return JsonUtil.generateJson(resp);
		}catch(Exception e) {
			logger.error("",e);
			return JsonUtil.generateJson(this.generalException(e.getMessage()));
		}
	}
}
