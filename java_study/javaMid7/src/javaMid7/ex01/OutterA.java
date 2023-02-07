package javaMid7.ex01;

public class OutterA {
	int oa = 10;
	static int soa = 20;

	void oaM() {
		oa = oa - 5;
		soa = soa - 10; // 자신의 메소드에서 static 모두 사용 가능
		soaM();
	}

	static void soaM() {
//		oa = oa+5; // 사용불가, static에서는 객체생성 후 사용가능
//		oaM();	// 인스턴스멤버 사용 불가
		soa = soa - 1;
	}

	class InnerA {
		int ia = 20;
//		static int sia = 30;	// static 선언불가, Outter 필드와 충돌

		void iam() {
			ia = ia + 10;
			oa = oa + 5;
			soa = soa-10;	// Outter의 static 필드 사용 가능
			oaM();
			soaM();
		}

//		static void siaM() {
			// static 선언불가, Outter 필드와 충돌
//		}
	}
}