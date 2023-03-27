create table course(
cou_id number(4) not null,
cou_name varchar(20) null,
Tea_name varchar(20) null,
primary key(cou_id)
);
-- student ���̺����
create table student(
stu_id number(4) not null,
stu_name varchar(20) null,
age number(4) null,
stu_email varchar2(20) null,
cou_id number(4) null,
sex char(1) default 'M',
primary key(stu_id),
--�ܷ�Ű ����, course�� �⺻Ű�� ����
foreign key(cou_id) references course(cou_id)
);

--���̺� ������ ����
insert into course values(10,'�����','������');
insert into course values(20,'�ڹ�','������');
insert into course values(30,'������','Ȳ����');
insert into course values(40,'��ǥ��','������');

--���̺� ������ �˻�
select * from course;

INSERT INTO STUDENT VALUES(101,'������', 24,'moon@nate.com',10,'M');
INSERT INTO STUDENT VALUES(102,'���Ѽ�', 22,'five@nate.com',20,'M');
INSERT INTO STUDENT VALUES(103,'���뼮', 22,'again@nate.com',20,'M');
INSERT INTO STUDENT VALUES(104,'����ö', 22,'cook@nate.com',20,'M');
INSERT INTO STUDENT VALUES(105,'��ȫ��', 24,'red@nate.com',10,'M');
INSERT INTO STUDENT VALUES(106,'������', 21,'kim@nate.com',20,'M');
INSERT INTO STUDENT VALUES(107,'�ڽ���', 22,'season@nate.com',20,'M');
INSERT INTO STUDENT VALUES(108,'������', 27,'brother@nate.com',10,'M');
INSERT INTO STUDENT VALUES(109,'������', 22, NULL,20,'F');
INSERT INTO STUDENT VALUES(110,'�ڱ⼮', 34,'flag@nate.com',10,'M');
INSERT INTO STUDENT VALUES(111,'��ȿ��', 24,'od@nate.com',30,'F');
INSERT INTO STUDENT VALUES(112,'��â��', 34,'window@nate.com',30,'M');
INSERT INTO STUDENT VALUES(113,'������', 28, NULL, 10,'M');
INSERT INTO STUDENT VALUES(114,'�̺���', 29,'bbong@nate.com',10,'M');
INSERT INTO STUDENT VALUES(115,'��â��', 24,'chang@nate.com',30,'M');
INSERT INTO STUDENT VALUES(116,'����', 34,'shine@nate.com',10,'M');

select * from student;

create table dept01(
deptno number(4),
dname varchar2(10),
loc varchar2(9)
);

--�����ͺ���
alter table dept01 modify(dname varchar2(30));
--�÷��߰�
alter table dept01 add(etc varchar2(50));
--���̺�������
desc dept01;
--���̺� �̸� �����ϱ�
rename dept01 to dept02;
--���̺� ���ڵ�=�ο�=�� ��� �����ϱ�
truncate table student;

select * from student;

--���̺��� ���ڵ�� ������ ��� �����ϱ�
drop table student;
--�����ڰ� �ƴ� ����ڰ� �ٸ� ����ڸ� ���� �� ����.
--create user tester2 identified by 1234;

create table dept( 
   deptno number(2) not null,
   dname varchar2(14),
   loc varchar2(13),
   primary key(deptno)
);
-- emp ���̺� �����
create table emp(
   empno number(4) not null,
   ename varchar2(10),
   job varchar2(9),
   mgr number(4),
   hiredate date,
   sale number(7,2),
   comm number(7,2),
   deptno number(2) not null,
   primary key(empno),
   foreign key(deptno) references dept( deptno ) 
);
alter table dept add constraint deptno_uq unique(deptno);
--�����ͻ���
INSERT INTO  dept ( deptno, dname, loc)    VALUES(10, '�渮��', '����');

INSERT INTO  dept ( deptno, dname, loc)    VALUES(20, '�λ��', '��õ');

INSERT INTO  dept ( deptno, dname, loc)    VALUES(30, '������', '����');
-- �÷� 
INSERT INTO  dept  VALUES(40, '�����', '����'); 

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1001, '����', '���', 1013, '2007/03/10',  300, 0,20);   

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1002, '�ѿ���', '�븮', 1005, '2007/04/02',  250, 6,30);                       

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1003, '����ȣ', '����', 1005, '2005/02/10',  500, 100,30);                     

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1004, '�̺���', '����', 1008, '2003/09/02',  600, 0,20);                        

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1005, '�ŵ���', '����', 1005, '2005/04/07',  450, 200,30);   

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1006, '�嵿��', '����', 1008, '2004/01/08',  520, 0,20);                         

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1007, '��켺', '����', 1008, '2005/03/08',  500, 0,30);                    

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1008, '�ȼ���', '����', 0, '1996/04/07',  1000, 0,30);  

--��������ȸ
select * from emp;
select job from emp;

--�ߺ��� ���� 1���� ���
select distinct job from emp;