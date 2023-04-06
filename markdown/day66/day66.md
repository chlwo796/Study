2023년 4월 5일 수요일

## day66

### 1. ncs

- UI(User Interface)

  - CLI(명령어 라인 인터페이스, Command Line Interface)
  - GUI(그래픽 유저 인터페이스, Graphical User Interface)
  - NUI(자연어 유저 인터페이스, Natural User Interface)

- 소프트웨어 아키텍처(Software Architecture)

  - 소프트웨어 구성요소 중 외부에 드러나는 요소 특성과 요소들 간의 관계를 표현한 것이다.

- 제약사항(Constraints Requirements)
  - 시스템을 설계하거나 구현할 때 관련되는 기술이나 표준, 규정들을 의미한다.

---

### 2. oracle

- chap. 12 뷰

  ```sql
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
  ```

- [뷰 문제 실습](https://cafe.naver.com/thisiscoding)

  ```sql
  create table student
  ( studno number(4) primary key,
    name   varchar2(10) not null,
    id varchar2(20) not null unique,
    grade number check(grade between 1 and 6),
    jumin char(13) not null,
    birthday  date,
    tel varchar2(15),
    height  number(4),
    weight  number(3),
    deptno1 number(3),
    deptno2 number(3),
    profno  number(4)) tablespace users;

  insert into student values (
  9411,'서진수','75true',4,'7510231901813',to_date('1975-10-23','YYYY-MM-DD'),'055)381-2158',180,72,101,201,1001);

  insert into student values (
  9412,'서재수','pooh94',4,'7502241128467',to_date('1975-02-24','YYYY-MM-DD'),'051)426-1700',172,64,102,null,2001);

  insert into student values (
  9413,'이미경','angel000',4,'7506152123648',to_date('1975-06-15','YYYY-MM-DD'),'053)266-8947',168,52,103,203,3002);

  insert into student values (
  9414,'김재수','gunmandu',4,'7512251063421',to_date('1975-12-25','YYYY-MM-DD'),'02)6255-9875',177,83,201,null,4001);

  insert into student values (
  9415,'박동호','pincle1',4,'7503031639826',to_date('1975-03-03','YYYY-MM-DD'),'031)740-6388',182,70,202,null,4003);

  insert into student values (
  9511,'김신영','bingo',3,'7601232186327',to_date('1976-01-23','YYYY-MM-DD'),'055)333-6328',164,48,101,null,1002);

  insert into student values (
  9512,'신은경','jjang1',3,'7604122298371',to_date('1976-04-12','YYYY-MM-DD'),'051)418-9627',161,42,102,201,2002);

  insert into student values (
  9513,'오나라','nara5',3,'7609112118379',to_date('1976-09-11','YYYY-MM-DD'),'051)724-9618',177,55,202,null,4003);

  insert into student values (
  9514,'구유미','guyume',3,'7601202378641',to_date('1976-01-20','YYYY-MM-DD'),'055)296-3784',160,58,301,101,4007);

  insert into student values (
  9515,'임세현','shyun1',3,'7610122196482',to_date('1976-10-12','YYYY-MM-DD'),'02)312-9838',171,54,201,null,4001);

  insert into student values (
  9611,'일지매','onejimae',2,'7711291186223',to_date('1977-11-29','YYYY-MM-DD'),'02)6788-4861',182,72,101,null,1002);

  insert into student values (
  9612,'김진욱','samjang7',2,'7704021358674',to_date('1977-04-02','YYYY-MM-DD'),'055)488-2998',171,70,102,null,2001);

  insert into student values (
  9613,'안광훈','nonnon1',2,'7709131276431',to_date('1977-09-13','YYYY-MM-DD'),'053)736-4981',175,82,201,null,4002);

  insert into student values (
  9614,'김문호','munho',2,'7702261196365',to_date('1977-02-26','YYYY-MM-DD'),'02)6175-3945',166,51,201,null,4003);

  insert into student values (
  9615,'노정호','star123',2,'7712141254963',to_date('1977-12-14','YYYY-MM-DD'),'051)785-6984',184,62,301,null,4007);

  insert into student values (
  9711,'이윤나','prettygirl',1,'7808192157498',to_date('1978-08-19','YYYY-MM-DD'),'055)278-3649',162,48,101,null,null);

  insert into student values (
  9712,'안은수','silverwt',1,'7801051776346',to_date('1978-01-05','YYYY-MM-DD'),'02)381-5440',175,63,201,null,null);

  insert into student values (
  9713,'인영민','youngmin',1,'7808091786954',to_date('1978-08-09','YYYY-MM-DD'),'031)345-5677',173,69,201,null,null);

  insert into student values (
  9714,'김주현','kimjh',1,'7803241981987',to_date('1978-03-24','YYYY-MM-DD'),'055)423-9870',179,81,102,null,null);

  insert into student values (
  9715,'허우','wooya2702',1,'7802232116784',to_date('1978-02-23','YYYY-MM-DD'),'02)6122-2345',163,51,103,null,null);

  create table department
  ( deptno number(3) primary key ,
    dname varchar2(25) not null,
    part number(3),
    build  varchar2(20))tablespace users;

  insert into department
  values (101,'컴퓨터공학과',100,'정보관');

  insert into department
  values (102,'멀티미디어공학과',100,'멀티미디어관');

  insert into department
  values (103,'소프트웨어공학과',100,'소프트웨어관');

  insert into department
  values (201,'전자공학과',200,'전자제어관');

  insert into department
  values (202,'기계공학과',200,'기계실험관');

  insert into department
  values (203,'화학공학과',200,'화학실습관');

  insert into department
  values (301,'문헌정보학과',300,'인문관');

  insert into department
  values (100,'컴퓨터정보학부',10,null);

  insert into department
  values (200,'메카트로닉스학부',10,null);

  insert into department
  values (300,'인문사회학부',20,null);

  insert into department
  values (10,'공과대학',null,null);

  insert into department
  values (20,'인문대학',null,null);

  commit;

  -----------------------------------------------
  -- professor 테이블

  drop table professor ;
  create table professor
  (profno number(4) primary key,
  name  varchar2(10) not null,
  id  varchar2(15) not null,
  position varchar2 (15) not null,
  pay number (3) not null,
  hiredate  date not null,
  bonus number(4) ,
  deptno  number(3),
  email  varchar2(50),
  hpage  varchar2(50)) tablespace users;

  insert into professor
  values(1001,'조인형','captain','정교수',550,to_date('1980-06-23','YYYY-MM-DD'),100,101,'captain@abc.net','http://www.abc.net');

  insert into professor
  values(1002,'박승곤','sweety','조교수',380,to_date('1987-01-30','YYYY-MM-DD'),60,101,'sweety@abc.net','http://www.abc.net');

  insert into professor
  values (1003,'송도권','powerman','전임강사',270,to_date('1998-03-22','YYYY-MM-DD'),null,101,'pman@power.com','http://www.power.com');

  insert into professor
  values (2001,'양선희','lamb1','전임강사',250,to_date('2001-09-01','YYYY-MM-DD'),null,102,'lamb1@hamail.net',null);

  insert into professor
  values (2002,'김영조','number1','조교수',350,to_date('1985-11-30','YYYY-MM-DD'),80,102,'number1@naver.com','http://num1.naver.com');

  insert into professor
  values (2003,'주승재','bluedragon','정교수',490,to_date('1982-04-29','YYYY-MM-DD'),90,102,'bdragon@naver.com',null);

  insert into professor
  values (3001,'김도형','angel1004','정교수',530,to_date('1981-10-23','YYYY-MM-DD'),110,103,'angel1004@hanmir.com',null);

  insert into professor
  values (3002,'나한열','naone10','조교수',330,to_date('1997-07-01','YYYY-MM-DD'),50,103,'naone10@empal.com',null);

  insert into professor
  values (3003,'김현정','only-u','전임강사',290,to_date('2002-02-24','YYYY-MM-DD'),null,103,'only_u@abc.com',null);

  insert into professor
  values (4001,'심슨','simson','정교수',570,to_date('1981-10-23','YYYY-MM-DD'),130,201,'chebin@daum.net',null);

  insert into professor
  values (4002,'최슬기','gogogo','조교수',330,to_date('2009-08-30','YYYY-MM-DD'),null,201,'gogogo@def.com',null);

  insert into professor
  values (4003,'박원범','mypride','조교수',310,to_date('1999-12-01','YYYY-MM-DD'),50,202,'mypride@hanmail.net',null);

  insert into professor
  values (4004,'차범철','ironman','전임강사',260,to_date('2009-01-28','YYYY-MM-DD'),null,202,'ironman@naver.com',null);

  insert into professor
  values (4005,'바비','standkang','정교수',500,to_date('1985-09-18','YYYY-MM-DD'),80,203,'standkang@naver.com',null);

  insert into professor
  values (4006,'전민','napeople','전임강사',220,to_date('2010-06-28','YYYY-MM-DD'),null,301,'napeople@jass.com',null);

  insert into professor
  values (4007,'허은','silver-her','조교수',290,to_date('2001-05-23','YYYY-MM-DD'),30,301,'silver-her@daum.net',null);

  select * from student;
  select * from department;
  select * from professor;
  select * from emp;

  -- 사원테이블을 기본테이블로, 부서별 최대급여와 최소급여를 출력하는 뷰를 SAL_VIEW란 이름으로 작성
  create or replace view sal_view as select d.dname, max(sal) max_sal, min(sal) min_sal from emp e, dept d where e.deptno = d.deptno group by d.dname;
  select * from sal_view;
  -- 인라인 뷰를 사용하여 급여를 많이 받는 순서대로 3명만 출력하시오
  select rownum ranking, empno, ename, sal from (select rownum, empno, ename, sal from emp order by sal desc) where rownum<=3;
  -- professor테이블과 department테이블을 조인하여 교수번호와 교수이름, 소속 학과이름을 조회하는 view를 생성하시오. view 이름은 v_prof_dept2로
  create or replace view v_prof_dept2 as select profno, name, dname from professor, department;
  select * from v_prof_dept2;
  -- inline view를 사용하여 student테이블과 departmant테이블을 사용하여 학과별로 학생들의 최대키와 최대 몸무게, 학과 이름을 출력하세요.
  select * from (select d.dname, max(s.height), max(s.weight) from student s, department d where s.deptno1 = d.deptno group by d.dname);
  -- student테이블과 departmemt테이블을 사용하여 학과 이름, 학과별 최대키, 학과별로 가장 키가 큰 학생들의 이름과 키를 inline view를 사용하여 출력하세요.
  select * from (select d.dname, s.name, max(s.height) from student s, department d where s.deptno1 = d.deptno group by d.dname, s.name);
  -- student테이블에서 학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름 키, 해당 학년의 평균키를 출력하되 inline view를 사용해서 출력하세요.(학년 컬럼으로 오름차순 정렬해서 출력하세요)
  select s.grade, s.name, s.height, g.avg_height from student s, (select grade, avg(height) avg_height from student group by grade) g where s.grade = g.grade and s.height>=g.avg_height order by s.grade asc;
  ```

---

### 3. memo

- [javaScript | 값 입력 후 엔터키 눌렀을 때 이벤트](https://charliecharlie.tistory.com/233)
- [javaScript | keyCode 값으로 엔터여부 판단 처리](https://haenny.tistory.com/80)
- [javaScript | 로그인에 쓰이는 함수](https://velog.io/@hana78786/%EB%A1%9C%EA%B7%B8%EC%9D%B8%EC%97%90-%EC%93%B0%EC%9D%B4%EB%8A%94-%ED%95%A8%EC%88%98)
- [javaScript | == vs ===](https://steemit.com/kr-dev/@cheonmr/js-operator)
- [oracle | view 생성/삭제/수정](https://butgrin.tistory.com/22)
