package com.mitrais.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mitrais.annotation.AuthenticateThis;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.session.SessionConsumer;
import com.mitrais.utils.Constants;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionConsumer sessionConsumer;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
		    final Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);
		    log.error("Wrong type of HandlerInterceptor");
		    return false;
		}
		
		HandlerMethod hm = (HandlerMethod) handler;
		
		AuthenticateThis authAnnotation = AnnotationUtils.findAnnotation(hm.getMethod(), AuthenticateThis.class);
		if (authAnnotation == null) {
			return true;
		}
		
		MUser user = sessionConsumer.getAuthenticatedUser();
		if (user == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.UNAUTHORIZED_MESSAGE);
			return false;
		}
		
		//TODO add more auth validation e.g. authenticate per services maybe
		//..
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}


}
