package javaMid3.ex14.again;

public class HighSchoolStudent extends MiddleSchooler {	// ������Ȯ��!����б��� ���б��� ��ӹ޾Ҵ�.
	private double standardDeviation; // ǥ������

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "����л�";
		}
	@Override
		void printAll() {
		System.out.println("---------------");
		System.out.println("����б� �����Դϴ�.");
		System.out.println("---------------");
		System.out.println("����� : " + getSubject());
		System.out.println("��米�� : " + getTeacher());
		System.out.println(
				"���� : �߰���� " + getMidtermExam() + ", �⸻��� : " + getFinals() + ", ������ : " + getPerformanceEvalution() + ", �⼮���� : " + getAttendance() + ", �������� : " + getServie() + ", ǥ������ : " + getStandardDeviation());
		System.out.println("���� : " + getScore());
		}
}
