2023년 3월 14일 화요일

## chap.07 exercises

### 1. 상속

- 자바는 다중 상속을 허용한다. (x) -> 다중상속 허용하지 않는다.
- 부모의 메소드를 자식 클래스에서 재정의(오버라이딩)할 수 있다.
- 부모의 private 접근 제한을 갖는 필드와 메소드는 상속의 대상이 아니다.
- final 클래스는 상속할 수 없고, fianl 메소드는 오버라이딩 할 수 없다.

---

### 2. 클래스 타입 변환

- 자식 객체는 부모 타입으로 자동 타입 변환된다.
- 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다. (x) -> 자식 객체가 부모 타입으로 자동 변환된 후 다시 자식 타입으로 변환할 때 강제 타입변환을 사용할 수 있다.
- 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다.
- 강제 타입 변환 전에 instanceof 연산자로 변환 가능한지 검사하는 것이 좋다.

---

### 3. final

- final 클래스는 부모 클래스로 사용할 수 있다. (x) -> final 선언된 클래스는 상속할 수 없다.
- final 필드는 초기화된 후에는 변경할 수 없다.
- final 메소드는 재정의(오버라이딩)할 수 없다.
- static final 필드는 상수를 말한다.

---

### 4. 오버라이딩(Overriding)

- 부모 메소드의 시그니처(리턴 타입, 메소드명, 매개변수)와 동일해야 한다.
- 부모 메소드보다 좁은 접근 제한자를 붙일 수 없다.(예:public (부모)->private (자식))
- @Override 어노테이션을 사용하면 재정의가 확실한지 컴파일러가 검증한다.
- protected 접근 제한을 갖는 메소드는 다른 패키지의 자식 클래스에서 재정의할 수 없다. (x) -> 상속관계면 가능하다.

---

### 5. 추상클래스

- 직접 객체를 생성할 수 없고, 상속만 할 수 있다.
- 추상 메소드를 반드시 가져야 한다.
- 추상 메소드는 자식 클래스에서 재정의(오버라이딩)할 수 있다.
- 추상 메소드를 재정의하지 않으면 자식 클래스도 추상 클래스가 되어야 한다.

---

### 6. 에러 발생 이유

```java
public class Parent{
    public String name;

    public Parent(String name){
        this.name = name;
    }
}
```

```java
public class Child extends Parent{
    public int studentNo;

    public Child(String name, int studentNo){
        // 자식객체의 생성자는 super();가 명시되어 있지않으면 부모의 기본생성자를 호출한다.
		// 1. 부모의 기본생성자 추가
		// 2. 자식생성자에 super(); 추가
		// super(name);
        this.name = name;
        this.studentNo = studentNo;
    }
}
```

---

### 7. 출력 결과

```java
package javaChap07.exercise07;

public class Parent {
    public String nation;
    public Parent() {
        this("대한민국");
        System.out.println("Parent() call");
    }
    public Parent(String nation) {
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}
```

```java
package javaChap07.exercise07;

public class Child extends Parent{
    public String name;

    public Child() {
        this("홍길동");
        System.out.println("Child() call");
    }
    public Child(String name) {
        this.name = name;
        System.out.println("Child(String name) call");
    }
}
```

```java
package javaChap07.exercise07;

public class ChildExample {
    public static void main(String[] args) {
        new Child();
    }
}
```

- 부모생성자(매개변수)->부모기본생성자->자식생성자(매개변수)->자식기본생성자

---

### 8. 출력 결과

```java
package javaChap07.exercise08;

public class Tire {
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}
```

```java
package javaChap07.exercise08;

public class SnowTire extends Tire {
	@Override
	public void run() {
		System.out.println("스노우타이어가 굴러갑니다.");
	}
}
```

```java
package javaChap07.exercise08;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;

		snowTire.run();
		tire.run();
	}
}
```

- 두 변수 모두 자식타입을 가리키므로 자식객체의 메소드가 실행된다.

---

### 9. 상속 관계

```java

B b = (     );

void method(B b){

}

method(     );
```

- 빈칸에 들어올 수 없는 객체는 B의 부모타입의 객체는 직접적으로 들어올 수 없다. (객체생성이 먼저 되고, 강제타입변환 후 가능)

---

### 10. 컴파일 에러 이유

```java
public abstract class Machine{
    public void powerOn(){}
    public void powerOff(){}
    public abstract void work();
}

public class Computer extends Machine{
 // 추상클래스에 추상메소드를 선언하였다면, 해당 객체를 상속하는 자식객체에서는 추상메소드를 강제오버라이딩해야한다.
}
```

---

### 11. 부모객체의 메소드 실행

```java
package javaChap07.exercise11;

public class Activity {
	public void onCreate() {
		System.out.println("기본적인 실행 내용");
	}
}
```

```java
package javaChap07.exercise11;

public class MainActivity extends Activity {
	@Override
	public void onCreate() {
        // 자식 메소드 실행시 부모의 메소드 실행
		super.onCreate();
		System.out.println("추가적인 실행 내용");
	}
}
```

---

### 12. C객체일 경우에만 method2() 호출

```java
package javaChap07.exercise12;

public class A {
	public void method1() {
		System.out.println("A-method1()");
	}
}
```

```java
package javaChap07.exercise12;

public class B extends A{
	@Override
	public void method1() {
		System.out.println("B-method1()");
	}
}
```

```java
package javaChap07.exercise12;

public class C extends A{
	@Override
	public void method1() {
		System.out.println("C-method1()");
	}
	public void method2() {
		System.out.println("C-method2()");
	}
}
```

```java
package javaChap07.exercise12;

public class Example {
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
	}

	public static void action(A a) {
		a.method1();
		if (a instanceof C) {
            // 부모객체로 받은 매개변수가 자식중 C타입을 가리킬 경우만 c.method2(); 실행
			C c = (C) a;
			c.method2();
		}
	}
}
```
