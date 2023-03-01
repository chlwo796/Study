2023년 3월 1일 수요일

---

## chap.12 excercises review

### 1. API 도큐먼트

- 자바 표준 라이브러리를 프로그램에서 어떻게 사용할 수 있는지를 설명하고 있다.
- 클래스의 상속 관계 및 자식 클래스들이 무엇이 있는지 알 수 있다.
- 생성자 선언부, 필드의 타입, 메소드의 선언부를 확인할 수 있다.
- public, protected, default, private 접근 제한을 가지는 멤버들을 확인할 수 있다. (x) -> 접근제한자는 확인할 수 없다.

### 2. java.base 모듈

- 모든 표준 모듈이 의존하는 기본 모듈이다.
- 모듈 기술자에 `requires`를 하지 않아도 사용할 수 있는 모듈이다.
- java.base의 패키지에는 java.lang, java.util, java.io, java.net, java.sql 등이 있다. (x) -> java.sql 은 다른 패키지이다.
- java.lang 패키지를 제외한 다른 패키지는 `import`문을 필요로 한다.

### 3. Object 클래스

- 모든 자바 클래스의 최상위 부모 클래스이다.
- Object의 equals() 메소드는 == 연산자와 동일하게 번지를 비교한다.
- Object의 hashCode() 메소드는 동등 비교시 활용된다.
- Object의 toString() 메소드는 객체의 필드값을 문자열로 리턴한다. (x) -> 주소값(객체값)을 문자열로 리턴

### 4. 동등비교

    ```java         true              true
    hashCode() 리턴값 -> equals() 리턴값 -> 동등 객체
    false = 다른객체     false = 다른객체
    ```

### 5. hashCode(), equals()

    ```java
    package javaChap12.exercise05;

    public class Student {
        private String studentNum;

        public Student(String studentNum) {
            super();
            this.studentNum = studentNum;
        }

        public String getStudentNum() {
            return studentNum;
        }

        public void setStudentNum(String studentNum) {
            this.studentNum = studentNum;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student target = (Student) obj;
                return getStudentNum().equals(target.getStudentNum());
            }
            return false;
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return studentNum.hashCode();
        }
    }
    ```

    ```java
    package javaChap12.exercise05;

    import java.util.HashSet;

    public class StudentExample {
        public static void main(String[] args) {
            HashSet<Student> hashSet = new HashSet<Student>();

            hashSet.add(new Student("1"));
            hashSet.add(new Student("1"));
            hashSet.add(new Student("2"));

            System.out.println(hashSet.size());
        }
    }
    ```

### 6. toString()

    ```java
    package javaChap12.exercise06;

    public class Member {
        private String id;
        private String name;

        public Member(String id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.id + ": " + this.name;
        }
    }
    ```

    ```java
    package javaChap12.exercise06;

    public class MemberExample {
        public static void main(String[] args) {
            Member member = new Member("blue", "이파란");
            System.out.println(member);
        }
    }
    ```

### 7. System 클래스

- System 클래스는 정적 필드와 정적 메소드만 제공한다.
- System.out은 콘솔에 출력할 때, System.in은 키보드에서 입력받을 때 사용한다.
- millsTime()과 nanoTime() 메소드는 현재 시간에 대한 long값을 리턴한다. (x) -> millsTime() 가 아닌 currentTimeMillis() 이다.
- exit() 메소드는 프로세스(JVM)을 종료시킨다.

### 8. 코드 실행 시간 구하기

    ```java
    package javaChap12.exercise08;

    public class NanoTimeExample {

        public static void main(String[] args) {
            long startTime = System.nanoTime();
            int[] scores = new int[1000];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = i;
            }
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            double avg = sum / scores.length;
            System.out.println(avg);
            long endTime = System.nanoTime();

            System.out.println((endTime - startTime) + "나노초");
        }
    }
    ```

### 9. 인코딩, 디코딩

    ```java
    package javaChap12.exercise09;

    import java.io.UnsupportedEncodingException;

    public class DecodingExample {
        public static void main(String[] args) throws UnsupportedEncodingException {
            byte[] bytes = { -20, -107, -120, -21, -123, -107 };
            String str = new String(bytes, "UTF-8");
            System.out.println("str : " + str);
        }
    }
    ```

### 10. StringBuilder

    ```java
    package javaChap12.exercise10;

    public class StringBuilderExample {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= 100; i++) {
                sb.append(i);
            }
            System.out.println(sb);
        }
    }
    ```

### 11. StringTokenizer

    ```java
    package javaChap12.exercise11;

    import java.util.StringTokenizer;

    public class StringTokenizerExample {

        public static void main(String[] args) {
            String str = "아이디, 이름, 패스워드";
            StringTokenizer st = new StringTokenizer(str, ",| ");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                System.out.println(token);
            }

        }

    }
    ```

### 12. Boxing, Unboxing

    ```java
    package javaChap12.exercise12;

    public class IntegerCompareExample {
        public static void main(String[] args) {
            Integer obj1 = 100;
            Integer obj2 = 100;
            Integer obj3 = 300;
            Integer obj4 = 300;

            System.out.println(obj1 == obj2);	// 제한범위 -128~127에서는 포장객체도 값으로 비교한다.
            System.out.println(obj3.equals(obj4));	// 객체의 값만 비교
        }
    }
    ```

### 13. Math 클래스

- Math.ceil(5.3) : 6.0
- Math.floor(5.3) : 5.0
- Math.max(5.3, 2.5) : 5.3
- Math.round(5.7) : 6.0 (x) -> 실수형이 아닌 정수형 리턴

### 14. 난수

- Math.random() 메소드는 0.0<= ~ <1.0 사이의 실수 난수를 리턴한다.
- Random의 nextDouble() 메소드는 0.0<= ~ < 1.0 사이의 실수 난수를 리턴한다.
- Random의 nextInt() 메소드는 int 타입의 허용 범위에서 난수를 리턴한다.
- Random의 nextInt(int n) 메소드는 0<= ~ <=n 사이의 정수 난수를 리턴한다. (x) -> n은 포함하지 않는다.

### 15. 올해 12월 31일까지 몇 일이 남았는지 구하는 코드

    ```java
    package javaChap12.exercise15;

    import java.time.LocalDateTime;
    import java.time.temporal.ChronoUnit;

    public class Main {
        public static void main(String[] args) {
            LocalDateTime startDate = LocalDateTime.now();
            LocalDateTime endDate = LocalDateTime.of(2023, 12, 31, 0, 0, 0);

            long remainDays = startDate.until(endDate, ChronoUnit.DAYS);

            System.out.println("남은 일수 : " + remainDays);

        }
    }
    ```

### 16. SimpleDateFormat

    ```java
    package javaChap12.exercise16;

    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class SimpleDateFormatExample {
        public static void main(String[] args) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
            System.out.println(sdf.format(date));
        }
    }
    ```

### 17. 정규표현식

    ```java
    package javaChap12.exercise17;

    import java.util.regex.Pattern;

    public class PatternMatcherExmaple {
        public static void main(String[] args) {
            // id 조건 = 첫번째는 알파벳, 두번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID값(대소문자구분x)
            String id = "5Angel1004";
            String regExp = "[a-zA-Z]\\w{7,11}";
            boolean isMatch = Pattern.matches(regExp, id);
            if (isMatch) {
                System.out.println("ID로 사용할 수 있습니다.");
            } else {
                System.out.println("ID로 사용할 수 없습니다.");
            }
        }
    }
    ```

### 18. Class 객체

- Class.forName() 메소드 또는 객체의 getClass() 메소드로 얻을 수 있다.
- 패키지와 클래스 이름을 알 수 있다.
- 클래스의 생성자, 필드, 메소드에 대한 정보를 알아낼 수 있다.
- getResource() 메소드는 프로젝트 경로를 기준으로 리소스의 URL을 리턴한다. (x) -> 클래스파일의 경로를 기준으로 상대경로

### 19. 어노테이션(Annotation)

- 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 역할을 한다.
- 클래스, 필드, 생성자, 메소드를 선언하기 전에 @어노테이션을 붙일 수 있다.
- @어노테이션("*")일 경우 value 속성값이 *가 된다.
- @어노테이션("\*", prop = 3)일 경우 value 속성값은 \*, prop 속성값은 3이 된다. (x) -> value 속성과 동시에 다른 속성을 적용하고 싶으면 value = 을 생략할 수 없다.
