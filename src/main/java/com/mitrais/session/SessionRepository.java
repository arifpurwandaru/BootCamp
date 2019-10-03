package com.mitrais.session;

import java.util.Map;

public interface SessionRepository {

	public Map<String, String> get(String sessionId);

	public void delete(String sessionId);

	public void save(String sessionId, Map<String, String> data);

}
