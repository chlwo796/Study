package javaChap19.example03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;

	public static void main(String[] args) {
		System.out.println("----------------------------------------------");
		System.out.println("������ �����Ϸ��� q �Ǵ� Q�� �Է��ϰ� EnterŰ�� �Է��ϼ���.");
		System.out.println("----------------------------------------------");
		startServer();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String key = sc.nextLine();
			if (key.equalsIgnoreCase("q")) {
				break;
			}
		}
		sc.close();

		stopServer();
	}

	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[����] ���۵�");

					while (true) {
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);
						String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

						SocketAddress socketAddress = receivePacket.getSocketAddress();
						for (int i = 0; i <= 10; i++) {
							String data = newsKind + " : ����" + i;
							byte[] bytes = data.getBytes("UTF-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
						}
					}
				} catch (IOException e) {
					System.out.println("[����]" + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public static void stopServer() {

		datagramSocket.close();
		System.out.println("[����] �����");
	}
}