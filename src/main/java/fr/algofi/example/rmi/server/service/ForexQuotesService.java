package fr.algofi.example.rmi.server.service;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import fr.algofi.example.rmi.common.model.Quote;
import fr.algofi.example.rmi.common.model.QuoteRequest;
import fr.algofi.example.rmi.common.service.QuoteService;

public class ForexQuotesService implements QuoteService {

	public Quote getQuote(final QuoteRequest quoteRequest) throws RemoteException {

		final Quote quote = new Quote();
		quote.setCurrency(quoteRequest.getCurrency());
		quote.setProduct(quoteRequest.getProduct());
		quote.setQuantity(quoteRequest.getQuantity() );

		final double rate = 1.2;
		final double amount = rate * quoteRequest.getQuantity();
		quote.setPrice(new BigDecimal(amount));

		return quote;
	}

}
