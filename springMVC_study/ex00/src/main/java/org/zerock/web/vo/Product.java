package org.zerock.web.vo;

import lombok.Data;

@Data
public class Product {

	private String name;
	private double price;
	
	public Product( String name, double price ) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getPrice();
	}
}
