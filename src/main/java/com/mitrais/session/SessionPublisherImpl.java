package com.mitrais.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mitrais.exception.SessionException;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.utils.Constants;
import com.mitrais.utils.CookieUtil;
import com.mitrais.utils.JsonUtil;


public class SessionPublisherImpl implements SessionPublisher{

	Logger log = LoggerFactory.getLogger(SessionPublisherImpl.class);

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@Autowired
	SessionRepository sessionRepo;

	String sessionId;
	Map<String, String> session;
	boolean saved = true;

	@Override
	public void clearSession() {
		this.saved = false;
		session.clear();
	}

	private String generateSessionId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Override
	public String generateToken() {
		String token = UUID.randomUUID().toString().replace("-", "");
		putSession(Constants.TRANS_TOKEN_KEY_ATTR, token);
		return token;
	}

	@Override
	public MUser getAuthenticatedUser() throws SessionException {
		String userSession = session.get(Constants.USER_SESSION_KEY_ATTR);
		if (userSession != null && !userSession.equals("")) {
			try {
				return JsonUtil.parseJson(userSession, MUser.class);
			} catch (Exception e) {
				log.error("Error when parsing session json", e);
				throw new SessionException("[define code here]", "getAuthenticatedUser: Parsing json failed");
			}
		}
		return null;
	}

	public Map<String, String> getSession() {
		return session;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	public void initSession() {
		session = new HashMap<String, String>();

		Cookie currentCookie = CookieUtil.getCookieByName(request, Constants.SESSION_COOKIE);
		if (currentCookie != null)
			sessionId = currentCookie.getValue();

		if (StringUtils.isBlank(sessionId) || !lookupSession()) {
			sessionId = generateSessionId();
		}

		Cookie setCookie = new Cookie(Constants.SESSION_COOKIE, sessionId);
		setCookie.setHttpOnly(true);
		setCookie.setPath("/");
		setCookie.setSecure(true);
		response.addCookie(setCookie);
	}

	private boolean lookupSession() {
		Map<String, String> repoData = sessionRepo.get(sessionId);
		if (repoData == null) {
			return false;
		}
		session.putAll(repoData);
		return true;
	}

	public void putAllSession(Map<? extends String, ? extends String> m) {
		this.saved = false;
		session.putAll(m);
	}

	@Override
	public void putSession(String key, String value) {
		this.saved = false;
		session.put(key, value);
	}

	@Override
	public void removeSession(String key) {
		this.saved = false;
		session.remove(key);
	}

	@Override
	public void deleteSession(String key) {
		this.saved = false;
		sessionRepo.delete(key);
	}

	@Override
	public void saveSession() {
		if (!saved) {
			if (session.isEmpty()) {
				sessionRepo.delete(sessionId);
			} else {
				sessionRepo.save(sessionId, session);
			}
			saved = true;
		}
	}

	@Override
	public void setLoginUser(MUser authUser) throws SessionException {
		try {
			String userSession = JsonUtil.generateJson(authUser);
			putSession(Constants.USER_SESSION_KEY_ATTR, userSession);
		} catch (Exception e) {
			log.error("Error when creating json session", e);
			throw new SessionException("[define id here]", e.getMessage());
		}
	}

	@Override
	public boolean validateToken(String token) {
		String sessionToken = session.get(Constants.TRANS_TOKEN_KEY_ATTR);
		return StringUtils.isNotBlank(sessionToken) 
					&& StringUtils.isNotBlank(token) 
						&& sessionToken.equals(token);
	}


}
