2023년 3월 4일 토요일

---

## chap.17 stream

### 1. 스트림이란?

- java 8부터는 컬렉션 및 배열의 요소를 반복 처리하기 위해 스트림(stream)을 사용할 수 있다.

  ```java
  // List 컬렉션의 stream() 메소드로 Stream 객체를 얻는다.
  Stream<String> Stream = list.stream();
  // forEach() 메소드로 요소를 어떻게 처리할지를 람다식으로 제공한다.
  stream.forEach(item -> //item 처리,람다식);
  ```

- StreamExample 예제

```java
package javaChap17.example01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("홍길동1");
		set.add("홍길동2");

		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
		//forEach(Consumer<? super String> action) = Consumer라는 함수적인터페이스를 람다식으로 표현, action 메소드는 리턴값이 없다.
	}
}
```

- Stream과 Iterator의 차이
  - 내부 반복자이므로 처리속도가 빠르고, 병렬 처리에 효율적이다.
  - 람다식으로 다양한 요소 처리를 정의할 수 있다.
  - 중간 처리와 최종 처리를 수행하도록 파이프라인을 형성할 수 있다.

---

### 2. 내부 반복자

- 외부 반복자 : for문과 Iterator는 컬렉션의 요소를 컬렉션 바깥쪽으로 반복해서 가져와 처리한다.
- 내부 반복자 : 스트림과 같이 요소 처리 방법을 컬렉션 내부로 주입시켜서 요소를 반복 처리한다.
  ![](https://blog.kakaocdn.net/dn/lPrwn/btrwUj7P0ZJ/21ZIXW8x1oZdGafyNcx7O1/img.png)

- 내부 반복자는 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 작업을 할 수 있고, 하나씩 처리하는 순차적 외부 반복자보다는 효율적으로 요소를 반복시킬 수 있는 장점이 있다.
- ParallelStreamExample 예제

  ```java
  package javaChap17.example02;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.stream.Stream;

  public class ParallelStreamExample {
      public static void main(String[] args) {
          List<String> list = new ArrayList<String>();

          list.add("홍길동");
          list.add("홍길동1");
          list.add("홍길동2");
          list.add("홍길동3");
          list.add("홍길동4");

          Stream<String> parallelStream = list.parallelStream();
          parallelStream.forEach(name -> System.out.println(name + ": " + Thread.currentThread().getName()));
      }
  }
  ```

---

### 3. 중간 처리와 최종 처리

- 스트림은 하나 이상 연결될 수 있으며, 컬렉션의 오리지널 스트림 뒤에 필터링 중간 스트림이 연결될 수 있고, 그 뒤에 매핑 중간 스트림이 연결될 수 있는데, 스트림이 연결되어 있는 것을 스트림 파이프라인(pipelines)라고 한다.

  ```java
  // 오리지널 Student스트림
  Stream<Student> studentStream = list.stream();
  // Studnet 객체를 getScore() 메소드의 리턴값으로 매핑
  IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
  // IntStream은 최종 처리를 위해 다양한 메소드를 제공하며, average() 메소드는 요소들의 평균값을 계산한다.
  double avg = scoreStream.average().getAsDouble();
  // 스트림 파이프라인으로 구성할 때, 파이프라인의 맨 끝에는 반드시 최종 처리부분이 있어야 한다.

  // 메소드 체이닝 패턴을 이용하여 더 간결하게 작성(null 유의해야한다.)
  double avg = list.stream()
  .mapToInt(student -> student.getScore())
  .average()
  .getAsDouble();
  ```

- StreamPipeLineExample 예제

  ```java
  package javaChap17.example03;

  public class Student {
      private String name;
      private int score;

      public Student(String name, int score) {
          super();
          this.name = name;
          this.score = score;
      }

      public String getName() {
          return name;
      }

      public int getScore() {
          return score;
      }

  }
  ```

  ```java
  package javaChap17.example03;

  import java.util.Arrays;
  import java.util.List;
  import java.util.stream.IntStream;
  import java.util.stream.Stream;

  public class StreamPipeLineExample {
      public static void main(String[] args) {
          List<Student> list = Arrays.asList(new Student("홍길동", 30), new Student("신용권", 20), new Student("유미선", 30));
  //		Stream<Student> studentStream = list.stream();
  //		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
  //		double avg = scoreStream.average().getAsDouble();
          // 메소드 체이닝 패턴
          double avg = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();
          System.out.println(avg);
      }
  }
  ```

---

### 4. 리소스로부터 스트림 얻기

- java.util.stream 패키지에는 스트림 인터페이스들이 있으며, BaseStream 인터페이스를 부모로 다음과 같은 상속 관계를 이루고 있다.
  ![](https://velog.velcdn.com/images/dbwltkd1019/post/b5b6f2e3-bf42-4bde-a7ab-b4e7bdeef9b4/image.png)
- BaseStream에는 모든 스트림이 사용할 수 있는 공통 메소드들이 정의되어 있고, Stream은 객체 요소를 처리하는 스트림, IntStream, LongStream, DoubleStream은 각각 기본 타입인 int, long, double 요소를 처리하는 스트림이다.
  ![](https://velog.velcdn.com/images/dbwltkd1019/post/11e01f1a-a7af-4f8a-9a05-7cf04873caad/image.png)

1. 컬렉션으로부터 스트림 얻기

- java.util.Collection 인터페이스는 스트림과 parallelStream() 메소드를 가지고 있기 때문에, 자식 인터페이스인 List와 Set 인터페이스를 구현한 모든 컬렉션에서 객체 스트림을 얻을 수 있다.
- StreamExample 예제

  ```java
  package javaChap17.example04;

  public class Product {
      private int pno;
      private String name;
      private String company;
      private int price;

      public Product(int pno, String name, String company, int price) {
          super();
          this.pno = pno;
          this.name = name;
          this.company = company;
          this.price = price;
      }

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

      @Override
      public String toString() {
          return new StringBuilder().append("{").append("pno: " + pno + ", ").append("name: " + name + ", ")
                  .append("company: " + company + ", ").append("price " + price).toString();
      }
  }
  ```

  ```java
  package javaChap17.example04;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.stream.Stream;

  public class StreamExample {
      public static void main(String[] args) {
          List<Product> list = new ArrayList<Product>();
          for (int i = 1; i <= 5; i++) {
              Product product = new Product(i, "상품" + i, "멋진 회사", (int) (100000 * Math.random()));
              list.add(product);
          }
          Stream<Product> stream = list.stream();
          // .println(p) -> toString 자동실행
          stream.forEach(p -> System.out.println(p));
      }
  }
  ```

2. 배열로부터 스트림 얻기

- java.util.Arrays 클래스를 이용하면 다양한 종류의 배열로부터 스트림을 얻을 수 있다.
- ArrysToStreamExample 예제

  ```java
  package javaChap17.example04;

  import java.util.Arrays;
  import java.util.stream.IntStream;
  import java.util.stream.Stream;

  public class ArrysToStreamExample {
      public static void main(String[] args) {
          String[] strArray = { "홍길동", "홍길동1", "홍길동2" };
          Stream<String> strStream = Arrays.stream(strArray);
          strStream.forEach(name -> System.out.println(name));
          System.out.println();
          int[] intArray = { 1, 3, 4, 5, 6 };
          IntStream intStream = Arrays.stream(intArray);
          intStream.forEach(number -> System.out.println(number));
          System.out.println();
      }
  }
  ```

3. 숫자 범위로부터 스트림 얻기

- IntStream 또는 LongStream의 정적 메소드인 range()와 reangeClosed() 메소드를 이용하면 특정 범위의 정수 스트림을 얻을 수 있다.
- 첫 번째 매개값은 시작 수이고, 두번째 매개값은 끝 수인데, 끝 수를 포함하지 않으면 range(), 포함하면 rangeClosed()를 사용한다.
- NumberToStreamExample 예제

  ```java
  package javaChap17.example04;

  import java.util.stream.IntStream;

  public class NumberToStreamExample {
      public static int sum = 0;

      public static void main(String[] args) {
          // int sum을 인스턴스변수로 선언하면, final적 특성을 가지지 못하여 사용할 수 없다.
          IntStream stream = IntStream.rangeClosed(1, 100);
          stream.forEach(a -> sum += a);
          System.out.println(sum);
      }
  }
  ```

4. 파일로부터 스트림 얻기

- java.nio.file.Files의 lines() 메소드를 이용하면 텍스트 파일의 행 단위 스트림을 얻을 수 있다. 텍스트파일에서 한 행씩 읽고 처리할 때 유용하게 사용할 수 있다.

  ```java
  package javaChap17.example04;

  import java.io.IOException;
  import java.net.URISyntaxException;
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;
  import java.util.stream.Stream;

  public class FileToStreamExample {
      public static void main(String[] args) throws URISyntaxException, IOException {
          Path path = Paths.get(FileToStreamExample.class.getResource("data.txt").toURI());
          Stream<String> stream = Files.lines(path);
          stream.forEach(line -> System.out.println(line));
          stream.close();
          // 리소스 보호
      }
  }
  ```

---

### 5. 요소 걸러내기(필터링)

- 필터링은 요소를 걸러내는 중간 처리 기능이다.
  ![](https://velog.velcdn.com/images/dbwltkd1019/post/da627f07-ba8c-4d93-a878-f6fade792c67/image.png)
- distinct() 메소드는 요소의 중복을 제거하며, 객체 스트림(Stream)일 경우, equals() 메소드의 리턴값이 true 이면 동일한 요소로 판단하고, IntStream, LongStream,DoubleStream은 같은 값일 경우 중복을 제거한다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/a88f4fbe-fe25-4c02-8d45-a78040496a85/image.png)
- filter() 메소드는 매개값으로 주어진 Predicate가 true를 리턴하는 요소만 필터링한다.
  ![](https://velog.velcdn.com/images/dbwltkd1019/post/dcb09694-4443-4834-be82-327d63821e34/image.png)
- Predicate는 함수형 인터페이스 이며, 다음과 같은 종류가 있다.
  ![](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F6TOfR%2Fbtqx1AOKZ66%2FeqD8XvGQ1DwID10avsHSA1%2Fimg.png)

  ```java
  // Predicate<T>의 람다식 표현
  T -> {... return true;}
  T -> true;  // 리턴문만 있다면 중괄호와 return 키워드 생략 가능
  ```

- FilteringExample 예제

  ```java
  package javaChap17.example05;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.stream.Stream;

  public class FilteringExample {
      public static void main(String[] args) {
          List<String> list = new ArrayList<String>();
          list.add("홍길동1");
          list.add("홍길동2");
          list.add("홍길동2");
          list.add("김길동3");
          list.add("김길동3");

          Stream<String> stream = list.stream();
          stream.forEach(name -> System.out.println(name));
          System.out.println();
          // 메소드 체이닝패턴
          list.stream().distinct().forEach(name -> System.out.println(name));
          System.out.println();
          list.stream().filter(f -> f.startsWith("김")).forEach(name -> System.out.println(name));
          System.out.println();
          list.stream().distinct().filter(f -> f.startsWith("김")).forEach(name -> System.out.println(name));

      }
  }
  ```

---

### 6. 요소 변환(매핑)

- 매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다.
- 매핑 메소드는 mapXxx(), asDoubleStream(), asLongStream(), boxed(), flatMapXxx() 등이 있다.

1. 요소를 다른 요소로 변환

- mapXxx() 메소드는 요소를 다른 요소로 변환한 새로운 스트림을 리턴한다.

  ![](https://velog.velcdn.com/images/szszszsz/post/1bc61447-aec7-41ef-8f27-97984f6db9c8/image.png)

- mapXxx() 메소드의 종류

  ![](https://velog.velcdn.com/images/szszszsz/post/f61fd8a0-34db-4be6-b2d3-b109387c767e/image.png)

- 매개타입 Function은 함수형 인터페이스로, 다음과 같은 종류가 있다.

  ![](https://velog.velcdn.com/images/szszszsz/post/9d70f30b-0e3d-4d58-a8f7-a0994ab496c3/image.png)

- 모든 Function은 매개값을 리턴값으로 매핑(변환)하는 applyXxx() 메소드를 가지고 있다.
  ```java
  // Function<T,R>을 람다식으로 표현
  T -> {... return R;}
  T -> R;
  ```
- MapExample 예제

  ```java
  package javaChap17.example06;

  public class Student {
      private String name;
      private int score;

      public Student(String name, int score) {
          super();
          this.name = name;
          this.score = score;
      }

      public String getName() {
          return name;
      }

      public int getScore() {
          return score;
      }

  }
  ```

  ```java
  package javaChap17.example06;

  import java.util.ArrayList;
  import java.util.List;

  public class MapExample {
      public static void main(String[] args) {
          List<Student> studentList = new ArrayList<Student>();
          studentList.add(new Student("홍길동", 80));
          studentList.add(new Student("홍길동", 70));
          studentList.add(new Student("홍길동", 60));

          studentList.stream().mapToInt(s -> s.getScore()).forEach(score -> System.out.println(score));
      }
  }
  ```

- 기본 타입간의 변환이거나 기본 타입 요소를 래퍼(Wrapper) 객체 요소로 변환하려면 다음과 같은 메소드를 사용할 수도 있다.
  ![](https://velog.velcdn.com/images/szszszsz/post/f1032009-4b00-41b9-9987-1317ba7f1f98/image.png)
- BoxingMapExample 예제

  ```java
  package javaChap17.example06;

  import java.util.Arrays;
  import java.util.stream.IntStream;

  public class BoxingMapExample {
      public static void main(String[] args) {
          int[] intArray = { 1, 3, 5, 7, 9 };

          IntStream intStream = Arrays.stream(intArray);

          intStream.asDoubleStream().forEach(d -> System.out.println(d));

          Arrays.stream(intArray).boxed().forEach(number -> System.out.println(number));
      }
  }
  ```

2. 요소를 복수 개의 요소로 변환

- flatMapXxx() 메소드는 하나의 요소를 복수 개의 요소들로 변환한 새로운 스트림을 리턴한다.
  ![](https://velog.velcdn.com/images/szszszsz/post/db5ec2ff-2a7d-463c-beee-339786549da1/image.png)
- flatMap() 메소드의 종류
  ![](https://velog.velcdn.com/images/szszszsz/post/7ccafac2-1a9a-4107-b371-208a07475f84/image.png)
- FlatMappingExample 예제

  ```java
  package javaChap17.example06;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class FlatMappingExample {
      public static void main(String[] args) {
          List<String> list1 = new ArrayList<String>();
          list1.add("this is java");
          list1.add("i am a best developer");

          list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(data -> System.out.println(data));

          List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
          list2.stream().flatMapToInt(data -> {
              String[] strArray = data.split(",");
              int[] intArray = new int[strArray.length];
              for (int i = 0; i < intArray.length; i++) {
                  // trim() = 공백제거
                  intArray[i] = Integer.parseInt(strArray[i].trim());
              }
              // flatMapToInt() = IntStream 리턴이 필요함
              return Arrays.stream(intArray);
          }).forEach(number -> System.out.println(number));
      }
  }
  ```

---

### 7. 요소 정렬

- 정렬은 요소를 오름차순 또는 내림차순으로 정렬하는 중간 처리 기능이다.

  ![](https://velog.velcdn.com/images/szszszsz/post/d19ca7b4-c1ba-439d-ac61-f2760996003b/image.png)

1. Comparable 구현 객체의 정렬

- 스트림의 요소가 객체일 경우 객체가 Comparable을 구현하고 있어야만 sorted()메소드를 사용하여 정렬할 수 있으며, 그렇지 않으면 ClassCastException이 발생한다.

  ```java
  public ClassName implements Comparable{

  }
  List<ClassName> list = new ArrayList<>();
  Stream<ClassName> stream = list.stream();
  // 정렬된 스트림(기본 오름차순)
  Stream<ClassName> orderedStream = stream.sorted();
  // 내림차순 정렬 스트림
  Stream<ClassName> reverseOrderedStream = stream.sorted(Comparator.reverseOrder());
  ```

- SortingExample 예제

  ```java
  package javaChap17.example07;

  public class Student1 implements Comparable<Student1> {
    private String name;
    private int score;

    public Student1(String name, int score) {
      super();
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }

    @Override
    public int compareTo(Student1 o) {
      // 점수기준으로 정렬
      return Integer.compare(score, o.score);
    }
  }
  ```

  ```java
  package javaChap17.example07;

  import java.util.ArrayList;
  import java.util.Comparator;
  import java.util.List;

  public class SortingExample {
    public static void main(String[] args) {
      List<Student1> studentList = new ArrayList<Student1>();

      studentList.add(new Student1("홍길동", 60));
      studentList.add(new Student1("신용권", 40));
      studentList.add(new Student1("유미선", 30));
      // 점수기준 오름차순
      studentList.stream().sorted().forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
      System.out.println();
      // 점수기준 내림차순
      studentList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getName() + " " + s.getScore()));

    }
  }
  ```

2. Comparator를 이용한 정렬

- 요소 객체가 Comparable을 구현하고 있지 않다면, 비교자 Comparator를 이용하여 요소를 정렬시킬 수 있다.
- 비교자는 Comparator 인터페이스를 구현한 객체를 말하는데, 간단하게 람다식으로 작성할 수도 있다.

  `sorted((o1, o2)->{..});`

- ComparatorSortingExample 예제

  ```java
  package javaChap17.example07;

  public class Student2 {
    private String name;
    private int score;

    public Student2(String name, int score) {
      super();
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }
  }
  ```

  ```java
  package javaChap17.example07;

  import java.util.ArrayList;
  import java.util.List;

  public class ComparatorSortingExample {
    public static void main(String[] args) {
      List<Student2> studentList = new ArrayList<Student2>();

      studentList.add(new Student2("홍길동", 60));
      studentList.add(new Student2("신용권", 40));
      studentList.add(new Student2("유미선", 30));
      // 점수기준 오름차순
      studentList.stream().sorted((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore()))
          .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
      System.out.println();
      // 역순
      studentList.stream().sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
          .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
    }
  }
  ```

---

### 8. 요소를 하나씩 처리(루핑)

- 루핑(looping) : 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것을 말하며, 루핑 메소드에는 peek()과 forEach()가 있다.

  ![](https://velog.velcdn.com/images/szszszsz/post/9db50e81-4214-4a49-beb5-02b45069b552/image.png)

- `peek()` : 중간처리 메소드이며, 최종 처리가 뒤에 붙지 않으면 동작하지 않는다.
- `forEach()` : 최종 처리 메소드이다.
- Consumer는 함수형 인터페이스이며, 다음과 같은 종류가 있다.
  ![](https://velog.velcdn.com/images/szszszsz/post/bf4c6bed-4a58-42c1-9de3-d844bdb110c2/image.png)
- 모든 Consumer는 매개값을 처리(소비)하는 accept() 메소드를 가지고 있다.

  ```java
  // Consumer<? super T>의 람다식 표현
  T->{..};
  T -> 실행문;
  ```

- LoopingExample 예제

  ```java
  package javaChap17.example08;

  import java.util.Arrays;

  public class LoopingExample {
    public static void main(String[] args) {
      int[] intArray = { 1, 2, 3, 4, 5 };
      // peek()이 최종처리로 적용됐을 때는 동작하지 않는다.
      Arrays.stream(intArray).filter(number -> number % 2 == 0).peek(number -> System.out.println(number));

      int[] evenArray = Arrays.stream(intArray).filter(number -> number % 2 == 0).peek(number -> System.out.println(number)).toArray();

    }
  }
  ```

---

### 9. 요소 조건 만족 여부(매칭)

- 매칭은 요소들이 특정 조건에 만족하는지 여부를 조사하는 최종 처리 기능이다.
  ![](https://velog.velcdn.com/images/szszszsz/post/6e563935-691e-4991-a069-44a492e9689d/image.png)
- allMatch(), anyMatch(), noneMatch() 메소드는 매개값으로 주어진 Predicate가 리턴하는 값에 따라 ture 또는 false를 리턴한다.
- MatchingExample 예제

  ```java
  package javaChap17.example09;

  import java.util.Arrays;

  public class MatchingExample {
    public static void main(String[] args) {
      int[] intArray = { 2, 4, 6 };

      boolean result = Arrays.stream(intArray).peek(n -> System.out.printf("{%d} ", n)).allMatch(n -> n % 2 == 0);
      System.out.println();
      System.out.println("전부 2의 배수입니까?" + result);

      result = Arrays.stream(intArray).anyMatch(n -> n % 3 == 0);
      System.out.println("하나라도 3의 배수입니까?" + result);

      result = Arrays.stream(intArray).noneMatch(n-> n%3==0);
      System.out.println("3의 배수가 없습니까?" + result);
    }
  }
  ```

---

### 10. 요소 기본 집계

- 집계(aggregate)는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값등과 같이 하나의 값으로 산출하는 것을 말한다.
- 대량의 데이터를 가공해서 하나의 값으로 축소하는 리덕션(reduction)과 같다.

1. 스트림이 제공하는 기본 집계

- 스트림은 카운팅, 최대, 최소, 평균, 합계 등을 처리하는 다음과 같은 최종 처리 메소드를 제공한다.
  ![](https://velog.velcdn.com/images/szszszsz/post/4a3ee967-e0b6-45e3-ab88-eaa632d8ab1b/image.png)
- OptionalXXX는 Optional, OptionalDouble, OptionalInt, OptionalLong 클래스를 말하며, 최종값을 저장하는 객체로 get(), getAsDouble(), getAsInt(), getAsLong()을 호출하면 최종값을 얻을 수 있다.
- AggregateExample 예제

  ```java
  package javaChap17.example10;

  import java.util.Arrays;

  public class AggregateExample {
    public static void main(String[] args) {
      int[] intArray = { 1, 2, 3, 4, 5 };

      long count = Arrays.stream(intArray).peek(n -> System.out.printf("{%d}", n)).count();
      System.out.println();
      System.out.println("총 개수 : " + count);
      long evenCount = Arrays.stream(intArray).filter(n -> n % 2 == 0).count();
      System.out.println("짝수의 개수 : " + evenCount);

      long sum = Arrays.stream(intArray).filter(n -> n % 2 == 0).sum();
      System.out.println("짝수의 합 : " + sum);

      double avg = Arrays.stream(intArray).filter(n -> n % 2 == 0).average().getAsDouble();
      System.out.println("짝수의 평균 : " + avg);

      int max = Arrays.stream(intArray).filter(n -> n % 2 == 0).max().getAsInt();
      System.out.println("짝수의 최대값 : " + max);

      int min = Arrays.stream(intArray).filter(n -> n % 2 == 0).min().getAsInt();
      System.out.println("짝수의 최소값 : " + min);

      int first = Arrays.stream(intArray).filter(n -> n % 3 == 0).findFirst().getAsInt();
      System.out.println("첫번째 3의 배수 : " + first);
    }
  }

  ```

2. Optional 클래스

- Optional, OptionalDouble, OptionalInt, OptionalLong 클래스는 단순히 집계값만 저장하는 것이 아니라, 집계값이 존재하지 않을 경우 디폴트 값을 설정하거나 집계값을 처리하는 Consumer를 등록할 수 있다.
  ![](https://velog.velcdn.com/images/szszszsz/post/242e1d8c-623d-4aa7-9099-c22069043a48/image.png)
- 컬렉션의 요소는 동적으로 추가되는 경우가 많은데, 만약 컬렉션에 요소가 존재하지 않으면 집계 값을 산출할 수 없으므로 NoSuchElementException 예외가 발생하므로, 해당 메소드를 통해 예외 발생을 막을 수 있다.

```java
// isPresent() 메소드가 ture를 리턴할 때만 집계값을 얻는다.
OptionalDouble optional = stream.average();
if(optional.isPresent()){
  System.out.println("평균 : " + optional.getAsDouble());
}else{
  system.out.println("평균 : 0.0");
}
// orElse() 메소드로 집계값이 없을 경우를 대비해서 디폴트 값을 정해놓는다.
double avg = stream.average().orElse(0.0);
System.out.println("평균 : " + avg);
// ifPresent() 메소드로 집계값이 있을 경우에만 동작하는 Consumer 람다식을 제공한다.
stream.average().ifPresent(a -> System.out.println("평균 : " + a));
```

- OptionalExample 예제

  ```java
  package javaChap17.example11;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.OptionalDouble;

  public class OptionalExample {
    public static void main(String[] args) {
      List<Integer> list = new ArrayList<>();
      // NoSuchElementsException 발생(데이터가 없음)
  //		double avg = list.stream().mapToInt(n -> n.intValue()).average().getAsDouble();

      OptionalDouble optional = list.stream().mapToInt(n -> n.intValue()).average();

      if (optional.isPresent()) {
        System.out.println(optional.getAsDouble());
      } else {
        System.out.println("평균 : 0.0");
      }
      double avg = list.stream().mapToInt(n -> n.intValue()).average().orElse(0.0);
      System.out.println(avg);

      // 데이터가 없으면 최종처리(출력)를 안하도록
      list.stream().mapToInt(n -> n.intValue()).average().ifPresent(a -> System.out.println(a));
    }
  }
  ```

---

### 11. 요소 커스텀 집계

- 스트림은 기본 집계 메소드인 sum(), average(), count(), max(), min()을 제공하며, 다양한 집계 결과물을 만들 수 있도록 reduce() 메소드도 제공한다.
  ![](https://velog.velcdn.com/images/szszszsz/post/1d261056-238b-4d28-b597-35606e204422/image.png)
- 매개값인 BinaryOperator는 함수형 인터페이스이며, 두 개의 매개값을 받아 하나의 값을 리턴하는 apply()메소드를 가지고 있다.

  ```java
  // apply()메소드의 람다식 표현
  (a,b)->{... return value;}
  (a,b)-> value;
  ```

- reduce()는 스트림에 요소가 없을 경우 예외가 발생하지만, identity 매개값이 주어지면 이 값을 디폴트 값으로 리턴한다.

  ```java
  // 스트림에 요소가 없다면 NoSuchElementException 발생
  int sum = stream.reduce((a,b)->a+b).getAsInt();

  // 디폴트 값(identity) 0 리턴
  int sum = stream.reduce(0,(a,b)->a+b);
  ```

- ReductionExample 예제

  ```java
  package javaChap17.example12;

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
  package javaChap17.example12;

  import java.util.Arrays;
  import java.util.List;

  public class ReductionExample {
    public static void main(String[] args) {
      List<Student> studentList = Arrays.asList(new Student("홍길동", 92), new Student("신용권", 95),
          new Student("김자바", 88));
      int sum1 = studentList.stream().mapToInt(s -> s.getScore()).sum();
      System.out.println(sum1);
      // reduce()로 사용자 연산식 적용
      int sum2 = studentList.stream().mapToInt(s -> s.getScore()).reduce(0, (a, b) -> a + b);
      System.out.println(sum2);
    }
  }
  ```

---

### 12. 요소 수집

- 스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect()를 제공한다.

1. 필터링한 요소 수집

- Stream의 collect(Collector<T,A,R> collector) 메소드는 필터링 또는 매핑된 요소들을 새로운 컬렉션에 수집하고, 이 컬렉션을 리턴하며, 매개값인 Collector는 어떤 요소를 어떤 컬렉션에 수집할 것인지를 결정한다.

  ![](https://velog.velcdn.com/images/szszszsz/post/414d4128-4a6b-4ddf-9357-4d1a7d50759e/image.png)

- T는 요소, A는 누적기(accumulator), 그리고 R은 요소가 저장될 컬렉션이다.
- Collector의 구현 객체는 다음과 같이 Collectors 클래스의 정적메소드로 얻을 수 있다.
  ![](https://velog.velcdn.com/images/szszszsz/post/ae03aad6-3af8-4b65-8a1c-9e884a1b4569/image.png)
- Collector 리턴값의 A(누적기)가 ?인 이뉴는 Collector가 List, Set, Map 컬렉션에 요소를 저장하는 방법이 정의되어있어 별도의 누적기가 필요 없기 때문이다.

  ```java
  // Student 스트림에서 남학생만 필터링 후 별도 List 로 생성
  List<Student> maleList = totalList.stream().filter(s->s.getSex().equals("남")).collect(Collectors.toList());

  // Student 스트림에서 이름을 key, 점수를 value로 갖는 Map 컬렉션 생성
  Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s->s.getName(),s->s.getScore()));
  ```

---

- CollectExample 예제

  ```java
  package javaChap17.example12;

  public class Student {
    private String name;
    private String sex;
    private int score;

    public Student(String name, String sex, int score) {
      super();
      this.name = name;
      this.sex = sex;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public String getSex() {
      return sex;
    }

    public int getScore() {
      return score;
    }
  }
  ```

  ```java
  package javaChap17.example12;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Map;
  import java.util.Set;
  import java.util.stream.Collectors;

  public class CollectExample {
    public static void main(String[] args) {
      List<Student> totalList = new ArrayList<Student>();

      totalList.add(new Student("홍길동", "남", 92));
      totalList.add(new Student("김수영", "여", 87));
      totalList.add(new Student("김자바", "남", 95));
      totalList.add(new Student("오해영", "여", 82));

      List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("남")).collect(Collectors.toList());

      maleList.stream().forEach(s -> System.out.println(s.getName()));
      System.out.println();
      Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));

      Set<String> keySet = map.keySet();

      for (String key : keySet) {
        System.out.println(key + " " + map.get(key));
      }
    }
  }
  ```

2. 요소 그룹핑

- collect() 메소드는 단순히 요소를 수집하는 기능 이외에 컬렉션의 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공한다.
- Collectors.groupingBy() 메소드에서 얻은 Collector를 collect() 메소드를 호출할 때 제공하면 된다.

  ![https://velog.velcdn.com/images/szszszsz/post/c155b06c-2cd2-43e4-a3f1-622761086816/image.png]

- groupingBy()는 Function을 이용해서 T를 K로 매핑하고, K를 키로 List<T>를 값으로 갖는 Map 컬렉션을 생성한다.

  ```java
  // 성별을 키로 하고, List<Student>를 값으로 하는 Map을 리턴해준다.
  Map<String, List<Student>> map = totalList.stream().collect(Collects.groupingBy(s->s.getSex()));
  ```

- CollectExample 예제

  ```java
  package javaChap17.example12;

  public class Student {
    private String name;
    private String sex;
    private int score;

    public Student(String name, String sex, int score) {
      super();
      this.name = name;
      this.sex = sex;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public String getSex() {
      return sex;
    }

    public int getScore() {
      return score;
    }
  }
  ```

  ```java
  package javaChap17.example12;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Map;
  import java.util.Set;
  import java.util.stream.Collectors;

  public class CollectExample {
    public static void main(String[] args) {
      List<Student> totalList = new ArrayList<Student>();

      totalList.add(new Student("홍길동", "남", 92));
      totalList.add(new Student("김수영", "여", 87));
      totalList.add(new Student("김자바", "남", 95));
      totalList.add(new Student("오해영", "여", 82));

      List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("남")).collect(Collectors.toList());

      maleList.stream().forEach(s -> System.out.println(s.getName()));
      System.out.println();
      Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));

      Set<String> keySet = map.keySet();

      for (String key : keySet) {
        System.out.println(key + " " + map.get(key));
      }

      Map<String, List<Student>> map1 = totalList.stream().collect(Collectors.groupingBy(s -> s.getSex()));

  	  Set<String> keySet1 = map1.keySet();

  	  for (String key : keySet1) {
  		System.out.println(key + " " + map1.get(key).get(0).getName() + " " + map1.get(key).get(1).getName());
  	}
    }
  }
  ```

---

### 13. 요소 병렬 처리

- 요소 병렬 처리(Parallel Operation): 멀티 코어 CPU 환경에서 전체 요소를 분할해서 각각의 코어가 병력적으로 처리하는 것
- 작업 처리 시간을 줄이는 것에 목적이 있으며, 자바는 요소 병렬 처리를 위해 병렬 스트림을 제공한다.

1. 동시성과 병렬성

- 멀티 스레드는 동시성(concurrency) 또는 병렬성(parallelism)으로 실행된다.
- 동시성 : 멀티 작업을 위해 멀티 스레드가 하나의 코어에서 번갈아가며 실행되는 것을 말하며, 한 시점에 단 하나의 작업만 실행한다.
- 병렬성 : 멀티 작업을 위해 멀티 코어를 각각 이용해서 병렬로 실행하는 것을 말하며, 한 시점에 여러 개의 작업을 병렬로 실행하기 때문에, 동시성보다 좋은 성능을 낸다.

  ![](https://velog.velcdn.com/images/szszszsz/post/c138a98f-fc73-4d88-8356-9e5fa7a98be9/image.png)

- 병렬성은 데이터 병렬성(data parallellism)과 작업 병렬성(task parallellism)으로 구분할 수 있다.
  - 데이터 병렬성 : 전체 데이터를 분할해서 서브 데이터셋으로 만들고 이 서브 데이터셋들을 병렬 처리해서 작업을 빨리 끝내는 것을 말한다. 자바 병렬 스트림은 데이터 병렬성을 구현한 것이다.
  - 작업 병렬성 : 서로 다른 작업을 병렬 처리하는 것을 말한다. 작업 병렬성의 대표적인 예는 서버 프로그램이며, 서버는 각각의 클라이언트에서 요청한 내용을 개별 스레드에서 병렬로 처리한다.

2. 포크조인 프레임워크

- 자바 병렬 스트림은 요소들을 병렬 처리하기 위해 포크조인 프레임워크(ForkJoin Framework)를 사용한다.
- 포크조인 프레임워크 : 포크 단계에서 전체 요소들을 서브 요소셋으로 분할하고, 각각의 서브 요소셋을 멀티 코어에서 병렬로 처리하며, 조인 단계에서는 서브 결과를 결합해서 최종 결과를 만들어낸다.

  ![](https://velog.velcdn.com/images/szszszsz/post/b8956f33-b7ce-401f-be1a-c63c890323e4/image.png)

- 병렬 처리 스트림은 포크 단계에서 요소를 순서대로 분할하지 않고, 내부적으로 요소들을 나누는 알고리즘이 있기 때문에 개발자는 신경 쓸 필요가 없다.
- 포크조인 프레임워크는 병렬 처리를 위해 스레드풀을 사용하며, 각각의 코어에서 서브 요소셋을 처리하는 것은 작업 스레드가 해야 하므로 스레드 관리가 필요하다.
- 포크조인 프레임워크는 ExecutorService의 구현 객체인 ForkJoinPool을 사용해서 작업 스레드를 관리한다.

  ![](https://velog.velcdn.com/images/szszszsz/post/7f02e34a-6107-473d-82ea-af4cc9a7a069/image.png)

3. 병렬 스트림 사용

- 자바 병렬 스트림을 이용할 경우에는 백그라운드에서 포크조인 프레임워크가 사용되기 때문에 개발자는 매우 쉽게 병렬 처리를 할 수 있다.
- 병렬 스트림은 다음 두 가지 메소드로 얻을 수 있다.

  ![](https://velog.velcdn.com/images/szszszsz/post/d5ad29bf-f71f-4d87-b26e-7cd36716016e/image.png)

- parallelStream() 메소드는 컬렉션(List, Set)으로부터 병렬 스트림을 바로 리턴하며, parallel() 메소드는 기존 스트림을 병렬 처리 스트림으로 변환한다.
- ParallelExample 예제

  ```java
  package javaChap17.example13;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Random;

  public class ParallelExample {
    public static void main(String[] args) {
      Random random = new Random();
      List<Integer> scores = new ArrayList<Integer>();
      for (int i = 0; i < 100000000; i++) {
        scores.add(random.nextInt(101));
      }

      double avg = 0.0;
      long startTime = 0;
      long endTime = 0;
      long time = 0;
      startTime = System.nanoTime();
      avg = scores.stream().mapToInt(n -> n.intValue()).average().getAsDouble();
      endTime = System.nanoTime();
      time = endTime - startTime;
      System.out.println("기본스트림");
      System.out.println("걸린시간 : " + time + "ns");
      System.out.println("평균 : " + avg);
      System.out.println();
      startTime = System.nanoTime();
      avg = scores.parallelStream().mapToInt(n -> n.intValue()).average().getAsDouble();
      endTime = System.nanoTime();
      time = endTime - startTime;
      System.out.println("parallelStream()병렬스트림");
      System.out.println("걸린시간 : " + time + "ns");
      System.out.println("평균 : " + avg);
      System.out.println();
      startTime = System.nanoTime();
      scores.stream().parallel().mapToInt(n -> n.intValue()).average().getAsDouble();
      endTime = System.nanoTime();
      time = endTime - startTime;
      System.out.println("parallel()병렬스트림");
      System.out.println("걸린시간 : " + time + "ns");
      System.out.println("평균 : " + avg);
    }
  }
  ```

4. 병렬 처리 성능

- 스트림 병렬 처리가 스트림 순차 처리보다 항상 실행 성능이 좋다고 판단해서는 안되며, 그 전에 먼저 병렬 처리에 영향을 미치는 다음 3가지 요인을 잘 살펴보아야 한다.

- **요소의 수와 요소당 처리 시간**
  - 컬렉션에 전체 요소의 수가 적고 요소당 처리 시간이 짧으면 일반 스트림이 병렬 스트림보다 빠를 수 있다. 병렬 처리는 포크 및 조인 단계가 있고, 스레드 풀을 생성하는 추가적인 비용이 발생하기 때문이다.
- **스트림 소스의 종류**
  - ArrayList와 배열은 인덱스로 요소를 관리하기 때문에 포크 단계에서 요소를 쉽게 분리할 수 있어 병렬 처리 시간이 절약된다. 반면에 HashSet, TreeSet은 요소 분리가 쉽지 않고, LinkedList 역시 링크를 따라가야 하므로 요소분리가 쉽지 않아 상대적으로 병렬 처리가 늦다.
- **코어(Core)의 수**
  - CPU 코어의 수가 많으면 많을수록 병렬 스트림의 성능은 좋아진다. 하지만 코어의 수가 적을 경우에는 일반 스트림이 더 빠를 수 있다. 병렬 스트림은 스레드 수가 증가하여 동시성이 많이 일어나므로 오히려 느려진다.
