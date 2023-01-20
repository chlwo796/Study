2023년 1월 12일 목요일

---

## Reference Variable

`int a;` : a라는 이름의 변수로 4byte의 공간을 stack memory에 생성한다.

`int a = 10;` : 10이라는 값을 변수 안에 바로 저장한다. (기본 타입)

`stack <-> heap` : RAM의 일부분
- stack memory : 자바 접근 가능 
- heap memory : 자바 접근 불가능, 임시 저장소

- __class와 method__

```java

public class RefEx01 {

	public static void main(String[] args) {    // main이라는 method 호출(프로그램메인)
        Person p = new Person();    
        // Person class의 heap memory 주소 생성, p라는 변수에 Person의 data type으로 stack memory에 할당.
        p.address = "경기도";
        // (~.) = ~에, p라는 변수에 adress를 넣는다. 그 값은 "경기도"이다.
		p.point = 81.5; // 위와 동일

        System.out.println(p.address);   
        // Person class의 field를 바로 사용할 시 error, (address) -> (p.address)
		System.out.println(p.point);
    }
}
class Person{  // 새로운 클래스 생성
    String address;  // Person class의 field(변수)
    double point;
}

```

```java

class Student { // 각 class에서는 method 호출이 가능하다

	String stName;
	int age;
    // method의 구조. 리턴타입 메소드이름(입력받는 변수, 메소드가 호출될 때 넣어주는 값들){처리할 내용}
	void method1() {    
		System.out.println("이곳은 Student class의 method1입니다.");
	}
}

```java

public class RefEx03 {

	public static void main(String[] args) {
		Person1 person = new Person1();

		person.setAdress("하남시");		// method에 값을 지정해준다.
		person.setPoint(301.4);			// 서로의 data type을 맞춰줘야 한다.
		person.setAll("강동구", 40.2);
	}

}

class Person1 {
	String adress;
	double point;
    void setAdress(String adress) {		
		// `void setAdress(String a)`로 새로운 변수에 값을 받아도 되지만 새로운 프로그램이 복잡해 질 시 변수가 많아져 헷갈릴 수 있다.
		// this.변수명 = 자신의 클래스의 멤버필드
		this.adress = adress;		
		// 같은 이름의 변수 중 전역변수를 지정해준다. `adress = adress;`는 자바가 실행하지 않는다.
		System.out.println("이곳은 Person1 클래스의 method " + adress);
	}

	void setPoint(double point) {
		this.point = point;
		System.out.println(point);
	}

	void setAll(String adress, double point) {		
		
		this.adress = adress;	
		this.point = point;		
		
		System.out.println(adress + point);
	}
}

```








