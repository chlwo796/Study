package exBasic;

public class MyFirst {

	public static void main(String[] args) {
		//���� �����ϱ�
		String university; //���и�
		String department; //���� : �ҹ���
		String student_id; //�ΰ��� ���ڰ� ������ ��� studentId Ȥ�� student_id
		
		//������ ���� �ֱ�
		university = "������б�";
		department = "��ǻ�Ͱ��а�";
		student_id = "23080511";
		
		System.out.println(university);
		System.out.println(department);
		System.out.println(student_id);
		
		System.out.println("---------------");
		System.out.println("�б� : "+university); //syso ctrl+space �� �����ϰ�
		System.out.println("�а� : "+department); //�ݺ��Ǵ� �����鵵 ctrl+space �� �����ϰ�
		System.out.println("�й� : "+student_id);
		
		System.out.println("---------------");
		System.out.println("�б� : "+university+", "+"�а� : "+department+", "+"�й� : "+student_id);
		
		System.out.println("---------------");
		//print�� ���� �� �ٹٲ���������.
		System.out.print("�б� : "+university);
		System.out.print(" �а� : "+department);
		System.out.print(" �й� : "+student_id);
		
		System.out.println("---------------");
		//printf format�� ���缭 ���
		System.out.printf("�б� : %s, �а� : %s, �й� : %s", university, department, student_id);
		//ù��° ����(university)�� ù��° %s��
	}

}
