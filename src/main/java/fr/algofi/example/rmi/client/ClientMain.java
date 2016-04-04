package fr.algofi.example.rmi.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.algofi.example.rmi.common.model.Quote;
import fr.algofi.example.rmi.common.model.QuoteRequest;
import fr.algofi.example.rmi.common.service.QuoteService;

public class ClientMain {

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		
		// get the service registry
		final Registry registry = LocateRegistry.getRegistry();
		
		// get the service
		final QuoteService quoteService = (QuoteService) registry.lookup("forexQuoteService");
		
		//build the quote request
		final QuoteRequest quoteRequest = new QuoteRequest();
		quoteRequest.setCurrency("USD");
		quoteRequest.setProduct("USD/HKG");
		quoteRequest.setQuantity( 1000 );
		
		// get the quote
		final Quote quote = quoteService.getQuote(quoteRequest);

		// display price
		System.out.println( quote.getQuantity() + " " + quote.getProduct() + " = " + quote.getPrice() + " " + quote.getCurrency() );
		
	}
}
