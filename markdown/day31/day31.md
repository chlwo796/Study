2023년 2월 14일 화요일

---

## day31

### 1. remind

- ncs test
- html 책갈피

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

- javaHigh03.example05.SetEx04

  ```java
  package javaHigh03.example05;

  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.Scanner;
  import java.util.Set;

  public class SetEx04 {
      public static void main(String[] args) {
          Set<Fare> fareSet = new HashSet<Fare>();

          fareSet.add(new Fare("502", 1, 423, 25000));
          fareSet.add(new Fare("303", 7, 725, 35000));
          fareSet.add(new Fare("403", 2, 222, 40000));
          fareSet.add(new Fare("503", 2, 438, 25000));
          fareSet.add(new Fare("503", 3, 417, 35000));
          fareSet.add(new Fare("504", 4, 248, 45000));
          fareSet.add(new Fare("504", 4, 248, 45000));

          // 전체출력, toString 활용해보기
          Iterator<Fare> it = fareSet.iterator();
          System.out.println("호수\t가족수\t전기사용량\t공동요금");
          while (it.hasNext()) {
              Fare fare = it.next();
              System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity() + "\t"
                      + fare.getFee());
          }
          // 호수검색->전기사용량
          Scanner sc = new Scanner(System.in);
          boolean check = true;
          System.out.print("호수를 입력하세요>");
          String searchNumber = sc.nextLine();

          it = fareSet.iterator();
          while (it.hasNext()) {
              Fare fare = it.next();
              if (fare.getNumber().equals(searchNumber)) {
                  System.out.println("호수 : " + searchNumber + ", 전기사용량 : " + fare.getElectricity());
                  check = false;
              }
          }
          if (check) {
              System.out.println("찾으시는 호수 " + searchNumber + "은/는 없습니다.");
          }
          // 최대전기사용량->호수, 가족수
          // Fare의 주소를 참조하는 변수 따로 선언
          Fare maxFare = null;
          int maxElectricity = 0;
          it = fareSet.iterator();
          while (it.hasNext()) {
              Fare fare = it.next();
              if (maxElectricity < fare.getElectricity()) {
                  maxElectricity = fare.getElectricity();
                  maxFare = fare; // 주소를 기억,저장하여 바로 사용한다.
              }
          }
          System.out.println("최대전기사용량 " + maxFare.getElectricity() + "의 가구는 " + maxFare.getNumber() + "호, 가족수 : "
                  + maxFare.getFamilyNumber());

          // 최소 공동요금 -> 공동요금 500원추가 -> 최소공동요금데이터가 여러개라면 배열로 만들어볼 수도 있다.
          int minFee = Integer.MAX_VALUE;
          System.out.println(minFee);
          it = fareSet.iterator();
          while (it.hasNext()) {
              Fare fare = it.next();
              if (minFee > fare.getFee()) {
                  minFee = fare.getFee();
              }
          }
          System.out.println("최소 공동요금 : " + minFee);
          int additionalFee = 500;
          it = fareSet.iterator();
          while (it.hasNext()) {
              Fare fare = it.next();
              if (minFee == fare.getFee()) {
                  fare.setFee(fare.getFee() + additionalFee);
                  System.out.println("공동요금 " + additionalFee + "원 추가하였습니다.");
                  System.out.println("호수\t가족수\t전기사용량\t공동요금");
                  System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity()
                          + "\t" + fare.getFee());
              }
          }
          // 전기사용량 평균, 공동요금 평균
          int sumElectricity = 0;
          int sumFee = 0;

          System.out.println("호수\t가족수\t전기사용량\t공동요금");
          it = fareSet.iterator();
          while (it.hasNext()) {
              Fare fare = it.next();
              sumElectricity += fare.getElectricity();
              sumFee += fare.getFee();
              System.out.println(fare.getNumber() + "\t" + fare.getFamilyNumber() + "\t" + fare.getElectricity() + "\t"
                      + fare.getFee());
          }
          double aveElectricity = (double) sumElectricity / fareSet.size();
          double aveFee = (double) sumFee / fareSet.size();
          System.out.println("전기사용량 평균 : " + aveElectricity + ", 공동요금 평균 : " + aveFee);

      }
  }

  ```

- Map 컬렉션 : 키(key)와 값(value)으로 구성된 엔트리(Entry)객체를 저장한다.

  ```java
  package javaHigh04.example01;

  import java.util.HashMap;
  import java.util.Iterator;
  import java.util.Map;
  import java.util.Set;

  public class MapEx01 {

      public static void main(String[] args) {
          Map<String, Integer> map1 = new HashMap<String, Integer>();
          map1.put("컴퓨터", 200);
          map1.put("프린터", 50);
          map1.put("아이폰", 210);
          map1.put("갤럭시탭", 170);
          // key -> value
          System.out.println(map1.get("컴퓨터"));
          System.out.println(map1.get("아이폰"));
          // 매장에 냉장고가 있나요?
          if (map1.containsKey("냉장고")) {
              System.out.println("있습니다.");
          } else {
              System.out.println("없습니다.");
          }
          System.out.println(map1);
          // 150만원 넘는 목록

          Set<String> set = map1.keySet(); // key -> set 컬렉션

          Iterator<String> it = set.iterator();
          while (it.hasNext()) {
              System.out.println(it.next());
          }
          System.out.println(map1.values()); // .values()로 가능할거같으넫..

          it = set.iterator();
          while (it.hasNext()) {
              String key = it.next();
              if (map1.get(key) > 150) {
                  System.out.println(key + " " + map1.get(key));
              }
          }
          // 170만원짜리 품목이 있습니까?
          it = set.iterator();
          boolean check = true;
          while (it.hasNext()) {
              String key = it.next();
              if (map1.get(key)==170) {
                  System.out.println(key + "있습니다.");
                  check = false;
              }
          }
          if(check) {
              System.out.println("없습니다.");
          }
      }
  }
  ```

---

### 3. memo

- Set<객체>의 중복데이터 처리
- ArrayList, Vector, LinkedList, HashSet, Map remind
