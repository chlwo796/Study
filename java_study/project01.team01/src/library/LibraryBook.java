package library;

public class LibraryBook {

   private String bookName; // å ����
   private String bookAuthor; // å ����
   private int bookCnt; // å ����
   
   public LibraryBook(String bookName, String bookAuthor, int bookCnt) {
      this.bookName = bookName;
      this.bookAuthor = bookAuthor;
      this.bookCnt = bookCnt;
   }
   
      public String getBookName() {
         return bookName;
      }
      public void setBookName(String bookName) {
         this.bookName = bookName;
      }
      public String getBookAuthor() {
         return bookAuthor;
      }
      public void setBookAuthor(String bookAuthor) {
         this.bookAuthor = bookAuthor;
      }
      public int getBookCnt() {
         return bookCnt;
      }
      public void setBookCnt(int bookCnt) {
         this.bookCnt = bookCnt;
      }
      
}