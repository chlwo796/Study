-- ���Ѻο�

grant create session to tester20;

create user tester30 identified by 1234;
create user tester40 identified by 1234;

grant create session to tester30;
grant create session to tester40;

-- �ڹ� ���翡 �ִ� ���̺�

create table users(
userid varchar2(50) primary key,
username varchar2(50) not null,
userpassword varchar2(50) not null,
userage number(3) not null,
useremail varchar2(50) not null
);

-- �Խù� ���� ���̺�
create table boards(
bno number primary key,
btitle varchar2(100) not null,
bcontent clob not null, -- clob = �������� ū�뷮 ������Ÿ��
bwriter varchar2(50) not null,
bdate date default sysdate,
bfilename varchar2(50) null,
bfiledata blob null -- blob = ���̳ʸ� ������ ū�뷮 ������Ÿ��
);

-- bno �÷� �ڵ� ������ ����
create sequence seq_bno nocache;

create table accounts(
ano varchar2(20) primary key,
owner varchar2(20) not null,
balance number not null
);

insert into accounts(ano, owner, balance) values('111-111-1111', '�Ͽ���', 1000000);
insert into accounts values('222-222-2222', '�Ѱܿ�', 0);

select * from accounts;

commit;

    -- ���ν��� : �ܹ��� sql���� �����Ͽ��� ���������� ó���ϰ� ����� ���α׷�
    CREATE OR REPLACE PROCEDURE user_create (
    -- a_userid��� ������, in �Էº���, users.userid%type users ���̺��� userid�÷��� �ڷ������� �Ѵ�.
    a_userid        IN  users.userid%TYPE, 
    a_username      IN  users.username%TYPE,
    a_userpassword  IN  users.userpassword%TYPE,
    a_userage       IN  users.userage%TYPE,
    a_useremail     IN  users.useremail%TYPE,
    -- pls_integer = ��µǴ� �ڷ�� ������
    a_rows          OUT PLS_INTEGER
) 
IS
BEGIN
    -- ���ڵ����
    INSERT INTO users (userid, username, userpassword, userage, useremail)
    VALUES (a_userid, a_username, a_userpassword,  a_userage, a_useremail);
    -- ���� ���� ��� a_rows ������ �־��ֱ�
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

insert into boards(bno, btitle, bcontent, bwriter) values (1000, '�Խ�������1', '�Խ��ǳ���1', 'ȫ�浿1');
desc boards;
select * from boards;

delete from boards;
select * from boards;

select seq_bno.nextval from dual;
