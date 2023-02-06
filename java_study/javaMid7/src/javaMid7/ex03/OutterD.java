package javaMid7.ex03;

public class OutterD {

	static int sia = 200;

	static void sM() {
		int ss = 10;
		class InnerD {
			int sid = 20;

			void siM() {
				System.out.println("innerD sim()" + sid + " " + sia);
			}
		}
		InnerD innerD = new InnerD();
		innerD.siM();
	}
}
