-- DDL(데이터 정의어) : CREATE(생성), ALTER(변경), DROP(제거)

-- 테이블생성 /제거
-- STUDENT 테이블(학번(pk, 정수형), 이름(char(10), 학과(varchar2))
-- ON REPLACE = 만약 테이블이 있다면 대체한다.
CREATE TABLE STUDENT_INFO(
    SI_NUM NUMBER(4) CONSTRAINT PK_SI_NUM PRIMARY KEY,
    SI_NAME CHAR(10) NOT NULL,
    SI_DEPART_NUM VARCHAR2(100) NOT NULL
);

DESC STUDENT_INFO;

SELECT SI_NUM, SI_NAME, SI_DEPART_NUM FROM STUDENT_INFO;

CREATE TABLE DEPARTMENT_INFO(
DI_NUM CHAR(10) PRIMARY KEY,
DI_NAME VARCHAR2(100) NOT NULL,
DI_LOC VARCHAR2(100)
);

CREATE VIEW VIEW_STUDENT(V_SI_NUM, V_SI_NAME) AS SELECT SI_NUM, SI_NAME FROM STUDENT_INFO
;

SELECT V_SI_NUM, V_SI_NAME FROM VIEW_STUDENT;

DROP TABLE DEPARTMENT_INFO;
DROP TABLE STUDENT_INFO;
DROP VIEW VIEW_STUDENT;

-- 테이블 복사
CREATE TABLE EMP AS SELECT * FROM EMPLOYEES;

SELECT * FROM EMP;
-- TRUNCATE 자료는 남아있다. 구조만 남는다. ROLLBACK불가
TRUNCATE TABLE EMP;
--  ROLLBACK불가
DROP TABLE EMP;
-- 변경, 컬럼삭제
ALTER TABLE EMP DROP COLUMN LAST_NAME;

-- DML(데이터 조작어)
-- SELECT(검색), INSERT(삽입), DELETE(삭제), UPDATE(갱신, 수정)

CREATE TABLE PRO_TABLE(
    P_CODE CHAR(10) PRIMARY KEY,
    P_NAME VARCHAR2(100) NOT NULL,
    P_PRICE INTEGER NOT NULL,
    P_REGION VARCHAR2(100) NOT NULL
);

CREATE TABLE CUS_TABLE(
    C_ID CHAR(5) PRIMARY KEY,
    C_NAME VARCHAR2(100) NOT NULL,
    C_GENDER CHAR(4) NOT NULL,
    C_ADDRESS VARCHAR2(100),
    C_PHONE CHAR(20) UNIQUE
);

CREATE TABLE ORDER_INFO(
    OI_ID NUMBER PRIMARY KEY,
    OI_DATE DATE NOT NULL,
    P_CODE CHAR(10),
    C_ID CHAR(5),
    OI_AMOUNT SMALLINT DEFAULT 1,
    FOREIGN KEY (P_CODE) REFERENCES PRO_TABLE(P_CODE),
    FOREIGN KEY (C_ID) REFERENCES CUS_TABLE(C_ID)
);
-- 시퀀스 생성
CREATE SEQUENCE ORDER_SEQ -- 시퀀스명
INCREMENT BY 1 -- 증가값
START WITH 1 -- 시작
MAXVALUE 5000 -- 최대 증가 숫자
MINVALUE 1; --최소

SELECT * FROM ORDER_INFO;
-- 삽입
-- INSERT INTO 테이블명(컬럼명1, 컬럼명2, ..) VALUES (값1, 값2, ..);
-- 모든 컬럼에 자료를 넣을 경우 컬럼명 생략 가능
insert into PRO_TABLE values('ba123','바나나',2300,'필리핀');
insert into PRO_TABLE values('ap231','사과',1000,'대구');
insert into PRO_TABLE values('or321','오렌지',500,'필라델피아');
insert into PRO_TABLE values('st341','딸기',700,'논산');
insert into PRO_TABLE values('ma456','망고',1500,'베트남');
-- MYSQL에서는 자동커밋, 오라클은 COMMIT을 별도로 해주어야한다.
commit;
-- CUS_TABLE 자료 삽입
insert into CUS_TABLE values('c1','김미연','여','관악','010-123-4567');
insert into CUS_TABLE values('c2','박보검','남','송파',null);
insert into CUS_TABLE values('c3','이승기','남','동작','010-234-4567');
insert into CUS_TABLE values('c4','정애란','여','관악','010-134-4568');
insert into CUS_TABLE values('c5','윤태화','여','송파',null);
insert into CUS_TABLE values('c6','김태연','남','강남','010-125-4567');
insert into CUS_TABLE values('c7','최미경','여','강남','010-126-4567');
insert into CUS_TABLE values('c8','이미란','여','관악','010-127-4567');
insert into CUS_TABLE values('c9','박지성','남','송파','010-333-4567');
insert into CUS_TABLE values('c10','박세리','여','양천',null);
insert into CUS_TABLE values('c11','한바다','남','양천','010-444-4567');
insert into CUS_TABLE values('c12','최하늘','여','역삼','010-123-5555');
insert into CUS_TABLE values('c13','이강산','남','강남',null);
insert into CUS_TABLE values('c14','우영우','여','송파','010-155-6666');
insert into CUS_TABLE values('c15','이정재','남','역삼','010-456-4567');
commit;
-- ORDER_INFO 자료 삽입
-- 시퀀스명.NEXTVAL(자동증가), SYSDATE(오늘날짜)
insert into ORDER_INFO values(order_seq.nextval, sysdate,'ba123','c1',30);
insert into ORDER_INFO values(order_seq.nextval, sysdate,'ap231','c2',45);
insert into ORDER_INFO values(order_seq.nextval, sysdate,'or321','c3',53);
insert into ORDER_INFO values(order_seq.nextval, sysdate,'st341','c11',80);
insert into ORDER_INFO values(order_seq.nextval, sysdate,'ma456','c15',72);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-25','ba123','c1',30);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-25','ap231','c5',45);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-25','or321','c3',53);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-27','ba123','c11',80);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-27','ap231','c13',72);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-27','ba123','c4',30);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-27','ap231','c4',45);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-28','or321','c3',53);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-28','ma456','c11',80);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-28','ap231','c13',72);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-30','ba123','c1',30);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-30','ap231','c2',45);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-30','or321','c4',53);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-31','ba123','c10',80);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-31','ap231','c13',72);
insert into ORDER_INFO values(order_seq.nextval, '2023-5-31','ba123','c4',30);
insert into ORDER_INFO values(order_seq.nextval, '2023-6-01','ap231','c3',45);
insert into ORDER_INFO values(order_seq.nextval, '2023-6-02','or321','c7',53);
insert into ORDER_INFO values(order_seq.nextval, '2023-6-02','ma456','c7',80);
insert into ORDER_INFO values(order_seq.nextval, '2023-6-03','ap231','c6',72);
commit;

-- 자료 조회
SELECT * FROM CUS_TABLE;
SELECT * FROM PRO_TABLE;
SELECT * FROM ORDER_INFO;

