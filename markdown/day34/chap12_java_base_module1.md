2023년 2월 19일 일요일

---

## chap.12 java.base module1

### 1. API 도큐먼트

- API(Application Programming Interface) 도큐먼트 : 자바 표준 모듈에서 제공하는 라이브러리는 너무 방대하기 때문에, 라이브러리를 쉽게 찾아서 사용할 수 있도록 방법을 기술한 것
  [java api docoments](https://docs.oracle.com/en/java/javase/index.html)

### 2. java.base module

- java.base module : 모든 모듈이 의존하는 기본 모듈, requires하지 않아도 사용할 수 있으며, 이 모듈에 포함되어 있는 패키지는 대부분의 자바 프로그램에서 많이 사용하는 것들이다.
- 주요 패키지와 용도
  - `java.lang` : 자바 언어의 기본 클래스를 제공
  - `java.util` : 자료 구조와 관련된 컬렉션 클래스를 제공
  - `java.text` : 날짜 및 숫자를 원하는 형태의 문자열로 만들어 주는 포맷 클래스를 제공
  - `java.time` : 날짜 및 시간을 조작하거나 연산하는 클래스를 제공
  - `java.io` : 입출력 스트림 클래스를 제공
  - `java.net` : 네트워크 통신과 관련된 클래스를 제공
  - `java.nio` : 데이터 저장을 위한 Buffer 및 새로운 입출력 클래스 제공
- `java.lang` : import 없이 사용할 수 있다.
- `java.lang` 패키지의 주요 클래스와 용도
  - `Object` : 자바 클래스의 최상위 클래스
  - `System`
    - 키보드로부터 데이터를 입력받을 때 사용
    - 모니터(콘솔)로 출력하기 위해 사용
    - 프로세스를 종료시킬 때 사용
    - 진행 시간을 읽을 때 사용
    - 시스템 속성(프로퍼티)을 읽을 떄 사용
  - `String` : 문자열을 저장하고 조작할 때 사용
  - `StringBuilder` : 효율적인 문자열 조작 기능이 필요할 때 사용(메모리 효율)
  - `java.util.StringTokenizer` : 구분자로 연결된 문자열을 분리할 떄 사용
  - `Byte`, `Short`, `Charactoer`, `Integer`, `Float`, `Double`, `Boolean`
    - 기본형(int, char, double 등)의 값을 포장할 때 사용
    - 문자열을 기본 타입으로 변환할 때 사용
  - `Math` : 수학 계산이 필요할 때 사용
  - `Class` : 클래스의 메타 정보(이름, 구성멤버) 등을 조사할 때 사용

### 3. Object 클래스

- 클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 `java.lang.Object` 클래스를 상속한다.
- Object 클래스의 주요 메소드
  - `boolean equals(Object obj)` : 객체의 번지를 비교하고 결과를 리턴
  - `int hashCode()` : 객체의 해시코드를 리턴
  - `String toString()` : 객체 문자 정보를 리턴

1. 객체 동등 비교

- Object의 equals() 메소드는 객체의 번지를 비교하고 boolean 값을 리턴한다.
  `public boolean equals(Object obj)`
- equals() 메소드의 매개변수 타입이 Object이므로 자동 타입 변환에 의해 모든 객체가 매개값으로 대입될 수 있다.
- EqualsExample 예제

  ```java
  package javaChap12.example01;

  public class Member {
      private String id;

      public Member(String id) {
          super();
          this.id = id;
      }
    // 동등비교 작업을 생략하면 1,2는 다른객체로 분류된다.
      @Override
      public boolean equals(Object obj) {
          if (obj instanceof Member) {
              Member target = (Member) obj;
              return id.equals(target.id);
          }
          return false;
      }
  }
  ```

  ```java
  package javaChap12.example01;


  public class EqualsExample {
  public static void main(String[] args) {
  Member member1 = new Member("1");
  Member member2 = new Member("1");
  Member member3 = new Member("3");

          if (member1.equals(member2)) {
              System.out.println("1과 2는 동등");
          } else {
              System.out.println("1과 2는 다름");
          }
          if (member1.equals(member3)) {
              System.out.println("1과 3은 동등");
          } else {
              System.out.println("1과 3은 다름");
          }
      }

  }
  ```

2. 객체 해시코드

- HashCode : 객체를 식별하는 정수
- Object의 `hashCode()` 메소드는 객체의 메모리 번지를 이용해서 해시코드를 생성하기 때문에 객체마다 다른 정수값을 리턴한다.
  `public int hashCode()`
- `eqauls()` 메소드와 마찬가지로 `hashCode()`는 객체의 데이터를 기준으로 재정의해서 새로운 정수값을 리턴하도록 하는 것이 일반적이다.(객체가 다르다 할지라도 내부 데이터가 동일하다면 같은 정수값을 리턴)
- 자바의 동등비교 : `hashCode()`가 리턴하는 정수값이 같은지 확인하고, 그 다음 `equals()`가 true를 리턴하는지 확인
- HashCodeExample 예제

  ```java
  package javaChap12.example01;

  public class Student {
      private int no;
      private String name;

      public Student(int no, String name) {
          super();
          this.no = no;
          this.name = name;
      }

      @Override
      public int hashCode() {
          // TODO Auto-generated method stub
          return name.hashCode() + no;
      }

      @Override
      public boolean equals(Object obj) {
          // TODO Auto-generated method stub
          if (obj instanceof Student) {
              Student target = (Student) obj;
              return no == target.no && name.equals(target.name);
          }
          return false;
      }
  }
  ```

  ```java
  package javaChap12.example01;

  public class HashCodeExample {
      public static void main(String[] args) {
          Student student1 = new Student(1, "홍길동");
          Student student2 = new Student(1, "홍길동");

          if (student1.hashCode() == student2.hashCode()) {
              if (student1.equals(student2)) {
                  System.out.println("동등");
              } else {
                  System.out.println("데이터가 달라서 다름");
              }
          } else {
              System.out.println("해시코드값이 달라서 다름");
          }
      }
  }
  ```

- HashSetExample 예제

  ```java
  package javaChap12.example01;

  import java.util.HashSet;

  public class HashSetExample {
      public static void main(String[] args) {
          HashSet<Student> hashSet = new HashSet<Student>();

          hashSet.add(new Student(1, "홍길동"));
          System.out.println(hashSet.size());
          // Student 클래스에서 동등비교과정을 생략하면 값이 같아도 저장된다.
          hashSet.add(new Student(1, "홍길동"));
          System.out.println(hashSet.size());
          hashSet.add(new Student(2, "홍길동"));
          System.out.println(hashSet.size());
      }
  }
  ```

3. 객체 문자 정보

- 객체 문자 정보 : 객체를 문자열로 표현한 값
- Object의 `toString()` 메소드는 객체의 문자 정보를 리턴하며, 기본적으로 '클래스명@16진수해시코드'로 구성된 문자열을 리턴한다.

  ```java
  Object obj = new Object();
  System.out.println(obj.toString());
  ```

  `java.lang.Object@de6ced`

- 객체의 문자 정보가 중요한 경우에는 Object의 `toString()`메소드를 재정의해서 간결하고 유익한 정보를 리턴하도록 한다.
- ToStringExample 예제

  ```java
  package javaChap12.example01;

  public class SmartPhone {
      private String company;
      private String os;

      public SmartPhone(String company, String os) {
          super();
          this.company = company;
          this.os = os;
      }

      @Override
      public String toString() {
          // toString() 메소드를 해당 객체의 변수를 담도록 재정의
          return company + " " + os;
      }
  }
  ```

  ```java
  package javaChap12.example01;

  public class ToStringExample {
      public static void main(String[] args) {
          SmartPhone smartPhone = new SmartPhone("삼성전자", "안드로이드");

          String str = smartPhone.toString();

          System.out.println(str);
          System.out.println(smartPhone);
      }
  }
  ```

- `System.out.println()` 메소드는 매개값이 기본형(int, long, double 등)이거나 문자열일 경우 해당 값을 그대로 출력하며, 객체를 참조하는 변수라면 해당객체의 `toString()` 메소드를 자동호출하여 리턴값을 출력한다.

### 4. System 클래스

- 자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 자바 가상 머신(JVM)위에서 실행되기 때문에, 운영체제의 모든 기능을 자바 코드로 직접 접근하기 어렵다.
- `java.lang` 패키지에 속하는 System 클래스를 이용하여 운영체제의 일부 기능을 이용할 수 있다.
- System 클래스의 정적 필드와 메소드
  - `out` : 콘솔에 문자 출력
  - `err` : 콘솔에 에러 내용 출력
  - `in` : 키보드 입력
  - `exit(int status)` : 프로세스 종료
  - `currentTimeMills()` : 현재 시간을 밀리초 단위의 long 값으로 전환
  - `nanoTime()` : 현재 시간을 나노초 단위의 long 값으로 리턴
  - `getProperty()` : 운영체제와 사용자 정보 제공
  - `getenv()` : 운영체제의 환경 변수 정보 제공

1. 콘솔 출력

- `out` : 콘솔에 원하는 문자열 출력
- `err` : 콘솔 종류에 따라 에러 내용이 빨간색으로 출력
- ErrExample 예제

  ```java
  package javaChap12.example02;

  public class ErrExample {
      public static void main(String[] args) {
          try {
              int value = Integer.parseInt("1oo");
          } catch (NumberFormatException e) {
              // TODO Auto-generated catch block
              System.err.println("에러내용");
              System.err.println(e.getMessage());
          }
      }
  }
  ```

2. 키보드 입력

- `in` : 키보드로부터 입력된 키를 읽음
  `int a = System.in.read();`
- `read()` 메소드는 호출과 동시에 입력키를 읽는 것이 아니라, Enter 키를 누르면 입력했던 키들을 하나씩 읽으며, IOException을 발생할 수 있는 코드이므로 예외처리가 필요하다.
- InExample 예제

  ```java
  package javaChap12.example02;

  import java.io.IOException;

  public class InExample {
      public static void main(String[] args) throws IOException {
          int speed = 0;
          int keyCode = 0;

          while (true) {
              if (keyCode != 13 && keyCode != 10) {
                  if (keyCode == 49) {
                      speed++;
                  } else if (keyCode == 50) {
                      speed--;
                  } else if (keyCode == 51) {
                      break;
                  }
                  System.out.println("-----------------------");
                  System.out.println("1. 증속 | 2. 감속 | 3. 중지");
                  System.out.println("------------------------");
                  System.out.println("현재속도>" + speed);
                  System.out.print("선택>");
              }
              keyCode = System.in.read();

          }
      }
  }
  ```

3. 프로세스 종료

- 운영체제는 실행중인 프로그램을 프로세스로 관리한다.
- 자바 프로그램을 시작하면 JVM 프로세스가 생성되고, 이 프로세스가 main()메소드를 호출하며, 이 프로세스를 강제 종료하고 싶으면 System클래스의 `exit()` 메소드를 사용한다.

  `System.exit(int status)`

- `exit()` 메소드는 int 매개값이 필요하며, 종료 상태값이라고 한다.

  - 정상종료 : 0
  - 비정상종료 : -1 or 1

- ExitExample 예제

  ```java
  package javaChap12.example02;

  public class ExitExample {
      public static void main(String[] args) {
          for (int i = 0; i < 10; i++) {
              System.out.println(i);
              if (i == 5) {
                  System.out.println("프로세스강제종료");
                  System.exit(0);
              }
          }
      }
  }
  ```

4. 진행 시간 읽기

- System 클래스의 `currentTimeMillis()` 메소드와 `nanoTime()` 메소드는 1970년 1월 1일 0시 부터 시작해서 현재까지 진행된 시간을 리턴한다.
- 메소드

  - `long currentTimeMillis()` : 1/1000초 단위로 진행된 시간을 리턴
  - `long nanoTime()` : 1/10^9초 단위로 진행된 시간을 리턴

- 프로그램 처리 시간을 측정하는데 주로 사용되며, 프로그램 처리를 시작할 때 한번, 끝날 때 한번 리턴된 값의 차이를 이용하여 프로그램 처리 시간을 구한다.
- MesureRunTimeExample 예제

  ```java
  package javaChap12.example02;

  public class MesureRunTimeExample {
      public static void main(String[] args) {
          long time1 = System.nanoTime();
          int sum = 0;
          for(int i = 0;i<100000000;i++) {
              sum+=i;
          }
          long time2 = System.nanoTime();

          System.out.println("총합 : " + sum);
          System.out.println((time2 - time1) + "나노초 소요되었습니다.");
      }
  }
  ```

5. 시스템 프로퍼티 읽기

- 시스템 프로퍼티(System Property) : 자바 프로그램이 시작될 때 자동 설정되는 시스템의 속성(운영체제 종류 및 사용자 정보, 자바 버전 등의 기본 사양정보)
- 시스템 프로퍼티의 주요 속성 이름(key)과 값(value)

  - `java.specification.version` : 자바 스펙 버전, 17
  - `java.home` : JDK 디렉토리 경로, C:\Program Files\Java\jdk-17.03
  - `os.name` : 운영체제, Windows 10
  - `user.name` : 사용자 이름, xxx
  - `user.home` : 사용자 홈 디렉토리 경로, C:\Users\xxx
  - `user.dir` : 현재 디렉토리 경로, C:\ThisIsJavaSecondEdition\workspace\thisisjava

- GetPropertyExample 예제

  ```java
  package javaChap12.example02;

  import java.util.Properties;
  import java.util.Set;

  public class GetPropertyExample {
      public static void main(String[] args) {
          String osName = System.getProperty("os.name");
          String userName = System.getProperty("user.name");
          String userHome = System.getProperty("user.home");

          System.out.println(osName);
          System.out.println(userName);
          System.out.println(userHome);

          System.out.println("----------------------");
          System.out.println("key: value");
          System.out.println("----------------------");
          Properties props = System.getProperties();
          Set keys = props.keySet();

          for(Object obKey : keys) {
              String key = (String) obKey;
              String value = System.getProperty(key);
              System.out.printf("%-40s: %s\n", key, value);
          }
      }
  }
  ```

### 5. 문자열 클래스

- `String` : 문자열을 저장하고 조작할 떄 사용
- `StringBuilder` : 효율적인 문자열 조작 기능이 필요할 때 사용
- `StringTokenizer` : 구분자로 연결된 문자열을 분리할 떄 사용

1. String 클래스

- 문자열 리터럴은 자동으로 String 객체로 생성되지만, String 클래스의 다양한 생정자를 이용해서 직접 객체를 생성할 수도 있다.
- 네트워크 통신으로 얻은 byte 배열을 원래 문자열로 변환하는 경우

  ```java
  // byte 배열 -> String 디코딩
  String str = new String(byte[] bytes);
  String str = new String(byte[] bytes, String charsetName);
  ```

- BytesToStringExample 예제

  ```java
  package javaChap12.example03;

  import java.io.UnsupportedEncodingException;
  import java.util.Arrays;

  public class BytesToStringExample {

    public static void main(String[] args) throws UnsupportedEncodingException {
      // TODO Auto-generated method stub
      String data = "자바";
      // 인코딩
      byte[] arr1 = data.getBytes("UTF-8"); // 기본 = UTF-8, .getBytes("UTF-8");

      System.out.println(Arrays.toString(arr1));
      // 디코딩
      String str1 = new String(arr1);
      System.out.println(str1);

      byte[] arr2 = data.getBytes("EUC-KR");
      System.out.println(Arrays.toString(arr2));

      String str2 = new String(arr2);
      System.out.println(str2);
      String korStr = "자바";

      // 인코딩 변환시 문자열 깨짐이 발생하는 경우, 아래와 같은 방법으로 맞는 인코딩타입을 찾을 수 있다.
      String charset[] = { "utf-8", "euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii" };

      for (String before : charset) {
        for (String after : charset) {
          if (!before.equals(after)) {
            System.out.println(before + " -> " + after + " = " + new String("자바".getBytes(before), after));
          }
        }
      }
    }
  }
  ```

2. StringBuilder 클래스

- `String`은 내부 문자열을 수정할 수 없다.(변경한 것 처럼 보이지만 사실 새로운 String 객체를 생성한다.)
- 문자열의 + 연산은 새로운 String 객체가 생성되고 이전 객체는 계속 버려지는 것이기 때문에 효율성이 좋지 않다.
- 잦은 문자열 변경 작업을 해야 한다면, `StringBuilder` 클래스를 사용하는 것이 좋으며, 내부 버퍼(데이터를 저장하는 메모리)에 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 작업을 하도록 설계되어 있다.
- StringBuilder 메소드

  - `StringBuilder append(기본값 | 문자열)` : 문자열을 끝에 추가
  - `StringBuilder insert(위치, 기본값 | 문자열)` : 문자열을 지정 위치에 추가
  - `StringBuilder delete(시작 위치, 끝 위치)` : 문자열 일부를 삭제
  - `StringBuilder replace(시작 위치, 끝 위치, 문자열)` : 문자열을 일부를 대체
  - `StringBuilder toString()` : 완성된 문자열을 리턴

- StringBuilderExample 예제

  ```java
  package javaChap12.example03;

  public class StringBuilderExample {
    public static void main(String[] args) {
      StringBuilder data = new StringBuilder();
      data.append("DEF");
      data.insert(0, "ABC");
      data.delete(3, 4);
      System.out.println(data);
      data.toString();

      System.out.println(data);
    }
  }
  ```

3. StringTokenizer 클래스

- 문자열이 구분자(delimiter)로 연결되어 있을 경우, 구분자를 기준으로 문자열을 분리하려면 String의 `split()` 메소드를 이용하거나 java.util 패키지의 StringTokenizer 클래스를 이용할 수 있다.
- `split()`은 정규 표현식으로 구분하고, `StringTokenizer`는 문자로 구분한다.

  ```java
  // 정규표현식 = split()
  String data = "홍길동&이수홍,박연수,김자바-최명호";
  String[] name = data.split("&|,|-");
  // 어느 한 종류의 구분자만 있다면 StringTokenizer를 사용, 구분자 생략은 공백이 기본 구분자가 된다.
  String data = "홍길동/이수홍/박연수";
  StringTokenizer st = new StringTokenizer(data, "/");
  ```

- `StringTokenizer` 메소드

  - `int countTokens()` : 분리할 수 있는 문자열의 총 수
  - `boolean hasMoreTokens()` : 남아 있는 문자열이 있는지 여부
  - `String nextToken()` : 문자열을 하나씩 가져옴()

- `nextToken()` 메소드는 분리된 문자열을 하나씩 가져오고 더 이상 가져올 문자열이 없다면 예외를 발생시키기 때문에, `hasMOreTokens()` 메소드로 가져올 문자열이 있는지 먼저 조사하는 것이 좋은 방법이다.
- StringTokenizerExample 예제

  ```java
  package javaChap12.example03;

  import java.util.StringTokenizer;

  public class StringTokenizerExample {
    public static void main(String[] args) {
      String str1 = "홍길동%이수홍,박연수";
      String[] names = str1.split("%|,");

      for (String str : names) {
        System.out.println(str);
      }
      String str2 = "홍길동$,이수홍$**박연수";
      StringTokenizer st = new StringTokenizer(str2, "$|,|*");
      int count = st.countTokens(); // 남아있는 토큰의 개수
      System.out.println(count);
      while (st.hasMoreTokens()) {
        String token = st.nextToken();
        System.out.println(token);
      }
      System.out.println(st.countTokens()); // 토큰 사용후 남은 개수가 출력된다. count = 3, st.countTokens() = 0
    }
  }
  ```

### 6. 포장 클래스

- 자바는 기본타입의 값을 갖는 객체를 생성할 수 있으며, 이런 객체를 포장(wrapper) 객체라고 한다.
- 기본 타입 : byte, char, short, int, long, float, double, boolean
- 포장클래스 : Byte, Character, Short, Integer, Long, Float, Double, Boolean
- 포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하는데 목적이 있다.

1. 박싱과 언박싱

- 박싱(boxing) : 기본 타입의 값을 포장 객체로 만드는 과정, 포장클래스 변수에 기본 타입 값이 대입될 때 발생
- 언박싱(unboxing) : 포장 객체에서 기본 타입의 값을 얻어내는 과정, 기본 타입 변수에 포장 객체가 대입될 때 발생

  ```java
  Integer a = 100;  // 박싱
  int value = a;  // 언박싱
  int value = a + 50; // a는 50과 연산되기 전에 언박싱된다.
  ```

- BoxingUnBoxingExample 예제

  ```java
  package javaChap12.example04;

  public class BoxingUnBoxingExample {
    public static void main(String[] args) {
      Integer obj = 100;
      System.out.println(obj.intValue());

      int value = obj;
      System.out.println(value);

      int result = obj + 100;	// obj 가 먼저 언박싱 후 연산
      System.out.println(result);
    }
  }
  ```

2. 문자열을 기본 타입 값으로 변환

- 포장 클래스는 문자열을 기본 타입 값으로 변환할 때도 사용되며, 대부분의 포장 클래스에는 `parse+기본타입`명으로 되어있는 정적메소드가 있다.
  ```java
  String str = "3000000";
  int value = Integer.parseInt(str);
  ```

3. 포장 값 비교

- 포장 객체는 내부 값을 비교하기 위해 ==와 != 연산자를 사용할 수 없다.(객체의 주소를 비교하기 때문)

  ```java
  Integer obj1 = 300;
  Integer obj2 = 300;
  System.out.println(obj1 == obj2);
  // 값은 같지만 주소값이 달라 false를 리턴한다.
  ```

- 예외적으로 해당 범위의 값을 갖는 포장 객체는 공유된다.
  - `boolean` : true, false
  - `char` : \u0000 ~ \u007f
  - `byte`, `short`, `int` : -128 ~ 127
- 포장 객체에 정확히 어떤 값이 저장될 지 모르는 상황이라면 `==`과 `!=`는 사용하지 않는 것이 좋으며, 대신 `equals()` 메소드로 내부 값을 비교할 수 있다.
- ValueCompareExample 예제

  ```java
  package javaChap12.example04;

  public class ValueCompareExample {
    public static void main(String[] args) {
      Integer obj1 = 300;
      Integer obj2 = 300;
      System.out.println(obj1==obj2);
      System.out.println(obj1.equals(obj2));

      Integer obj3 = 100;
      Integer obj4 = 100;
      System.out.println(obj3==obj4);	// -128~127의 범위에서의 결과를 확인해볼 수 있다.
      System.out.println(obj3.equals(obj4));
    }
  }
  ```
