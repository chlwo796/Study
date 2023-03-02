package javaChap13.exercise04;

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("이순신", 50);
		Integer childAge = Util.getValue(childPair, "이순신1");
		System.out.println(childAge);
		
//		OtherPair<String, Integer> otherPair = new OtherPair<String, Integer>("이순신", 50);
//		Integer otherAge = Util.getValue(otherPair, "이순신1");
//		System.out.println(otherAge);
	}
}
