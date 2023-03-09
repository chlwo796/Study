2023년 3월 9일 목요일

---

## day47

### 1. java

- chap.17 스트림
- 단계별 코딩(마지막 단계까지 코드가 완성되어야지 최종처리)
- 처리속도가 매우 빠름
- StreamEx01 실습

  ```java
  package javaHigh11.example01;

  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.Set;

  public class StreamEx01 {
      public static void main(String[] args) {
          Set<String> set = new HashSet<String>();
          set.add("홍길동");
          set.add("신용권");
          set.add("김자바");

          Iterator<String> it = set.iterator();

          while (it.hasNext()) {
              System.out.println(it.next());
          }
          System.out.println("스트림이용");
          set.stream().forEach(name -> System.out.println(name));
      }
  }
  ```

- ParallelStreamEx01 실습

  ```java
  package javaHigh11.example01;

  // util 패키지의 모두 다 import
  import java.util.*;

  public class ParalleStreamEx01 {
      public static void main(String[] args) {
          List<Integer> list = new ArrayList<Integer>();

          list.add(1);
          list.add(2);
          list.add(3);
          list.add(4);
          list.add(5);
          list.add(6);
          list.add(7);
          list.add(8);

          list.parallelStream().forEach(n -> {
              System.out.println(n);
              // 병렬처리한 스트림은 순차처리x, 멀티스레드로 처리속도가 더 빠르다.
              System.out.println(Thread.currentThread().getName());
          });
      }
  }
  ```

- StreamPipeLineEx01 실습

  ```java
  package javaHigh11.example01;

  public class Student {
      private String name;
      private int score;

      public String getName() {
          return name;
      }

      public int getScore() {
          return score;
      }

      public Student(String name, int score) {
          super();
          this.name = name;
          this.score = score;
      }
  }
  ```

  ```java
  package javaHigh11.example01;

  import java.util.Arrays;
  import java.util.List;

  public class StreamPipeLineEx01 {
      public static void main(String[] args) {
          // T... = 여러개
          List<Student> studentList = Arrays.asList(new Student("홍길동1", 20), new Student("홍길동2", 30),
                  new Student("홍길동3", 40), new Student("홍길동4", 50), new Student("홍길동5", 60));
          // 평균구하기, peek() 중간처리 출력
          double average = studentList.stream().mapToInt(student -> student.getScore())
                  .peek(score -> System.out.println(score)).average().getAsDouble();
          System.out.println(average);
          // 합계구하기
          int sum = studentList.stream().mapToInt(student -> student.getScore()).sum();
          System.out.println(sum);

      }
  }
  ```

- append() 메소드에 String 연산을 같이 하지 않는다.(StringBuilder를 사용한 목적에 어긋남)

  ```java
  package javaHigh11.example02;

  public class Product {
      private int pno;
      private String name;
      private String company;
      private int price;

      public int getPno() {
          return pno;
      }

      public String getName() {
          return name;
      }

      public String getCompany() {
          return company;
      }

      public int getPrice() {
          return price;
      }

      public Product(int pno, String name, String company, int price) {
          super();
          this.pno = pno;
          this.name = name;
          this.company = company;
          this.price = price;
      }

      @Override
      public String toString() {

          return new StringBuilder().append("{pno: ").append(pno).append(", name: ").append(name).append(", company : ")
                  .append(company).append(", price : ").append(price).append("}").toString();
      }
  }
  ```

- StreamEx02 실습

  ```java
  package javaHigh11.example02;

  import java.util.ArrayList;
  import java.util.List;

  public class StreamEx02 {
      public static void main(String[] args) {
          List<Product> list = new ArrayList<Product>();
          for (int i = 1; i <= 5; i++) {
              Product product = new Product(i, "상품" + i, "멋진 회사 ", (int) (10000 * Math.random()));
              list.add(product);
          }
          list.stream().forEach(p -> System.out.println(p));
      }
  }
  ```

---

### 2. js

- 자바스크립트를 html에 적용하는 방법
- 내부
  - <script> html 안에 사용
- 외부
  - <script src = "xxx.js"></script>
- 입출력 방법
  - 알림창 출력 : alert("메세지");
    - let number = 100;
    - alert(number + "클릭을 하셨습니다");
  - 확인창 출력 : confirm("메세지");
    - let t1 = document.getElementByid("text1");
    - t1.onclick = function(){
      let name = "홍길동";
      let result = confirm(name + "자바스크립트를 클릭하셨습니다");
      // 확인 - true, 취소 - false
      if(result){
      name = "정현희";
      alert(name);
      }else{
      alert(name);
      }
      }
- 프롬프트 창으로 입력받기
  - prompt("메세지", [기본값]) []-선택
- 웹브라우저에 출력하기
  - document.write("<p> 내용 </p>"); <p>는 임의의 태그
- 콘솔창에 출력하기
  - console.log("출력할 내용") : 중간중간 실행이 잘 되는지 확인(브라우저 -> F12,console창 확인)

---

### 2. memo

- [시나공핵심요약pdf](https://www.sinagong.co.kr/pds?sCase=L&lcd=001&idx=16&bookcd=BN003559&fg=pd03)
- [자바스크립트 변수](https://paperblock.tistory.com/42)
-
