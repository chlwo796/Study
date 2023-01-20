package ch06.day01;

public class ClassEx03 {

	public static void main(String[] args) {
//		생성자끼리 호출하기
		Book book = new Book();
		
		System.out.println(book.getBookTitle());
		System.out.println(book.getBookPrice());
	}

}
class Book{
	String bookTitle;
	int bookPrice;
	
	public Book() {
		
		this(30000);
		System.out.println("이곳은 기본 생성자이다");
//		this()안에 변수의 데이터타입에 따라
//		맞는 생성자 Book(String bookTitle)호출한다.
	}
	public Book(int bookPrice) {
		this("이것이 CSS이다");
		this.bookPrice = bookPrice;
	}
	public Book(String bookTitle) {
//		this();	// 무한 반복루프, 에러발생
		this.bookTitle = bookTitle;
	}
	public Book(String bookTitle, int bookPrice) {
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
}