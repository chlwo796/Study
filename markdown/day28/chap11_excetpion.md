2023년 2월 12일

---

## chap.11 exception

### 1. 예외와 예외 클래스

- 에러(error) : 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류가 발생하는 것을 자바에서는 에러라고 한다.
- 예외(exception) : 잘못된 사용 또는 코딩으로 인한 오류
  1. 일반 예외(exception)
     - 컴파일러가 예외 처리 코드 여부를 검사하는 예외를 말한다.
  2. 실행 예외(runtime exception)
     - 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외를 말한다.
- 예외가 발생되면 프로그램은 곧바로 종료되지만(보안이나 데이터 손실에 매우 취약한 상태) 예외처리를 통해 계속 실행 상태를 유지할 수 있다.
- 예외가 발생하면 예외 클래스로부터 객체를 생성한다.
- 자바의 모든 에러와 예외 클래스는 `Throwable`을 상속받아 만들어지고, 추가적으로 예외 클래스는 `java.lang.Exception` 클래스를 상속받는다.

### 2. 예외 처리 코드

- 예외 처리 코드 : 예외가 발생했을 때 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드
- `try-catch-finally` 블록으로 구성되며, 생성자 내부와 메소드 내부에서 작성된다.

  ```java
  try{
    // 예외발생할 수 있는 블록
  }catch(예외타입 인스턴스변수){
    // 예외발생시 실행하는 블록
  }finally{
    // 항상 실행하는 블록(생략가능)
  }
  ```

- javaMid11.example01.ExceptionHandlingExample02

  ```java
  package javaMid11.example01;

  public class ExceptionHandlingExample02 {
      public static void printLength(String data) {
          try {
              int result = data.length();
              System.out.println("문자 수 : " + result);
          } catch (NullPointerException e) {
              System.out.println(e.getMessage());
              System.out.println(e.toString());
              e.printStackTrace();
          } finally {
              System.out.println("마무리 실행");
          }
      }

      public static void main(String[] args) {
  //		NullPointerException Example
          System.out.println("프로그램 시작");
          printLength("안녕하세요");
          printLength(null);
          System.out.println("프로그램 종료");
      }
  }
  ```

- javaMid11.example02.ExceptionHandlingExample

  ```java
  package javaMid11.example02;

  public class ExceptionHandlingExample {
      public static void main(String[] args) {
          try {
              Class.forName("java.lang.String");
              System.out.println("java.lang.String 클래스가 존재합니다.");
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
          try {
              Class.forName("java.lang.String2");
              System.out.println("java.lang.String2 클래스가 존재합니다.");
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
  }
  ```

### 3. 예외 종류에 따른 처리

- `try{}`에는 다양한 종류의 예외가 발생할 수 있는데, 다중 `catch(){}`를 사용하면 발생하는 예외에 따라 예외 처리 코드를 다르게 작성할 수 있다.
- `try(){}`에서 동시 다발적으로 예외가 발생하지 않으며, 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 `catch(){}`으로 이동하기 때문에, `catch(){}`가 여러 개라 할지라도 `catch(){}`블록은 단 하나만 실행된다.
- javaMid11.example03.ExceptionHandlingExample

  ```java
  package javaMid11.example03;

  public class ExceptionHandlingExample {
      public static void main(String[] args) {
          String[] array = { "100", "1oo" };

          for (int i = 0; i <= array.length; i++) {
              try {
                  int value = Integer.parseInt(array[i]);
                  System.out.println("array[" + i + "] : " + value);
              } catch (ArrayIndexOutOfBoundsException e) {
                  System.out.println("배열 인덱스가 초과됨:" + e.getMessage());
                  e.printStackTrace();
              } catch (NumberFormatException e) {
                  System.out.println("숫자로 변환할 수 없음:" + e.getMessage());
                  e.printStackTrace();
              }
          }
      }
  }
  ```

- 처리해야 할 예외 클래스들이 상속 관계에 있을 때는 하위 클래스 `catch(){}`를 먼저 작성하고 상위 클래스 `catch(){}`를 나중에 작성해야 한다.
- javaMid11.example04.ExceptionHandlingExample

  ```java
  package javaMid11.example04;

  public class ExceptionHandlingExample {

      public static void main(String[] args) {
          String[] array = { "100", "1oo" };

          for (int i = 0; i <= array.length; i++) {
              try {
                  int value = Integer.parseInt(array[i]);
                  System.out.println("array[" + i + "] : " + value);
              } catch (ArrayIndexOutOfBoundsException e) {
                  System.out.println("배열 인덱스가 초과됨:" + e.getMessage());
                  e.printStackTrace();
              } catch (Exception e) {
                  System.out.println("실행에 문제가 있습니다.");
              }
          }
      }
  }
  ```

- 두개 이상의 예외를 하나의 `catch(){}`로 동일하게 예외 처리하고 싶은 경우에는 `catch(ClassA | classB ..){}`로 `|`기호를 사용한다.
- javaMid11.example05.ExceptionHandlingExample

  ```java
  package javaMid11.example05;

  public class ExceptionHandlingExample {

      public static void main(String[] args) {
          // TODO Auto-generated method stub
          String[] array = { "100", "1oo", null, "200" };
          for (int i = 0; i <= array.length; i++) {
              try {
                  int value = Integer.parseInt(array[i]);
                  System.out.println("array[" + i + "] : " + value);
              } catch (ArrayIndexOutOfBoundsException e) {
                  System.out.println("배열인덱스가 초과됨 : " + e.getMessage());
              } catch (NullPointerException | NumberFormatException e) {
                  System.out.println("데이터에 문제가 있음 : " + e.getMessage());
              }
          }
      }

  }
  ```

### 4. 리소스 자동 닫기

- 리소스(resource) : 데이터를 제공하는 객체
- 리소스는 사용하기 위해 open 한 후 사용이 끝난 다음에는 close해야 한다.(추후 다른 프로그램에서 사용할 수 있다.)
- 리소스를 사용하다가 예외가 발생될 경우에도 안전하게 닫는 것이 중요하며, 그렇지 않으면 리소스가 불안정한 상태로 남아있게 된다.
- try-with-resources `try(){}`를 사용하면 예외 발생 여부와 상관없이 리소스를 자동으로 닫아준다.
- 리소스는 `java.lang.AutoCloseable` 인터페이스를 구현해서 `close()` 메소드를 재정의 해야한다.

  ```java
  package javaMid11.example06;

  public class MyResource implements AutoCloseable {
      private String name;

      public MyResource(String name) {
          this.name = name;
          System.out.println("[MyResource(" + name + ") 열기");
      }

      public String read1() {
          System.out.println("[MyResource(" + name + ") 읽기");
          return "100";
      }

      public String read2() {
          System.out.println("[MyResource(" + name + ")  읽기");
          return "abc";
      }

      @Override
      public void close() throws Exception {
          System.out.println("[MyResource(" + name + ") 닫기");
      }
  }
  ```

- javaMid11.example06.TryWithResourceExample

  ```java
  package javaMid11.example06;

  public class TryWithResourceExample {

      public static void main(String[] args) {
          try (MyResource res = new MyResource("A")) {
              String data = res.read1();
              int value = Integer.parseInt(data);
          } catch (Exception e) {
              System.out.println("예외 처리 : " + e.getMessage());
          }
          System.out.println();
          try (MyResource res = new MyResource("A")) {
              String data = res.read2();
              int value = Integer.parseInt(data);
          } catch (Exception e) {
              System.out.println("예외 처리 : " + e.getMessage());
          }
          System.out.println();

          MyResource res1 = new MyResource("A");
          MyResource res2 = new MyResource("B");
          try (res1;res2){
              String data1 = res1.read1();
              String data2 = res2.read1();
          }catch(Exception e) {
              System.out.println("예외처리 : " + e.getMessage());
          }
      }
  }
  ```

### 5. 예외 떠넘기기

- 메소드 내부에서 예외가 발생할 때, try-catch 블록으로 예외를 처리하는 것이 기본이지만, `throws` 키워드를 사용하여, 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다.
- `리턴타입 메소드명(매개변수, ..) throws 예외클래스1, 예외클래스2, ..{}`
- javaMid11.example07.ThrowsExample01

  ```java
  package javaMid11.example07;

  public class ThrowsExample {
      public static void main(String[] args) {
          try {
              findClass();
          } catch (ClassNotFoundException e) {
              System.out.println("예외처리 : " + e.toString());
          }
      }

      public static void findClass() throws ClassNotFoundException {
          Class.forName("java.lang.String2");
      }
  }
  ```

- 나열해야 할 예외 클래스가 많을 경우에는 `throws Exeption` 또는 `throws Throwable`만으로 모든 예외를 간단히 떠넘길 수도 있다.
- `main()` 메소드에서도 `throws` 키워드를 사용해서 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 되고, JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.
- javaMid11.example07.ThrowsExample02

  ```java
  package javaMid11.example07;

  public class ThrowsExample02 {
      public static void main(String[] args) throws Exception {

          findClass();
      }

      public static void findClass() throws ClassNotFoundException {
          Class.forName("java.lang.String2");
      }
  }
  ```

### 6. 사용자 정의 예외

- 사용자 정의 예외 : 자바 표준 라이브러리에는 존재하지 않는 프로젝트 요구사항에 의한 예외 클래스를 직접 정의하여 사용
- 컴파일러가 체크하는 일반 예외로 선언할 수도 있고, 컴파일러가 체크하지 않는 실행 예외로 선언할 수도 있다.
- 통상적으로 일반 예외는 Exception의 자식클래스로 선언하고, 실행예외는 RuntimeException의 자식클래스로 선언한다.
- 사용자 정의 예외 클래스에는 기본 생성자와 예외 메시지를 입력받는 생성자를 선언해준다.
- javaMid11.example08.InsufficientException

  ```java
  package javaMid11.example08;

  public class InsufficientException extends Exception {
      public InsufficientException(String message) {
          super(message);
      }

      public InsufficientException() {
          // TODO Auto-generated constructor stub
      }
  }
  ```

- 사용자 정의 예외를 직접 코드에서 발생시키려면 `throw` 키워드와 함께 예외 객체를 제공하고, 원인에 해당하는 메세지를 제공하고 싶다면 생성자 매개값으로 전달한다.
- `throw` 된 예외는 직접 try-catch블록으로 예외를 처리할 수도 있지만, 대부분은 메소드를 호출한 곳에서 예외를 처리하도록 `throws` 키워드로 예외를 떠넘긴다.
- javaMid11.example08.Account

  ```java
  package javaMid11.example08;

  public class Account {
      private long balance;

      public Account() {
          // TODO Auto-generated constructor stub
      }

      public long getBalance() {
          return balance;
      }

      public void deposit(int money) {
          balance += money;
      }

      public void withdraw(int money) throws InsufficientException {
          if (balance < money) {
              throw new InsufficientException("잔고 부족 : " + (money - balance) + "모자람");
          }
          balance -= money;
      }
  }
  ```

- javaMid11.example08.AccountExample

  ```java
  package javaMid11.example08;

  public class AccountExample {
      public static void main(String[] args) {
          Account account = new Account();
          account.deposit(10000);
          System.out.println("예금액: " + account.getBalance());
          try {
              account.withdraw(30000);
          } catch (InsufficientException e) {
              String message = e.getMessage();
              System.out.println(message);
          }
      }
  }
  ```
