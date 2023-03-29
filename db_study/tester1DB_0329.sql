-- ��ü����
select * from emp;
-- �÷�����
select empno, ename from emp;
-- as = ��Ī, empno->�����ȣ, ename->����� �÷��� ����
select empno as �����ȣ, ename as ����� from emp;
-- as ���� ����
select ename �����, sale �޿� from emp;
-- ������డ��, number Ÿ���� ���
select ename �����, sale �޿�, sale*12 ���� from emp;
select ename �����, sale �޿�, sale*12*0.12 ���� from emp;
-- �����޾� = ���� + ���ʽ� *5 - ����*0.12 - ���ʽ� *0.2
select sale + comm*5 - sale*0.12 - comm * 0.2 �����޾� from emp;

insert into emp (empno, ename, job, mgr, hiredate, sale, comm, deptno) values (1009, '������', null, 1005, '98/10/10', 700, 0, null);

insert into emp values(1010, '���ȯ', null,1004, '98/12/04', 250, 0, null);

select * from emp;

select ename, comm, sale*12+comm, nvl(comm, 0), sale*12+nvl(comm,0) from emp;

--nvl(�÷���, �÷��� null�̸� ó���� ��)
select nvl(job, '������') from emp;
--������ ���� null ���ڹ����� 0
select nvl(comm,0), sale*12+nvl(comm,0) "�����޾�" from emp;

select ename || '�� �Ի��Ͻ� ���� ȯ���մϴ�' from emp;

select ename || '��' || sale || '���� �� ������ �����մϴ�' from emp;

--�μ���ȣ ���(�ߺ�����)
select distinct deptno from emp;
--����(job)�� ������ ���
select distinct job from emp;
--null�� '�̹���' ����ϱ�
select distinct nvl(job, '�̹���') from emp;

--������
--�޿��� 500 �̻��� ��� ����ϱ�
select * from emp where sale>500;
--�Ի����� 98�⵵ ������ ����� �����ȣ�� �̸� �Ի��� ����ϱ�
select empno, ename, hiredate from emp where hiredate >= '98/10/30';
--�μ���ȣ�� 10�� ����� �̸��� �μ���ȣ ���
select ename, deptno from emp where deptno = 10;
--�μ���ȣ�� 10�̰ų� 30�̰� �Ի����� 2005�� ���� �Ի��� ��� ��ü �÷� ����ϱ�
select * from emp where deptno = 10 or deptno = 30 and hiredate <= '05/01/01';
--�Ŵ����� 1008�� ����� �̸��� �μ� �Ŵ��� ��ȣ ����ϱ�
select deptno, mgr from emp where mgr=1008;
--empno�� ¦���� ����� �����ȣ�� �̸��� ���(¦���Լ� mod)
select empno, ename from emp where mod(empno,2)=0;
--job�� ����̰ų� �븮�̰ų� ������ ����� �޿��� 300%�� ���ʽ��� �ְ� ����� �̸� ���� �޿� ���ʽ�
select ename, job, sale, sale*3 ���ʽ� from emp where job in('���','�븮','����');
--�达�� ��� ���
select * from emp where ename like '��%';

select * from emp where ename like '_��_';

select * from emp where job like '_��';

--'��'�� �ƴ� ��� ���

select * from emp where job not like '_��';
--�Ի����� '03/01/01~06/12/31' ���̿� �Ի��� ���
select * from emp where hiredate>='03/01/01' AND hiredate<='06/12/31';
select * from emp where hiredate between '03/01/01'and '06/12/31';
--�޿��� 300~800���̰� �ƴ� ���
select * from emp where sale<300 and sale>800;
select * from emp where not sale>=300 and sale<=800;
--���ʽ��� ���� ���
select * from emp where comm=0;
--�Ŵ����� ���� ���
select * from emp where mgr=0;
--select * from emp where job = null; --���x
select * from emp where job is null;
select * from emp where job is not null;
--�޿��� ���� �޴� ��� ������� ���
select* from emp order by sale;
-- �μ���ȣ�� 20,30�� ����� �޿������� ����ϱ�
select * from emp where deptno=20 or deptno=30 order by sale desc;
select * from emp where deptno in(20,30) order by sale desc;
--������ ����, ������ ����� �Ի��� ������ ���
select * from emp where job in('����','����') order by hiredate asc;
--�μ���ȣ�� 20,30�� ����� �޿�����, ���ʽ��������� ��� 
select * from emp where deptno in(20,30) order by sale desc, comm desc;
--�μ���ȣ�� 20, 30�� ����� �μ���, �����ȣ�� ����ϱ�
select * from emp where deptno in (20,30) order by deptno asc, empno asc;
select * from emp order by job asc; --��������=null�� ���� ������
select * from emp order by job desc; --��������=null�� ���� ó��

--select������ ���ο� ���̺� �����
--���� create table ���̺�� as select��

create table cdept as select * from dept;
create table cemp as select empno, ename, deptno from emp;
select * from cemp;
create table ccemp as select empno, ename, deptno from emp where deptno = 20;
select * from ccemp;
--�̸� ��, �� ���� ����� empno, ename, deptno �÷��� c2emp ���̺�� �����
create table c2emp as select empno, ename, deptno from emp where ename like '��%' or ename like '��%';

--������
select * from ccemp union all select * from c2emp;

--�ߺ�����
select * from ccemp union select * from c2emp;

--������, ������
select * from ccemp intersect select * from c2emp;

--������, ���� ���� ������
select * from ccemp minus select * from c2emp;

