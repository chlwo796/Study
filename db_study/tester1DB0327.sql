create table course(
cou_id number(4) not null,
cou_name varchar(20) null,
Tea_name varchar(20) null,
primary key(cou_id)
);
-- student 테이블생성
create table student(
stu_id number(4) not null,
stu_name varchar(20) null,
age number(4) null,
stu_email varchar2(20) null,
cou_id number(4) null,
sex char(1) default 'M',
primary key(stu_id),
--외래키 설정, course의 기본키와 연결
foreign key(cou_id) references course(cou_id)
);

--테이블에 데이터 삽입
insert into course values(10,'모바일','성윤정');
insert into course values(20,'자바','김혜경');
insert into course values(30,'윈도우','황연주');
insert into course values(40,'웹표준','전혜영');

--테이블 데이터 검색
select * from course;

INSERT INTO STUDENT VALUES(101,'문종헌', 24,'moon@nate.com',10,'M');
INSERT INTO STUDENT VALUES(102,'오한솔', 22,'five@nate.com',20,'M');
INSERT INTO STUDENT VALUES(103,'제용석', 22,'again@nate.com',20,'M');
INSERT INTO STUDENT VALUES(104,'정국철', 22,'cook@nate.com',20,'M');
INSERT INTO STUDENT VALUES(105,'박홍진', 24,'red@nate.com',10,'M');
INSERT INTO STUDENT VALUES(106,'김현우', 21,'kim@nate.com',20,'M');
INSERT INTO STUDENT VALUES(107,'박시준', 22,'season@nate.com',20,'M');
INSERT INTO STUDENT VALUES(108,'김준형', 27,'brother@nate.com',10,'M');
INSERT INTO STUDENT VALUES(109,'문혜진', 22, NULL,20,'F');
INSERT INTO STUDENT VALUES(110,'박기석', 34,'flag@nate.com',10,'M');
INSERT INTO STUDENT VALUES(111,'윤효선', 24,'od@nate.com',30,'F');
INSERT INTO STUDENT VALUES(112,'안창범', 34,'window@nate.com',30,'M');
INSERT INTO STUDENT VALUES(113,'공지훈', 28, NULL, 10,'M');
INSERT INTO STUDENT VALUES(114,'이봉림', 29,'bbong@nate.com',10,'M');
INSERT INTO STUDENT VALUES(115,'안창범', 24,'chang@nate.com',30,'M');
INSERT INTO STUDENT VALUES(116,'장희성', 34,'shine@nate.com',10,'M');

select * from student;

create table dept01(
deptno number(4),
dname varchar2(10),
loc varchar2(9)
);

--데이터변경
alter table dept01 modify(dname varchar2(30));
--컬럼추가
alter table dept01 add(etc varchar2(50));
--테이블구조보기
desc dept01;
--테이블 이름 변경하기
rename dept01 to dept02;
--테이블 레코드=로우=행 모두 삭제하기
truncate table student;

select * from student;

--테이블의 레코드와 구조를 모두 삭제하기
drop table student;
--관리자가 아닌 사용자가 다른 사용자를 만들 수 없다.
--create user tester2 identified by 1234;

create table dept( 
   deptno number(2) not null,
   dname varchar2(14),
   loc varchar2(13),
   primary key(deptno)
);
-- emp 테이블 만들기
create table emp(
   empno number(4) not null,
   ename varchar2(10),
   job varchar2(9),
   mgr number(4),
   hiredate date,
   sale number(7,2),
   comm number(7,2),
   deptno number(2) not null,
   primary key(empno),
   foreign key(deptno) references dept( deptno ) 
);
alter table dept add constraint deptno_uq unique(deptno);
--데이터삽입
INSERT INTO  dept ( deptno, dname, loc)    VALUES(10, '경리부', '서울');

INSERT INTO  dept ( deptno, dname, loc)    VALUES(20, '인사부', '인천');

INSERT INTO  dept ( deptno, dname, loc)    VALUES(30, '영업부', '용인');
-- 컬럼 
INSERT INTO  dept  VALUES(40, '전산부', '수원'); 

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1001, '김사랑', '사원', 1013, '2007/03/10',  300, 0,20);   

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1002, '한예슬', '대리', 1005, '2007/04/02',  250, 6,30);                       

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1003, '오지호', '과장', 1005, '2005/02/10',  500, 100,30);                     

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1004, '이병헌', '부장', 1008, '2003/09/02',  600, 0,20);                        

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1005, '신동엽', '과장', 1005, '2005/04/07',  450, 200,30);   

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1006, '장동건', '부장', 1008, '2004/01/08',  520, 0,20);                         

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1007, '김우성', '차장', 1008, '2005/03/08',  500, 0,30);                    

INSERT INTO  emp ( empno, ename,  job, mgr, hiredate, sale, comm, deptno )

                       VALUES (1008, '안성기', '사장', 0, '1996/04/07',  1000, 0,30);  

--데이터조회
select * from emp;
select job from emp;

--중복된 내용 1개만 출력
select distinct job from emp;