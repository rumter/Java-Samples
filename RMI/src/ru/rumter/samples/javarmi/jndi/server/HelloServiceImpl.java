package ru.rumter.samples.javarmi.jndi.server;

import java.rmi.RemoteException;

import ru.rumter.samples.javarmi.jndi.api.HelloService;

/**
 * Реализация интерфейса сервиса.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
public class HelloServiceImpl implements HelloService {

	public String getHello(String userName) throws RemoteException {
		return "Hello " + userName + "!";
	}

}
