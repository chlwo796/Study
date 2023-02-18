2023년 2월 18일 토요일

---

## chap.15 excercises review

### 1. 컬렉션 프레임워크

- List 컬렉션은 인덱스로 객체를 관리하며 중복 저장을 허용한다.
- Set 컬렉션은 순서를 유지하지 않으며 중복 저장을 허용하지 않는다.
- Map 컬렉션은 키와 값으로 구성된 Map.Entry를 저장한다.
- Stack은 FIFO(선입선출) 자료구조를 구현한 클래스이다. (x) -> LILO(후입선출)의 자료구조이다.

### 2. List 컬렉션

- 대표적인 구현 클래스로는 ArrayList, Vector, LinkedList가 있다.
- 멀티 스레드 환경에서는 ArrayList 보다는 Vector가 스레드에 안전하다.
- ArrayList에서 객체를 삭제하면 삭제된 위치는 비어 있게 된다. (x) 인덱스를 전부 삭제한 인덱스만큼 다시 옮겨준다.
- 중간 위치에 객체를 빈번히 삽입하거나 제거할 경우 LinkedList를 사용하는 것이 좋다.

### 3. Set 컬렉션

- 대표적인 구현 클래스로는 HashSet, LinkedHashSet, TreeSet 이 있다.
- Set 컬렉션에서 객체를 하나씩 꺼내오고 싶다면 Iterator를 이용한다.
- HashSet은 hashCode()와 equals() 메소드를 이용해서 중복된 객체를 판별한다.
- Set 컬렉션에는 null을 저장할 수 없다. (x) -> 중복허용을 하지 않기 때문에, 하나의 null만 저장할 수 있다.

### 4. Map 컬렉션

- 대표적인 구현 클래스로는 HashMap, Hashtable, TreeMap, Properties가 있다.
- HashMap과 Hashtable은 hashCode()와 equals() 메소드를 이용해서 중복 키를 판별한다.
- 멀티 스레드 환경에서는 Hashtable보다는 HashMap이 스레드에 안전하다. (x) -> Hashtable이 멀티 스레드 환경에서 안전하다.
- Properties는 키와 값이 모두 String 타입이다.

### 5. 단일(싱글) 스레드 환경에서 Board객체를 저장 순서에 맞게 읽고 싶은 경우, 코드 작성

`List<Board> list = new ArrayList<Board>();`

### 6. 단일(싱글) 스레드 환경에서 학번(String)을 키로, 점수(Integer)를 값으로 저장하는 경우, 코드 작성

`Map<String, Integer> map = new HashMap<String, Integer>();`

### 7. BoardDao 클래스와 getBoardList() 메소드 작성

- Board 클래스

  ```java
  package javaChap15.exercise07;

  public class Board {
      private String title;
      private String content;

      public Board(String title, String content) {
          super();
          this.title = title;
          this.content = content;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public String getContent() {
          return content;
      }

      public void setContent(String content) {
          this.content = content;
      }
  }
  ```

- ListExample 클래스

  ```java
  package javaChap15.exercise07;

  import java.util.List;

  public class ListExample {
      public static void main(String[] args) {
          BoardDao dao = new BoardDao();
          List<Board> list = dao.getBoardList();
          for(Board board : list) {
              System.out.println(board.getTitle() + "-" + board.getContent());
          }
      }
  }
  ```

- BoardDao 클래스

  ```java
  package javaChap15.exercise07;

  import java.util.ArrayList;
  import java.util.List;

  public class BoardDao {
      List<Board> daoList = new ArrayList<Board>();

      public List<Board> getBoardList() {
          daoList.add(new Board("제목2", "내용2"));
          daoList.add(new Board("제목3", "내용3"));
          return daoList;
      }

  }
  ```

### 8. 객체를 참조하는 HashSet 의 사용자 정의 중복 설정(학번)

- Stdent 클래스

  ```java
  package javaChap15.exercise08;

  public class Student {
      public int studentNum;
      public String name;

      public Student(int studentNum, String name) {
          super();
          this.studentNum = studentNum;
          this.name = name;
      }

      @Override
      public boolean equals(Object obj) {
          if (obj instanceof Student) {
              Student student = (Student) obj;
              return this.studentNum == student.studentNum;
          }
          return false;
      }

      @Override
      public int hashCode() {
          // TODO Auto-generated method stub
          return studentNum;
      }
  }
  ```

- HashSetExample 클래스

  ```java
  package javaChap15.exercise08;

  import java.util.HashSet;
  import java.util.Set;

  public class HashSetExample {
      public static void main(String[] args) {
          Set<Student> set = new HashSet<Student>();

          set.add(new Student(1,"홍길동1"));
          set.add(new Student(2,"홍길동2"));
          set.add(new Student(1,"홍길동3"));

          System.out.println(set.size());
          for(Student s : set) {
              System.out.println(s.studentNum + ":" + s.name);
          }

      }
  }
  ```

### 9. HashMap으로 평균 점수, 최고 점수, 최고 점수를 받은 아이디를 출력

- MapExample 클래스

  ```java
  package javaChap15.exercise09;

  import java.util.HashMap;
  import java.util.Map;
  import java.util.Set;
  import java.util.TreeMap;

  public class MapExample {
      public static void main(String[] args) {
          Map<String, Integer> map = new HashMap<String, Integer>();

          map.put("blue", 96);
          map.put("hong", 86);
          map.put("white", 92);

          String name = null;
          int maxScore = 0;
          int totalScore = 0;

          System.out.println("기본 map");
          Set<String> keySet1 = map.keySet();
          for (String key : keySet1) {
              System.out.println(key + " " + map.get(key));
              if (maxScore < map.get(key)) {
                  name = key;
                  maxScore = map.get(key);
              }
              totalScore += map.get(key);
          }
          System.out.println();
          System.out.println("9번 출력결과");
          System.out.println(name);
          System.out.println(maxScore);
          System.out.println(maxScore / map.size());
          System.out.println();
          TreeMap<String, Integer> treeMap = new TreeMap<>();
          treeMap.putAll(map);
          System.out.println("treeMap 변환");
          Set<String> keySet2 = treeMap.keySet();
          for (String key : keySet2) {
              System.out.println(key + " " + treeMap.get(key));
          }
          System.out.println();
      }
  }
  ```

### 10. Student 객체의 score 기준으로 자동 정렬 구현

- Student 클래스

  ```java
  package javaChap15.exercise10;

  public class Student implements Comparable<Student>{
      public String id;
      public int score;
      public Student(String id, int score) {
          super();
          this.id = id;
          this.score = score;
      }
  @Override
      public int compareTo(Student o) {
          if(this.score>o.score) {
              return 1;
          }else if (this.score==o.score) {
              return 0;
          }else return -1;
      }
  }
  ```

- TreeSetExample 클래스

  ```java
  package javaChap15.exercise10;

  import java.util.TreeSet;

  public class TreeSetExample {
      public static void main(String[] args) {
          TreeSet<Student> treeSet = new TreeSet<Student>();
          treeSet.add(new Student("blue", 96));
          treeSet.add(new Student("hong", 86));
          treeSet.add(new Student("white", 92));

          Student student = treeSet.last();
          System.out.println("최고점수 : " + student.score);
          System.out.println("최고 점수를 받은 아이디 : " + student.id);
      }
  }
  ```

### 11. LIFO와 FIFO 컬렉션

- Stack은 LIFO이고 Queue는 FIFO 구조를 가지고 있다.
- Stack에 넣는 행위는 push 이고, 빼는 행위는 pop이다.
- Queue에 넣는 행위는 offer이고, 빼는 행위는 poll이다.
- Stack과 Queue는 자바에서 클래스 타입이다. (x) -> Stack = 클래스, Queue = 인터페이스

### 12. 동기화된 컬렉션

- 멀티스레드 환경에서 안전하게 사용할 수 있는 컬렉션이다.
- 동기화된 컬렉션의 메소드는 synchronized 처리가 되어 있다.
- Vector와 HashMap은 동기화된 컬렉션이다. (x) -> Hashtable이 동기화된 컬렉션이다.
- Collections의 synchronizedMap() 메소드는 동기화된 Map을 리턴한다.

### 13. 수정할 수 없는 List 컬렉션

- 요소를 추가, 삭제할 수 없는 List 컬렉션을 말한다.
- List의 of() 메소드는 수정할 수 없는 컬렉션을 생성한다.
- List의 copyOf() 메소드는 기존 컬렉션을 복사한 수정할 수 없는 컬렉션을 생성한다.
- Array.asList() 메소드는 배열로부터 수정할 수 있는 List 컬렉션을 생성한다. (x) -> 배열로부터 수정할 수 없는 List 컬렉션을 생성한다.
