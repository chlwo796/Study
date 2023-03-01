2023년 3월 1일 수요일

---

## chap.12 java.base module3

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

3. 어노테이션 유지 정책

- 어노테이션 유지 정책 : @AnnotationName을 언제까지 유지할 것인지를 지정하는 것
- RetentionPolicy 열거 상수로 정의된 유지정책

  - `SOURCE`
    - 적용 시점 : 컴파일 할 때 적용
    - 제거 시점 : 컴파일 된 후에 제거
  - `CLASS`
    - 적용 시점 : 메모리로 로딩할 때 적용
    - 제거 시점 : 메모리로 로딩된 후 제거
  - `RUNTIME`
    - 적용 시점 : 실행할 때 적용
    - 제거 시점 : 계속 유지

- `@Retention` : 유지 정책을 지정할 때 사용하며, 기본 속석인 value는 RetentionPolicy 열거 상수 값을 가진다.

  ```java
  @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface AnnotationName{
    // RetentionPolicy.RUNTIME 으로 적용하여 실행할 때 적용
  }
  ```

4. 어노테이션 설정 정보 이용

- 어노테이션은 아무런 동작을 가지지 않는 설정 정보일 뿐이며, 어떻게 처리할 것인지는 애플리케이션의 몫이다.
- 리플렉션을 이용해서 적용 대상으로부터 어노테이션의 정보를 얻어낼 수 있다.

  - `boolean isAnnotationPresent(AnnotationName.class)` : 지정한 어노테이션이 적용되었는지 여부
  - `Annotation getAnnotation(AnnotationName.class)` : 지정한 어노테이션이 적용되어 있으면 어노테이션을 리턴하고, 그렇지 않다면 null을 리턴
  - `Annotation[] getDeclaredAnnotations()` : 적용된 모든 어노테이션을 리턴

- PrintAnnotationExample 예제

  ```java
  package javaChap12.example10;

  import java.lang.annotation.ElementType;
  import java.lang.annotation.Retention;
  import java.lang.annotation.RetentionPolicy;
  import java.lang.annotation.Target;

  @Target({ ElementType.METHOD })	// 메소드를 타겟으로
  @Retention(RetentionPolicy.RUNTIME)	// 실행할 때 적용
  public @interface PrintAnnotation {
    String value() default "-";	// value속성

    int number() default 15;	// number속성

  }
  ```

  ```java
  package javaChap12.example10;

  public class Service {
    @PrintAnnotation	// default 속성대로 적용
    public void method1() {
      System.out.println("실행내용1");
    }

    @PrintAnnotation("*")	// value에 값만 적용 = value 생략가능
    public void method2() {
      System.out.println("실행내용2");
    }

    @PrintAnnotation(value = "#", number = 20)	// number 속성도 변경 = value 생략불가
    public void method3() {
      System.out.println("실행내용3");
    }
  }
  ```

  ```java
  package javaChap12.example10;

  import java.lang.reflect.InvocationTargetException;
  import java.lang.reflect.Method;

  public class PrintAnnotationExample {
    public static void main(String[] args)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Method[] declaredMethods = Service.class.getDeclaredMethods();
      for (Method method : declaredMethods) {
        PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
        printLine(printAnnotation);
        // Service에 있는 선언된 메소드 모두 호출
        method.invoke(new Service());

        printLine(printAnnotation);
      }
    }

    public static void printLine(PrintAnnotation printAnnotation) {
      if (printAnnotation != null) {
        int number = printAnnotation.number();
        for (int i = 0; i < number; i++) {
          String value = printAnnotation.value();
          System.out.print(value);
        }
        System.out.println();
      }
    }
  }
  ```
