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
