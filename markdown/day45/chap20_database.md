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

2. 원격 연결

### 3. Client Tool 설치

- SQL Developer : Oracle DB 개발 및 관리를 간편하게 해주는 무료 Client Tool이며, 명령어 기반 SQL Plus를 이용해도 되지만, UI 기반의 SQL Developer를 사용하면 DB 모델링에서부터 DB상태 확인, SQL 스크립트 및 PL/SQL 개발 등을 매우 편리하게 할 수 있다.

---

### 4. DB 구성

- Oracle이 설치되었다면 학습에 필요한 테이블, 시퀀스, 프로시저, 함수를 생성하여 데이터베이스를 구성한다.

---

### 5. DB 연결

- 클라이언트 프로그램에서 DB와 연결하려면 해당 DBMS JDBC Driver가 필요하며, 연결에 필요한 네 가지 정보가 있어야 한다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/a6699988-31ad-4dfe-9236-9f391e0947c1/image.png)

  - DBMS가 설치된 컴퓨터의 IP주소
  - DBMS가 허용하는 포트(Port) 번호
  - 사용자(DB 계정) 및 비밀번호
  - 사용하고자 하는 DB 이름

- IP 주소는 컴퓨터를 찾아가기 위해, Port 번호는 DBMS로 연결하기 위해 필요하다.
- DBMS는 여러 개의 DB를 관리하므로, 실제로 사용할 DB 이름이 필요하며, 어떤 사용자인지 인증받기 위한 계정 및 비밀번호도 필요하다.

1. JDBC Driver 설치

- 로컬 PC에서 찾은 ojdbc.8jar 파일 또는 URL에서 내려받은 ojdbc8-19.x.0.0.jar 파일을 프로젝트의 lib 폴더에 복사 후 Build Path에 추가한다.
- 환경변수작업 CLASSPATH에 JAR 파일 경로 추가

2. DB 연결

- 클라이언트 프로그램을 DB와 연결하기 위해 가장 먼저 해야 할 작업은 JDBC Driver를 메모리로 로딩하는 것
- Class.forName() 메소드는 문자열로 주어진 JDBC Driver 클래스를 Build Path에서 찾고, 메모리로 로딩한다.

  `Class.forName("oracle.jdbc.OracleDriver");`

- 이 과정에서 JDBC Driver 클래스의 static 블록이 실행되면서 DriverManager에 JDBC Driver 객체를 등록하게 되며, Build Path에서 JDBC Driver 클래스를 찾지 못하면 ClassNotFoundException이 발생하므로 예외 처리를 해야 한다.
- DriverManager에 JDBC Driver가 등록되면, getConnection() 메소드로 DB와 연결할 수 있다.

```java
Connection coon = DriverManager.getConnection("연결 문자열", "사용자", "비밀번호");
```

- 첫 번째 매개값은 연결 문자열인데, DBMS마다 다른 형식을 가지고 있으며, Oracle의 연결 문자열은 다음과 같다.

  `jdbc:oracle:thin:@localhost:1521/orcl`

  - jdbc:oracle:this : TCP용 JDBC Driver를 사용한다는 뜻(this)
  - @localhost : 로컬에 설치된 Oracle에 연결하겠다는 의미
  - 원격으로 Oracle을 연결하려면 @IP주소로 기술해야 한다.
  - 1521 : Port 번호
  - orcl : DB명

- 연결이 성공하면 getConnection() 메소드는 Connection 객체를 리턴하며, 연결이 실패하면 SQLException이 발생하므로 예외처리를 해야한다.

- ConnectionExample 예제

  ```java
  package javaChap20.example01;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;

  public class ConnectionExample {
    public static void main(String[] args) {
  //		Connection conn = null;
  //		try {
  //			// JDBC Driver를 메모리로 로딩, DriverManager 등록
  //			Class.forName("oracle.jdbc.OracleDriver");
  //
  //			// DB와 연결
  //
  //			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
  //			System.out.println("연결 성공");
  //
  //			// DB작업
  //
  //			System.out.println("연결 끊기");
  //		} catch (ClassNotFoundException e) {
  //			// TODO Auto-generated catch block
  //			e.printStackTrace();
  //		} catch (SQLException e) {
  //			// TODO Auto-generated catch block
  //			e.printStackTrace();
  //		} finally {
  //			try {
  //				if (conn != null) {
  //					conn.close();
  //				}
  //			} catch (SQLException e) {
  //				// TODO Auto-generated catch block
  //				e.printStackTrace();
  //			}
  //		}
      // 자동 리소스 기능
      try {
        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java",
            "oracle")) {
          System.out.println("연결 성공");
          // DB작업
        } catch (SQLException e) {

        }
        System.out.println("연결 끊기");
      } catch (ClassNotFoundException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }
  ```

---

### 6. 데이터 저장

- JDBC를 이용하여 INSERT 문을 실행하는 방법

```java
// users 테이블에 새로운 사용자 정보를 저장하는 INSERT문(데이터베이스 내부에서 실행)
INSERT INTO users (userid, username, userpassword, userage, useremail)

// sql 문에서는 '' = 문자열
VALUES ('winter', '한겨울', '12345', 25, 'winter@mycompany.com')

// 실행 후 데이터베이스 전송, SQL Deverloper = 클라이언트
commit;

// 실행 후 이전으로 돌아감
rollback;
// 실행 후 영구저장
// 값을 ?로 대체한 매개변수화된 INSERT문
INSERT INTO users (userid, username, userpassword, userage, useremail)
VALUES(?,?,?,?,?)

// INSERT 문을 String 타입 변수 sql에 문자열로 대체
String sql = new StringBuilder()
.append("INSERT INTO users (userid, username, userpassword, userage, useremail) ")
.append("VALUES (?, ?, ?, ?, ?)")
.toString();

// Connection의 prepareStatement() 메소드로부터 PreparedStatement를 얻는다.
// 매개변수화된 SQL문을 실행
PreparedStatement pstmt = conn.prepareStatement(sql);

// ?에 들어갈 값을 지정, ?는 순서에 따라 1번부터 번호를 부여
// 값의 타입에 따라 Setter 메소드를 선택한 후 첫번째는 ? 순번, 두번째는 값을 지정
pstmt.setString(1, "winter");
pstmt.setString(2, "한겨울");
pstmt.setString(3, "12345");
pstmt.setInt(4, 25);
pstmt.setString(5, "winter@mycompany.com");

// 값을 지정한 후 executeUpdate() 메소드를 호출하면 SQL 문이 실행되면서 users 테이블에 1개의 행이 저장
// executeUpdate() 메소드가 리턴하는 값은 저장된 행 수이며, 정상실행 = 1 리턴
int rows. pstmt.executeUpdate();

// PreparedStatement를 더 이상 사용하지 않을 경우, close() 메소드 호출 후 종료(메모리해제)
pstmt.close();
```

- UserInsertExmaple 예제

  ```java
  package javaChap20.example02;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;

  public class UserInsertExample {
    public static void main(String[] args) {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = "insert into users (userid, username, userpassword, userage, useremail) values (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 제약조건에 usersid 는 primary_key로 설정되어있어, 중복저장시 에러
        pstmt.setString(1, "fail2");
        pstmt.setString(2, "최재환");
        pstmt.setString(3, "123456");
        pstmt.setInt(4, 30);
        pstmt.setString(5, "chlwo796@naver.com");

        int rows = pstmt.executeUpdate();
        System.out.println(rows);

        pstmt.close();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } finally {
        try {
          if (conn != null) {
            conn.close();
          }
        } catch (SQLException e) {
        }
        System.out.println("연결 끊기");
      }
    }
  }
  ```

```java

// boards 테이블에 게시물 정보를 저장
// SEQ_BNO.NEXTVAL 은 SEQ_BNO 시퀀스에서 가져올 번호(저장된 마지막 번호 다음), SYSDATE는 현재시간
INSERT INTO boards (bno, bittle, bcontent, bwriter, bdate, bfilename, bfiledata)
VALUES (SEQ_BNO.NEXTVAL, '눈 오는 날', '함박눈이 내려요', 'winter', SYSDATE, 'snow.jpg', binaryData)

// SEQ_BNO.NEXTVAL와 SYSDATE를 제외하고 나머지는 ?로 대체한 매개변수화된 INSERT 문

String sql = "" + "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " + "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";

// 매개변수화된 INSERT 문을 실행
// 두번째 매개값은 INSERT 문이 실행된 후 가져올 컬럼 값이며, SQL 문이 실행되기 전까지는 SEQ_BNO.NEXTVAL로 얻은 번호를 모르기때문에, SQL문이 실행된 후 bno 컬럼에 실제로 저장된 값을 얻어보는 것이다.
PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});

// bfiledata 컬럼은 바이너리 타입(blob)이므로 ?에 값을 지정하려면 setBinaryStream(), setBlob(), setBytes() 메소드 중 하나를 이용한다.

pstmt.setString(1, "눈 오는 날");
pstmt.setString(2, "함박눈이 내려요.");
pstmt.setString(3, "winter");
pstmt.setString(4, "snow.jpg");
pstmt.setBlob(5, new FileInputStream("src/javaChap20/example02/8.jpg"));

// 게시물 정보가 저장되었을 경우(rows = 1) getGeneratedKeys() 메소드로 ResultSet을 얻고, getInt() 메소드로 bno를 얻는다.

int rows = pstmt.executeUpdate();
if(rows == 1){
  // new String{"bno"}에 기술된 컬럼 값을 가져온다.
  ResultSet rs = pstmt.getGeneratedKeys();

  if(rs.next()){
    // new String[]{"bno"} 의 첫번째 항목 bno 컬럼 값을 읽는다.
    int bno = rs.getInt(1);
  }
  rs.close();
}
```

- BoardWithFileInsertExample 예제

  ```java
  package javaChap20.example02;

  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.sql.Blob;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;

  public class BoardWithFileInsertExample {
    public static void main(String[] args) {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

        pstmt.setString(1, "눈 오는 날1");
        pstmt.setString(2, "함박눈이 내려요");
        pstmt.setString(3, "winter");
        pstmt.setString(4, "8.jpg");

  //			pstmt.setBlob(5, null);	// 컴파일오류, setBlob()메소드의 오버로딩과 관련. InputStream 타입인지, Blob타입인지 명시해주어야한다.
  //			Blob blob = null;	// 이를 해결하기 위한 Blob타입의 변수 선언 후 대입
        try {
          pstmt.setBlob(5, new FileInputStream("src/javaChap20/example02/8.jpg"));
        } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        int rows = pstmt.executeUpdate();
        System.out.println(rows);

        if (rows == 1) {
          ResultSet rs = pstmt.getGeneratedKeys();
          if (rs.next()) {
            // rs에 데이터가 없으면
            int bno = rs.getInt(1);
            System.out.println("저장된 bno : " + bno);
            String btitle = rs.getString(2);
            System.out.println("저장된 btitle : " + btitle);
          }
          rs.close();
        }

        pstmt.close();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } finally {
        try {
          if (conn != null) {
            conn.close();
          }
        } catch (SQLException e) {
        }
        System.out.println("연결 끊기");
      }
    }
  ```
