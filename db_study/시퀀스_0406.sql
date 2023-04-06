------------------------------13�� ������ ����------------------------------------
-- ������ �����ϱ�
create sequence dept_deptno_seq
    start with 10
    increment by 10;
    
-- ������ ������ ��ųʸ� ����
desc user_sequences; -- ��������
select *from user_sequences;

-- �������� ���簪 currval
select dept_deptno_seq.currval from dual; -- ó�� �̰ͺ��� �����ϴϱ�? ����, nextval ����Ʈ(����Ű�� ��ġ) ��ġ ���� �����ش�.
-- �������� ������ nextval
select dept_deptno_seq.nextval from dual; -- ������ ��ŭ ��ġ�� �̵��ؼ� ���� �����ش�.

drop sequence emp_seq;

-- �������� ���� ���̺��� ��� ����ұ�?
create sequence emp_seq
    start with 1
    increment by 1
    maxvalue 1000;
    
create table seqEmp(
    empno number(4), -- �ڵ����� ��ȣ �����ǰ�
    name varchar2(20), -- ���� �Է�
    beginDate date -- �ڵ����� ���� ��¥�� �Էµǰ�
);

drop table seqEmp;

insert into seqEmp values (emp_seq.nextval, 'ȫ�浿', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿2', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿3', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿4', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿5', sysdate);

select *from seqEmp;

-- sequence �����ϱ�
alter sequence emp_seq
    increment by 10
    maxvalue 100
    cycle
    cache 2;

insert into seqEmp values (emp_seq.nextval, 'ȫ�浿1', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿2', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿3', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿4', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿5', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿6', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿7', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿8', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿9', sysdate);
insert into seqEmp values (emp_seq.nextval, 'ȫ�浿10', sysdate);

select *from seqEmp;

-- �ε��� ����
select * from user_ind_columns; -- ���̺��� ���� �� primary key�� �ڵ����� �ε��� ó��

-- �̸����� �˻��ϴ� ���� ����ϸ�, �˻��� ������ �ϰ� ���� ���
-- �ذ�å �̸��� �ε����� ����� �ּ���
create index idx_emp_ename on emp(ename);



select * from emp;
select * from emp where job = '���';

drop index idx_emp_ename;

select * from student;
create index idx_student_name on student(stu_name);
drop index idx_student_name;
set timing on;
select * from student where stu_name='����';
set timing on;
select * from student where sex != 'M';
set timing on;
-- �ε����� �ؾ��ϴ� ���
-- ���̺��� ���� ���� ���� ��
-- where���� �ش� �÷��� ���� ���� ��
-- �˻������ ��ü �������� 2%~4%������ ��
-- join�� ���� ���Ǵ� �÷��̳� null�� �����ϴ� �÷��� ���� ���

-- �ε����ϸ� �� ���� ���
-- ���̺��� ���� ���� ���� ��
-- where���� �ش� �÷��� ���� ���� ��
-- �˻������ ��ü�������� 10%~15%������ ��
-- ���̺� DML�� ���� ����� ��