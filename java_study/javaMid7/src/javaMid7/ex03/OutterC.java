package javaMid7.ex03;

public class OutterC {
	int ia = 10;
	static int sia = 20;

	void iaM() {

		class InnerC {
			int ic = 100;
//			static int sic = 30;

			void icM() {
				ia = ia + 100; // outterŬ������ ��� ��� ����
				ic = ic + 10; // InnerŬ������ ���
				System.out.println("OutterC.iaM().InnerC.icM()");
			}

//			static void sicM() {
//				System.out.println("OutterC.iaM().InnerC.sicM()");
//			}

		}
//		�޼ҵ� ���� ���� ��ü�����ϰ� �����͸� ����ؾ��Ѵ�. ��������
//		�޼ҵ尡 Ŭ������ �����ϴ� ���
		InnerC innerC = new InnerC();
		innerC.icM();
	}

	static void siaM() {

	}

}