package javaHigh10.example07;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -2949995971198247160L;

	private String name;
	private int price;

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + ": " + price;
	}
}
