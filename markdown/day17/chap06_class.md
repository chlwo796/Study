2023년 2월 4일 토요일

---

## chap.06 class01

### 1. 객체지향 언어

- OOP : Object Oriented Programming
- 여러가지 문제들을 해결하기 위해 실제 세계를 컴퓨터 속에 구현하고자 하는 언어
- 부품 객체를 먼저 만들고 하나씩 조립해 완성된 프로그램을 만드는 기법

1. 객체(Object)란?

   - 물리적으로 존재하는 것(자동차, 책, 사람)
   - 추상적인 것(회사, 날짜) 중에서 자신의 속성과 동작을 가지는 모든 것
   - 객체는 필드(속성)과 메소드(동작)으로 구성된 자바 객체로 모델링 가능
   - 현실에 존재하는 사물과 개념들을 소프트웨어적으로 구현하고 그 구현된 객체들이 상호작용하며 데이터를 처리하는 방식

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDAxMDJfMTUx/MDAxNTc3OTcxMTk4MzIw.7xfhy7t4fUw_hm_SmOnaT8kLXDSgP8QGsheiVE2PHlEg.iu9O40z3YpWBeTaKa6R2TTEnHwrvtat0r9pvU2-nKzcg.PNG/c5.png?type=w800)

2. 객체의 상호작용

   - 객체들은 서로간에 기능(동작)을 이용하고 데이터를 주고 받음

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDAxMDJfMjk4/MDAxNTc3OTcxMzgwMDU0.5HOp7RMbBIzQdJ6MdnbQDc4LSs70ZU4CEZzzFvJQg2og.urH8ggemtr6U0uw7ULW2L_qMXuo5Fk5LYkd_DPUxjfEg.PNG/c6.png?type=w800)

3. 리턴값 = 전자계산기객체, 메소드(매개값1, 매개값2 등)

   `int result = Calculator.add(10,20);`

![]([](https://cafeptthumb-phinf.pstatic.net/MjAyMDAxMDJfNzUg/MDAxNTc3OTcxMzgwMzU0.mEyI9k-QgQXG-_jeKBjfCUJze4iYJZaZ9NBXiRKG694g.Jto428lJgrD-AR-F-VASuu-8NCXpL00GuK2jhMHFQUYg.PNG/c7.png?type=w800)

1. 객체 간의 관계

   - 객제 지향 프로그램에서 객체는 다른 객체와 관계를 맺음
   - 관계의 종류
     - 집합 관계 : 완성품과 부품의 관계
     - 사용 관계 : 객체가 다른 객체를 사용하는 관계
     - 상속 관계 : 종류 객체와 구체적인 사물 객체 관계

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMjAx/MDAxNjA0OTExMDY1MTM5.JAvKUb0QiZcSisSnUYsTN2Jw6_blpXzOU03ugMJYLqMg.QYMQWrwf9tEYztxPEXCBjUK4kz1aDJftbbYMLEa0mbQg.PNG/%E3%85%812.png?type=w1600)

5. 객체지향 언어의 특징

   1. 캡슐화
      - 객체의 필드, 메소드를 하나로 묶고, 실제 구현 내용을 감추는 것
      - 외부객체는 객체 내부 구조를 알지 못하며, 객체가 노출해 제공하는 필드와 메소드만 이용 가능
      - 외부의 잘못된 사용으로 인해 객체가 손상되지 않도록 필드와 메소드를 캡슐화하여 보호한다.
      - 자바는 캡슐회된 멤버를 노출시킬 것인지 숨길 것인지 결정하기 위해 접근제한자(Access Modifier)를 사용

   ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMzQg/MDAxNjA0OTExMjExNTU4.B2VEV-buWneFu5SLXEJv-WqIJ2dMI_3lccgfhtTXwTMg.JQoOKJMFKDf-3c7wjB69ASMsMZ2DrxDKYZiKVW9nkK4g.PNG/%E3%85%812.png?type=w1600)

   2. 상속
      - 상위(부모) 객체의 필드와 메소드를 하위(자식) 객체에게 물려주는 행위
      - 하위 객체는 상위 객체를 확장해서 추가적인 필드와 메소드를 가질 수 있음
      - 상속대상 : 필드와 메소드
      - 상속의 효과
        - 상위 객체를 재사용하여 하위 객체를 빨리 개발 가능
        - 반복된 코드의 중복을 줄임
        - 유지보수의 편리성 제공
        - 객체의 다형성 구현

   ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMjE1/MDAxNjA0OTExMjI0NDUx.dZLukF1fThk-WWn0hG3X6raM00zkewh5aJjpaaUjLVIg.H3yYj46H7Oj4Axlp_J0cgB1hpYIpGLTF05PUqQ65wzYg.PNG/%E3%85%813.png?type=w1600)

   3. 다형성
      - 같은 타입이지만 실행 결과가 다양한 객체를 대입할 수 있는 성질

   ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMjk1/MDAxNjA0OTExMjQyNDA2.UapYouR3_Lm6_wqyrqMhVLyl1e-uMij2HqSZIg27T-Mg.vQAX2NV5O2PO-a_iJCZ9gIVSyBDQ3vSdhJlpuWyaY1Mg.PNG/%E3%85%814.png?type=w1600)

### 2. 클래스와 객체

1. 클래스란?

   - 클래스는 객체를 만들기 위한 설계도
   - 클래스를 통해 객체를 정의하고 생성
   - 클래스에는 객체의 속성과 기능들이 정의되어 있고 이를 통해서 객체를 생성

2. 인스턴스(instance)

   - 클래스를 통해 만들어진 형태
   - 클래스를 통해 객체를 만드는 과정을 클래스의 인스턴스화라고 한다.

3. 클래스의 객체 생성

   - 클래스에는 객체를 생성하기 위한 필드와 메소드가 정의되어있다.
   - 클래스로부터 만들어진 객체를 해당 클래스의 인스턴스(instance)라고 한다.
   - 하나의 클래스로부터 여러개의 인스턴스를 만들 수 있다.

4. 개발자 -> 설계 -> 인스턴스화

   ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfOSAg/MDAxNjA0OTExMzczOTU3.lwn_KiL9CRyc2SPWgKzbC6AAK0mXl20dZzYfkbpIetQg.bi69Y8GID4H5p4XIcJKzpJ_pCVpK_nS-4hafbI0CYngg.PNG/%E3%85%815.png?type=w1600)

### 3. 클래스 선언

- 클래스 만드는 규칙

  - 하나이상의 문자로 이루어져야 한다.(Car, SportCar 등)
  - 첫번째 글자는 숫자가 올 수 없다.(3Car 불가능)
  - \$,\_ 외 특수문자는 사용할 수 없다.(\$Car,\_Car 가능)

  ```java
    public class Car{

    }

    class Tire{

    }
  ```

  - 두개 이상의 클래스가 선언된 소스파일을 컴파일하면 바이트 코드 파일(.class) 클래스는 선언한 개수만큼 생긴다.(Car.class, Tire.class)
  - 파일이름과 동일한 이름의 클래스 선언에만 public 접근 제한자를 붙일 수 있다.
  - 파일이름과 일치하지 않는 클래스 선언에 public 접근 제한자를 붙이면 컴파일 에러가 발생한다.
  - 가급적, 소스파일 하나당 동일한 이름의 클래스 하나를 선언하는 것이 좋다.

### 4. 객체 생성과 클래스 변수

- 클래스를 선언한 다음 컴파일을 했다면, 객체를 생성할 설계도가 만들어진 것과 같다.
  `new className();`
- new는 클래스로부터 객체를 생성시키는 연산자이다.
- new 연산자 뒤에는 생성자가 오는데 생성자는 className() 형태를 가지고 있다.
- new 연산자는 힙 영역에 객체를 생성시킨 후 객체의 주소를 리턴하도록 되어 있다.

```java
A a;
a = new A();

A a = new A();
```

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMTIg/MDAxNjA0OTEyMjkwMDk2.OE-9JLRYg7YGnuQQQIoP9vJrFriAboiHbAF_NcNZ4pEg.8j9nIwz1KwLdiEzIFuf0RIK_EJFogH_2lVgSr9oLTQUg.PNG/%E3%85%812.png?type=w1600)

### 5. 클래스의 구성 멤버

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMDlfMjcx/MDAxNjA0OTEyMzgxOTc2.ahPduI7PdMMIk2EZt081y57FmjV17dwhH5XrYvGrT2Ig.JFJEKuomKm1Fr1tYmxuLpiZruHWiC6kLi9v7ikDnUv0g.PNG/%E3%85%812.png?type=w1600)

### 6. 필드

- 객체의 고유 데이터, 부품 객체, 상태 정보를 저장하는 곳
- 필드 선언은 클래스 블록 {} 어디서든 존재할 수 있다.

1. 필드 선언

   ` Type name; [= initial value;]` : [생략가능]

2. 필드 사용

   - 필드를 사용한다는 것은 필드값을 읽고, 변경하는 작업
   - 클래스 내부의 생성자나 메소드에서 사용할 경우, 단순히 필드 이름으로 읽고 변경하면 된다.
   - 클래스 외부에서 사용할 경우, 우선적으로 클래스로부터 객체를 생성한 뒤 필드를 사용해야 한다.
   - 객체가 존재하지 않으면 필드도 존재하지 않기 때문에, 우선적으로 객체를 인스턴스화 한뒤 객체에 소속된 데이터를 사용한다.

   ```java
   A a = new A();
   a.feildA = 60;
   ```

   - "." 도트연산자
     - a변수가 A객체를 참조하게 되면, 도트연산자를 사용해서 fieldA에 접근할 수 있다.
     - 객체 접근 연산자로 객체가 가지고 있는 필드나 메소드를 사용하고자 할 때 사용한다.

### 7. 생성자

1. new 연산자로 호출되는 특별한 {} 블록

   - 생성자 역할은 객체 생성시 초기화를 담당한다.
   - 생성자의 이름은 클래스의 이름과 같아야 한다.
   - 생성자는 리턴 값이 없다.

2. 객체 초기화란 필드를 초기화하거나 메소드를 호출해서 객체를 사용할 준비를 하는 것을 말한다.

   - 생성자를 실행시키지 않고는 클래스로부터 객체를 만들 수 없다.
   - `new` 연산자에 의해 생성자가 성공적으로 실행되면 힙영역에 객체가 생성되고 객체의 주소가 리턴된다.

3. 기본 생성자

   - 모든 클래스는 생성자가 반드시 존재하며 하나 이상을 가질 수 있다.
   - 만약에 클래스에서 생성자를 생략했다면, 컴파일러가 기본생성자를 바이트 코드에 자동으로 추가해 넣는다.

4. 기본 생성자 형식

   `public className(){}`

5. 매개변수가 있는 생성자 형식

   `public className(Type name){}`

6. 생성자 오버로딩(Overloading)

   - 매개변수를 달리하는 생성자를 여러개 선언하는 것

### 8. 메소드

- 객체의 동작에 해당하는 {} 블록을 말한다.
- 메소드를 호출하게 되면 블록에 있는 모든 코드를 일괄적으로 실행한다.

1. 메소드 선언 형식(구조)

   ```java
   returnType methodName(Type name){
       실행할 코드
   }

   double methodA(int a, int b){
    return (double)a + b;
   }
   ```

2. 리턴 타입

   - 리턴타입은 메소드가 실행 후 리턴하는 값의 타입을 말한다.
   - 리턴이 없는 경우 : void
   - 리턴이 있는 경우나 없는 경우나(void) 해당하는 타입이 꼭 명시되어야 한다.

   ```java
   void methodA(){}
   double methodB(int a, int y){}
   ```

3. 메소드 이름

   - 숫자로 시작하면 안되고 $,\_ 를 제외한 특수문자를 사용하지 말아야 한다.
   - 관례적으로 메소드명은 소문자로 작성한다.
   - 동사로 주로 짓는다.
   - 서로 다른 단어가 혼합된 이름이라면 뒤이어 오는 단어의 첫머리 글자는 대문자로 작성한다.
   - getter~ : 필드의 출력을 담당하는 메소드 이름
   - setter~ : 필드의 입력을 담당하는 메소드 이름

4. 매개변수 선언

   - 매개변수는 메소드가 실행할 때 필요한 데이터를 외부로부터 받기 위해 사용한다.

5. 객체 외부에서 호출

   ```java
   // 리턴값이 없거나, 있어도 리턴값을 받지 않을 경우
   a.methodA();
   // 리턴값이 있고, 리턴값을 받고 싶을 경우
   int b = a.methodA();
   ```

### 9. 메소드 오버로딩

1. 메소드 이름이 같고, 매개변수 타입만 달리해서 사용하는 것

   - 장점 : 동작에 대한 동일한 명칭으로 사용할 수 있다.
   - 규칙

   ```java
   returnType methodName(Type1 name1){
   return field;
   }
   returnType2 methodName(Type2 name2){
   return field;
   }
   returnType3 methodName(Type1 name1, Type2 name2){
   return field;
   }
   ```

2. 사용 시 주의사항

   - 매개변수의 타입과 개수, 순서가 똑같을 경우 매개변수 이름만 바꾸는 것은 메소드 오버로딩이 아니다.
   - 리턴타입만 다르고 매개변수가 동일하다면 오버로딩이 아니다.
