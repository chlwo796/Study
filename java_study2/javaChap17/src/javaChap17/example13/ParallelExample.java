package javaChap17.example13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelExample {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i < 100000000; i++) {
			scores.add(random.nextInt(101));
		}

		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;
		startTime = System.nanoTime();
		avg = scores.stream().mapToInt(n -> n.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("�⺻��Ʈ��");
		System.out.println("�ɸ��ð� : " + time + "ns");
		System.out.println("��� : " + avg);
		System.out.println();
		startTime = System.nanoTime();
		avg = scores.parallelStream().mapToInt(n -> n.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("parallelStream()���Ľ�Ʈ��");
		System.out.println("�ɸ��ð� : " + time + "ns");
		System.out.println("��� : " + avg);
		System.out.println();
		startTime = System.nanoTime();
		scores.stream().parallel().mapToInt(n -> n.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("parallel()���Ľ�Ʈ��");
		System.out.println("�ɸ��ð� : " + time + "ns");
		System.out.println("��� : " + avg);
	}
}