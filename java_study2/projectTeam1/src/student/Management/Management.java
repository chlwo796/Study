package student.Management;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
   ArrayList<LectureData> list;
   Scanner sc;

   Management() {
      list = new ArrayList();
      sc = new Scanner(System.in);
   }

// ���� �˻�
   void serch() {

      String find; // ���� �̸� �޴� ��

      System.out.print("�˻��� ���� ������ �Է��ϼ��� : ");
      find = sc.next();

      for (int i = 0; i < list.size(); i++) { // list ũ�⸸ŭ for�� ����

         // ���� �˻�
         if (find.equals(list.get(i).getLecture())) {

            System.out.println("���� : " + list.get(i).getLecture());
            System.out.println("������ : " + list.get(i).getTeacherName());
         } else {
            System.out.println("������ �ٽ� Ȯ�����ּ���.");
         }
         break;
      }
   }

// ��ü ���� ���
   void serchAll() {

      System.out.println("��ü ���� ���");
      System.out.println("----------------------------------");
      System.out.println("������   ��缱����   �����ο�   ������");
      System.out.println("----------------------------------");
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i).getLecture() + " " + list.get(i).getTeacherName());
      }
   }

}
