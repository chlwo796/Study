2023년 2월 14일 화요일

---

## day31

### 1. remind

- ncs test

---

### 2. java

- 컬렉션 자료구조
- 동등 객체를 찾는 방법
  1. `hashcode()` : 주기억장치(힙, 스택, 메소드) 주소 만드는 코드
     - RAM의 용량에 따라 `hashcode()`가 만드는 주소는 유한적임
  2. `equals()` : 주소가 같다면 값이 같은 조건으로 동등한 객체로 판단
- RAM(Random Access Memory)
- ROM(Read Only Memory)
- private 변수와 생성자, getter,setter 선언

  - javaHigh03.example02.Member

    ```java
    package javaHigh03.example02;

    public class Member {

        public Member(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

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

- `Set<Type> setName = new HashSet<Type>();`

  - javaHigh03.example02.SexEx01

    ```java
    package javaHigh03.example02;

    import java.util.HashSet;
    import java.util.Iterator;
    import java.util.Set;

    public class SetEx01 {
        public static void main(String[] args) {
            Set<Member> memberSet = new HashSet<Member>();
            memberSet.add(new Member("홍길동", 30));
            memberSet.add(new Member("이순신", 25));
            memberSet.add(new Member("최기쁨", 10));

            Iterator<Member> it = memberSet.iterator();
            while(it.hasNext()) {
            System.out.println(it.next()); // 주소 출력
            }
            it = memberSet.iterator();
            while(it.hasNext()) {
                Member member = it.next();	// memberSet의 주소와 member 객체를 연결
            System.out.println(member.getName() + " " + member.getAge());
            }
        }
    }
    ```

- **Set의 데이터가 객체 속성(배열)이라면 데이터 값이 같더라도 주소가 다르게 생성되어 중복데이터가 저장된다.**
- 자바에서 모든 클래스는 Object 클래스의 자식이다.
- Object 클래스의 `hashCode()`, `equals()` method overriding

  ```java
  package javaHigh03.example02;

  public class Member {
      // 이름이 같고 나이가 같으면 같은사람(동등객체)라는 것을 프로그램으로 작성하기
      // 1. hashcode() 2. equals()
      // hashCode()수행과 equals()수행은 별도로 메소드 호출하지 않아도 Set 객체가 자동호출한다.
      @Override
      public int hashCode() {
          // 개발자가 hashCode()를 재정의
          return name.hashCode() + age;
      }

      @Override
      public boolean equals(Object obj) {
          // obj 변수에는 2번째로 set 안에 들어갈 자료의 주소가 들어있다.
          // target.name = 들어갈 자료의 이름, this.name = 들어있는 자료의 이름
          if(obj instanceof Member) {
              Member target = (Member) obj;
              return target.name.equals(this.name) && target.age == this.age;
          }
          return false;
      }
  }
  ```

---

### 3. memo

- Set<객체>의 중복데이터 처리
- ArrayList, Vector, LinkedList, HashSet remind
