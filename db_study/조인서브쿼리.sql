-- 조인 종류
-- 1. 등가조인 = cross 조인 = 교집합, 양쪽 테이블에 동일한 컬럼값들만 조인
-- 2. left, right outer join, 왼쪽 및 오른쪽에 있는 테이블 레코드조인
-- 3. full outer join, 왼쪽 오른쪽 모두 테이블 레코드 조인

select * from emp, dept; -- full join
select * from emp; -- 18개 레코드
select * from dept; -- 4개 레코드
select 18*4 from dual;

select * from emp, dept where emp.deptno = dept.deptno; -- equal join

-- 김사랑의 부서명과 지역명?
select ename, dname, loc from emp, dept where emp.ename = '김사랑';
-- 지역이 인천인 사람의 사원번호와 입사일 출력
select loc, ename, empno, hiredate from emp, dept where dept.loc = '인천';

select * from user_constraints where table_name in('EMP', 'DEPT');

select emp.deptno, emp.ename, dept.dname from emp, dept where emp.deptno=dept.deptno and dept.dname in ('인사부', '경리부') order by dept.dname asc;
-- 별칭부여
select e.deptno, e.ename, d.dname from emp e, dept d
where e.deptno = d.deptno and d.dname in ('인사부', '경리부')
order by d.dname asc;

select * from emp;

-- 사원번호, 매니저 이름
-- self join
select e1.empno, e1.ename, e2.mgr, e2.ename  from emp e1, emp e2 where e1.mgr = e2.empno;

select * from student;
select * from course;

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


