package javaChap19.example02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

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
					serverSocket = new ServerSocket(50001);
					System.out.println("[����] ���۵�");

					while (true) {
						System.out.println("\n[����] ���� ��û�� ��ٸ�\n");

						Socket socket = serverSocket.accept();
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[����]" + isa.getHostName() + "�� ���� ��û�� ������");

						socket.close();
						System.out.println("[����]" + isa.getHostName() + "�� ������ ����");
					}
				} catch (IOException e) {
					System.out.println("[����]" + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public static void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[����] �����");
	}
}