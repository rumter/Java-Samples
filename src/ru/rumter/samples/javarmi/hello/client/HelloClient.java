package ru.rumter.samples.javarmi.hello.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ru.rumter.samples.javarmi.hello.api.HelloService;

/**
 * Клиент.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
public class HelloClient {

	public static void main(String[] args) throws Exception {

		// lookup proxy
		Registry registry = LocateRegistry.getRegistry(12345);
		HelloService proxy = (HelloService) registry.lookup("HelloService");

		// invoke
		String result = proxy.getHello("Name");
		System.out.println(result);

	}

}
