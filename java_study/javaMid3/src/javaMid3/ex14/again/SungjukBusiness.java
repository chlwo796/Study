package javaMid3.ex14.again;

import java.util.Scanner;

public class SungjukBusiness {

	void input(SungJuk sj) {
//		����κ��� ���������ϵ��� ¥����!!
		Scanner sc = new Scanner(System.in);
		System.out.print("����� : ");
		sj.setSubject(sc.nextLine());
		System.out.print("�߰�������� : ");
		sj.setMidtermExam(sc.nextInt());
		System.out.print("�⸻������� : ");
		sj.setFinals(sc.nextInt());
		System.out.print("���������� : ");
		sj.setPerformanceEvalution(sc.nextInt());

		if (sj instanceof ElemantaryStudent) {
			calculator(sj);
		} else if (sj instanceof MiddleSchooler) {
			System.out.print("��米�� : ");
			MiddleSchooler ms = (MiddleSchooler) sj;
			ms.setTeacher(sc.nextLine());
			sc.nextLine();
//			teacher�� middleSchooler Ŭ�����ʵ��̴�.
			System.out.print("�⼮���� : ");
			ms.setAttendance(sc.nextInt());
			System.out.print("�������� : ");
			ms.setServie(sc.nextInt());
			calculator(ms);

		} else if (sj instanceof HighSchoolStudent) {
			System.out.print("��米�� : ");
			HighSchoolStudent hs = (HighSchoolStudent) sj;
			hs.setTeacher(sc.nextLine());
			sc.nextLine();
			System.out.print("�⼮���� : ");
			hs.setAttendance(sc.nextInt());
			System.out.print("�������� : ");
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