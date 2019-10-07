package com.mitrais.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerImpl implements MessageListener{

	@Override
	@KafkaListener(topics="${kafka.my.topic}")
	public void listen(String jsonStr) throws Exception {
		System.out.println("======================> Message: "+jsonStr);
	}

}
