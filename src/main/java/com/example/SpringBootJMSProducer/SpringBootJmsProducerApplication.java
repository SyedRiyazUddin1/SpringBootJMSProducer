package com.example.SpringBootJMSProducer;

import com.example.SpringBootJMSProducer.config.RabbitMQConfiguration;
import com.example.SpringBootJMSProducer.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJmsProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJmsProducerApplication.class, args);
    }


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setProductId(101);
        product.setName("Sony Laptop");
        product.setQuantity(20);

        System.out.println("Sending message...");

        //RabitTemplate.convertAndSend method converst java object to AMQP message and is sent ti defult topic exchange
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
                "message_routing_key", product);
        System.out.println("Message sent successfully...");
    }
}
