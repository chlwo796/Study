package javaHigh09.exercise08;

public class Example {
	private static Student[] students = { new Student("ȫ�浿", 80, 95), new Student("�ſ��", 90, 87) };

	public static double avg(Function<Student> function) {
		// ����� ���ϴ� �ڵ� �ۼ��ϰ� ����� �����Ѵ�. = �ǻ��ڵ�(�ּ�ó���� ���� ����)
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += function.apply(students[i]);
		}
		double avg = (double) sum / students.length;

		return avg;
	}

	public static void main(String[] args) {
//		double englishAvg = avg(s -> s.getEnglishScore());
		double englishAvg = avg(Student :: getEnglishScore);
		System.out.println("���� ��� ���� : " + englishAvg);

//		double mathAvg = avg(s -> s.getMathScore());
		double mathAvg = avg(Student::getMathScore);
		System.out.println("���� ��� ���� : " + mathAvg);
	}
}