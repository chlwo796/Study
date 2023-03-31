--���� ���ڸ� �������� ������ ���� ��¥ ����ϱ�
select to_char( sysdate -1, 'yyyy/mm/dd') ����,
       to_char( sysdate, 'yyyy/mm/dd') ����,
       to_char( sysdate + 1, 'yyyy/mm/dd') 
       from dual;
-- ��������  ������  ���� �ݳ��� 14�� ����
select to_char(sysdate, 'yyyy/mm/dd') ������,
       to_char(sysdate + 14, 'yyyy/mm/dd') �ݳ���
       from dual;
-- Round
select round( to_date('2023/06/16', 'yyyy/mm/dd'), 'MM') from dual;
-- �Ի����� ���� ù���� �����ϱ�
select to_char( hiredate, 'yyyy/mm/dd') �Ի���,
       to_char( trunc(hiredate, 'MONTH'), 'yyyy/mm/dd') ���ް����,  -- Ư���� ��¥�� ���� �������� ������
       to_char( trunc(hiredate, 'YEAR'), 'yyyy') �Ի��ѳ⵵
       from emp;
-- �γ�¥ ������ ������ ���ϴ� Months_between �Լ�
-- ���� Months_between(date1, date2) ;
-- 2023/12/31 2023/03/30 ��� ���� ����?
select trunc( months_between( '2023/12/31', sysdate ) ) 
       from dual;
-- ���ó�¥ - �Ի��� = ���
select ename,trunc( months_between( sysdate, hiredate ) ) �ٹ�������
       from emp;
-- �Ի��Ͽ��� 5���� ��¥���
select hiredate �Ի��� , add_months( hiredate, 60 ) as "5����"
       from emp;       
-- �ش������ ���� ����� ��¥�� ��ȯ�ϴ� next_day�Լ�
-- next_day(��¥, ����);
-- �̹��� �Ͽ��� ��¥?
select next_day( sysdate, 1 ) from dual;
-- �̹��� ������ ��¥��?
select last_day( sysdate ) from dual;
-- �Ի����� ������ ��¥��?
select last_day( hiredate) from emp;
-- NVL �Լ� 
-- ������ ��� �Է��� ���ϸ� 0���� ������ ��� �Է��� ���Ͽ� null�� ��¥�� ��� �Է��� ���ϸ� null���� ��
--  nvl( �÷���, �⺻��) �÷��� ���� ������ �÷����� ��� null�̸� �⺻�� ���
-- �����ϱ� �Ի����� 0�� ��� �����ϱ�
select * from emp;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1013, '������', 1005, 400, 10) ; 
-- �����ϱ� 1003�� comm�� 0���� sale-100 �����ϱ�
update emp set comm = 0 where empno=1003;
update emp set sale=sale-100  where empno=1003;
-- job null�� ��� �������
select job, nvl( job, '�������') from emp;
-- update���� �̿��ؼ� job null�� ��� ��������̶�� �����ϱ�
update emp set job = nvl( job, '����'); 
select * from emp;
-- �Ի����� null���� ���� ��¥�� ������Ʈ ��Ű����.
update emp set hiredate = nvl( hiredate, sysdate );
-- comm null�� ��� 50���� �⺻���� ������Ʈ ��Ű����
update emp set comm = nvl( comm, 50);

create table  c3emp as select * from emp;

-- NULLIF�Լ��� ��ǥ������ ���Ͽ� ������ ��쿡�� NULL�� ��ȯ�ϰ�, �ƴϸ� ù��° ǥ������ ��ȯ�մϴ�.
select nullif( 'a','a' ) from dual; -- 'a','a' �����ϹǷ� null��ȯ
select nullif( 'a','b' ) from dual;

-- coalesce( comm, sale, 0) �Լ�
-- 1) ���  0 300 -> 0  2) 100 null -> 100 3) null 400 -> 400 4) null null -> 0
select ename, sale, comm, coalesce( comm, sale, 0) from emp;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1014, '�����', 1005, 400, 10) ;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1015, '�ڼ���', 1005, 600, 10) ;    
insert into emp( empno, ename, mgr, comm, deptno )
            values( 1016, '������', 1005, 100, 10) ;  
insert into emp( empno, ename, mgr, deptno )
            values( 1017, 'ȫ����', 1005, 10) ;             
select * from emp;

-- DECODE�Լ� switch~case��
-- ���� decode( ǥ����, ���ǽ�1,  ���1,
--                     ���ǽ�2, ���2,
--                     ���ǽ�3, ���3,
--                      �⺻��� ); 
select ename, deptno, decode( deptno, 10, '�渮��', 20,'�λ��', 30,'������', 40, '�����', '�̹�ġ') �μ���
       from emp order by deptno asc;
select * from dept;
-- loc ����-�Ե�Ÿ�� ��õ-���̵� ����-�������� ����-������   �÷����� ������
select loc, decode( loc, '����', '�Ե�Ÿ��', '��õ','���̵�', '����','��������','����','������') ������ from dept;
-- dept�� �������� �÷� �߰� �÷����� tourism �ڷ����� varchar2(20)���� �ϼ���
alter table dept add tourism varchar2(20);
-- �׸��� ������Ʈ ��Ű����.
update dept set tourism = decode( loc, '����', '�Ե�Ÿ��', '��õ','���̵�', '����','��������','����','������'); 
     
-- CASE�Լ�
-- ����
--  case when ���ǽ�1 then ���1
--       when ���ǽ�2 then ���2
--       else ���� ������ ��� �ƴ� ��� ó���� ���n
--  end    
select * from student;

-- 1) ���� �ڵ�(cou_id)�� 10�̸� '�ڹ�'���� 20�̸� '�ڹٽ�ũ��Ʈ'���� 30�̸� '�����ͺ��̽�'���� 40�̸� '������'���� �ܴ̿� '�⺻'����
select cou_id,
    case when cou_id=10 then '�ڹ�'
        when cou_id=20 then '�ڹٽ�ũ��Ʈ'
        when cou_id=30 then '�����ͺ��̽�'
        when cou_id=40 then '������'
        else '�⺻'
    end ������
from student;

-- 2) �̸��� '��'���̰� ���̰� 25�� �̻��� ����� 'A���ǽǷ� ������' '��'���̰� ���̰� 25�� �����̸� 'B���ǽǷ� ������'
select stu_name,
    case when (stu_name like ('��%') and age >= 25) then 'A���ǽǷ� ������'
        when (stu_name like ('��%') and age <= 25) then 'B���ǽǷ� ������'
    end ���ǽ�
from student;

-- 3) ����(sex)�� ����(M)�̸� '����ȭ����� 1��' ����('F')�̸� '����ȭ����� 2,3��'���� ����ϱ�
select sex,
    case when (sex = 'M') then '����ȭ����� 1��'
        when (sex = 'F') then '����ȭ����� 2,3��'
    end ȭ���
from student;

select * from student;
--1) ���� �ڵ�(cou_id)�� 10�̸� '�ڹ�'���� 20�̸� '�ڹٽ�ũ��Ʈ'���� 30�̸� '�����ͺ��̽�'���� 40�̸� '������'���� �ܴ̿� '�⺻'����
select distinct cou_id,
    case when cou_id=10 then '�ڹ�'
        when cou_id=20 then '�ڹٽ�ũ��Ʈ'
        when cou_id=30 then '�����ͺ��̽�'
        when cou_id=40 then '������'
        else '�⺻'
    end ������
from student order by cou_id;

--2) �̸��� '��'���̰� ���̰� 25�� �̻��� ����� 'A���ǽǷ� ������' '��'���̰� ���̰� 25�� �����̸� 'B���ǽǷ� ������'
--  �ٸ� �е��� '���� ���ŵ� �˴ϴ�'
select stu_name,
    case when (stu_name like '��%' and age >= 25) then 'A���ǽǷ� ������'
        when (stu_name like '��%' and age <= 25) then 'B���ǽǷ� ������'
        else '���� ���ŵ� �˴ϴ�'
    end ���ǽ�
from student;
--3) ����(sex)�� ����(M)�̸� '����ȭ����� 1��' ����('F')�̸� '����ȭ����� 2,3��'�� ����ϱ�
select distinct sex,
    case when (sex = 'M') then '����ȭ����� 1��'
         when (sex = 'F') then '����ȭ����� 2,3��'
    end ȭ���
from student;

-- ��� ���̺��� ���� ����� stu_id, stu_name, age ���
-- 1�ܰ� ��� ���̸� ���� ���Ѵ�.
select rount(avg(age)) from student;
-- 2�ܰ� 1�ܰ� ��� ���̸� ���ǹ����� ���
select stu_id, stu_name, age from student where age< (select round(avg(age)) from student);

select * from emp; 

-- ������� ��ü �޿�����?
select sum(sale) from emp;
-- �׷캰�� ���� ���ϱ�
-- �μ��� �޿��� �հ��?
select deptno from emp group by deptno order by deptno asc;
select deptno �μ���ȣ, sum(sale) �޿� from emp group by deptno;
-- �г⺰ �����?
-- �ڽ����� ������ ���, �ִ� ���̸� ���ϱ�
select cou_id, trunc(avg(age)), max(age) from student group by cou_id order by cou_id asc;
select * from emp order by deptno;
-- �Ŵ���(mgr) ���� �����ϴ� �ο�����?
select mgr, count(empno) from emp group by mgr order by mgr asc;
-- job �������� �޿��� ��հ� ���ʽ� ����� ���ϼ���
select job, avg(sale), avg(comm) from emp group by job order by job asc;
-- ù��° �׷�, �μ��� �ι�° �׷�, ������
select deptno, job, avg(sale) from emp group by deptno, job;
-- �μ��� �޿� ����� 600 �̻��� �μ��� ����ϼ���
select deptno, avg(sale) from emp group by deptno having avg(sale) >=600;

-- ����� �����ϰ� �޿� �Ѿ��� 800 �̻��� ���޺� �޿� �Ѿ� ���ϱ�
select deptno, sum(sale) from emp where job !='���' group by job having sum(sale)>800;

-- ��� ����� �޿��ְ��, ������, �Ѿ� �� ��� �޿��� ���, ���= �����ݿø�
select max(sale) �޿��ְ��, min(sale) �޿�������, sum(sale) �Ѿ�, avg(sale) ��ձ޿� from emp;

-- �� ��� ���� �������� �޿� �ְ��, ������, �Ѿ� �� ��վ��� ���
select job ��������, max(sale) �޿��ְ��, min(sale) �޿�������, sum(sale) �Ѿ�, avg(sale) ��ձ޿� from emp group by job;
-- count(*) �Լ��� �̿��Ͽ� ��� ������ ����� ���
select job, count(*) from emp group by job;
-- ���� �� ����
select job, count(job) from emp group by job having job='����';
-- �޿� �ְ��, �޿� �������� ����
select max(sale)-min(sale) ���� from emp;
-- ���޺� ����� ���� �޿� ���, �����޿� 500�̸� �׷�����, �޿��� ���� ��������
select job ����, min(sale) �����޿� from emp group by job, sale having min(sale) >= 500 order by sale asc;
-- �� �μ��� ���� �μ���ȣ �̸�, ������, �����, �μ� ���� ��� ����� ��� �޿��� ���
select deptno, count(deptno), round(avg(sale), 2) from emp group by deptno order by deptno;
