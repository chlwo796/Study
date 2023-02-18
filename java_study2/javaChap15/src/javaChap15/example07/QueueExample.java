package javaChap15.example07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> queue = new LinkedList<Message>();
		queue.offer(new Message("안녕하세요", "홍길동"));
		queue.offer(new Message("안녕하세요!", "김자바"));
		queue.offer(new Message("안녕하세요!!", "이자바"));
		
		while(!queue.isEmpty()) {
			Message message = queue.poll();
			System.out.println(message.to + " 에게 " + message.command + " 메세지를 보냅니다.");
		}
	}
}
