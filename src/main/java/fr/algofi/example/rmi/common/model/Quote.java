package fr.algofi.example.rmi.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;

	private String currency;
	
	private String product;
	
	private int quantity;
	
	private BigDecimal price; 
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
