package javaBasic5.ex13;

public class MemberService {

	boolean result;

	boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		} else
			return false;

	}

	void logout(String id) {
		System.out.println(id + "´Ô ·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
	}
}
