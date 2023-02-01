package javaMid3.ex13.again;

import java.util.Scanner;

public class SaleBusiness {
//	������ Ŭ�������� �����ϰ� �⺻�����ڿ��� ��ü�������ش�. �ٸ��޼ҵ忡���� ������ �ٷ� �����پ� �� �ֵ���!
	SeoulJisa sj;
	KyeonginJisa kij;
	KangwonJisa kj;
	JejuJisa je;
	Jisa js;
	Scanner sc;

	public SaleBusiness() {
//		SaleBusiness�� �ν��Ͻ�ȭ �����μ� �ٷ� ����Ǵ� �͵�
		sc = new Scanner(System.in);
		sj = new SeoulJisa();
		kij = new KyeonginJisa();
		kj = new KangwonJisa();
		je = new JejuJisa();

	}

	public void input() {
//		�Է´��
		String yn = "n";
		do {
			System.out.println("�����?");
			System.out.println("1. �������� | 2. �������� | 3. �������� | 4. ��������");
			System.out.println("����>");
			int jisaSelect = 0;
			jisaSelect = sc.nextInt();
			switch (jisaSelect) {
			case 1:
				jisaInput(sj); // sj��� ������ �ִ°��� toSrtring �޼ҵ��� ���ϰ��� �ٷ� ����.
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
			System.out.println("��� �Ͻðڽ��ϱ�?(y/n)");
			yn = sc.next();
		} while (yn.equalsIgnoreCase("y"));
	}

	private void jisaInput(Jisa js) {
//		�θ�Ÿ������ method�� ��������� ������ ���� switch�� �ȿ� �޼ҵ带 ��� �� �������Ѵ�.
		System.out.print("��ǰ��?");
		if(js instanceof SeoulJisa) {
			sj.setProName(sc.next());
			sc.nextLine();
			System.out.print(sj + " " + sj.getProName() + " �Ǹŷ���?");
			sj.setSaleAmount(sc.nextInt());
			sj.setSaleStatus(saleStatusMethod(sj.getProName(), sj.getSaleAmount()));
			sj.setProPrice(proPriveInput(sj.getProName()));
			System.out.print(sj + " " + sj.getProName() + " " + sj.getSaleAmount() + " " + sj.getSaleStatus());
		}
		
		if (js instanceof KyeonginJisa) {
			kij = (KyeonginJisa) js;
			kij.setProName(sc.next());
			sc.nextLine();
			System.out.print(kij + " " + kij.getProName() + " �Ǹŷ���?");
			kij.setSaleAmount(sc.nextInt());
			kij.setSaleStatus(saleStatusMethod(kij.getProName(), kij.getSaleAmount()));
			kij.setProPrice(proPriveInput(kij.getProName()));
			System.out.print(kij + " " + kij.getProName() + " " + kij.getSaleAmount() + " " + kij.getSaleStatus());
		}
		if (js instanceof KangwonJisa) {
			kj = (KangwonJisa) js;
			kj.setProName(sc.next());
			sc.nextLine();
			System.out.print(kj + " " + kj.getProName() + " �Ǹŷ���?");
			kj.setSaleAmount(sc.nextInt());
			kj.setSaleStatus(saleStatusMethod(kj.getProName(), kj.getSaleAmount()));
			kj.setProPrice(proPriveInput(kj.getProName()));
			System.out.print(kj + " " + kj.getProName() + " " + kj.getSaleAmount() + " " + kj.getSaleStatus());
		}
		if (js instanceof JejuJisa) {
			je = (JejuJisa) js;
			je.setProName(sc.next());
			sc.nextLine();
			System.out.print(je + " " + je.getProName() + " �Ǹŷ���?");
			je.setSaleAmount(sc.nextInt());
			je.setSaleStatus(saleStatusMethod(je.getProName(), je.getSaleAmount()));
			je.setProPrice(proPriveInput(je.getProName()));
			System.out.print(je + " " + je.getProName() + " " + je.getSaleAmount() + " " + je.getSaleStatus());
		}
	}

	public void output() {
//		��´��
		System.out.println("--------------------------");
		System.out.println("------�� ���纰 �Ǹ� ��Ȳ------");
		System.out.println("--------------------------");
		System.out.printf("%10s%10s%10s%10s%10s\n", "�����", "��ǰ��", "��ǰ����", "�Ǹŷ�", "������Ȳ");
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
//		�ڽ�Ŭ���������� ����Ѵٸ� private�� ó�����ִ� ���� ����.
//		������Ȳ���, �Է¹ް� �ٷ� ��� �� �������ش�.
		int saleStatus = 0;
		if (proName.equals("��ǻ��")) {
			saleStatus = 2000000 * amount;
		} else if (proName.equals("������")) {
			saleStatus = 500000 * amount;
		} else {
			System.out.println("��ǰ�� �߸��Է��߽��ϴ�.");
		}
		return saleStatus;
	}

	private int proPriveInput(String proName) {
		if (proName.equals("��ǻ��")) {
			return 2000000;
		} else if (proName.equals("������")) {
			return 500000;
		}
		return 0;
	}

}
