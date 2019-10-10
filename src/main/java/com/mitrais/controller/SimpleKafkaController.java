package com.mitrais.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.utils.CommonResponse;
import com.mitrais.utils.JsonUtil;

@RestController
@RequestMapping("kafka")
public class SimpleKafkaController extends CommonController{

    @Value("${kafka.my.topic}")
    private String topic = "";
    
    @Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;
    
    @PostMapping(path="/publish", produces=MediaType.APPLICATION_JSON_VALUE)
    public String publishKafka(@RequestBody MUser user) throws Exception {
    	kafkaStringTemplate.send(topic, "String", JsonUtil.generateJson(user));
    	CommonResponse<String> resp = new CommonResponse<>();
    	return JsonUtil.generateJson(resp);
    }
    
}


