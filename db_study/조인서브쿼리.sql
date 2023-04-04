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

select * from student;
select * from course;

-- �ΰ� ���� �غ���
select * from student, course;

-- cou id�� ������ ���� �������� �����ϱ�
select * from student s, course c where s.cou_id = c.cou_id;

-- �й�, �̸�, �ڽ���ȣ �ڽ��� ������
select stu_id, stu_name , s.cou_id, cou_name, tea_name from student s, course c where s.cou_id = c.cou_id;

-- ������ �̸� ������ �����ϱ�
select stu_id, stu_name , s.cou_id, cou_name, tea_name 
    from student s, course c 
    where s.cou_id = c.cou_id
    order by tea_name asc;

--����) �л� ���̰� ���� ���� ����� ������ ������?
-- 1�ܰ� cou_id�� ������ ���� �������� �����ϱ�
select * from student s, course c where s.cou_id = c.cou_id;
-- 2�ܰ� ���� ���� ���̴�?
select max(age) from student s, course c where s.cou_id = c.cou_id;
-- 3�ܰ� ������ ���� ���� ���� ����� ��������
select * from student s, course c
    where s.cou_id = c.cou_id and s.age = ( select max(age) from student s, course c);

-- ����� ���¸� �����ϴ� ����� �ο�����?
select * from course, course;
select * from student s, course c where s.cou_id = c.cou_id;
select * from student s, course c
    where s.cou_id = c.cou_id and c.cou_name = '�����';
    
select count(*) ����ϼ����ο� from student s, course c
    where s.cou_id = c.cou_id and c.cou_name = '�����';    
-- ���л��̰� ������ ������ ������ �����ϴ� �л��� �й���, ����, �̸���, �����ڵ�, �������� ����ϱ�
select s.stu_id, s.age, s.stu_email, c.cou_id, c.cou_name from student s, course c
    where s.cou_id = c.cou_id and s.sex='M' and c.tea_name like '��%';

-- course ���̺� �÷� �߰��ϱ� tea_id
-- course ���̺� ���� ����
    desc course;
-- ���̺��� �÷� �߰��ϱ�
    alter table course
        add tea_id number(4);
-- �ڷḦ �����ϱ�
    select * from course;
    update course set tea_id=2001 where tea_name='������';
    update course set tea_id=2002 where tea_name like 'Ȳ%';
    update course set tea_id=2003 where tea_name like '_��%';
    
-- student ���̺� �÷� �߰��ϱ� memto_id number(4)
desc student;
  alter table student
     add memto_id number(4);
-- memto_id �÷� �� �߰��ϱ� 103, 105,  111, 101, 103, 102, 102, 106, 105, 104, 104, 110, 110, 112, 112
   update student set memto_id=103 where stu_id=101;
   update student set memto_id=105 where stu_id=102;
   update student set memto_id=111 where stu_id=103;
   update student set memto_id=101 where stu_id=104;
   update student set memto_id=103 where stu_id=105;
   update student set memto_id=102 where stu_id=106;
   update student set memto_id=102 where stu_id=107;
   update student set memto_id=106 where stu_id=108;
   update student set memto_id=105 where stu_id=109;
   update student set memto_id=105 where stu_id=110;
   update student set memto_id=104 where stu_id=111;
   update student set memto_id=104 where stu_id=112;
   update student set memto_id=110 where stu_id=113;
   update student set memto_id=110 where stu_id=114;
   update student set memto_id=112 where stu_id=115;
   update student set memto_id=112 where stu_id=116;
   
-- ����) �ش��л��� ������ ������ �̸���, ������������� ����Ͻÿ� 
-- ��) ������ ����� ���뼮�̰�, �����̸����� again@nate.com ����������� : ����� 
 -- 1�ܰ� �л��� �����̸� �˻�
  select * from student s1, student s2;
   select * from student s1, student s2 where s1.memto_id = s2.stu_id;
   select s1.stu_name, s2.stu_name, s2.stu_email from student s1, student s2 where s1.memto_id = s2.stu_id;
 -- 2�ܰ� ���䰡 �����ϴ� ������?
 -- self join�ϰ� course ���̺� ����
   select * from student s1, student s2, course c 
          where s1.memto_id = s2.stu_id and s2.cou_id = c.cou_id;
 -- ���ϴ� �÷� ���ֱ�
   select s1.stu_name, s2.stu_name, s2.stu_email, c.cou_name from student s1, student s2, course c 
          where s1.memto_id = s2.stu_id and s2.cou_id = c.cou_id;

select * from course;

-- ����2) �� �����Ե��� �̸����� �����ϴ� �л����й�, �̸���, �������̸�, �����̸���, ���伺���� �˻��ϼ���
select * from course c, student s;
select * from course c, student s where c.cou_id = s.cou_id;
select * from course c, student s1, student s2;
select * from course c, student s where c.cou_id = s1.cou_id and s1.stu_id = s2.memto_id;
select c.tea_name, s1.stu_id, s1.stu_email, s2.stu_name, s2.stu_email, s2.sex
    from course c, student s1, student s2
    where c.cou_id = s1.cou_id and s1.stu_id = s2.memto_id
    order by c.tea_name asc;
    
-- outer join
-- ���䰡 ���� �����?
-- ������ ���� ���� ȸ������?
-- ������ ���� ���� �л���?
select * from emp;
select member.ename ����̸�, manager.ename ���ӻ���̸�
    from emp member left outer join emp manager
    on member.mgr = manager.empno;
    
select member.ename ����̸�, manager.ename ���ӻ���̸�
    from emp member right outer join emp manager
    on member.mgr = manager.empno;
    
-- where member.mgr(+) = manager.empno(+); -- �������� ��� where ���� ����
-- full outer join ���� �����ʿ� �ִ� ���̺��� ��� ������, ���� ���̺��� ��� �� ������
-- ���� ������� ������ ��� null ä��

select * from student;
-- �������� �ʴ� �л���? ������
select * from student s1 right outer join student s2 on s1.memto_id = s2.stu_id;
select s2.stu_name from student s1 right outer join student s2 on s1.memto_id = s2.stu_id
where s1.memto_id is null;

select stu_name from student
where stu_name in (select s2.stu_name from student s1 right outer join student s2
on s1.memto_id = s2.stu_id
where s1.stu_id is null
);

select s1.stu_name, s2.stu_name from student s1, student s2
where s1.memto_id(+) = s2.stu_id
and s1.memto_id is null;

select * from dept;
select * from emp;
insert into dept values(50, '�ѹ���', '����');
insert into dept values(60, '�ؿܺ�', '����');

-- ����� ���� �μ��� ���
select dname from emp e right outer join dept d on e.deptno = d.deptno where e.deptno is null;
select d.dname from emp e, dept d where e.deptno(+) = d.deptno and e.deptno is null;


