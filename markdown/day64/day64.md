2023년 4월 3일 월요일

## day64

### 1. oracle

- chap.08 insert, chap.09 constraint

  ```sql
  -- 레코드를 삽입할 때 insert문
  -- 형식 insert into 테이블명(컬럼명1, 컬럼명2 ...) values ('실제값',...);
  -- 레코드를 수정할 때 update 문
  -- 형식 update 테이블명 set 컬러명 = '실제값',... where 조건절
  select * from emp;
  -- mgr 1005인 사람의 급여를 50만원 인상
  update emp set sale = sale+50 where mgr = 1005;
  -- job이 사원 대리인 사람의 보너스
  update emp set comm = comm + 30 where job in ('사원', '대리');
  -- 입사일이 05년 이전의 사람의 급여를 100만원 인상
  update emp set sale = sale + 100 where hiredate<='05/01/01';
  -- 평균 급여보다 적게 받은 직원에 대해서 보너스 50만원 지급하세요.
  select avg(sale) from emp;
  -- 평균 급여?
  update emp set comm = comm + 50 where sale< (select avg(sale) from emp);
  select * from emp;
  -- 부서별로 제일 많이 받는 사람은 급여 100만원 삭감
  -- 1단계 부서별로 제일 많이 받는 사람은?
  select ename, deptno, max(sale) from emp group by deptno, ename;
  update emp set sale = sale-100 where sale=(select max(sale) from emp group by deptno);
  update emp set sale = sale-100 where sale in (select max(sale) from emp group by deptno);

  -- job 사장이거나 입사일 98/12/31 이전 입사인 사람의 급여 = 급여 + 평균급여 수정
  update emp set sale = sale + ( select avg(sale) from emp) where job = '사장' or hiredate<='98/12/31';
  select * from emp;
  -- job 수습인 사람들을 사원 변경하세요.
  update emp set job = '사원' where job = '과장';

  -- delete문
  create table c4emp as select * from emp;
  select * from c4emp;

  -- 급여가 1000만원 이상인 사람 삭제
  delete from c4emp where sale>=1000;
  -- mgr 1008, 1003인 사람 삭제
  delete from c4emp where mgr in (1008, 1003);
  -- 김씨, 이씨인 사람 제외하고 모두 삭제
  delete from c4emp where not ename like '김%' or not ename like '이%';
  -- 보너스가 100만원 이상인 사람 삭제
  delete from c4emp where comm>=100;
  -- deptno가 10, 20인 사람 삭제
  delete from c4emp where deptno in (10, 20);

  rollback;
  commit;
  update emp set sale = sale + 500 where job = '사장';
  rollback;
  select * from emp;
  update emp set sale = sale-500 where job = '사장';

  insert into emp ( deptno) values (80);
  desc user_constraints;
  -- 제약조건 사용 목적 : 데이터베이스를 사용할 때 데이터의 오류 방지
  -- 데이터베이스 딕셔너리를 통하여 제약조건에 대한 컬럼구조 보기
  -- 데이터베이스 딕셔너리를 통하여 제약조건의 제약조건명, 제약조건 타입, 테이블명 보기
  -- 필요한 컬럼들만 선택해서 보기
  select constraint_name, constraint_type, table_name from user_constraints;
  -- 전체 제약조건에 관련된 컬럼들 보기
  select * from user_constraints;
  -- constraint_type P-primary key, R_foreign key, U-unique, C-check 또는 not null

  -- 각 제약조건 만들기 -> 수정-> 삭제
  -- 만들기 테이블 생성할 때 제약조건을 만든다.
  drop table emp03;
  create table emp03(
  empno number(4),
  ename varchar2(10),
  job varchar2(10),
  deptno number(2)
  );
  drop table emp03;
  select  constraint_name, constraint_type, table_name search_condition from user_constraints where table_name in ('EMP03');

  create table emp03(
  empno number(4) unique,
  ename varchar2(10) unique,
  job varchar2(10),
  deptno number(2)
  );

  -- 삽입하기
  -- 정상으로 삽입하기

  insert into emp03 values (1001, '홍길동', '사장', 10);
  -- impno 없이
  insert into emp03(ename, job, deptno) values ('이순신', '부사장' , 10);
  -- ename 입력x
  insert into emp03(empno, job, deptno) values (1002, '사원', 20);
  -- unique 유효성
  insert into emp03 values(1001, '박미주', '부장', 10);
  insert into emp03 values(null, '박미주', '부장', 10);    -- null 중복가능
  insert into emp03(ename, job, deptno) values ('이순신', '부사장', 10);

  select * from emp03;
  select * from user_constraints where table_name in ('EMP03');
  -- 제약조건(constraint_name) 사용자 정의
  create table emp03(
  empno number(4) constraint emp03_empno_uk unique, -- constraint 제약조건명 제약조건
  -- 제약조건명을 만드는 방법 : 테이블명_컬럼명_제약조건명
  ename varchar2(10) constraint emp03_ename_uk unique,
  job varchar2(10) constraint emp03_job_nn not null,
  deptno number(2) constraint emp03_job_nn_uk not null unique
  );
  select * from user_constraints where table_name in ('EMP03');

  -- primary key 기본키 = not null + unique

  drop table emp03;

  create table emp03(
  empno number(4),
  ename varchar2(10),
  job varchar2(10),
  deptno number(2),
  constraint emp03_empno_pk primary key(empno)
  );
  -- 정상입력
  insert into emp03 values (1001, '최재환', '무직', 20);
  insert into emp03 values (1002, '최재남', '무직', 30);
  -- 오류입력
  insert into emp03 (enmae, job, deptno) values ('최재환', '백수', 20);
  insert into emp03 values (1001, '최재환', '무직', 30);
  -- foreign key 외래키
  -- 부모테이블 먼저 생성
  create table dept03(
  deptno number(4),
  dname varchar2(10),
  loc varchar2(10),
  constraint dept03_deptno_pk primary key(deptno)
  );
  drop table emp03;
  -- 첫번재 방법
  create table emp03(
  empno number(4),
  ename varchar2(20),
  deptno number(4) constraint emp03_deptno_nn not null
                  constraint emp03_deptno_fk references dept03(deptno),
  constraint emp03_empno_pk primary key(empno)
  );
  select * from emp03;
  -- 두번째 방법
  create table emp03(
  empno number(4),
  ename varchar2(20),
  deptno number(4) constraint emp03_deptno_nn not null,
  foreign key(deptno) references dept03(deptno)
  );
  select * from user_constraints where table_name in ('EMP03', 'DEPT03');
  insert into dept03 values(10, '경리부', '서울');
  insert into emp03 values(1001, '홍길동', 10);

  -- check 제약조건
  -- 입력되는 값을 체크하여 설정된 값 이외의 값이 들어오면 오류
  drop table emp03;
  create table emp03(
  empno number(4),
  salary number(10) check(salary between 500 and 5000), -- 제약 조건명을 명시하지 않고
  comm number(10) constraint emp03_comm_ck check( comm between 10 and 1000)
  );
  select * from user_constraints where table_name in ('EMP03');
  -- 정상입력
  insert into emp03 values(1001, 800, 20);
  -- 오류입력
  insert into emp03 values(1001, 5000, 0);
  -- 제약 만들기
  -- 제약 수정, 삭제

  -- 복합키 2개 이상 컬럼을 합쳐서 기본키로 만든 것

  drop table emp03;
  create table emp03(
      ephone number(4),
      ename varchar2(20),
      job varchar2(20),
      constraint emp03_ephone_ename_pk primary key(ephone, ename)
  );

  insert into emp03 values(3334, '홍길동', '사원');
  insert into emp03 values(3334, '이길동', '사원');
  insert into emp03 values(3344, '홍길동', '사원');
  insert into emp03 values(3334, '홍길동', '사원');

  drop table emp03;
  drop table dept03;
  create table emp03(
      empno number(4),
      ename varchar2(20),
      job varchar2(20),
      deptno number(4)
  );
  -- 제약조건 추가
  alter table emp03 add constraint emp03_empno_pk primary key(empno);

  select * from user_constraints where table_name in ('EMP03');

  -- deptno 외래키 지정
  create table dept03(
      deptno number(4),
      dname varchar2(20),
      loc varchar2(20)
  );

  alter table dept03 add constraint dept03_deptno_pk primary key(deptno);

  alter table emp03 add constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno);

  -- dname loc를 복합키로 제약조건 추가하기
  drop table dept03;
  drop table emp03;

  alter table dept03 add constraint dept03_dname_loc_pk primary key(dname, loc);
  -- dname not null로 지정하지 않으면 자동으로 null
  -- not null로 지정하지 않으면 자동으로 null
  alter table dept03 modify dname constraint dept03_dname_nn not null;

  -- ename not null로 조건 변경
  alter table emp03 modify ename constraint emp03_ename_nn not null;
  -- 제약조건 제거
  -- 1. 제약조건명으로 제거
  alter table dept03 drop constraint dept03_dname_nn;
  select * from user_constraints where table_name in('DEPT03');

  -- emp03 primary 키의 제약조건을 제거
  alter table emp03 drop primary key;
  -- primary key, foreign key, check 제약조건 추가 add constraint ~
  -- primary key, foreign key, check 제약조건 제거 drop constraint ~, drop primary key
  -- not null

  CREATE TABLE  employee(

      emp_no number(4),

      emp_name varchar2(20),

      salary  number(6),

      birthday  date );
  CREATE TABLE  prjoect(

      pro_no number(4),

      pro_content varchar2(100),

      start_date  date,

      finish_date date );
      CREATE TABLE  specialty(

      emp_no number(4),

      specialty   varchar2(20)

  );
  CREATE TABLE assign(

  emp_no   number(4),

  pro_no    number(4) );
  alter table employee add constraint employee_pk primary key(emp_no);
  alter table assign add constraint assign_employee_fk foreign key(emp_no) references employee(emp_no) ;
  alter table prjoect add constraint project_pk primary key(pro_no);
  alter table assign add constraint assign_project_fk foreign key(pro_no) references prjoect(pro_no);
  alter table specialty add constraint specialty_fk foreign key(emp_no) references employee(emp_no);
  alter table specialty add constraint specialty_pk primary key(specialty);
  alter table assign add constraint assign_pk primary key (emp_no, pro_no);

  select * from user_constraints where table_name in ('EMPLOYEE', 'PRJOECT', 'SPECIALTY','ASSIGN');

  -- cascade 종속
  -- 부모테이블의 자료를 변경하면 자식도 같이 변경이 될 수 있게 제약조건을 만들어 주는 것.
  drop table emp03;
  drop table dept03;

  create table emp03(
  empno number(4),
  ename varchar2(10)
  constraint emp03_ename_nn not null,
  job varchar2(10),
  deptno number(2),
  constraint emp03_empno_pk primary key(deptno),
  constraint emp03_job_uk unique(job),
  constraint emp03_deptno_fk foreign key(deptno) references dept03(deptno)
  );
  create table dept03(
  deptno number(2),
  dname varchar2(10),
  loc varchar2(10),
  constraint dept03_deptno primary key(deptno)
  );

  select * from user_constraints where table_name in('EMP03', 'DEPT03');
  insert into emp03 values (1000, '홍길동', '사원', 50);
  -- 부모자료 넣고 자식 자료 넣는다. or 제약조건을 임시로 비활성화(disable constraint)
  alter table emp03 disable constraint emp03_deptno_fk; --비권장사항
  -- 비활성화한 제약조건을 다시 활성화
  alter table emp03 enable constraint emp03_deptno_fk;
  delete from emp03;
  -- cascade 옵션
  alter table dept03 disable primary key cascade;
  alter table dept03 enable primary key;
  alter table emp03 enable constraint emp03_deptno_fk;
  insert into emp03 values (1000, '홍길동', '사원', 50);

  ```

- chap.10 join 서브쿼리

  ```sql
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

  ```

---

### 2. memo
