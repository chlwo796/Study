create table c5emp as select * from emp;

select * from c5emp;

create view viewEmp as select * from c5emp;

-- ������ ������������ ����� ����� ��� ��� ����� �θ�
create view venameMgr as
select member.ename ����̸�, manager.ename ���ӻ���̸�
from emp member left outer join emp manager
on member.mgr = manager.empno;

select * from venameMgr;

select * from venameMgr where ����̸� = '���ȯ';

select * from student;
select * from course;

-- ��������
-- �ڽ��� ������� ����� �ڽ���ȣ, �ڽ���, �����Ը�, �л���ȣ, �л����� �˻�

select c.cou_id �ڽ���ȣ, c.cou_name �ڽ���, c.tea_name �����Ը�, s.stu_id �л���ȣ, s.stu_name �л���
from student s, course c where c.cou_id = s. cou_id and c.cou_name = '�����';

-- ��� �����
-- ���� create view ���̸� as ������
create view vStudentCourse as select c.cou_id, c.cou_name, c.tea_name, s.stu_id, s.stu_name from course c, student s where c.cou_id = s.cou_id and c.cou_name = '�����';

select * from vStudentCourse;

-- ��� ������ �������̺�
-- ����ϴ� ����? �����ϰ� �� �������� ����ϰ� ����� ��� ��� ����� �θ� ������ ����.

desc user_views;
select * from user_views;
-- ���� ���̺��� �ڷᰡ ����� �� ���� �߻� 
insert into vStudentCourse values (50, '�ڹ�', 'ȫ�浿', 120, '���ֿ�');

create table login(
id varchar2(20),
password varchar2(20)
);

create table member(
phone varchar2(20)
);

-- �ΰ� �÷��� ��� ��ģ �� �����

create or replace view vLoginMember as select id, password, phone from login, member;
select * from vloginmember;
drop view vloginmember;
insert into vloginmember values ('1000', '1234', '01012345678'); -- ���պ�� �Ұ�

create view vLogin as select * from login;

-- ��ȿ� �����͸� �����ϸ� ������ ���̺�� �����Ͱ� ���Եȴ�. ���պ� �Ұ�, �ܼ���� ��Ȳ������ �ٸ�
insert into vLogin values('1000', '1234');
-- �信 �ִ� �� �˻�
select * from vLogin;

-- ���̺� �ִ� �� �˻�
select * from login;

-- ���̺� ������ ����
insert into login values ('2000', '4321');

-- �� �ȿ� ������ ����, �������̺�, ����� ��� ���� ����
update vLogin set password='7890' where id = '1000';
update login set password = '9543' where id = '2000';

-- �� �ȿ� ������ �����ϱ�
delete from vLogin where id = '1000';

select * from vLogin;

-- ���� �����ͺ��̽����� �䰡 ��� �Ǿ� �ִ� �� ������ ��ųʸ��� Ȯ���ϱ�

select * from user_views;

-- vlogin �䰡 ������ ����� ������ ���� ��ü
create or replace view vlogin as select id from login;

create or replace view vvlogin as select id, password from login where id like '11%';
-- �⺻���̺� ���� ���� �� ����, �̸� �������� �� �ִ�.
create or replace force view vvvlogin as select * from kMember;

select * from vvvlogin;

-- view�� view �����
create or replace view v3Login as select * from vlogin;

-- �޿��� 800 �̻��� ����� �並 ������ּ��� ��� vSal800
create or replace view vSal800 as select * from emp where sale>=800;
-- vSal800 ���� �޿��� 50% �λ��ϼ���
update vSal800 set sale = sale + sale*0.5;

select * from vSal800;

-- �信�� dml(insert, update, delete) �ȵǰ� �ϰ� �ʹ�.
create or replace view vSal800 as select * from emp where sale>=800 with read only;

update vSal800 set sale = sale + sale*0.5; -- with read only ����

create or replace view vDept30 as select * from emp where deptno=30 with check option;
update vDept30 set deptno = 20; -- �������� ������ �ƴѰ�� ���ٺҰ�
select * from vdept30;

select * from emp where sale is not null order by sale desc;
-- rownum ������Ŀ�����̺��� �ԷµǴ� ������ ����ϴ� �÷�, �ԷµǴ� �������� �����ǰ� �ٲ��� �ʴ´�.
select rownum, ename, sale from emp where sale is not null order by sale desc;

-- ȸ�翡�� �޿��� ���� ���� �޴� ����� �˻��ϱ�
select rownum, ename, sale from (select rownum, ename, sale from emp where sale is not null order by sale desc) where rownum<=5;
select rownum, ename, sale from emp where rownum<=5 order by sale desc;