package exBasic;

public class MyFirst {

	public static void main(String[] args) {
		//변수 선언하기
		String university; //대학명
		String department; //변수 : 소문자
		String student_id; //두개의 문자가 합쳐진 경우 studentId 혹은 student_id
		
		//변수에 값을 넣기
		university = "서울대학교";
		department = "컴퓨터공학과";
		student_id = "23080511";
		
		System.out.println(university);
		System.out.println(department);
		System.out.println(student_id);
		
		System.out.println("---------------");
		System.out.println("학교 : "+university); //syso ctrl+space 로 간편하게
		System.out.println("학과 : "+department); //반복되는 변수들도 ctrl+space 로 간편하게
		System.out.println("학번 : "+student_id);
		
		System.out.println("---------------");
		System.out.println("학교 : "+university+", "+"학과 : "+department+", "+"학번 : "+student_id);
		
		System.out.println("---------------");
		//print는 실행 후 줄바꿈하지않음.
		System.out.print("학교 : "+university);
		System.out.print(" 학과 : "+department);
		System.out.print(" 학번 : "+student_id);
		
		System.out.println("---------------");
		//printf format에 맞춰서 출력
		System.out.printf("학교 : %s, 학과 : %s, 학번 : %s", university, department, student_id);
		//첫번째 변수(university)가 첫번째 %s로
	}

}
