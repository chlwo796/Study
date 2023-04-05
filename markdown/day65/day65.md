2023년 4월 4일 화요일

## day65

### 1. oracle

- chap. 10 조인

  ```sql
  -- 두개 조인 해보기
  select * from student, course;

  -- cou id가 동일한 것을 조건으로 조인하기
  select * from student s, course c where s.cou_id = c.cou_id;

  -- 학번, 이름, 코스번호 코스명 선생님
  select stu_id, stu_name , s.cou_id, cou_name, tea_name from student s, course c where s.cou_id = c.cou_id;

  -- 선생님 이름 순으로 정렬하기
  select stu_id, stu_name , s.cou_id, cou_name, tea_name
      from student s, course c
      where s.cou_id = c.cou_id
      order by tea_name asc;

  --문제) 학생 나이가 가장 많은 사람이 수강한 과목은?
  -- 1단계 cou_id가 동일한 것을 조건으로 조인하기
  select * from student s, course c where s.cou_id = c.cou_id;
  -- 2단계 가장 많은 나이는?
  select max(age) from student s, course c where s.cou_id = c.cou_id;
  -- 3단계 조건을 가장 나이 많은 사람의 수강과목
  select * from student s, course c
      where s.cou_id = c.cou_id and s.age = ( select max(age) from student s, course c);

  -- 모바일 강좌를 수강하는 사람의 인원수는?
  select * from course, course;
  select * from student s, course c where s.cou_id = c.cou_id;
  select * from student s, course c
      where s.cou_id = c.cou_id and c.cou_name = '모바일';

  select count(*) 모바일수강인원 from student s, course c
      where s.cou_id = c.cou_id and c.cou_name = '모바일';
  -- 남학생이고 정윤정 선생님 과목을 수강하는 학생의 학번과, 나이, 이메일, 수강코드, 수강명을 출력하기
  select s.stu_id, s.age, s.stu_email, c.cou_id, c.cou_name from student s, course c
      where s.cou_id = c.cou_id and s.sex='M' and c.tea_name like '성%';

  -- course 테이블에 컬럼 추가하기 tea_id
  -- course 테이블 구조 보기
      desc course;
  -- 테이블의 컬럼 추가하기
      alter table course
          add tea_id number(4);
  -- 자료를 삽입하기
      select * from course;
      update course set tea_id=2001 where tea_name='성윤정';
      update course set tea_id=2002 where tea_name like '황%';
      update course set tea_id=2003 where tea_name like '_혜%';

  -- student 테이블에 컬럼 추가하기 memto_id number(4)
  desc student;
  alter table student
      add memto_id number(4);
  -- memto_id 컬럼 값 추가하기 103, 105,  111, 101, 103, 102, 102, 106, 105, 104, 104, 110, 110, 112, 112
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

  -- 문제) 해당학생의 멘토명과 멘토의 이메일, 멘토수강과목을 출력하시오
  -- 예) 문종헌 멘토는 제용석이고, 멘토이메일은 again@nate.com 멘토수강과목 : 모바일
  -- 1단계 학생의 멘토이름 검색
  select * from student s1, student s2;
  select * from student s1, student s2 where s1.memto_id = s2.stu_id;
  select s1.stu_name, s2.stu_name, s2.stu_email from student s1, student s2 where s1.memto_id = s2.stu_id;
  -- 2단계 멘토가 수강하는 과목은?
  -- self join하고 course 테이블도 조인
  select * from student s1, student s2, course c
          where s1.memto_id = s2.stu_id and s2.cou_id = c.cou_id;
  -- 원하는 컬럼 써주기
  select s1.stu_name, s2.stu_name, s2.stu_email, c.cou_name from student s1, student s2, course c
          where s1.memto_id = s2.stu_id and s2.cou_id = c.cou_id;

  select * from course;

  -- 문제2) 각 선생님들의 이름별로 수강하는 학생의학번, 이메일, 멘토의이름, 멘토이메일, 멘토성별을 검색하세요
  select * from course c, student s;
  select * from course c, student s where c.cou_id = s.cou_id;
  select * from course c, student s1, student s2;
  select * from course c, student s where c.cou_id = s1.cou_id and s1.stu_id = s2.memto_id;
  select c.tea_name, s1.stu_id, s1.stu_email, s2.stu_name, s2.stu_email, s2.sex
      from course c, student s1, student s2
      where c.cou_id = s1.cou_id and s1.stu_id = s2.memto_id
      order by c.tea_name asc;

  -- outer join
  -- 멘토가 없는 사원은?
  -- 쇼핑을 하지 않은 회원명은?
  -- 시험을 보지 않은 학생은?
  select * from emp;
  select member.ename 사원이름, manager.ename 직속상관이름
      from emp member left outer join emp manager
      on member.mgr = manager.empno;

  select member.ename 사원이름, manager.ename 직속상관이름
      from emp member right outer join emp manager
      on member.mgr = manager.empno;

  -- where member.mgr(+) = manager.empno(+); -- 지원안함 대신 where 빼면 나옴
  -- full outer join 동일 오른쪽에 있는 테이블은 모두 나오기, 왼쪽 테이블의 모두 다 나오기
  -- 서로 연결되지 않으면 모두 null 채움

  select * from student;
  -- 멘토하지 않는 학생은? 김현우
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
  insert into dept values(50, '총무부', '서울');
  insert into dept values(60, '해외부', '미주');

  -- 사원이 없는 부서명 출력
  select dname from emp e right outer join dept d on e.deptno = d.deptno where e.deptno is null;
  select d.dname from emp e, dept d where e.deptno(+) = d.deptno and e.deptno is null;

  ```

- chap. 11 서브쿼리

  ```sql
  -- 부서 테이블 생성하기

  CREATE TABLE DEPT(
  DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
  DNAME VARCHAR2(14),
  LOC VARCHAR2(13)
  );

  -- 사원 테이블 생성하기

  CREATE TABLE EMP(
  EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  MGR NUMBER(4),
  HIREDATE DATE,
  SAL NUMBER(7,2),
  COMM NUMBER(7,2),
  DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);

  -- 급여 테이블 생성하기

  CREATE TABLE SALGRADE(
  GRADE NUMBER,
  LOSAL NUMBER,
  HISAL NUMBER );

  -- 사원 테이블에 샘플 데이터 추가하기

  INSERT INTO DEPT VALUES(10, '경리부', '서울');
  INSERT INTO DEPT VALUES(20, '인사부', '인천');
  INSERT INTO DEPT VALUES(30, '영업부', '용인');
  INSERT INTO DEPT VALUES(40, '전산부', '수원');

  -- 부서 테이블에 샘플 데이터 추가하기

  INSERT INTO EMP VALUES(1001, '김사랑', '사원', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
  INSERT INTO EMP VALUES(1002, '한예슬', '대리', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250, 80, 30);
  INSERT INTO EMP VALUES(1003, '오지호', '과장', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500, 100, 30);
  INSERT INTO EMP VALUES(1004, '이병헌', '부장', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
  INSERT INTO EMP VALUES(1005, '신동협', '과장', 1005, to_date('2005-04-07','yyyy-mm-dd'), 450, 200, 30);
  INSERT INTO EMP VALUES(1006, '장동건', '부장', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
  INSERT INTO EMP VALUES(1007, '이문세', '부장', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
  INSERT INTO EMP VALUES(1008, '감우성', '차장', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500, 0, 30);
  INSERT INTO EMP VALUES(1009, '안성기', '사장', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
  INSERT INTO EMP VALUES(1010, '이병헌', '과장', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
  INSERT INTO EMP VALUES(1011, '조향기', '사원', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, NULL, 30);
  INSERT INTO EMP VALUES(1012, '강혜정', '사원', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
  INSERT INTO EMP VALUES(1013, '박중훈', '부장', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
  INSERT INTO EMP VALUES(1014, '조인성', '사원', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);

  -- 급여 테이블에 샘플 데이터 추가하기
  INSERT INTO SALGRADE VALUES (1, 700,1200);
  INSERT INTO SALGRADE VALUES (2, 1201,1400);
  INSERT INTO SALGRADE VALUES (3, 1401,2000);
  INSERT INTO SALGRADE VALUES (4, 2001,3000);
  INSERT INTO SALGRADE VALUES (5, 3001,9999);

  select * from dept;
  select * from emp;
  select * from salgrade;

  select ename, hiredate from emp e right outer join dept d on e.deptno = d.deptno where d.dname= '경리부';
  select ename, sal from emp e right outer join dept d on e.deptno = d.deptno where d.loc = '인천';
  select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno = d.deptno;
  select ename, dname from dept d left outer join emp e on d.deptno = e.deptno where e.job = '과장';
  select e1.ename, e1.job from emp e1 right outer join emp e2 on e1.mgr = e2.empno where e2.ename = '감우성';
  select e.ename from emp e right outer join dept d on e.deptno = d.deptno where d.loc in (select d.loc from emp e right outer join dept d on e.deptno = d.deptno where e.ename = '감우성');

  -- 11장 서브쿼리
  select dname from dept where deptno = (select deptno from emp where ename = '이문세');
  -- 평균 급여보다 더 많은 급여를 받는 사원 출력
  select ename, sal from emp where sal > (select avg(sal) from emp);
  -- 급여가 500을 초과하는 사원과 같은 부서에 근무하는 사원 구하기
  -- 1단계 급여가 500만원 초과하는 사원

  select * from emp where sal>=500;
  -- 2단계 해당 부서 사람들 검색
  select ename, deptno from emp where deptno in (select deptno from emp where sal>=500);
  -- 30번 부서의 최대급여보다 많은 급여를 받는 사원 출력
  select ename, sal from emp where sal>= (select max(sal) from emp where deptno = 30);
  -- 또는
  select ename, sal from emp where sal>=all(select sal from emp where deptno = 30);
  -- all (250, 500, 450, 480, 500, 280) sal>=250 and sal>=500
  select * from emp where sal>=any(select sal from emp where deptno=30);
  -- sal>=250 or sal>=500 ..
  select * from emp where sal>= some(select sal from emp where deptno = 30);
  -- sal>=250 or sal>=500 ..
  select * from emp where exists (select * from emp where deptno = 30);

  -- 테이블 생성
  create table emp02 as select * from emp where deptno in (10, 20);

  -- 테이블을 생성하는데 구조만 생성하기
  create table emp03 as select * from emp where deptno in (10000);
  select * from emp03;

  desc emp03;

  -- emp 테이블의 제약조건 보기
  select * from user_constraints where table_name in ('EMP');
  select * from user_constraints where table_name in ('EMP03');

  -- update 문에 서브쿼리
  -- 문) deptno = 20인 지역명을 deptno=40의 지역명 변경
  select * from dept;
  update dept set loc = (select loc from dept where deptno = 40) where deptno = 20;

  use tester1db;
  -- 장동건의 급여 변경
  select * from emp;
  update emp set sal = (select max(sal) from emp where job = '부장') where ename = '장동건';

  rollback;
  -- 부장에서 급여가 제일 많은 사람의 급여로 장동건 부장의 급여를 변경
  -- 수원에서 근무하는 직원중에서 제일 먼저 입사한 사람의 이름과, 입사일은?
  select ename, hiredate from emp where emp.hiredate <=all(select hiredate from emp, dept where dept.loc = '수원');

  -- 위에 조건에 만족하는 사람 삭제, 사장 제외
  delete from emp where hiredate <=all(select hiredate from emp, dept where dept.loc = '수원' and job !='사장');
  create table emp06 as select * from emp;
  drop table emp06;
  select * from dept;
  select * from emp06;
  -- 1. 영업부 모든 사원의 이름과 급여
  select ename, sal from emp where deptno = (select deptno from dept where dname = '영업부');
  -- 2. 과장 최소급여보다 많은 급여를 받는 사원의 이름과 급여와 직급 출력, 과장 제외
  select ename, sal, job from emp where sal> (select min(sal) from emp where job = '과장') and job !='과장';
  -- 3. 인천 사원 급여 100 인상
  update emp set sal=sal+100 where deptno in( select deptno from dept where loc = '인천');
  -- 4. 경리부 사원 삭제
  delete from emp06 where deptno in( select deptno from dept where dname = '경리부');
  -- 5. '이문세'와 같은 부서, 이름 부서번호 출력
  select ename, deptno from emp06 where deptno in( select deptno from emp06 where ename = '이문세')  ;
  -- 6. '이문세'의 급여와 동일하거나 더 많이 받는 사원명
  select ename from emp06 where sal>=(select sal from emp06 where ename = '이문세');
  -- 7. '이문세'와 동일한 직급을 가진 사원 출력
  select ename from emp06 where job in (select job from emp06 where ename = '이문세');
  -- 8. '인천'에서 근무하는 사원 이름, 부서번호 출력
  select ename, deptno from emp06 where deptno in (select deptno from dept where loc = '인천');
  -- 9. 직속상관 감우성 사원 이름 급여 출력
  select ename, sal from emp06 where mgr in (select empno from emp06 where ename = '감우성');
  -- 10. 부서별로 가장 급여 많이 받는 사원 정보(사원번호, 사원이름, 급여, 부서번호)
  select empno, ename, sal, deptno from emp06 where sal in (select max(sal) from emp06 group by deptno);
  ```

---

### 2. memo
