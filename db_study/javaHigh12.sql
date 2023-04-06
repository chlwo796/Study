-- 권한부여

grant create session to tester20;

create user tester30 identified by 1234;
create user tester40 identified by 1234;

grant create session to tester30;
grant create session to tester40;

-- 자바 교재에 있는 테이블

create table users(
userid varchar2(50) primary key,
username varchar2(50) not null,
userpassword varchar2(50) not null,
userage number(3) not null,
useremail varchar2(50) not null
);

-- 게시물 정보 테이블
create table boards(
bno number primary key,
btitle varchar2(100) not null,
bcontent clob not null, -- clob = 문자형식 큰용량 데이터타입
bwriter varchar2(50) not null,
bdate date default sysdate,
bfilename varchar2(50) null,
bfiledata blob null -- blob = 바이너리 형식의 큰용량 데이터타입
);

-- bno 컬럼 자동 시퀀스 형식
create sequence seq_bno nocache;

create table accounts(
ano varchar2(20) primary key,
owner varchar2(20) not null,
balance number not null
);

insert into accounts(ano, owner, balance) values('111-111-1111', '하여름', 1000000);
insert into accounts values('222-222-2222', '한겨울', 0);

select * from accounts;

commit;

    -- 프로시저 : 단문의 sql문을 연결하여서 순차적으로 처리하게 만드는 프로그램
    CREATE OR REPLACE PROCEDURE user_create (
    -- a_userid라는 변수는, in 입력변수, users.userid%type users 테이블의 userid컬럼의 자료형으로 한다.
    a_userid        IN  users.userid%TYPE, 
    a_username      IN  users.username%TYPE,
    a_userpassword  IN  users.userpassword%TYPE,
    a_userage       IN  users.userage%TYPE,
    a_useremail     IN  users.useremail%TYPE,
    -- pls_integer = 출력되는 자료는 정수형
    a_rows          OUT PLS_INTEGER
) 
IS
BEGIN
    -- 레코드삽입
    INSERT INTO users (userid, username, userpassword, userage, useremail)
    VALUES (a_userid, a_username, a_userpassword,  a_userage, a_useremail);
    -- 행의 수를 세어서 a_rows 변수에 넣어주기
    a_rows := SQL%ROWCOUNT;
    COMMIT;
END;
/

CREATE OR REPLACE FUNCTION user_login (
    a_userid        users.userid%TYPE, 
    a_userpassword  users.userpassword%TYPE
) RETURN PLS_INTEGER
IS
    v_userpassword users.userpassword%TYPE;
    v_result PLS_INTEGER;
BEGIN
    SELECT userpassword INTO v_userpassword
    FROM users
    WHERE userid = a_userid;

    IF v_userpassword = a_userpassword THEN
        RETURN 0;
    ELSE
        RETURN 1;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN 
        RETURN 2;
END;
/
commit;

select * from users;

insert into boards(bno, btitle, bcontent, bwriter) values (1000, '게시판제목1', '게시판내용1', '홍길동1');
desc boards;
select * from boards;

delete from boards;
select * from boards;

select seq_bno.nextval from dual;
