package javaChap15.example07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> queue = new LinkedList<Message>();
		queue.offer(new Message("�ȳ��ϼ���", "ȫ�浿"));
		queue.offer(new Message("�ȳ��ϼ���!", "���ڹ�"));
		queue.offer(new Message("�ȳ��ϼ���!!", "���ڹ�"));
		
		while(!queue.isEmpty()) {
			Message message = queue.poll();
			System.out.println(message.to + " ���� " + message.command + " �޼����� �����ϴ�.");
		}
	}
}
