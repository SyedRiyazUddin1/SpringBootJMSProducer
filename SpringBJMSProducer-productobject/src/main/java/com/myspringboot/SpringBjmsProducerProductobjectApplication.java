package com.myspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myspringboot.config.RabbitMQConfiguration;
import com.myspringboot.model.Product;

@SpringBootApplication
public class SpringBjmsProducerProductobjectApplication implements CommandLineRunner {

	// using logger slf4j
	private static final Logger log = LoggerFactory.getLogger(SpringBjmsProducerProductobjectApplication.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBjmsProducerProductobjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);

		log.info("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName, "message_routing_key", product);
		log.info("Message sent successfully...");
	}

}
