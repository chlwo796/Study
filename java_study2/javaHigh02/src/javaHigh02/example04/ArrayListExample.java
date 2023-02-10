package javaHigh02.example04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Data> arrayList1 = new ArrayList<Data>();

		arrayList1.add(new Data("4월3일", "BC103", "강남구", 230, 276000, "3470-1234"));
		arrayList1.add(new Data("4월5일", "BL203", "서초구", 150, 180000, "3470-2200"));
		arrayList1.add(new Data("4월8일", "AC205", "송파구", 270, 324000, "3470-3300"));

		System.out.println("매출일자\t거래처코드\t매출지역\t판매량\t매출금액\t연락처");
		for (int i = 0; i < arrayList1.size(); i++) {
			System.out.print(arrayList1.get(i).getDate() + "\t");
			System.out.print(arrayList1.get(i).getCode() + "\t");
			System.out.print(arrayList1.get(i).getArea() + "\t");
			System.out.print(arrayList1.get(i).getSaleAmmount() + "\t");
			System.out.print(arrayList1.get(i).getSalePrice() + "\t");
			System.out.print(arrayList1.get(i).getPhoneNumber() + "\n");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("거래처 코드는?");
		String searchCode = sc.nextLine();
		boolean search = true;
		for (int i = 0; i < arrayList1.size(); i++) {
			if (arrayList1.get(i).getCode().equals(searchCode)) {
				System.out
						.print("매출지역은 " + arrayList1.get(i).getArea() + "\n연락처는 " + arrayList1.get(i).getPhoneNumber());
				search = false;
			}
		}
		if (search) {
			System.out.println("자료가 없습니다.");
		}
		int max = 0;
		int indexMax = 0;
		for (int i = 0; i < arrayList1.size(); i++) {
			if (max < arrayList1.get(i).getSalePrice()) {
				max = arrayList1.get(i).getSalePrice();
				indexMax = i;
			}
		}
		System.out.println("인덱스 : " + indexMax + ", 최대매출은 : " + max);

		int min = Integer.MAX_VALUE;
		int indexMin = 0;
		System.out.println(min);
		for (int i = 0; i < arrayList1.size(); i++) {
			if (min > arrayList1.get(i).getSaleAmmount()) {
				min = arrayList1.get(i).getSaleAmmount();
				indexMin = i;
			}
		}
		System.out.println("인덱스 : " + indexMin + ", 최소판매량은 : " + arrayList1.get(indexMin).getSaleAmmount());
	}
}