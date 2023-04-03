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
