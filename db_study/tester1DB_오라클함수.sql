--오라클 주요 함수
--소수점없애기
select round(85/3) from dual;
--절대값
select abs(-90) from dual;
--mod = 나머지, trunc = 특정 자리수 잘라내기 
select abs(-90), trunc(34.5678,2), mod(90,8) from dual;
--upper = 대문자로 변환, lower = 소문자로 변환, initcap = 첫글자만 대문자, 나머지 소문자
select 'Welcome to Oracle', upper('Welcome to Oracle'), lower('Welcome to Oracle'), initCap('WELCOME TO ORACLE') from dual;

select length('홍길동') from dual; --문자의 길이 출력(한글1바이트)
select lengthb('홍길동') from dual; --'홍' -3바이트의 문자 바이트수 출력(한글2바이트)

select substr('Welcome To Oracle', 4, 3) from dual; --4번째부터 3글자
select 
substr('Welcome To Oracle', 9, 1) ||
substr('Welcome To Oracle', 12, 1)|| 
substr('Welcome To Oracle', 8, 1) from dual;

select * from student;

select stu_email from student where stu_name='문종헌';

select substr(stu_email,5,1) from student where stu_name='문종헌';

select substr(stu_id,2,2) 일련번호 from student;
select instr('데이터베이스', '이') from dual;
select instr('학생아이디 학생아이디', '아', 1, 2) from dual;
select instr('없는글자는 어떻게 나오나?', '박')from dual;
select * from student;
select instr(stu_id, 116), stu_id from student;

select substr(stu_email,1, instr(stu_email, '@',1,1)-1) from student;
--lpad, rpad 특정기호로 채운다.
select lpad('홍길동', 20,'#') from dual;
--형변환 함수
select sysdate from dual;
select sysdate, to_char(sysdate, 'yyyy/mm/dd, am hh:mi:ss') from dual;
-- L=통화기호,9 = 자리수(자리수가 맞지 않아도 채우지 않는다.)
select to_char(123000, 'L999,999') from dual;
-- 0 = 자리수가 맞지 않을 경우 0으로 채운다.
select to_char(123000, 'L0000,000') from dual;
select to_char(12.3456, 'L00,000.00000') from dual;
select * from dual;

select * from emp;
--to_date = 날짜형식으로 형변환
insert into emp values(1011, '박수민', null, 1003, to_date(230329,'yymmdd'), 850, 0, 10);
insert into emp values(1012, '차영주', null, 1005, to_date('220515','yymmdd'), 740, 0 , 10);
--입사일 4월만
select * from emp where hiredate like '%/04/%';
--07년도에 입사한 정보
select * from emp where to_char(hiredate, 'YY')='07';
--매니저사번을 날짜로
select mgr, to_date(mgr,'mm/dd') from emp where mgr !=0;
--문자열을 숫자로
select to_number('070310', '999999')+5000 from dual;
--날짜->문자->숫자
select to_number(to_char(hiredate,'yyyymmdd'),'99999999')from emp;