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
		int ia = 20; // ������ ����� ��� ����
		static int sia = 30;	

		void iam() {
			ia = ia + 10;
//			oa = oa + 5; // outter�� �ν��Ͻ������ ����� �� ����.
			soa = soa - 10;
//			oaM(); // outter�� �ν��Ͻ������ ����� �� ����.
			soaM();
		}

		static void siaM() {
			// static method ��� ����
		}
	}
}
