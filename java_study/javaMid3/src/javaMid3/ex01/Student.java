package javaMid3.ex01;

public class Student extends Person {
	public void 공부하기() {
		System.out.println("학교 공부");
	}
@Override
public void 말하기() {
	// TODO Auto-generated method stub
	super.말하기();
	System.out.println("재밌게 말하기");
}
@Override
public void 걷기() {
	// TODO Auto-generated method stub
	super.걷기();
	System.out.println("걷기 싫어함");
}
@Override
public void 잠자기() {
	// TODO Auto-generated method stub
	super.잠자기();
	System.out.println("잠이 많음");
}
@Override
public void 먹기() {
	// TODO Auto-generated method stub
	super.먹기();
	System.out.println("안먹음");
}
}
