package javaChap19.example02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("172.30.1.13", 50001);
//			String sendMessage = "���� �ڹٰ� ����~~~~~";
//			OutputStream os = socket.getOutputStream();
//			byte[] bytes = sendMessage.getBytes("UTF-8");
//			os.write(bytes);
//			os.flush();
//			System.out.println("[Ŭ���̾�Ʈ] ������ ���� :" + sendMessage);
//
//			InputStream is = socket.getInputStream();
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String receiveMessage = new String(bytes, 0, readByteCount,"UTF-8");
//			System.out.println("[Ŭ���̾�Ʈ] ������ ���� :" + receiveMessage);

			String sendMessage = "���� �ڹٰ� ����~~~";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[Ŭ���̾�Ʈ] ������ ���� :" + sendMessage);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[Ŭ���̾�Ʈ] ������ ���� :" + receiveMessage);

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