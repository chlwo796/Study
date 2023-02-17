package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		//�л� ���� ���
		
		//����Ʈ ����
		List<Student> studentArray = new ArrayList<Student>();
		
		//��ü �߰�
		studentArray.add(new Student("ȫ�浿", "010-1111-1111", "1��", "����"));
		studentArray.add(new Student("�̼���", "010-2222-2222", "2��", "����"));
		studentArray.add(new Student("������", "010-3333-3333", "1��", "����"));
		
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		boolean flag = true;
		String searchName;
		
		
		
		System.out.println("------------------------------------------------------");
		System.out.println("1.�л��˻� 2.�л���� 3.�л� �������� 4.�л����� 5.����ȭ������");
		System.out.println("------------------------------------------------------");
		System.out.print("�޴� ���� > ");
		menuSelect = sc.nextInt();
		sc.nextLine();
		
		while(flag) {
			
			switch(menuSelect) {
				case 1: //�л� �˻�
					boolean searchOk = false;
					System.out.print("�л� �̸��� �Է����ּ���. > ");
					searchName = sc.nextLine();
					
					for(int i = 0; i<studentArray.size(); i++) {
						
						if(searchName.equals(studentArray.get(i).getStudentName())) {
							System.out.println("�̸�: " + studentArray.get(i).getStudentName());
							System.out.println("��ȭ��ȣ: " + studentArray.get(i).getPhoneNum());
							System.out.println("��������: " + studentArray.get(i).getSubjectName());
							System.out.println("��: " + studentArray.get(i).getClassName());
							searchOk = true;
							
							
						} 
						
//						if(!(studentArray.get(i).studentName.equals(searchName))) {
//							System.out.println("��ϵ��� ���� �л��Դϴ�.");
//							break;
//						}
					}
					if (!searchOk) {
						System.out.println("��ϵ��� ���� �л��Դϴ�.\n�ٽ� �Է����ּ���.");
					}
					System.out.println("�߰� �˻� �Ͻðڽ��ϱ�? (Y/N)");
					String input = (sc.nextLine()).toUpperCase();
					if(input.equals("Y")) {
						flag = true;
					}
					if (input.equals("N")) {
						break;
					}
					
					
					break;
				case 2: //�л� ���
					System.out.print("����� �л� �̸� > ");
					String inputName = sc.nextLine();
					System.out.print("��ȭ��ȣ ��� > ");
					String inputPhone = sc.nextLine();
					System.out.print("�������� ��� > ");
					String inputSub = sc.nextLine();
					System.out.print("����� �� > ");
					String inputClass = sc.nextLine();
					
					studentArray.add(new Student(inputName, inputPhone, inputClass, inputSub));
					
					System.out.println("�л� ������ ��ϵǾ����ϴ�.");
					break;
					
				case 3: //�л� ����
					Scanner ms = new Scanner(System.in);
					System.out.print("�л� �̸��� �Է��ϼ���. > ");
					searchName = sc.nextLine();
					
					for(Student s : studentArray) {
						if(s.studentName.equals(searchName)) {
							System.out.print("������ ��ȭ��ȣ�� �Է��ϼ���. > ");
							s.phoneNum = ms.nextLine();
							
							if(s.phoneNum.length()<=13) {
								System.out.println("������ �����Ǿ����ϴ�.");
							} else {
								System.out.println("�߸��� �Է��Դϴ�.");
							}
							
						} else {
							System.out.println("��ϵ��� ���� �л��Դϴ�.");
						}
						
					}
					
					break;
					
				case 4: //�л� ����
					
				case 5: //���� ȭ������
					
				default: System.out.println("�߸��� �Է��Դϴ�."); break;
			}
			
		}
		
		

	}

}