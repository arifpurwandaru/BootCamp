package com.mitrais.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducer{
	@Autowired
	private KafkaTemplate<String, Object> kafkaObjectTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;

	public void sendDefault(String data) throws Exception {
		this.sendDefault("String", data);
	}

	public void sendDefault(String key, String data) throws Exception {
		this.send("DEFAULT-TOPIC-PLATFORM", key, data);
	}

	public void sendDefault(Object data) throws Exception {
		this.sendDefault("Object", data);
	}

	public void sendDefault(String key, Object data) throws Exception {
		this.send("DEFAULT-TOPIC-PLATFORM", key, data);
	}

	public void send(String topicName, String key, String data) throws Exception {
		this.kafkaStringTemplate.send(topicName, key, data);
	}

	public void send(String topicName, String data) throws Exception {
		this.send(topicName, "String", data);
	}

	public void send(String topicName, String key, Object data) throws Exception {
		this.kafkaObjectTemplate.send(topicName, key, data);
	}

	public void send(String topicName, Object data) throws Exception {
		this.send(topicName, "Object", data);
	}

	public void sendDefault(int partition, String key, String data) throws Exception {
		this.send("DEFAULT-TOPIC-PLATFORM", partition, key, data);
	}

	public void sendDefault(int partition, String data) throws Exception {
		this.sendDefault(partition, "String", data);
	}

	public void sendDefault(int partition, String key, Object data) throws Exception {
		this.send("DEFAULT-TOPIC-PLATFORM", partition, key, data);
	}

	public void sendDefault(int partition, Object data) throws Exception {
		this.sendDefault(partition, "String", data);
	}

	public void send(String topicName, int partition, String key, String data) throws Exception {
		this.kafkaStringTemplate.send(topicName, Integer.valueOf(partition), key, data);
	}

	public void send(String topicName, int partition, String data) throws Exception {
		this.send(topicName, partition, "String", data);
	}

	public void send(String topicName, int partition, String key, Object data) throws Exception {
		this.kafkaObjectTemplate.send(topicName, Integer.valueOf(partition), key, data);
	}

	public void send(String topicName, int partition, Object data) throws Exception {
		this.send(topicName, partition, "Object", data);
	}
}
