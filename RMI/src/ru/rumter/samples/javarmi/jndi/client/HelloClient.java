package ru.rumter.samples.javarmi.jndi.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ru.rumter.samples.javarmi.jndi.api.HelloService;

/**
 * Клиент.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
public class HelloClient {

	public static void main(String[] args) throws Exception {

		// lookup proxy
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
		properties.put(Context.PROVIDER_URL, "rmi://localhost:1099");
		InitialContext ctx = new InitialContext(properties);
		HelloService proxy = (HelloService) ctx.lookup("HelloService");

		// invoke
		String result = proxy.getHello("Name");
		System.out.println(result);

	}

}
