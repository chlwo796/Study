CREATE TABLE DEPT (
              DEPTNO DECIMAL(2),
              DNAME VARCHAR(14), 
              LOC VARCHAR(13), 
              CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO)
);

create TABLE EMP (    
            EMPNO DECIMAL(4),
            ENAME VARCHAR(10),
            JOB VARCHAR(9),
            MGR DECIMAL(4),
            HIREDATE DATE,  
            SAL DECIMAL(7,2), 
            COMM DECIMAL(7,2),
            DEPTNO DECIMAL(2),
            CONSTRAINT PK_EMP PRIMARY KEY (EMPNO),
            CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);

CREATE TABLE SALGRADE ( 
              GRADE number(3),   
              LOSAL SMALLINT,    
              HISAL SMALLINT  
);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,TO_DATE('17-12-1980','dd-mm-yy'),800,NULL,20);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,TO_DATE('20-2-1981','dd-mm-yy'),1600,300,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,TO_DATE('22-2-1981','dd-mm-yy'),1250,500,30);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,TO_DATE('2-4-1981','dd-mm-yy'),2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,TO_DATE('28-9-1981','dd-mm-yy'),1250,1400,30);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,TO_DATE('1-5-1981','dd-mm-yy'),2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,TO_DATE('9-6-1981','dd-mm-yy'),2450,NULL,10);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,TO_DATE('13-7-1987','dd-mm-yy')-85,3000,NULL,20);
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,TO_DATE('17-11-1981','dd-mm-yy'),5000,NULL,10);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,TO_DATE('8-9-1981','dd-mm-yy'),1500,0,30);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,TO_DATE('13-7-1987','dd-mm-yy'),1100,NULL,20);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,TO_DATE('3-12-1981','dd-mm-yy'),950,NULL,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,TO_DATE('3-12-1981','dd-mm-yy'),3000,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,TO_DATE('23-1-1982','dd-mm-yy'),1300,NULL,10);


INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;

select * from dept;
select * from emp;
select * from salgrade;

select empno, ename, sal from emp where deptno=10;

select ename, hiredate, deptno from emp where empno = 7369;

select * from emp where ename ='ALLEN';

select ename, deptno, sal from emp where hiredate ='83/01/12';

select * from emp where not job = 'MANAGER';

select * from emp where hiredate>= '81/04/02';

select ename, sal, deptno from emp where sal>=800;

select * from emp where deptno>=20;

select * from emp where ename>='K';

select * from emp where hiredate<='81/12/09';

select empno, ename from emp where deptno<=7698;

select ename, sal, deptno from emp where hiredate between '81/04/02' and '82/12/09';

select ename, job, sal from emp where sal>1600 and sal<3000;

select * from emp where empno>=7654 and empno<=7782;

select * from emp where ename between 'B%' and 'K%';

select * from emp where hiredate not like '81%';

select * from emp where job='MANAGER' or job='SALESMAN';

select ename, empno, deptno from emp where deptno not in (20,30);

select empno, ename, deptno from emp where ename like 'S%';

select * from emp where hiredate like '80%';

select * from emp where ename like '%S%';

select * from emp where ename like 'S%' and ename like '%T';
select * from emp where ename like 'S___T';

select * from emp where ename like '_A%';

select * from emp where comm is null;

select * from emp where comm is not null;

select ename, deptno, sal from emp where deptno=30 and sal>=1500;

select empno, ename, deptno from emp where ename like 'K%' or deptno=30;

select * from emp where sal>=1500 and deptno=30 and job= 'MANAGER';

select * from emp order by sal desc;

select * from emp order by deptno desc, ename asc, sal desc;

select * from emp;