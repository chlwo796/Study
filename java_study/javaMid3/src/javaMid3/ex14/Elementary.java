package javaMid3.ex14;

public class Elementary extends School {
//	�ʵ��л� ������
	public Elementary() {
		super("00�ʵ��б�");
	}

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest;
	}

	@Override
	void print(School[] scoreArray) {
		System.out.println("�����\t�߰�\t�⸻\t������\t����");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			if (!(scoreArray[i].schoolName).contains("�ʵ��б�")) {
				continue;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].midExam + "\t" + scoreArray[i].finalExam
					+ "\t" + scoreArray[i].performTest + "\t" + scoreArray[i].totalScore);
		}
	}
}