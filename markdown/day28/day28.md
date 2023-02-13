2023년 2월 9일 목요일

---

## day28

### 1. remind

- package > module > package > class
- module -> `.jar` 다른프로젝트에서 buildpath 설정 후 사용
- `requires` : 패키지
- `exports` : 패키지 노출
- `transitive` : 전이.
- Exception

  1. `basic`

  ```java
  try{
    // 예외발생할 수 있는 블록
  }catch(예외타입 인스턴스변수){
    // 예외발생시 실행하는 블록
  }finally{
    // 항상 실행하는 블록(생략가능)
  }
  ```

  2. `throws`

  ```java
  class A{
  void methodA1() throws 예외타입1, 예외타입2{
      methodA2();
      }
  void methodA2() throws 예외타입1, 예외타입2{
      methodA3();
      // 다른 예외타입이 발생할 수 있는 구문 -> 예외타입1
      }
  void methodA3() throws 예외타입2{
      }
  }
  public static void main(String[] args) throws Exception{
      // 메인에서는 예외타입의 부모인 Exception클래스를 throws 하여 다른 클래스에서 예외가 발생했을 경우 타입종류에 상관없이 받아낼 수 있다.
  }
  ```

  3. `throw new userName("message")`

  ```java
  public class InsufficientException extends Exception {
  public InsufficientException(String message) {
  	// TODO Auto-generated constructor stub
  	super(message);
  }

  public InsufficientException() {
  	// TODO Auto-generated constructor stub

  }
    }
  	public void withdraw(int money) throws InsufficientException{
  	if(balance<money) {
  		throw new InsufficientException("잔고 부족" + (money-balance) + "모자람");
  	}
  	balance -= money;
  }
  ```

---

### 2. java

- toeic program(javaMid10.toeic)

  1. class structure : ToeicExample(main), Toeic, 예외클래스
  2. source

  ```java
  package javaMid10.toeic;

  public class ScoreMaxException extends Exception {
      public ScoreMaxException(String message) {
          super(message);
      }
      public ScoreMaxException() {
      }
  }
  ```

  ```java
  package javaMid10.toeic;

  public class ScoreMinException extends Exception {
      public ScoreMinException(String message) {
          super(message);
      }
      public ScoreMinException() {
      }
  }
  ```

  ```java
  package javaMid10.toeic;
  import java.util.Scanner;
  public class Toeic {
      Scanner sc = new Scanner(System.in);
      int toeicScore;
      String choice;
      void input() throws ScoreMinException, ScoreMaxException {
          // 메인은 간단하게 하는 것이 좋다.
          while (true) {
              System.out.println("당신의 토익점수는?");
              toeicScore = sc.nextInt();

              if (toeicScore < 0) {
                  throw new ScoreMinException("0점 미만의 토익점수는 나올 수 없습니다.");
              } else if (toeicScore > 990) {
                  throw new ScoreMaxException("990점 초과한 토익점수는 나올 수 없습니다.");
              } else {
                  System.out.println("당신의 토익점수는 " + toeicScore + "점 입니다.");
              }
              sc.nextLine();
              System.out.println("계속하시겠습니까?(y/n)");
              choice = sc.nextLine();
              if(choice.equalsIgnoreCase("n")) {
                  break;
              }
          }
      }
  }
  ```

  ```java
  package javaMid10.toeic;

  public class ToeicExample {
      public static void main(String[] args) {
          Toeic toeic = new Toeic();
          try {
              toeic.input();
          } catch (ScoreMinException e) {
              System.out.println(e.getMessage());
          } catch (ScoreMaxException e) {
              System.out.println(e.getMessage());
          }
      }
  }
  ```

- chap.11 확인문제
- chap.11.04 리소스 자동 닫기(java 9 이상)

  1. resource : 데이터를 제공하는 객체
  2. 리소스는 사용하기 위해 열어야(open)하며, 사용이 끝난 후 닫아야(close)한다.
  3. 리소스 사용중에 예외가 발생되는 경우라도 안전하게 닫는것이 중요하며, 그렇지 않으면 리소스가 불안정한 상태로 남아있게 된다.
  4. 반복되는 `try-catch`의 불편함을 해소
  5. 구조(try-with-resources) : `try(리소스를 여는 코드){실행블록}`
  6. 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하더라도 자동으로 리소스의 close() 메소드가 호출된다.
  7. chap.11 확인문제 8번 source

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
      }
      @Override
      public void close() throws IOException {
          System.out.println("파일을 닫습니다.");
      }
  }
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

- 오버라이드규칙

  1. 부모의 메소드의 리턴타입, 메소드명, 매개변수는 무조건 같아야 한다.
  2. 자식의 접근제한자는 부모의 접근제한자를 포함할 수 있어야 한다.
  3. 부모의 예외타입은 자식의 예외타입을 포함할 수 있어야 한다.(자식이 더 좁은타입)

---

- part.03 chap.15->chap.12
- chap.15 컬렉션 자료구조
- 용도 분류 : 검색, 정렬, 보관용 등..
- 데이터의 형태

  1. 한 곳에 몰려 있는 것을 처리하는 것
  2. 여기저기 분산되어 있는 것을 처리하는 것

- 자료구조의 분류

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99E4BA415AEB1E9801)

- 컬렉션 : 자료구조를 미리 라이브러리로 만들어 둔 것
- List : 데이터를 쌓는 구조, 중복 가능
- Set : 덩어리로 데이터를 저장, 중복 불가
- Map : 사전과 비슷한 형태

  - key : 중복불가(only), Set 계열
  - value : 중복가능, List 계열

- ArrayList

```java
package javaHigh01.Example01;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {

	public static void main(String[] args) {

		ArrayList arrayList = new ArrayList();

//		1차원 배열을 컬렉션으로 만듬
//		다형성, 더 많이 사용
		List list1 = new ArrayList();
//		배열의 단점 = 한번 선언하면 길이를 수정할 수 없기 때문에,
//		새로 생성하고 옮겨주어야한다.
//		추가하거나 중간이 비어있을 경우에도 수정하기 매우 어렵기 때문에,
//		메모리외 효율이 좋지 않다.
		int[] n1 = new int[3];

		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add(12);

		System.out.println(list1.get(3));
		System.out.println("들어있는 개수는 : " + list1.size());

//		"k"라는 자료가 있나요?
//		배열집합으로 된 컬렉션이기 때문에 반복문을 사용하지 않더라도 간단하게 가능하다
		if (list1.contains("k")) {
			System.out.println("있습니다");
		} else {
			System.out.println("없습니다.");
		}
	}
}
```

---

### 3. memo

- 학생관리 프로그램(출결(시간), 성적), 선생님의 요구사항이라면....수강료..일괄 문자메세지전송, 상담/메모, 월사용료, 무료체험
- 취업/자격증

  - 포트폴리오 2개
  - 면접질문 : 정보처리 기사 자격증 필기부분

- 2월말에 웹페이지 만들기 실습
