package fr.algofi.example.rmi.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.algofi.example.rmi.common.model.Quote;
import fr.algofi.example.rmi.common.model.QuoteRequest;

public interface QuoteService extends Remote {

	public Quote getQuote( final QuoteRequest quoteRequest ) throws RemoteException;
}
