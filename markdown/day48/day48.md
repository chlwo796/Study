2023년 3월 10일 금요일

---

## day48

### 1. java

- 중간처리
- FilterEx01 실습

  ```java
  package javaHigh11.example03;

  import java.util.ArrayList;
  import java.util.List;

  public class FilterEx01 {
      public static void main(String[] args) {
          List<String> list = new ArrayList<String>();
          list.add("홍길동");
          list.add("신용권");
          list.add("신민철");
          list.add("신용권");
          list.add("김자바");
          // 중복제거
          list.stream().distinct().forEach(name -> System.out.println(name));
          System.out.println();
          // filter 메소드의 matches 메소드
          list.stream().filter(n -> n.matches("김자바")).forEach(n -> System.out.println(n));
          System.out.println();
          list.stream().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
          System.out.println();
          list.stream().distinct().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
      }
  }
  ```

- FilterEx02 실습

  ```java
  package javaHigh11.example03;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.stream.IntStream;

  public class FilterEx02 {
      public static void main(String[] args) {
          // 반복문 이용
          List<Integer> list = new ArrayList<Integer>();
          for (int i = 1; i <= 100; i++) {
              list.add(i);
          }
          list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
          // IntStream 클래스의 메소드 이용, 짝수 출력
          IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

      }
  }
  ```

- FilterEx03 실습

```java
package javaHigh11.example03;

import java.util.Arrays;
import java.util.List;

public class FilterEx03 {
	public static void main(String[] args) {
		// 객체를 참조하는 리스트의 필터링 후 출력
		Arrays.asList(new Student("신길동", 10), new Student("홍길동2", 15), new Student("김길동", 30),
				new Student("신길동", 20), new Student("홍길동5", 18)).stream().filter(s -> s.getAge() < 30)
				.forEach(s -> System.out.println(s.getName() + "\t" + s.getAge()));
		System.out.println();
		List<Student> list = Arrays.asList(new Student("신길동", 10), new Student("홍길동2", 15), new Student("김길동", 30),
				new Student("신길동", 20), new Student("홍길동5", 18));
		// 이름을 가져와 중복 제거
		list.stream().map(s->s.getName()).distinct().forEach(s->System.out.println(s));
	}
}
```

- FlatMappingEx01 실습

  ```java
  package javaHigh11.example04;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class FlatMappingEx01 {
      public static void main(String[] args) {
          List<String> list = new ArrayList<String>();
          list.add("this is java");
          list.add("i am a best developer");

          list.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(s -> System.out.println(s));
          System.out.println();
          List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
          list2.stream().flatMapToInt(n -> {
              String[] strArray = n.split(",");
              int[] intArray = new int[strArray.length];
              for (int i = 0; i < strArray.length; i++) {
                  // trim() = 공백을 버린다!!
                  intArray[i] = Integer.parseInt(strArray[i].trim());
              }
              return Arrays.stream(intArray);
          }).forEach(n -> System.out.println(n));
          System.out.println();
          list2.stream().flatMap(s -> Arrays.stream(s.split(", "))).mapToInt(s -> Integer.parseInt(s))
                  .forEach(s -> System.out.println(s));
      }
  }
  ```

- SortingEx 실습

  ```java
  package javaHigh11.example05;

  import java.util.Comparator;

  public class PersonComporator implements Comparator<Person> {
      @Override
      public int compare(Person o1, Person o2) {
          // TODO Auto-generated method stub
          return Double.compare(o2.getPay(), o1.getPay());
      }
  }
  ```

  ```java
  package javaHigh11.example05;

  import java.util.Arrays;
  import java.util.List;

  public class SortingEx {
      public static void main(String[] args) {
          List<Student> list = Arrays.asList(new Student("홍길동1", 26), new Student("홍길동2", 21), new Student("홍길동3", 25),
                  new Student("홍길동4", 20));
          // 정렬
          list.stream().sorted().forEach(s -> System.out.println(s.getName() + "\t" + s.getScore()));
          System.out.println();

          List<Person> personList = Arrays.asList(new Person("F", false, 2800.10), new Person("E", true, 3900.90),
                  new Person("D", true, 3900.99), new Person("B", false, 2340.80), new Person("C", false, 1200.90),
                  new Person("A", true, 998.90));
          // 급여역순 출력
          personList.stream().sorted(new PersonComporator())
                  .forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
          System.out.println();
          // 남자출력, 급여역순
          personList.stream().filter(s -> s.isGender()).sorted(new PersonComporator())
                  .forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
          System.out.println();

          personList.stream().filter(s -> s.isGender()).sorted(new PersonComporator())
          .forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
      }
  }
  ```

---

### 2. js

- console창
- undefined : 값이 지정되지 않았을 때의 상태, 선언만 하고 값을 할당하지 않은 상태의 변수
- null : 값이 유효하지 않을 때의 상태
- 콘솔사용이유
- `===` : 값과 자료형까지 동일하면 true를 리턴
- `==` : 값이 동일하면 true
- `!=` : 값이 같지 않으면 true
- `!==` : 값과 자료형이 같지 않으면 true

---

### 3. memo
