2023년 3월 3일 금요일

## day43

### 1. java

- chap.16 람다식
- 인터페이스 작명시 일반적으로 `~able`을 뒤에 붙힌다.

6. 생성자 참조

- 람다식에서 결과 리턴하는 것이 객체를 생성하는 것 밖에 없다면 사용 가능

  ```java
  package javaHigh09.example04;

  @FunctionalInterface
  public interface Createable1 {
    // Member 리턴타입의 추상메소드 선언
    public Member create(String id);
  }
  ```

  ```java
  package javaHigh09.example04;

  public class Member {
    private String id;
    private String name;

    public Member(String id) {
      super();
      this.id = id;
    }
    @Override
    public String toString() {
      String info = "id: " + id;
      return info;
    }
  }
  ```

  ```java
  package javaHigh09.example04;

  public class Person {
    // 리턴타입은 Member, 매개변수는 인터페이스인 메소드 선언
    public Member getMember1(Createable1 createable) {
      // 매개변수 = 인터페이스
      String id = "winter";
      Member member = createable.create(id);	// 추상메소드 구현
      return member;
    }
  }
  ```

  ```java
  package javaHigh09.example04;

  public class ConstructorReferenceExample {
    public static void main(String[] args) {
      Person person = new Person();
      // 익명구현객체 표현
      Member m1 = person.getMember1(new Createable1() {

        @Override
        public Member create(String id) {
          // TODO Auto-generated method stub
          return new Member(id);
        }
      });
      // 람다식 표현
      m1 = person.getMember1((String id) -> {
        return new Member(id);
      });

      m1 = person.getMember1(id -> new Member(id));

      // 매개변수 생성자참조 = 람다식에서 결과를 리턴하는 것이 객체를 생성하는 것 밖에 없다면 사용 가능

      m1 = person.getMember1(Member::new);
      System.out.println(m1);
      System.out.println();
    }
  }
  ```

- chap.16 확인문제
- 신선식품 웹사이트 화면 구현중

---

### 2. memo

- to do weekend
  - chap.14 스레드풀, chap.17 스트림 요소 처리, chap.18 데이터 입출력, chap.19 네트워크 입출력
  - 화면정의서 작성(3차 프로젝트, 공차클론프로젝트, 로그인, 가맹점)
  - 클론할 페이지 알아보기
- 월요일수업 : js, react, 유효성검사
