package com.example.SpringBootJMSConsumer.receiver;

import org.springframework.stereotype.Component;

@Component
public class JMSReceiver {
	
	public void receiveMessage(String message) {
		
		System.out.println("Received <" + message + ">");
	}
}