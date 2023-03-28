package controller;

public class LoginCommand {
	// AuthService를 이용하여 로그인 요청을 처리하는 클래스
	private String email;
	private String password;
	private boolean rememberEmail;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	
}
