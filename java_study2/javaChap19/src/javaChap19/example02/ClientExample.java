package javaChap19.example02;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("172.30.1.13", 50001);
			
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
			
			socket.close();
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}