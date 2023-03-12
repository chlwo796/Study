package javaChap19.example06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<String, SocketClient>());

	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("���� ���۵�");
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {
			}

		});
		thread.start();
	}

	public static void main(String[] args) {

		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();

			System.out.println("----------------------------------------------");
			System.out.println("������ �����Ϸ��� q �Ǵ� Q�� �Է��ϰ� EnterŰ�� �Է��ϼ���.");
			System.out.println("----------------------------------------------");

			Scanner sc = new Scanner(System.in);

			while (true) {
				String key = sc.nextLine();
				if (key.equalsIgnoreCase("q")) {
					break;
				}
			}
			sc.close();
			chatServer.stop();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��������");

	}

	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("���� : " + key);
		System.out.println("���� ä���� �� : " + chatRoom.size() + "\n");
	}

	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);

		String json = root.toString();
		Collection<SocketClient> socketClients = chatRoom.values();
		for (SocketClient sc : socketClients) {
			if (sc == sender) {
				continue;
			}
			sc.send(json);
		}

	}

	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("��������");
		} catch (IOException e) {
		}

	}

	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("���� : " + key);
		System.out.println("���� ä���� �� : " + chatRoom.size() + "\n");
	}
}
