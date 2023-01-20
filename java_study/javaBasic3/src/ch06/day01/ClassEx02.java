package ch06.day01;

public class ClassEx02 {

	public static void main(String[] args) {
//		constructor, overloading
		Student st = new Student();
		Student st1 = new Student("홍길동");
		Student st2 = new Student("010-1234-5678",100);
		Student st3 = new Student("홍길동", 90);	// st2와 st3의 데이터 타입이 같다.
		Student st4 = new Student(85, "010-7894-5612");
		Student st5 = new Student("홍길동");
		Student st6 = new Student("010-555-6666");	// String name 변수로 입력된다.
		
		System.out.println(st.getName() + "\t" + st.getPhone() + "\t" + st.getScores());
		System.out.println(st1.getName() + "\t" + st1.getPhone() + "\t" + st1.getScores());
		System.out.println(st2.getName() + "\t" + st2.getPhone() + "\t" + st2.getScores());
		System.out.println(st3.getName() + "\t" + st3.getPhone() + "\t" + st3.getScores());
		System.out.println(st4.getName() + "\t" + st4.getPhone() + "\t" + st4.getScores());
		System.out.println(st5.getName() + "\t" + st5.getPhone() + "\t" + st5.getScores());
	}

}
class Student{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	String phone;
	int scores;
	
	public Student() {
		System.out.println("Student class의 기본생성자부분");
	}
	public Student(String name) {
		this.name = name;
	}
	public Student(String phone, int scores) {
		this.phone = phone;
		this.scores = scores;
	}
//	public Student(String name, int scores) {	// 데이터타입이 공통된다. 오류발생
//		this.name = name;						// 오버로딩의 기본 = 서로 다른 데이터타입
//		this.scores = scores;					// ()안에 데이터 타입의 순서가 다를 경우 다른 데이터타입이다.
//	}
	public Student(int scores, String phone) {
		this.scores = scores;
		this.phone = phone;
	}
	
}