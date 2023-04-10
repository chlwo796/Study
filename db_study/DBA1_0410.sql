--- 15�� pl/sql ��

set serveroutput on -- ����Ŭ���� �������ִ� ���ν����� ������ ���

begin
dbms_output.put_line('hello world!');
end;
/
declare
vempno number(4);
vename varchar2(10);
begin
vempno := 1001;
vename := '����';
dbms_output.put_line('���     �̸�');
dbms_output.put_line('--------------');
dbms_output.put_line(vempno || ' ' || vename);
end;
/

SET SERVEROUTPUT ON;-- ������ִ� ������ ȭ�鿡 �����ش�.
begin 
    DBMS_OUTPUT.PUT_LINE('HELLO PL/SQL');
END;
/

-- ���� ���� : ��Į�󺯼�, ���۷��� ����
-- 1) ��Į�� ����
vempno number(4);
vename varchar2(10);
-- 2) ���۷��� ����
vempno emp.empno%type;
vename emp.ename%type;

vemp emp%rowtype;

-- select ��
select ename into vename from emp;
select * from emp;
select * from dept;

-- emp ���̺��� �����ȣ�� �̸��� ��ȸ�ϱ� PL/SQL������ �����

DECLARE
    vempno emp.empno%TYPE;
    vename emp.ename%TYPE;
    vdeptno emp.deptno%TYPE;
    vdname varchar2(20) := NULL;
BEGIN
    SELECT empno, ename, deptno INTO vempno, vename, vdeptno FROM emp WHERE empno=1001;
    IF( vdeptno = 10 ) THEN
        vdname := '�渮��';
    ELSIF( vdeptno = 20 ) THEN
           vdname := '�λ��';
    ELSIF( vdeptno = 30 ) THEN
           vdname := '������';
    ELSE vdname := '�����';
    END IF;
    DBMS_OUTPUT.PUT_LINE('���      �̸�      �μ���ȣ    �μ���');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------');
    DBMS_OUTPUT.PUT_LINE(vempno||'     '||vename||'     '||vdeptno||'         '||vdname);
END;
/

-- �ݺ��� loop
declare n number := 1;
begin loop 
dbms_output.put_line(n);
n:=n+1;
if n>5 then
exit;
end if;
end loop;
end;
/

-- �ݺ��� for
declare

begin
    for n in 1..5 loop
    dbms_output.put_line(n);
    end loop;
end;
/

-- �ݺ��� while
declare
n number := 1;
begin
loop
dbms_output.put_line(n);
n:=n+1;
if n>5 then exit;
end if;
end loop;
end;
/

-- 16�� ���� ���ν���
drop table emp01;
create table emp01 as select * from emp;

select * from emp01;
-- �������ν��� ����
create or replace procedure del_all
is
begin
delete from emp01;
commit;
end;
/
-- �����ϱ�
execute del_all;
select * from emp;
desc user_source;
select name, type, line, text from user_source;

-- �̾� ���� ���� ����� �����ϱ�

create or replace procedure del_name(vename emp01.ename%type)   -- (���μ�, ���Ű�����)
is
begin
    delete from emp01 where ename like vename;
    commit;
    end;
/

execute del_name('��%'); -- (���μ�, �Ķ����)

select * from emp01;

-- in, out, inout �Ű�����
create or replace procedure sal_empno
(
    vempno in emp.empno%type,
    vename out emp.ename%type,
    vsale out emp.sale%type,
    vjob out emp.job%type
)
is begin 
    select ename, sale,job into vename, vsale, vjob from emp where empno = vempno;
end;
/

variable vename varchar2(15);
variable vsale number;
variable vjob varchar2(15);
execute sal_empno(1001,:vename,:vsale,:vjob);

print vename;
print vsale;
print vjob;
print vename;

-- ���ν����� ����
-- ���� Ŭ���̾�Ʈ�� ���� ��Ģ ����
-- ������ �̸� ������ �������� �����, Ŭ���̾�Ʈ�� ���๮�� �ǸŰ����� ������ �ȴ�.
-- ���ȼ� ����

-- �����Լ�
-- Ư¡ : ���ν����� �ٸ����� �������� �ǵ������� �� �ִ�.
-- �Լ� ����
create or replace function call_bonus(
vempno in emp.empno%type)
return number
is vsal number(7);
begin
select sale into vsal from emp where empno = vempno;
return (vsal + 200);
end;
/

-- �Լ� ȣ��
variable var_res number;
execute :var_res := call_bonus(1001);

print var_res;

-- Ŀ��
select * from emp;
select * from dept;

create or replace procedure cursor_sample01 is
vdept dept%rowtype;
cursor c1 -- 1�ܰ� Ŀ�� ����
is
select * from dept;
begin
dbms_output.put_line('�μ���ȣ    �μ���   ������');
dbms_output.put_line('-------------------------');
open c1; -- 2�ܰ� Ŀ�� ����
loop
    fetch c1 into vdept.deptno, vdept.dname, vdept.loc;
    exit when c1%notfound;
    dbms_output.put_line(vdept.deptno ||' ' || vdept.dname || ' ' || vdept.loc);
end loop;
close c1;
end;
/

-- ����
execute cursor_sample01;
-- �ڹ� �ڵ�
set serveroutput on execute cursor_sample01;
set serveroutput on
    execute cursor_sample01;
select * from emp;

-- Ʈ���� = Ư�� ���̺� ���� �� �̸� �̺�Ʈ�� �ٸ� ���̺� �ڵ� ����
-- ���Ի���� ������ �߰��� �� '���Ի���� �Ի��߽��ϴ�' ��� ����ϱ�
create table emp02(
empno number(4) primary key,
ename varchar2(20),
job varchar2(20)
);

-- Ʈ���� ����
create or replace trigger trg_01
after insert
on emp02
begin
dbms_output.put_line('���Ի���� �Ի��߽��ϴ�.');
end;
/

insert into emp02 values(1002, '����', '���');
select * from emp02;
-- insert �ø� Ʈ���� ����
update emp02 set ename = 'ȫ�浿' where empno = 1001;

-- �޿� ������ �ڵ����� �߰��ϴ� Ʈ���� �ۼ��ϱ�
create table sal01(
salno number(4) primary key,
sal number(7),
empno number(4) references emp02(empno)
);

create sequence sal01_salno_seq;
create or replace trigger trg_02

-- ����3 �޿� ������ �ڵ� �����ϴ� Ʈ���� �ۼ�
create or replace trigger trg_03
after delete
on emp02 
for each row
begin delete from sal01 where empno :=old.empno;
end;
/


