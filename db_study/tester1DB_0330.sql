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
