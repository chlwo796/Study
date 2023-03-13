package tempMemo;

public class Computer {
	int sum(int... is) {
		int sum = 0;

		for (int i = 0; i < is.length; i++) {
			sum += is[i];
		}
		return sum;
	}
}