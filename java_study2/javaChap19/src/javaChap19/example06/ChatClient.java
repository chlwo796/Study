package javaChap19.example06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;

	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("Ŭ���̾�Ʈ ������ �����");
	}

	public void receive() {
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + ">" + message);
				} catch (IOException e) {
					System.out.println("Ŭ���̾�Ʈ ���� ���� ����");
					System.exit(0);
				}
			}
		});
		thread.start();
	}

	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}

	public void unconnect() throws IOException {
		socket.close();
	}

	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();

			Scanner scanner = new Scanner(System.in);
			System.out.print("��ȭ�� �Է� : ");
			chatClient.chatName = scanner.nextLine();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);

			chatClient.receive();

			System.out.println("----------------------------------------------");
			System.out.println("���� �޼����� �Է��ϰ� Enter");
			System.out.println("������ �����Ϸ��� q �Ǵ� Q�� �Է��ϰ� Enter");
			System.out.println("----------------------------------------------");

			while (true) {
				String message = scanner.nextLine();
				if (message.equalsIgnoreCase("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}

			scanner.close();
			chatClient.unconnect();
		} catch (Exception e) {
			System.out.println("Ŭ���̾�Ʈ ���� ���� �ȵ�");
		}
		System.out.println("Ŭ���̾�Ʈ ����");
	}
}
