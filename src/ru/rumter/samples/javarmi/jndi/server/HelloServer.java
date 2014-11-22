package ru.rumter.samples.javarmi.jndi.server;

import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ru.rumter.samples.javarmi.jndi.api.HelloService;

/**
 * Сервер.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
public class HelloServer {

	public static void main(String[] args) throws Exception {

		// init
		HelloService helloServiceInst = new HelloServiceImpl();

		// proxy
		HelloService proxyServiceInst = (HelloService) UnicastRemoteObject.exportObject(helloServiceInst, 0);

		// bind proxy
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
		properties.put(Context.PROVIDER_URL, "rmi://localhost:1099");
		InitialContext ctx = new InitialContext(properties);
		ctx.rebind("HelloService", proxyServiceInst);

		// ready
		System.out.println("Server ready");

	}

}
