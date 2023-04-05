create table c5emp as select * from emp;

select * from c5emp;

create view viewEmp as select * from c5emp;

-- 복잡한 서브쿼리문을 빈번히 사용할 경우 뷰로 만들어 두면
create view venameMgr as
select member.ename 사원이름, manager.ename 직속상관이름
from emp member left outer join emp manager
on member.mgr = manager.empno;

select * from venameMgr;

select * from venameMgr where 사원이름 = '김수환';

select * from student;
select * from course;

-- 서브쿼리
-- 코스가 모바일인 사람의 코스번호, 코스명, 선생님명, 학생번호, 학생명을 검색

select c.cou_id 코스번호, c.cou_name 코스명, c.tea_name 선생님명, s.stu_id 학생번호, s.stu_name 학생명
from student s, course c where c.cou_id = s. cou_id and c.cou_name = '모바일';

-- 뷰로 만들기
-- 형식 create view 뷰이름 as 쿼리문
create view vStudentCourse as select c.cou_id, c.cou_name, c.tea_name, s.stu_id, s.stu_name from course c, student s where c.cou_id = s.cou_id and c.cou_name = '모바일';

select * from vStudentCourse;

-- 뷰는 논리적인 가상테이블
-- 사용하는 이유? 복잡하고 긴 쿼리문을 빈번하게 사용할 경우 뷰로 만들어 두면 간단해 진다.

desc user_views;
select * from user_views;
-- 원래 테이블의 자료가 연결될 때 오류 발생 
insert into vStudentCourse values (50, '자바', '홍길동', 120, '최주영');

create table login(
id varchar2(20),
password varchar2(20)
);

create table member(
phone varchar2(20)
);

-- 두개 컬럼을 모두 합친 뷰 만들기

create or replace view vLoginMember as select id, password, phone from login, member;
select * from vloginmember;
drop view vloginmember;
insert into vloginmember values ('1000', '1234', '01012345678'); -- 복합뷰는 불가

create view vLogin as select * from login;

-- 뷰안에 데이터를 삽입하면 물리적 테이블로 데이터가 삽입된다. 복합뷰 불가, 단순뷰는 상황에따라 다름
insert into vLogin values('1000', '1234');
-- 뷰에 있는 것 검색
select * from vLogin;

-- 테이블에 있는 것 검색
select * from login;

-- 테이블에 데이터 삽입
insert into login values ('2000', '4321');

-- 뷰 안에 데이터 수정, 물리테이블, 가상뷰 모두 수정 가능
update vLogin set password='7890' where id = '1000';
update login set password = '9543' where id = '2000';

-- 뷰 안에 데이터 삭제하기
delete from vLogin where id = '1000';

select * from vLogin;

-- 현재 데이터베이스에서 뷰가 어떻게 되어 있는 지 데이터 딕셔너리로 확인하기

select * from user_views;

-- vlogin 뷰가 없으면 만들고 있으면 새로 대체
create or replace view vlogin as select id from login;

create or replace view vvlogin as select id, password from login where id like '11%';
-- 기본테이블 없이 강제 뷰 생성, 미리 만들어놓을 수 있다.
create or replace force view vvvlogin as select * from kMember;

select * from vvvlogin;

-- view로 view 만들기
create or replace view v3Login as select * from vlogin;

-- 급여가 800 이상인 사람만 뷰를 만들어주세요 뷰명 vSal800
create or replace view vSal800 as select * from emp where sale>=800;
-- vSal800 뷰의 급여를 50% 인상하세요
update vSal800 set sale = sale + sale*0.5;

select * from vSal800;

-- 뷰에서 dml(insert, update, delete) 안되게 하고 싶다.
create or replace view vSal800 as select * from emp where sale>=800 with read only;

update vSal800 set sale = sale + sale*0.5; -- with read only 설정

create or replace view vDept30 as select * from emp where deptno=30 with check option;
update vDept30 set deptno = 20; -- 웨어절의 조건이 아닌경우 접근불가
select * from vdept30;

select * from emp where sale is not null order by sale desc;
-- rownum 마지막커밋테이블의 입력되는 순서를 기억하는 컬럼, 입력되는 시점에서 결정되고 바뀌지 않는다.
select rownum, ename, sale from emp where sale is not null order by sale desc;

-- 회사에서 급여를 제일 많이 받는 사람을 검색하기
select rownum, ename, sale from (select rownum, ename, sale from emp where sale is not null order by sale desc) where rownum<=5;
select rownum, ename, sale from emp where rownum<=5 order by sale desc;