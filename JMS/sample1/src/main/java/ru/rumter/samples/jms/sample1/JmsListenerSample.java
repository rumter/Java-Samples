package ru.rumter.samples.jms.sample1;

import org.springframework.context.support.GenericXmlApplicationContext; 

public class JmsListenerSample {

	public static void main(String[] args) { 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); 
		ctx.load("classpath:META-INF/applicationContext.xml"); 
		ctx.refresh();

		SimpleMessageSender messageSender = ctx.getBean(SimpleMessageSender.class);

		for (int i = 0; i < 5; ++ i) {
			messageSender.sendMessage("message num " + i);
		}

		while (true) {
		} 
	} 

} 