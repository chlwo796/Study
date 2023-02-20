package javaHigh05.example07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {
	public static void main(String[] args) {
		Queue<Message> queue = new LinkedList<Message>();
		
		queue.offer(new Message("sendMail", "ȫ�浿1"));
		queue.offer(new Message("sendSNS", "ȫ�浿2"));
		queue.offer(new Message("sendKakao", "ȫ�浿3"));
		queue.offer(new Message("sendDm", "ȫ�浿4"));
		
		while(!queue.isEmpty()) {
			Message m = queue.poll();
			System.out.println(m.getTo() + "���� " + m.getCommand().substring(4) + " ��/�� �����ϴ�.");
		}
	}
}
