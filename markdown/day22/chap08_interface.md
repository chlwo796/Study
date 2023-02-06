2023년 2월 5일 일요일

---

## chap.08 interface

### 1. 인터페이스란?

- 추상클래스처럼 추상메소드를 갖는다.
- 추상클래스보다 추상화정도가 높아서 오직 추상메소드와 상수만을 멤버로 가질 수 있다.

### 2. 인터페이스 선언

```java
public interface A {    // interface A 선언
	static final double PI = 3.14;  // 상수 선언 가능

	abstract void methodA();    // 추상메소드 선언

	default void methodAA() {
		// default 명시를 해줘야 사용가능
        // default 메소드 선언
	}

	static void methodAAA() {
        // static 메소드 선언
	}
    //	int a;	// 컴파일 에러. 상수만 선언가능, interface에서는 데이터를 저장하지 않는다.
    //	static {
	// 컴파일 에러. static 블록 사용 불가
    //	}
}
```

1. 상수 필드 선언

   - 인터페이스는 상수 필드만 선언 가능
   - 데이터를 저장하지 않는다.
   - 인터페이스에 선언된 필드는 모두 컴파일 과정에서 자동으로 `public static final`이 붙는다.
   - 상수명은 대문자로 작성한다.
   - 서로 다른 단어로 구성되어 있을 경우에는 언더 바(\_)로 연결한다.
   - 선언과 동시에 초기값 지정해야한다.
   - `static {}` 으로 초기화할 수 없다.

2. 추상 메소드 선언

   - 인터페이스를 통해 호출된 메소드는 최종적으로 객체에서 실행된다.
   - 인터페이스의 메소드는 실행 블록이 필요 없이 추상메소드로 선언한다.
   - 추상 메소드는 리턴타입, 메소드명, 매개변수만 기술되고 {}블록을 붙이지 않는 메소드를 말한다.
   - 인터페이스에 선언된 추상 메소드는 모두 `public abstract`의 특성을 갖기 때문에, `public abstract`를 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.
     ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMjFfNjcg/MDAxNjA1OTI4MjMzMjE1.RqtB0LvLheDpZF_1ciXYMED2lQcHOQYEgSXOu68lF_4g.s6-EcqYX5C74CAL-OqRtDZd-zdMExw3B_Z8P0YZUn1Yg.PNG/a1.PNG?type=w1600)

3. 디폴트 메소드 선언

   `public default returnType methodName(Type, name){}`

   ```java
   default void methodA() {
           // default 메소드 선언
       }
   ```

4. 정적 메소드 선언

   `public static returnType methodName(Type, name){}`

   ```java
   static void methodAAA() {
           // static 메소드 선언
       }
   ```

### 3. 인터페이스 구현

- 개발코드가 인터페이스 메소드를 호출하면 인터페이스는 객체의 메소드를 호출한다.
- 객체는 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름, 매개타입, 리턴타입을 가진 셀제 메소드를 가지고 있어야 한다.
- 이러한 객체를 인터페이스의 구현 객체라고 하고, 구현 객체를 생성하는 클래스를 구현 클래스라고 한다.

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMjFfMTkw/MDAxNjA1OTM1NTA4NjEz.-JL3N-8-AUhkAR7oelT_lfEk3HXcjEpc03Aj6K7nmW0g.7tdYCFb4BeyZ6z5vVeMLAdXGbBaLITpZZbpj8KLralsg.PNG/a1.PNG?type=w1600)

### 4. 인터페이스 상속

- 인터페이스는 인터페이스로부터만 상속받을 수 있으며, 클래스와는 달리 다중 상속, 즉 여러개의 인터페이스로부터 상속을 받는 것이 가능하다.

```java
public interface A {
}
public interface B {

}
public interface C extends A, B{

}
public interface D extends A,B,C{

}
// public class E extends A{
//      public default class E는 public interface A를 상속할 수 없다.
//      (extends to implements) or (class to interface)
// }
```

### 5. 인터페이스 구현

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMjJfMjcg/MDAxNjA2MDQyMTc3NDM1.R-XkxHVXQU3cfH7FPfaxcgdYcICtlYZoyq5kSLSKoSIg.3wsTc2u9Tczk9bLpZsqYRw5wBk-h3gftgCuqbo-oBLIg.PNG/image.png?type=w1600)

```java
public interface Attackable {

}
public interface Movable {

}
public class Unit {

}
public interface Fightable extends Attackable, Movable{
    // interface Fightable은 interface Attackable, Movable 모두 상속한다.
}
public class Fighter extends Unit implements Fightable{
    // Fighter는 Unit을 상속받으면서 interface Fightable을 구현한다.
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter fighter = new Fighter();

		if (fighter instanceof Unit) {
			System.out.println("Unit의 자손");
		}
		if (fighter instanceof Fightable) {
			System.out.println("Fightable을 구현");
		}
		if (fighter instanceof Movable) {
			System.out.println("Movable을 구현");
		}
		if (fighter instanceof Attackable) {
			System.out.println("Attackable을 구현");
		}
		if (fighter instanceof Object) {
			System.out.println("object의 자손");
		}
        // 출력 결과를 확인해보자.
	}

}
```

### 6. 인터페이스를 이용한 다중 상속

`public class TV extends SubTV implements InterfaceTV, InterfaceTv2{}`

### 7. 인터페이스를 이용한 다형성

- 다형성은 자손클래스의 인스턴스를 조상타입의 참조변수로 참조하는 것이 가능하다.
  `부모클래스 참조변수 = new 자손클래스();`
- 이것처럼 인터페이스 역시 이를 구현한 클래스의 조상이라 할 수 있으므로 해당 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있으며 인터페이스 타입으로의 형변환도 가능하다.

```java
public interface Fightable{

}

public class Fighter extends Unit implements Fightable{

}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fightable fightable = new Fighter();
    }
     void attack(Fightable fightable){
    }
    Fightable method1() {
		Fightable fightable = new Fighter();
		return fightable;   // 해당 인터페이스 Fightable을 구현클래스의 인스턴스로 반환한다는 것을 의미한다.
    }
}
```

### 8. 인터페이스의 장점

- 개발시간을 단축시킬 수 있다.
- 표준화가 가능하다.
- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
- 독립적인 프로그래밍이 가능하다.

### 9. 인터페이스 역할

- 클래스를 사용하는 쪽(User)와 클래스를 제공하는 쪽(Provider)가 있다.
- 메소드를 사용하는 쪽에서는 사용하려는 메소드(Provider)의 선언부만 알면 된다.
- 객체의 사용방법을 정의한 타입이다.
- 객체의 교환성을 높여 주기 때문에 다형성을 구현하는 매우 중요한 역할을 한다.
- 람다식(익명함수)은 함수적 인터페이스의 구현 객체를 생성한다.
- 개발코드와 객체가 서로 통신하는 접점
- 개발코드는 인터페이스와 메소드만 알고 있으면 된다.

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMjFfMjQw/MDAxNjA1OTI3NTAyMTY3.uLfbNzGG1pXb1fqLjOwOEqV4ugdGw8w50aLJ_QLXl6wg.0EMwjuF1jWhWcpm2d1sc1Xs3z8HMZpk6Th8LRfT6ynkg.PNG/%E3%85%811.png?type=w1600)
![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMjFfMjY4/MDAxNjA1OTI3NTE5Njgy.VZaIgaa6cYBRJQl5NfpiauVkqwTg26y8hJFZSQodNYgg.Ai4HdLDGMV75Y9SBHv0RmPP8r1x9-x4aoc4VvIKLkzog.PNG/%E3%85%812.png?type=w1600)

- **개발코드가 직접 객체의 메소드를 호출하면 간단한데 중간에 인터페이스를 두는 이유**

  - 개발코드를 수정하지 않고 사용하는 객체를 변경할 수 있도록 하기 위해서
  - 인터페이스는 하나의 객체가 아니라 여러 객체들과 사용이 가능하므로 어떤 객체를 사용하느냐에 따라서 실행 내용과 리턴 값이 다를 수 있다.
  - 따라서 개발 코드 측면에서는 코드 변경 없이 실행 내용과 리턴값을 다양화 할 수 있다는 장점을 가지고 있다.
