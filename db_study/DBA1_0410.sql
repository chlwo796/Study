--- 15장 pl/sql 문

set serveroutput on -- 오라클에서 제공해주는 프로시저의 내용을 출력

begin
dbms_output.put_line('hello world!');
end;
/
declare
vempno number(4);
vename varchar2(10);
begin
vempno := 1001;
vename := '김사랑';
dbms_output.put_line('사번     이름');
dbms_output.put_line('--------------');
dbms_output.put_line(vempno || ' ' || vename);
end;
/

SET SERVEROUTPUT ON;-- 출력해주는 내용을 화면에 보여준다.
begin 
    DBMS_OUTPUT.PUT_LINE('HELLO PL/SQL');
END;
/

-- 변수 종류 : 스칼라변수, 레퍼런스 변수
-- 1) 스칼라 변수
vempno number(4);
vename varchar2(10);
-- 2) 레퍼런스 변수
vempno emp.empno%type;
vename emp.ename%type;

vemp emp%rowtype;

-- select 문
select ename into vename from emp;
select * from emp;
select * from dept;

-- emp 테이블에서 사원번호와 이름을 조회하기 PL/SQL문으로 만들기

DECLARE
    vempno emp.empno%TYPE;
    vename emp.ename%TYPE;
    vdeptno emp.deptno%TYPE;
    vdname varchar2(20) := NULL;
BEGIN
    SELECT empno, ename, deptno INTO vempno, vename, vdeptno FROM emp WHERE empno=1001;
    IF( vdeptno = 10 ) THEN
        vdname := '경리부';
    ELSIF( vdeptno = 20 ) THEN
           vdname := '인사부';
    ELSIF( vdeptno = 30 ) THEN
           vdname := '영업부';
    ELSE vdname := '전산부';
    END IF;
    DBMS_OUTPUT.PUT_LINE('사번      이름      부서번호    부서명');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------');
    DBMS_OUTPUT.PUT_LINE(vempno||'     '||vename||'     '||vdeptno||'         '||vdname);
END;
/

-- 반복문 loop
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

-- 반복문 for
declare

begin
    for n in 1..5 loop
    dbms_output.put_line(n);
    end loop;
end;
/

-- 반복문 while
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

-- 16장 저장 프로시저
drop table emp01;
create table emp01 as select * from emp;

select * from emp01;
-- 저장프로시저 생성
create or replace procedure del_all
is
begin
delete from emp01;
commit;
end;
/
-- 실행하기
execute del_all;
select * from emp;
desc user_source;
select name, type, line, text from user_source;

-- 이씨 성을 가진 사람만 삭제하기

create or replace procedure del_name(vename emp01.ename%type)   -- (가인수, 가매개변수)
is
begin
    delete from emp01 where ename like vename;
    commit;
    end;
/

execute del_name('이%'); -- (실인수, 파라미터)

select * from emp01;

-- in, out, inout 매개변수
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

-- 프로시저의 장점
-- 여러 클라이언트의 업무 규칙 공유
-- 서버에 미리 복잡한 쿼리문을 만들고, 클라이언트는 실행문에 실매개값만 보내면 된다.
-- 보안성 좋음

-- 저장함수
-- 특징 : 프로시저와 다른점은 실행결과를 되돌려받을 수 있다.
-- 함수 생성
create or replace function call_bonus(
vempno in emp.empno%type)
return number
is vsal number(7);
begin
select sale into vsal from emp where empno = vempno;
return (vsal + 200);
end;
/

-- 함수 호출
variable var_res number;
execute :var_res := call_bonus(1001);

print var_res;

-- 커서
select * from emp;
select * from dept;

create or replace procedure cursor_sample01 is
vdept dept%rowtype;
cursor c1 -- 1단계 커서 선언
is
select * from dept;
begin
dbms_output.put_line('부서번호    부서명   지역명');
dbms_output.put_line('-------------------------');
open c1; -- 2단계 커서 열기
loop
    fetch c1 into vdept.deptno, vdept.dname, vdept.loc;
    exit when c1%notfound;
    dbms_output.put_line(vdept.deptno ||' ' || vdept.dname || ' ' || vdept.loc);
end loop;
close c1;
end;
/

-- 실행
execute cursor_sample01;
-- 자바 코드
set serveroutput on execute cursor_sample01;
set serveroutput on
    execute cursor_sample01;
select * from emp;

-- 트리거 = 특정 테이블 변경 후 이를 이벤트로 다른 테이블 자동 변경
-- 신입사원의 정보를 추가할 때 '신입사원이 입사했습니다' 라고 출력하기
create table emp02(
empno number(4) primary key,
ename varchar2(20),
job varchar2(20)
);

-- 트리거 생성
create or replace trigger trg_01
after insert
on emp02
begin
dbms_output.put_line('신입사원이 입사했습니다.');
end;
/

insert into emp02 values(1002, '김사랑', '사원');
select * from emp02;
-- insert 시만 트리거 실행
update emp02 set ename = '홍길동' where empno = 1001;

-- 급여 정보를 자동으로 추가하는 트리거 작성하기
create table sal01(
salno number(4) primary key,
sal number(7),
empno number(4) references emp02(empno)
);

create sequence sal01_salno_seq;
create or replace trigger trg_02

-- 예제3 급여 정보를 자동 삭제하는 트리거 작성
create or replace trigger trg_03
after delete
on emp02 
for each row
begin delete from sal01 where empno :=old.empno;
end;
/


