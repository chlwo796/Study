-- 1) 수강 코드(cou_id)가 10이면 '자바'과정 20이면 '자바스크립트'과정 30이면 '데이터베이스'과정 40이면 '스프링'과정 이외는 '기본'과정
select cou_id,
    case when cou_id=10 then '자바'
        when cou_id=20 then '자바스크립트'
        when cou_id=30 then '데이터베이스'
        when cou_id=40 then '스프링'
        else '기본'
    end 과정명
from student;

-- 2) 이름이 '박'씨이고 나이가 25살 이상인 사람은 'A강의실로 오세요' '오'씨이고 나이가 25살 이하이면 'B강의실로 오세요'
select stu_name,
    case when (stu_name like ('박%') and age >= 25) then 'A강의실로 오세요'
        when (stu_name like ('오%') and age <= 25) then 'B강의실로 오세요'
    end 강의실
from student;

-- 3) 성별(sex)가 남자(M)이면 '남자화장실은 1층' 여자('F')이면 '여자화장실은 2,3층'으로 출력하기
select sex,
    case when (sex = 'M') then '남자화장실은 1층'
        when (sex = 'F') then '여자화장실은 2,3층'
    end 화장실
from student;

select * from student;
--1) 수강 코드(cou_id)가 10이면 '자바'과정 20이면 '자바스크립트'과정 30이면 '데이터베이스'과정 40이면 '스프링'과정 이외는 '기본'과정
select distinct cou_id,
    case when cou_id=10 then '자바'
        when cou_id=20 then '자바스크립트'
        when cou_id=30 then '데이터베이스'
        when cou_id=40 then '스프링'
        else '기본'
    end 과정명
from student order by cou_id;

--2) 이름이 '박'씨이고 나이가 25살 이상인 사람은 'A강의실로 오세요' '오'씨이고 나이가 25살 이하이면 'B강의실로 오세요'
--  다른 분들은 '집에 가셔도 됩니다'
select stu_name,
    case when (stu_name like '박%' and age >= 25) then 'A강의실로 오세요'
        when (stu_name like '오%' and age <= 25) then 'B강의실로 오세요'
        else '집에 가셔도 됩니다'
    end 강의실
from student;
--3) 성별(sex)가 남자(M)이면 '남자화장실은 1층' 여자('F')이면 '여자화장실은 2,3층'로 출력하기
select distinct sex,
    case when (sex = 'M') then '남자화장실은 1층'
         when (sex = 'F') then '여자화장실은 2,3층'
    end 화장실
from student;

-- 평균 나이보다 작은 사람의 stu_id, stu_name, age 출력
-- 1단계 평균 나이를 먼저 구한다.
select rount(avg(age)) from student;
-- 2단계 1단계 평균 나이를 조건문으로 사용
select stu_id, stu_name, age from student where age< (select round(avg(age)) from student);

select * from emp; 

-- 사원들의 전체 급여합은?
select sum(sale) from emp;
-- 그룹별로 합을 구하기
-- 부서별 급여의 합계는?
select deptno from emp group by deptno order by deptno asc;
select deptno 부서번호, sum(sale) 급여 from emp group by deptno;
-- 학년별 평균은?
-- 코스별로 나이의 평균, 최대 나이를 구하기
select cou_id, trunc(avg(age)), max(age) from student group by cou_id order by cou_id asc;
select * from emp order by deptno;
-- 매니저(mgr) 별로 멘토하는 인원수는?
select mgr, count(empno) from emp group by mgr order by mgr asc;
-- job 직위별로 급여의 평균과 보너스 평균을 구하세요
select job, avg(sale), avg(comm) from emp group by job order by job asc;
-- 첫번째 그룹, 부서별 두번째 그룹, 직위별
select deptno, job, avg(sale) from emp group by deptno, job;
-- 부서별 급여 평균이 600 이상인 부서를 출력하세요
select deptno, avg(sale) from emp group by deptno having avg(sale) >=600;

-- 사원을 제외하고 급여 총액이 800 이상인 직급별 급여 총액 구하기
select deptno, sum(sale) from emp where job !='사원' group by job having sum(sale)>800;

-- 모든 사원의 급여최고액, 최저액, 총액 및 평균 급여를 출력, 평균= 정수반올림
select max(sale) 급여최고액, min(sale) 급여최저액, sum(sale) 총액, avg(sale) 평균급여 from emp;

-- 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 출력
select job 업무유형, max(sale) 급여최고액, min(sale) 급여최저액, sum(sale) 총액, avg(sale) 평균급여 from emp group by job;
-- count(*) 함수를 이용하여 담당 업무별 사원수 출력
select job, count(*) from emp group by job;
-- 과장 수 나열
select job, count(job) from emp group by job having job='과장';
-- 급여 최고액, 급여 최저액의 차액
select max(sale)-min(sale) 차액 from emp;
-- 직급별 사원의 최저 급여 출력, 최저급여 500미만 그룹제외, 급여에 대한 내림차순
select job 직급, min(sale) 최저급여 from emp group by job, sale having min(sale) >= 500 order by sale asc;
-- 각 부서에 대해 부서번호 이름, 지역명, 사원수, 부서 내의 모든 사원의 평균 급여를 출력
select deptno, count(deptno), round(avg(sale), 2) from emp group by deptno order by deptno;
