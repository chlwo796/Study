2023년 2월 27일 월요일

---

## day40

### 1. remind

- 어노테이션

---

### 2. java

- chap.12 연습문제
- chap.13 제네릭
- 제네릭(Generic) : 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능
- GenericEx01 실습

  ```java
  package javaHigh07.example01;

  public class GenericEx01 {
      public static void main(String[] args) {
          Box<String> box1 = new Box<String>();
          box1.content = "사과";
  //		box1.content = 100;	// Box<String> 이므로 에러발생

          Box<Integer> box2 = new Box<Integer>();
          box2.content = 100;
  //		box2.content = "사과"; // Box<Integer> 이므로 에러 발생
      }
  }
  class Box<T>{
      public T content;
  }
  ```

- GenericEx02 실습

  ```java
  package javaHigh07.example01;

  public class GenericEx02 {
      public static void main(String[] args) {
          Product<Tv, String> product1 = new Product<Tv, String>();
          product1.setKind(new Tv());
          Tv tv1 = product1.getKind();
          System.out.println(tv1); // tv1의 주소 출력
          product1.setModel("스마트tv");
          String str1 = product1.getModel();
          System.out.println(str1);

          Product<Tv, Integer> product2 = new Product<Tv, Integer>();
          product2.setKind(new Tv());
          product2.setModel(5000000);
          System.out.println(product2.getKind());
          System.out.println(product2.getModel());
          if(product2.getKind().toString().equals("TV") && product2.getModel()>=5000000) {
              System.out.println("차라리 " + new Car() +"를 사지!!!");
          }
          Product<Integer, Car> product3 = new Product<Integer, Car>();
          product3.setKind(10000000);
          product3.setModel(new Car());
          System.out.println(product3.getModel());
          System.out.println(product3.getKind());
          if(product3.getKind()>=10000000) {
              System.out.println("차라리 " + new Tv() + "를 사지 !!");
          }

      }
  }

  class Product<K, M> {
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

  class Tv{
  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return "TV";
  }
  }

  class Car{
      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "자동차";
      }
  }
  ```

- GenericEx03 실습(구조 매우 중요, 코드의 가독성)

  ```java
  package javaHigh07.example01;

  public class GenericEx03 {
      public static void main(String[] args) {
          HomeAgency homeAgency = new HomeAgency();
          Home home = homeAgency.rent();
          home.turnOnLight();

          CarAgency carAgency = new CarAgency();
          Car1 car1 = carAgency.rent();
          car1.run();
      }
  }

  interface Rentable<P> {
      P rent();
  }

  class Home {
      public void turnOnLight() {
          System.out.println("전등을 켭니다.");
      }
  }

  class Car1 {
      public void run() {
          System.out.println("자동차가 달립니다.");
      }
  }
  class HomeAgency implements Rentable<Home>{
      @Override
      public Home rent() {
          // TODO Auto-generated method stub
          return new Home();
      }
  }
  class CarAgency implements Rentable<Car1>{
      @Override
      public Car1 rent() {
          // TODO Auto-generated method stub
          return new Car1();
      }
  }
  ```

- GenericEx04 실습(상속과 제네릭)

  ```java
  package javaHigh07.example01;

  public class GenericEx04 {
      public static void main(String[] args) {

      }
  }

  class A<I> {

  }

  class AA<I, J> extends A<I> {
      // 자식은 부모의 타입,제네릭 그대로 물려받아야 한다.
      // 혹은 추가로 지정해줄 수 있다.
  }

  class AAA<I, J, K> extends AA<I, J> {

  }
  ```

---

### 3. memo

- [이클립스 폰트사이즈 변경](https://hianna.tistory.com/324)
- [정보처리산업기사 기출문제](https://www.comcbt.com/xe/j3/4494879)
- [Pattern.matcher vs String.matches](https://velog.io/@edwin/JAVA-%EC%A0%95%EA%B7%9C%EC%8B%9D-%EC%84%B1%EB%8A%A5%EC%97%90-%EB%8C%80%ED%95%B4-Pattern.matcher-VS-String.matches)
- [정보처리산업기사 필기 공부법](https://m.blog.naver.com/yoonpago93/222048926417)
- [정보처리산업기사 필기](https://dandev.tistory.com/m/entry/%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC-%EC%82%B0%EC%97%85%EA%B8%B0%EC%82%AC-%ED%95%84%EA%B8%B0-%EA%B3%B5%EB%B6%80%EB%B2%95)
- 랜덤문구 출력해보기
- 클래스명, 메소드명 직관적(디테일)으로, 클래스 수가 많아지더라도 각 클래스를 간결하게(가독성), 메소드 역할별로 분류
- 프로젝트관리 : 화면정의서
- 3.3일 금요일까지 주제선정 및 화면정의서 설계
