package javaChap16.exercise08;

public class Example {
	private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

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
		System.out.println("영어 평균 점수 : " + englishAvg);

//		double mathAvg = avg(s -> s.getMathScore());
		double mathAvg = avg(Student::getMathScore);
		System.out.println("수학 평균 점수 : " + mathAvg);
	}
}