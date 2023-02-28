2023년 2월 28일 화요일

---

## day41

### 1.remind

- 제네릭<>
- 제네릭도 상속이 가능하다.(최소 부모의 것 이상으로 선언 가능)

---

### 2. java

- 제네릭 메소드 실습

  ```java
  package javaHigh07.example01;

  public class GenericEx05 {
    public static void main(String[] args) {
      Box1<String> box1 = new Box1<String>();
      box1.setT("홍길동");
      System.out.println(box1.getT());

      Box2<String, Integer> box2 = new Box2<String, Integer>();
      box2.setS("홍길동");
      box2.setT(30);
      System.out.println(box2.getS());
      System.out.println(box2.getT());
      Box2<Boolean, Box1<String>> box3 = new Box2<Boolean, Box1<String>>();
      box3.setS(true);
      box3.setT(new Box1<String>("신검대상"));
      if (box3.getS()) {
        System.out.println(box3.getT().getT());
      }
    }

    public <A, B> void gM() {

    }
  }

  class Box1<T> {
    private T t;

    public T getT() {
      return t;
    }

    public void setT(T t) {
      this.t = t;
    }

    public T play() {
      return t;
    }

    public Box1() {
      // TODO Auto-generated constructor stub
    }

    public Box1(T t) {
      super();
      this.t = t;
    }

  }

  class Box2<S, T> {
    private S s;
    private T t;

    public S getS() {
      return s;
    }

    public void setS(S s) {
      this.s = s;
    }

    public T getT() {
      return t;
    }

    public void setT(T t) {
      this.t = t;
    }

    public Box2(S s, T t) {
      super();
      this.s = s;
      this.t = t;
    }

    public Box2() {
      // TODO Auto-generated constructor stub
    }

  }
  ```

- 제한된 타입 파라미터 실습

  ```java
  package javaHigh07.example01;

  public class GenericEx06 {
    public static void main(String[] args) {
      boolean result = GenericEx06.compare(10.0, 10);
      System.out.println(result);

    }

    public static <T extends Number> boolean compare(T t1, T t2) {
      // T extends Number 로 자료형을 Number의 자식들만 T로 제한
      System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
      double v1 = t1.doubleValue();
      double v2 = t2.doubleValue();

      return (v1 == v2);
    }
  }
  ```

- 와일드카드 타입 파라미터 실습

  ```java
  package javaHigh07.example01;

  public class GenericEx07 {
    public static void main(String[] args) {
      // Applicant<?> applicant = 타입 전부 참조 가능
      Course.registerCourse1(new Applicant<Person>(new Person()));
      Course.registerCourse1(new Applicant<Worker>(new Worker()));
      Course.registerCourse1(new Applicant<Student>(new Student()));
      Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
      Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
      // Applicant<? extends Student> applicant = Student 및 해당자식클래스 참조 가능
      Course.registerCourse2(new Applicant<Student>(new Student()));
      Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
      Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
      // Applicant<? super Worker> applicant = Worker 및 해당 부모클래스 참조 가능
      Course.registerCourse3(new Applicant<Person>(new Person()));
      Course.registerCourse3(new Applicant<Worker>(new Worker()));

    }
  }

  class Person {

  }

  class Worker extends Person {

  }

  class Student extends Person {

  }

  class HighStudent extends Student {

  }

  class MiddleStudent extends Student {

  }

  class Applicant<T> {
    public T kind;

    public Applicant(T kind) {
      super();
      this.kind = kind;
    }

  }

  class Course {
    public static void registerCourse1(Applicant<?> applicant) {
      System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함.");
    }

    public static void registerCourse2(Applicant<? extends Student> applicant) {
      System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함.");
    }

    public static void registerCourse3(Applicant<? super Worker> applicant) {
      System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함.");
    }
  }
  ```

- `?` 는 범위에 있는 모든 타입으로 대체할 수 있다는 표시이다.
- chap.13 연습문제
- chap.14 멀티스레드
- 운영체제 : 응용프로그램 또는 사용자가 컴퓨터 하드웨어를 편리하고 효율적으로 사용하게 하기 위하여 시스템 자원(메모리, 프로세서 등)을 관리하고 여러가지 프로그램이 필요로하는 공통적인 서비르를 제공하는 소프트웨어
- 운영체제는 실행중인 프로그램을 프로세스(process)로 관리한다.
  ![프로세스](https://velog.velcdn.com/images%2Fireneeming%2Fpost%2F80415ec7-4ef9-4839-9185-cf8406b9ba24%2Fimage.png)
- 멀티태스킹(multi tasking)은 두 가지 이상의 작업을 동시에 처리하는 것
- 멀티스레드 환경 : 각 프로세스가 독립적으로 처리되며, 동시에 2개 이상의 프로그램 실행 가능
- 마이크로프로세서 : cpu
- thread 실습

  ```java
  package javaHigh08.example01;

  public class Task1 implements Runnable {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      for(int i = 0;i<100;i++) {
        System.out.println("청바지를 만들어줘");
      }
    }
  }
  ```

  ```java
  package javaHigh08.example01;

  public class Task2 extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println("티셔츠 만들어줘");
      }
    }
  }
  ```

  ```java
  package javaHigh08.example01;

  public class ThreadEx01 {
    public static void main(String[] args) {
      Task1 task1 = new Task1();
      Thread thread1 = new Thread(task1);
      thread1.start();
      // 동시실행
      for(int i = 0;i<100;i++) {
        System.out.println("모자를 만들어줘");
      }
      Task2 task2 = new Task2();
      task2.start();
    }
  }
  ```

- 익명객체로 Runnable, thread 구현

  ```java
  package javaHigh08.example03;

  public class ThreadEx03 {
    public static void main(String[] args) throws InterruptedException {
      Thread thread1 = new Thread() {
        @Override
        public void run() {
          for (int i = 0; i < 100; i++) {
            System.out.println("전화하는중");
          }
        }
      };

      thread1.start();

      Runnable r1 = new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 100; i++) {
            System.out.println("카톡보는중");
          }
        }
      };

      Runnable r2 = new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 100; i++) {
            System.out.println("유튜브보는중");
          }
        }
      };
      // Runnable 익명객체로 하나의 Thread에 주소 넣어준다.
      Thread thread = new Thread(r1);
      thread = new Thread(r1);
      thread.start();
      thread = new Thread(r2);
      thread.start();
    }
  }
  ```

---

### 3. memo

- [프로세스 생성과정](https://velog.io/@ireneeming/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-%EC%83%9D%EC%84%B1-%EA%B3%BC%EC%A0%95)
- chap.13 연습문제 4번 리뷰하기
