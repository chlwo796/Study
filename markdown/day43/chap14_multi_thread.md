2023년 3월 4일 토요일

---

## chap.14 multi thread

### 1. 멀티 스레드 개념

- 운영체제는 실행 중인 프로그램을 프로세스로 관리한다.
- 멀티 태스킹은 두 가지 이상의 작업을 동시에 처리하는 것을 말하며, 이때 운영체제가 멀티 프로세스를 생성해서 처리한다.
- 하나의 프로세스에서 두 가지 이상의 작업을 처리할 수도 있는데, 이 때 멀티 스레드를 사용한다.
- 멀티스레드는 데이터를 분할해서 병렬로 처리하는 곳에서 사용하기도 하고, 안드로이드 앱에서 네트워크 통신을 하기 위해 사용하기도 한다.
  ![](https://mblogthumb-phinf.pstatic.net/20160605_158/mals93_1465132479088M2CDj_PNG/%B1%D7%B8%B21.png?type=w800)

---

### 2. 메인 스레드

- 모든 자바 프로그램은 메인 스레드가 main() 메소드를 실행하면서 시작된다.

  ```java
  public static void main(String[] args){
      // 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행하고, main() 메소드의 마지막 코드를 실행하거나 return 문을 만나면 실행을 종료한다.
      String data = null;
      if(...){

      }
      while(..){

      }
      System.out.println("");
  }
  ```

  - 메인 스레드는 필요에 따라 추가 작업 스레드들을 만들어서 실행시킬 수 있고, 이런 멀티 스레드에서는 실행중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다.

  ![](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPn4duTXRNTg_Mo8Vj4cNtVbPi0eD812qASA&usqp=CAU)

---

### 3. 작업 스레드 생성과 실행

- 자바는 작업 스레드로 객체로 관리하므로 클래스가 필요하며, Thread 클래스로 직접 객체를 생성해도 되지만, 하위 클래스를 만들어 생성할 수도 있다.

1. Thread 클래스로 직접 생성

- java.lang 패키지에 있는 Thread 클래스로부터 작업 스레드 객체를 직접 생성한다.

  ```java
  // Runnable 구현객체를 매개값으로 갖는 생성자로 호출
  Thread thread = new Thread(Runnable target);

  // Runnable은 스레드가 작업을 실행할 때 사용하는 인터페이스이다.
  // Runnable 구현클래스 작성

  class Task implements Runnable{
      @Override
      public void run(){
          // 스레드가 실행할 내용
      }
  }

  Runnable task = new Task(); // 다형성
  Thread thread = new Thread(task);

  // 명시적 Runnable 구현 클래스를 작성하지 않고 익명 구현 객체를 매개값으로 호출(가장 많이 사용)
  Thread thread = new Thread(new Runnable(){
      @Override
      public void run(){
          // 스레드가 실행할 코드
      }
  });

  // 스레드 생성 후 스레드 객체의 start() 메소드 호출(작업스레드 실행)
  thread.start();
  ```

- BeepPrintExample 예제

  ```java
  package javaChap14.example01;

  import java.awt.Toolkit;

  public class BeepPrintExample {
      public static void main(String[] args) throws InterruptedException {
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          for (int i = 0; i < 5; i++) {
              toolkit.beep();
              Thread.sleep(300);
          }
          // main 스레드는 싱글스레드로 다중처리작업을 할 수 없는 것을 보여준다.
          for(int i = 0;i<5;i++) {
              System.out.println("띵");
              Thread.sleep(300);
          }
      }
  }
  ```

  ```java
  package javaChap14.example01;

  import java.awt.Toolkit;

  public class BeepPrintExample {
      public static void main(String[] args) throws InterruptedException {
          // 작업스레드 추가 후 멀티스레드로 동시처리
          Thread thread = new Thread(new Runnable() {

              @Override
              public void run() {
                  Toolkit toolkit = Toolkit.getDefaultToolkit();
                  for (int i = 0; i < 5; i++) {
                      toolkit.beep();
                      try {
                          Thread.sleep(300);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

              }
          });
          thread.start();

          for (int i = 0; i < 5; i++) {
              System.out.println("띵");
              Thread.sleep(300);
          }
      }
  }
  ```

2. Thread 자식 클래스로 생성

- Thread 클래스를 상속한 다음 run() 메소드를 재정의해서 스레드가 실행할 코드를 작성하고 객체를 생성하면 된다.

  ```java
  public class WorkerThread extends Thread{
      @Override
      public void run(){
          // 실행내용
      }
  }
  // 부모 Thread 타입으로 자식클래스 객체 생성
  Thread thread = new WorkerThread();
  thread.start();

  // Thread 의 익명 자식객체 사용(더 많이 사용)
  Thread thread = new Thread(){
      @Override
      public void run(){
          // 실행내용
      }
  };
  thread.start();
  ```

- BeepPrintExample 예제

  ```java
  package javaChap14.example02;

  import java.awt.Toolkit;

  public class BeepPrintExample {
      public static void main(String[] args) throws InterruptedException {
          // 익명 자식 객체로 생성
          Thread thread = new Thread() {
              @Override
              public void run() {
                  Toolkit toolkit = Toolkit.getDefaultToolkit();
                  for (int i = 0; i < 5; i++) {
                      toolkit.beep();
                      try {
                          Thread.sleep(500);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          };
          thread.start();

          for (int i = 0; i < 5; i++) {
              System.out.println("띵");
              Thread.sleep(500);
          }
      }
  }
  ```

---

### 4. 스레드 이름

- 스레드는 자신의 이름을 가지고 있으며, 메인 스레드는 `main`이라는 이름을 가지고 있고, 작업 스레드는 자동적으로 `Thread-n`이라는 이름을 가진다.

```java
// 작업 스레드의 이름을 변경하고 싶을 때 사용
thread.setName("스레드이름");
// 디버깅 할 때 어떤 스레드가 작업하는지 조사할 목적으로 사용
Thread thread = Thread.currentThread();
System.out.println(thread.getName());
```

- ThreadNameExample 예제

  ```java
  package javaChap14.example03;

  public class ThreadNameExample {
      public static void main(String[] args) {
          Thread mainThread = Thread.currentThread();
          System.out.println(mainThread.getName());

          for (int i = 0; i < 3; i++) {
              Thread threadA = new Thread() {
                  @Override
                  public void run() {
                      System.out.println(getName() + " 실행");
                  }
              };
              threadA.start();
          }
          for (int i = 0; i < 3; i++) {
              String number = Integer.toString(i);
              Thread chatThread = new Thread() {
                  @Override
                  public void run() {

                      System.out.println(getName() + " 실행");
                  }
              };
              chatThread.setName("chatThread-" + number);
              chatThread.start();
          }
      }
  }
  ```

---

### 5. 스레드 상태

- 스레드 객체를 생성(new) 하고, start() 메소드를 호출하면 곧바로 스레드가 실행되는 것이 아니라, 실행 대기 상태(runnable)가 된다.
- 실행 대기하는 스레드는 CPU 스케줄링에 따라 CPU를 점유하고 run() 메소드를 실행하며, 이때를 실행(running)상태라고 한다.
- 실행 스레드는 run() 메소드를 모두 실행하기 전에 스케줄링에 의해 다시 실행 대기상태로 돌아갈 수 있으며, 다른 스레드가 실행 상태가 된다.
- 스레드는 실행 대기 상태와 실행 상태를 번갈아 가면서 자신의 run() 메소드를 조금씩 실행하며, run()메소드가 종료되면 더 이상 실행할 코드가 없기 대문에 스레드의 실행은 멈추게 되고, 이때를 종료 상태(terminated)라고 한다.
  ![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxTcmV%2FbtqxrldjYEN%2FCRKbQUSxcRa7tcPNv9LXB0%2Fimg.png)

- 일시 정지
  - `sleep(long millis)` : 주어진 시간 동안 스레드를 일시 정지 상태로 만든다. 주어진 시간이 지나면 자동적으로 실행 대기상태가 된다.
  - `join()` : join() 메소드를 호출한 스레드는 일시 정지 상태가 된다. 실행 대기 상태가 되려면, join()메소드를 가진 스레드가 종료되어야 한다.
  - `wait()` : 동기화 블록 내에서 스레드를 일시 정지 상태로 만든다.
- 일시 정지 해제
  - `interrupt()` : 일시 정지 상태의 경우, InterruptedException을 발생시켜 실행 대기 상태, 또는 종료 상태로 만든다.
  - `notify()`, `notifyAll()` : wait() 메소드로 인해 일시 정지 상태인 스레드를 실행 대기 상태로 만든다.
- 실행 대기
  - `yield()` : 실행 상태에서 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다.

1. 주어진 시간 동안 일시 정지

- 실행 중인 스레드를 일정 시간 멈추게 하고 싶다면 Thread 클래스의 정적 메소드인 sleep()을 이용하면 된다.

```java
try{
    Thread.sleep(1000);
}catch(InterruptedException e){
    // interrupt() 메소드가 호출되면 실행
}
// 일시정지 상태에서는 InterruptedException이 발생할 수 있기 때문에 sleep()은 예외 처리가 필요한 메소드이다.
```

- SleepExample 예제

  ```java
  package javaChap14.example04;

  import java.awt.Toolkit;

  public class SleepExample {
      public static void main(String[] args) {
          Toolkit toolkit = Toolkit.getDefaultToolkit();

          for (int i = 0; i < 10; i++) {
              toolkit.beep();
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  ```

2. 다른 스레드의 종료를 기다림

- 계산 스레드의 작업이 종료된 후 그 결과값을 받아 처리하는 경우, 계산 스레드가 종료될 때 까지 기다렸다가 다른 스레드가 실행이 되어야 하는데, 이를 위해 join() 메소드를 사용한다.

  ```java
  Thread threadA = new Thread(){
      @Override
      public void run(){
          // A스레드 실행내용
      }
  };
  Thread threadB = new Thread(){
      @Override
      public void run(){
          // B스레드에서 A스레드 실행
          threadA.start();
          // B스레드 일시정지, A스레드 실행중
          threadA.join();
          // A스레드 종료 후 B스레드 실행내용 실행

      }
  };
  threadB.start();
  ```

- JoinExample 예제

  ```java
  package javaChap14.example04;

  public class SumThread extends Thread {
      private long sum;

      public long getSum() {
          return sum;
      }

      public void setSum(long sum) {
          this.sum = sum;
      }

      @Override
      public void run() {
          for (int i = 1; i <= 100; i++) {
              sum += i;
          }
      }
  }
  ```

  ```java
  package javaChap14.example04;

  public class JoinExample {
      public static void main(String[] args) throws InterruptedException {
          SumThread sumThread = new SumThread();
          sumThread.start();
          try {
              sumThread.join();
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          System.out.println(sumThread.getSum());
      }
  }
  ```

3. 다른 스레드에게 실행 양보

- 스레드가 처리하는 작업을 반복적인 실행을 위해 for문이나 while문을 포함하는 경우가 많은데, 무의미한 반복을 하는 경우 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는것이 프로그램 성능에 도움이 된다. 이런 기능을 위해 Thread의 yeild() 메소드를 사용한다.

```java
public void run(){
    while(true){
        // work의 값이 false라면 무의미한 while문 반복 -> else 조건 추가
        if(work){
        System.out.println("ThreadA 작업 내용");
    } else{
        // yield()를 호출한 스레드는 실행 대기 상태로 돌아가고, 다른 스레드가 실행 상태가 된다.
        Thread.yield();
    }
}
}
```

- YieldExample 예제

  ```java
  package javaChap14.example04;

  public class WorkThread extends Thread {
      public boolean work = true;

      public WorkThread(String name) {
          setName(name);
      }

      @Override
      public void run() {
          while (true) {
              try {
                  sleep(1000);
              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
              if (work) {
                  System.out.println(getName() + "작업처리중");
              } else {
                  Thread.yield();
              }
          }
      }
  }
  ```

  ```java
  package javaChap14.example04;

  public class YieldExample {
      public static void main(String[] args) throws InterruptedException {
          WorkThread workThreadA = new WorkThread("workThreadA");
          WorkThread workThreadB = new WorkThread("workThreadB");
          workThreadA.start();
          workThreadB.start();
          Thread.sleep(5000);
          workThreadA.work = false;
          Thread.sleep(10000);
          workThreadA.work = true;
      }
  }
  ```

---

### 6. 스레드 동기화

- 멀티 스레드는 하나의 객체를 공유해서 작업할 수도 있는데, 이 경우 다른 스레드에 의해 객체 내부 데이터가 쉽게 변경될 수 있기 때문에 의도했던 것과는 다른 결과가 나올 수 있다.
- 이를 위해 자바는 동기화(synchronized)메소드와 블록을 제공한다.
- 객체 내부에 동기화 메소드와 동기화 블록이 여러 개가 있다면 스레드가 이들 중 하나를 실행할 때 다른 스레드는 해당 메소드는 물론이고 다른 동기화 메소드 및 블록도 실행할 수 없다.(일반 메소드는 실행 가능)

1. 동기화 메소드 및 블록 선언

- 동기화 메소드를 선언하는 방법은 `synchronized` 키워드를 붙이면 되고, 인스턴스와 정적 메소드 어디든 붙일 수 있다.

  ```java
  public synchronized void method(){
      // 단 하나의 스레드만 실행하는 영역
  }
  public void method(){
      synchronized(공유객체){
          // 단 하나의 스레드만 실행하는 블록
      }
      // 여러 스레드가 실행할 수 있는 영역
  }
  ```

- SynchronizedExample 예제

  ```java
  package javaChap14.example05;

  public class Calculator {
      private int memory;

      public int getMemory() {
          return memory;
      }

      public synchronized void setMemory1(int memory) {
          this.memory = memory;
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + ": " + this.memory);
      }

      public void setMemory2(int memory) {
          synchronized (this) {
              this.memory = memory;
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName() + ": " + this.memory);
          }
      }
  }
  ```

  ```java
  package javaChap14.example05;

  public class User1Thread extends Thread {
      private Calculator calculator;

      public User1Thread() {
          setName("User1Thread");
      }

      public void setCalculator(Calculator calculator) {
          this.calculator = calculator;
      }

      @Override
      public void run() {
          calculator.setMemory1(100);
      }
  }
  ```

  ```java
  package javaChap14.example05;

  public class User2Thread extends Thread {
      private Calculator calculator;

      public User2Thread() {
          setName("User2Thread");
      }

      public void setCalculator(Calculator calculator) {
          this.calculator = calculator;
      }

      @Override
      public void run() {
          calculator.setMemory1(50);
      }
  }
  ```

  ```java
  package javaChap14.example05;

  public class SynchronizedExample {
      public static void main(String[] args) {
          Calculator calculator = new Calculator();
          User1Thread user1Thread = new User1Thread();
          user1Thread.setCalculator(calculator);
          User2Thread user2Thread = new User2Thread();
          user2Thread.setCalculator(calculator);
          // 메인스레드에서 거의 동시에 시작하더라도 동기화되어 데이터가 각각 다르게 출력됨을 확인할 수 있다.
          user1Thread.start();
          user2Thread.start();
      }
  }
  ```

2. wait()과 notify()를 이용한 스레드제어

- wait()과 notify() 메소드를 이용하여 두 스레드를 교대로 번갈아 가며 실행할 수 있다.
- 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 정해 놓으며, 한 스레드가 작업을 완료하면 notify()메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태고 만들고, 자신은 두번 작업을 하지 않도록 wait() 메소드를 호출하여 일시 정지 상태로 만든다.
- WaitNotifyExample 예제

  ```java
  package javaChap14.example05;

  public class WorkObject {
      public synchronized void methodA() throws InterruptedException {
          Thread thread = Thread.currentThread();
          System.out.println(thread.getName() + ": methodA 작업 실행");
          notify();
          wait();
      }

      public synchronized void methodB() throws InterruptedException {
          Thread thread = Thread.currentThread();
          System.out.println(thread.getName() + ": methodB 작업 실행");
          notify();
          wait();
      }
  }
  ```

  ```java
  package javaChap14.example05;

  public class ThreadA extends Thread {
      private WorkObject workObject;

      public ThreadA(WorkObject workObject) {
          setName("ThreadA");
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
  package javaChap14.example05;

  public class ThreadB extends Thread {
      private WorkObject workObject;

      public ThreadB(WorkObject workObject) {
          setName("ThreadB");
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
  package javaChap14.example05;

  public class WaitNotifyExample {
      public static void main(String[] args) {
          WorkObject workObject = new WorkObject();

          ThreadA threadA = new ThreadA(workObject);
          ThreadB threadB = new ThreadB(workObject);

          threadA.start();
          threadB.start();

          // 메인스레드는 종료하였더라도 다른 작업스레드가 남아있어 종료하지 않는다.
      }
  }
  ```

---

### 7. 스레드 안전 종료

- 스레드는 자신의 run()메소드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행중인 스레드를 즉시 종료할 필요가 있다.
- 스레드를 강제 종료하기 위해 Thread는 stop() 메소드를 제공하고 있으나 이 메소드는 deprecated 되었다.(스레드를 갑자기 종료하게 되면 사용중이던 리소스들이 불안전한 상태로 남겨진다.)
- 스레드를 안전하게 종료하는 방법은 사용하던 리소스들을 정리하고 run() 메소드를 빨리 종료하는 것인데, 주로 조건 이용 방법과 interrupt() 메소드 이용 방법을 사용한다.

1. 조건 이용

- 스레드가 while 문으로 반복 실행할 경우, 조건을 이용해서 run() 메소드의 종료를 유도할 수 있다.

  ```java
  public class ThreadA extends Thread{
      private boolean stop;

      public void run() {
          while(!stop){
              // 스레드가 반복 실행하는 내용
          }
          // 스레드가 사용한 리소스 정리
      }
  }
  ```

- SafeStopExample 예제

  ```java
  package javaChap14.example06;

  public class PrintThread1 extends Thread {
      private boolean stop;

      public void setStop(boolean stop) {
          this.stop = stop;
      }

      @Override
      public void run() {
          while (!stop) {
              System.out.println("실행중");
          }
          System.out.println("리소스정리");
          System.out.println("실행종료");
      }
  }
  ```

  ```java
  package javaChap14.example06;

  public class SafeStopExample {
      public static void main(String[] args) {
          PrintThread1 printThread1 = new PrintThread1();
          printThread1.start();

          try {
              Thread.sleep(3000);	// 메인스레드 3초 일시정지
          } catch (InterruptedException e) {
          }
          // 3초 후 boolean 값 변경
          printThread1.setStop(true);
      }
  }
  ```

2. interrupt() 메소드 이용

- interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때, InterruptedException 예외를 발생시키며, 예외 처리를 통해 run() 메소드를 정상 종료시킬 수 있다.

  ```java
  Thread thread = new Thread();
  thread.start();

  thread.interrupt(); // 일시정지 상태일때 바로 정리 후 종료.

  public void run(){
      try{
          while(true){
              Thread.sleep(1); // 잠깐의 일시정지 시간을 둔다.
          }
      }catch(InterruptedException e){

      }
      // 스레드가 사용한 리소스 정리
  }
  ```

- InterrupteExample 예제

  ```java
  package javaChap14.example06;

  public class PrintThread2 extends Thread {
      private boolean stop;

      public void setStop(boolean stop) {
          this.stop = stop;
      }

      @Override
      public void run() {
          try {
              while (!stop) {
                  System.out.println("실행중");
                  Thread.sleep(1);
              }
          } catch (InterruptedException e) {
          }
          System.out.println("리소스정리");
          System.out.println("실행종료");
      }
  }
  ```

  ```java
  package javaChap14.example06;

  public class InterruptExample {
      public static void main(String[] args) {
          PrintThread2 printThread2 = new PrintThread2();
          printThread2.start();

          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
          }

          printThread2.interrupt();
      }
  }
  ```

- 일시정지를 만들지 않고도 interrupt() 메소드 호출 여부를 알 수 있는 방법이 있다.

  ```java
  // Thread의 정적메소드 interrupted()
  boolean status = Thread.interrupted();
  // 인스턴스메소드 isInterrupted();
  boolean status = objThread.isInterrupted();
  ```

- InterruptedExample 예제

  ```java
  package javaChap14.example06;

  public class PrintThread3 extends Thread {

      @Override
      public void run() {
          while (!Thread.interrupted()) {
              System.out.println("실행중");
          }

          System.out.println("리소스정리");
          System.out.println("실행종료");
      }
  }
  ```

  ```java
  package javaChap14.example06;

  public class InterruptedExample {
      public static void main(String[] args) {
          PrintThread3 printThread3 = new PrintThread3();
          System.out.println(printThread3.isInterrupted());
          printThread3.start();

          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
          }
          printThread3.interrupt();
          System.out.println(printThread3.isInterrupted());
      }
  }
  ```

---

### 8. 데몬 스레드

- 데몬스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이며, 주 스레드가 종료되면 데몬 스레드도 따라서 자동으로 종료된다.

  ```java
  public static void main(String[] args){
      // 주 스레드는 메인스레드
      AutoSaveThread thread = new AutoSaveThread();
      // 데몬스레드는 AutoSaveThread
      thread.setDaemon(true);
      thread.start();
  }
  ```

- DaemonExample 예제

  ```java
  package javaChap14.example07;

  public class AutoSaveThread extends Thread {
      public void save() {
          System.out.println("작업 내용을 저장");
      }

      @Override
      public void run() {
          while (true) {
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  break;
              }
              save();
          }

      }
  }
  ```

  ```java
  package javaChap14.example07;

  public class DaemonExample {
      public static void main(String[] args) {
          AutoSaveThread autoSaveThread = new AutoSaveThread();
          autoSaveThread.setDaemon(true);
          autoSaveThread.start();

          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
          }
          System.out.println("메인스레드종료");
      }
  }
  ```

---

### 9. 스레드풀

- 스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐(queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다.
- 작업처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리하며, 이렇게 하면 작업량이 증가해도 스레드의 개수가 늘어나지 않아 애플리케이션의 성능이 급격히 저하되지 않는다.

  ![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F42def3b0-ffe2-4c40-a851-adbe8512ac6e%2FUntitled.png?table=block&id=28de5c65-d996-49ba-9460-49630cefdd1a&spaceId=b453bd85-cb15-44b5-bf2e-580aeda8074e&width=2000&userId=80352c12-65a4-4562-9a36-2179ed0dfffb&cache=v2)

1. 스레드풀 생성

- 자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와 Executors 클래스를 제공하고 있다.
- Executors의 두 정적 메소드를 이용하면 간단하게 스레드풀인 ExecutorService 구현 객체를 만들 수 있다.
  - `newCachedThreadPool()`
    - 초기 수 : 0
    - 코어 수 : 0
    - 최대 수 : Integer.MAX_VALUE
  - `newFixedThreadPool(int nThreads)`
    - 초기 수 : 0
    - 코어 수 : 생성된 수
    - 최대 수 : nThreads
- 초기 수 : 스레드풀이 생성될 때 기본적으로 생성되는 스레드 수
- 코어 수 : 스레드가 증가된 후 사용되지 않는 스레드를 제거할 때 최소한 풀에서 유지하는 스레드 수
- 최대 수 : 증가되는 스레드의 한도 수

  ```java
  // 초기수 0, 코어수 0, 60초 동안 스레드가 아무 작업을 하지 않으면 스레드풀에서 제거
  ExecutorService executorService = Executors.newChchedThreadPool();
  // 초기수 0, 최대수5, 생성된 스레드를 제거하지 않는다.
  ExecutorService executorService = Executors.newFixedThreadPool(5);
  // 값을 부여해 직접 생성
  ExecutorService threadPool = new ThreadPoolExecutor(
      3,  // 코어 수
      100,    // 최대 수
      120L,   // 추가된 스레드가 120초 동안 작업하지 않으면 스레드풀에서 제거
      TimeUnit.SECONDS,   // 위 시간 단위
      new SynchronousQueue<Runnable>()    // 작업 큐
  );
  ```

1. 스레드풀 종료

- 스레드풀의 스레드는 기본적으로 데몬스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아 있으며, 스레드풀의 모든 스레드를 종료하려면 ExecutorService의 `shutdown()`, `shutdownNow()` 메소드 중 하나를 실행해야 한다.

  - `void shutdown()` : 현재 처리 중인 작업 뿐만 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다.
  - `List<Runnable> shutdownNow()` : 현재 작업 처리 중인 스레드를 interrupt 해서 작업을 중지시키고 스레드풀을 종료시킨다. 리턴값은 작업 큐에 있는 미처리된 작업(Runnable)의 목록이다.

- 남아있는 작업을 마무리하고 스레드풀을 종료할 때에는 `shutdown()`을 호출하고, 남아있는 작업과는 상관없이 강제로 종료할 때에는 `shutdownNow()`를 호출하면 된다.
- ExecutorServiceExample 예제

  ```java
  package javaChap14.example08;

  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;

  public class ExecutorServiceExample {
      public static void main(String[] args) {
          // 최대 5개의 작업스레드로 운용
          ExecutorService executorService = Executors.newFixedThreadPool(5);

          executorService.shutdownNow();
      }
  }
  ```

2. 작업 생성과 처리 요청

- 하나의 작업은 Runnable 또는 Callable 구현 클래스로 표현하며, Runnable과 Callable의 차이점은 작업 처리 완료 후 리턴값이 있느냐 없느냐이다.

```java
new Runnable(){
    @Override
    public void run(){
        // 처리내용
        // 리턴값이 없다.
    }
};
new Callable<T>{
    @Override
    public T call() throws Exception{
        return T;
    }
};
```

- 작업 처리 요청 : ExecutorService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위

  - `void execute(Runnable command)` : Runnable을 작업 큐에 저장, 작업 처리 결과를 리턴하지 않음
  - `Future<T> submit(Callable<T> task)` : Callable을 작업 큐에 저장, 작업 처리 결과를 얻을 수 있도록 Future을 리턴

- Runnable 또는 Callable 객체가 ExecutorService의 작업 큐에 들어가면 ExecutorService는 처리할 스레드가 있는지 보고, 없다면 스레드를 새로 생성시키며, 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 꺼내와 run() 또는 call() 메소드를 실행하며 작업을 처리한다.

- RunnableExecuteExample 예제

  ```java
  package javaChap14.example08;

  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;

  public class RunnableExecuteExample {
      public static void main(String[] args) {
          String[][] mails = new String[1000][3];
          for (int i = 0; i < mails.length; i++) {
              mails[i][0] = "admin@my.com";
              mails[i][1] = "member" + i + "@my.com";
              mails[i][2] = "신상품입고";
          }
          ExecutorService executorService = Executors.newFixedThreadPool(5);

          for (int i = 0; i < 1000; i++) {
              final int idx = i;
              executorService.execute(new Runnable() {

                  @Override
                  public void run() {
                      Thread thread = Thread.currentThread();
                      String from = mails[idx][0];
                      String to = mails[idx][1];
                      String content = mails[idx][2];
                      System.out.println("[" + thread.getName() + "]" + from + " ==> " + to + ": " + content);
                  }
              });
          }
          executorService.shutdown();
      }
  }
  ```

- CallableSubmitExample 예제

  ```java
  package javaChap14.example08;

  import java.util.concurrent.Callable;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;
  import java.util.concurrent.Future;

  public class CallableSubmitExample {
      public static void main(String[] args) {
          ExecutorService executorService = Executors.newFixedThreadPool(5);

          for (int i = 1; i <= 100; i++) {
              final int idx = i;
              // 100개의 Callable을 생성, submit()메소드로 작업 큐에 넣는다.
              // ExecutorService는 최대 5개 스레드로 작업 큐에서 Callable을 하나씩 꺼내어 call() 메소드를 실행
              Future<Integer> future = executorService.submit(new Callable<Integer>() {
                  @Override
                  public Integer call() throws Exception {
                      int sum = 0;
                      for (int i = 1; i <= idx; i++) {
                          sum += i;
                      }
                      Thread thread = Thread.currentThread();
                      System.out.println("[" + thread.getName() + "]" + "1~" + idx + " 합 계산");
                      return sum;
                  }
              });
              try {
                  // Futre의 get()메소드는 작업이 끝날 때까지 기다렸다가 call() 메소드가 리턴한 값을 리턴
                  int result = future.get();
                  System.out.println("리턴값 : " + result);
              } catch (Exception e) {
              }
          }
          executorService.shutdown();
      }
  }
  ```
