package javaMid3.ex13.again;

import java.util.Scanner;

public class SaleBusiness {
//	변수만 클래스에서 생성하고 기본생성자에서 객체생성해준다. 다른메소드에서도 변수를 바로 가져다쓸 수 있도록!
	SeoulJisa sj;
	KyeonginJisa kij;
	KangwonJisa kj;
	JejuJisa je;
	Jisa js;
	Scanner sc;

	public SaleBusiness() {
//		SaleBusiness를 인스턴스화 함으로서 바로 실행되는 것들
		sc = new Scanner(System.in);
		sj = new SeoulJisa();
		kij = new KyeonginJisa();
		kj = new KangwonJisa();
		je = new JejuJisa();

	}

	public void input() {
//		입력담당
		String yn = "n";
		do {
			System.out.println("지사는?");
			System.out.println("1. 서울지사 | 2. 경인지사 | 3. 강원지사 | 4. 제주지사");
			System.out.println("선택>");
			int jisaSelect = 0;
			jisaSelect = sc.nextInt();
			switch (jisaSelect) {
			case 1:
				jisaInput(sj); // sj라는 변수를 넣는것은 toSrtring 메소드의 리턴값이 바로 들어간다.
				break;
			case 2:
				jisaInput(kij);
				break;
			case 3:
				jisaInput(kj);
				break;
			case 4:
				jisaInput(je);
				break;
			}
			System.out.println("계속 하시겠습니까?(y/n)");
			yn = sc.next();
		} while (yn.equalsIgnoreCase("y"));
	}

	private void jisaInput(Jisa js) {
//		부모타입으로 method를 만들어주지 않으면 각각 switch문 안에 메소드를 모두 다 만들어야한다.
		System.out.print("제품은?");
		if(js instanceof SeoulJisa) {
			sj.setProName(sc.next());
			sc.nextLine();
			System.out.print(sj + " " + sj.getProName() + " 판매량은?");
			sj.setSaleAmount(sc.nextInt());
			sj.setSaleStatus(saleStatusMethod(sj.getProName(), sj.getSaleAmount()));
			sj.setProPrice(proPriveInput(sj.getProName()));
			System.out.print(sj + " " + sj.getProName() + " " + sj.getSaleAmount() + " " + sj.getSaleStatus());
		}
		
		if (js instanceof KyeonginJisa) {
			kij = (KyeonginJisa) js;
			kij.setProName(sc.next());
			sc.nextLine();
			System.out.print(kij + " " + kij.getProName() + " 판매량은?");
			kij.setSaleAmount(sc.nextInt());
			kij.setSaleStatus(saleStatusMethod(kij.getProName(), kij.getSaleAmount()));
			kij.setProPrice(proPriveInput(kij.getProName()));
			System.out.print(kij + " " + kij.getProName() + " " + kij.getSaleAmount() + " " + kij.getSaleStatus());
		}
		if (js instanceof KangwonJisa) {
			kj = (KangwonJisa) js;
			kj.setProName(sc.next());
			sc.nextLine();
			System.out.print(kj + " " + kj.getProName() + " 판매량은?");
			kj.setSaleAmount(sc.nextInt());
			kj.setSaleStatus(saleStatusMethod(kj.getProName(), kj.getSaleAmount()));
			kj.setProPrice(proPriveInput(kj.getProName()));
			System.out.print(kj + " " + kj.getProName() + " " + kj.getSaleAmount() + " " + kj.getSaleStatus());
		}
		if (js instanceof JejuJisa) {
			je = (JejuJisa) js;
			je.setProName(sc.next());
			sc.nextLine();
			System.out.print(je + " " + je.getProName() + " 판매량은?");
			je.setSaleAmount(sc.nextInt());
			je.setSaleStatus(saleStatusMethod(je.getProName(), je.getSaleAmount()));
			je.setProPrice(proPriveInput(je.getProName()));
			System.out.print(je + " " + je.getProName() + " " + je.getSaleAmount() + " " + je.getSaleStatus());
		}
	}

	public void output() {
//		출력담당
		System.out.println("--------------------------");
		System.out.println("------각 지사별 판매 현황------");
		System.out.println("--------------------------");
		System.out.printf("%10s%10s%10s%10s%10s\n", "지사명", "제품명", "제품가격", "판매량", "매출현황");
		System.out.printf("%10s%10s%10s%10s%10s\n", sj, sj.getProName(), sj.getProPrice(), sj.getSaleAmount(),
				sj.getSaleStatus());
		System.out.printf("%10s%10s%10s%10s%10s\n", kij, kij.getProName(), kij.getProPrice(), kij.getSaleAmount(),
				kij.getSaleStatus());
		System.out.printf("%10s%10s%10s%10s%10s\n", kj, kj.getProName(), kj.getProPrice(), kj.getSaleAmount(),
				kj.getSaleStatus());
		System.out.printf("%10s%10s%10s%10s%10s\n", je, je.getProName(), je.getProPrice(), je.getSaleAmount(),
				je.getSaleStatus());

	}

	private int saleStatusMethod(String proName, int amount) {
//		자신클래스에서만 사용한다면 private로 처리해주는 것이 좋다.
//		매출현황담당, 입력받고 바로 계산 후 리턴해준다.
		int saleStatus = 0;
		if (proName.equals("컴퓨터")) {
			saleStatus = 2000000 * amount;
		} else if (proName.equals("프린터")) {
			saleStatus = 500000 * amount;
		} else {
			System.out.println("제품을 잘못입력했습니다.");
		}
		return saleStatus;
	}

	private int proPriveInput(String proName) {
		if (proName.equals("컴퓨터")) {
			return 2000000;
		} else if (proName.equals("프린터")) {
			return 500000;
		}
		return 0;
	}

}
