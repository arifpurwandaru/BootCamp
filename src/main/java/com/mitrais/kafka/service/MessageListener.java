package com.mitrais.kafka.service;

public interface MessageListener {

	public void listen(String jsonStr) throws Exception;
}
