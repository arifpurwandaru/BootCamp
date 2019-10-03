package com.mitrais.session;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SessionRepositoryImpl implements SessionRepository {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	

	//TODO put this timeout as a sys config on db
	long sessionTimeout = 30;

	
	@Override
	public Map<String, String> get(String sessionId) {
		HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
		Map<String, String> session = opsForHash.entries(sessionId);
		refreshExpire(sessionId);
		return session;
	}

	private void refreshExpire(String sessionId) {
		redisTemplate.expire(sessionId, sessionTimeout, TimeUnit.MINUTES);
	}

	@Override
	public void delete(String sessionId) {
		redisTemplate.delete(sessionId);
	}

	@Override
	public void save(String sessionId, Map<String, String> data) {
		redisTemplate.delete(sessionId);
		redisTemplate.opsForHash().putAll(sessionId, data);
		refreshExpire(sessionId);
	}

}
