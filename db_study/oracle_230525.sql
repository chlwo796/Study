-- DDL(������ ���Ǿ�) : CREATE(����), ALTER(����), DROP(����)

-- ���̺���� /����
-- STUDENT ���̺�(�й�(pk, ������), �̸�(char(10), �а�(varchar2))
-- ON REPLACE = ���� ���̺��� �ִٸ� ��ü�Ѵ�.
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

-- ���̺� ����
CREATE TABLE EMP AS SELECT * FROM EMPLOYEES;

SELECT * FROM EMP;
-- TRUNCATE �ڷ�� �����ִ�. ������ ���´�. ROLLBACK�Ұ�
TRUNCATE TABLE EMP;
--  ROLLBACK�Ұ�
DROP TABLE EMP;
-- ����, �÷�����
ALTER TABLE EMP DROP COLUMN LAST_NAME;

-- DML(������ ���۾�)
-- SELECT(�˻�), INSERT(����), DELETE(����), UPDATE(����, ����)

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
-- ������ ����
CREATE SEQUENCE ORDER_SEQ -- ��������
INCREMENT BY 1 -- ������
START WITH 1 -- ����
MAXVALUE 5000 -- �ִ� ���� ����
MINVALUE 1; --�ּ�

SELECT * FROM ORDER_INFO;
-- ����
-- INSERT INTO ���̺��(�÷���1, �÷���2, ..) VALUES (��1, ��2, ..);
-- ��� �÷��� �ڷḦ ���� ��� �÷��� ���� ����
insert into PRO_TABLE values('ba123','�ٳ���',2300,'�ʸ���');
insert into PRO_TABLE values('ap231','���',1000,'�뱸');
insert into PRO_TABLE values('or321','������',500,'�ʶ��Ǿ�');
insert into PRO_TABLE values('st341','����',700,'���');
insert into PRO_TABLE values('ma456','����',1500,'��Ʈ��');
-- MYSQL������ �ڵ�Ŀ��, ����Ŭ�� COMMIT�� ������ ���־���Ѵ�.
commit;
-- CUS_TABLE �ڷ� ����
insert into CUS_TABLE values('c1','��̿�','��','����','010-123-4567');
insert into CUS_TABLE values('c2','�ں���','��','����',null);
insert into CUS_TABLE values('c3','�̽±�','��','����','010-234-4567');
insert into CUS_TABLE values('c4','���ֶ�','��','����','010-134-4568');
insert into CUS_TABLE values('c5','����ȭ','��','����',null);
insert into CUS_TABLE values('c6','���¿�','��','����','010-125-4567');
insert into CUS_TABLE values('c7','�ֹ̰�','��','����','010-126-4567');
insert into CUS_TABLE values('c8','�̶̹�','��','����','010-127-4567');
insert into CUS_TABLE values('c9','������','��','����','010-333-4567');
insert into CUS_TABLE values('c10','�ڼ���','��','��õ',null);
insert into CUS_TABLE values('c11','�ѹٴ�','��','��õ','010-444-4567');
insert into CUS_TABLE values('c12','���ϴ�','��','����','010-123-5555');
insert into CUS_TABLE values('c13','�̰���','��','����',null);
insert into CUS_TABLE values('c14','�쿵��','��','����','010-155-6666');
insert into CUS_TABLE values('c15','������','��','����','010-456-4567');
commit;
-- ORDER_INFO �ڷ� ����
-- ��������.NEXTVAL(�ڵ�����), SYSDATE(���ó�¥)
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

-- �ڷ� ��ȸ
SELECT * FROM CUS_TABLE;
SELECT * FROM PRO_TABLE;
SELECT * FROM ORDER_INFO;

