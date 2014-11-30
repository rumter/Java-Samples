package ru.rumter.samples.javarmi.hello.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс удаленного сервиса.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
public interface HelloService extends Remote {
	String getHello(String userName) throws RemoteException;
}