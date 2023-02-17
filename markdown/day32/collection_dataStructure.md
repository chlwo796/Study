2023년 2월 16일 목요일

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

### 4. Map 컬렉션

- Map 컬렉션은 Key(키)와 Value(값)으로 구성된 Entry(엔트리)객체를 저장한다.
- Key와 Value는 모두 객체이며 Key는 중복저장할 수 없다.
- Map 컬렉션에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 있으며, Key로 객체들을 관리하기 때문에 Key를 매개값으로 갖는 메소드가 많다.
- 객체 추가
  - `V put(K key, V value)` : 주어진 키와 값을 추가, 저장이 되면 값을 리턴
- 객체 검색
  - `boolean containsKey(Object key)` : 주어진 키가 있는지 여부
  - `boolean containsValue(Object value)` : 주어진 값이 있는지 여부
  - `Set<Map.Entry<k,V>> entrySet()` : 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
  - `V get(Object key)` : 주어진 키의 값을 리턴
  - `boolean isEmpty()` : 컬렉션이 비어있는지 여부
  - `Set<K> keySet()` : 모든 key를 Set 객체에 담아서 리턴
  - `int size()` : 저장된 키의 총 수를 리턴
  - `Collection<V> values()` : 저장된 모든 값 Collection에 담아서 리턴
- 객체 삭제
  - `void clear()` : 모든 Map.Entry(key, value)를 삭제
  - `V remove(Object o)` : 주어진 key와 일치하는 Map.Entry 삭제, 삭제가 되면 값을 리턴

1. HashMap

- HashMap은 키로 사용할 객체가 `hashCode()` 메소드의 리턴값이 같고, `equals()` 메소드가 true를 리턴할 경우, 동일 키로 보고 중복 저장을 허용하지 않는다.
- HashMapExample 예제

  ```java
  package javaChap15.example04;

  import java.util.HashMap;
  import java.util.Iterator;
  import java.util.Map;
  import java.util.Map.Entry;
  import java.util.Set;

  public class HashMapExample {
    public static void main(String[] args) {
      Map<String, Integer> map = new HashMap<String, Integer>();

      map.put("홍길동0", 30);
      map.put("홍길동1", 90);
      map.put("홍길동2", 30);
      map.put("홍길동3", 30);
      map.put("홍길동2", 40);
      // 동일한 key가 있을경우 마지막 value만 저장
      System.out.println(map.size());
      // key 지정하여 value 출력
      System.out.println(map.get("홍길동2"));

      // keySet()으로 반복자 선언하여 전체출력(key->value)
      Set<String> keySet = map.keySet();

      Iterator<String> iterator = keySet.iterator();

      while(iterator.hasNext()) {
        String key = iterator.next();
        System.out.println(key + " " + map.get(key));
      }

      // entrySet()으로 entry 전체출력(entry = (key,value))
      Set<Entry<String, Integer>> entrySet = map.entrySet();

      Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();

      while(iterator1.hasNext()) {
        System.out.println(iterator1.next());
      }
      // key로 map에서 제거
      map.remove("홍길동1");
      System.out.println(map.size());
      // 반복자 재호출 후 출력
      iterator1 = entrySet.iterator();
      while(iterator1.hasNext()) {
        System.out.println(iterator1.next());
      }
    }
  }
  ```

2. Hashtable

- Hashtable은 HashMap과 동일한 내부 구조를 가지고 있지만, 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Hashtable의 메소드들을 실행할 수 없다.
- 멀티스레드 환경에서도 안전하게 객체를 추가, 삭제할 수 있다.
- HashtableExample 예제

  ```java
  package javaChap15.example04;

  import java.util.Hashtable;
  import java.util.Map;

  public class HashtableExample {
    public static void main(String[] args) {
      // Hashtable -> HashMap 으로 변경 후 실행하면 다른 출력결과를 확인할 수 있다.
      Map<String, Integer> map1 = new Hashtable<String, Integer>();

      Thread threadA = new Thread() {
        @Override
        public void run() {
          for(int i = 1;i<=1000;i++) {
            map1.put(String.valueOf(i), i);
          }
        }
      };
      Thread threadB = new Thread() {
        @Override
        public void run() {
          for(int i = 1001;i<=2000;i++) {
            map1.put(String.valueOf(i), i);
          }
        }
      };

      threadA.start();
      threadB.start();

      try {
        threadA.join();
        threadB.join();
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println(map1.size());
    }
  }
  ```

- HashMap은 두 스레드가 동시에 put()메소드를 호출할 수 있어서 경합이 발생하고, 결국은 하나만 저장된다.
- Hashtable의 put()은 동기화 메소드이므로 한번에 하나의 스레드만 실행할 수 있어 경합이 발생하지 않는다.

3. Properties

- Properties는 Hashtable의 자식 클래스이기 때문에 Hashtable의 특징을 그대로 가지고 있으며, key와 value를 String 타입으로 제한한 컬렉션이다.
- Properties는 주로 확장자가 `.properties`인 프로퍼티 파일을 읽을 때 사용하며, 프로퍼티 파일은 key와 value가 `=` 기호로 연결되어 있는 텍스트 파일이다.
- 일반적으로 프로퍼티 파일은 클래스파일(`.class`)들과 함께 저장되므로, 클래스 파일을 기준으로 상대 경로를 이용해서 읽는 것이 편리하다.
- database.properties 파일을 클래스 패키지 속에 생성
  ![](properties%EC%83%9D%EC%84%B1.png)
- Properties 객체를 생성하고, `.load()` 메소드로 프로퍼티 파일의 내용을 메모리로 로드한다.
- Class 객체의 `getResourceAsStream()` 메소드는 주어진 상대 경로의 리소스 파일을 읽는 InputStream을 리턴한다.
- PropertiesExample 예제

```java
package javaChap15.example04;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
      // 이클립스에서는 .load() 와 같은 메소드처럼 외부파일을 가져올 경우 반드시 예외처리를 해주도록 되어있다.
			properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(properties.getProperty("driver"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("admin"));
	}
}
```

### 5. 검색 기능을 강화시킨 컬렉션

- 컬렉션 프레임워크는 검색기능을 강화시킨 TreeSet과 TreeMap을 제공한다.

1. TreeSet

- TreeSet은 이진트리(Binary Tree)를 기반으로 한 Set 컬렉션이며, 이진 트리는 여러개의 노드(Node)가 트리 형태로 연결된 구조로, 루트 노드(Root Node)라고 불리는 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.
- Set 타입 변수에 대입해도 되지만 TreeSet 타입으로 대입한 이유는 검색 관련 메소드가 TreeSet에만 정의되어 있기 때문이다.
- TreeSet Method
  - `E first()` : 제일 낮은 객체 리턴
  - `E last()` : 제일 높은 객체 리턴
  - `E lower(E e)` : 주어진 객체보다 바로 아래 객체를 리턴
  - `E higher(E e)` : 주어진 객체보다 바로 위 객체를 리턴
  - `E floor(E e)` : 주어진 객체와 동등한 객체가 있으면 리턴, 없다면 바로 아래 객체를 리턴
  - `E ceiling(E e)` : 주어진 객체와 동등한 객체가 있으면 리턴, 없다면 바로 위 객체를 리턴
  - `Iterator<E> iterator()` : 오름차순 반복자 리턴
  - `Iterator<E> descendingIterator()` : 내림차순 반복자 리턴
  - `NavigableSet<E> descendingSet()` : 내림차순으로 정렬된 NavigableSet 리턴
  - `NavigableSet<E> headSet(E toElement, boolean inclusive)` : 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 객체 포함여부 = true or false
  - `NavigableSet<E> tailSet(E toElement, boolean inclusive)` : 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 객체 포함여부 = true or false
  - `NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toinclusive)` : 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴, 시작과 끝 객체 포함여부 = true or false
- TreeSetExample 예제

  ```java
  package javaChap15.example05;

  import java.util.Iterator;
  import java.util.NavigableSet;
  import java.util.TreeSet;

  public class TreeSetExample {

    public static void main(String[] args) {
      TreeSet<Integer> treeSet = new TreeSet<Integer>();

      treeSet.add(87);
      treeSet.add(98);
      treeSet.add(77);
      treeSet.add(39);
      treeSet.add(90);
      treeSet.add(100);

      for(Integer i : treeSet) {
        System.out.println(i);
      }
      System.out.println();
      System.out.println("가장 낮은 점수 : " + treeSet.first());
      System.out.println("가장 높은 점수 : " + treeSet.last());
      System.out.println("80점 바로 위 점수 : " + treeSet.ceiling(80));
      System.out.println("80점 바로 아래 점수 : " + treeSet.floor(80));
      System.out.println("70점 바로 아래 점수 : " + treeSet.lower(70));
      System.out.println("50점 바로 위 점수 : " + treeSet.higher(50));

      NavigableSet<Integer> navigableSet = treeSet.descendingSet();
      System.out.println("descendingSet()로 내림차순으로 변경");
      for(Integer i : navigableSet) {
        System.out.println(i);
      }
      Iterator<Integer> iterator = treeSet.descendingIterator();
      System.out.println("descendingIterator()로 내림차순 변경");
      while(iterator.hasNext()) {
        System.out.println(iterator.next());
      }
      System.out.println("범위검색 : 70점 미만 점수");
      NavigableSet<Integer> navigableSet1 = treeSet.headSet(70, false);
      for(Integer i : navigableSet1) {
        System.out.println(i);
      }
      System.out.println("범위검색 : 80점 이상 점수");
      NavigableSet<Integer> navigableSet2 = treeSet.tailSet(80, true);
      for(Integer i : navigableSet2) {
        System.out.println(i);
      }
      System.out.println("범위검색 : 80점 초과, 90점 이하 점수");
      NavigableSet<Integer> navigableSet3 = treeSet.subSet(80, false, 90, true);
      for(Integer i : navigableSet3) {
        System.out.println(i);
      }

    }

  }
  ```

2. TreeMap

- TreeMap은 이진 트리를 기반으로 한 Map 컬렉션이며, TreeSet과의 차이점은 키와 값이 저장된 Entry를 저장한다는 점이다.
- TreeMap에 엔트리를 저장하면 키를 기준으로 자동 정렬되는데, 부모 키 값과 비교해서 낮은 것은 왼쪽, 옾은 것은 오른쪽 자식 노드에 Entry 객체를 저장한다.
- Map 타입 변수에 대입해도 되지만 TreeMap 타입으로 대입한 이유는 검색 관련 메소드가 TreeMap에만 정의되어 있기 때문이다.
- TreeMap Method

  - `Map.Entry<K, V> firstEntry()` : 제일 낮은 Map.Entry를 리턴
  - `Map.Entry<K, V> lastEntry()` : 제일 높은 Map.Entry를 리턴
  - `Map.Entry<K, V> lowerEntry(K key)` : 주어진 키보다 바로 아래 Map.Entry를 리턴
  - `Map.Entry<K, V> higherEntry(K key)` : 주어진 키보다 바로 뒤 Map.Entry를 리턴
  - `Map.Entry<K, V> floorEntry(K key)` : 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 아래의 Map.Entry를 리턴
  - `Map.Entry<K, V> ceilingEntry(K key)` : 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 위의 Map.Entry를 리턴
  - `Map.Entry<K, V> pollFirstEntry()` : 제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거함
  - `Map.Entry<K, V> pollLastEntry()` : 제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거함
  - `NavigableSet<K> descendingKeySet()` : 내림차순으로 정렬된 키의 NavigableSet을 리턴
  - `NavigableMap<K, V> descendingMap()` : 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
  - `NavigableSet<K, V> headMap(K toKey, boolean inclusive)` : 주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴, 객체 포함 여부 = trur or false
  - `NavigableSet<K, V> tailMap(K toKey, boolean inclusive)` : 주어진 키보다 높은 Map.Entry들을 NavigableMap으로 리턴, 객체 포함 여부 = trur or false
  - `NavigableSet<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)` : 시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환, 시작과 끝 객체 포함 여부 = true or false

- TreeMap 예제

  ```java
  package javaChap15.example05;

  import java.util.Map.Entry;
  import java.util.NavigableMap;
  import java.util.Set;
  import java.util.SortedMap;
  import java.util.TreeMap;

  public class TreeMapExample {
    public static void main(String[] args) {
      TreeMap<String, Integer> treeMap1 = new TreeMap<String, Integer>();

      treeMap1.put("apple", 10);
      treeMap1.put("forever", 10);
      treeMap1.put("description", 10);
      treeMap1.put("ever", 10);
      treeMap1.put("zoo", 10);
      treeMap1.put("base", 10);
      treeMap1.put("guess", 10);
      treeMap1.put("cherry", 10);

      Set<Entry<String, Integer>> entrySet = treeMap1.entrySet();
      for(Entry<String, Integer> entry : entrySet) {
        System.out.println(entry.getKey() + " " + entry.getValue());
      }

      SortedMap<String, Integer> sortedMap = null;
      Entry<String, Integer> entry = null;
      System.out.println("제일 앞 단어");
      entry = treeMap1.firstEntry();
      System.out.println(entry.getKey() + " " + entry.getValue());

      System.out.println("제일 뒤 단어");
      entry = treeMap1.lastEntry();
      System.out.println(entry.getKey() + " " + entry.getValue());
      System.out.println("ever 앞 단어");
      entry = treeMap1.lowerEntry("ever");
      System.out.println(entry.getKey() + " " + entry.getValue());

      System.out.println("description 뒤 단어");
      entry = treeMap1.higherEntry("description");
      System.out.println(entry.getKey() + " " + entry.getValue());

      System.out.println("d 뒤(높은) 단어들");
      sortedMap = treeMap1.tailMap("d");
      Set<Entry<String, Integer>> sortedSet = sortedMap.entrySet();
      for(Entry<String, Integer> sortedEntry : sortedSet) {
        System.out.println(sortedEntry.getKey() + " " + sortedEntry.getValue());
      }
      System.out.println("내림차순정렬");
      NavigableMap<String, Integer> navigableMap = treeMap1.descendingMap();
      for(Entry<String, Integer> entry1 : navigableMap.entrySet()) {
        System.out.println(entry1.getKey() + " " + entry1.getValue());
      }
      System.out.println("b(포함)~i 검색");
      NavigableMap<String, Integer> rangeMap = treeMap1.subMap("b", true, "i", false);
      for(Entry<String, Integer> entry2 : rangeMap.entrySet()) {
        System.out.println(entry2.getKey() + " " + entry2.getValue());
      }

    }
  }
  ```
