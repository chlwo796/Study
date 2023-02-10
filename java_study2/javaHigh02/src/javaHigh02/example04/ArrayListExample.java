package javaHigh02.example04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Data> arrayList1 = new ArrayList<Data>();

		arrayList1.add(new Data("4��3��", "BC103", "������", 230, 276000, "3470-1234"));
		arrayList1.add(new Data("4��5��", "BL203", "���ʱ�", 150, 180000, "3470-2200"));
		arrayList1.add(new Data("4��8��", "AC205", "���ı�", 270, 324000, "3470-3300"));

		System.out.println("��������\t�ŷ�ó�ڵ�\t��������\t�Ǹŷ�\t����ݾ�\t����ó");
		for (int i = 0; i < arrayList1.size(); i++) {
			System.out.print(arrayList1.get(i).getDate() + "\t");
			System.out.print(arrayList1.get(i).getCode() + "\t");
			System.out.print(arrayList1.get(i).getArea() + "\t");
			System.out.print(arrayList1.get(i).getSaleAmmount() + "\t");
			System.out.print(arrayList1.get(i).getSalePrice() + "\t");
			System.out.print(arrayList1.get(i).getPhoneNumber() + "\n");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("�ŷ�ó �ڵ��?");
		String searchCode = sc.nextLine();
		boolean search = true;
		for (int i = 0; i < arrayList1.size(); i++) {
			if (arrayList1.get(i).getCode().equals(searchCode)) {
				System.out
						.print("���������� " + arrayList1.get(i).getArea() + "\n����ó�� " + arrayList1.get(i).getPhoneNumber());
				search = false;
			}
		}
		if (search) {
			System.out.println("�ڷᰡ �����ϴ�.");
		}
		int max = 0;
		int indexMax = 0;
		for (int i = 0; i < arrayList1.size(); i++) {
			if (max < arrayList1.get(i).getSalePrice()) {
				max = arrayList1.get(i).getSalePrice();
				indexMax = i;
			}
		}
		System.out.println("�ε��� : " + indexMax + ", �ִ������ : " + max);

		int min = Integer.MAX_VALUE;
		int indexMin = 0;
		System.out.println(min);
		for (int i = 0; i < arrayList1.size(); i++) {
			if (min > arrayList1.get(i).getSaleAmmount()) {
				min = arrayList1.get(i).getSaleAmmount();
				indexMin = i;
			}
		}
		System.out.println("�ε��� : " + indexMin + ", �ּ��Ǹŷ��� : " + arrayList1.get(indexMin).getSaleAmmount());
	}
}