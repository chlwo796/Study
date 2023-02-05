2023년 2월 5일 일요일

---

## chap.07 inheritance

### 1. 상속 개념

- 현실에서 상속은 부모가 자식에게 물려주는 행위이다.
- 객체지향프로그램에서의 상속은 부모클래스의 멤버를 자식 클래스에게 물려 줄 수 있다.
- 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것이다.
- 상속을 통해서 클래스를 작성하면 보다 적은 양의 코드로 새로운 클래스를 작성할 수 있고, 코드를 공통적으로 관리할 수 있기 때문에 코드의 추가 및 변경이 매우 용이하다.

1. 상속 특징

   - 코드의 재사용성을 높인다
   - 코드의 중복을 제거하여 프로그램의 생산성과 유지 보수에 크게 기여한다.

   ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMTZfMjkg/MDAxNjA1NTEzOTEyNTYx.9FU3X07F9_YBLT5YZ7EX6ujYiamCeORNQjjd6_2SbqYg.A4_ekZWSygCyRDxmhm0N_R2ZKkUZulfJh8A6tB2_ubkg.PNG/%E3%85%811.png?type=w1600)

2. 용어

   - 조상클래스 : 부모(parent)클래스, 상위(super)클래스, 기반(base)클래스
   - 자손클래스 : 자식(child)클래스, 하위(sub)클래스, 파생(derived)클래스

### 2. 클래스 상속

- 현실에서 상속은 부모가 자식을 선택해서 물려주지만, 프로그램에서 상속은 자식이 부모를 선택한다.
- 자식클래스를 선언할 때 어떤 부모클래스를 상속받을 것인지를 결정하고 선택된 부모 클래스는 extends 뒤에 기술한다.
- 생성자와 초기화 블록은 상속되지 않고, 멤버만 상속된다.
- 자손클래스의 멤버개수는 조상클래스보다 항상 같거나 많다.

1. 형식

   ```java
   class ChildClass extends ParentsClass{

   }

   class A extends B{
       // A(자식클래스)는 B(부모클래스)를 상속한다.
   }
   ```

2. 특징

   - 자바는 단일상속밖에 되지 않는다.
   - 하나의 자식클래스에 여러 부모클래스를 둘 수 없다.

### 3. 클래스간의 관계

- 클래스를 재사용하기 위해서는 클래스끼리 관계를 맺어주어야 한다.

1. 포함관계(has ~a)

   - 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것
   - `import`, `new` 등의 연산자로 관계맺기
   - `~은 ~을 가지고 있다.` 라고 문장을 만들어서 의미가 맞으면 포함관계로 관계 맺는다.
   - `원은 점을 가지고 있다.` `자동차는 바퀴를 가지고 있다.`

2. 상속관계(is ~a)

   - 상속(is ~a) 관계를 만드려면 `자식클래스 is a 부모클래스이다`가 성립되어야 한다.
   - `고양이 is a 동물이다.` `강아지 is a 동물이다.`
   - 상속관계를 만들기 위해서는 부모 클래스가 자식 클래스의 공통점을 가지고 있어야 한다.

### 4. 부모생성자 호출(super)

- 자식 객체를 생성하면, 부모 객체가 먼저 생성되고 자식 객체가 그 다음에 생성된다.
- 자식클래스의 기본생성자에 `super();`가 생략이 되어 자동컴파일된다.
  ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMTdfMTA0/MDAxNjA1NjIwNjUzMDk1.SGhuMaftI5KUDODyqg6XDOst1w2LszRCkE6wQnx-SoQg.RY2tjhDNSpbdxGdKynvaKU0iTmakuC598kTy0xQm34Yg.PNG/a1.PNG?type=w1600)

  ```java
  public class B {
      public B() {
          // 부모의 기본생성자
          System.out.println("부모의 기본생성자");
      }
  }
  public class A extends B { // A 클래스는 B 클래스를 부모로 한다.
      public A() {
  //		자식클래스 A의 기본생성자
  //		super(); // 명시하지 않아도 자동으로 컴파일한다.
          System.out.println("자식의 기본생성자");
      }
  }
  public class Main {
      public static void main(String[] args) {
          A a = new A(); // 자식클래스를 객체화한다.
      }
  }
  ```

- `super`의 용도

  1. `super.a` 부모인스턴스 멤버를 가르킨다.
  2. `super(); super(a,b);` 부모생성자를 호출할 수 있다.
  3. `super.methodA();` 자식이 부모메소드를 overriding 한 경우에, 부모 메소드만을 호출할 수 있다.

  ```java
  public class B {
      int a = 10;

      public B() {
          // 부모의 기본생성자
          System.out.println("부모의 기본생성자");
          a = a + 10;
      }
  }
  public class A extends B { // A 클래스는 B 클래스를 부모로 한다.
      public A() {
  //		자식클래스 A의 기본생성자
  //		super(); // 명시하지 않아도 자동으로 컴파일한다.
          System.out.println("자식의 기본생성자");
          System.out.println(super.a);
      }

      void methodA() {
          System.out.println(this.a);	// 자식은 부모의 멤버를 공유한다.
          System.out.println(super.a);
          System.out.println(a);
          a = a + 10;
          System.out.println(this.a);	// 자식메소드에서 값을 변경하더라도 부모의 값도 같이 바뀐다.
          System.out.println(super.a);
          System.out.println(a);

      }
  }
  public class Main {
      public static void main(String[] args) {
          A a = new A(); // 자식클래스를 객체화한다.
          a.methodA();
      }
  }
  ```

### 5. object class

- 모든 클래스의 상속계층도의 최상위에 있는 조상클래스이다.
- 다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로 object클래스로부터 상속 받게 한다.
- `toString()과 equals()` 와 같은 메소드를 따로 정의하지 않아도 쓸 수 있었던 이유이다.

### 6. 메소드 재정의(override)

- override의 사전적 의미는 `~위에 덮어쓰기` 이다.
- 부모클래스의 특정 메소드를 그대로 자식클래스가 사용하기에 적합하지 않을 경우에, 일부 메소드는 자식 클래스에서 다시 수정,보완하여 사용해야 한다.

1. 메소드 재정의

   - 자식클래스에서 부모의 동일한 메소드를 재정의하는 것을 말한다.
   - 메소드가 오버라이딩이 되었다면 부모객체의 메소드는 숨겨지기 때문에, 자식 객체에서 메소드를 호출하면 오버라이딩된 자식메소드가 호출된다.

2. 메소드 오버라이딩의 규칙

   - 부모의 메소드와 자식 메소드가 동일한 리턴타입, 메소드이름, 매개변수리스트를 가져야 한다.
   - 접근제어자를 조상 클래스의 메소드보다 좁은 범위로 변경할 수 없다.
   - 예외는 조상클래스의 메소드보다 많이 선언할 수 없다.
   - 인스턴스 메소드를 static 메소드로 또는 그 반대로 변경할 수 없다.

   ```java
   public class B {
       int x, y;

       String methodB(int x, int y) {
           return "x: " + x + ", y: " + y;
       }
   }
   public class A extends B {
       int z;

       @Override
       String methodB(int x, int y) {   // 동일한 리턴타입, 이름, 매개변수로 overriding
           z = 5;// 자식의 추가적인 필드멤버는 메소드 내부, 생성자, 필드, 블록을 통하여 초기화한다.(메소드 매개변수 추가x)
           return "x: " + x + ", y: " + y + ",z :" + z;
       }
   }
   public class Main {
       public static void main(String[] args) {
           A a = new A(); // 자식클래스를 객체화한다.
           System.out.println(a.methodB(1, 2));
       }
   }
   ```

### 7. final 클래스와 메소드

- `final` 키워드는 클래스, 필드, 메소드 선언 시에 사용할 수 있다.
- `final`은 해당 선언이 최종 상태이고, 결코 수정될 수 없음을 뜻한다.
- `final int a;` : 초기값 설정 후 더이상 값을 변경할 수 없다.
- `final class A{}` : 상속할 수 없는 클래스이다.
- `final void methodA(){}` : 오버라이딩 할 수 없는 메소드이다.

### 8. protected 접근제한자

- 같은 패키지의 경우, 자유롭게 객체화한 후 접근 가능하다.

```java
package tempMemo;

public class A {
	protected int a = 1;
}
package tempMemo;

public class B {
	A a = new A();

	public B() {
		a.a = 3;
		System.out.println(a.a);
	}
}
package tempMemo;

public class Main {
	public static void main(String[] args) {
		B b = new B();
	}
}
```

- 다른패키지라 할 지라도, 상속관계라면 `import` 후 protected 멤버필드에 접근할 수 있다.

```java
package tempMemo1;

import tempMemo.A;

public class C extends A {

	public C() {
		super.a = 5;
		System.out.println(super.a);
	}
}
```
