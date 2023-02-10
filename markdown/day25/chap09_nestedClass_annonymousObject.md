2023년 2월 6일 월요일

---

## chap.09 nestedClass & annonymousObject

### 1. 중첩 클래스와 중첩 인터페이스

- 특정 클래스와 관계를 맺을 경우에는 관계 클래스를 내부에 선언하는 것이 좋다.
- 중첩클래스(nested class)란 클래스 내부에 선언한 클래스를 말하는 데 중첩 클래스를 사용하면 두 클래스의 멤버들을 서로 쉽게 접근할 수 있다는 장점을 가지고 있다.
- 외부에는 불필요한 관계 클래스를 감춤으로서 코드의 복잡성을 줄일 수 있다.

1. 중첩클래스 구조

   ```java
   public class A {
       class B{

       }
   }
   ```

2. 중첩 인터페이스 구조

   ```java
   public class B {
       interface C{

       }
   }
   ```

3. 이용되는 곳

- UI 프로그래밍에서 이벤트를 처리할 목적으로 사용

4. 중첩 클래스의 장점

- 내부클래스에서 외부클래스의 멤버들을 쉽게 접근할 수 있다.
- 코드의 복잡성을 줄일 수 있다.(캡슐화)

5. 내부클래스는 다른 클래스에서 잘 사용하지 않고 외부클래스에서만 주로 사용하므로 내부클래스로 만든 것이다.

   ```java
   public class A { // 외부클래스
       class B{ // 내부클래스

       }
   }
   ```

### 2. 중첩(내부) 클래스의 종류와 특징

1. 인스턴스 클래스(instance class)

- 외부 클래스의 멤버 변수 선언 위치에 선언하며, 외부 클래스의 인스턴스처럼 다루어진다.
- 주로 외부클래스의 인스턴스 멤버들과 관련된 작업에 사용될 목적으로 선언된다.

  1.  구조

      ```java
      public class A {
              class B{ // 인스턴스 클래스
              // A객체를 생성해야만 B 중첩클래스를 사용할 수 있다.
              }
          }
      ```

  2.  사용방법

  - A클래스 외부에서 인스턴스 멤버클래스 B의 객체를 생성하려면, 먼저 A객체를 생성하고 B의 객체를 생성한다.

    ```java
    public class A {
        int fieldA;

        class B {
            int fieldB;

            void methodB() {
                fieldA = fieldA + 3; // 내부클래스에서 외부클래스 인스턴스변수 접근가능
                System.out.println("fieldA : " + fieldA);
                System.out.println("fieldB : " + fieldB);
            }
        }

        void methodA() {

        }
    }
    public class Main {
        public static void main(String[] args) {
            A a = new A();
            A.B b = a.new B();  // A객체 생성 후 B객체 생성
            b.fieldB = 5;   // B객체의 인스턴스변수 접근
            b.methodB();    // B객체의 인스턴스메소드 접근
        }
    }
    ```

2. 스태틱 클래스(static class)

- 외부 클래스의 멤버 변수 선언 위치에 선언하며, 외부 클래스의 static멤버처럼 다루어진다.
- 주로 외부 클래스의 static 멤버, 특히 static 메소드에 사용될 목적으로 선언된다.

  1. 구조

     ```java
     public class A {
            static class C{ // 스태틱 클래스

             }
         }
     ```

  2. 실행방법

     ```java
     public class C {
         static class D{
             int d;
             static int sd;
             void methodD() {

             }
             static void smethodD() {

             }
         }
     }
     public class Main {
         public static void main(String[] args) {

             C.D cd = new C.D();
             cd.methodD();
             cd.d = 3;
             C.D.sd = 2;
             C.D.smethodD();

         }
     }
     ```

3. 지역 클래스(local class)

- 외부 클래스의 메소드나 초기화 블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있다.
- 메소드 호출 시에만 사용될 수 있기 때문에, 메소드를 독점하며 정보은닉에 유리하다.

  1. 구조 및 실행

     ```java
     public class A {
         private int fieldA;

         void methodA() {
             class B {
                 int fieldB;

                 void methodB() {
                     fieldA = +1;
                     fieldA = fieldA + fieldB;
                     System.out.println(fieldA);
                 }

             }
             B b = new B();
             b.fieldB = +3;
             b.methodB();

         }
     }
     public class Main {
         public static void main(String[] args) {

             A a = new A();
             a.methodA();
         }
     }
     ```

4. 익명 클래스(anonymous class)

- 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용)

### 3. 익명클래스(anonymous clas)

1. 익명클래스는 이름이 없는 클래스이다.
   - 클래스의 선언과 객체의 생성을 동시에 하기 때문에 단 한번만 사용될 수 있고 오직 하나의 객체만을 생성할 수 있는 일회용 클래스이다.
2. 구조(`Type name = new Type(){};`)

   ```java
   package tempMemo;

   public class A {
       void methodA() {
       }
   }
   package tempMemo;

   public interface C {
       void methodC();
   }
   package tempMemo;

   public class B {
       A a = new A() {
           void methodA() {
               System.out.println("class A의 익명 자식객체");
           };
       };
       C c = new C() {
           @Override
           public void methodC() {
               System.out.println("interface C의 익명 구현객체");
           }
       };
   }
   ```

3. 특징

- 이름이 없기 때문에 생성자를 가질 수 없다.
- 조상클래스의 이름이나 구현하고자 하는 인터페이스의 이름을 사용해서 정의하기 때문에 하나의 클래스로 상속받는 동시에 인터페이스를 구현하거나 둘 이상의 인터페이스를 구현할 수 없다.
- 오로지 단 하나의 클래스를 상속받거나 단 하나의 인터페이스만을 구현할 수 있다.

4. 실행 후 생성되는 파일

`외부클래스명$number.class`
