2023년 3월 7일 화요일

---

## chap.20 데이터베이스 입출력

### 1. JDBC 개요

- 자바는 데이터베이스(DB)와 연결해서 데이터 입출력 작업을 할 수 있도록 JDBC(java database connectivity) 라이브러리(java.sql 패키지)를 제공한다.
- JDBC는 데이터베이스 관리시스템(DBMS)의 종류와 상관없이 동일하게 사용할 수 있는 클래스와 인터페이스로 구성되어 있다.
  ![](https://velog.velcdn.com/images/szszszsz/post/56332231-8052-49a8-a053-7e5dc33d1527/image.png)
- JDBC 인터페이스를 통해 실제로 DB와 작업하는 것은 JDBC Driver이며, JDBC Driver는 JDBC 인터페이스를 구현한 것으로, DBMS마다 별도로 다운로드받아 사용해야한다.
  ![](https://velog.velcdn.com/images/szszszsz/post/a905c8b6-17e6-41ea-a867-4715b469534b/image.png)

1. DriverManager

- JDBC Driver를 관리하며 DB와 연결하여 Connection 구현 객체를 생성

2. Connection

- Conneciton 인터페이스는 Statement, PrepareStatement, CallableStatement 구현 객체를 생성하며, 트랜잭션(Transaction)처리 및 DB 연결을 끊을 때 사용

3. Statement

- Statement 인터페이스는 SQL의 DDL(Data Definition Language)과 DML(Data Manipulation Language)를 실행할 때 사용하며, 주로 변경되지 않는 정적 SQL문을 실행할 때 사용

4. PreparedStatement

- PreparedStatement는 Statement와 동일하게 SQL의 DDL, DML 문을 실행할 때 사용하며, 차이점은 매개변수화된 SQL 문을 사용할 수 있기 때문에, 편리성과 보안성이 좋다.(Statement보다 PreparedStatement를 주로 사용)

5. CallableStatement

- CallableStatement는 DB에 저장되어 있는 프로시저(procuder)와 함수(function)을 호출할 때 사용

6. ResultSet

- ResultSet은 DB에서 가져온 데이터를 읽을 때 사용

---

### 2. DBMS 설치

1. Oracle 설치

- Oracle을 설치하려면 11GB 이상의 하드디스크 공간과 2GB 이상의 여유 메모리가 있어야 하며, 가능하면 전체 메모리가 16GB 이상인 컴퓨터에서 설치하는 것을 권장한다.
