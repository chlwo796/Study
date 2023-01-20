package ch05.day03;

import java.util.Calendar;

public class Ex02 {

	public static void main(String[] args) {
//		method�� Ȱ���� ���� �Է��ϱ�

//		�ֹι�ȣ "930122-1209218" �� "��⵵ �ϳ���" ���� : 25 ���� : ����

		Person ps = new Person();
		ps.setSsn("930122-1209218");
		System.out.println(ps.getName());
		ps.setAddress("��⵵ �ϳ���");
		System.out.println(ps.getAddress());
		ps.setAge("930122-1209218");
		System.out.println(ps.getAge());
		ps.setGender(true);
		System.out.println(ps.getGender());

		Shop shop1 = new Shop();
		shop1.setShopName("KT-hand");
		shop1.setShopType("�ڵ�������");
		shop1.setShopSale(1000);
		
		System.out.println(shop1.getShopName());
		System.out.println(shop1.getShopType());
		System.out.println(shop1.getShopSale());
	}

}

class Person {

	Calendar now = Calendar.getInstance(); // ����Ͻú���
	int currentYear = now.get(Calendar.YEAR);
	int currentMonth = now.get(Calendar.MONTH);
	String ssn;
	String address;
	int age;
	boolean gender;

	void setSsn(String ssn) {
		this.ssn = ssn;
	}

	void setAddress(String address) {
		this.address = address;
	}

	void setAge(String ssn) {
		System.out.println(currentYear);
		System.out.println(currentMonth);
		String birth = ssn.substring(0, 2);
		int ageYear = Integer.parseInt(birth);
		age = currentYear - (1900 + ageYear);
	}

	void setGender(boolean gender) {
		this.gender = gender;
	}

	String getName() {
		return this.ssn;
	}

	String getAddress() {
		return this.address;
	}

	int getAge() {
		return this.age;
	}

	String getGender() {
		if (true) {
			return "����";
		} else
			return "����";
	}
}

class Shop {
String shopName;
String shopType;
int sale;

void setShopName(String shopName) {
	this.shopName = shopName;
}
void setShopType(String shopType) {
	this.shopType = shopType;
}
void setShopSale(int sale) {
	this.sale = sale;	
}
String getShopName() {
	return this.shopName;
}
String getShopType() {
	return this.shopType;
}
int getShopSale() {
	return this.sale;
}
}
