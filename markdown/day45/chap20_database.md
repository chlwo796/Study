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

---

### 7. 데이터 수정

- JDBC를 이용해서 UPDATE 문을 실행하는 방법
- boards 테이블에 저장된 게시물 중에서 bno가 1인 게시물의 btitle, bfilename, bfiledata를 변경하는 SQL문

  ```sql
  UPDATE boards SET
  btitle = '눈사람',
  bcontent= '눈으로 만든 사람',
  bfilename = 'snowman.jpg',
  bfiledata = binaryData
  WHERE bno = 3
  -- , 는 구분자로 사용되기때문에 마지막에는 넣지 않는다.
  -- 값을 ?로 대체한 매개변수화된 UPDATE 문으로 변경

  UPDATE boards SET
  btitle = ?
  bcontent = ?,
  bfilename = ?,
  bfiledata = ?
  WHERE bno=?
  ```

  ```java
  // String 타입 변수 sql에 매개변수화된 UPDATE 문을 저장
  String sql = new StringBuilder()
  .append("UPDATE board SET ")
  .append("btitle=?, ")
  .append("bcontent=?, ")
  .append("bfilename=?, ")
  .append("bfiledata=?, ")
  .append("WHERE bno=?")
  .toString();

  // 매개변수화된 UPDATE 문을 실행하기 위해 다음과 같이 prepareStatement() 메소드로부터 PreparedStatement를 얻고, ?에 해당하는 값을 지정
  PreparedStatement pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, "눈사람");
  pstmt.setString(2, "눈으로 만든 사람");
  pstmt.setString(3, "8.jpg");
  pstmt.setBlob(4, new FileInputStream("src/javaChap20/example02/8.jpg");
  pstmt.setInt(5,3);

  int rows = pstmt.executeUpdate();
  // 성공적으로 실행되면 수정된 행의 수 가 리턴
  // 0을 리턴하면 조건에 맞는 행이 없어 수정된 내용이 없음을 의미한다.
  ```

- 수정 중 커밋이나 롤백을 하지 않으면, 사실상 해당 클라이언트에서 계속 수정상태에 있는 것이므로, 데이터베이스에 제대로 적용이 안된다면 수정중인 클라이언트에서 커밋이나 롤백을 하여 락을 풀어준다.

- BoardUpdateExample 예제

  ```java
  package javaChap20.example03;

  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;

  public class BoardUpdateExample {
    public static void main(String[] args) throws FileNotFoundException {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = new StringBuilder()
            // 각 문 끝에는 " "공백을 넣어주는 것이 좋다(실수방지)
            .append("update boards set ").append("btitle=?, ").append("bcontent=?, ").append("bfilename=?, ")
            .append("bfiledata=? ").append("where bno=?").toString();
        PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

        pstmt.setString(1, "소나기가");
        pstmt.setString(2, "소나기가 엄청내려여");
        pstmt.setString(3, "rain");
        pstmt.setBlob(4, new FileInputStream("src/javaChap20/example03/3.jpg"));
        pstmt.setInt(5, 3);

        int rows = pstmt.executeUpdate();
        System.out.println("수정된 행 수 : " + rows);

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

---

### 8. 데이터 삭제

- JDBC를 이용하여 DELETE 문을 실행하는 방법
- boards 테이블에서 bwriter가 winter인 모든 게시물을 삭제하는 DELETE문

  ```sql
  -- where이 없으면 전체삭제
  DELETE FROM boards WHERE bwriter = 'winter'

  -- 조건절의 값을 ?로 대체한 매개변수화된 DELETE문
  DELETE FROM boards WHERE bwriter = ?
  ```

  ```java
  // 매개변수화된 DELETE 문을 실행하기 위해 다음과 같이 prepareStatement() 메소드로부터 PreparedStatement를 얻는다.
  String sql = "DELETE FROM boards WHERE bwriter=?";
  PreparedStatement pstmt = conn.prepareStatement(sql);

  // ?에 값을 지정한 후, executeUpdate로 SQL문 실행
  pstmt.setString(1,"winter");

  // 정상실행 후 삭제된 행 수 리턴(0일수도 있다)
  int rows = pstmt.executeUpdate();
  ```

- BoardDeleteExmaple 예제

  ```java
  package javaChap20.example04;

  import java.io.FileNotFoundException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;

  public class BoardDeleteExample {
    public static void main(String[] args) throws FileNotFoundException {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = "delete from boards where bwriter=? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "winter");
        int rows = pstmt.executeUpdate();
        System.out.println("삭제된 행 수 : " + rows);

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

### 9. 데이터 읽기

- PreparedStatement를 생성할 때 SQL 문이 INSERT, UPDATE, DELETE일 경우에는 executeUpdate() 메소드를 호출하지만, 데이터를 가져오는 SELECT 문일 경우에는 executeQuery() 메소드를 호출해야 한다.

```java
// executeQuery() 메소드는 가져온 데이터를 ResultSet에 저장하고 리턴한다.
ResultSet rs = pstmt.executeQuery();
```

1. ResultSet 구조

- ResultSet은 SELECT 문에 기술된 컬럼으로 구성된 행(row)의 집합이다.

```sql
-- userid, username, userage 컬럼으로 구성된 ResultSet을 리턴
SELECT userid, username, userage FROM users
```

- 위 SELECT문이 가져온 데이터 행이 4개라면 ResultSet의 내부 구조는 다음과 같다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/b9b2aae3-bdf0-40b2-ac68-dfbcaf2f4752/image.png)

- ResultSet의 특징은 커서(cursor)가 있는 행의 데이터만 읽을 수 있다는 것이며, 커서는 행을 가리키는 포인터를 말한다.
- ResultSet에는 실제 가져온 데이터 행의 앞과 뒤에 beforeFirst 행과 afterLast 행이 붙는데, 최초 커서는 beforeFirst를 가리키며, 첫번째 데이터 행인 first 행을 읽으려면 커서를 이동시켜야 한다.

```java
boolean result = rs.next();
```

- next() 메소드는 커서를 다음 행으로 이동시키는데, 이동한 행에 데이터가 있으면 true를, 없으면 false를 리턴한다.
- SELECT문으로 가져온 데이터 행이 없다면 beforeFirst 행과, afterLast 행이 붙어 있기 때문에 첫 번째 next() 결과는 false가 된다.

  ```java
  // 1개의 데이터 행만 가져올 경우
  // 주로 SELECT문이 기본 키(primary key)를 조건으로 데이터를 가져오는 경우
  ResultSet rs = pstmt.executeQuery();
  if(rs.next()){
    // 첫 번째 데이터 행 처리
  }else{
    // afterLast 행으로 이동했을 경우
  }
  // n개의 데이터 행을 가져올 경우
  ResultSet rs = pstmt.executeQuery();
  while(rs.next()){
    // last 행까지 이동하면서 데이터 행 처리
  }
    // afterLast 행으로 이동했을 경우
    // 더 이상 사용하지 않는다면, ResultSet이 사용한 메모리를 해제한다.
    rs.close();
  ```

2. 데이터 행 읽기

- 커서가 있는 데이터 행에서 각 컬럼의 값은 Getter 메소드로 읽을 수 있으며, 컬럼의 데이터 타입에 따라 getType() 메소드가 사용되며, 매개값으로 컬럼의 이름 또는 순번을 줄 수 있다.

  ```java
  // 컬럼 이름으로 읽기
  String userId = rs.getString("userid");
  String userName = rs.getString("username");
  int userAge = rs.getInt("userage");

  // 컬럼 순번으로 읽기
  // ResultSet에서 컬럼 순번은 1부터 3까지, userid =1, username = 2, userage = 3이다.
  String userId = rs.getString(1);
  String userName = rs.getString(2);
  int userAge = rs.getInt(3);
  ```

  ```sql
  -- SELECT문에 연산식이나 함수 호출
  SELECT userid, userage - 1
  FROM users

  -- (userage-1) as userage와 같이 별명(alias)가 있으면 별명을 컬럼이름으로 사용한다.
  ```

  ```java
  // 컬럼 이름을 사용할 수 없고, 컬럼 순번으로 읽어야 한다.
  String userId = rs.getString("userid");
  int userAge = rs.getInt(2);
  ```

3. 사용자 정보 읽기

- 컬럼 개수와 타입에 맞게 필드를 선언하고, 롬복 @Data 어노테이션을 이용하여 Getter, Setter, toString() 메소드를 자동생성시킨다.
- DTO 클래스 생성(User), 롬복을 이용할 수도 있다.

  ```java
  package javaChap20.example05;

  // DTO 클래스
  public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public String getUserPassword() {
      return userPassword;
    }

    public void setUserPassword(String userPassword) {
      this.userPassword = userPassword;
    }

    public int getUserAge() {
      return userAge;
    }

    public void setUserAge(int userAge) {
      this.userAge = userAge;
    }

    public String getUserEmail() {
      return userEmail;
    }

    public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + userAge;
      result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
      result = prime * result + ((userId == null) ? 0 : userId.hashCode());
      result = prime * result + ((userName == null) ? 0 : userName.hashCode());
      result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      User other = (User) obj;
      if (userAge != other.userAge)
        return false;
      if (userEmail == null) {
        if (other.userEmail != null)
          return false;
      } else if (!userEmail.equals(other.userEmail))
        return false;
      if (userId == null) {
        if (other.userId != null)
          return false;
      } else if (!userId.equals(other.userId))
        return false;
      if (userName == null) {
        if (other.userName != null)
          return false;
      } else if (!userName.equals(other.userName))
        return false;
      if (userPassword == null) {
        if (other.userPassword != null)
          return false;
      } else if (!userPassword.equals(other.userPassword))
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userAge="
          + userAge + ", userEmail=" + userEmail + "]";
    }

    public User() {
      // TODO Auto-generated constructor stub
    }

    public User(String userId, String userName, String userPassword, int userAge, String userEmail) {
      super();
      this.userId = userId;
      this.userName = userName;
      this.userPassword = userPassword;
      this.userAge = userAge;
      this.userEmail = userEmail;
    }

  }
  ```

- userid가 winter인 사용자 정보를 가져오는 SELECT 문

  ```sql
  SELECT userid, username, userpassword, userage, useremail
  FROM users
  WHERE userid = 'winter';
  ```

  ```java
  // 조건절의 값을 ?로 대체한 매개변수화된 SQL문을 String 타입 변수 sql에 대입
  String sql = "select userid, username, userpassword, userage, useremail from users where userid=?";
  ```

  ```java
  // 매개변수화된 SELECT 문을 실행하기 위해 다음과 같이 prepareStatement() 메소드로부터 PreparedStatement를 얻는다.
  PreparedStatement pstmt = conn.prepareStatement(sql);
  // ?에 값을 지정
  pstmt.setString(1, "winter");
  ```

- userid는 기본 키이므로 조건에 맞는 행은 1개이거나 0개며, if문을 이용해서 next() 메소드가 true를 리턴할 경우에는 데이터 행을 User 객체에 저장하고 출력한다.

  ```java
  // executeQuery() 메소드로 SELECT 문을 실행해서 ResultSet을 얻는다.
  ResultSet rs = pstmt.executeQuery();
  if (rs.next()) {
  User user = new User();
  user.setUserId(rs.getString("userId"));
  user.setUserName(rs.getString("username"));
  user.setUserPassword(rs.getString("userpassword"));
  user.setUserAge(rs.getInt(4));
  user.setUserEmail(rs.getString(5));
  System.out.println(user);

  } else {
  System.out.println("사용자 아이디가 존재하지 않습니다.");
  }
  ```

- UserSelectExample 예제

  ```java
  package javaChap20.example05;

  import java.io.FileNotFoundException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;

  public class UserSelectExample {
    public static void main(String[] args) throws FileNotFoundException {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = "select userid, username, userpassword, userage, useremail from users where userid=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "winter");
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
          // 매개변수를 직접 받으니 데이터 양이 많아질수록 매우 불편하다..(컬럼양)
  //				String userId = rs.getString("userid");
  //				String userName = rs.getString("username");
  //				String userPassword = rs.getString("userpassword");
  //				int userAge = rs.getInt("userage");
  //				String userEmail = rs.getString("useremail");
  //				printUser(userId, userName, userPassword, userAge, userEmail);

          User user = new User();
          user.setUserId(rs.getString("userId"));
          user.setUserName(rs.getString("username"));
          user.setUserPassword(rs.getString("userpassword"));
          user.setUserAge(rs.getInt("userage"));
          user.setUserEmail(rs.getString("useremail"));

          printUser2(user);

        } else {
          System.out.println("사용자 아이디가 존재하지 않습니다.");
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

    public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
      // 매개변수를 직접 받으니 데이터 양이 많아질수록 매우 불편하다..
      System.out.println("userId: " + userId);
      System.out.println("userName: " + userName);
      System.out.println("userPassword: " + userPassword);
      System.out.println("userEmail: " + userEmail);
      System.out.println("userAge: " + userAge);
    }

    public static void printUser2(User user) {
      System.out.println("userId: " + user.getUserId());
      System.out.println("userName: " + user.getUserName());
      System.out.println("userPassword: " + user.getUserPassword());
      System.out.println("userEmail: " + user.getUserEmail());
      System.out.println("userAge: " + user.getUserAge());
      // toString() 으로 간편하게
      System.out.println(user);
    }
  }
  ```

4. 게시물 정보 읽기

- boards 테이블의 1개 행(게시물)을 저장할 Board 클래스를 작성한다.

  ```java
  package javaChap20.example06;

  import java.sql.Blob;
  import java.util.Date;

  public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    private String bfilename;
    private Blob bfiledata;

    public int getBno() {
      return bno;
    }

    public void setBno(int bno) {
      this.bno = bno;
    }

    public String getBtitle() {
      return btitle;
    }

    public void setBtitle(String btitle) {
      this.btitle = btitle;
    }

    public String getBcontent() {
      return bcontent;
    }

    public void setBcontent(String bcontent) {
      this.bcontent = bcontent;
    }

    public String getBwriter() {
      return bwriter;
    }

    public void setBwriter(String bwriter) {
      this.bwriter = bwriter;
    }

    public Date getBdate() {
      return bdate;
    }

    public void setBdate(Date bdate) {
      this.bdate = bdate;
    }

    public String getBfilename() {
      return bfilename;
    }

    public void setBfilename(String bfilename) {
      this.bfilename = bfilename;
    }

    public Blob getBfiledata() {
      return bfiledata;
    }

    public void setBfiledata(Blob bfiledata) {
      this.bfiledata = bfiledata;
    }

    public Board() {
      // TODO Auto-generated constructor stub
    }

    public Board(int bno, String btitle, String bcontent, String bwriter, Date bdate, String bfilename,
        Blob bfiledata) {
      super();
      this.bno = bno;
      this.btitle = btitle;
      this.bcontent = bcontent;
      this.bwriter = bwriter;
      this.bdate = bdate;
      this.bfilename = bfilename;
      this.bfiledata = bfiledata;
    }

    @Override
    public String toString() {
      return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
          + ", bdate=" + bdate + ", bfilename=" + bfilename + ", bfiledata=" + bfiledata + "]";
    }

  }
  ```

- bwriter가 bwinter인 게시물 정보를 가져오는 SELECT 문

  ```sql
  select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata
  from boards
  where bwriter='winter';
  ```

- 조건절의 값을 ?로 대체한 매개변수화된 SELECT 문을 String 타입 변수 sql에 대입

  ```java
  String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards where bwriter=?";
  ```

- 매개변수화된 SELECT 문을 실행하기 위해 다음과 같이 prepareStatement() 메소드로부터 PreparedStatement를 얻고 ?에 값을 저장

  ```java
  PreparedStatement pstmt = conn.prepareStatement(sql);

  pstmt.setString(1, "winter");

  ```

- executeQuery() 메소드로 SELECT문을 실행한 후 ResultSet을 얻는다.
- 조건에 맞는 행은 n개이므로 while 문을 이용해서 next() 메소드가 false를 리턴할때 까지 반복

  ```java
  while (rs.next()) {
  Board board = new Board();
  board.setBno(rs.getInt("bno"));
  board.setBtitle(rs.getString("btitle"));
  board.setBcontent(rs.getString("bcontent"));
  board.setBwriter(rs.getString("bwriter"));
  board.setBdate(rs.getDate("bdate"));
  board.setBfilename(rs.getString("bfilename"));
  board.setBfiledata(rs.getBlob("bfiledata"));

  System.out.println(board);
  }
  ```

- Boards의 bfiledate는 Blob 객체이므로 콘솔에 출력하면 의미 없는 타입 정보만 촐력된다.
- Blob 객체에 저장된 바이너리 데이터를 얻기 위해서는 다음과 같이 입력스트림 또는 배열을 얻어내야한다.

  ```java
  Blob blob = board.getBfiledata();
  InputStream is = blob.getBinaryStream();

  // UI에 그릴 때 배열로 풀어준다.
  byte[] bytes = blob.getBytes(0,blob.length());

  // Blob 객체에서 InputStream을 얻고, 읽은 바이트를 파일로 저장하는 방법
  InputStream is = blob.getBinaryStream();
  OutputStream os = new FileOutputStream("c:/jhc/" + board.getBfilename());
  is.transferTo(os);
  os.flush();
  os.close();
  is.close();
  ```

- BoardSelectExample 예제

  ```java
  package javaChap20.example06;

  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.OutputStream;
  import java.sql.Blob;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.util.ArrayList;
  import java.util.List;

  public class BoardSelectExample {
    public static void main(String[] args) throws IOException {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        // DB작업
        String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards where bwriter=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "winter");
        ResultSet rs = pstmt.executeQuery();
        List<Board> boards = new ArrayList<>();
        while (rs.next()) {
          Board board = new Board();
          board.setBno(rs.getInt("bno"));
          board.setBtitle(rs.getString("btitle"));
          board.setBcontent(rs.getString("bcontent"));
          board.setBwriter(rs.getString("bwriter"));
          board.setBdate(rs.getDate("bdate"));
          board.setBfilename(rs.getString("bfilename"));
          board.setBfiledata(rs.getBlob("bfiledata"));

          Blob blob = board.getBfiledata();
          if (blob != null) {
            InputStream is = blob.getBinaryStream();
            OutputStream os = new FileOutputStream("c:/jhc/" + board.getBfilename());
            is.transferTo(os);
            os.flush();
            os.close();
            is.close();
          }
          boards.add(board);
        }
        rs.close();

        printBoards(boards);

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

    public static void printBoards(List<Board> boards) {
      for (Board board : boards) {
        System.out.println(board);
      }
      // 스트림으로 이용
      boards.stream().forEach(b -> System.out.println(b));
    }
  }
  ```

---

### 10. 프로시저와 함수 호출

- 프로시저와 함수는 Oracle DB에 저장되는 PL/SQL 프로그램이며, 클라이언트 프로그램에서 매개값과 함께 프로시저 또는 함수를 호출하면 DB 내부에서 일련의 SQL 문을 실행하고, 실행 결과를 클라이언트 프로그램으로 돌려주는 역할을 한다.
- JDBC에서 프로시저와 함수를 호출할 때는 CallableStatement를 사용하며, 프로시저와 함수의 매개변수화된 호출문을 작성하고 Connection의 prepareCall() 메소드로부터 CallableStatement 객체를 얻을 수 있다.

  ```java
  // user_create라는 이름의 프로시저 호출
  String sql = "{call user_create(?, ?, ?, ?, ?, ?)}";
  CallableStatement cstmt = conn.prepareCall(sql);
  ```

  ```java
  // user_login이라는 이름의 함수 호출
  String sql = "{? = call user_login(?, ?)}";
  CallableStatement cstmt = conn.prepareCall(sql);
  ```

- 함수는 call 문의 실행 결과를 대입할 좌측 리턴값의 자리(?=)를 명시해야하며, 첫번째 ?가 무조건 리턴값이다.
- 프로시저도 리턴값과 유사한 OUT타입의 매개변수를 가질 수 있고, 괄호 안의 ? 중 일부는 OUT값(리턴값)일 수 있다.
- prepareCall() 메소드로 CallableStatement를 얻었다면 리턴값에 해당하는 ?는 registerOutParameter() 메소드로 지정하고, 그 이외의 ?는 호출 시 필요한 매개값으로 Setter 메소드를 사용해서 값을 지정해야한다.

  ```java
  String sql = "{call user_create(?, ?, ?, ?, ?, ?)}";
  CallableStatement cstmt = conn.prepareCall(sql);

  cstmt.setString(1, "summer"); // 프로시저의 첫 번째 매개값
  cstmt.setString(2, "한여름");
  cstmt.setString(3, "12345");
  cstmt.setInt(4, 26);
  cstmt.setString(5, "summer@mycompany.com");
  cstmt.registerOutParameter(6, Types.INTEGER); // OUT값(리턴값) 지정
  ```

  ```java
  String sql = "{? = call user_login(?, ?)}";
  CallableStatement cstmt = conn.prepareCall(sql);

  cstmt.registerOutParameter(1, Types.INTEGER); // 리턴값 지정
  cstmt.setString(2, "winter"); // 함수의 첫번째 매개값
  cstmt.setString(3, "12345");
  ```

- ?에 대한 설정이 끝나면 프로시저 또는 함수를 호출하기 위해 execute() 메소드를 다음과 같이 호출

  ```java
  cstmt.execute();
  int rows = cstmt.getInt(6); // 프로시저의 리턴값 저장
  int result = cstmt.getInt(1); // 함수의 리턴값 저장

  cstmt.close();  // 종료
  ```

1. 프로시저 호출

- user_create는 앞 5개의 IN 매개변수와 마지막 OUT 매개변수로 구성되어 있으며, IN 매개변수는 호출 시 필요한 매개값으로 사용되며, OUT 매개변수는 리턴값으로 사용된다.

```sql
create or replace PROCEDURE user_create (
-- 외부에서 받는값 = IN
    a_userid        IN  users.userid%TYPE,
    a_username      IN  users.username%TYPE,
    a_userpassword  IN  users.userpassword%TYPE,
    a_userage       IN  users.userage%TYPE,
    a_useremail     IN  users.useremail%TYPE,
    a_rows          OUT PLS_INTEGER
)
```

- ProcedureCallExample 예제

  ```java
  package javaChap20.example07;

  import java.sql.CallableStatement;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import java.sql.Types;

  public class ProcedureCallExample {
    public static void main(String[] args) {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        String sql = "{call user_create(?, ?, ?, ?, ?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);

        cstmt.setString(1, "summer");
        cstmt.setString(2, "한여름");
        cstmt.setString(3, "12345");
        cstmt.setInt(4, 26);
        cstmt.setString(5, "summer@mycompany.com");
        cstmt.registerOutParameter(6, Types.INTEGER);

        cstmt.execute();
        int rows = cstmt.getInt(6);
        System.out.println("저장된 행 수 :" + rows);
        cstmt.close();
      } catch (Exception e) {
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

2. 함수 호출

- user_login()은 2개의 매개변수와 PLS_INTEGER 리턴 타입으로 구성되어 있으며, 2개의 매개변수는 호출 시 값을 제공하고, 호출 후에는 정수 값을 리턴한다는 의미이다.

  ```sql
  create or replace FUNCTION user_login (
      a_userid        users.userid%TYPE,
      a_userpassword  users.userpassword%TYPE
  ) RETURN PLS_INTEGER
  IS
  -- 변수선언하는곳
      v_userpassword users.userpassword%TYPE;
      v_result PLS_INTEGER;
  BEGIN
  -- (INTO)db 패스워드를 v 패스워드에 저장한다.
      SELECT userpassword INTO v_userpassword
      FROM users
      WHERE userid = a_userid;
  --  = 비교연산자
      IF v_userpassword = a_userpassword THEN
          RETURN 0;
      ELSE
          RETURN 1;
      END IF;
  --    패스워드데이터가 없을 때 예외처리
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
          RETURN 2;
  END;
  ```

- FunctionCallExample 예제

  ```java
  package javaChap20.example07;

  import java.sql.CallableStatement;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import java.sql.Types;

  public class FunctionCallExample {
    public static void main(String[] args) {
      Connection conn = null;
      try {
        // JDBC Driver를 메모리로 로딩, DriverManager 등록
        Class.forName("oracle.jdbc.OracleDriver");

        // DB와 연결

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
        System.out.println("연결 성공");

        String sql = "{? = call user_login(?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);

        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, "winter");
        cstmt.setString(3, "12345");

        cstmt.execute();
        int result = cstmt.getInt(1);
        switch (result) {
        case 0:
          System.out.println("로그인성공");
          break;
        case 1:
          System.out.println("비밀번호오류");
          break;
        case 2:
          System.out.println("존재하지않는아이디");
          break;
        }
        cstmt.close();
      } catch (Exception e) {
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
