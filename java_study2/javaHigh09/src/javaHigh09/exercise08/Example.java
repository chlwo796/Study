package javaHigh09.exercise08;

public class Example {
	private static Student[] students = { new Student("홍길동", 80, 95), new Student("신용권", 90, 87) };

	public static double avg(Function<Student> function) {
		// 평균을 구하는 코드 작성하고 평균을 리턴한다. = 의사코드(주석처리로 먼저 설명)
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
		System.out.println("영어 평균 점수 : " + englishAvg);

//		double mathAvg = avg(s -> s.getMathScore());
		double mathAvg = avg(Student::getMathScore);
		System.out.println("수학 평균 점수 : " + mathAvg);
	}
}