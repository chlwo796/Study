package javaHigh02.example03;

import java.util.ArrayList;
import java.util.List;

public class BoardMain {
	public static void main(String[] args) {
		List<Board> boardList1 = new ArrayList<Board>();

		boardList1.add(new Board("����", "�񰡿Ϳ�", "ȫ�浿", "20230210"));
		boardList1.add(new Board("����", "�ݿ���", "��浿", "20230211"));
		boardList1.add(new Board("�ָ�", "������Ʈ", "�̱浿", "20230212"));

		for (int i = 0; i < boardList1.size(); i++) {
			System.out.print(boardList1.get(i).getSubject() + " ");
			System.out.print(boardList1.get(i).getContent() + " ");
			System.out.print(boardList1.get(i).getWriter() + " ");
			System.out.print(boardList1.get(i).getJoinDate() + " ");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < boardList1.size(); i++) {
			System.out.print(boardList1.get(i).getJoinDate() + " ");
		}
		System.out.println();

//		�Խ��� ���� "����"�̶�� ���� �� ����� �̸��� �ۼ����� �˻��غ���
//		���ȭ�� ��浿 0211
//		.contains() Ȥ�� .equals()
		for (int i = 0; i < boardList1.size(); i++) {
			if (boardList1.get(i).getSubject().contains("����")) {
				System.out.print(boardList1.get(i).getSubject() + " " + boardList1.get(i).getJoinDate());
			}
		}System.out.println();
//		�ۼ����� 0210 ���� �Խñ��� ����� ������ ����ϱ�
		for(int i = 0;i<boardList1.size();i++) {
			if(boardList1.get(i).getJoinDate().equals("20230210")) {
				System.out.print(boardList1.get(i).getSubject() + " " + boardList1.get(i).getContent());
			}
		}
	}
}