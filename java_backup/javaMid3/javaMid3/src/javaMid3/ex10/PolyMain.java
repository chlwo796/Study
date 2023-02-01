package javaMid3.ex10;

public class PolyMain {
	public static void main(String[] args) {
		CaptionTv ca = new CaptionTv();
		TV tv = new TV();
		TV cTV = new CaptionTv(); // 부모타입으로 자식의 주소를 참조하는 변수 cTV 객체생성
		ca.channel = 11;
		ca.power = true;
		ca.text = "파노라마";
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
//		overriding 후
		cTV.channelUp();
//		cTV.text = "자식 필드"; // 자식필드는 사용할 수 없다. 부모타입으로 선언된 변수이다.
//		부모타입을 자식타입으로 강제형변환	
// 		자식클래스에서 오버라이딩을 하지 않았기 때문에 자식메소드에 접근할 수 없다.
		CaptionTv ctv = (CaptionTv) cTV;
		ctv.text = "자식필드";
		ctv.caption();
	}
}
