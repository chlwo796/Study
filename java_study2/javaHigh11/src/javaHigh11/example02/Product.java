package javaHigh11.example02;

public class Product {
	private int pno;
	private String name;
	private String company;
	private int price;

	public int getPno() {
		return pno;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public int getPrice() {
		return price;
	}

	public Product(int pno, String name, String company, int price) {
		super();
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	@Override
	public String toString() {

		return new StringBuilder().append("{pno: ").append(pno).append(", name: ").append(name).append(", company : ")
				.append(company).append(", price : ").append(price).append("}").toString();
	}
}