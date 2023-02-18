2023년 2월 18일 토요일

---

## chap.15 collection data structure2

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

3. Comparable과 Comparator

- TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되며, 객체가 `interface Comparable`을 구현하고 있어야 가능하다.
- Integer, Double, String 타입은 모두 `Comparable`을 기본적으로 구현하고 있기 때문에 상관없지만, 사용자 정의 객체를 저장할 때에는 반드시 `Comparable`을 구현하고 있어야 한다.

- `int compareTo(T o)` : 주어진 객체와 같으면 0, 적으면 음수, 크면 양수를 리턴
- 해당 객체에 `implements Comparable<E>` 후 메소드 오버라이딩

  ```java
  package javaChap15.example06;

  public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
      super();
      this.name = name;
      this.age = age;
    }

    @Override
    public int compareTo(Person o) {
  //		이름으로정렬
  //		return this.name.compareTo(o.name);
      // 나이로 정렬
      if (this.age > o.age) {
        return 1;
      } else if (this.age == o.age) {
        return 0;
      } else
        return -1;
    }

  }
  ```

- ComparableExample 예제

  ```java
  package javaChap15.example06;

  import java.util.TreeSet;

  public class ComparableExample {
    public static void main(String[] args) {
      TreeSet<Person> treeSet1 = new TreeSet<Person>();
      treeSet1.add(new Person("홍길동", 45));
      treeSet1.add(new Person("김자바", 35));
      treeSet1.add(new Person("박자바", 36));
      treeSet1.add(new Person("이자바", 35));

      for(Person p : treeSet1) {
        System.out.println(p.name + " " + p.age);
      }
    }
  }
  ```

- 비교 기능이 없는 Comparable 비구현 객체를 저장하고 싶다면(별도의 클래스로 저장), TreeSet과 TreeMap을 생성할 때 비교자(Comparator)를 제공하면 된다.
- `TreeMap<K, V> treeMap = new TreeMap<K, V>(new ComparatorImpl());`
- 비교자는 Comparator 인터페이스를 구현한 객체를 말하며, Comparator 인터페이스에는 compare() 메소드가 정의되어 있다.
- `int compare(T o1, T o2)` : o1과 o2가 동등하다면 0을 리턴, o1이 o2보다 앞에 오게 하려면 음수를 리턴, o1이 o2보다 뒤에 오게하려면 양수를 리턴
- 별도 Comparator 객체(비교자)에서 `implements Comparator<E>` 후 메소드 오버라이딩

  ```java
  package javaChap15.example06;

  import java.util.Comparator;

  public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
      // TODO Auto-generated method stub
      if (o1.price > o2.price) {
        return 1;
      } else if (o1.price == o2.price) {

        return 0;
      } else

        return -1;
    }

  }
  ```

- TreeSet 객체

  ```java
  package javaChap15.example06;

  public class Fruit {
    public String name;
    public int price;

    public Fruit(String name, int price) {
      super();
      this.name = name;
      this.price = price;
    }

  }
  ```

- `TreeSet<E> treeSet = new TreeSet<E>(new ComparatorImpl());`

  ```java
  package javaChap15.example06;

  import java.util.TreeSet;

  public class ComparatorExample {
    public static void main(String[] args) {
      TreeSet<Fruit> treeSet1 = new TreeSet<Fruit>(new FruitComparator());
      treeSet1.add(new Fruit("사과", 1000));
      treeSet1.add(new Fruit("포도", 1500));
      treeSet1.add(new Fruit("바나나", 2000));
      treeSet1.add(new Fruit("배", 3000));

      for (Fruit f : treeSet1) {
        System.out.println(f.name + " " + f.price);
      }
    }
  }
  ```

### 6. LIFO와 FIFO 컬렉션

- LIFO(Last In First Out) : 나중에 넣은 객체가 먼저 빠져나는 구조(후입선출)
- FIFO(First In First Out) : 먼저 넣은 객체가 먼저 빠져나가는 구조(선입선출)
- 컬렉션 프레임워크는 LIFO 자료구조를 제공하는 스택(Stack) 클래스와 FIFO 자료구조를 제공하는 큐(Queue)인터페이스를 제공하고 있다.
- JVM 스택 메모리는 스택을 응용한 대표적인 예이며, 스택 메모리에 저장된 변수는 나중에 저장된 것부터 제거된다.
- 스레드풀(ExecutorService)의 작업큐는 큐를 응용한 대표적인 예이며, 먼저 들어온 작업부터 처리한다.

1. Stack

- Stack 클래스는 LIFO 자료구조를 구현한 클래스이다.
- `E push(E item)` : 주어진 객체를 스택에 넣는다.
- `E pop()` : 스택의 맨 위 객체를 빼낸다.
- StackExample 예제

  ```java
  package javaChap15.example07;

  public class Coin {
      private int value;

      public Coin(int value) {
          super();
          this.value = value;
      }

      public int getValue() {
          return value;
      }

      public void setValue(int value) {
          this.value = value;
      }
  }
  ```

- 후입선출 확인

  ```java
  package javaChap15.example07;

  import java.util.Stack;

  public class StackExample {
      public static void main(String[] args) {
          Stack<Coin> stack = new Stack<Coin>();

          stack.push(new Coin(100));
          stack.push(new Coin(50));
          stack.push(new Coin(500));
          stack.push(new Coin(10));

          while(!stack.isEmpty()) {
              Coin coin = stack.pop();
              System.out.println(coin.getValue());
          }
      }
  }
  ```

2. Queue

- Queue 인터페이스는 FIFO 자료구조에서 사용되는 메소드를 정의하고 있다.
- `boolean offer(E e)` : 주어진 객체를 큐에 넣는다.
- `E poll()` : 큐에서 객체를 빼낸다.
- Queue 인터페이스를 구현한 대표적인 클래스는 LinkedList이며, 다형성으로 LinkedList 객체를 Queue 인터페이스 변수에 대입할 수 있다.
- `Queue<E> queue = new LinkedList<E>();`
- QueueExample 예제

  ```java
  package javaChap15.example07;

  public class Message {
      public String command;
      public String to;
      public Message(String command, String to) {
          super();
          this.command = command;
          this.to = to;
      }
  }
  ```

- 선입선출 확인

  ```java
  package javaChap15.example07;

  import java.util.LinkedList;
  import java.util.Queue;

  public class QueueExample {
      public static void main(String[] args) {
          Queue<Message> queue = new LinkedList<Message>();
          queue.offer(new Message("안녕하세요", "홍길동"));
          queue.offer(new Message("안녕하세요!", "김자바"));
          queue.offer(new Message("안녕하세요!!", "이자바"));

          while(!queue.isEmpty()) {
              Message message = queue.poll();
              System.out.println(message.to + " 에게 " + message.command + " 메세지를 보냅니다.");
          }
      }
  }
  ```

### 7. 동기화된 컬렉션

- 컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었기 때문에, 여르 스레드가 동시에 컬렉션에 접근한다면 의도치 않게 요소가 변경될 수 있는 불안전한 상태가 된다.
- Vector, Hashtable은 동기화된 메소드로 구성되어 있기 때문에, 멀티 스레드 환경에서 안전하게 요소를 처리할 수 있지만, ArrayList, HashSet, HashMap은 동기화된 메소드로 구성되어 있지 않아 멀티스레드 환경에서 안전하지 않다.
- 때때로 이런 비동기화된 컬렉션을 멀티 스레드 환경에서 사용하고 싶은 경우, 동기화된 메소드로 래핑해주는 Collections의 `syschronizedXXX()` 메소드를 사용한다.
- `List<T> sysnchronizedList(List<T> list)` : List를 동기화된 List로 리턴
- `Map<K, V> sysnchronizedMap(Map<K, V> m)` : Map을 동기화된 Map으로 리턴
- `Set<T> sysnchronizedSet(Set<T> s)` : Set를 동기화된 Set으로 리턴
- SynchronizedMapExample 예제

  ```java
  package javaChap15.example08;

  import java.util.Collections;
  import java.util.HashMap;
  import java.util.Map;

  public class SynchronizedMapExample {
      public static void main(String[] args) {
          Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
  //		아래 코드의 결과로 동기화된 map과의 차이점을 확인해볼 수 있다.
  //		Map<Integer, String> map = new HashMap<Integer, String>();
          Thread threadA = new Thread() {
              @Override
              public void run() {
                  for (int i = 1; i <= 1000; i++) {
                      map.put(i, String.valueOf(i));
                  }
              }
          };
          Thread threadB = new Thread() {
              @Override
              public void run() {
                  for (int i = 1001; i <= 2000; i++) {
                      map.put(i, String.valueOf(i));
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
          System.out.println(map.size());
      }
  }
  ```

### 8. 수정할 수 없는 컬렉션

- 수정할 수 없는(unmodifiable) 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션을 말하며, 컬렉션 생성 시 저장된 요소를 변경하고 싶지 않을 때 유용하다.
- List, Set, Map 인터페이스의 정적 메소드인 `.of()`로 생성할 수 있다.

  ```java
  List<E> list = List.of(E...elements);
  Set<E> set = Set.of(E...elements);
  Map<K, V> map = Map.of(K k1, V v1, K k2, V v2,..);
  ```

- `.copyOf()`를 이용해 기존 컬렉션을 복사하여 수정할 수 없는 컬렉션을 만든다.

  ```java
  List<E> list = List.copyOf(Collection<E> coll);
  Set<E> set = Set.copyOf(Collection<E> coll);
  Map<K, V> map = Map.copyOf(Map<K, V> map);
  ```

- 배열로부터 수정할 수 없는 List 컬렉션을 만들 수 있다.

  ```java
  String[] array = {"A", "B", "C"};
  List<String> list = Arrays.asList(array);
  ```

- ImmutableExample 예제

  ```java
  package javaChap15.example09;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.HashMap;
  import java.util.HashSet;
  import java.util.List;
  import java.util.Map;
  import java.util.Set;

  public class ImmutableExample {
      public static void main(String[] args) {
          List<String> list = List.of("A", "B", "C");

  //		list.add("D");	// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

          Set<String> set = Set.of("A", "B", "C");

  //		set.remove("A");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

          Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");

  //		map.put(4, "D");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

          for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i));
          }

          ArrayList<String> arrayList = new ArrayList<String>();

          arrayList.add("A");
          arrayList.add("B");
          arrayList.add("C");
          arrayList.add("D");

          List<String> list2 = List.copyOf(arrayList);

  //		list2.add("B");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException
          for (int i = 0; i < list2.size(); i++) {
              System.out.println(list2.get(i));
          }

          Set<String> hashSet = new HashSet<String>();

          hashSet.add("A");
          hashSet.add("B");
          hashSet.add("C");
          hashSet.add("D");

          Set<String> set2 = Set.copyOf(hashSet);

  //		set2.add("E");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException
          Map<Integer, String> hashMap = new HashMap<Integer, String>();

          hashMap.put(3, "A");
          hashMap.put(5, "M");
          hashMap.put(6, "C");
          hashMap.put(1, "D");

          Map<Integer, String> map2 = Map.copyOf(hashMap);

  //		map2.clear();// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

          String[] array = { "A", "B", "C", "D" };

          List<String> list3 = Arrays.asList(array);

          for (int i = 0; i < list3.size(); i++) {
              System.out.println(list3.get(i));
          }
      }
  }
  ```
