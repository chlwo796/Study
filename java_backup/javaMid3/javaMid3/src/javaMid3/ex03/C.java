package javaMid3.ex03;

public class C extends BB {
	long multiply = 1;

	@Override
	int sum(int a) {
		// TODO Auto-generated method stub
		return super.sum(a);
	}

	@Override
	int minus(int a) {
		// TODO Auto-generated method stub
		return super.minus(a);
	}

	long °öÇÏ±â(int b) {
		for (int i = 1; i <= b; i++) {
			multiply = multiply * i;
		}
		return multiply;

	}

	void printC() {
		System.out.println(sum + " " + minus + " " + multiply);
	}
}
