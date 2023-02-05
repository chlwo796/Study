2023년 2월 5일 일요일

---

## chap.07 abstract

### 1. 추상클래스의 개념

- 사전 : 실제 간에 공통되는 특성을 추출하는 것
- 자바 : 공통적인 특성을 추출해서 선언한 클래스, 미완성 설계도
- 추상클래스 : 부모클래스
- 구현(실체)클래스 : 자식클래스
- 추상클래스는 실체 클래스의 공통이되는 필드와 메소드를 추출해서 만들었기 때문에, 객체를 직접 생성해서 사용할 수 없다.
- 상속을 통해서 자식클래스에 의해서만 완성될 수 있다.

### 2. 추상클래스의 용도

- 실체 클래스들의 공통된 필드와 메소드의 이름을 동일한 목적으로 사용
- 실체 클래스를 작성할 때 시간을 절약
- 추상클래스는 추상메소드를 포함하고 있다는 것을 제외하고는 일반 클래스와 동일하다.
- **자식클래스에서 추상메소드를 반드시 구현하도록 강요하기 위해서 사용**

### 3. 추상클래스의 선언

`public abstract class A{}`

```java
public abstract class  A {

	void methodA() {
		System.out.println("methodA");
	}
}
public class B extends A {

}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();	// abstract class A 접근불가
//		자식객체인 B를 통해 메소드에 접근
		B b = new B();
		b.methodA();
	}

}
```

### 4. 추상메소드와 오버라이딩

- 추상클래스는 실제 클래스가 공통적으로 가져야 할 필드와 메소드들을 정의해 놓은 추상적인 클래스이므로, 실제 클래스의 멤버(필드, 메소드)를 통일화하는데 목적이 있다.
- 모든 실체들이 가지고 있는 메소드의 실행 내용이 동일하다면 추상 클래스에 메소드를 작성한다.
- 형식 : **{}블록은 따로 명시하지 않는다.(내용이 없다는 뜻)**
  `접근제한자 abstract returnType methodName(Type name);`

```java
public abstract class A {   // 추상클래스의 선언

	abstract void methodA();    // 추상메소드 선언
}
public class B extends A {
	@Override
	void methodA() {
		System.out.println("강제 오버라이딩 b-methodA");

	}
}
public class C extends A{
@Override
void methodA() {
	System.out.println("강제 오버라이딩 c-methodA");
}
}
public class Main {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();

		b.methodA();
		c.methodA();
	}
}
```
