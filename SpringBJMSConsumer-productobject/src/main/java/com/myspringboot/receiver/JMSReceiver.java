package com.myspringboot.receiver;

import org.springframework.stereotype.Component;

import com.myspringboot.model.Product;

@Component
public class JMSReceiver {

	public void receiveMessage(Product Product) {
		System.out.println("Received <" + Product + ">");
	}
}
