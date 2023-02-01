package javaMid3.ex03;

public class BB {
	int a;
	int sum;
	int minus;

	int sum(int a) {
		for (int i = 0; i <= a; i++) {
			sum = sum + i;
		}
		return sum;

	}

	int minus(int a) {
		minus = sum - a;
		return minus;
	}

	void printBB() {
		System.out.println(sum + " " + minus);
	}

}
