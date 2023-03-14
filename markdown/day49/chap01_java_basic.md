2023년 3월 13일 월요일

---

## chap.01 java basic

### 1. 프로그래밍 언어와 자바

- 컴퓨터가 이해할 수 있는 기계어(marchine language)는 0과 1로 이루어진 이진 코드를 사용하며, 프로그래밍 언어는 사람의 언어와 기계어의 다리 역할을 한다.
- 프로그래밍 언어는 고급언어와 저급 언어로 구분된다.

  - 고급언어 : 컴퓨터와 대화할 수 있도록 만든 언어 중에서 사람이 쉽게 이해할 수 있는 언어, 컴파일(compile)을 통해 2진수 기계어로 변환한 후 컴퓨터가 사용
  - 저급언어 : 기계어에 가까운 언어, 어셈블리어

- 소스(source) : 고급 언어로 작성한 파일
- 고급 언어의 종류 : java, C, C++, C#, python
- 자바의 특징
  - 모든 운영체제에서 실행 가능
  - 객체 지향 프로그래밍(object oriented programming, OOP)
  - 메모리 자동 정리
  - 무료 라이브러리 풍부

---

### 2. JDK

- 자바 프로그램을 개발하고 실행하기 위해서는 java se(standart edition)의 구현체인 jdk(java development kit)을 설치해야한다.
- JDK의 종류
  - Open JDK : 비용을 고려한다면 Open JDK를 사용하는 것이 유리하다.
  - Oracle JDK : Open JDK보다 응답성과 JVM 성능이 상대적으로 뛰어남

---

### 3. 바이트코드 파일과 자바 가상 머신

- 자바 소스 파일의 확장명은 `.java` 이며, 텍스트 파일이므로 어떤 텍스트 에디터에서도 작성이 가능하다.

1. 바이트코드 파일

- 소스 파일(.java)를 작성한 후에는 컴파일을 해야 한다.
- javac(java compiler) 명령어는 소스파일을 컴파일하는데, 컴파일 결과는 확장명이 `.class`인 바이트코드(byteCode)파일로 생성된다.

2. 자바 가상 머신

- 바이트 코드 파일(.class)을 특정 운영체제가 이해하는 기계어로 번역하고 실행시키는 명령어는 `java`이다.
- `java` 명령어는 JDK와 함께 설치된 자바 가상 머신(java virtual marchine, JVM)을 구동시켜 바이트 코드 파일을 완전한 기계어로 번역하고 실행시킨다.

### 4. 용어정리

- Java, JDK, JRE, JavaSE

  - Java 개발 도구에 중점 : JDK17
  - Java 실행 환경에 중점 : JRE17
  - Java 스펙 내용에 중점 : JavaSE-17

- JavaSE(java standard edition)은 자바 개발에서부터 실행까지의 모든 환경을 정의한 스펙을 말하며, JavaSE 스펙을 준수해서 만든 것이 Open JDK, Oracle JDK라고 생각하면 된다.
