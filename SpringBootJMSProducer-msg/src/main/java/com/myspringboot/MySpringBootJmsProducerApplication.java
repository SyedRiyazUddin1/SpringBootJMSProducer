package com.myspringboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myspringboot.config.RabbitMQConfiguration;

@SpringBootApplication
public class MySpringBootJmsProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootJmsProducerApplication.class, args);
	}

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");

		// RabitTemplate.convertAndSend method convert java object to AMQP message and
		// is sent to default topic exchange
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName, "message_routing_key",
				"Hello from RabbitMQ");
		System.out.println("Message sent successfully...");
	}

}
