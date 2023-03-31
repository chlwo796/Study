--오늘 날자를 기준으로 어제와 내일 날짜 계산하기
select to_char( sysdate -1, 'yyyy/mm/dd') 어제,
       to_char( sysdate, 'yyyy/mm/dd') 오늘,
       to_char( sysdate + 1, 'yyyy/mm/dd') 
       from dual;
-- 도서대출  대출일  오늘 반납일 14일 이후
select to_char(sysdate, 'yyyy/mm/dd') 대출일,
       to_char(sysdate + 14, 'yyyy/mm/dd') 반납일
       from dual;
-- Round
select round( to_date('2023/06/16', 'yyyy/mm/dd'), 'MM') from dual;
-- 입사일이 달의 첫날로 셋팅하기
select to_char( hiredate, 'yyyy/mm/dd') 입사일,
       to_char( trunc(hiredate, 'MONTH'), 'yyyy/mm/dd') 월급계산일,  -- 특정한 날짜를 달을 기준으로 버리기
       to_char( trunc(hiredate, 'YEAR'), 'yyyy') 입사한년도
       from emp;
-- 두날짜 사이의 간격을 구하는 Months_between 함수
-- 형식 Months_between(date1, date2) ;
-- 2023/12/31 2023/03/30 몇개월 남아 있지?
select trunc( months_between( '2023/12/31', sysdate ) ) 
       from dual;
-- 오늘날짜 - 입사일 = 몇개월
select ename,trunc( months_between( sysdate, hiredate ) ) 근무개월수
       from emp;
-- 입사일에서 5년후 날짜출력
select hiredate 입사일 , add_months( hiredate, 60 ) as "5년후"
       from emp;       
-- 해당요일의 가장 가까운 날짜를 반환하는 next_day함수
-- next_day(날짜, 요일);
-- 이번주 일요일 날짜?
select next_day( sysdate, 1 ) from dual;
-- 이번달 마지막 날짜는?
select last_day( sysdate ) from dual;
-- 입사일의 마지막 날짜는?
select last_day( hiredate) from emp;
-- NVL 함수 
-- 숫자인 경우 입력을 안하면 0으로 문자인 경우 입력을 안하여 null로 날짜인 경우 입력을 안하면 null으로 됨
--  nvl( 컬럼명, 기본값) 컬럼에 값이 있으면 컬럼값을 출력 null이면 기본값 출력
-- 삽입하기 입사일이 0인 경우 삽입하기
select * from emp;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1013, '오수정', 1005, 400, 10) ; 
-- 수정하기 1003을 comm을 0으로 sale-100 변경하기
update emp set comm = 0 where empno=1003;
update emp set sale=sale-100  where empno=1003;
-- job null인 경우 수습사원
select job, nvl( job, '수습사원') from emp;
-- update문을 이용해서 job null인 경우 수습사원이라고 변경하기
update emp set job = nvl( job, '수습'); 
select * from emp;
-- 입사일이 null것을 오늘 날짜로 업데이트 시키세요.
update emp set hiredate = nvl( hiredate, sysdate );
-- comm null인 경우 50으로 기본으로 업데이트 시키세요
update emp set comm = nvl( comm, 50);

create table  c3emp as select * from emp;

-- NULLIF함수는 두표현식을 비교하여 동일한 경우에는 NULL로 반환하고, 아니면 첫번째 표현식을 반환합니다.
select nullif( 'a','a' ) from dual; -- 'a','a' 동일하므로 null반환
select nullif( 'a','b' ) from dual;

-- coalesce( comm, sale, 0) 함수
-- 1) 경우  0 300 -> 0  2) 100 null -> 100 3) null 400 -> 400 4) null null -> 0
select ename, sale, comm, coalesce( comm, sale, 0) from emp;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1014, '김수정', 1005, 400, 10) ;
insert into emp( empno, ename, mgr, sale, deptno )
            values( 1015, '박수정', 1005, 600, 10) ;    
insert into emp( empno, ename, mgr, comm, deptno )
            values( 1016, '정수정', 1005, 100, 10) ;  
insert into emp( empno, ename, mgr, deptno )
            values( 1017, '홍수정', 1005, 10) ;             
select * from emp;

-- DECODE함수 switch~case문
-- 형식 decode( 표현식, 조건식1,  결과1,
--                     조건식2, 결과2,
--                     조건식3, 결과3,
--                      기본결과 ); 
select ename, deptno, decode( deptno, 10, '경리부', 20,'인사부', 30,'영업부', 40, '전산부', '미배치') 부서명
       from emp order by deptno asc;
select * from dept;
-- loc 서울-롯데타워 인천-월미도 용인-에버랜드 수원-수원성   컬럼명은 관광지
select loc, decode( loc, '서울', '롯데타워', '인천','월미도', '용인','에버랜드','수원','수원성') 관광지 from dept;
-- dept의 구조에서 컬럼 추가 컬럼명은 tourism 자료형은 varchar2(20)으로 하세요
alter table dept add tourism varchar2(20);
-- 그리고 업데이트 시키세요.
update dept set tourism = decode( loc, '서울', '롯데타워', '인천','월미도', '용인','에버랜드','수원','수원성'); 
     
-- CASE함수
-- 형식
--  case when 조건식1 then 결과1
--       when 조건식2 then 결과2
--       else 위의 조건이 모두 아닌 경우 처리할 결과n
--  end    
select * from student;

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
