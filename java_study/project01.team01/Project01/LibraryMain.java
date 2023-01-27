package Project01;

import java.util.Scanner;

public class LibraryMain {
   private static LibraryBook[] LibrarybookArray = new LibraryBook[100];
   private static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args) {
      
      boolean flage = true;
      while(flage) {
    	 System.out.println();
         System.out.println("                            ���� ���� ���α׷�");
         System.out.println("-------------------------------------------------------------------------");
         System.out.println("1. �ű� ���� ��� | 2. ���� ���� �˻� | 3. ���� ���� ���� | 4. ���� ���� ��� | 5. ����");
         System.out.println("-------------------------------------------------------------------------");
         System.out.print("���� > ");
         String choice = sc.nextLine();
         
         switch(choice) {
            case "1": newBookM(); break;
            case "2": loanBook(); break;
            case "3": delBook(); break;
            case "4": bookList(); break;
            case "5": System.out.println("���α׷� ����."); flage = false; break;
            default: System.out.println("���ڸ� �߸� �Է��Ͽ����ϴ�.");
         } 
      }
   }
  
   // 1. �ű� ���� ���
   private static void newBookM() {
      System.out.print("å ���� > ");
      String bookName = sc.nextLine();
      System.out.print("�۰� > ");
      String bookAuthor = sc.nextLine();
      System.out.print("���� > ");
      int bookCnt = sc.nextInt();
      LibraryBook newlibrarybook = new LibraryBook(bookName, bookAuthor,bookCnt);
      
      for(int i = 0; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] == null) {
            LibrarybookArray[i] = newlibrarybook;
            break;
         }
      } sc.nextLine();
      System.out.println("���������� ��ϵǾ����ϴ�.");
   }

   // 2. ���� ���� �˻�
   private static void loanBook() {
       System.out.print("ã���ô� å ������ �Է��Ͻÿ�. > ");
       String searchBook = sc.nextLine();
       
       for(int i = 0 ; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] != null) {
          if(searchBook.equals(LibrarybookArray[i].getBookName())) {
             System.out.println("���� : " + LibrarybookArray[i].getBookName() );
             System.out.println("���� : " + LibrarybookArray[i].getBookAuthor());
             System.out.println("���� ���� å : " + LibrarybookArray[i].getBookCnt() + "��");
             if(LibrarybookArray[i] == null) {
                System.out.println("ã���ô� å�� ���� �����ϴ�.");
             }
             else {break;
             }
          } else System.out.println("��ϵ��� ���� å �Դϴ�.");
          break;
         }
       }
    }
   
   // 3. ���� ���� ����
   private static void delBook() {
      
       System.out.print("��Ͽ��� �����Ϸ��� å ������ �Է��Ͻÿ�. > ");
       String searchBook = sc.nextLine();
       
       for(int i = 0 ; i < LibrarybookArray.length ; i++) {
         if(LibrarybookArray[i] != null) {
          if(searchBook.equals(LibrarybookArray[i].getBookName())) {
             System.out.println("�����Ϸ��� å ������ " + LibrarybookArray[i].getBookName() + "(��)�� �½��ϱ�?" );
             System.out.print("������ y, Ʋ���� n �� ������ֽʽÿ�. > ");
             String answer = sc.nextLine();
             if(answer.equals("y")) {
               LibrarybookArray[i] = null;
                System.out.println("�����Ǿ����ϴ�. ó������ �ǵ��ư��ϴ�.");
             }
             else {
                System.out.println("ó������ ���ư��ϴ�.");
                break;
             }
          } else System.out.println("�߸� �Է��ϼ̽��ϴ�.");
          break;
         }
       }
    }
   
   
   // 4. ���� ���� ���
   private static void bookList() {
      System.out.println("                           ��� ���� ���� ��� ���");
       System.out.println(" ");
      
      for (int i = 0 ; i < LibrarybookArray.length ; i++) {
         LibraryBook librarybook = LibrarybookArray[i];
         if(librarybook != null) {
            System.out.print("���� : " + librarybook.getBookName() + " / ");
            System.out.print("���� : " + librarybook.getBookAuthor() + " / ");
            System.out.print( librarybook.getBookCnt() + "�� ������");
            System.out.println();
         }
      }
   }
   
   
}