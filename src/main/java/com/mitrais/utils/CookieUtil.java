package com.mitrais.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		} else if (name == null) {
			return null;
		} else {
			Cookie[] arg2 = cookies;
			int arg3 = cookies.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Cookie c = arg2[arg4];
				if (name.equals(c.getName())) {
					return c;
				}
			}

			return null;
		}
	}
}
