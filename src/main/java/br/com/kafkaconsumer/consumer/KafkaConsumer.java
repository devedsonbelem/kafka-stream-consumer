package br.com.kafkaconsumer.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.com.kafkaconsumer.entity.Users;

@Service
public class KafkaConsumer {

	  private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	  @KafkaListener(topics = "${topic.name}")
	    public void listen(@Payload List<Users> usersList) {
	             System.out.println(usersList);	 
    	        if (usersList != null) {
	            for (Users user : usersList) {
	            	 System.out.println("REsposta " + user);
	             
	                LOG.info("Received user: {}", user.toString());
	            }
	        } else {
	            LOG.warn("Received null or empty list");
	        }
}
}