package com.woori.myhome.board;

import com.woori.myhome.common.BaseDto;

public class BoardDto extends BaseDto{
	//db실제 데이터 자료와 상관없이 그냥 String 으로 하자 
	private String id="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private String seq="";
	private String userid="";
	private String regdate="";
	
	private String filename1="";
	private String filename2="";
	private String filename3="";
	
	
	
	
	

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public String getFilename3() {
		return filename3;
	}

	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(String id, String title, String writer, String contents, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.wdate = wdate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
	
}
