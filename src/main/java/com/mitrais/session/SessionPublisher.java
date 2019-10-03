package com.mitrais.session;

import com.mitrais.exception.SessionException;
import com.mitrais.persistence.entity.MUser;


public interface SessionPublisher extends SessionConsumer{
	
	public void setLoginUser(MUser authUser) throws SessionException;

	public void putSession(String key, String value);

	public void removeSession(String key);

	public void deleteSession(String key);

	public void clearSession();

	public void saveSession();
	
	public String generateToken();
	
}
