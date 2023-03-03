2023년 3월 3일 금요일

---

## chap.16 lambda expressions

### 1. 람다식이란?

- 함수형 프로그래밍(functional programming) : 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법
- 데이터 처리부는 데이터만 가지고 있고, 처리방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다.
- 함수형 프로그래밍의 특징 : 동일한 데이터라도 함수A를 제공해서 처리하는 결과와 함수B를 제공해서 처리하는 결과는 다를 수 있다.(데이터 처리의 다형성)
- 람다식 : 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록이며, 데이터 처리부는 람다식을 받아 매개변수에 데이터를 대입하고 중괄호를 실행시켜 처리한다.
  `lambda expression : (parameter, ...)->{function}`

- 자바는 람다식을 익명 구현객체로 변환한다.

```java
public interface Calculable{
    //추상 메소드
    void calculate(int x, int y);
}
// 익명 구현 객체
new Calculable(){
@Override
public void calculate(int x, int y){처리내용}
};
// 람다식
(x,y)->{처리내용};
// 람다식은 인터페이스의 익명 구현 객체이므로, 인터페이스 타입의 매개변수에 대입될 수 있다.
public void action(Calculable calculable){
    int x = 10;
    int y = 4;
    calculable.calculate(x, y);
}
// action 메소드를 호출할 때 매개값으로 다음과 같이 람다식을 제공할 수 있다.
// action 메소드에서 calculable.calculate(x,y)를 실행하면 람다식의 중괄호 블록이 실행되면서 데이터가 처리된다.
// action 메소드는 람다식을 이용해서 내부 데이터를 처리하는 처리부 역할을 한다.
action((x,y)->{
    int result = x + y;
    System.out.println(result);
});
```

- 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다.
- 함수형 인터페이스(functional interface) : 단 하나의 추상 메소드를 가진 인터페이스
- `@FunctionalInterface` : 인터페이스가 함수형 인터페이스임을 보장하는 어노테이션이며, 실제 기술하는것은 선택사항이다.
- LambdaExample 예제

  ```java
  package javaChap16.example01;

  @FunctionalInterface  // 함수형 인터페이스 선언
  public interface Calculable {
      void calculate(int x, int y);
  }
  ```

  ```java
  package javaChap16.example01;

  public class LambdaExample {
      public static void main(String[] args) {
          action((x, y) -> {
              int result = x + y;
              System.out.println(result);
          });
          action((x, y) -> {
              int result = x - y;
              System.out.println(result);
          });
      }

      public static void action(Calculable calculable) {
          int x = 10;
          int y = 4;

          calculable.calculate(x, y);
      }
  }
  ```

---

### 2. 매개변수가 없는 람다식

- 함수형 인터페이스의 추상 메소드에 매개변수가 없을 경우, 람다식은 다음과 같이 작성할 수 있다.

```java
() -> {
    // 실행내용
    // 실행내용
    // 실행내용이 두개 이상일 경우 중괄호 사용
}
() -> // 실행내용이 한줄일 경우 중괄호 생략 가능
```

- LambdaExample 예제

  ```java
  package javaChap16.example02;

  @FunctionalInterface
  public interface Workable {
      void work();
  }
  ```

  ```java
  package javaChap16.example02;

  public class Person {
      public void action(Workable workable) {
          workable.work();
      }
  }
  ```

  ```java
  package javaChap16.example02;

  public class LambdaExample {
      public static void main(String[] args) {
          Person person = new Person();
          person.action(() -> {
              System.out.println("출근을 합니다.");
              System.out.println("프로그래밍을 합니다.");
          });
          person.action(() -> System.out.println("퇴근합니다."));
      }
  }
  ```

- ButtonExample 예제

  ```java
  package javaChap16.example02;

  public class Button {

      @FunctionalInterface
      public static interface ClickListener {
          void onClick();
      }

      private ClickListener clickListener;

      public void setClickListener(ClickListener clickListener) {
          this.clickListener = clickListener;
      }

      public void click() {
          this.clickListener.onClick();
      }
  }
  ```

  ```java
  package javaChap16.example02;

  public class ButtonExample {
      public static void main(String[] args) {
          Button btnOk = new Button();

          btnOk.setClickListener(() -> System.out.println("Ok 버튼을 클릭했습니다."));
          btnOk.click();

          Button btnCancel = new Button();
          btnCancel.setClickListener(() -> System.out.println("Cancle 버튼을 클릭했습니다."));
          btnCancel.click();
      }
  }
  ```

---

### 3. 매개변수가 있는 람다식

- 매개변수를 선언할 때 타입은 생략할 수 있고, 구체적인 타입 대신에 var를 사용할 수도 있지만 일반적으로 타입을 생략하고 작성한다.

  ```java
  (Type parameter, ...) -> {
      // 실행내용
      // 실행내용
  }
  (var parameter, ...) -> {
      // 실행내용
      // 실행내용
  }
  (parameter, ...) -> {
      // 실행내용
      // 실행내용
  }
  // 매개변수가 하나일 경우 () 생략할 수도 있으며, 이 때 Type 또는 var를 붙일 수 없다.
  parameter ->{
      // 실행내용
      // 실행내용
  }
  ```

- LambdaExample 예제

  ```java
  package javaChap16.example03;

  @FunctionalInterface
  public interface Speakable {
      void speak(String content);
  }
  ```

  ```java
  package javaChap16.example03;

  @FunctionalInterface
  public interface Workable {
      void work(String name, String job);
  }
  ```

  ```java
  package javaChap16.example03;

  public class Person {
      public void action1(Workable workable) {
          workable.work("홍길동", "프로그래밍");
      }
      public void action2(Speakable speakable) {
          speakable.speak("안녕하세요");
      }
  }
  ```

  ```java
  package javaChap16.example03;

  public class LambdaExample {
      public static void main(String[] args) {
          Person person = new Person();

          person.action1((name, job) -> {
              System.out.print(name + "이 ");
              System.out.println(job + "을 합니다.");
          });
          person.action2(content -> System.out.println("\"" + content + "\" 라고 외칩니다.")

          );
      }
  }
  ```

---

### 4. 리턴값이 있는 람다식

- 함수형 인터페이스의 추상 메소드에 리턴값이 있을 경우 람다식은 다음과 같이 작성할 수 있다.

  ```java
  (parameter, ...) ->{
      // 실행내용
      return null;
  }
  // 리턴문이 하나만 있을 경우, {}와 함께 return 생략 가능
  // 리턴값은 연산식 또는 리턴값 있는 메소드 호출로 대체할 수 있다.
  (parameter, ...) -> null;
  ```

- LambdaExample 예제

  ```java
  package javaChap16.example04;

  @FunctionalInterface
  public interface Calculable {
      double calc(double x, double y);
  }
  ```

  ```java
  package javaChap16.example04;

  public class Person {
      public void action(Calculable calculable) {
          double result = calculable.calc(10, 4);
          System.out.println("결과 : " + result);
      }
  }
  ```

  ```java
  package javaChap16.example04;

  public class LambdaExample {
      public static void main(String[] args) {
          Person person = new Person();

          person.action((x, y) -> {
              double result = x + y;
              return result;
          });
          // return문 생략 후 연산식으로 대체
          person.action((x, y) -> (x + y));
          // return 생략 후 메소드로 대체
          person.action((x, y) -> sum(x, y));
      }

      public static double sum(double x, double y) {
          return x + y;
      }
  }
  ```

---

### 5. 메소드 참조

- 메소드 참조는 말 그대로 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다.

  ```java
  (left, right)->Math.max(left,right);
  // 여기서 람다식은 단순히 두 개의 값을 Math.max() 메소드의 매개값으로 전달하는 역할만 한다.
  // 이런 경우, 메소드 참조를 이용하여 깔끔하게 처리할 수 있다.
  Math :: max;
  ```

1. 정적 메소드와 인스턴스 메소드 참조

- 정적(static) 메소드를 참조할 경우에는 클래스 이름 뒤에 `::` 기호를 붙이고 정적 메소드 이름을 기술한다.

  `ClassName :: methodName`

- 인스턴스 메소드일 경우네는 먼저 객체생성한 다음 참조 변수 뒤에 `::` 기호를 붙이고 인스턴스 메소드 이름을 기술한다.

  ```java
  ClassName className = new ClassName();

  className :: methodName
  ```

- MethodReferenceExample 예제

  ```java
  package javaChap16.example05;

  @FunctionalInterface
  public interface Calculable {
      double calc(double x, double y);
  }
  ```

  ```java
  package javaChap16.example05;

  public class Person {
      public void action(Calculable calculable) {
          double result = calculable.calc(10, 4);
          System.out.println("결과 : " + result);
      }
  }
  ```

  ```java
  package javaChap16.example05;

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
  package javaChap16.example05;

  public class MethodReferenceExample {
      public static void main(String[] args) {
          Person person = new Person();

          person.action((x, y) -> Computer.staticMethod(x, y));
          // x,y 라는 매개변수를 받는 Computer의 staticMethod는 단순히 매개변수만 받아서 처리 후 리턴한다.
          // 정적메소드 참조형
          person.action(Computer::staticMethod);
          // 객체생성 후 인스턴스메소드 접근
          Computer computer = new Computer();

          person.action((x, y) -> computer.instanceMethod(x, y));
          // 인스턴스메소드 참조형
          person.action(computer::instanceMethod);
      }
  }
  ```

2. 매개변수의 메소드 참조

```java
// a 매개변수의 메소드를 호출해서 b 매개변수를 매개값으로 사용하는 경우
(a,b)->{a.instanceMethod(b);}
// 메소드 참조로 표현
ClassName :: instanceMethod
// 작성방법은 정적 메소드 참조와 동일하지만, a의 인스턴스 메소드가 사용된다는 점에서 다르다.
```

- MethodReferenceExample 예제

  ```java
  package javaChap16.example06;

  @FunctionalInterface
  public interface Comparable {
      int compare(String a, String b);
  }
  ```

  ```java
  package javaChap16.example06;

  public class Person {
      public void ordering(Comparable comparable) {
          String a = "홍길동";
          String b = "김길동";

          int result = comparable.compare(a, b);

          if(result<0) {
              System.out.println(a + "은 " + b + "보다 앞에 옵니다.");
          }else if(result == 0) {
              System.out.println(a + "은 " + b + "과 같습니다.");
          }else {
              System.out.println(a + "은 " + b + "보다 뒤에 옵니다.");
          }
      }
  }
  ```

  ```java
  package javaChap16.example06;

  public class MethodReferenceExample {
      public static void main(String[] args) {
          Person person = new Person();

          person.ordering((a, b) -> a.compareToIgnoreCase(b));
          // a의 클래스(타입) :: methodName
          person.ordering(String::compareToIgnoreCase);
      }
  }
  ```

---

### 6. 생성자 참조

- 생성자를 참조한다는 것은 객체를 생성하는 것을 의미하며, 람다식이 단순히 객체를 생성하고 리턴하도록 구성된다면 람다식을 생성자 참조로 대치할 수 있다.

  ```java
  (a,b) -> {return new ClassName(a,b);}

  // 생성자 참조 표현
  ClassName :: new
  // 생성자가 오버로딩되어 여러 개가 있을 경우, 컴파일러는 함수형 인터페이스의 추상 메소드와 동일한 매개변수 타입과 개수를 가지고 있는 생성자를 찾아 실행한다.
  ```

- ConstuctorreferenceExample 예제

  ```java
  package javaChap16.example07;

  @FunctionalInterface
  public interface Creatable1 {
      public Member create(String id);
  }
  ```

  ```java
  package javaChap16.example07;

  @FunctionalInterface
  public interface Creatable2 {
      public Member create(String id, String name);
  }
  ```

  ```java
  package javaChap16.example07;

  public class Member {
      private String id;
      private String name;

      public Member(String id, String name) {
          super();
          this.id = id;
          this.name = name;
          System.out.println("Member(String id, String name)");
      }

      public Member(String id) {
          super();
          this.id = id;
          System.out.println("Member(String id)");
      }

      @Override
      public String toString() {
          String info = "{id: " + id + ", name: " + name + "}";
          return info;
      }
  }
  ```

  ```java
  package javaChap16.example07;

  public class Person {
      public Member getMember1(Creatable1 creatable1) {
          String id = "Winter";
          Member member = creatable1.create(id);
          return member;
      }

      public Member getMember2(Creatable2 creatable2) {
          String id = "Winter";
          String name = "한겨울";
          Member member = creatable2.create(id, name);
          return member;
      }
  }
  ```

  ```java
  package javaChap16.example07;

  public class ConstructorReferenceExample {
      public static void main(String[] args) {
          Person person = new Person();
          Member member1 = person.getMember1(id -> new Member(id));
          // 생성자 참조표현
          member1 = person.getMember1(Member::new);
          System.out.println(member1);

          Member member2 = person.getMember2((id, name) -> new Member(id, name));
          // 생성자 참조표현, getMember2의 추상메소드의 매개변수에 따라 맞는 생성자를 찾아 생성한다. 없으면 컴파일 오류
          member2 = person.getMember2(Member::new);
          System.out.println(member2);
      }
  }
  ```
