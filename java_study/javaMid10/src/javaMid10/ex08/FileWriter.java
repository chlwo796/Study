package javaMid10.ex08;

import java.io.IOException;

public class FileWriter implements AutoCloseable {
	public FileWriter(String filePath) throws IOException {
		System.out.println(filePath + " ������ ���ϴ�.");
	}

	public void write(String data) throws IOException {
		System.out.println(data + "�� ���Ͽ� �����մϴ�.");
	}

	public FileWriter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void close() throws IOException {
		System.out.println("������ �ݽ��ϴ�.");
	}

}
