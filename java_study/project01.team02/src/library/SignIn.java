package library;

import java.util.Scanner;

class SignIn {
	private String id = null;
	private String pw = null;
	private String inputId;
	private String inputPw;

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getInputId() {
		return inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputPw() {
		return inputPw;
	}

	public void setInputPw(String inputPw) {
		this.inputPw = inputPw;
	}

	Scanner sc = new Scanner(System.in);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}