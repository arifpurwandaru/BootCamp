package com.mitrais.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mitrais.exception.DAOException;
import com.mitrais.exception.SessionException;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.proc.service.UserService;
import com.mitrais.session.SessionPublisher;
import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.JsonUtil;
/**
 * 
 * @author Arif_P
 *
 * This class intended as a bridge authentication between legacy system and this application
 */
@RestController
@RequestMapping("/sso")
public class SingleSignOnService {
	private static Logger logger = LoggerFactory.getLogger(SingleSignOnService.class);
	//TODO put as sys config in db
	private static final String SECRET_KEY="xx123secret321xx";

	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionPublisher sessionPublisher;
	
	/**
	 * This service should be called from legacy system right after the authentication process triggered
	 * 
	 * @param param
	 * @return
	 * @throws JsonProcessingException
	 */
	@PostMapping(path="/logon", produces=MediaType.APPLICATION_JSON_VALUE)
	public String logon(@RequestBody Map<String, String> param) throws JsonProcessingException {
		CommonResponse<MUser> resp = new CommonResponse<>();
		try{
			logger.debug("===================================> Test logging");
			//TODO: authenticate here
			//...
			
			MUser u = userService.get(param.get("userId"));
			sessionPublisher.setLoginUser(u);
			//String token = JWTUtil.generateToken(SECRET_KEY, JsonUtil.generateJson(u));
			resp.setData(u);
			sessionPublisher.saveSession();
		}catch(DAOException de) {
			resp.setRespCode("[code here]");
			resp.setRespMsg(de.getMessage());
			logger.error("DAOException", de);
		} catch (SessionException se) {
			resp.setRespCode("[code here]");
			resp.setRespMsg(se.getMessage());
			logger.error("SessionException", se);
		}
		
		return JsonUtil.generateJson(resp);
	}
	
}
