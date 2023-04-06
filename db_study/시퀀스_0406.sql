------------------------------13장 시퀀스 개념------------------------------------
-- 시퀀스 생성하기
create sequence dept_deptno_seq
    start with 10
    increment by 10;
    
-- 시퀀스 데이터 딕셔너리 보기
desc user_sequences; -- 구조보기
select *from user_sequences;

-- 시퀀스의 현재값 currval
select dept_deptno_seq.currval from dual; -- 처음 이것부터 수행하니깐? 에러, nextval 포인트(가르키는 위치) 위치 값을 보여준다.
-- 시퀀스의 다음값 nextval
select dept_deptno_seq.nextval from dual; -- 증가값 만큼 위치를 이동해서 값을 보여준다.

drop sequence emp_seq;

-- 시퀀스를 실제 테이블에서 어떻게 사용할까?
create sequence emp_seq
    start with 1
    increment by 1
    maxvalue 1000;
    
create table seqEmp(
    empno number(4), -- 자동으로 번호 증가되게
    name varchar2(20), -- 직접 입력
    beginDate date -- 자동으로 오늘 날짜가 입력되게
);

drop table seqEmp;

insert into seqEmp values (emp_seq.nextval, '홍길동', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동2', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동3', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동4', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동5', sysdate);

select *from seqEmp;

-- sequence 수정하기
alter sequence emp_seq
    increment by 10
    maxvalue 100
    cycle
    cache 2;

insert into seqEmp values (emp_seq.nextval, '홍길동1', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동2', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동3', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동4', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동5', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동6', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동7', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동8', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동9', sysdate);
insert into seqEmp values (emp_seq.nextval, '홍길동10', sysdate);

select *from seqEmp;

-- 인덱스 정보
select * from user_ind_columns; -- 테이블을 만들 때 primary key는 자동으로 인덱스 처리

-- 이름으로 검색하는 것이 빈번하며, 검색을 빠르게 하고 싶은 경우
-- 해결책 이름을 인덱스로 만들어 주세요
create index idx_emp_ename on emp(ename);



select * from emp;
select * from emp where job = '사원';

drop index idx_emp_ename;

select * from student;
create index idx_student_name on student(stu_name);
drop index idx_student_name;
set timing on;
select * from student where stu_name='장희성';
set timing on;
select * from student where sex != 'M';
set timing on;
-- 인덱스를 해야하는 경우
-- 테이블의 행의 수가 많을 때
-- where문에 해당 컬럼이 많이 사용될 때
-- 검색결과가 전체 데이터의 2%~4%정도일 때
-- join에 자주 사용되는 컬럼이나 null을 포함하는 컬럼이 많은 경우

-- 인덱스하면 안 좋은 경우
-- 테이블의 행의 수가 적을 때
-- where문에 해당 컬럼이 적게 사용될 때
-- 검색결과가 전체데이터의 10%~15%정도일 때
-- 테이블에 DML을 자주 사용할 때