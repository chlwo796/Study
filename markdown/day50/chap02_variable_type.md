2023년 3월 14일 화요일

## chap.02 variable type

### 1. primitive type 종류와 값의 범위 및 기본값

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F991A15355B6140F125)

---

### 2. 문자 타입

- 하나의 문자를 작은따옴표(')로 감싼 것을 문자 리터럴이라고 한다.
- 문자 리터럴은 유니코드로 변환되어 저장되는데, 유니코드는 세계 각국의 문자를 0~65535 숫자로 매핑한 국제 표준 규약이다.
- 자바는 이러한 유니코드를 저장할 수 있도록 char 타입을 제공한다.

  ```java
  char var1 = 'A';
  char var2 = '가';
  char var3 = 65;
  char var4 = 0x0041;
  ```

- 유니코드가 정수이므로 char 타입도 정수타입에 속한다.

### 3. 실수 타입

- 실수 타입에는 float와, double이 있으며 double타입이 float 타입보다 큰 실수를 저장할 수 있고 정밀도 또한 높다.
- 자바는 float타입과 double타입의 값을 부동 소수점(floating-point)방식으로 메모리에 저장한다.
