package javaMid3.ex14;

public class High extends School {
//	������ ǥ�������߰�
	public High() {
//	����л� �⺻������, �⼮,�������� �߰��� �Է¹޾ƺ���?
		super("00����б�");

	}

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
		super.sd = 23.12;
	}

	@Override
	void print(School[] scoreArray) {
		System.out.println("�����\t��米��\t�߰�\t�⸻\t������\t�⼮����\t��������\tǥ������\t����");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			if (!(scoreArray[i].schoolName).contains("����б�")) {
				continue;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].teacher + "\t" + scoreArray[i].midExam
					+ "\t" + scoreArray[i].finalExam + "\t" + scoreArray[i].performTest + "\t"
					+ scoreArray[i].attendance + "\t" + scoreArray[i].volunteer + "\t" + scoreArray[i].sd + "\t"
					+ scoreArray[i].totalScore);
		}
	}
}
