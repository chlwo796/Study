package javaMid7.ex01;

public class OutterA {
	int oa = 10;
	static int soa = 20;

	void oaM() {
		oa = oa - 5;
		soa = soa - 10; // �ڽ��� �޼ҵ忡�� static ��� ��� ����
		soaM();
	}

	static void soaM() {
//		oa = oa+5; // ���Ұ�, static������ ��ü���� �� ��밡��
//		oaM();	// �ν��Ͻ���� ��� �Ұ�
		soa = soa - 1;
	}

	class InnerA {
		int ia = 20;
//		static int sia = 30;	// static ����Ұ�, Outter �ʵ�� �浹

		void iam() {
			ia = ia + 10;
			oa = oa + 5;
			soa = soa-10;	// Outter�� static �ʵ� ��� ����
			oaM();
			soaM();
		}

//		static void siaM() {
			// static ����Ұ�, Outter �ʵ�� �浹
//		}
	}
}