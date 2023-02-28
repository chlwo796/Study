2023년 2월 26일 일요일

---

## chap.12 java.base module

### 7. 수학 클래스

- Math 클래스는 수학 계산에 사용할 수 있는 메소드를 제공하며, 모두 정적메소드 이므로 Math클래스로 바로 사용이 가능하다.
- Math 클래스의 주요 메소드

  ```java
  // 절대값
  int v1 = Math.abs(-5);
  double v2 = Math.abs(-3.14);

  // 올림값
  double v3 = Math.ceil(5.3);
  double v4 = Math.ceil(-5.3);

  // 버림값
  double v5 = Math.floor(5.3);
  double v6 = Math.floor(-5.3);

  // 최대값
  int v7 = Math.max(5, 9);
  double v8 = Math.max(5.3, 2.8);

  // 최소값
  int v9 = Math.min(5, 9);
  double v10 = Math.min(5.3, 2.5);

  // 랜덤값
  double v11 = Math.random();

  // 반올림값
  long v12 = Math.round(5.3);
  long v13 = Math.round(5.7);
  ```

- MathExample 예제

  ```java
  package javaChap12.example05;

  public class MathExample {
      public static void main(String[] args) {

          double v1 = Math.ceil(5.3);
          double v2 = Math.floor(5.3);
          System.out.println(v1);
          System.out.println(v2);

          // 최대값
          double v3 = Math.max(3, 8);
          double v4 = Math.min(3, 8);
          System.out.println(v3);
          System.out.println(v4);

          double v5 = 12.7849;
          double temp1 = v5 *100;
          double temp2 = Math.round(temp1);
          double result = temp2/100.0;
          System.out.println(result);
      }
  }
  ```

- `random()` 메소드는 0.0과 1.1사이의 double 타입 난수를 리턴한다.
  `int num = (int) (Math.random()*n) + start;`
- java.util.Random 클래스를 이용하는 방법
  - `Random()` : 현재 시간을 이요해서 종자값을 자동 설정한다
  - `Random(long seed)` : 주어진 종자값을 사용한다.
- 종자값(seed) : 난수를 만드는 알고리즘에 사용되는 값으로, 종자값이 같으면 같은 난수를 얻는다.
- Random 클래스의 주요 메소드

  - `boolean nextBoolean()` : boolean 타입의 난수를 리턴
  - `double nextDouble()` : double 타입의 난수를 리턴(0.0<= ~ < 1.0)
  - `int nextInt()` : int 타입의 난수를 리턴(-2^32<= ~ <=2^32-1)
  - `int nextInt(int n)` : int 타입의 난수를 리턴(0<= ~ < n)

- RandomExample 예제

  ```java
  package javaChap12.example05;

  import java.util.Arrays;
  import java.util.Random;

  public class RandomExample {
      public static void main(String[] args) {
          int[] selectNumber = new int[6];
          Random random = new Random(3);
          System.out.print("선택번호 : ");

          for(int i = 0;i<selectNumber.length;i++) {
              selectNumber[i] = random.nextInt(45) + 1;
              System.out.print(selectNumber[i] + " ");
          }
          System.out.println();

          int[] winningNumber = new int[6];
          // 종자값을 다르게 하여 선택번호와 당첨번호는 각각 다르게 나온다.
          random = new Random(5);
          System.out.print("당첨번호 : ");

          for(int i = 0;i<winningNumber.length;i++) {
              winningNumber[i] = random.nextInt(45) + 1;
              System.out.print(winningNumber[i] + " ");
          }
          System.out.println();

          Arrays.sort(selectNumber);
          Arrays.sort(winningNumber);
          boolean result = Arrays.equals(selectNumber, winningNumber);
          System.out.print("당첨 여부 : ");
          if(result) {
              System.out.println("1등에 당첨되셨습니다.");
          }else {
              System.out.println("당첨되지 않았습니다.");
          }
      }
  }
  ```

### 8. 날짜와 시간 클래스

- 자바는 컴퓨터의 날짜 및 시각을 읽을 수 있도록 java.util 패키지에서 Date와 Calendar 클래스를 제공한다.
- 날짜와 시간을 조작할 수 있도록 java.time 패키지에서 LocalDateTime 등의 클래스를 제공한다.
- Date 클래스 : 날짜 정보를 전달하기 위해 사용
- Calendar 다양한 시간대별로 날짜와 시간을 얻을 때 사용
- LocalDateTime : 날짜와 시간을 조작할 때 사용

1. Date 클래스

- Date는 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고 받을 때 사용되며, Date 클래스에는 여러 개의 생성자가 선언되어 있지만, 대부분 Deprecated(더 이상 사용되지 않음)되어 `Date()` 기본 생성자만 주로 사용된다.
- Date() 생성자는 컴퓨터의 현재 날짜를 읽어 Date 객체로 만든다.

  `Date now = new Date();`

- 현재 날짜를 문자열로 얻고 싶다면 `toString()` 메소드를 사용할 수 있지만, 영문으로 출력되기 때문에 원하는 형식으로 출력하고 싶다면, `SimpleDateFormat` 클래스와 함께 사용해야 한다.

- DateExample 예제

  ```java
  package javaChap12.example06;

  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class DateExample {
      public static void main(String[] args) {
          Date now = new Date();
          String now1 = now.toString();
          System.out.println(now1);
          System.out.println(now);

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
          String now2 = sdf.format(now);
          System.out.println(now2);
      }
  }
  ```

2. Calendar 클래스

- Calendar 클래스는 달력을 표현하는 추상 클래스이며, Calendar 클래스의 정적 메소드인 `getInstance()` 메소드를 이용하면 컴퓨터에 설정되어 있는 시간대(TimeZone)을 기준으로 Calendar 하위 객체를 얻을 수 있다.

  `Calendar now = Calendar.getInstance();`

- Calendar가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서는 `get()`메소드를 이용하고, `get()` 메소드의 매개값으로 Calendar에 정의된 상수를 주면 상수가 의미하는 값을 리턴한다.

  ```java
  int year = now.get(Calendar.YEAR);1   // 년도를 리턴
  int month = now.get(Calendar.MONTH) + 1;  // 월(0~11)을 리턴
  int day = now.get(Calendar.DAY_OF_MONTH); // 일을 리턴
  int week = now.get(Calendar.DAY_OF_WEEK); // 요일을 리턴
  int amPm = now.get(Calendar.AM_PM);   // 오전/오후를 리턴
  int hour = now.get(Calendar.HOUR);    // 시를 리턴
  int minute = now.get(Calendar.MINUTE);    // 분을 리턴
  int second = now.get(Calendar.SECOND);    // 초를 리턴
  ```

- CalendarExample 예제

  ```java
  package javaChap12.example06;

  import java.util.Calendar;

  public class CalendarExample {
      public static void main(String[] args) {
          Calendar now = Calendar.getInstance();

          int year = now.get(Calendar.YEAR);
          int month = now.get(Calendar.MONTH) + 1;
          int day = now.get(Calendar.DAY_OF_MONTH);
          int week = now.get(Calendar.DAY_OF_WEEK);

          String strWeek = null;

          switch (week) {
          case Calendar.MONDAY: {
              strWeek = "월";
              break;
          }
          case Calendar.TUESDAY: {
              strWeek = "화";
              break;
          }
          case Calendar.WEDNESDAY: {
              strWeek = "수";
              break;
          }
          case Calendar.THURSDAY: {
              strWeek = "목";
              break;
          }
          case Calendar.FRIDAY: {
              strWeek = "금";
              break;
          }
          case Calendar.SATURDAY: {
              strWeek = "토";
              break;
          }
          default: {
              strWeek = "일";
          }

          }//end switch
          int amPm = now.get(Calendar.AM_PM);
          String strAmPm = null;
          if(amPm == Calendar.AM) {
              strAmPm = "오전";
          }else {
              strAmPm = "오후";
          }
          int hour = now.get(Calendar.HOUR);
          int minute = now.get(Calendar.MINUTE);
          int second = now.get(Calendar.SECOND);

          System.out.println(year + "년");
          System.out.println(month + "월");
          System.out.println(day + "일");
          System.out.println(strWeek + "요일");
          System.out.println(strAmPm);
          System.out.println(hour + "시");
          System.out.println(minute + "분");
          System.out.println(second + "초");
      }
  }
  ```

- 알고 싶은 시간대의 TimeZone 객체를 얻어, `getInstance()` 메소드의 매개값으로 넘겨주면, 미국/로스앤젤레스와 같은 다른 시간대의 Calendar를 얻을 수 있다.

  ```java
  Timezone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
  Calendar now = Calendar.getInstance(timeZone);
  ```

- LosAngelesExample 예제

  ```java
  package javaChap12.example06;

  import java.util.Calendar;
  import java.util.TimeZone;

  public class LosAngelesExample {
      public static void main(String[] args) {
          TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
          Calendar now = Calendar.getInstance(timeZone);

          int amPm = now.get(Calendar.AM);
          String strAmPm = null;
          if (amPm == Calendar.AM) {
              strAmPm = "오전";
          } else {
              strAmPm = "오후";
          }
          int hour = now.get(Calendar.HOUR);
          int minute = now.get(Calendar.MINUTE);
          int second = now.get(Calendar.SECOND);

          System.out.println(strAmPm);
          System.out.println(hour + "시");
          System.out.println(minute + "분");
          System.out.println(second + "초");

      }
  }
  ```

- PrintTimeZoneID 예제

  ```java
  package javaChap12.example06;

  import java.util.TimeZone;

  public class PrintTimeZoneID {
      public static void main(String[] args) {
          String[] availableIDs = TimeZone.getAvailableIDs();
          for(String id : availableIDs) {
              System.out.println(id);
          }
      }
  }
  ```

3. 날짜와 시간 조작

- Date와 Calendar는 날짜와 시간 정보를 얻기에는 충분하지만, 날짜와 시간을 조작할 수는 없다.
- java.time 패키지의 LocalDateTime 클래스가 제공하는 메소드를 이용하면 쉽게 날짜와 시간을 조작할 수 있다.
  - `minusYears(long)` : 년 빼기
  - `minusMonths(long)` : 월 빼기
  - `minusDays(long)` : 일 빼기
  - `minusWeeks(long)` : 주 빼기
  - `plusYears(long)` : 년 더하기
  - `plussMonths(long)` : 월 더하기
  - `plusWeeks(long)` : 주 더하기
  - `plussDays(long)` : 일 더하기
  - `minusHours(long)` : 시간 빼기
  - `minusMinutes(long)` : 분 빼기
  - `minusSeconds(long)` : 초 빼기
  - `minusNanos(long)` : 나노초 빼기
  - `plusHours(long)` : 시간 더하기
  - `plusMinutes(long)` : 분 더하기
  - `plusSeconds(long)` : 초 더하기
- LocalDataTime 클래스를 이용해서 현재 컴퓨터의 날짜와 시간을 얻는 방법

  `LocalDateTime now = LocalDateTime.now();`

- DateTimeOperationExample 예제

  ```java
  package javaChap12.example06;

  import java.time.LocalDateTime;
  import java.time.format.DateTimeFormatter;

  public class DateTimeOperationExample {
      public static void main(String[] args) {
          LocalDateTime now = LocalDateTime.now();
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
          System.out.println(now.format(dtf));

          LocalDateTime result1 = now.plusYears(1);
          System.out.println("1년 더하기 : " + result1.format(dtf));

          LocalDateTime result2 = now.minusHours(1);
          System.out.println("1시간 빼기 : " + result2.format(dtf));

          LocalDateTime result3 = now.plusDays(6);
          System.out.println("6일 더하기 : " + result3.format(dtf));
      }
  }
  ```

4. 날짜와 시간 비교

- LocalDateTime 클래스는 날짜와 시간을 비교할 수 있는 메소드도 제공한다.

  - `boolean isAfter(other)` : 이후 날짜인지
  - `boolean isBefore(other)` : 이전 날짜인지
  - `boolean isEqual(other)` : 동일 날짜인지
  - `long until(other, unit)` : 주어진 단위(unit) 차이를 리턴

- 특정 날짜와 시간으로 LocalDateTime 객체를 얻는 방법
  `LocalDateTime target = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);`

- DateTimeCompareExample 예제

  ```java
  package javaChap12.example06;

  import java.time.LocalDateTime;
  import java.time.format.DateTimeFormatter;
  import java.time.temporal.ChronoUnit;

  public class DateTimeCompareExample {
      public static void main(String[] args) {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

          LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

          System.out.println("시작일 : " + startDateTime.format(dtf));

          LocalDateTime endDateTime = LocalDateTime.of(2023, 12, 31, 0, 0, 0);

          System.out.println("종료일 : " + endDateTime.format(dtf));

          if(startDateTime.isBefore(endDateTime)) {
              System.out.println("진행중입니다.");
          }else if(startDateTime.isEqual(endDateTime)) {
              System.out.println("종료합니다.");
          }else if(startDateTime.isAfter(endDateTime)) {
              System.out.println("종료했습니다.");
          }
          long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
          long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
          long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
          long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
          long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
          long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);

          System.out.println("남은 해 : " + remainYear);
          System.out.println("남은 월 : " + remainMonth);
          System.out.println("남은 일 : " + remainDay);
          System.out.println("남은 시간 : " + remainHour);
          System.out.println("남은 분 : " + remainMinute);
          System.out.println("남은 초 : " + remainSecond);
      }
  }
  ```

### 9. 형식 클래스

- Format(형식) 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공한다.
- Format 주요 클래스
  - `DecimalFormat` : 숫자를 형식화된 문자열로 변환
  - `SimpleDateFormat` : 날짜를 형식화된 문자열로 변환

1. DecimalFormat

- DecimalFormat은 숫자를 형식화된 문자열로 변환하는 기능을 제공하며, 다음과 같은 패턴을 사용한다.

  ![](https://mblogthumb-phinf.pstatic.net/20160107_271/rain483_1452157680736vtAjv_PNG/1.PNG?type=w2)

- 패턴 정보와 함께 DecimalFormat 객체를 생성하고 `format()` 메소드로 숫자를 제공하면 패턴에 따른 형식화된 문자열을 얻을 수 있다.

  ```java
  DecimalFormat df = new DecimalFormat("#,###.0");
  String result = df.format(1234567.89);
  ```

- DecimalFormatExample 예제

  ```java
  package javaChap12.example07;

  import java.text.DecimalFormat;

  public class DecimalFormatExample {
    public static void main(String[] args) {
      double num = 1234567.89;

      DecimalFormat df;

      df = new DecimalFormat("#,###");
      System.out.println(df.format(num));

      df = new DecimalFormat("#,###.00");
      System.out.println(df.format(num));
    }
  }
  ```

1. SimpleDateFormat

- SimpleDateFormat은 날짜를 형식화된 문자열로 변환하는 기능을 제공하며, 다음과 같은 패턴을 사용한다.

  ![](https://mblogthumb-phinf.pstatic.net/20160107_61/rain483_14521583552198iIfo_PNG/3.PNG?type=w2)

- 패턴에는 자리수에 맞게 기호를 반복해서 작성할 수 있으며, 패턴 정보와 함께 SimpleDateFormat 객체를 생성하고 `format()` 메소드로 날자를 제공하면 패턴과 동일한 문자열을 얻을 수 있다.

  ```java
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
  String strDate = sdf.format(new Date());
  ```

- SimpleDateFormatExample 예제

  ```java
  package javaChap12.example07;

  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class SimpleDateFormatExample {
    public static void main(String[] args) {
      Date now = new Date();

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
      System.out.println(sdf.format(now));

      sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
      System.out.println(sdf.format(now));

      sdf = new SimpleDateFormat("오늘은 E요일");
      System.out.println(sdf.format(now));
      // D = 월 구분이 없는 일(1~365)
      sdf = new SimpleDateFormat("올해의 D번째 날");
      System.out.println(sdf.format(now));

      sdf = new SimpleDateFormat("오늘은 M월의 W번재 주");
      System.out.println(sdf.format(now));
    }
  }
  ```

### 10. 정규 표현식 클래스

- 정규표현식(Regular Expression)을 이용해서 문자열이 올바르게 구성되어 있는지 검증한다.

1. 정규 표현식 작성 방법

- 정규 표현식은 문자 또는 숫자와 관련된 표현과 반복 기호가 결합된 문자열이다.

  ![](https://velog.velcdn.com/images%2Fcyhse7%2Fpost%2Fd0c4861d-d7e9-4080-ba17-6cee4738a424%2Fimage.png)

- 02-123-1234, 010-1234-5678 의 정규표현식

  `(02|010)-\d{3,4}-\d{4}`

- white@naver.com 의 정규표현식

  `\w+@\w+\.\w+(\.\w+)?`

2. Pattern 클래스로 검증

- java.util.regex 패키지의 Pattern 클래스는 정규 표현식으로 문자열을 검증하는 `matches()` 메소드를 제공한다.
  `boolean result = Pattern.matches("정규식", "검증할 문자열");`

- PatternExample 예제

  ```java
  package javaChap12.example08;

  import java.util.regex.Pattern;

  public class PatternExample {
    public static void main(String[] args) {
      String regExp = "(02|010)-\\d{3,4}-\\d{4}";
      String data = "010-4116-0586";
      boolean result = Pattern.matches(regExp, data);
      if(result) {
        System.out.println("일치");
      }else {
        System.out.println("불일치");
      }
      regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
      data = "chlwo796@naver.com";
      result = Pattern.matches(regExp, data);
      if(result) {
        System.out.println("이메일일치");
      }else {
        System.out.println("불일치");
      }
    }
  }
  ```

### 11. 리플렉션

- 자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다.
- 메타정보 : 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메소드) 정보 등
- 리플렉션(reflection) : 메타 정보를 프로그램에서 읽고 수정하는 행위

  ```java
  Class clazz = String.class; // 클래스로부터 얻는 방법
  Class clazz = Class.forName("java.lang.String");
  String str = "김자바";
  Class clazz = str.getClass();  // 객체로부터 얻는 방법
  ```

1. 패키지와 타입 정보 얻기

- 패키지와 타입(클래스, 인터페이스) 이름 정보를 얻는 메소드

  - `Package getPackage()` : 패키지 정보 읽기
  - `String getSimpleName()` : 패키지를 제외한 타입 이름
  - `String getName()` : 패키지를 포함한 전체 타입 이름

- GetClassExample 예제

  ```java
  package javaChap12.example09;

  public class GetClassExample {
    public static void main(String[] args) throws ClassNotFoundException {
      Class clazz1 = Car.class;
      Class clazz2 = Class.forName("javaChap12.example09.Car");
      Car car = new Car();
      Class clazz3 = car.getClass();

      System.out.println(clazz1.getPackageName());
      System.out.println(clazz2.getSimpleName());
      System.out.println(clazz3.getName());
      System.out.println(clazz1);
      System.out.println(clazz2);
      System.out.println(clazz3);
    }
  }

  class Car {

  }
  ```

2. 멤버 정보 얻기

- 타입(클래스, 인터페이스)가 가지고 있는 멤버 정보를 얻는 메소드

  - `Constructor[] getDeclaredConstructors()` : 생성자 정보 읽기
  - `Field[] getDeclaredFields()` : 필드 정보 읽기
  - `Method[] getDeclaredMethods()` : 메소드 정보 읽기

- Constructor, Field, Method 클래스는 전부 java.lang.reflect 패키지에 있는데, 각각 생성자, 필드, 메소드에 대한 선언부 정보를 제공한다.
- ReflectionExample 예제

  ```java
  package javaChap12.example09;

  import java.lang.reflect.Constructor;
  import java.lang.reflect.Field;
  import java.lang.reflect.Method;

  public class ReflectionExample {
    public static void main(String[] args) {
      Class clazz = Car1.class;
      Constructor[] constructors = clazz.getDeclaredConstructors();
      for (Constructor constructor : constructors) {
        System.out.print(constructor.getName() + "(");
        Class[] parameters = constructor.getParameterTypes();
        printParameters(parameters);
        System.out.println(")");
      }
      System.out.println();
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        System.out.println(field.getType().getName() + " " + field.getName());
      }
      System.out.println();
      Method[] methods = clazz.getDeclaredMethods();
      for (Method method : methods) {
        System.out.print(method.getName() + "(");
        Class[] parameters = method.getParameterTypes();
        printParameters(parameters);
        System.out.println(")");
      }
      System.out.println();
    }

    private static void printParameters(Class[] parameters) {
      for (int i = 0; i < parameters.length; i++) {
        System.out.print(parameters[i].getName());
        if (i < parameters.length - 1) {
          System.out.print(",");
        }
      }
    }
  }

  class Car1 {
    private String model;
    private String owner;

    public Car1(String model) {
      super();
      this.model = model;
    }

    public Car1() {
      // TODO Auto-generated constructor stub
    }

    public String getModel() {
      return model;
    }

    public void setModel(String model) {
      this.model = model;
    }

    public String getOwner() {
      return owner;
    }

    public void setOwner(String owner) {
      this.owner = owner;
    }
  }
  ```

3. 리소스 경로 얻기

- Class 객체는 클래스 파일(`.class`)의 경로 정보를 가지고 있기 때문에, 이 경로를 기준으로 상대경로에 있는 다른 리소스 파일(이미지, XML, Property 파일)의 정보를 얻을 수 있다.
  - `URL getResource(String name)` : 리소스 파일의 URL 리턴
  - `InputStream getResourceAsStream(String name)` : 리소스 파일의 InputStream 리턴
- getResource()는 경로 정보가 담긴 URL 객체를 리턴하고, getResourceAsStream()은 파일의 내용을 읽을 수 있도록 InputStream 객체를 리턴한다.
- src 폴더에 클래스파일과 함께 저장되있는 상태에서, 컴파일 후 bin 폴더로 자동으로 복사가 된다.

  ```java
  package javaChap12.example09;

  public class GetResourceExample {
    public static void main(String[] args) {
      Class clazz = Car2.class;

      String photo1Path = clazz.getResource("1.jpg").getPath();
      String photo2Path = clazz.getResource("images/2.jpg").getPath();

      System.out.println(photo1Path);
      System.out.println(photo2Path);
    }
  }

  class Car2 {

  }
  ```

### 12. 어노테이션

- 어노테이션(Annotation) : 코드에서 `@`으로 작성되는 요소이며, 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보이다.
- 어노테이션의 세가지 용도
  - 컴파일 시 사용하는 정보 전달
  - 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
  - 실행 시 특정 기능을 처리할 때 사용하는 정보 전달

1. 어노테이션 타입 정의와 적용

- 어노테이션도 하나의 타입이므로 어노테이션을 사용하기 위해서는 먼저 정의부터 해야 한다.

  ```java
  public @interface AnnotationName{
      // 이렇게 정의한 어노테이션은 @AnnotationName 으로 사용된다.
  }
  ```

- 어노테이션은 속성을 가질 수 있으며, 타입과 이름으로 구성, 이름 뒤에 괄호를 붙인다.

  ```java
  public @interface AnnotationName{
    String prop1();
    int prop2 default 1;  // 속성의 기본값은 default 키워드로 지정할 수 있다.

    // 이렇게 선언된 어노테이션은 다음과 같이 사용한다.
    // @AnnotationName(prop1 = "값"); // prop2는 기본값이 있기 때문에 생략 가능하다.
    // @AnnotationName(prop1 = "값", prop2 = 3);
  }
  ```

- 어노테이션은 기본 속성인 value를 가질 수 있다.

  ```java
  public @interface Annotation{
    String value();
    int prop2 default 1;

    // value 속성을 가진 어노테이션은 코드에서 다음과 같이 값만 기술할 수 있다.
    // @Annotation("값");
    // value 속성과 다른 속성의 값을 동시에 주고 싶으면 value 속성 이름을 반드시 언급해야한다.
    // @Annotation(value = "값", prop2 = 3);
  }
  ```

2. 어노테이션 적용 대상

- 어노테이션은 설정 정보이며, 어떤 대상에 설정 정보를 적용할 것인지 명시해야한다.
- ElementType 열거상수로 정의되어있는 적용 대상의 종류

  - `TYPE` : 클래스, 인터페이스, 열거타입
  - `ANNOTATION_TYPE` : 어노테이션
  - `FIELD` : 필드
  - `CONSTRUCTOR` : 생성자
  - `METHOD` : 메소드
  - `LOCAL_VARIABLE` : 로컬 변수
  - `PACKAGE` : 패키지

- `@Target` : 적용 대상을 지정할 때 사용, 기본 속성인 value는 ElementType 배열을 값으로 가진다.

```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
// 클래스, 필드, 메소드 적용대상
public @interface AnnotationName{

}
@AnnotationName
public class ClassName{
  @AnnotationName
  private String fieldName;

  @AnnotationName
  public void methodName(){

  }
  @AnnotationName
  public ClassName(){
    // 생성자에는 적용할 수 없다. @Target에서 지정하지 않았다.
  }
}
```
