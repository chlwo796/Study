package javaMid3.ex14.again;

public class ElemantaryStudent extends SungJuk {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�ʵ��л�";
	}

	@Override
	void printAll() {
		System.out.println("---------------");
		System.out.println("�ʵ��б� �����Դϴ�.");
		System.out.println("---------------");
		System.out.println("����� : " + getSubject());
		System.out.println(
				"���� : �߰���� " + getMidtermExam() + ", �⸻��� : " + getFinals() + ", ������ : " + getPerformanceEvalution());
		System.out.println("���� : " + getScore());
	}
}
