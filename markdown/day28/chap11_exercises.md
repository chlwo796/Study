2023년 2월 13일 월요일

---

## chap.11 예외처리

### 1. exception

- 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다.
- RuntimeException의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다.
- 예외는 `try-catch`블록을 사용해서 처리된다.
- 자바 표준 예외만 프로그램에서 처리할 수 있다. (x) -> 사용자 예외를 정의해서 처리 가능하다.

### 2. `try-catch-finally`블록

- try{} 블록에는 예외가 발생할 수 있는 코드를 작성한다.
- catch{} 블록은 try{} 블록에서 발생한 예외를 처리하는 블록이다.
- try{} 블록에서 return 문을 사용하면 finally{} 블록은 실행되지 않는다. (x) -> finally{} 블록은 항상 실행된다.
- catch{} 블록은 예외의 종류별로 여러 개를 작성할 수 있다.

### 3. `throws`

- 생성자나 메소드의 선언 끝 부분에 사용되어 내부에서 발생된 예외를 떠넘긴다.
- `throws` 뒤에는 떠념겨야 할 예외를 쉼표(,)로 구분해서 기술한다.
- 모든 예외를 떠넘기기 위해 간단하게 `throws Exception`으로 작성할 수 있다.
- 새로운 예외를 발생시키기 위해 사용된다. (x) -> 새로운 예외는 `throw` 키워드로 발생시킨다.

### 4. `throw`

- 예외를 최초로 발생시키는 코드이다.
- 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다. (x) -> `throws`에 대한 설명이다.
- `throw`로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 `throws`로 떠넘겨진다.
- `throw` 키워드 뒤에는 예외 객체 생성 코드가 온다.

### 5. 예외 처리

`public void method1() throws NumberFormatException, ClassNotFoundException{}`

- 잘못된 코드
  ```java
  try{method1();}
  catch(Exception e){}  // 큰 타입의 예외클래스를 먼저 선언하면, 뒤에 catch()문을 실행하지 않는다.
  catch(ClassNotFoundException e){}
  ```
- 수정한 코드
  ```java
  try{method1();}
  catch(ClassNotFoundException e){} // 다중 catch()의 예외클래스는 작은 타입부터 나열한다.
  catch(Exception e){}
  ```

### 6. 출력 결과

```java
package javaMid10.ex06;

public class Excercises06 {
	public static void main(String[] args) {
		String[] strArray = { "10", "20a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스초과");
			} catch (NumberFormatException e) {
				System.out.println("숫자변환오류");
			} finally {
				System.out.println(value);
			}
		}
	}
}
```

- 10, 숫자변환오류, 10, 인덱스초과, 10 순서대로 출력(value값이 바뀌지 않는다.)

### 7. 코드 작성

- javaMid10.ex07.NotExistIDException

  ```java
  package javaMid10.ex07;

  public class NotExistIDException extends Exception {
      public NotExistIDException() {
      }

      public NotExistIDException(String message) {
          super(message);
      }
  }
  ```

- javaMid10.ex07.WrongPasswordException

  ```java
  package javaMid10.ex07;

  public class WrongPasswordException extends Exception {
      public WrongPasswordException(String message) {
          super(message);
      }

      public WrongPasswordException() {
          // TODO Auto-generated constructor stub
      }
  }
  ```

- javaMid10.ex07.LoginMain

  ```java
  package javaMid10.ex07;

  public class LoginMain {
      public static void main(String[] args) {
          try {
              login("white", "12345");
          }catch(Exception e) {
              System.out.println(e.getMessage());
          }
          try {
              login("blue", "54321");
          }catch(Exception e) {
              System.out.println(e.getMessage());
          }
      }
      public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
          if(!id.equals("blue")) {
              throw new NotExistIDException("아이디가 존재하지 않습니다.");
          }
          if(!password.equals("12345")) {
              throw new WrongPasswordException("패스워드가 틀립니다.");
          }
      }
  }
  ```

### 8. try-with-resorces

- javaMid10.ex08.FileWriter

  ```java
  package javaMid10.ex08;

  import java.io.IOException;

  public class FileWriter implements AutoCloseable {
      public FileWriter(String filePath) throws IOException {
          System.out.println(filePath + " 파일을 엽니다.");
      }

      public void write(String data) throws IOException {
          System.out.println(data + "를 파일에 저장합니다.");
      }

      public FileWriter() {
          // TODO Auto-generated constructor stub
      }

      @Override
      public void close() throws IOException {
          System.out.println("파일을 닫습니다.");
      }

  }
  ```

- javaMid10.ex08.FileWriterMain

  ```java
  package javaMid10.ex08;

  public class FileWriterMain {
      public static void main(String[] args) {

          try (FileWriter fw = new FileWriter("file.txt")) {
              fw.write("java");
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  ```
