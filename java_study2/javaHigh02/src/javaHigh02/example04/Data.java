package javaHigh02.example04;

public class Data {
	String date;
	String code;
	String area;
	String phoneNumber;
	int saleAmmount;
	int salePrice;
	
	public Data(String date, String code, String area, int saleAmmount, int salePrice,String phoneNumber) {
		super();
		this.date = date;
		this.code = code;
		this.area = area;
		this.phoneNumber = phoneNumber;
		this.saleAmmount = saleAmmount;
		this.salePrice = salePrice;
	}
	
	@Override
	public String toString() {
//		object Ŭ������ �޼ҵ�, �ּҸ� ������ �ڵ����� toString()�޼ҵ� ����
//		��� Ŭ�������� ������ �Ͽ� �����Ѵ�.
		return "��������\t�ŷ�ó�ڵ�\t��������\t�Ǹŷ�\t����ݾ�\t����ó";
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSaleAmmount() {
		return saleAmmount;
	}

	public void setSaleAmmount(int saleAmmount) {
		this.saleAmmount = saleAmmount;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
}