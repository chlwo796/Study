package javaHigh11.example01;

// util ��Ű���� ��� �� import
import java.util.*;

public class ParalleStreamEx01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		list.parallelStream().forEach(n -> {
			System.out.println(n);
			// ����ó���� ��Ʈ���� ����ó��x, ��Ƽ������� ó���ӵ��� �� ������.
			System.out.println(Thread.currentThread().getName());
		});
	}
}