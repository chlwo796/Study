package javaMid3.ex14.again;

public class MiddleSchooler extends SungJuk {
	private String teacher; // ��米���
	private int attendance; // �⼮����
	private int servie; // ��������

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getServie() {
		return servie;
	}

	public void setServie(int servie) {
		this.servie = servie;
	}

	@Override
	void printAll() {
		System.out.println("---------------");
		System.out.println("���б� �����Դϴ�.");
		System.out.println("---------------");
		System.out.println("����� : " + getSubject());
		System.out.println("��米�� : " + getTeacher());
		System.out.println(
				"���� : �߰���� " + getMidtermExam() + ", �⸻��� : " + getFinals() + ", ������ : " + getPerformanceEvalution() + ", �⼮���� : " + getAttendance() + ", �������� : " + getServie());
		System.out.println("���� : " + getScore());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "���л�";
	}

}
