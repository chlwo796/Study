package student.Management;

import java.util.Scanner;

public class LectureManagement {

	   public static void main(String[] args) {
	      Management cont = new Management();
	      boolean flage = true;
	      Scanner sc = new Scanner(System.in);
	      while (flage) {
	         System.out.println("-----------------------------------------------------------");
	         System.out.println("1.���� �˻� | 2.��ü ���� ��� | 3.������ �˻� | 4. ����ȭ������");
	         System.out.println("-----------------------------------------------------------");
	         System.out.print("1�� ~ 4���� ���ϴ� ��ȣ�� �Է��ϼ��� -> ");
	         String menu = sc.nextLine();
	         System.out.println(" ");

	         switch (menu) {

	         case "1":
	            cont.serch();
	            break;
	         case "2":
	            cont.serchAll();
	            break;
	         case "3":
	            cont.serch();
	            break;
	         case "4":
	            System.out.println("����ȭ������");
	            flage = false;
	            break;
	         default:
	            System.out.println("�߸��Է��ϼ̽��ϴ�. 1�� ~ 4���� ���ϴ� ��ȣ�� �Է��ϼ���. ");
	         }
	      }
	   }
	}