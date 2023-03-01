2023년 3월 1일 수요일

---

## chap.13 generic

### 1. 제네릭이란?

- 제네릭(Generic) : 결정되지 않은 타입을 파라미터로 처리하고, 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능
- 결정되지 않은 content의 타입을 T라는 타입 파라미터로 정의

  ```java
  public class Box<T>{
      public T content;
  }

  Box<String> box = new Box<String>();
  box.content = "문자열";
  String content = box.content; // 강제 형변환 필요없이 바로 데이터를 얻을 수 있다.

  Box<Integer> box = new Box<Integer>();
  box.content = 100;
  int content = box.content; // 강제 형변환 필요없이 바로 데이터를 얻을 수 있다.
  ```

- 타입파라미터 `<T>` 는 단지 이름일 뿐이기 때문에 T대신 A부터 Z까지 어떤 알파벳을 사용해도 되며, 변수의 타입과 동일하다면 생성자에는 타입을 명시하지 않아도 된다.

  ```java
  Box<String> box = new Box<String>();
  Box<String> box = new Box<>();  // 타입 생략 가능

  Box<Integer> box = new Box<Integer>();
  Box<Integer> box = new Box<>(); // 타입 생략 가능
  ```

- GenericExample 예제

  ```java
  package javaChap13.example01;

  public class Box<T> {
      public T content;
  }
  ```

  ```java
  package javaChap13.example01;

  public class GenericExample {
      public static void main(String[] args) {
          Box<String> box1 = new Box<>();
          box1.content = "안녕하세요";
          String str = box1.content;
          System.out.println(str);

          Box<Integer> box2 = new Box<>();
          box2.content = 100;
          int value = box2.content;
          System.out.println(value);
      }
  }
  ```

### 2. 제네릭 타입

- 제네릭 타입은 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말하며, 제네릭 타입은 선언부에 `<>` 부호가 붙고 그 사이에 타입 파라미터들이 위치한다.

  ```java
  public class ClassName<A, B, ..>{
  }
  public interface InterfaceName<A, B, ..>{
  }
  ```

- 타입 파라미터는 변수명과 동일한 규칙에 따라 작성할 수 있지만 일반적으로 대문자 알파벳 한글자로 표현한다.
- 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야 하며, 지정하지 않으면 Object 타입이 암묵적으로 사용된다.
- GenericExample01 예제

  ```java
  package javaChap13.example02;

  public class Tv {
      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "Tv";
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class Car {
      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "Car";
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class Product<K, M> {
      private K kind;
      private M model;

      public K getKind() {
          return kind;
      }

      public void setKind(K kind) {
          this.kind = kind;
      }

      public M getModel() {
          return model;
      }

      public void setModel(M model) {
          this.model = model;
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class GenericExample01 {
      public static void main(String[] args) {
          Product<Tv, String> product1 = new Product<Tv, String>();
          product1.setKind(new Tv());
          product1.setModel("스마트티비");

          Tv tv = product1.getKind();
          String tvModel = product1.getModel();

          System.out.println(tv);
          System.out.println(tvModel);

          Product<Car, String> product2 = new Product<Car, String>();
          product2.setKind(new Car());
          product2.setModel("테슬라");

          Car car = product2.getKind();
          String carModel = product2.getModel();
          System.out.println(car);
          System.out.println(carModel);
      }
  }
  ```

- GenericExample02 예제 : 제네릭타입의 인터페이스를 선언 후 해당 인터페이스를 구현하는 클래스로 접근

  ```java
  package javaChap13.example02;

  public interface Rentable<P> {
      P rent();
  }
  ```

  ```java
  package javaChap13.example02;

  public class Home {
      public void turnOnLight() {
          System.out.println("전등을 켭니다.");
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class Car {
      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "Car";
      }
      public void run() {
          System.out.println("자동차가 달립니다.");
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class HomeAgency implements Rentable<Home> {
      @Override
      public Home rent() {

          return new Home();
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class CarAgency implements Rentable<Car> {
      @Override
      public Car rent() {

          return new Car();
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class GenericExample02 {
      public static void main(String[] args) {
          HomeAgency homeAgency = new HomeAgency();
          Home home = homeAgency.rent();
          home.turnOnLight();

          CarAgency carAgency = new CarAgency();
          Car car = carAgency.rent();
          car.run();
      }
  }
  ```

- 타입 파라미터는 기본적으로 Object 타입으로 간주되므로 Object가 가지고 있는 메소드를 호출할 수 있다.
- GenericExample03 예제

  ```java
  package javaChap13.example02;

  public class Box<T> {
      public T content;

      public boolean compare(Box<T> box) {
          boolean result = this.content.equals(box.content);
          return result;
      }
  }
  ```

  ```java
  package javaChap13.example02;

  public class GenericExample03 {
      public static void main(String[] args) {
          Box box1 = new Box();
          box1.content = "100";

          Box box2 = new Box();
          box2.content = "100";

          Box box3 = new Box();
          box3.content = 100;

          boolean result1 = box1.compare(box2);
          System.out.println(result1);
          boolean result2 = box2.compare(box3);
          System.out.println(result2);
      }
  }
  ```

### 3. 제네릭 메소드

- 제네릭 메소드는 타입 파라미터를 가지고 있는 메소드를 말하며, 타입 파라미터가 메소드 선언부에 정의된다는 점에서 제네릭타입과 차이가 있다.
- 제네릭 메소드는 리턴 타입 앞에 `<>` 기호를 추가하고 타입 파라미터를 정의한 뒤, 리턴 타입과 매개변수 타입에서 사용한다.

  ```java
  public <A, B, ...> returnType methodName(parameter, ...){
  }
  public <T> Box<T> boxing(T t){
      // boxing() 메소드는 타입 파라미터로 <T>를 정의하고 매개변수 타입과 리턴 타입에서 T를 사용한다.
  }
  Box<Integer> box1 = boxing(100);
  Box<String> box2 = boxing("문자열");
  ```

- GenericExample 예제

  ```java
  package javaChap13.example03;

  public class Box<T> {
      private T t;

      public T getT() {
          return t;
      }

      public void setT(T t) {
          this.t = t;
      }
  }
  ```

  ```java
  package javaChap13.example03;

  public class GenericExample {
      public static void main(String[] args) {
          Box<Integer> box1 = boxing(100);
          int intValue = box1.getT();
          System.out.println(intValue);

          Box<String> box2 = boxing("홍길동");
          String strValue = box2.getT();
          System.out.println(strValue);
      }

      public static <T> Box<T> boxing(T t) {
          Box<T> box = new Box<T>();
          box.setT(t);
          return box;
      }
  }
  ```

### 4. 제한된 타입 파라미터

- 제한된 타입 파라미터(bounded type parameter) : 모든 타입으로 대체할 수 없고, 특정 타입과 자식 또는 구현 관계에 있는 타입만 대체할 수 있는 타입 파라미터

  ```java
  public <T extends ParentsType> returnType methodName(parameter,...){
  }

  public <T extends Number> boolean compare(T t1, T t2){
    // 상위 타입은 클래스 뿐만 아니라 인터페이스도 가능하다.(implements 사용x)
    double v1 = t1.doubleValue();   // Number의 doubleValue() 메소드 사용
    double v2 = t2.doubleValue();
    return (v1 == v2);
    // 타입 파라미터가 Number 타입으로 제한되면서 Object의 메소드 뿐만 아니라 Number가 가지고 있는 메소드도 사용할 수 있다.
  }
  ```

- GenericExample 예제

  ```java
  package javaChap13.example04;

  public class GenericExample {
      public static void main(String[] args) {
          boolean result1 = compare(10, 20);
          System.out.println(result1);

          boolean result2 = compare(4.3, 4.3);
          System.out.println(result2);
          // 제네릭메소드의 타입을 Number로 제한하였다.
  //		boolean result3 = compare("12", "12");
  //		System.out.println(result3);
      }

      public static <T extends Number> boolean compare(T t1, T t2) {
          System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
          double value1 = t1.doubleValue();
          double value2 = t2.doubleValue();
          return value1 == value2;
      }
  }
  ```
