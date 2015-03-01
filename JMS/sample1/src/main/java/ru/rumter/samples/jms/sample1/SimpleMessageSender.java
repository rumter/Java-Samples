package ru.rumter.samples.jms.sample1;

import javax.jms.JMSException; 
import javax.jms.Message; 
import javax.jms.Session; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jms.core.JmsTemplate; 
import org.springframework.jms.core.MessageCreator; 
import org.springframework.stereotype.Component; 

@Component("simpleMessageSender")
public class SimpleMessageSender { 

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageSender.class);

	@Autowired 
	private JmsTemplate jmsTemplate; 

	public void sendMessage(final String message) { 
		this.jmsTemplate.send(new MessageCreator() { 
			public Message createMessage(Session session) throws JMSException { 
				logger.info("send message " + message);
				return session.createTextMessage(message); 
			} 
		}); 
	} 
} 