package no_15552;

//���������� for�� ������ Ǯ�� ���� �����ؾ� �� ���� �ִ�. ����� ����� ������ ���� ���� �Է¹ްų� ����� �� �ð��ʰ��� �� �� �ִٴ� ���̴�.
//C++�� ����ϰ� �ְ� cin/cout�� ����ϰ��� �Ѵٸ�, cin.tie(NULL)�� sync_with_stdio(false)�� �� �� ������ �ְ�, 
//endl ��� ���๮��(\n)�� ����. ��, �̷��� �ϸ� �� �̻� scanf/printf/puts/getchar/putchar �� C�� ����� ����� ����ϸ� �� �ȴ�.
//Java�� ����ϰ� �ִٸ�, Scanner�� System.out.println ��� BufferedReader�� BufferedWriter�� ����� �� �ִ�. 
//BufferedWriter.flush�� �� �������� �� ���� �ϸ� �ȴ�.
//Python�� ����ϰ� �ִٸ�, input ��� sys.stdin.readline�� ����� �� �ִ�. 
//��, �̶��� �� ���� ���๮�ڱ��� ���� �Է¹ޱ� ������ ���ڿ��� �����ϰ� ���� ��� .rstrip()�� �߰��� �� �ִ� ���� ����.
//���� �Է°� ��� ��Ʈ���� �����̹Ƿ�, �׽�Ʈ���̽��� ���� �Է¹޾Ƽ� ������ �� ���� ����� �ʿ�� ����.
//�׽�Ʈ���̽��� �ϳ� ���� �� �ϳ� ����ص� �ȴ�.
//�ڼ��� ���� �� �ٸ� ����� ���� �� �ۿ� ����Ǿ� �ִ�.
//�� ��α� �ۿ��� BOJ�� ��Ÿ ���� ���� ���� �� �� �ִ�.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		int a = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < a; i++) {
			str = new StringTokenizer(bufferedReader.readLine());
			bufferedWriter.write((Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken())) + "\n");
		}
		bufferedWriter.close();
	}
}
