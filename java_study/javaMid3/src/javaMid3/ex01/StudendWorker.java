package javaMid3.ex01;

public class StudendWorker extends Student {
	// StudentWorker class는 Student와 조부모 Person class를 모두 상속한다.
	public void 일하기() {
		System.out.println("학교에서 일함");
	}

	@Override
	public void 공부하기() {
		// TODO Auto-generated method stub
		super.공부하기();
		System.out.println("공부하는 학생들을 도와준다.");
	}

	@Override
	public void 말하기() {
		// TODO Auto-generated method stub
		super.말하기();
	}

	@Override
	public void 걷기() {
		// TODO Auto-generated method stub
		super.걷기();
	}

	@Override
	public void 잠자기() {
		// TODO Auto-generated method stub
		super.잠자기();
	}

	@Override
	public void 먹기() {
		// TODO Auto-generated method stub
		super.먹기();
	}

}
