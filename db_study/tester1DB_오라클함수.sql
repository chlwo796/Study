--����Ŭ �ֿ� �Լ�
--�Ҽ������ֱ�
select round(85/3) from dual;
--���밪
select abs(-90) from dual;
--mod = ������, trunc = Ư�� �ڸ��� �߶󳻱� 
select abs(-90), trunc(34.5678,2), mod(90,8) from dual;
--upper = �빮�ڷ� ��ȯ, lower = �ҹ��ڷ� ��ȯ, initcap = ù���ڸ� �빮��, ������ �ҹ���
select 'Welcome to Oracle', upper('Welcome to Oracle'), lower('Welcome to Oracle'), initCap('WELCOME TO ORACLE') from dual;

select length('ȫ�浿') from dual; --������ ���� ���(�ѱ�1����Ʈ)
select lengthb('ȫ�浿') from dual; --'ȫ' -3����Ʈ�� ���� ����Ʈ�� ���(�ѱ�2����Ʈ)

select substr('Welcome To Oracle', 4, 3) from dual; --4��°���� 3����
select 
substr('Welcome To Oracle', 9, 1) ||
substr('Welcome To Oracle', 12, 1)|| 
substr('Welcome To Oracle', 8, 1) from dual;

select * from student;

select stu_email from student where stu_name='������';

select substr(stu_email,5,1) from student where stu_name='������';

select substr(stu_id,2,2) �Ϸù�ȣ from student;
select instr('�����ͺ��̽�', '��') from dual;
select instr('�л����̵� �л����̵�', '��', 1, 2) from dual;
select instr('���±��ڴ� ��� ������?', '��')from dual;
select * from student;
select instr(stu_id, 116), stu_id from student;

select substr(stu_email,1, instr(stu_email, '@',1,1)-1) from student;
--lpad, rpad Ư����ȣ�� ä���.
select lpad('ȫ�浿', 20,'#') from dual;
--����ȯ �Լ�
select sysdate from dual;
select sysdate, to_char(sysdate, 'yyyy/mm/dd, am hh:mi:ss') from dual;
-- L=��ȭ��ȣ,9 = �ڸ���(�ڸ����� ���� �ʾƵ� ä���� �ʴ´�.)
select to_char(123000, 'L999,999') from dual;
-- 0 = �ڸ����� ���� ���� ��� 0���� ä���.
select to_char(123000, 'L0000,000') from dual;
select to_char(12.3456, 'L00,000.00000') from dual;
select * from dual;

select * from emp;
--to_date = ��¥�������� ����ȯ
insert into emp values(1011, '�ڼ���', null, 1003, to_date(230329,'yymmdd'), 850, 0, 10);
insert into emp values(1012, '������', null, 1005, to_date('220515','yymmdd'), 740, 0 , 10);
--�Ի��� 4����
select * from emp where hiredate like '%/04/%';
--07�⵵�� �Ի��� ����
select * from emp where to_char(hiredate, 'YY')='07';
--�Ŵ�������� ��¥��
select mgr, to_date(mgr,'mm/dd') from emp where mgr !=0;
--���ڿ��� ���ڷ�
select to_number('070310', '999999')+5000 from dual;
--��¥->����->����
select to_number(to_char(hiredate,'yyyymmdd'),'99999999')from emp;