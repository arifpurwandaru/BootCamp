package com.mitrais.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.kafka.service.MessageProducer;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.JsonUtil;

@RestController
@RequestMapping("kafka")
public class SimpleKafkaController extends CommonController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${kafka.my.topic}")
    private String topic = "";
    
    @Autowired
    private MessageProducer msgProducer;
    
    
    @PostMapping(path="/publish", produces=MediaType.APPLICATION_JSON_VALUE)
    public String publishKafka(@RequestBody MUser user) throws Exception {
    	msgProducer.send(topic, JsonUtil.generateJson(user));
    	CommonResponse<String> resp = new CommonResponse<>();
    	return JsonUtil.generateJson(resp);
    }
    
}
