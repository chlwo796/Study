package javaMid3.ex10;

public class PolyMain {
	public static void main(String[] args) {
		CaptionTv ca = new CaptionTv();
		TV tv = new TV();
		TV cTV = new CaptionTv(); // �θ�Ÿ������ �ڽ��� �ּҸ� �����ϴ� ���� cTV ��ü����
		ca.channel = 11;
		ca.power = true;
		ca.text = "�ĳ��";
		ca.caption();
		ca.channelUp();
		ca.channelDown();

		tv.channel = 1;
		tv.power = false;
		tv.channelDown();
		tv.channelUp();

		cTV.channel = 22;
		cTV.power = true;
		cTV.channelDown();
		cTV.channelUp();
		System.out.println("-----------");
//		overriding ��
		cTV.channelUp();
//		cTV.text = "�ڽ� �ʵ�"; // �ڽ��ʵ�� ����� �� ����. �θ�Ÿ������ ����� �����̴�.
//		�θ�Ÿ���� �ڽ�Ÿ������ ��������ȯ	
// 		�ڽ�Ŭ�������� �������̵��� ���� �ʾұ� ������ �ڽĸ޼ҵ忡 ������ �� ����.
		CaptionTv ctv = (CaptionTv) cTV;
		ctv.text = "�ڽ��ʵ�";
		ctv.caption();
	}
}
