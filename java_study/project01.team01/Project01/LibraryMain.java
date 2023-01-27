package Project01;

import java.util.Scanner;

public class LibraryMain {
   private static LibraryBook[] LibrarybookArray = new LibraryBook[100];
   private static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args) {
      
      boolean flage = true;
      while(flage) {
    	 System.out.println();
         System.out.println("                            도서 관리 프로그램");
         System.out.println("-------------------------------------------------------------------------");
         System.out.println("1. 신규 도서 등록 | 2. 보유 도서 검색 | 3. 보유 도서 삭제 | 4. 보유 도서 목록 | 5. 종료");
         System.out.println("-------------------------------------------------------------------------");
         System.out.print("선택 > ");
         String choice = sc.nextLine();
         
         switch(choice) {
            case "1": newBookM(); break;
            case "2": loanBook(); break;
            case "3": delBook(); break;
            case "4": bookList(); break;
            case "5": System.out.println("프로그램 종료."); flage = false; break;
            default: System.out.println("숫자를 잘못 입력하였습니다.");
         } 
      }
   }
  
   // 1. 신규 도서 등록
   private static void newBookM() {
      System.out.print("책 제목 > ");
      String bookName = sc.nextLine();
      System.out.print("작가 > ");
      String bookAuthor = sc.nextLine();
      System.out.print("수량 > ");
      int bookCnt = sc.nextInt();
      LibraryBook newlibrarybook = new LibraryBook(bookName, bookAuthor,bookCnt);
      
      for(int i = 0; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] == null) {
            LibrarybookArray[i] = newlibrarybook;
            break;
         }
      } sc.nextLine();
      System.out.println("정상적으로 등록되었습니다.");
   }

   // 2. 보유 도서 검색
   private static void loanBook() {
       System.out.print("찾으시는 책 제목을 입력하시오. > ");
       String searchBook = sc.nextLine();
       
       for(int i = 0 ; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] != null) {
          if(searchBook.equals(LibrarybookArray[i].getBookName())) {
             System.out.println("제목 : " + LibrarybookArray[i].getBookName() );
             System.out.println("저자 : " + LibrarybookArray[i].getBookAuthor());
             System.out.println("보유 중인 책 : " + LibrarybookArray[i].getBookCnt() + "권");
             if(LibrarybookArray[i] == null) {
                System.out.println("찾으시는 책이 현재 없습니다.");
             }
             else {break;
             }
          } else System.out.println("등록되지 않은 책 입니다.");
          break;
         }
       }
    }
   
   // 3. 보유 도서 삭제
   private static void delBook() {
      
       System.out.print("목록에서 삭제하려는 책 제목을 입력하시오. > ");
       String searchBook = sc.nextLine();
       
       for(int i = 0 ; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] != null) {
          if(searchBook.equals(LibrarybookArray[i].getBookName())) {
             System.out.println("삭제하려는 책 제목이 " + LibrarybookArray[i].getBookName() + "(이)가 맞습니까?" );
             System.out.print("맞으면 y, 틀리면 n 로 대답해주십시오. > ");
             String answer = sc.nextLine();
             if(answer.equals("y")) {
               LibrarybookArray[i] = null;
                System.out.println("삭제되었습니다. 처음으로 되돌아갑니다.");
             }
             else {
                System.out.println("처음으로 돌아갑니다.");
                break;
             }
          } else System.out.println("잘못 입력하셨습니다.");
          break;
         }
       }
    }
   
   
   // 4. 보유 도서 목록
   private static void bookList() {
      System.out.println("                           ▽▽ 보유 도서 목록 ▽▽");
       System.out.println(" ");
      
      for (int i = 0 ; i < LibrarybookArray.length ; i++) {
         LibraryBook librarybook = LibrarybookArray[i];
         if(librarybook != null) {
            System.out.print("제목 : " + librarybook.getBookName() + " / ");
            System.out.print("저자 : " + librarybook.getBookAuthor() + " / ");
            System.out.print( librarybook.getBookCnt() + "권 보유중");
            System.out.println();
         }
      }
   }
   
   
}