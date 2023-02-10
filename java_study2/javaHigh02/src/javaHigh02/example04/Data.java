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
//		object 클래스의 메소드, 주소를 찍으면 자동으로 toString()메소드 실행
//		모든 클래스에서 재정의 하여 재사용한다.
		return "매출일자\t거래처코드\t매출지역\t판매량\t매출금액\t연락처";
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