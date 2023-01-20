package ch05.day03;

public class NullEx01 {

	public static void main(String[] args) {
//		Null, NullPointerException
//		참조변수 = heap memory의 주소를 가지고 있는 변수
//		null = heap memory의 주소를 아직 넣어주지 않았다. 나중에 넣을 것이다. 초기값 설정
		
		Ezen st = null;	// st 변수에는 참조값이 들어 있지 않다. stack memory에만 자리 생성.
		System.out.println(st);
		Ezen ez1 = new Ezen();
		ez1.setName("최재환");	// "홍길동" -> String 타입 name 변수
		System.out.println("이름 : " + ez1.getName());
		ez1.setPhone("010-4116-0586");
		System.out.println("번호 : " + ez1.getPhone());
		ez1.setKor(100);
		System.out.println("점수 : " + ez1.getKor());
	}

}
//		method를 통해서 변수 값을 지정, 객체지향의 큰 틀
class Ezen{
	String name;
	String phone;
	int kor;
	
	void setName(String name) {	// "홍길동"->String name
		this.name = name;	// name -> this.name(class소속field)
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	String getName(){
		return this.name;	// this.없이 name으로도 가능. 제일 가까운 변수가 class소속 field
	}
	String getPhone() {
		return this.phone;
	}
	int getKor() {
		return this.kor;
	}
}
