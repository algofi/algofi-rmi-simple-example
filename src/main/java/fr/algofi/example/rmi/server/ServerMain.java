package fr.algofi.example.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import fr.algofi.example.rmi.common.service.QuoteService;
import fr.algofi.example.rmi.server.service.ForexQuotesService;

public class ServerMain {

	static {
		System.setProperty("java.rmi.server.ignoreStubClasses", "false");
	}

	public static void main(String[] args) {

		final QuoteService forexQuoteService = new ForexQuotesService();
		try {
			final int port = 1234;

			final Remote remoteForexQuoteService = UnicastRemoteObject.exportObject(forexQuoteService, port);

			final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

			registry.bind("forexQuoteService", remoteForexQuoteService);

			System.out.println("Server ready");

		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
			System.exit(-2);
		}
	}

}
