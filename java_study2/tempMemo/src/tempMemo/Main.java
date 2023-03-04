package tempMemo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a = 4;
		int b = Integer.BYTES;
		System.out.println(b);
		String str = "È£¶ûÀÌ";
		String c = new String();
		int d = str.indexOf(str);
		int e = str.length();
		int f = Character.BYTES;
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		int g = Short.BYTES;
		System.out.println(g);

		int[] common = new int[100];
		for(int i = 0;i<common.length;i++) {
			common[i] = i;
			System.out.println(common[i]);
		}
		int abs = common[99];
		System.out.println(abs);
	}
}
