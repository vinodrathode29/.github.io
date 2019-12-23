package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {

	public CartEmptyException() {
		super("Cart is Empty");
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
  
}
