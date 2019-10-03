package com.mitrais;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mitrais.filter.AuthenticationInterceptor;
import com.mitrais.filter.SessionPublisherInterceptor;
import com.mitrais.session.SessionPublisherImpl;


@Configuration
public class BaseAuthenticationConfig implements WebMvcConfigurer{

	@Bean
	public SessionPublisherInterceptor sessionInterceptor() {
		return new SessionPublisherInterceptor();
	}
	
	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor());
		registry.addInterceptor(authenticationInterceptor());
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionPublisherImpl sessionPublisher() {
		return new SessionPublisherImpl();
	}
}
