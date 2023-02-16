2023년 2월 16일 목요일

---

## day32

### 1. remind

- Tree 구조(Left-Root-Right)

  ```text
  4 7 0 8 9 2

        4
       / \
      0   7
       \   \
        2   8
             \
              9
  ```

- Tree 장점 : 읽기만 해도 정렬이 되며, 검색 속도가 빠르다.
- Tree 구조에서는 중복데이터를 허용하지 않기때문에 TreeSet,TreeMap으로 두가지가 있다.

---

### 2. java

- TreeSet Method

  - `E first()` : 제일 낮은 객체 리턴
  - `E last()` : 제일 높은 객체 리턴
  - `Iterator<E> iterator()` : 오름차순 반복자 리턴
  - `Iterator<E> descendingIterator()` : 내림차순 반복자 리턴
  - `NavigableSet<E> descendingSet()` : 내림차순으로 정렬된 NavigableSet 리턴
  - `NavigableSet<E> headSet(E toElement, boolean inclusive)` : 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 객체 포함여부 = true or false
  - `NavigableSet<E> tailSet(E toElement, boolean inclusive)` : 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 객체 포함여부 = true or false
  - `NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toinclusive)` : 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴, 시작과 끝 객체 포함여부 = true or false

- javaHigh05.example01.TreeSetEx01

  ```java
  package javaHigh05.example01;

  import java.util.Iterator;
  import java.util.NavigableSet;
  import java.util.SortedSet;
  import java.util.TreeSet;

  public class TreeSetEx01 {
    public static void main(String[] args) {
      TreeSet<Integer> tree1 = new TreeSet<Integer>();

      tree1.add(4);
      tree1.add(7);
      tree1.add(4);
      tree1.add(0);
      tree1.add(8);
      tree1.add(9);
      tree1.add(2);

      System.out.println("트리의 노드 수 ->" + tree1.size());
      System.out.println("제일 낮은 객체 ->" + tree1.first());
      System.out.println("제일 높은 객체 ->" + tree1.last());
      System.out.println("7의 바로 아래 객체 ->" + tree1.lower(7));
      System.out.println("7의 바로 위 객체 ->" + tree1.higher(7));
      System.out.println("5와 같은 객체 ->(없으면 바로 아래 객체)" + tree1.floor(5));
      System.out.println("3와 같은 객체 ->(없으면 바로 위 객체)" + tree1.ceiling(3));
      System.out.println("제일 낮은 객체 꺼내온 후 제거 " + tree1.pollFirst());
      System.out.println("제일 높은 객체 꺼내온 후 제거 " + tree1.pollLast());
      System.out.println("제일 낮은 객체 ->" + tree1.first());
      System.out.println("제일 높은 객체 ->" + tree1.last());
      System.out.println("트리의 노드 수 ->" + tree1.size());

      // 오름차순
      Iterator<Integer> iterator = tree1.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
      System.out.println();
      // descendingIterator() = 반대순서, 내림차순
      Iterator<Integer> iterator1 = tree1.descendingIterator();
      while (iterator1.hasNext()) {
        System.out.println(iterator1.next());
      }
      System.out.println();
      // NavigableSet = 정렬된 Set
      NavigableSet<Integer> navigableSet = tree1.descendingSet();
      Iterator<Integer> iterator2 = navigableSet.iterator();

      while (iterator2.hasNext()) {
        System.out.println(iterator2.next());
      }
      System.out.println();
      System.out.println(navigableSet.first());
      System.out.println(navigableSet.floor(3));
      System.out.println();
      SortedSet<Integer> sortedSet1 = tree1.headSet(8);
      for (Integer i : sortedSet1) {
        System.out.println(i);
      }
      System.out.println();
      SortedSet<Integer> sortedSet2 = tree1.headSet(8, true);
      for (Integer i : sortedSet2) {
        System.out.println(i);
      }
      System.out.println();
      SortedSet<Integer> sortedSet3 = tree1.tailSet(4);
      for (Integer i : sortedSet3) {
        System.out.println(i);
      }
      System.out.println();
      SortedSet<Integer> sortedSet4 = tree1.subSet(2, true, 8, false);
      for (Integer i : sortedSet4) {
        System.out.println(i);
      }

    }
  }
  ```

- javaHigh05.example01.TreeSetEx02

  ```java
  package javaHigh05.example01;

  import java.util.NavigableSet;
  import java.util.SortedSet;
  import java.util.TreeSet;

  public class TreeSetEx02 {
    public static void main(String[] args) {
      TreeSet<Integer> treeSet1 = new TreeSet<Integer>();

      treeSet1.add(3500000);
      treeSet1.add(2150000);
      treeSet1.add(2200000);
      treeSet1.add(2700000);
      treeSet1.add(2750000);

      // 가장 높은 기본급은?
      System.out.println("가장 높은 기본급 : " + treeSet1.last());
      // 가장 낮은 기본급은?
      System.out.println("가장 낮은 기본급 : " + treeSet1.first());
      // 기본급 오름차순
      System.out.println("오름차순 정렬");
      for (Integer i : treeSet1) {
        System.out.println(i);
      }
      // 기본급 내림차순
      System.out.println("내림차순 정렬");
      NavigableSet<Integer> navigableSet1 = treeSet1.descendingSet();
      for (Integer i : navigableSet1) {
        System.out.println(i);
      }

      TreeSet<String> treeSet2 = new TreeSet<String>();

      treeSet2.add("과장");
      treeSet2.add("사원");
      treeSet2.add("사원");
      treeSet2.add("대리");
      treeSet2.add("대리");
      treeSet2.add("사원");
      treeSet2.add("과장");
      treeSet2.add("부장");

      // 오름차순 정렬
      for (String s : treeSet2) {
        System.out.println(s);
      }
      NavigableSet<String> navigableSet2 = treeSet2.descendingSet();
      // 내림차순 정렬
      System.out.println();
      for (String s : navigableSet2) {
        System.out.println(s);
      }
      // 직급의 개수
      System.out.println(treeSet2.size());

      // 부장 바로 아래는?

      System.out.println(treeSet2.lower("부장"));
      // 대리 바로 위는?

      System.out.println(treeSet2.higher("대리"));
    }
  }
  ```

- TreeMap method
  - `Map.Entry<K,V> firstEntry()` : 제일 낮은 Map.Entry를 리턴
  - `lastEntry()` : 제일 높은 Map.Entry를 리턴
  - `lowerEntry(K key)` : 주어진 key보다 바로 아래 Map.Entry를 리턴
  - `higherEntry(K key)` : 주어진 key보다 바로 위 Map.Entry를 리턴
  - `floorEntry(K key)` : 주어진 key와 동등한 key가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 key 바로 위의 Map.Entry를 리턴
  - `ceilingEntry(K key)` : 주어진 key와 동등한 key가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 key 바로 아래의 Map.Entry를 리턴
  - `pollFirstEntry()` : 제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거
  - `pollLastEntry()` : 제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거
  - `NavigableSet<K> descendingKeySet()` : 내림차순으로 정렬된 키의 NavigableSet을 리턴
  - `NavigableMap<K> descendingMap()` : 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
  - `NavigableMap<K> headMap(K toKey, boolean inclusive)` : 주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴, 주어진 키의 Map.Entry 포함여부 = true or false
  - `NavigableMap<K> tailMap(K toKey, boolean inclusive)` : 주어진 키보다 높은 Map.Entry들을 NavigableMap으로 리턴, 주어진 키의 Map.Entry 포함여부 = true or false
  - `NavigableMap<K> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)` : 시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환, 시작과 끝 키의 Map.Entry 포함여부 = true or false
- javaHigh05.example02.TreeMapEx01

  ```java
  package javaHigh05.example02;

  import java.util.Iterator;
  import java.util.Map.Entry;
  import java.util.NavigableMap;
  import java.util.NavigableSet;
  import java.util.Set;
  import java.util.TreeMap;

  public class TreeMapEx01 {

    public static void main(String[] args) {
      TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

      treeMap.put("apple", 10);
      treeMap.put("forever", 60);
      treeMap.put("description", 20);
      treeMap.put("ever", 40);
      treeMap.put("zoo", 20);
      treeMap.put("base", 50);
      treeMap.put("guess", 110);
      treeMap.put("cherry", 70);

      Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
      Iterator<Entry<String, Integer>> iterator = entrySet.iterator();

      while(iterator.hasNext()) {
        System.out.println(iterator.next());
      }

      // 특정 키에 대한 값 가져오기
      Entry<String, Integer> entry = null;
      entry = treeMap.firstEntry();
      System.out.println("제일 앞 단어 " + entry.getKey() + entry.getValue());
      entry = treeMap.lastEntry();
      System.out.println("제일 뒤 단어 " + entry.getKey() + entry.getValue());
      entry = treeMap.lowerEntry("ever");
      System.out.println("ever의 앞 단어 " + entry.getKey());
      entry = treeMap.higherEntry("ever");
      System.out.println("ever의 뒤 단어 " + entry.getKey());

      NavigableMap<String, Integer> navigableMap = treeMap.descendingMap();
      Set<Entry<String, Integer>> descendingEntry = navigableMap.entrySet();

      for(Entry<String, Integer> e : descendingEntry) {
        System.out.println(e);
      }
      System.out.println();
      // key값만으로 value를 자동으롷 호출하는 코드, 더 편리해 보인다.
      NavigableSet<String> navigableSet = treeMap.descendingKeySet();
      for(String s : navigableSet) {
        System.out.println(s + " = " + treeMap.get(s));
      }
      System.out.println();
      NavigableMap<String, Integer> subMap1 = treeMap.subMap("c", true, "h", true);
      Set<String> keySet = subMap1.keySet();
      for(String s : keySet) {
        System.out.println(s + " = " + subMap1.get(s));
      }
      System.out.println();
      for(Entry<String, Integer> e : subMap1.entrySet()) {
        System.out.println(e);
      }
    }
  }
  ```

- javaHigh05.example02.TreeMapEx02

  ```java
  package javaHigh05.example02;

  import java.util.Map.Entry;
  import java.util.Set;
  import java.util.TreeMap;

  public class TreeMapEx02 {
    public static void main(String[] args) {
      TreeMap<String, String> treeMap1 = new TreeMap<String, String>();

      treeMap1.put("영업부1", "강정호");
      treeMap1.put("홍보부1", "김강인");
      treeMap1.put("기획부1", "김영자");
      treeMap1.put("총무부1", "김영자");
      treeMap1.put("인사부1", "홍길동");
      treeMap1.put("회계부1", "최재환");
      treeMap1.put("개발부1", "최재환");
      treeMap1.put("영업부2", "강정호");
      treeMap1.put("홍보부2", "김강인");
      treeMap1.put("기획부2", "김영자");
      treeMap1.put("총무부2", "김영자");
      treeMap1.put("인사부2", "홍길동");
      treeMap1.put("회계부2", "최재환");
      treeMap1.put("개발부2", "최재환");

      for (Entry<String, String> e : treeMap1.entrySet()) {
        System.out.println(e);
      }
      System.out.println();
      for (String e : treeMap1.descendingKeySet()) {
        System.out.println(e + "=" + treeMap1.get(e));
      }
      System.out.println();
      System.out.println(treeMap1.firstEntry());
      System.out.println(treeMap1.lastEntry());
      System.out.println(treeMap1.lowerEntry("회계"));
      System.out.println(treeMap1.higherEntry("회계"));
    }
  }
  ```

- Comparable, Comparator
  - TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되는데, 어떤 객체든 정렬될 수 있는 것은 아니고 객체가 `Comparable` 인터페이스를 구현하고 있어야 가능하다.
  - `Integer`, `Double`, `String` 타입은 기본적으로 `Comparable`을 구현하고 있기 때문에 상관이 없지만, 사용자 정의 객체를 저장할 때에는 반드시 `interface Comparable`을 구현하고 있어야 한다.
- 사용자 정의 정렬(Comparable, Comparator)
- Comparable 실습

  ```java
  package javaHigh05.example03;

  import java.util.TreeSet;

  public class ComparableEx01 {
    public static void main(String[] args) {
      TreeSet<Person> treeSet2 = new TreeSet<Person>();
      treeSet2.add(new Person("홍길동", 45, 1.4));
      treeSet2.add(new Person("김자바", 25, 2.2));
      treeSet2.add(new Person("박지원", 11, 5.4));
      treeSet2.add(new Person("박지원", 19, 2.7));
      treeSet2.add(new Person("박지원", 18, 3.2));
      treeSet2.add(new Person("박지원3", 15, 6.2));
      treeSet2.add(new Person("박지원4", 17, 1.3));
      treeSet2.add(new Person("박지원5", 11, 2.6));
      System.out.println();
      for (Person p : treeSet2) {
        System.out.println(p.getName() + " " + p.getAge() + " " + p.getScore());
      }
    }
  }
  ```

- `class Person implements Comparable<Person>{}` : interface Comparable를 구현하며 `compareTo()` 메소드 오버라이딩

  ```java
  package javaHigh05.example03;

  public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Double score;

    public Person(String name, int age, Double score) {
      super();
      this.name = name;
      this.age = age;
      this.score = score;
    }

    public Double getScore() {
      return score;
    }

    public void setScore(Double score) {
      this.score = score;
    }

    @Override
    public int compareTo(Person o) {
      // 이름으로 정렬, String 클래스에 있는 메소드 compareTo()를 호출하여 정렬작업수행
  //		return name.compareTo(o.name);
      // 이름 거꾸로 정렬
  //		return o.name.compareTo(name);
      // 나이로 정렬
  //		if (this.age < o.age) {
  //			return -1;
  //		} else if (this.age == o.age) {
  //			return 0;
  //		} else {
  //			return 1;
  //		}
      // 나이 역순
  //		if (o.age < this.age) {
  //			return -1;
  //		} else if (o.age == this.age) {
  //			return 0;
  //		} else {
  //			return 1;
  //		}
      // 점수 순서대로 정렬(오름차순)
  //		return score.compareTo(o.score);
      // 점수 역순
      return o.score.compareTo(score);
      // Integer class로 변수 선언했을 경우 compareTo()메소드를 사용할 수 있다.
  //		return age.compareTo(o.age);
    }

    public Person(String name, int age) {
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
  }
  ```

- Comparator : 데이터에 접근불가한 경우 별도의 비교하는 class를 생성하여 비교한다.

---

### 3. memo

- [개발자 소양 5가지](https://yozm.wishket.com/magazine/detail/1896/)
- 사용자 정의 정렬과 중복데이터 처리 합쳐보기
- TreeSet에서는 자동정렬이 되기 때문에, 객체참조로 중복데이터가 있더라도 따로 사용자가 정의하는 작업을 해주지 않아도 된다.
- 2.22 ncs test
