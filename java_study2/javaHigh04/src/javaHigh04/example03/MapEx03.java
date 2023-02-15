package javaHigh04.example03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx03 {

	public static void main(String[] args) {
//		���Ӽ����� �̸� = key, ��, ���� = value
		Map<String, School> schoolMap = new HashMap<String, School>();

		School school1 = new School("������", new School("3�г�1��", 20));
		School school2 = new School("����ȯ", new School("2�г�2��", 23));
		School school3 = new School("�ƹ���", new School("1�г�3��", 21));
		School school4 = new School("ȫ�浿", new School("2�г�4��", 19));
		School school5 = new School("����", new School("2�г�3��", 24));

		schoolMap.put(school1.getTeacher(), school1.getSchool());
		schoolMap.put(school2.getTeacher(), school2.getSchool());
		schoolMap.put(school3.getTeacher(), school3.getSchool());
		schoolMap.put(school4.getTeacher(), school4.getSchool());
		schoolMap.put(school5.getTeacher(), school5.getSchool());

		// mapping �� �ּҸ� �����߱� ������ key�� ����Ϸ��� ���������� ȣ���Ͽ��� �Ѵ�.

		System.out.println("-------------------");
		System.out.println(school1.getTeacher());
		System.out.println(schoolMap.get(school1.getTeacher()).getGrade());
		System.out.println(schoolMap.get(school1.getTeacher()).getStNumber());

		System.out.println("-------------------");
		System.out.println(school2.getTeacher());
		System.out.println(schoolMap.get(school2.getTeacher()).getGrade());
		System.out.println(schoolMap.get(school2.getTeacher()).getStNumber());

		System.out.println("-------------------");
		System.out.println(school3.getTeacher());
		System.out.println(schoolMap.get(school3.getTeacher()).getGrade());
		System.out.println(schoolMap.get(school3.getTeacher()).getStNumber());

		System.out.println("-------------------");
		System.out.println(school4.getTeacher());
		System.out.println(schoolMap.get(school4.getTeacher()).getGrade());
		System.out.println(schoolMap.get(school4.getTeacher()).getStNumber());

		System.out.println("-------------------");
		System.out.println(school5.getTeacher());
		System.out.println(schoolMap.get(school5.getTeacher()).getGrade());
		System.out.println(schoolMap.get(school5.getTeacher()).getStNumber());

		// keySet();���� key�� Set���� ������ְ� �ݺ��� ȣ��
		System.out.println("------");
		Set<String> keys = schoolMap.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// �������� �ο�����?
		System.out.println("------");
		System.out.println(keys.size());
		System.out.println("------");
		
		it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			School school = schoolMap.get(key);
			System.out.println(key);
		    // get(key) -> value
			System.out.println(school.getGrade());
			System.out.println(school.getStNumber());
		}
	}
}