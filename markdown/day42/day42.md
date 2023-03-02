2023년 3월 2일 목요일

---

## day42

### 1. java

- thread : 멀티프로그램(전화, 인터넷 사용 등)

```java
implements Runnable{
run(){
    // 전화걸기
}
}

extends Thread{
run(){

}
}
```

- 스레드 이름, 우선순위

  ```java
  package javaHigh08.example04;

  public class PhoneThread implements Runnable {
    @Override
    public void run() {
      System.out.println("전화걸기");
    }
  }
  ```

  ```java
  package javaHigh08.example04;

  public class YoutubeThread extends Thread {
    @Override
    public void run() {
      System.out.println("유튜브 보기");

    }
  }
  ```

  ```java
  package javaHigh08.example04;

  public class ThreadEx04 {
    public static void main(String[] args) {
      Thread mainThread = Thread.currentThread();
      String threadName = mainThread.getName();
      System.out.println(threadName);

      PhoneThread ph = new PhoneThread();
      Thread t1 = new Thread(ph);
      t1.start();

      YoutubeThread yu = new YoutubeThread();
      yu.start();

      System.out.println("스레드이름 : " + t1.getName());
      System.out.println(yu.getName());
      System.out.println(t1.getName());

      t1.setName("전화걸기");
      yu.setName("유튜브보기");
      System.out.println(yu.getName());
      System.out.println(t1.getName());

      System.out.println(t1.getPriority());// 우선순위 = 1~10

      t1.setPriority(1);
      yu.setPriority(10);
    }
  }
  ```

- Thread.sleep(milliseconds) : 주어진 시간 동안 스레드를 일시 정지 상태로 만들며, 주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.
- t2.join() : 동시 실행중 t2스레드가 먼저 끝나고 join을 호출한 스레드 실행대기
- ThreadEx05 실습

  ```java
  package javaHigh08.example04;

  public class ThreadEx05 {
    public static void main(String[] args) {

      Thread t2 = new Thread(new Runnable() {
        public void run() {
          for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= 9; j++) {
              System.out.println(i + "X" + j + "=" + (i * j));
              try {
                Thread.sleep(20);
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
          }
        }
      });

      Thread t1 = new Thread(new Runnable() {
        public void run() {

          try {
            t2.start();
            t2.join(); // t2를 완료한 후 t1 마저 실행, t1실행대기

          } catch (InterruptedException e) {
  //					 TODO Auto-generated catch block
            e.printStackTrace();
          }
          for (int i = 0; i < 72; i++) {
            System.out.println("---------");
            try {
              Thread.sleep(20);
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
        }
      });
      t1.start();
    }
  }
  ```

- 스레드동기화
- 임계영역 : 스레드가 사용하고 있는 메소드를 다른 스레드가 사용하지 못하게 막아 주는 영역
- `synchronized`
  - `public synchronized returnType methodName(){}` : 메소드 전체를 임계영역으로 만들기
  - `synchronized(this){}` : 메소드의 일부분을 임계영역으로 만들기
- SynchronizedEx 실습

  ```java
  package javaHigh08.example05;

  public class Calculator {
    private int memory;

    public int getMemory() {
      return memory;
    }

    public void setMemory1(int memory) {
      synchronized (this) {
        this.memory = memory;

        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);

      }
    }

    public synchronized void setMemory2(int memory) {

      this.memory = memory;

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
  }
  ```

  ```java
  package javaHigh08.example05;

  public class User1Thread extends Thread {
    private Calculator calculator;

    public User1Thread() {
      // Thread의 이름을 넣어줌
      setName("User1Thread");
    }

    public void setCalculator(Calculator calculator) {
      this.calculator = calculator;
    }

    @Override
    public void run() {
  //		calculator.setMemory1(100);
      calculator.setMemory2(100);
    }

  }
  ```

  ```java
  package javaHigh08.example05;

  public class User2Thread extends Thread {
    private Calculator calculator;

    public User2Thread() {
      // Thread의 이름을 넣어줌
      setName("User2Thread");
    }

    public void setCalculator(Calculator calculator) {
      this.calculator = calculator;
    }

    @Override
    public void run() {
  //		calculator.setMemory1(50);
      calculator.setMemory2(50);
    }

  }
  ```

  ```java
  package javaHigh08.example05;

  public class SynchronizedEx {
    public static void main(String[] args) {
      Calculator calculator = new Calculator();

      User1Thread user1Thread = new User1Thread();
      user1Thread.setCalculator(calculator);
      user1Thread.start();
      User2Thread user2Thread = new User2Thread();
      user2Thread.setCalculator(calculator);
      user2Thread.start();
    }

  }
  ```

- `notify()`, `wait()` : 충돌하지않고 교차실행
- WaitNotifyEx 실습

  ```java
  package javaHigh08.example06;

  public class ThreadA extends Thread {
    private WorkObject workObject;

    public ThreadA(WorkObject workObject) {
      this.workObject = workObject;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        try {
          workObject.methodA();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }
  ```

  ```java
  package javaHigh08.example06;

  public class ThreadB extends Thread {
    private WorkObject workObject;

    public ThreadB(WorkObject workObject) {
      this.workObject = workObject;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {

        try {
          workObject.methodB();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }
    }
  }
  ```

  ```java
  package javaHigh08.example06;

  public class WorkObject {
    public synchronized void  methodA() throws InterruptedException {
      System.out.println("ThreadA methodA() 작업중");
      notify(); // 실행
      wait();
    }

    public synchronized void methodB() throws InterruptedException {
      System.out.println("ThreadA methodB() 작업중");
      notify();
      wait();
    }
  }
  ```

  ```java
  package javaHigh08.example06;

  public class WaitNotifyEx {
    public static void main(String[] args) {
      WorkObject workObject = new WorkObject();
      ThreadA threadA = new ThreadA(workObject);
      ThreadB threadB = new ThreadB(workObject);

      threadA.start();
      threadB.start();

  //		threadB.setDaemon(true); // threadB를 데몬스레드로 인정
  //		threadA.setDaemon(false); // threadA 데몬스레드 헤제
    }
  }
  ```

- 안전종료 스킵
- 데몬(daemon)스레드 : 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드, 주 스레드가 종료되면 같이 따라서 자동종료
- 실제로 스레드 코드는 run() 메소드 override하지 않고 스레드 풀을 이용한다.
- 스레드풀(thread pool) : 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해놓고 작업 큐(queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식
- 스레드풀 스킵
- chap.16 람다식
- 람다식은 코드를 간단하게 표현할 수 있는 방법
- `@FunctionalInterface` : 함수적 인터페이스, 하나의 추상메소드만 가지고 있는 인터페이스, 실제 붙이는 것은 선택사항
- 람다식은 함수적 인터페이스만 사용 가능

  ```java
  package javaHigh09.example01;
  @FunctionalInterface // 함수적 인터페이스 = 하나의 추상메도드만 가지고 있는 인터페이스
  public interface Calculable {
    void c();
  }
  ```

  ```java
  package javaHigh09.example01;

  public class CalculImpl implements Calculable {
    @Override
    public void c() {
      System.out.println("Calculable을 구현");

    }
  }
  ```

  ```java
  package javaHigh09.example01;

  public class LambdaEx01 {
    public static void main(String[] args) {
      // 기본 방법
      CalculImpl c1 = new CalculImpl();
      c1.c();

      // 방법2 = 익명구현객체

      Calculable c2 = new Calculable() {

        @Override
        public void c() {
          System.out.println("익명구현객체");

        }
      };
      c2.c();

      // 방법3 람다식
      Calculable c3 = () -> System.out.println("람다식표현");
      c3.c();
    }
  }
  ```

- 매개변수가 있는 경우, 타입을 생략하고 작성하는것이 일반적이다.

  ```java
  package javaHigh09.example02;

  public interface InterfaceEx02 {
    void a(int a1, double d1);
  }
  ```

  ```java
  package javaHigh09.example02;

  public class LambdaEx02 {
    public static void main(String[] args) {
          InterfaceEx02 i4 = (a1, d1) -> System.out.println(a1 + d1);
          i4.a(20, 4);
    }
  }
  ```

- return문 하나만 있을 경우에는 중괄호와 함께 생략 가능
- 메소드 참조 표현 : 람다식에서 입력이 되었는데, 어떤 메소드 1개만 실행하면 되는 경우에 사용 가능

  ```java
  package javaHigh09.example03;

  public interface InterfaceEx01 {
    double c(double x, double y);
  }
  ```

  ```java
  package javaHigh09.example03;

  public class Computer {
    public static double staticMethod(double x, double y) {
      return x + y;
    }

    public double instanceMethod(double x, double y) {
      return x + y;
    }
  }
  ```

  ```java
  package javaHigh09.example03;

  public class Person {
    public void action(InterfaceEx01 interfaceEx01) {
      double result = interfaceEx01.c(10, 4);
      System.out.println("결과 : " + result);
    }
  }
  ```

  ```java
  package javaHigh09.example03;

  public class LambdaEx03 {
    public static void main(String[] args) {
      Person person = new Person();
      // 익명구현객체 람다식으로 생략하는 과정
      // 리턴타입, 매개변수 동일해야 사용 가능
      person.action(new InterfaceEx01() {

        @Override
        public double c(double x, double y) {
          // TODO Auto-generated method stub
          return Computer.staticMethod(x, y);
        }
      });

      person.action((double x, double y) -> {
        return Computer.staticMethod(x, y);
      });

      person.action((x, y) -> Computer.staticMethod(x, y));

      person.action(Computer::staticMethod);

  //		person.action(Computer::voidMethod);
      // instance메소드 접근방법
      Computer computer = new Computer();
      person.action(new InterfaceEx01() {

        @Override
        public double c(double x, double y) {
          // TODO Auto-generated method stub
          return computer.instanceMethod(x, y);
        }
      });

      person.action((x, y) -> computer.instanceMethod(x, y));

      person.action(computer::instanceMethod);

    }
  }
  ```

---

### 2. memo

- [피보나치수열](https://memostack.tistory.com/92#article-2-3--3--%EC%9E%AC%EA%B7%80%EC%A0%81%EC%9C%BC%EB%A1%9C-%EB%B0%98%EB%B3%B5%ED%95%98%EC%97%AC-%ED%91%B8%EB%8A%94-%EB%B0%A9%EB%B2%95)
- [DAO, DTO, VO](https://melonicedlatte.com/2021/07/24/231500.html)
- [신선식품웹사이트 js실습](https://cafe.naver.com/thisiscoding)
- 백엔드 : Spring - java, DB
- 프론트엔드 : React - html, css, js
- 풀스택 : Spring, React
- 과정형평가 : java, html, css
