package javaChap19.example06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	ChatServer chatServer;
	Socket socket;
	String clientIp;
	String chatName;
	DataInputStream dis;
	DataOutputStream dos;

	public SocketClient(ChatServer chatServer, Socket socket) {
		try {

			this.chatServer = chatServer;
			this.socket = socket;

			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {

					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
					case "incoming": {
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "�����̽��ϴ�.");
						chatServer.addSocketClient(this);
						break;
					}
					case "message": {
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}

					}

				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "�����̽��ϴ�.");
				chatServer.removeSocketClient(this);
			}

		});

	}

	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}

	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
}
