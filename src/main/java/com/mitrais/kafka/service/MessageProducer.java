package com.mitrais.kafka.service;

public interface MessageProducer {
	void sendDefault(String arg0) throws Exception;

	void sendDefault(String arg0, String arg1) throws Exception;

	void sendDefault(int arg0, String arg1, String arg2) throws Exception;

	void sendDefault(int arg0, String arg1) throws Exception;

	void sendDefault(Object arg0) throws Exception;

	void sendDefault(String arg0, Object arg1) throws Exception;

	void sendDefault(int arg0, String arg1, Object arg2) throws Exception;

	void sendDefault(int arg0, Object arg1) throws Exception;

	void send(String arg0, String arg1, String arg2) throws Exception;

	void send(String arg0, String arg1) throws Exception;

	void send(String arg0, int arg1, String arg2, String arg3) throws Exception;

	void send(String arg0, int arg1, String arg2) throws Exception;

	void send(String arg0, String arg1, Object arg2) throws Exception;

	void send(String arg0, Object arg1) throws Exception;

	void send(String arg0, int arg1, String arg2, Object arg3) throws Exception;

	void send(String arg0, int arg1, Object arg2) throws Exception;
}
