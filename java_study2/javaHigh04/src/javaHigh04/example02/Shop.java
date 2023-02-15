package javaHigh04.example02;

public class Shop {

	private Data data;
	private String phone;

	public Shop(String phone, Data data) {
		super();
		this.data = data;
		this.phone = phone;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
