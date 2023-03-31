2023년 3월 31일 금요일

## day63

### 1. oracle

    ```sql
    -- 7장 테이블 구조 생성, 변경, 제거하는 DDL(Database Define Language) 데이터정의어
    -- 목표 테이블 만들고 수정 삭제
    -- tester1DB = 스키마
    create table emp01(
    empno number(4),
    ename varchar2(14),
    sal number(7,3)
    );
    -- 테이블 구조 확인
    desc emp01;
    create table emp02(
        empno number(4) default 1000,
        ename varchar2(14) default '홍길동',
        sal number(7,3)
    );

    insert into emp01(empno) values (2000);
    insert into emp02(sal) values (500);

    -- 테이블 구조를 만들기 이름 부서명 입사일-기본값으로 오늘 날짜
    create table emp03(
        ename varchar2(14),
        dname varchar2(14),
        hiredate date default sysdate
    );
    insert into emp03 values ('최진영', '전산부', '2022/10/08');
    insert into emp03 values ('이수민', '영업부', '2023/03/03');

    select * from emp03;

    alter table emp01
        add(birth date default sysdate);

    desc emp01;

    --sal 컬럼의 자료형을 number(7,3) --> number(8)로 변경하기

    alter table emp01
        modify(sal number(8));

    -- empno varchar2(10) ename varchar2(20)으로 변경하기
    alter table emp01
        modify (empno varchar2(10), ename varchar2(20));

    select * from emp01;
    desc emp01;

    update emp01 set empno = null;

    --sal 컬럼을 지우기

    alter table emp02
        drop column sal;

    desc emp02;

    -- deptno, hiredate 컬럼을 모두 삭제하기
    alter table emp03
        drop column deptname;

    alter table emp03
        drop column hiredate;

    desc emp03;

    --레코드수가 아주 많은 경우에 컬럼변경(추가, 수정, 삭제)할 경우 데이터베이스 속도가 느려진다.
    --삭제할 컬럼을 바로 바로 지우는게 아니라 unused로 만들어 두고 나중에 한꺼번에 삭제합니다.

    select * from emp02; --unused된 컬럼은 검색이 되지 않는다.
    alter table emp02
        set unused(ename);  -- 사용하지 않을 컬럼을 체크하는것

    desc emp02;


    alter table emp02 --unused된 컬럼을 완전히 제거한다.
        drop unused columns;

    --table 변경
    select * from emp01;
    -- 테이블 이름 변경
    rename emp01 to newEmp01;
    select * from newEmp01;
    desc newEmp01;

    -- 테이블의 구조를 제거하는 것 = 테이블 제거
    drop table newEmp01;
    drop table emp03;

    -- 테이블 속안에 데이터를 모두 삭제
    create table copyEmp as select * from emp;
    -- 테이블 속 안에 데이터(레코드)를 모두 삭제하기 방법1) delete 문, 방법2) truncate table 문
    select * from copyEmp;
    -- delete문으로 트랜잭션에서 작업이 이루어지므로 commit 전에 rollback 하여 삭제를 취소할 수 있다.
    delete from copyEmp;
    -- 방금전에 했던 명령 되돌리기 트랜잭션에서 작업하는 것 되돌리기
    rollback;
    -- 트랜잭션은 은행에서 예금 인출처럼 100% 완료되어야 성공, 중간에 멈추면 처음으로 되돌아 가는 것
    truncate table copyEmp;
    -- truncate table은 데이터베이스 내부에서 처리, rollback 처리 x
    -- ~~쓴다 = 저장, 삭제, 수정, 삽입 내포되어있음
    -- ~~읽는다 = 보기만 가능
    select table_name from user_tables;
    select * from user_tables;
    select table_name, max_trans from user_tables;
    select * from all_tables;
    -- dba = 시스템 관리와 관련
    --select * from dba_tables; -- 로컬에서 dba 접근 x

    -- 데이터 딕셔너리
    -- 사용자가 만드는 테이블이 아니고 데이터베이스 서버에서 자동으로 만들고 수정하여 준다.
    -- 사용자는 보기만 한다. 사용자는 데이터베이스 서버안에 들어 있는 정보를 볼때 이용한다.
    -- user_  all_  dba_
    --------------------------
    -- dml = data manipulation language, 데이터 조작어, 웹개발자가 자바코드에 명령어 써준다.
    -- select insert update delete
    create table dept01(
        deptno number(2),
        dname varchar2(14),
        loc varchar2(13)
    );

    desc dept01;
    -- 수정 및 복사
    insert into dept01 values(10, '경리부', '서울');
    -- 특정 행 삽입
    insert into dept01 select deptno, dname, loc from dept where deptno = 20;
    -- 여러개 삽입
    insert into dept01 select deptno, dname, loc from dept;
    -- loc = null로 삽입
    insert into dept01 (deptno, dname) select deptno, dname from dept;
    select * from dept;

    select * from dept where deptno = 20;

    -- 숫자 삽입, 문자 삽입, 날짜 삽입, null 삽입
    alter table dept01 add birth date;
    -- deptno 20 or 30 인 레코드 안에 오늘 ㅇ날짜로 생일을 넣어 주세요
    insert into dept01 select deptno, dname, loc, sysdate from dept where deptno in (20, 30);
    desc dept01;
    select * from dept01;
    --dname 전산부인 사람의 birth를 1990/12/25로 삽입
    ```

---

### 2. memo

- [css | inputbox 클릭시 속성변경](https://jostorys.tistory.com/18)
- [css | background-image 속성](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=skydoor2014&logNo=220686864738)
- [css | easing의 종류 및 사용법](https://sseozzzy.tistory.com/38)
