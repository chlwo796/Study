2023년 2월 15일 수요일

---

## chap.15 collection data structure

### 1. 컬렉션 프레임워크

- 자바는 널리 알려져 있는 자료구조(Data Structure)를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 관련된 인터페이스와 클래스들을 `java.util` 패키지에 포함시켜 놓았으며 총칭해서 컬렉션 프레임워크라고 부른다.
- Collection의 주요 인터페이스
  - List : 순서를 유지하고 저장, 중복저장 가능
    - 구현클래스 : `ArrayList`,`Vector`,`LinkedList`
  - Set : 순서를 유지하지 않고 저장, 중복저장 x
    - 구현클래스 : `HashSet`, `TreeSet`
  - Map : 키와 값으로 구성된 엔트리 저장, 키는 중복 저장 안됨
    - 구현클래스 : `HashMap`,`Hashtable`,`TreeMap`,`Properties`

### 2. List 컬렉션

- List 컬렉션은 객체를 인덱스로 관리하기 때문에, 객체를 저장하면 인덱스가 부여되고 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공한다.
- `ArrayList`, `Vector`, `LinkedList` 등이 있는데, List 컬렉션에서는 인덱스로 객체들이 관리되기 때문에, 인덱스를 매가값으로 갖는 메소드들이 많다.
- 객체 추가

  - `boolean add(E e)` : 주어진 객체를 맨 끝에 추가
  - `void add(int index, E element)` : 주어진 인덱스에 객체를 추가
  - `set(int index, E element)` : 주어진 인덱스의 객체를 새로운 객체로 바꿈

- 객체 검색

  - `boolean contains(Object o)` : 주어진 객체가 저장되어 있는지 여부
  - `E get(int index)` : 주어진 인덱스에 저장된 객체를 리턴
  - `isEmpty()` : 컬렉션이 비어 있는지 조사
  - `int size()` : 저장되어 있는 전체 객체 수를 리턴

- 객체 삭제
  - `void clear()` : 저장된 모든 객체를 삭제
  - `E remove(int index)` : 주어진 인덱스에 저장된 객체를 삭제
  - `boolean remove(Object o)` : 주어진 객체를 삭제

1. ArrayList

- ArrayList는 List 컬렉션에서 가장 많이 사용하는 컬렉션이며, 객체를 추가하면 내부 배열에 객체가 저장된다.
- 일반 배열과는 다르게 크기 제한 없이 객체를 추가할 수 있다.
- 객체를 추가하면 인덱스 0번부터 차례대로 저장되고, 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨지며, 객체를 삽입하더라도 해당 인덱스부터 마지막 인덱스까지 1씩 밀려난다.
- **데이터(객체)의 삭제와 삽입이 빈번하게 일어나는 프로그램의 경우, ArrayList를 사용하는 것은 바람직하지 않다.**
- javaChap15.example01.Board

  ```java
  package javaChap15.example01;

  public class Board {
    private String subject;
    private String content;
    private String writer;

    public Board(String subject, String content, String writer) {
      super();
      this.subject = subject;
      this.content = content;
      this.writer = writer;
    }

    public String getSubject() {
      return subject;
    }

    public void setSubject(String subject) {
      this.subject = subject;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getWriter() {
      return writer;
    }

    public void setWriter(String writer) {
      this.writer = writer;
    }

  }
  ```

- javaChap15.example01.ArrayListExample

  ```java
  package javaChap15.example01;

  import java.util.ArrayList;
  import java.util.List;

  public class ArrayListExample {

    public static void main(String[] args) {
      // TODO Auto-generated method stub
      List<Board> list = new ArrayList<Board>();

      list.add(new Board("제목1", "내용1", "글쓴이1"));
      list.add(new Board("제목2", "내용2", "글쓴이2"));
      list.add(new Board("제목3", "내용3", "글쓴이3"));
      list.add(new Board("제목4", "내용4", "글쓴이3"));
      list.add(new Board("제목5", "내용5", "글쓴이4"));
      list.add(new Board("제목6", "내용6", "글쓴이4"));

      System.out.println("게시글의 수 : " + list.size());
      System.out.println();

      System.out.println(list.get(3).getSubject() + "\t" + list.get(3).getContent() + "\t" + list.get(3).getWriter());
      System.out.println();

      for(int i = 0;i<list.size();i++) {
        System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
      }
      // 두번 제거 가능한 이유는 index2 제거 후 index3이었던 데이터가 2로 가기 때문. ArrayList의 특성
      list.remove(2);
      list.remove(2);

      System.out.println();
      for(int i = 0;i<list.size();i++) {
        System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
      }
      System.out.println();
      for(Board b : list) {
        System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
      }
    }
  }
  ```

2. Vector

- Vector는 ArrayList와 동일한 내부 구조를 가지고 있지만, 동기화된 메소드로 구성되어 있어서 멀티 스레드가 동시에 `Vector()` 메소드를 실행할 수 없다. -> **멀티 스레드 환경에서 안전하게 객체를 추가 또는 삭제할 수 있다.**
- `Thread thread = new Thread(){};` : 작업스레드 생성
- javaChap15.example01.VectorExample

  ```java
  package javaChap15.example01;

  import java.util.List;
  import java.util.Vector;

  public class VectorExample {
    public static void main(String[] args) {
      List<Board> list = new Vector<Board>();

      Thread threadA = new Thread() {
        @Override
        public void run() {
          for (int i = 1; i <= 1000; i++) {
            list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
          }
        }
      };
      Thread threadB = new Thread() {
        @Override
        public void run() {
          for (int i = 1001; i <= 2000; i++) {
            list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
          }
        }
      };
      threadA.start();  // 작업스레드 실행
      threadB.start();

      try {
        threadA.join(); // .join() = 스레드 종료될 떄까지 기다림.
        threadB.join();
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println("총 객체 수 : " + list.size());

    }
  }
  ```

- `Vector<>()`를 `ArrayList<>()`로 변경하면 2000이 나오지 않거나 에러가 발생할 수 있다.
  - **ArrayList는 두 스레드가 동시에 add()메소드를 호출할 수 있기 때문에 경합이 발생해 결국 하나만 저장되기 때문이다.**

3. LinkedList

- LinkedList는 ArrayList와 사용 방법은 동일하지만, ArrayList는 내부 배열에 객체를 저장하고, LinkedList는 **인접 객체를 체인처럼 연결해서 관리한다.**
- LinkedList는 특정 위치에서 객체를 삽입하거나 삭제하면 바로 앞뒤 링크만 변경하면 되므로 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList보다 좋은 성능을 발휘한다.
- ArrayList의 같은 인덱스에 새로운 객체가 계속 추가되면, 기존 객체의 인덱스를 한칸씩 전부 뒤로 밀어 자료를 저장하기 때문에 LinkedList와 속도차이가 많이 난다.
- javaChap15.example01.LinkedListExample

  ```java
  package javaChap15.example01;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;

  public class LinkedListExample {
    public static void main(String[] args) {
      List<String> list1 = new ArrayList<String>();
      List<String> list2 = new LinkedList<String>();

      long startTime;
      long endTime;

      startTime = System.nanoTime();
      for (int i = 0; i < 10000; i++) {
        list1.add(0, String.valueOf(i));
      }
      endTime = System.nanoTime();
      System.out.println("ArrayList 걸린 시간 : " + (endTime - startTime) + " ns");

      startTime = System.nanoTime();
      for (int i = 0; i < 10000; i++) {
        list2.add(0, String.valueOf(i));
      }
      endTime = System.nanoTime();
      System.out.println("LinkedList 걸린 시간 : " + (endTime - startTime) + " ns");
    }
  }
  ```

### 3. Set 컬렉션

- List 컬렉션은 저장순서를 유지하지만, Set 컬렉션은 저장 순서가 유지되지 않는다.
- 객체를 중복해서 저장할 수 없고, 하나의 null만 저장한다.
- Set 컬렉션에는 HashSet, LinkedHashSet, TreeSet 등이 있으며, 인덱스로 관리하지 않기 때문에 인덱스를 매개값으로 갖는 메소드가 없다.
- 객체추가
  - `boolean add(E e)` : 주어진 객체를 성공적으로 저장하면 true를 리턴하고, 중복 객체면 false를 리턴
- 객체검색

  - `boolean contains(Object o)` : 주어진 객체가 저장되어 있는지 여부
  - `isEmpty()` : 컬렉션이 비어 있는지 조사
  - `Iterator<E> iterator()` : 저장된 객체를 한번씩 가져오는 반복자 리턴
  - `int size()` : 저장되어 있는 전체 객체 수 리턴

- 객체 삭제
  - `void clear()` : 저장된 모든 객체를 삭제
  - `boolean remove(Object o)` : 주어진 객체를 삭제

1. HashSet

- HashSet은 동일한 객체는 중복 저장하지 않는다.
- 다른 객체라도 hashCode() 메소드의 리턴값이 같고, equals() 메소드가 true를 리턴하면 동일한 객체라고 판단하고 중복 저장하지 않는다.
- javaChap15.example02.HashSetExample

  ```java
  package javaChap15.example02;

  import java.util.HashSet;
  import java.util.Set;

  public class HashSetExample {
    public static void main(String[] args) {
      Set<String> set = new HashSet<String>();

      set.add("Java1");
      set.add("Java2");
      set.add("Java3");
      set.add("Java1");
      set.add("Java5");

      System.out.println("데이터 수 : " + set.size());
    }
  }
  ```

- 객체타입으로 HashSet 데이터를 선언하였다면, Object의 `hashCode()`와 `equals()`를 오버라이딩함으로서 상황에 맞게 데이터 중복저장 조건을 설정할 수 있다.
- javaChap15.example02.Member

  ```java
  package javaChap15.example02;

  public class Member {
    private String name;
    private int age;

    public Member(String name, int age) {
      super();
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public int hashCode() {
      return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
      if(obj instanceof Member) {
        Member member = (Member) obj;
        return member.name.equals(name) && member.age == age;
      }
      return false;
    }
  }
  ```

- javaChap15.example02.HashSetExample

  ```java
  package javaChap15.example02;

  import java.util.HashSet;
  import java.util.Set;

  public class HashSetExample {
    public static void main(String[] args) {
      Set<String> set = new HashSet<String>();

      set.add("Java1");
      set.add("Java2");
      set.add("Java3");
      set.add("Java1");
      set.add("Java5");

      System.out.println("데이터 수 : " + set.size());

      Set<Member> set1 = new HashSet<Member>();

      set1.add(new Member("홍길동", 30));
      set1.add(new Member("홍길동", 30));

      System.out.println("데이터 수 : " + set1.size());
    }
  }
  ```

- Set 컬렉션은 인덱스로 객체를 검색해서 가져오는 메소드가 없으므로, `향상for문`과 `iterator()` 메소드로 반복자를 얻어 객체를 하나씩 가져온다.

  - 향상된 for 문

    ```java
    for(E e : setName) {
    }
    ```

  - iterator()

    ```java
    while(iterator.hasNext()){
      E e = iterator.next();
    }
    ```

- iterator는 Set 컬렉션의 객체를 가져오거나 제거하기 위해 다음 메소드를 제공한다.
  - `boolean hasNext()` : 가져올 객체가 있으면 true or false
  - `E next()` : 컬렉션에서 하나의 객체를 가져온다.
  - `void remove()` : next()로 가져온 객체를 Set 컬렉션에서 제거한다.
- javaChap15.example03.HashSetExample

  ```java
  package javaChap15.example03;

  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.Set;

  public class HashSetExample {
    public static void main(String[] args) {
      Set<String> set1 = new HashSet<String>();

      set1.add("java1");
      set1.add("java2");
      set1.add("java2");
      set1.add("java3");
      set1.add("java4");
      set1.add("java4");
      set1.add("java5");

      Iterator<String> iterator = set1.iterator();

      while (iterator.hasNext()) {
        String str = iterator.next();
        System.out.println(str);
        if (str.equals("java1")) {
          iterator.remove();
        }
      }
      set1.remove("java3");
      System.out.println();
      for (String str : set1) {
        System.out.println(str);
      }

    }
  }
  ```
