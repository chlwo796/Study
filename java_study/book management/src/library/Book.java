package library;

public class Book {
	public String name;
	public String author;
	public String position;
	public int cnt; // 網溥除 援瞳熱
	public String state;
	public int date; // 網溥除 陳瞼
	public int duplicateNumber;
	
	
	public Book(String name, String author, String position, int cnt,String state) { 
		this.name=name;
		this.author=author;
		this.position=position;
		this.cnt =cnt;
		this.state=state;
		
		
	}
	public Book(String name, String author, String position, int cnt, String state,int date) { 
		this.name=name;
		this.author=author;
		this.position=position;
		this.cnt =cnt;
		this.state=state;
		this.date=date;
		
	}
	public Book(Book book) {
		this.name=book.name;
		this.author=book.author;
		this.position=book.position;
		this.cnt =book.cnt;
		this.state=book.state;
		this.date=book.date;
		this.duplicateNumber=book.duplicateNumber;
	}
}
