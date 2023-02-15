package javaHigh03.example05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetEx04 {
	public static void main(String[] args) {
		Set<Fare> fareSet = new HashSet<Fare>();

		fareSet.add(new Fare("502", 1, 423, 25000));
		fareSet.add(new Fare("303", 7, 725, 35000));
		fareSet.add(new Fare("403", 2, 222, 40000));
		fareSet.add(new Fare("503", 2, 438, 25000));
		fareSet.add(new Fare("503", 3, 417, 35000));
		fareSet.add(new Fare("504", 4, 248, 45000));
		fareSet.add(new Fare("504", 4, 248, 45000));

		// ��ü���, toString Ȱ���غ���
		Iterator<Fare> it = fareSet.iterator();
		System.out.println("ȣ��\t������\t�����뷮\t�������");
		while (it.hasNext()) {
			Fare fare = it.next();
			System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity() + "\t"
					+ fare.getFee());
		}
		// ȣ���˻�->�����뷮
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		System.out.print("ȣ���� �Է��ϼ���>");
		String searchNumber = sc.nextLine();

		it = fareSet.iterator();
		while (it.hasNext()) {
			Fare fare = it.next();
			if (fare.getNumber().equals(searchNumber)) {
				System.out.println("ȣ�� : " + searchNumber + ", �����뷮 : " + fare.getElectricity());
				check = false;
			}
		}
		if (check) {
			System.out.println("ã���ô� ȣ�� " + searchNumber + "��/�� �����ϴ�.");
		}
		// �ִ������뷮->ȣ��, ������
		// Fare�� �ּҸ� �����ϴ� ���� ���� ����
		Fare maxFare = null;
		int maxElectricity = 0;
		it = fareSet.iterator();
		while (it.hasNext()) {
			Fare fare = it.next();
			if (maxElectricity < fare.getElectricity()) {
				maxElectricity = fare.getElectricity();
				maxFare = fare; // �ּҸ� ���,�����Ͽ� �ٷ� ����Ѵ�.
			}
		}
		System.out.println("�ִ������뷮 " + maxFare.getElectricity() + "�� ������ " + maxFare.getNumber() + "ȣ, ������ : "
				+ maxFare.getFamilyNumber());

		// �ּ� ������� -> ������� 500���߰� -> �ּҰ�����ݵ����Ͱ� ��������� �迭�� ���� ���� �ִ�.
		int minFee = Integer.MAX_VALUE;
		System.out.println(minFee);
		it = fareSet.iterator();
		while (it.hasNext()) {
			Fare fare = it.next();
			if (minFee > fare.getFee()) {
				minFee = fare.getFee();
			}
		}
		System.out.println("�ּ� ������� : " + minFee);
		int additionalFee = 500;
		it = fareSet.iterator();
		while (it.hasNext()) {
			Fare fare = it.next();
			if (minFee == fare.getFee()) {
				fare.setFee(fare.getFee() + additionalFee);
				System.out.println("������� " + additionalFee + "�� �߰��Ͽ����ϴ�.");
				System.out.println("ȣ��\t������\t�����뷮\t�������");
				System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity()
						+ "\t" + fare.getFee());
			}
		}
		// �����뷮 ���, ������� ���
		int sumElectricity = 0;
		int sumFee = 0;
		
		System.out.println("ȣ��\t������\t�����뷮\t�������");
		it = fareSet.iterator();
		while (it.hasNext()) {
			Fare fare = it.next();
			sumElectricity += fare.getElectricity();
			sumFee += fare.getFee();
			System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity() + "\t"
					+ fare.getFee());
		}
		double aveElectricity = (double) sumElectricity / fareSet.size();
		double aveFee = (double) sumFee / fareSet.size();
		System.out.println("�����뷮 ��� : " + aveElectricity + ", ������� ��� : " + aveFee);

	}
}