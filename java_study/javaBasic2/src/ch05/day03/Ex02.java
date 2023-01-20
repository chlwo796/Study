package ch05.day03;

import java.util.Calendar;

public class Ex02 {

	public static void main(String[] args) {
//		method를 활용한 변수 입력하기

//		주민번호 "930122-1209218" 집 "경기도 하남시" 나이 : 25 성별 : 남자

		Person ps = new Person();
		ps.setSsn("930122-1209218");
		System.out.println(ps.getName());
		ps.setAddress("경기도 하남시");
		System.out.println(ps.getAddress());
		ps.setAge("930122-1209218");
		System.out.println(ps.getAge());
		ps.setGender(true);
		System.out.println(ps.getGender());

		Shop shop1 = new Shop();
		shop1.setShopName("KT-hand");
		shop1.setShopType("핸드폰가게");
		shop1.setShopSale(1000);
		
		System.out.println(shop1.getShopName());
		System.out.println(shop1.getShopType());
		System.out.println(shop1.getShopSale());
	}

}

class Person {

	Calendar now = Calendar.getInstance(); // 년월일시분초
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
			return "남자";
		} else
			return "여자";
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
