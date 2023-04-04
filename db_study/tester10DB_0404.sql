-- �μ� ���̺� �����ϱ�

DROP TABLE EMP;

-- ��� ���̺� �����ϱ�

DROP TABLE DEPT;

-- �޿� ���̺� �����ϱ�

DROP TABLE SALGRADE;

-- �μ� ���̺� �����ϱ�

DROP TABLE EMPLOYEE;

-- ��� ���̺� �����ϱ�

DROP TABLE DEPARTMENT;

-- �޿� ���̺� �����ϱ�

DROP TABLE SALGRADE;

-- �μ� ���̺� �����ϱ�

CREATE TABLE DEPT(
DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) 
);

-- ��� ���̺� �����ϱ�

CREATE TABLE EMP( 
EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7,2),
COMM NUMBER(7,2),
DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);

-- �޿� ���̺� �����ϱ�

CREATE TABLE SALGRADE(
GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER );

-- ��� ���̺� ���� ������ �߰��ϱ�

INSERT INTO DEPT VALUES(10, '�渮��', '����');
INSERT INTO DEPT VALUES(20, '�λ��', '��õ');
INSERT INTO DEPT VALUES(30, '������', '����'); 
INSERT INTO DEPT VALUES(40, '�����', '����');

-- �μ� ���̺� ���� ������ �߰��ϱ�

INSERT INTO EMP VALUES(1001, '����', '���', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1002, '�ѿ���', '�븮', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250, 80, 30);
INSERT INTO EMP VALUES(1003, '����ȣ', '����', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500, 100, 30);
INSERT INTO EMP VALUES(1004, '�̺���', '����', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
INSERT INTO EMP VALUES(1005, '�ŵ���', '����', 1005, to_date('2005-04-07','yyyy-mm-dd'), 450, 200, 30);
INSERT INTO EMP VALUES(1006, '�嵿��', '����', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
INSERT INTO EMP VALUES(1007, '�̹���', '����', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
INSERT INTO EMP VALUES(1008, '���켺', '����', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500, 0, 30);
INSERT INTO EMP VALUES(1009, '�ȼ���', '����', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
INSERT INTO EMP VALUES(1010, '�̺���', '����', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
INSERT INTO EMP VALUES(1011, '�����', '���', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, NULL, 30);
INSERT INTO EMP VALUES(1012, '������', '���', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO EMP VALUES(1013, '������', '����', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
INSERT INTO EMP VALUES(1014, '���μ�', '���', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);

-- �޿� ���̺� ���� ������ �߰��ϱ�
INSERT INTO SALGRADE VALUES (1, 700,1200);
INSERT INTO SALGRADE VALUES (2, 1201,1400);
INSERT INTO SALGRADE VALUES (3, 1401,2000);
INSERT INTO SALGRADE VALUES (4, 2001,3000);
INSERT INTO SALGRADE VALUES (5, 3001,9999);

select * from dept;
select * from emp;
select * from salgrade;

select ename, hiredate from emp e right outer join dept d on e.deptno = d.deptno where d.dname= '�渮��';
select ename, sal from emp e right outer join dept d on e.deptno = d.deptno where d.loc = '��õ';
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno = d.deptno;
select ename, dname from dept d left outer join emp e on d.deptno = e.deptno where e.job = '����';
select e1.ename, e1.job from emp e1 right outer join emp e2 on e1.mgr = e2.empno where e2.ename = '���켺';
select e.ename from emp e right outer join dept d on e.deptno = d.deptno where d.loc in (select d.loc from emp e right outer join dept d on e.deptno = d.deptno where e.ename = '���켺');

-- 11�� ��������
select dname from dept where deptno = (select deptno from emp where ename = '�̹���');
-- ��� �޿����� �� ���� �޿��� �޴� ��� ���
select ename, sal from emp where sal > (select avg(sal) from emp);
-- �޿��� 500�� �ʰ��ϴ� ����� ���� �μ��� �ٹ��ϴ� ��� ���ϱ�
-- 1�ܰ� �޿��� 500���� �ʰ��ϴ� ���

select * from emp where sal>=500;
-- 2�ܰ� �ش� �μ� ����� �˻�
select ename, deptno from emp where deptno in (select deptno from emp where sal>=500);
-- 30�� �μ��� �ִ�޿����� ���� �޿��� �޴� ��� ���
select ename, sal from emp where sal>= (select max(sal) from emp where deptno = 30);
-- �Ǵ�
select ename, sal from emp where sal>=all(select sal from emp where deptno = 30);
-- all (250, 500, 450, 480, 500, 280) sal>=250 and sal>=500
select * from emp where sal>=any(select sal from emp where deptno=30);
-- sal>=250 or sal>=500 ..
select * from emp where sal>= some(select sal from emp where deptno = 30);
-- sal>=250 or sal>=500 ..
select * from emp where exists (select * from emp where deptno = 30);

-- ���̺� ����
create table emp02 as select * from emp where deptno in (10, 20);

-- ���̺��� �����ϴµ� ������ �����ϱ�
create table emp03 as select * from emp where deptno in (10000);
select * from emp03;

desc emp03;

-- emp ���̺��� �������� ����
select * from user_constraints where table_name in ('EMP');
select * from user_constraints where table_name in ('EMP03');

-- update ���� ��������
-- ��) deptno = 20�� �������� deptno=40�� ������ ����
select * from dept;
update dept set loc = (select loc from dept where deptno = 40) where deptno = 20;

use tester1db;
-- �嵿���� �޿� ����
select * from emp;
update emp set sal = (select max(sal) from emp where job = '����') where ename = '�嵿��';

rollback;
-- ���忡�� �޿��� ���� ���� ����� �޿��� �嵿�� ������ �޿��� ����
-- �������� �ٹ��ϴ� �����߿��� ���� ���� �Ի��� ����� �̸���, �Ի�����?
select ename, hiredate from emp where emp.hiredate <=all(select hiredate from emp, dept where dept.loc = '����');

-- ���� ���ǿ� �����ϴ� ��� ����, ���� ����
delete from emp where hiredate <=all(select hiredate from emp, dept where dept.loc = '����' and job !='����');
create table emp06 as select * from emp;
drop table emp06;
select * from dept;
select * from emp06;
-- 1. ������ ��� ����� �̸��� �޿�
select ename, sal from emp where deptno = (select deptno from dept where dname = '������');
-- 2. ���� �ּұ޿����� ���� �޿��� �޴� ����� �̸��� �޿��� ���� ���, ���� ����
select ename, sal, job from emp where sal> (select min(sal) from emp where job = '����') and job !='����';
-- 3. ��õ ��� �޿� 100 �λ�
update emp set sal=sal+100 where deptno in( select deptno from dept where loc = '��õ'); 
-- 4. �渮�� ��� ����
delete from emp06 where deptno in( select deptno from dept where dname = '�渮��');
-- 5. '�̹���'�� ���� �μ�, �̸� �μ���ȣ ���
select ename, deptno from emp06 where deptno in( select deptno from emp06 where ename = '�̹���')  ;
-- 6. '�̹���'�� �޿��� �����ϰų� �� ���� �޴� �����
select ename from emp06 where sal>=(select sal from emp06 where ename = '�̹���');
-- 7. '�̹���'�� ������ ������ ���� ��� ���
select ename from emp06 where job in (select job from emp06 where ename = '�̹���');
-- 8. '��õ'���� �ٹ��ϴ� ��� �̸�, �μ���ȣ ���
select ename, deptno from emp06 where deptno in (select deptno from dept where loc = '��õ');
-- 9. ���ӻ�� ���켺 ��� �̸� �޿� ���
select ename, sal from emp06 where mgr in (select empno from emp06 where ename = '���켺');
-- 10. �μ����� ���� �޿� ���� �޴� ��� ����(�����ȣ, ����̸�, �޿�, �μ���ȣ)
select empno, ename, sal, deptno from emp06 where sal in (select max(sal) from emp06 group by deptno);