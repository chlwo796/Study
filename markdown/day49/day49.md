2023년 3월 13일 월요일

---

## day49

### 1. java

- 루핑(looping)은 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것을 말하며, 메소드에는 peek()과 forEach()가 있다.
- LoopingEx01 실습

  ```java
  package javaHigh11.example06;

  import java.util.Arrays;

  public class LoopingEx01 {
      public static void main(String[] args) {
          int[] intArray = { 1, 2, 3, 4, 5 };
          Arrays.stream(intArray).filter(n -> n % 2 == 0).peek(n -> System.out.println(n)).count();
          // peek이용은 최종처리로 집계함수 필요, 전체출력이 필요한 경우에 이용
      }
  }
  ```

- 요소 조건 만족 여부(매칭)

  - `boolean allMatch()` : 모두 만족(and) true
  - `boolean anyMatch()` : 한개라도 만족(or) true
  - `boolean noneMatch()` : 모두 거짓 true

- MatchingEx01 실습

  ```java
  package javaHigh11.example07;

  import java.util.Arrays;

  public class MatchingEx01 {
      public static void main(String[] args) {
          // 모두만족(and) = allMatch(), 한개라도 만족(or) = anyMatch(), 모두 거짓 = noneMatch()
          int[] intArray = { 2, 4, 6, 7 };
          boolean result = Arrays.stream(intArray).allMatch(n -> n % 2 == 0);
          System.out.println(result);

          result = Arrays.stream(intArray).anyMatch(n -> n % 2 == 0);
          System.out.println(result);

          result = Arrays.stream(intArray).noneMatch(n -> n % 7 == 0);
          System.out.println(result);
          System.out.println();
          Student[] studentArray = { new Student("홍길동", 100), new Student("홍길동", 80), new Student("홍길동", 90),
                  new Student("홍길동", 50) };
          // 점수가 모두 60점 이상?
          result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s >= 60);
          System.out.println(result);
          // 점수중에서 한개라도 80점 이상?
          result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).anyMatch(s -> s >= 80);
          System.out.println(result);
          // 전부 100점?
          result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s == 100);
          System.out.println(result);
      }
  }
  ```

- 요소 기본 집계
- OptionalXXX는 Optional, OptionalDouble, OptionalInt, OptionalLong 클래스를 말하며, 최종값을 저장하는 객체로 get(), getAsDouble(), getAsInt(), getAsLong()을 호출하여 최종값을 리턴받는다.

  ```java
  package javaHigh11.example07;

  import java.util.Arrays;

  public class AggregateEx01 {
      public static void main(String[] args) {
          Student[] studentArray = { new Student("홍길동1", 100), new Student("홍길동2", 80), new Student("홍길동3", 90),
                  new Student("홍길동4", 64), new Student("홍길동5", 70), new Student("홍길동6", 87) };
          long countResult = Arrays.stream(studentArray).count();
          System.out.println(countResult);
          int sum = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).sum();
          System.out.println(sum);
          double average = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).average().getAsDouble();
          System.out.println(average);
          int max = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).max().getAsInt();
          System.out.println(max);
          int min = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).min().getAsInt();
          System.out.println(min);
      }
  }
  ```

- Optional 클래스는 단순히 집계값만 저장하는 것이 아니라, 집계값이 존재하지 않을 경우, 디폴트 값을 설정하거나 집계값을 처리하는 Consumer를 등록할 수 있다.
  - `boolean isPresent` : 집계값이 있으면 true
  - `T orElse(T)` : 집계값이 없을 경우 디폴트 값 설정
  - `void ifPresent(Consumer)` : 집계값이 있을 경우 Consumer에서 처리
- OptionalEx01 실습

  ```java
  package javaHigh11.example08;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.OptionalDouble;

  public class OptionalEx01 {
      public static void main(String[] args) {
          List<Integer> list = new ArrayList<Integer>();
  //		list.add(10);
  //		list.add(20);
          // 데이터가 없는 경우 에러발생
  //		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

          OptionalDouble od = list.stream().mapToInt(Integer::intValue).average();
          if (od.isPresent()) {
              System.out.println(od.getAsDouble());
          } else {
              System.out.println("평균 : 0.0");
          }
          double average = list.stream().mapToInt(n -> n.intValue()).average().orElse(0.0);
          System.out.println(average);

          list.stream().mapToInt(Integer::intValue).average().ifPresent(n -> System.out.println(n));
      }
  }
  ```

- 요소 커스텀 집계
- reduce()는 스트림에 요소가 없을 경우 예외가 발생하지만, identity 매값이 주어지면 이 값을 디폴트 값으로 리턴한다.
- ReductionEx01 실습

  ```java
  package javaHigh11.example09;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  import javaHigh11.example07.Student;

  public class ReductionEx01 {
      public static void main(String[] args) {
          List<Student> studentList = Arrays.asList(new Student("홍길동1", 92), new Student("홍길동2", 93),
                  new Student("홍길동3", 88));
          int sumResult = studentList.stream().mapToInt(s -> s.getScore()).sum();
          System.out.println(sumResult);

          int sum = studentList.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
          System.out.println(sum);

          studentList = new ArrayList<Student>();

          sum = studentList.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
          System.out.println(sum);
      }
  }
  ```

- 요소 수집
- ***

### 2. js

- 호이스팅(hoisting) : 상황에 따라 변수의 선언과 할당을 분리해서 선언 부분을 스코프의 가장 위쪽으로 끌어 올리는 것(함수의 선언 위치는 프로그램 흐름에 영향을 주지 않는다.)
- 자바스크립트 해석기는 함수 소스를 훓어보면서 var를 사용한 변수는 따로 기억한다.
- var : 지역변수, let : 전역변수

---

### 3. memo

https://lktprogrammer.tistory.com/88

- [div vs span](https://lktprogrammer.tistory.com/88)
- [js 이벤트 처리 참조](https://cafe.naver.com/thisiscoding)
- [자바스크립트 기본문법정리](https://cafe.naver.com/thisiscoding)
