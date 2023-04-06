2023년 4월 6일 목요일

## day 67

### 1. oracle

- chap 13. 시퀀스 개념

  ```sql
  ------------------------------13장 시퀀스 개념------------------------------------
  -- 시퀀스 생성하기
  create sequence dept_deptno_seq
      start with 10
      increment by 10;

  -- 시퀀스 데이터 딕셔너리 보기
  desc user_sequences; -- 구조보기
  select *from user_sequences;

  -- 시퀀스의 현재값 currval
  select dept_deptno_seq.currval from dual; -- 처음 이것부터 수행하니깐? 에러, nextval 포인트(가르키는 위치) 위치 값을 보여준다.
  -- 시퀀스의 다음값 nextval
  select dept_deptno_seq.nextval from dual; -- 증가값 만큼 위치를 이동해서 값을 보여준다.

  drop sequence emp_seq;

  -- 시퀀스를 실제 테이블에서 어떻게 사용할까?
  create sequence emp_seq
      start with 1
      increment by 1
      maxvalue 1000;

  create table seqEmp(
      empno number(4), -- 자동으로 번호 증가되게
      name varchar2(20), -- 직접 입력
      beginDate date -- 자동으로 오늘 날짜가 입력되게
  );

  drop table seqEmp;

  insert into seqEmp values (emp_seq.nextval, '홍길동', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동2', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동3', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동4', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동5', sysdate);

  select *from seqEmp;

  -- sequence 수정하기
  alter sequence emp_seq
      increment by 10
      maxvalue 100
      cycle
      cache 2;

  insert into seqEmp values (emp_seq.nextval, '홍길동1', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동2', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동3', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동4', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동5', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동6', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동7', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동8', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동9', sysdate);
  insert into seqEmp values (emp_seq.nextval, '홍길동10', sysdate);

  select *from seqEmp;

  -- 인덱스 정보
  select * from user_ind_columns; -- 테이블을 만들 때 primary key는 자동으로 인덱스 처리

  -- 이름으로 검색하는 것이 빈번하며, 검색을 빠르게 하고 싶은 경우
  -- 해결책 이름을 인덱스로 만들어 주세요
  create index idx_emp_ename on emp(ename);



  select * from emp;
  select * from emp where job = '사원';

  drop index idx_emp_ename;

  select * from student;
  create index idx_student_name on student(stu_name);
  drop index idx_student_name;
  set timing on;
  select * from student where stu_name='장희성';
  set timing on;
  select * from student where sex != 'M';
  set timing on;
  -- 인덱스를 해야하는 경우
  -- 테이블의 행의 수가 많을 때
  -- where문에 해당 컬럼이 많이 사용될 때
  -- 검색결과가 전체 데이터의 2%~4%정도일 때
  -- join에 자주 사용되는 컬럼이나 null을 포함하는 컬럼이 많은 경우

  -- 인덱스하면 안 좋은 경우
  -- 테이블의 행의 수가 적을 때
  -- where문에 해당 컬럼이 적게 사용될 때
  -- 검색결과가 전체데이터의 10%~15%정도일 때
  -- 테이블에 DML을 자주 사용할 때
  ```

- chap 14. 사용자 권한

  ```txt

  0. 역할 만들기
  create role 역할명;

  1. 역할에다가 권한 주기
  grant  권한명1, 권한명2 ...  to 역할명;
  grant create user, drop user, drop any table, backup any table, create session, create table  to  ddba;
  2. tester40 역할부여
  grant  ddba to tester40;
  문) tester30사용자가
      tester20사용자가 만든 dept테이블을 검색하기

  dept테이블에 대한 권한은 tester20, system 이 가지고 있다.
  tester30 사용자는 dept테이블을 검색할 권한을 tester20 또는 system에 권한을 부여 받아야 한다.
  tester20 > grant  select on dept to tester30;

  tester30> select * from tester20.dept;
                              스키마명.객체명

  스키마는 객체를 소유한 사용자

  문)  tester30 사용자가
      tester20 사용자가 만든 dept테이블안에 레코드를 삽입하기

  문) tester30 사용자가
      tester20 사용자가 만든 dept테이블안에 레코드를 삭제하기

      인천 지역을 삭제하기

  -- 권한 뺏기
  누가 뺏을 수 있을까? 관리자(system, sys), 객체를 만든 사용자/역할

  문)   tester30 사용자가
          tester20 사용자가 만든 dept테이블안에 레코드를 삽입하지 못하게 권한을 뺏기
  tester20 > revoke insert on dept from tester30;

  문)  tester30 사용자가
      tester20 사용자가 만든 dept테이블안에 레코드를 삭제하지 못하게 권한을 뺏기
  system > revoke  delete on tester20.dept from tester30;
  ```

---

### 2. java, oracle

- db, jdbc 연결

  ```java
  package javaHigh12;

  import java.io.FileInputStream;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;

  public class BoardsInsertEx {

      public static void main(String[] args) {
          Connection conn = null;
          try {
              Class.forName("oracle.jdbc.OracleDriver");
              conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
              System.out.println("연결 성공");
              String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
              PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
              pstmt.setString(1,"이게 뭐야");
              pstmt.setString(2, "이게 무슨 사진");
              pstmt.setString(3, "winter");
              pstmt.setString(4, "2.jpg");
              pstmt.setBlob(5, new FileInputStream("src/javaHigh12/2.jpg"));

              int rows = pstmt.executeUpdate();	// 데이터베이스 insert문 실행
              System.out.println("저장된 행 수 : " + rows);
              if(rows == 1) {
                  ResultSet rs = pstmt.getGeneratedKeys();	// new String[] {"bno"} 에 기술된 컬럼값
                  if(rs.next()) {
                      int bno = rs.getInt(1);	// insert 후 생성된 시퀀스넘버를 가져옴(확인용)
                      System.out.println("저장된 bno : " + bno);
                  }
                  rs.close();
              }
          } catch (Exception e) {
              e.printStackTrace();
          } // jdbc driver 등록
          finally {
              if (conn != null) {
                  try {
                      conn.close();
                  } catch (SQLException e) {
                  }
              }
          }
      }
  }
  ```

### 3. memo

- [oracle | error ora-00937](https://itprogramming119.tistory.com/entry/Oracle-Error-ORA-00937-not-a-single-group-group-function)
- [oracle | error ora-00918](https://mine-it-record.tistory.com/167)
