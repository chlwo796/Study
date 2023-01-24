package ch05.sec11;

public class MainStringArrayArgument {

	public static void main(String[] args) {
//		main(method�� String[] args) �� �ǹ�

		if (args.length != 2) {
			System.out.println("�Է°��� �����մϴ�.");
			System.exit(0);
		}

		String str1 = args[0];
		String str2 = args[1];

		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);

		int result = num1 + num2;
		System.out.println(result);

//		run -> run configurations -> arguments -> ���� int1 int2 �Է� -> run
//		cmd run -> projectName.bin(javaBasic2.bin) -> java ch05.sec11.MainStringArrayArgument int1 int2
	}

}
