package javaMid3.ex03;

public class A extends BB {

//	@Override	// 자식에 메소드가 없으면 부모의 메소드로 실행된다. 생성자이동개념인거같다..
//	int sum(int a) {
//		// TODO Auto-generated method stub
//		return super.sum(a);
//	}

	@Override
	int minus(int a) {
		// TODO Auto-generated method stub
		return super.minus(a);
		
	}
	void printA() {
		System.out.println(sum + " " + minus);
	}

}
