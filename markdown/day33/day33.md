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
  - `Iterator<E> iterator()` : 오름차순 정렬구조
  - `Iterator<E> descendingIterator()` : 내림차순 정렬구조
  - `NavigableSet<E> descendingSet()` :
- TreeMap method
- Comparable, Comparator
  - TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되는데, 어떤 객체든 정렬될 수 있는 것은 아니고 객체가 `Comparable` 인터페이스를 구현하고 있어야 가능하다.
  - `Integer`, `Double`, `String` 타입은 기본적으로 `Comparable`을 구현하고 있기 때문에 상관이 없지만, 사용자 정의 객체를 저장할 때에는 반드시 `interface Comparable`을 구현하고 있어야 한다.
- 사용자 정의 정렬(Comparable, Comparator)
- Comparator : 데이터에 접근불가한 경우 별도의 비교하는 class를 생성하여 비교한다.

---

### 3. memo

- [개발자 소양 5가지](https://yozm.wishket.com/magazine/detail/1896/)
- 사용자 정의 정렬과 중복데이터 처리 합쳐보기
