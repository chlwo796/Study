package javaMid3.ex14.again;

import java.util.Scanner;

public class SungjukBusiness {

	void input(SungJuk sj) {
//		공통부분을 먼저실행하도록 짜본다!!
		Scanner sc = new Scanner(System.in);
		System.out.print("과목명 : ");
		sj.setSubject(sc.nextLine());
		System.out.print("중간고사점수 : ");
		sj.setMidtermExam(sc.nextInt());
		System.out.print("기말고사점수 : ");
		sj.setFinals(sc.nextInt());
		System.out.print("수행평가점수 : ");
		sj.setPerformanceEvalution(sc.nextInt());

		if (sj instanceof ElemantaryStudent) {
			calculator(sj);
		} else if (sj instanceof MiddleSchooler) {
			System.out.print("담당교사 : ");
			MiddleSchooler ms = (MiddleSchooler) sj;
			ms.setTeacher(sc.nextLine());
			sc.nextLine();
//			teacher는 middleSchooler 클래스필드이다.
			System.out.print("출석점수 : ");
			ms.setAttendance(sc.nextInt());
			System.out.print("봉사점수 : ");
			ms.setServie(sc.nextInt());
			calculator(ms);

		} else if (sj instanceof HighSchoolStudent) {
			System.out.print("담당교사 : ");
			HighSchoolStudent hs = (HighSchoolStudent) sj;
			hs.setTeacher(sc.nextLine());
			sc.nextLine();
			System.out.print("출석점수 : ");
			hs.setAttendance(sc.nextInt());
			System.out.print("봉사점수 : ");
			hs.setServie(sc.nextInt());
			calculator(hs);
		}
	}

	void output(SungJuk sj) {
		
		sj.printAll();
	}

	void calculator(SungJuk sj) {
		if (sj instanceof ElemantaryStudent) {
			sj.setScore(sj.getMidtermExam() + sj.getFinals() + sj.getPerformanceEvalution());
		} else if (sj instanceof MiddleSchooler) {
			MiddleSchooler ms = (MiddleSchooler) sj;
			ms.setScore(ms.getMidtermExam() + ms.getFinals() + ms.getAttendance() + ms.getServie()
					+ ms.getPerformanceEvalution());
		} else if (sj instanceof HighSchoolStudent) {
			HighSchoolStudent hs = (HighSchoolStudent) sj;
			hs.setScore(hs.getMidtermExam() + hs.getFinals() + hs.getAttendance() + hs.getServie()
					+ hs.getPerformanceEvalution());
			hs.setStandardDeviation(12.12);
		}

	}
}