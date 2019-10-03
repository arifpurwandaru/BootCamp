package com.mitrais.session;

import com.mitrais.exception.SessionException;
import com.mitrais.persistence.entity.MUser;

public interface SessionConsumer {

	public String getSessionId();
	
	public boolean validateToken(String token) throws SessionException;
	
	public MUser getAuthenticatedUser() throws SessionException;
	
}
