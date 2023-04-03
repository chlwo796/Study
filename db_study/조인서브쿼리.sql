-- ���� ����
-- 1. ����� = cross ���� = ������, ���� ���̺� ������ �÷����鸸 ����
-- 2. left, right outer join, ���� �� �����ʿ� �ִ� ���̺� ���ڵ�����
-- 3. full outer join, ���� ������ ��� ���̺� ���ڵ� ����

select * from emp, dept; -- full join
select * from emp; -- 18�� ���ڵ�
select * from dept; -- 4�� ���ڵ�
select 18*4 from dual;

select * from emp, dept where emp.deptno = dept.deptno; -- equal join

-- ������ �μ���� ������?
select ename, dname, loc from emp, dept where emp.ename = '����';
-- ������ ��õ�� ����� �����ȣ�� �Ի��� ���
select loc, ename, empno, hiredate from emp, dept where dept.loc = '��õ';

select * from user_constraints where table_name in('EMP', 'DEPT');

select emp.deptno, emp.ename, dept.dname from emp, dept where emp.deptno=dept.deptno and dept.dname in ('�λ��', '�渮��') order by dept.dname asc;
-- ��Ī�ο�
select e.deptno, e.ename, d.dname from emp e, dept d
where e.deptno = d.deptno and d.dname in ('�λ��', '�渮��')
order by d.dname asc;

select * from emp;

-- �����ȣ, �Ŵ��� �̸�
-- self join
select e1.empno, e1.ename, e2.mgr, e2.ename  from emp e1, emp e2 where e1.mgr = e2.empno;
