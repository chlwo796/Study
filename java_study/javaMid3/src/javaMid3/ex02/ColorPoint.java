package javaMid3.ex02;

public class ColorPoint extends Point {
//	Point class�� ��������μ� �θ�Ŭ������ �޼ҵ带 �������̵� �� �� ������ �޼ҵ带 �������Ѵ�.
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