package javaMid7.ex01;

public class OutterB {
	int oa = 10;
	static int soa = 20;

	void oaM() {
		oa = oa - 5;
		soa = soa - 10;
		soaM();
	}

	static void soaM() {
//		oa = oa+5; 
//		oaM();	
		soa = soa - 1;
	}

	static class InnerB {
		int ia = 20; // 본인의 멤버는 사용 가능
		static int sia = 30;	

		void iam() {
			ia = ia + 10;
//			oa = oa + 5; // outter의 인스턴스멤버는 사용할 수 없다.
			soa = soa - 10;
//			oaM(); // outter의 인스턴스멤버는 사용할 수 없다.
			soaM();
		}

		static void siaM() {
			// static method 사용 가능
		}
	}
}
