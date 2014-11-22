package ru.rumter.samples.javarmi.hello.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ru.rumter.samples.javarmi.hello.api.HelloService;

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
		Registry registry = LocateRegistry.createRegistry(12345);
		registry.bind("HelloService", proxyServiceInst);

		// ready
		System.out.println("Server ready");

	}

}
