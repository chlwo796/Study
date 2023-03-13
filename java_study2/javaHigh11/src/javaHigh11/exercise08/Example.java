package javaHigh11.exercise08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javaHigh11.exercise07.Member;

public class Example {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("ȫ�浿", "������"), new Member("�質��", "�����̳�"),
				new Member("�ſ��", "������"));

		Map<String, List<Member>> groupingMap = list.stream().collect(Collectors.groupingBy(m -> m.getJob()));
		
		Set<String> job = groupingMap.keySet();

		List<Member> devList = groupingMap.get("������");
		devList.stream().forEach(d -> System.out.println(d));
		System.out.println();
		List<Member> degList = groupingMap.get("�����̳�");
		degList.stream().forEach(d -> System.out.println(d));
	}
}