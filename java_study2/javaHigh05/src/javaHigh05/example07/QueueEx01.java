package javaHigh05.example07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {
	public static void main(String[] args) {
		Queue<Message> queue = new LinkedList<Message>();
		
		queue.offer(new Message("sendMail", "È«±æµ¿1"));
		queue.offer(new Message("sendSNS", "È«±æµ¿2"));
		queue.offer(new Message("sendKakao", "È«±æµ¿3"));
		queue.offer(new Message("sendDm", "È«±æµ¿4"));
		
		while(!queue.isEmpty()) {
			Message m = queue.poll();
			System.out.println(m.getTo() + "¿¡°Ô " + m.getCommand().substring(4) + " À»/¸¦ º¸³À´Ï´Ù.");
		}
	}
}
