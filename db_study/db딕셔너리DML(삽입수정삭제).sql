-- 7�� ���̺� ���� ����, ����, �����ϴ� DDL(Database Define Language) ���������Ǿ�
-- ��ǥ ���̺� ����� ���� ����
-- tester1DB = ��Ű��
create table emp01(
empno number(4),
ename varchar2(14),
sal number(7,3)
);
-- ���̺� ���� Ȯ��
desc emp01;
create table emp02(
    empno number(4) default 1000,
    ename varchar2(14) default 'ȫ�浿',
    sal number(7,3)
);

insert into emp01(empno) values (2000);
insert into emp02(sal) values (500);

-- ���̺� ������ ����� �̸� �μ��� �Ի���-�⺻������ ���� ��¥
create table emp03(
    ename varchar2(14),
    dname varchar2(14),
    hiredate date default sysdate
);
insert into emp03 values ('������', '�����', '2022/10/08');
insert into emp03 values ('�̼���', '������', '2023/03/03');

select * from emp03;

alter table emp01
    add(birth date default sysdate);
    
desc emp01;

--sal �÷��� �ڷ����� number(7,3) --> number(8)�� �����ϱ�

alter table emp01
    modify(sal number(8));
    
-- empno varchar2(10) ename varchar2(20)���� �����ϱ�
alter table emp01
    modify (empno varchar2(10), ename varchar2(20));
    
select * from emp01;
desc emp01;

update emp01 set empno = null;

--sal �÷��� �����

alter table emp02
    drop column sal;

desc emp02;

-- deptno, hiredate �÷��� ��� �����ϱ�
alter table emp03
    drop column deptname;
    
alter table emp03
    drop column hiredate;
    
desc emp03;

--���ڵ���� ���� ���� ��쿡 �÷�����(�߰�, ����, ����)�� ��� �����ͺ��̽� �ӵ��� ��������.
--������ �÷��� �ٷ� �ٷ� ����°� �ƴ϶� unused�� ����� �ΰ� ���߿� �Ѳ����� �����մϴ�.

select * from emp02; --unused�� �÷��� �˻��� ���� �ʴ´�.
alter table emp02
    set unused(ename);  -- ������� ���� �÷��� üũ�ϴ°�

desc emp02;


alter table emp02 --unused�� �÷��� ������ �����Ѵ�.
    drop unused columns;
    
--table ����
select * from emp01;
-- ���̺� �̸� ����
rename emp01 to newEmp01;
select * from newEmp01;
desc newEmp01;

-- ���̺��� ������ �����ϴ� �� = ���̺� ����
drop table newEmp01;
drop table emp03;

-- ���̺� �Ӿȿ� �����͸� ��� ����
create table copyEmp as select * from emp;
-- ���̺� �� �ȿ� ������(���ڵ�)�� ��� �����ϱ� ���1) delete ��, ���2) truncate table ��
select * from copyEmp;
-- delete������ Ʈ����ǿ��� �۾��� �̷�����Ƿ� commit ���� rollback �Ͽ� ������ ����� �� �ִ�.
delete from copyEmp;
-- ������� �ߴ� ��� �ǵ����� Ʈ����ǿ��� �۾��ϴ� �� �ǵ�����
rollback;
-- Ʈ������� ���࿡�� ���� ����ó�� 100% �Ϸ�Ǿ�� ����, �߰��� ���߸� ó������ �ǵ��� ���� ��
truncate table copyEmp; 
-- truncate table�� �����ͺ��̽� ���ο��� ó��, rollback ó�� x
-- ~~���� = ����, ����, ����, ���� �����Ǿ�����
-- ~~�д´� = ���⸸ ����
select table_name from user_tables;
select * from user_tables;
select table_name, max_trans from user_tables;
select * from all_tables;
-- dba = �ý��� ������ ����
--select * from dba_tables; -- ���ÿ��� dba ���� x

-- ������ ��ųʸ�
-- ����ڰ� ����� ���̺��� �ƴϰ� �����ͺ��̽� �������� �ڵ����� ����� �����Ͽ� �ش�. 
-- ����ڴ� ���⸸ �Ѵ�. ����ڴ� �����ͺ��̽� �����ȿ� ��� �ִ� ������ ���� �̿��Ѵ�. 
-- user_  all_  dba_
--------------------------
-- dml = data manipulation language, ������ ���۾�, �������ڰ� �ڹ��ڵ忡 ��ɾ� ���ش�.
-- select insert update delete
create table dept01(
    deptno number(2),
    dname varchar2(14),
    loc varchar2(13)
);

desc dept01;
-- ���� �� ����
insert into dept01 values(10, '�渮��', '����');
-- Ư�� �� ����
insert into dept01 select deptno, dname, loc from dept where deptno = 20;
-- ������ ����
insert into dept01 select deptno, dname, loc from dept;
-- loc = null�� ����
insert into dept01 (deptno, dname) select deptno, dname from dept;
select * from dept;

select * from dept where deptno = 20;

-- ���� ����, ���� ����, ��¥ ����, null ����
alter table dept01 add birth date;
-- deptno 20 or 30 �� ���ڵ� �ȿ� ���� ����¥�� ������ �־� �ּ���
insert into dept01 select deptno, dname, loc, sysdate from dept where deptno in (20, 30);
desc dept01;
select * from dept01;
--dname ������� ����� birth�� 1990/12/25�� ����