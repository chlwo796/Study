package javaMid7.ex02;

public class C {
	static class D {
		static void print() {
			for (int i = 0; i < 5; i++) {
				for (int j = i; j < 5; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

		static void printA() {
			for (int i = 0; i < 4; i++) {
				for(int k = 0;k<i+1;k++) {
					System.out.print("*");
				}
				for (int j = 0; j < 5-(2*i); j++) {
					System.out.print(" ");
				}
				for(int l = 0;l<i+1;l++) {
					if(i == 3 && l == 3) {	// 한번 더 보기
						break;
					}
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}