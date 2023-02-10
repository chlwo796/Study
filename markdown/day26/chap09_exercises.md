2023년 2월 10일 금요일

---

## chap.09 Exercises review

### 1. 중첩 멤버 클래스

- 인스턴스 멤버 클래스는 바깥 클래스의 객체가 있어야 사용될 수 있다.
- 정적 멤버 클래스는 바깥 클래스의 객체가 없어도 사용될 수 있다.
- 인스턴스 멤버 클래스 내부에는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다.
- 정적 멤버 클래스 내부에는 바깥 클래스의 인스턴스 필드를 사용할 수 있다.(x) -> 사용할 수 없다.

```java
package tempMemo;

public class A {
	int a = 10;
	void methodA() {

	}
	static class B{
		static void methodB() {
            // 에러발생. static으로 선언된 내부 클래스에서는 외부클래스의 인스턴스 필드를 사용할 수 없다.
			// methodA();
			// a = a+10;
		}
	}
}
```

### 2. 로컬 클래스

- 로컬 클래스는 메소드 내부에 선언된 클래스를 말한다.
- 로컬 클래스는 바깥 클래스의 필드와 메소드를 사용할 수 있다.
- 로컬 클래스는 static 키워드를 이용해서 정적 클래스로 만들 수 있다.(x) -> static 선언 불가
- final 특성을 가진 매개변수나 로컬 변수만 로컬 클래스 내부에서 사용할 수 있다.

```java
package tempMemo;

public class A {
	int a = 10;

	void methodA() {
		static class B{ // static 컴파일에러 발생
            // final이나 abstract 로만 선언이 가능하다.
		}
	}
}
```

### 3. 익명객체

- 익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성될 수 있다.
- 익명 객체는 필드, 매개변수, 로컬 변수의 초기값으로 주로 사용된다.
- 익명 객체에는 생성자를 선언할 수 있다.(x) -> 생성자를 선언할 수 없다. 부모의 생성자만 호출된다.
- 익명 객체는 주로 재정의된 메소드를 멤버로 가진다.

```java
package tempMemo;

public class A {
	B b = new B() { // B의 익명 자식객체 선언
		@Override
		void methodB() {
			// 생성자는 부모의 것(B)만 이용이 가능하다.
			super.methodB();
		}
	};
}
package tempMemo;

public class B {
	public B() {
		// B 의 기본생성자
	}
	void methodB() {

	}
}
```

### 4. 내부 클래스 객체 생성

```java
package javaMid8.ex04;

public class Car {
	class Tire {

	}

	static class Engine {

	}
}
package javaMid8.ex04;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car();
		Car.Tire tire = car.new Tire();
		Car.Engine engine = new Car.Engine();
	}
}
```

### 5. interface의 익명 구현 객체

```java
package javaMid8.ex05;

public interface Action {
	public void work();
}
package javaMid8.ex05;

public class ActionMain {
	public static void main(String[] args) {
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("interface Action의 익명구현객체");
				System.out.println("복사를 합니다.");

			}
		};
		action.work();
	}
}
```

### 6. 익명 구현 객체를 다양한 방법으로 생성

1. field 로 선언

```java
package javaMid8.ex06;

public interface Vehicle {
	public void run();
}
package javaMid8.ex06;

public class Anonymous {
	Vehicle field = new Vehicle() {

		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");

		}
	};
}
```

2. 로컬변수로 선언

```java
public interface Vehicle {
	public void run();
}
package javaMid8.ex06;

public class Anonymous {
	void method1() {
		Vehicle localVar = new Vehicle() {

			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");

			}
		};
		localVar.run();
	}
}
```

3. 메소드의 매개변수로 선언

```java
public interface Vehicle {
	public void run();
}
package javaMid8.ex06;

public class Anonymous {
	void method2(Vehicle v) {
		v.run();
	}
}
```

4. Main

```java
package javaMid8.ex06;

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		anonymous.field.run();
		anonymous.method1();
		anonymous.method2(new Vehicle() {
//			메소드에서 바로 익명구현객체를 만들어서 호출하기. 매우중요.
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
```

### 7. 컴파일 에러의 원인

```java
package javaMid8.ex07;

public class Chatting {
	class Chat {
		void start() {

		}

		void sendMessage(String message) {

		}
	}

	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		Chat chat = new Chat() {
			@Override
			void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData; // 컴파일 오류 발생
					sendMessage(message);
				}
			}
		};

		chat.start();
	}
    // 외부클래스 Chatting의 메소드 startChat()에서 선언된 내부클래스 Chat의 익명 자식객체를 선언하였다.
    // 로컬클래스인 Chat의 익명 자식객체에서는 startChat()에서 선언된 String nickName 로컬변수를 사용할 수 는 있어도,
    // 로컬클래스의 변수들은 final적 특성을 가지기 때문에 데이터를 바꿀 수는 없다.
    // 따라서 null을 빼거나, 메소드 외부에서 선언하면 해결된다.
}
```
