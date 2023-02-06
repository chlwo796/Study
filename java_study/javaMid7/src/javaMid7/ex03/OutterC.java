package javaMid7.ex03;

public class OutterC {
	int ia = 10;
	static int sia = 20;

	void iaM() {

		class InnerC {
			int ic = 100;
//			static int sic = 30;

			void icM() {
				ia = ia + 100; // outter클래스의 멤버 사용 가능
				ic = ic + 10; // Inner클래스의 멤버
				System.out.println("OutterC.iaM().InnerC.icM()");
			}

//			static void sicM() {
//				System.out.println("OutterC.iaM().InnerC.sicM()");
//			}

		}
//		메소드 종료 전에 객체생성하고 데이터를 사용해야한다. 정보은닉
//		메소드가 클래스를 독점하는 경우
		InnerC innerC = new InnerC();
		innerC.icM();
	}

	static void siaM() {

	}

}