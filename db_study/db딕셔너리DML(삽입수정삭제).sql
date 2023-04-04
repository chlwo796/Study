-- 7장 테이블 구조 생성, 변경, 제거하는 DDL(Database Define Language) 데이터정의어
-- 목표 테이블 만들고 수정 삭제
-- tester1DB = 스키마
create table emp01(
empno number(4),
ename varchar2(14),
sal number(7,3)
);
-- 테이블 구조 확인
desc emp01;
create table emp02(
    empno number(4) default 1000,
    ename varchar2(14) default '홍길동',
    sal number(7,3)
);

insert into emp01(empno) values (2000);
insert into emp02(sal) values (500);

-- 테이블 구조를 만들기 이름 부서명 입사일-기본값으로 오늘 날짜
create table emp03(
    ename varchar2(14),
    dname varchar2(14),
    hiredate date default sysdate
);
insert into emp03 values ('최진영', '전산부', '2022/10/08');
insert into emp03 values ('이수민', '영업부', '2023/03/03');

select * from emp03;

alter table emp01
    add(birth date default sysdate);
    
desc emp01;

--sal 컬럼의 자료형을 number(7,3) --> number(8)로 변경하기

alter table emp01
    modify(sal number(8));
    
-- empno varchar2(10) ename varchar2(20)으로 변경하기
alter table emp01
    modify (empno varchar2(10), ename varchar2(20));
    
select * from emp01;
desc emp01;

update emp01 set empno = null;

--sal 컬럼을 지우기

alter table emp02
    drop column sal;

desc emp02;

-- deptno, hiredate 컬럼을 모두 삭제하기
alter table emp03
    drop column deptname;
    
alter table emp03
    drop column hiredate;
    
desc emp03;

--레코드수가 아주 많은 경우에 컬럼변경(추가, 수정, 삭제)할 경우 데이터베이스 속도가 느려진다.
--삭제할 컬럼을 바로 바로 지우는게 아니라 unused로 만들어 두고 나중에 한꺼번에 삭제합니다.

select * from emp02; --unused된 컬럼은 검색이 되지 않는다.
alter table emp02
    set unused(ename);  -- 사용하지 않을 컬럼을 체크하는것

desc emp02;


alter table emp02 --unused된 컬럼을 완전히 제거한다.
    drop unused columns;
    
--table 변경
select * from emp01;
-- 테이블 이름 변경
rename emp01 to newEmp01;
select * from newEmp01;
desc newEmp01;

-- 테이블의 구조를 제거하는 것 = 테이블 제거
drop table newEmp01;
drop table emp03;

-- 테이블 속안에 데이터를 모두 삭제
create table copyEmp as select * from emp;
-- 테이블 속 안에 데이터(레코드)를 모두 삭제하기 방법1) delete 문, 방법2) truncate table 문
select * from copyEmp;
-- delete문으로 트랜잭션에서 작업이 이루어지므로 commit 전에 rollback 하여 삭제를 취소할 수 있다.
delete from copyEmp;
-- 방금전에 했던 명령 되돌리기 트랜잭션에서 작업하는 것 되돌리기
rollback;
-- 트랜잭션은 은행에서 예금 인출처럼 100% 완료되어야 성공, 중간에 멈추면 처음으로 되돌아 가는 것
truncate table copyEmp; 
-- truncate table은 데이터베이스 내부에서 처리, rollback 처리 x
-- ~~쓴다 = 저장, 삭제, 수정, 삽입 내포되어있음
-- ~~읽는다 = 보기만 가능
select table_name from user_tables;
select * from user_tables;
select table_name, max_trans from user_tables;
select * from all_tables;
-- dba = 시스템 관리와 관련
--select * from dba_tables; -- 로컬에서 dba 접근 x

-- 데이터 딕셔너리
-- 사용자가 만드는 테이블이 아니고 데이터베이스 서버에서 자동으로 만들고 수정하여 준다. 
-- 사용자는 보기만 한다. 사용자는 데이터베이스 서버안에 들어 있는 정보를 볼때 이용한다. 
-- user_  all_  dba_
--------------------------
-- dml = data manipulation language, 데이터 조작어, 웹개발자가 자바코드에 명령어 써준다.
-- select insert update delete
create table dept01(
    deptno number(2),
    dname varchar2(14),
    loc varchar2(13)
);

desc dept01;
-- 수정 및 복사
insert into dept01 values(10, '경리부', '서울');
-- 특정 행 삽입
insert into dept01 select deptno, dname, loc from dept where deptno = 20;
-- 여러개 삽입
insert into dept01 select deptno, dname, loc from dept;
-- loc = null로 삽입
insert into dept01 (deptno, dname) select deptno, dname from dept;
select * from dept;

select * from dept where deptno = 20;

-- 숫자 삽입, 문자 삽입, 날짜 삽입, null 삽입
alter table dept01 add birth date;
-- deptno 20 or 30 인 레코드 안에 오늘 ㅇ날짜로 생일을 넣어 주세요
insert into dept01 select deptno, dname, loc, sysdate from dept where deptno in (20, 30);
desc dept01;
select * from dept01;
--dname 전산부인 사람의 birth를 1990/12/25로 삽입
------------------------
-- 레코드를 삽입할 때 insert문
-- 형식 insert into 테이블명(컬럼명1, 컬럼명2 ...) values ('실제값',...);
-- 레코드를 수정할 때 update 문
-- 형식 update 테이블명 set 컬러명 = '실제값',... where 조건절
select * from emp;
-- mgr 1005인 사람의 급여를 50만원 인상
update emp set sale = sale+50 where mgr = 1005;
-- job이 사원 대리인 사람의 보너스
update emp set comm = comm + 30 where job in ('사원', '대리');
-- 입사일이 05년 이전의 사람의 급여를 100만원 인상
update emp set sale = sale + 100 where hiredate<='05/01/01';
-- 평균 급여보다 적게 받은 직원에 대해서 보너스 50만원 지급하세요.
select avg(sale) from emp;
-- 평균 급여?
update emp set comm = comm + 50 where sale< (select avg(sale) from emp);
select * from emp;
-- 부서별로 제일 많이 받는 사람은 급여 100만원 삭감
-- 1단계 부서별로 제일 많이 받는 사람은?
select ename, deptno, max(sale) from emp group by deptno, ename;
update emp set sale = sale-100 where sale=(select max(sale) from emp group by deptno);
update emp set sale = sale-100 where sale in (select max(sale) from emp group by deptno);

-- job 사장이거나 입사일 98/12/31 이전 입사인 사람의 급여 = 급여 + 평균급여 수정
update emp set sale = sale + ( select avg(sale) from emp) where job = '사장' or hiredate<='98/12/31';
select * from emp;
-- job 수습인 사람들을 사원 변경하세요.
update emp set job = '사원' where job = '과장';

-- delete문
create table c4emp as select * from emp;
select * from c4emp;

-- 급여가 1000만원 이상인 사람 삭제
delete from c4emp where sale>=1000;
-- mgr 1008, 1003인 사람 삭제
delete from c4emp where mgr in (1008, 1003);
-- 김씨, 이씨인 사람 제외하고 모두 삭제
delete from c4emp where not ename like '김%' or not ename like '이%';
-- 보너스가 100만원 이상인 사람 삭제
delete from c4emp where comm>=100;
-- deptno가 10, 20인 사람 삭제
delete from c4emp where deptno in (10, 20);

rollback;
commit;
update emp set sale = sale + 500 where job = '사장';
rollback;
select * from emp;
update emp set sale = sale-500 where job = '사장';

insert into emp ( deptno) values (80);
desc user_constraints;
-- 제약조건 사용 목적 : 데이터베이스를 사용할 때 데이터의 오류 방지
-- 데이터베이스 딕셔너리를 통하여 제약조건에 대한 컬럼구조 보기
-- 데이터베이스 딕셔너리를 통하여 제약조건의 제약조건명, 제약조건 타입, 테이블명 보기
-- 필요한 컬럼들만 선택해서 보기
select constraint_name, constraint_type, table_name from user_constraints;
-- 전체 제약조건에 관련된 컬럼들 보기
select * from user_constraints;
-- constraint_type P-primary key, R_foreign key, U-unique, C-check 또는 not null

-- 각 제약조건 만들기 -> 수정-> 삭제
-- 만들기 테이블 생성할 때 제약조건을 만든다.
drop table emp03;
create table emp03(
empno number(4),
ename varchar2(10),
job varchar2(10),
deptno number(2)
);
drop table emp03;
select  constraint_name, constraint_type, table_name search_condition from user_constraints where table_name in ('EMP03');

create table emp03(
empno number(4) unique,
ename varchar2(10) unique,
job varchar2(10),
deptno number(2)
);

-- 삽입하기
-- 정상으로 삽입하기

insert into emp03 values (1001, '홍길동', '사장', 10);
-- impno 없이
insert into emp03(ename, job, deptno) values ('이순신', '부사장' , 10);
-- ename 입력x
insert into emp03(empno, job, deptno) values (1002, '사원', 20);
-- unique 유효성
insert into emp03 values(1001, '박미주', '부장', 10);
insert into emp03 values(null, '박미주', '부장', 10);    -- null 중복가능
insert into emp03(ename, job, deptno) values ('이순신', '부사장', 10);

select * from emp03;
select * from user_constraints where table_name in ('EMP03');
-- 제약조건(constraint_name) 사용자 정의
create table emp03(
empno number(4) constraint emp03_empno_uk unique, -- constraint 제약조건명 제약조건
-- 제약조건명을 만드는 방법 : 테이블명_컬럼명_제약조건명
ename varchar2(10) constraint emp03_ename_uk unique,
job varchar2(10) constraint emp03_job_nn not null,
deptno number(2) constraint emp03_job_nn_uk not null unique
);
select * from user_constraints where table_name in ('EMP03');

-- primary key 기본키 = not null + unique

drop table emp03;

create table emp03(
empno number(4),
ename varchar2(10),
job varchar2(10),
deptno number(2),
constraint emp03_empno_pk primary key(empno)
);
-- 정상입력
insert into emp03 values (1001, '최재환', '무직', 20);
insert into emp03 values (1002, '최재남', '무직', 30);
-- 오류입력 
insert into emp03 (enmae, job, deptno) values ('최재환', '백수', 20);
insert into emp03 values (1001, '최재환', '무직', 30);
-- foreign key 외래키
-- 부모테이블 먼저 생성
create table dept03(
deptno number(4),
dname varchar2(10),
loc varchar2(10),
constraint dept03_deptno_pk primary key(deptno)
);
drop table emp03;
-- 첫번재 방법
create table emp03(
empno number(4),
ename varchar2(20),
deptno number(4) constraint emp03_deptno_nn not null
                constraint emp03_deptno_fk references dept03(deptno),
constraint emp03_empno_pk primary key(empno)
);
select * from emp03;
-- 두번째 방법
create table emp03(
empno number(4),
ename varchar2(20),
deptno number(4) constraint emp03_deptno_nn not null,
foreign key(deptno) references dept03(deptno)
);
select * from user_constraints where table_name in ('EMP03', 'DEPT03');
insert into dept03 values(10, '경리부', '서울');
insert into emp03 values(1001, '홍길동', 10);

-- check 제약조건
-- 입력되는 값을 체크하여 설정된 값 이외의 값이 들어오면 오류
drop table emp03;
create table emp03(
empno number(4),
salary number(10) check(salary between 500 and 5000), -- 제약 조건명을 명시하지 않고
comm number(10) constraint emp03_comm_ck check( comm between 10 and 1000)
);
select * from user_constraints where table_name in ('EMP03');
-- 정상입력
insert into emp03 values(1001, 800, 20);
-- 오류입력
insert into emp03 values(1001, 5000, 0);
-- 제약 만들기
-- 제약 수정, 삭제

-- 복합키 2개 이상 컬럼을 합쳐서 기본키로 만든 것

drop table emp03;
create table emp03(
    ephone number(4),
    ename varchar2(20),
    job varchar2(20),
    constraint emp03_ephone_ename_pk primary key(ephone, ename)
);

insert into emp03 values(3334, '홍길동', '사원');
insert into emp03 values(3334, '이길동', '사원');
insert into emp03 values(3344, '홍길동', '사원');
insert into emp03 values(3334, '홍길동', '사원');

drop table emp03;
drop table dept03;
create table emp03(
    empno number(4),
    ename varchar2(20),
    job varchar2(20),
    deptno number(4)
);
-- 제약조건 추가
alter table emp03 add constraint emp03_empno_pk primary key(empno);

select * from user_constraints where table_name in ('EMP03');

-- deptno 외래키 지정
create table dept03(
    deptno number(4),
    dname varchar2(20),
    loc varchar2(20)
);

alter table dept03 add constraint dept03_deptno_pk primary key(deptno);

alter table emp03 add constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno);

-- dname loc를 복합키로 제약조건 추가하기
drop table dept03;
drop table emp03;

alter table dept03 add constraint dept03_dname_loc_pk primary key(dname, loc);
-- dname not null로 지정하지 않으면 자동으로 null
-- not null로 지정하지 않으면 자동으로 null
alter table dept03 modify dname constraint dept03_dname_nn not null;

-- ename not null로 조건 변경
alter table emp03 modify ename constraint emp03_ename_nn not null;
-- 제약조건 제거
-- 1. 제약조건명으로 제거
alter table dept03 drop constraint dept03_dname_nn;
select * from user_constraints where table_name in('DEPT03');

-- emp03 primary 키의 제약조건을 제거
alter table emp03 drop primary key;
-- primary key, foreign key, check 제약조건 추가 add constraint ~
-- primary key, foreign key, check 제약조건 제거 drop constraint ~, drop primary key
-- not null

CREATE TABLE  employee(

    emp_no number(4),

    emp_name varchar2(20),

    salary  number(6),

    birthday  date );
CREATE TABLE  prjoect(

     pro_no number(4),

     pro_content varchar2(100),

     start_date  date,

     finish_date date );
     CREATE TABLE  specialty(

     emp_no number(4),

     specialty   varchar2(20)

);
CREATE TABLE assign(

   emp_no   number(4),

   pro_no    number(4) );
alter table employee add constraint employee_pk primary key(emp_no);
alter table assign add constraint assign_employee_fk foreign key(emp_no) references employee(emp_no) ;
alter table prjoect add constraint project_pk primary key(pro_no);
alter table assign add constraint assign_project_fk foreign key(pro_no) references prjoect(pro_no);
alter table specialty add constraint specialty_fk foreign key(emp_no) references employee(emp_no);
alter table specialty add constraint specialty_pk primary key(specialty);
alter table assign add constraint assign_pk primary key (emp_no, pro_no);

select * from user_constraints where table_name in ('EMPLOYEE', 'PRJOECT', 'SPECIALTY','ASSIGN');

-- cascade 종속
-- 부모테이블의 자료를 변경하면 자식도 같이 변경이 될 수 있게 제약조건을 만들어 주는 것.
drop table emp03;
drop table dept03;

create table emp03(
empno number(4),
ename varchar2(10)
constraint emp03_ename_nn not null,
job varchar2(10),
deptno number(2),
constraint emp03_empno_pk primary key(deptno),
constraint emp03_job_uk unique(job),
constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno)
);
create table dept03(
deptno number(2),
dname varchar2(10),
loc varchar2(10),
constraint dept03_deptno primary key(deptno)
);

select * from user_constraints where table_name in('EMP03', 'DEPT03');
insert into emp03 values (1000, '홍길동', '사원', 50);
-- 부모자료 넣고 자식 자료 넣는다. or 제약조건을 임시로 비활성화(disable constraint)
alter table emp03 disable constraint emp03_deptno_fk; --비권장사항
-- 비활성화한 제약조건을 다시 활성화
alter table emp03 enable constraint emp03_deptno_fk;
delete from emp03;
-- cascade 옵션
alter table dept03 disable primary key cascade;
alter table dept03 enable primary key;
alter table emp03 enable constraint emp03_deptno_fk;
insert into emp03 values (1000, '홍길동', '사원', 50);


