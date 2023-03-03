package javaChap16.exercise08;

public class Example {
	private static Student[] students = { new Student("ȫ�浿", 90, 96), new Student("�ſ��", 95, 93) };

	public static double avg(Function<Student> function) {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += function.apply(students[i]);
		}
		double result = (double) sum / students.length;
		return result;
	}

	public static void main(String[] args) {
//		double englishAvg = avg(s -> s.getEnglishScore());
		double englishAvg = avg(Student::getEnglishScore);
		System.out.println("���� ��� ���� : " + englishAvg);

//		double mathAvg = avg(s -> s.getMathScore());
		double mathAvg = avg(Student::getMathScore);
		System.out.println("���� ��� ���� : " + mathAvg);
	}
}