2023년 2월 18일 토요일

---

## chap.15 collection data structure2

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
