2023년 3월 2일 목요일

## chap.13 exercises

### 1. 제네릭

- 컴파일 시 강한 타입 체크를 할 수 있다.
- 타입 변환(casting)을 제거한다.
- 제네릭 타입은 타입 파라미터를 가지는 제네릭 클래스와 인터페이스를 말한다.
- 제네릭 메소드는 리턴 타입으로 타입 파라미터를 가질 수 없다. (x) -> 가질 수 있다.

### 2. Container 제네릭 타입 선언

    ```java
    package javaChap13.exercise02;

    public class ContainerExample {
        public static void main(String[] args) {
            Container<String> container1 = new Container<String>();
            container1.setT("홍길동");
            String str = container1.getT();

            Container<Integer> container2 = new Container<Integer>();
            container2.setT(6);
            int value = container2.getT();
        }
    }

    class Container<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

    }
    ```

### 3. Container 제네릭 타입 선언

    ```java
    package javaChap13.exercise03;

    public class ContainerExample {
        public static void main(String[] args) {
            Container<String, String> container1 = new Container<String, String>();
            container1.set("홍길동", "도적");
            String name1 = container1.getK();
            String job = container1.getV();

            Container<String, Integer> container2 = new Container<String, Integer>();
            container2.set("홍길동", 33);
            String name2 = container2.getK();
            int age = container2.getV();
        }
    }

    class Container<K, V> {
        private K k;
        private V v;

        public K getK() {
            return k;
        }

        public void set(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public V getV() {
            return v;
        }

    }
    ```

### 4. Util 클래스, getValue() 제네릭 메소드 작성

    ```java
    package javaChap13.exercise04;

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
    ```

    ```java
    package javaChap13.exercise04;

    public class ChildPair<K, V> extends Pair<K, V> {

        public ChildPair(K key, V value) {
            super(key, value);
            // TODO Auto-generated constructor stub
        }
    }
    ```

    ````java
    package javaChap13.exercise04;

    public class OtherPair<K, V> {
        private K key;
        private V value;

        public OtherPair(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
    ```java
    package javaChap13.exercise04;

    public class Util {
        public static <P extends Pair<K, V>, K, V> V getValue(P p, K k) {
            if (p.getKey().equals(k)) {
                return p.getValue();
            }
            return null;
        }
    }
    ````

    ```java
    package javaChap13.exercise04;

    public class UtilExample {
        public static void main(String[] args) {
            Pair<String, Integer> pair = new Pair<String, Integer>("홍길동", 35);
            Integer age = Util.getValue(pair, "홍길동");
            System.out.println(age);

            ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("이순신", 50);
            Integer childAge = Util.getValue(childPair, "이순신1");
            System.out.println(childAge);

    //		OtherPair<String, Integer> otherPair = new OtherPair<String, Integer>("이순신", 50);
    //		Integer otherAge = Util.getValue(otherPair, "이순신1");
    //		System.out.println(otherAge);
        }
    }
    ```
