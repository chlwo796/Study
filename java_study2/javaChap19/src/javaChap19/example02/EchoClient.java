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
//			String sendMessage = "나는 자바가 좋아~~~~~";
//			OutputStream os = socket.getOutputStream();
//			byte[] bytes = sendMessage.getBytes("UTF-8");
//			os.write(bytes);
//			os.flush();
//			System.out.println("[클라이언트] 데이터 보냄 :" + sendMessage);
//
//			InputStream is = socket.getInputStream();
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String receiveMessage = new String(bytes, 0, readByteCount,"UTF-8");
//			System.out.println("[클라이언트] 데이터 받음 :" + receiveMessage);

			String sendMessage = "나는 자바가 좋아~~~";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄 :" + sendMessage);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음 :" + receiveMessage);

			System.out.println("[클라이언트] 연결 성공");

			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}