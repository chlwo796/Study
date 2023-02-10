package javaHigh02.example03;

public class Board {
	private String subject;
	private String content;
	private String writer;
	private String joinDate; // 게시글 작성일

	public Board(String subject, String content, String writer, String joinDate) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.joinDate = joinDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
