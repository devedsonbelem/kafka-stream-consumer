package br.com.kafkaconsumer.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.kafkaconsumer.entity.Users;

@EnableKafka
@Configuration
public class ReciverConfig {
	

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, List<Users>> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, List<Users>> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	    return factory;
	}
	@Bean
	public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); // Use JsonDeserializer
	    props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // Permita todas as classes a serem desserializadas (não recomendado em produção)
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "MyGroup");
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	    return props;
	}

	@Bean
	public ConsumerFactory<String, List<Users>> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<>(
	        consumerConfigs(), 
	        new StringDeserializer(),
	        new JsonDeserializer<>(new TypeReference<List<Users>>() {})
	    );
	}

 

}
