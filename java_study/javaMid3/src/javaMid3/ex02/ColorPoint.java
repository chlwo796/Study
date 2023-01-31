package javaMid3.ex02;

public class ColorPoint extends Point {
//	Point class를 상속함으로서 부모클래스의 메소드를 오버라이딩 한 후 변수와 메소드를 재정의한다.
	String color = "red";

	@Override
	void printAll() {
		// TODO Auto-generated method stub
		super.printAll();
		px = 3;
		py = 4;
		System.out.println(color + "(" + px + ", " + py + ")");
	}
}