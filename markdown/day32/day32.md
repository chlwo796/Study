2023년 2월 15일 수요일

---

## day32

### 1. remind

- Set : 중복저장x
- `hashCode();`,`equals();` : 동등비교
- Map : key, value로 구성된 entry
- key : 중복x -> `keySet();`
- value : 중복가능
- List
  - ArrayList : 배열
  - LinkedList : 삭제/삽입
  - Vector : 스레드로 코드 짜는데 ArrayList가 필요함
- Set
  - HashSet
  - TreeSet
- Map : 인터페이스
  - HashMap
  - HashTable

---

### 2. java

- Map 실습, 주소이동 알고리즘 파악
- private field 선언, 클래스타입 생성자 선언
- javaHigh04.example03.School

  ```java
  package javaHigh04.example03;

  public class School {
      private String teacher;
      private String grade;
      private int stNumber;
      private School school;

      public School(String grade, int stNumber) {
          super();
          this.grade = grade;
          this.stNumber = stNumber;
      }

      public School(String teacher, School school) {
          super();
          this.teacher = teacher;
          this.school = school;
      }

      public School getSchool() {
          return school;
      }

      public void setSchool(School school) {
          this.school = school;
      }

      public String getTeacher() {
          return teacher;
      }

      public void setTeacher(String teacher) {
          this.teacher = teacher;
      }

      public String getGrade() {
          return grade;
      }

      public void setGrade(String grade) {
          this.grade = grade;
      }

      public int getStNumber() {
          return stNumber;
      }

      public void setStNumber(int stNumber) {
          this.stNumber = stNumber;
      }

  }
  ```

- javaHigh04.example03.MapEx03

  ```java
  package javaHigh04.example03;

  import java.util.HashMap;
  import java.util.Map;

  public class MapEx03 {

      public static void main(String[] args) {
  //		담임선생님 이름 = key, 반, 명수 = value
          Map<String, School> schoolMap = new HashMap<String, School>();

          School school1 = new School("정현희", new School("3학년1반", 20));
          School school2 = new School("최재환", new School("2학년2반", 23));
          School school3 = new School("아무개", new School("1학년3반", 21));
          School school4 = new School("홍길동", new School("2학년4반", 19));
          School school5 = new School("무명", new School("2학년3반", 24));

          schoolMap.put(school1.getTeacher(), school1.getSchool());
          schoolMap.put(school2.getTeacher(), school2.getSchool());
          schoolMap.put(school3.getTeacher(), school3.getSchool());
          schoolMap.put(school4.getTeacher(), school4.getSchool());
          schoolMap.put(school5.getTeacher(), school5.getSchool());

          // mapping 시 주소를 대입했기 때문에 key를 출력하려면 직접적으로 호출하여야 한다.

          System.out.println("-------------------");
          System.out.println(school1.getTeacher());
          System.out.println(schoolMap.get(school1.getTeacher()).getGrade());
          System.out.println(schoolMap.get(school1.getTeacher()).getStNumber());

          System.out.println("-------------------");
          System.out.println(school2.getTeacher());
          System.out.println(schoolMap.get(school2.getTeacher()).getGrade());
          System.out.println(schoolMap.get(school2.getTeacher()).getStNumber());

          System.out.println("-------------------");
          System.out.println(school3.getTeacher());
          System.out.println(schoolMap.get(school3.getTeacher()).getGrade());
          System.out.println(schoolMap.get(school3.getTeacher()).getStNumber());

          System.out.println("-------------------");
          System.out.println(school4.getTeacher());
          System.out.println(schoolMap.get(school4.getTeacher()).getGrade());
          System.out.println(schoolMap.get(school4.getTeacher()).getStNumber());

          System.out.println("-------------------");
          System.out.println(school5.getTeacher());
          System.out.println(schoolMap.get(school5.getTeacher()).getGrade());
          System.out.println(schoolMap.get(school5.getTeacher()).getStNumber());

          // 반복자로 풀어보기.Map->Set
      }

  }
  ```

- HashTable : HashMap과 동일한 내부 구조를 가지고 있지만, 스레드를 이용하기 때문에, 멀티스레드 환경에서도 안전하게 객체를 추가, 삭제할 수 있다.
- `keySet();`과 반복자를 통한 key 전체 호출

  ```java
          Set<String> keys = schoolMap.keySet();
          Iterator<String> it = keys.iterator();
          while(it.hasNext()) {
              System.out.println(it.next());
          }
  ```

- key데이터로 value 전체 호출

  ```java
          it = keys.iterator();
          while (it.hasNext()) {
              String key = it.next();
              School school = schoolMap.get(key);
              System.out.println(key);
              // get(key) -> value
              System.out.println(school.getGrade());
              System.out.println(school.getStNumber());
          }
  ```

- Properties<String, String> : Map의 한 종류

  - 키의 형태가 String, 값의 형태가 String으로 미리 정의된 Map의 형태
  - 용도 : 환경설정을 담고 있다.

- file을 load할 때는 오류가 많이 발생하므로, 자바에서는 항상 예외처리를 하도록 되어있다.
- database.properties file 생성

  ```java
  driver = oracle.jdbc.OracleDriver
  url = jdbc:oracle:this:@localhost:1521:orc1
  username = scott
  password=tiger
  admin=\uD64D\uAE38\uB3D9
  ```

- Properties 객체 생성 후 `load(ClassName.class.getResourceAsStream("resourceName"));`

  ```java
  package javaHigh04.example04;

  import java.io.IOException;
  import java.util.Properties;

  public class PropertiesEx01 {
      public static void main(String[] args) throws IOException {
          Properties properties = new Properties();
          properties.load(PropertiesEx01.class.getResourceAsStream("database.properties"));

          System.out.println(properties.getProperty("driver"));
          System.out.println(properties.getProperty("url"));
          System.out.println(properties.getProperty("username"));
          System.out.println(properties.getProperty("password"));
          System.out.println(properties.getProperty("admin"));
      }
  }

  ```

- TreeSet : 이진트리를 기반으로 한 Set컬렉션
  - 루트(근) 노드 : 제일 처음 있는 노드
  - 단 노드 : 제일 마지막, 자식이 없는(terminal) 노드
  - 간 노드 : 부모와 자식노드를 가지고 있는(사이에 끼어 있는) 노드
  - 레벨(Level) : 깊이(Depth)
  - ~진트리 : 가장 많은 가지수를 말한다.(ex.3진트리)
- 3~진트리 -> 2진트리 변환

  ```text
        1               1
      / | \            /
     2  3  4          2
    / \         ->   / \
   5   6            5   3
     / | \           \   \
    7  8  9           6   4
                       \
                        7
                         \
                          8
                           \
                            9
  ```

- Tree에 있는 자료 검색

  - 중위검색(order) : left-root-right

    ```text
    3,8,0,10,7을 이진트리로 변환

        3
    / \
    0   8
        / \
        7  10

    0-3-7-8-10으로 읽기만해도 자동정렬된다.
    ```

- TreeSet의 장점
  - 읽기만으로 정렬이 된다.
  - 시간복잡도(비교횟수)가 낮아 검색속도가 빠르다.
- TreeSet의 단점

  - 처음 만들 때 시간이 많이 소요됨
  - 기억할 주소의 공간이 필요하다.
  - 삭제나 추가 등 데이터 수정이 빈번하게 발생하는 자료구조의 경우 비효율적이다.

- 데이터의 정렬과 검색을 많이 한다면 Tree구조로 하는 것이 좋다.
- 데이터구조가 Map(key,value)이라면 TreeMap

---

### 3. memo

- key-> value 반복자 호출 정리

  - 주소로 호출, 값으로 호출 정리

- **반복자 `it.next();` 메소드는 호출될때마다 다른 주소를 가져온다.**

  - `it.next();` 를 인스턴스 변수에 담아주는 이유이며, while문 안에서 한번만 사용토록 한다.

  ```java
          it = keys.iterator();
          while (it.hasNext()) {
              System.out.println(it.next());
              System.out.println(schoolMap.get(it.next()).getGrade());
              System.out.println(schoolMap.get(it.next()).getStNumber());
          }
          // NoSuchElementException 발생
  ```

- 내일 수업 내용
  - TreeSet의 데이터를 비교하는 방법
  - 정렬기준이 되는 field를 정의하는 방법
- css 참고 사이트 정리

  - [w3schools](https://www.w3schools.com/)
  - [codecademy](https://www.codecademy.com/learn/learn-css)
  - [mozilla](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps)

- CSS : 부트스트랩활용(css 양식 라이브러리), 외부스타일
