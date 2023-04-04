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
------------------------
-- ���ڵ带 ������ �� insert��
-- ���� insert into ���̺��(�÷���1, �÷���2 ...) values ('������',...);
-- ���ڵ带 ������ �� update ��
-- ���� update ���̺�� set �÷��� = '������',... where ������
select * from emp;
-- mgr 1005�� ����� �޿��� 50���� �λ�
update emp set sale = sale+50 where mgr = 1005;
-- job�� ��� �븮�� ����� ���ʽ�
update emp set comm = comm + 30 where job in ('���', '�븮');
-- �Ի����� 05�� ������ ����� �޿��� 100���� �λ�
update emp set sale = sale + 100 where hiredate<='05/01/01';
-- ��� �޿����� ���� ���� ������ ���ؼ� ���ʽ� 50���� �����ϼ���.
select avg(sale) from emp;
-- ��� �޿�?
update emp set comm = comm + 50 where sale< (select avg(sale) from emp);
select * from emp;
-- �μ����� ���� ���� �޴� ����� �޿� 100���� �谨
-- 1�ܰ� �μ����� ���� ���� �޴� �����?
select ename, deptno, max(sale) from emp group by deptno, ename;
update emp set sale = sale-100 where sale=(select max(sale) from emp group by deptno);
update emp set sale = sale-100 where sale in (select max(sale) from emp group by deptno);

-- job �����̰ų� �Ի��� 98/12/31 ���� �Ի��� ����� �޿� = �޿� + ��ձ޿� ����
update emp set sale = sale + ( select avg(sale) from emp) where job = '����' or hiredate<='98/12/31';
select * from emp;
-- job ������ ������� ��� �����ϼ���.
update emp set job = '���' where job = '����';

-- delete��
create table c4emp as select * from emp;
select * from c4emp;

-- �޿��� 1000���� �̻��� ��� ����
delete from c4emp where sale>=1000;
-- mgr 1008, 1003�� ��� ����
delete from c4emp where mgr in (1008, 1003);
-- �达, �̾��� ��� �����ϰ� ��� ����
delete from c4emp where not ename like '��%' or not ename like '��%';
-- ���ʽ��� 100���� �̻��� ��� ����
delete from c4emp where comm>=100;
-- deptno�� 10, 20�� ��� ����
delete from c4emp where deptno in (10, 20);

rollback;
commit;
update emp set sale = sale + 500 where job = '����';
rollback;
select * from emp;
update emp set sale = sale-500 where job = '����';

insert into emp ( deptno) values (80);
desc user_constraints;
-- �������� ��� ���� : �����ͺ��̽��� ����� �� �������� ���� ����
-- �����ͺ��̽� ��ųʸ��� ���Ͽ� �������ǿ� ���� �÷����� ����
-- �����ͺ��̽� ��ųʸ��� ���Ͽ� ���������� �������Ǹ�, �������� Ÿ��, ���̺�� ����
-- �ʿ��� �÷��鸸 �����ؼ� ����
select constraint_name, constraint_type, table_name from user_constraints;
-- ��ü �������ǿ� ���õ� �÷��� ����
select * from user_constraints;
-- constraint_type P-primary key, R_foreign key, U-unique, C-check �Ǵ� not null

-- �� �������� ����� -> ����-> ����
-- ����� ���̺� ������ �� ���������� �����.
drop table emp03;
create table emp03(
empno number(4),
ename varchar2(10),
job varchar2(10),
deptno number(2)
);
drop table emp03;
select  constraint_name, constraint_type, table_name search_condition from user_constraints where table_name in ('EMP03');

create table emp03(
empno number(4) unique,
ename varchar2(10) unique,
job varchar2(10),
deptno number(2)
);

-- �����ϱ�
-- �������� �����ϱ�

insert into emp03 values (1001, 'ȫ�浿', '����', 10);
-- impno ����
insert into emp03(ename, job, deptno) values ('�̼���', '�λ���' , 10);
-- ename �Է�x
insert into emp03(empno, job, deptno) values (1002, '���', 20);
-- unique ��ȿ��
insert into emp03 values(1001, '�ڹ���', '����', 10);
insert into emp03 values(null, '�ڹ���', '����', 10);    -- null �ߺ�����
insert into emp03(ename, job, deptno) values ('�̼���', '�λ���', 10);

select * from emp03;
select * from user_constraints where table_name in ('EMP03');
-- ��������(constraint_name) ����� ����
create table emp03(
empno number(4) constraint emp03_empno_uk unique, -- constraint �������Ǹ� ��������
-- �������Ǹ��� ����� ��� : ���̺��_�÷���_�������Ǹ�
ename varchar2(10) constraint emp03_ename_uk unique,
job varchar2(10) constraint emp03_job_nn not null,
deptno number(2) constraint emp03_job_nn_uk not null unique
);
select * from user_constraints where table_name in ('EMP03');

-- primary key �⺻Ű = not null + unique

drop table emp03;

create table emp03(
empno number(4),
ename varchar2(10),
job varchar2(10),
deptno number(2),
constraint emp03_empno_pk primary key(empno)
);
-- �����Է�
insert into emp03 values (1001, '����ȯ', '����', 20);
insert into emp03 values (1002, '���糲', '����', 30);
-- �����Է� 
insert into emp03 (enmae, job, deptno) values ('����ȯ', '���', 20);
insert into emp03 values (1001, '����ȯ', '����', 30);
-- foreign key �ܷ�Ű
-- �θ����̺� ���� ����
create table dept03(
deptno number(4),
dname varchar2(10),
loc varchar2(10),
constraint dept03_deptno_pk primary key(deptno)
);
drop table emp03;
-- ù���� ���
create table emp03(
empno number(4),
ename varchar2(20),
deptno number(4) constraint emp03_deptno_nn not null
                constraint emp03_deptno_fk references dept03(deptno),
constraint emp03_empno_pk primary key(empno)
);
select * from emp03;
-- �ι�° ���
create table emp03(
empno number(4),
ename varchar2(20),
deptno number(4) constraint emp03_deptno_nn not null,
foreign key(deptno) references dept03(deptno)
);
select * from user_constraints where table_name in ('EMP03', 'DEPT03');
insert into dept03 values(10, '�渮��', '����');
insert into emp03 values(1001, 'ȫ�浿', 10);

-- check ��������
-- �ԷµǴ� ���� üũ�Ͽ� ������ �� �̿��� ���� ������ ����
drop table emp03;
create table emp03(
empno number(4),
salary number(10) check(salary between 500 and 5000), -- ���� ���Ǹ��� ������� �ʰ�
comm number(10) constraint emp03_comm_ck check( comm between 10 and 1000)
);
select * from user_constraints where table_name in ('EMP03');
-- �����Է�
insert into emp03 values(1001, 800, 20);
-- �����Է�
insert into emp03 values(1001, 5000, 0);
-- ���� �����
-- ���� ����, ����

-- ����Ű 2�� �̻� �÷��� ���ļ� �⺻Ű�� ���� ��

drop table emp03;
create table emp03(
    ephone number(4),
    ename varchar2(20),
    job varchar2(20),
    constraint emp03_ephone_ename_pk primary key(ephone, ename)
);

insert into emp03 values(3334, 'ȫ�浿', '���');
insert into emp03 values(3334, '�̱浿', '���');
insert into emp03 values(3344, 'ȫ�浿', '���');
insert into emp03 values(3334, 'ȫ�浿', '���');

drop table emp03;
drop table dept03;
create table emp03(
    empno number(4),
    ename varchar2(20),
    job varchar2(20),
    deptno number(4)
);
-- �������� �߰�
alter table emp03 add constraint emp03_empno_pk primary key(empno);

select * from user_constraints where table_name in ('EMP03');

-- deptno �ܷ�Ű ����
create table dept03(
    deptno number(4),
    dname varchar2(20),
    loc varchar2(20)
);

alter table dept03 add constraint dept03_deptno_pk primary key(deptno);

alter table emp03 add constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno);

-- dname loc�� ����Ű�� �������� �߰��ϱ�
drop table dept03;
drop table emp03;

alter table dept03 add constraint dept03_dname_loc_pk primary key(dname, loc);
-- dname not null�� �������� ������ �ڵ����� null
-- not null�� �������� ������ �ڵ����� null
alter table dept03 modify dname constraint dept03_dname_nn not null;

-- ename not null�� ���� ����
alter table emp03 modify ename constraint emp03_ename_nn not null;
-- �������� ����
-- 1. �������Ǹ����� ����
alter table dept03 drop constraint dept03_dname_nn;
select * from user_constraints where table_name in('DEPT03');

-- emp03 primary Ű�� ���������� ����
alter table emp03 drop primary key;
-- primary key, foreign key, check �������� �߰� add constraint ~
-- primary key, foreign key, check �������� ���� drop constraint ~, drop primary key
-- not null

CREATE TABLE  employee(

    emp_no number(4),

    emp_name varchar2(20),

    salary  number(6),

    birthday  date );
CREATE TABLE  prjoect(

     pro_no number(4),

     pro_content varchar2(100),

     start_date  date,

     finish_date date );
     CREATE TABLE  specialty(

     emp_no number(4),

     specialty   varchar2(20)

);
CREATE TABLE assign(

   emp_no   number(4),

   pro_no    number(4) );
alter table employee add constraint employee_pk primary key(emp_no);
alter table assign add constraint assign_employee_fk foreign key(emp_no) references employee(emp_no) ;
alter table prjoect add constraint project_pk primary key(pro_no);
alter table assign add constraint assign_project_fk foreign key(pro_no) references prjoect(pro_no);
alter table specialty add constraint specialty_fk foreign key(emp_no) references employee(emp_no);
alter table specialty add constraint specialty_pk primary key(specialty);
alter table assign add constraint assign_pk primary key (emp_no, pro_no);

select * from user_constraints where table_name in ('EMPLOYEE', 'PRJOECT', 'SPECIALTY','ASSIGN');

-- cascade ����
-- �θ����̺��� �ڷḦ �����ϸ� �ڽĵ� ���� ������ �� �� �ְ� ���������� ����� �ִ� ��.
drop table emp03;
drop table dept03;

create table emp03(
empno number(4),
ename varchar2(10)
constraint emp03_ename_nn not null,
job varchar2(10),
deptno number(2),
constraint emp03_empno_pk primary key(deptno),
constraint emp03_job_uk unique(job),
constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno)
);
create table dept03(
deptno number(2),
dname varchar2(10),
loc varchar2(10),
constraint dept03_deptno primary key(deptno)
);

select * from user_constraints where table_name in('EMP03', 'DEPT03');
insert into emp03 values (1000, 'ȫ�浿', '���', 50);
-- �θ��ڷ� �ְ� �ڽ� �ڷ� �ִ´�. or ���������� �ӽ÷� ��Ȱ��ȭ(disable constraint)
alter table emp03 disable constraint emp03_deptno_fk; --��������
-- ��Ȱ��ȭ�� ���������� �ٽ� Ȱ��ȭ
alter table emp03 enable constraint emp03_deptno_fk;
delete from emp03;
-- cascade �ɼ�
alter table dept03 disable primary key cascade;
alter table dept03 enable primary key;
alter table emp03 enable constraint emp03_deptno_fk;
insert into emp03 values (1000, 'ȫ�浿', '���', 50);


