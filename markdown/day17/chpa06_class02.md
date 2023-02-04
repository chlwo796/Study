2023년 2월 4일 토요일

---

## chap.06 class02

### 1. 정적 멤버와 static

- 정적 멤버는 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드

1. 정적 멤버 선언

```java
// 정적 필드
static int a;

// 정적 메소드
static void methodA(){

}
```

2. 원리

   - 정적 필드와 정적 메소드는 클래스에 고정된 멤버이므로, 클래스 로더가 클래스(바이트코드)를 로딩해서 메모리 영역에 적재할 때 클래스별로 관리한다. 따라서 클래스의 로딩이 끝나면 바로 사용할 수 있다.
   - 클래스 -> 바이트코드 읽기 -> 클래스로더 -> 바이트코드 적재 -> 메소드영역(정적필드, 정적메소드)

3. 정적 멤버 사용

   - 클래스가 메모리로 로딩되면 정적멤버를 바로 사용할 수 있는데 클래스 이름과 함께 도트연산자로 접근한다.

   ```java
   ClassName.field;
   ClassName.method(Type name);

   class A {
    static int a;

    static void methodA();{

    }
    A.a;

    A.methodA();
   }
   ```

### 2. 정적 초기화 블록

- 정적 블록은 클래스가 메모리로 로딩될 때 자동적으로 실행된다.

```java
public class Main {
	public static void main(String[] args) {

        System.out.println("main");
		System.out.println(Television.info);
        System.out.println("main");
	}
}

class Television {
	static String a = "a";
	static String b = "b";
	static String info;
	static {
		System.out.println("sdf");	// 생성자 개념과 비슷하다. 호출과 동시에 자동적으로 실행된다.
	}

}
```

- 출력결과 : "main" -> static {} -> Television.info -> "main"

### 3. 정적 메소드와 블록 선언시 주의사항

- 정적메소드와 정적 블록을 선언할 때의 주의사항은 객체가 없어도 실행된다는 특징 때문에 이들 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다.
- 객체 자신의 참조인 `this` 조차 사용할 수 없다.

### 4. 변수의 초기화

- 변수를 선언하고 처음으로 갖는 값을 초기화라 한다.
- 변수의 초기화는 필수적이기도 하고 선택적이기도 하다.
- 가능하면 초기화 하는 것이 좋다.
- 멤버변수는 초기화를 하지 않아도 된다.
- 지역변수는 초기화를 반드시 해야한다.

```java
class A {
	int a;
	int b;
	int c = a;  // 멤버변수는 초기화를 하지 않아도 가능하다.

	void methodA() {
		int d;  //지역변수 d의 선언, 초기화 x
		int e = d;  // 초기화되지 않은 지역변수 d로는 지역변수 e의 초기화를 할 수 없다. 에러발생
	}
}
```

### 5. 멤버 변수의 초기화 방법

1. 명시적 초기화

   `int a = 10;`

2. 생성자를 이용한 초기화

   ```java
   int a;
   public A(){
       a = 0;
   }
   ```

3. 초기화 블록(initialization block)

   - 인스턴스 초기화 블록 : 인스턴스변수를 초기화하는데 사용
   - 클래스 초기화 블록(static) : 클래스 변수(static)을 초기화하는데 사용

### 6. 초기화 블록(initialization block)

1. 클래스 초기화 블록

   - 클래스 변수의 복잡한 초기화에 사용된다.
   - 클래스가 메모리에 처음 로딩될 때 **단 한번**만 수행된다.

2. 인스턴스 초기화 블록

   - 인스턴스 변수의 복잡한 초기화에 사용된다.
   - 인스턴스를 생성할 때마다 수행된다.

3. **생성자보다 인스턴스 초기화 블럭이 먼저 수행된다.**

```java
public class Main {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("black", "Stick");
	}
}

class Car {
	int count;
	int serialNo;
	String color;
	String gearType;

	{
		count++;
		serialNo = count; // instance block = 초기화를 담당하며, 생성자보다 먼저실행된다. 결과를 확인해보자.
		System.out.println(color + " " + gearType);
		System.out.println(color);
		System.out.println(serialNo);
	}

	Car() {
//		count++;
//		serialNo = count;
		color = "while";
		gearType = "Auto";
		System.out.println(color + " " + gearType);
		System.out.println(color);
		System.out.println(serialNo); // count++ 이 수행된 상태.
	}

	Car(String color, String gearType) {
//		count++;
//		serialNo = count;
		this.color = color;
		this.gearType = gearType;
		System.out.println(color + " " + gearType);
		System.out.println(color);
		System.out.println(serialNo);
	}

}
```

- 생성자마다의 중복되는 코드를 instance블록 {} 에 담아서 재사용성을 높이고, 중복을 제거할 수 있다.

### 7. 클래스가 메모리에 로딩될 때 순서

- 클래스 초기화 블록 static { } -> main() -> 인스턴스 초기화 블록 { } -> 생성자

### 8. 멤버 변수의 초기화 시기와 순서

- 클래스 변수(`static int a`)의 초기화 시점 : 클래스가 처음 로딩될 때 단 한번 초기화 된다.
- 인스턴스 변수(`int a`)의 초기화 시점 : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.
- 클래스 변수의 초기화 순서 : 기본값 -> 명시적 초기화-> 클래스 초기화 블럭
- 인스턴스 변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블록 -> 생성자
- **클래스 변수는 항상 인스턴스 변수보다 먼저 생성되고 초기화된다.**

### final field

- final의 의미는 최종적이라는 뜻을 가지고 있다.
- final field는 초기값이 저장되면 이것이 최종적인 값이 되어서 프로그램 실행도중에 수정할 수 없다는 것
- 형식 : `final Type name = 초기값`

```java
final String nation = "korea";
```

### 9. 상수(static final)

- 상수는 불변의 값을 말한다.
- 원주율 파이나 지구의 무게나 둘레, 중력가속도 등
- 자바에서는 불변값을 저장하는 필드를 상수라고 한다.
- final 필드를 상수라 부르지 않는다.(불변의 값을 객체마다 저장할 필요가 없기 때문에 클래스 변수로 사용하여 정의한다.)
- 형식 : `static final Type NAME = 초기값`

```java
public class Main {
	public static void main(String[] args) {
        // static 메소드에서 바로 ClassName.field로 값을 호출한다.
		System.out.println("지구의 반지름 = " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 = " + Earth.EARTH_SURFACE_AREA + "km^2");

	}
}

class Earth {
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;

	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
```
