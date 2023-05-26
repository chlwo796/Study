SELECT * FROM CUS_TABLE;
SELECT * FROM PRO_TABLE;
SELECT * FROM ORDER_INFO;

-- DDL(������ ���Ǿ�) : CREATE(����), ALTER(����), DROP(����)-������ ���ֱ�, 
-- TRUNCATE(����) : ���̺� ������ �����

-- DML(������ ���۾�) : SELECT(�˻�), INSERT(����), DELETE(����), UPDATE(����, ����)
-- SELECT �÷��� .. FROM ���̺�� WHERE ����;
-- INSERT INTO ���̺��(�÷���..) VALUES(��1...);
-- DELETE FROM ���̺�� WHERE ����;
-- UPDATE ���̺�� SET ������_�÷��� = ������ �� .. WHERE ����;

-- DCL(������ �����) : GRANT(���Ѻο�), REVOKE(����ȸ��)
--             TCL -  COMMIT(�Ϸ�), ROLLBACK(�ǵ�����, �۾����), CHECKPOINT(�ǵ��ư� ��ġ)

-- CREATE ��ü ������� ��ü�� �̸�
-- �÷� = COLUMN = �Ӽ� = ATTRIBUTE = ITEM = �׸� = �ʵ�
-- �� = ROW = ���ڵ� = Ʃ��
-- ���̺� = �����̼�
-- CREATE TABLE ���̺��(�÷��� Ÿ�� �������� ..);
-- CREATE VIEW ���(�÷��� .. ) AS ( SELECT ��);
-- ALTER USER ����ڸ� IDENTIFIED BY ��й�ȣ; -- ������� ��й�ȣ ����
-- ALTER TABLE ���̺�� ADD �÷��� ������Ÿ��; -- �� �߰�
-- ALTER TABLE ���̺�� MODIFY �÷��� �ڷ���(����); -- ���� �ڷ����̳� ���̸� ����
-- ALTER TABLE ���̺�� DROP COLUMN �÷���; -- �� ����
-- ALTER TABLE ���̺�� ADD CONSTRAINT �������Ǹ� PRIMARY KEY(�÷���);
-- ALTER TABLE ���̺�� ADD CONSTRAINT �ܷ�Ű�������Ǹ� FOREIGN KEY(�÷���) REFERENCES �����Ǵ����̺��(�÷���);

-- DML ��
-- ���̺���, ����� PK �� ���������� ������� �ʴ´�.
CREATE TABLE ORDER_INFO_COPY AS SELECT * FROM ORDER_INFO;

SELECT * FROM ORDER_INFO_COPY;

-- ����1) ORDER_INFO_COPY ���̺��� OI_AMOUNT�� 55�̻��� �ڷ���� OI_DATE, C_ID(�����̵�), OI_AMOUNT �˻�
SELECT OI_DATE AS �ֹ�����, C_ID AS "�� ���̵�", OI_AMOUNT "�ֹ�����" FROM ORDER_INFO_COPY WHERE OI_AMOUNT>=55;

-- ����2) ORDER_INFO_COPY P_CODE ba123 �Ǵ� or321 �̸鼭 C_ID c1 �Ǵ� c3�ΰ��� �˻�
-- �ֹ����̺��� c1,c3�� ���̵� ���� ����� �ٳ����� �������� �ֹ��� ������ �˻�

SELECT OI_ID, OI_DATE, P_CODE, C_ID, OI_AMOUNT FROM ORDER_INFO_COPY WHERE (P_CODE = 'ba123' or P_CODE='or321') and
(C_ID = 'c1' or C_ID = 'c3');

-- ����3) CUS_TABLE���� ��ȭ��ȣ�� ���� ���� C_ID, C_NAME �˻�
-- IS NULL = �ΰ��� ��, IS NOT NULL = NULL�� �ƴ� ��
SELECT C_ID AS �����̵�, C_NAME AS ���̸� FROM CUS_TABLE WHERE C_PHONE IS NULL;

-- ����4) ORDER_INFO_COPY ���̺��� �ֹ������� 50 �̻��� ������ P_CODE, C_ID �˻��ϵ�
-- C_ID �ߺ��� ��� �ϳ��� ǥ��
SELECT P_CODE AS ��ǰ�ڵ�, C_ID AS ���� FROM ORDER_INFO_COPY WHERE OI_AMOUNT<=50;

-- ����5) ORDER_INFO_COPY ���̺��� �ֹ������� 50�̻� 70������ �ڷ� �˻�
SELECT OI_ID, OI_DATE, P_CODE, C_ID, OI_AMOUNT FROM ORDER_INFO_COPY WHERE OI_AMOUNT>=50 AND OI_AMOUNT<=70;
-- �̻� ������ �ڷ���� ��� BETWEEN�� ������ ���
SELECT OI_ID, OI_DATE, P_CODE, C_ID, OI_AMOUNT FROM ORDER_INFO_COPY WHERE OI_AMOUNT BETWEEN 50 AND 70;

-- ����6) CUS_TABLE ���̺��� '��'�� ���� ���� ������� C_NAME�� C_PHONE �˻�
-- ��ġ����(���ϵ�ī��) = %(��繮��), _(�ѱ��ڸ�)
-- LIKE '����%' = �������� �����ϴ� ��� ����
-- LIKE '%��' = ������ ���ڰ� ������ ��
-- LIKE '%ȭ%' = ���� �߿� ȭ�� �� ��
-- LIKE '_��' = ù���� �ƹ��ų�, �� 2������ �ڱ��ڰ� ���ΰ�
SELECT C_NAME, C_PHONE FROM CUS_TABLE WHERE C_NAME LIKE '��%';

DESC PRO_TABLE;
-- ����7) PRO_TABLE P_CODE = 'wa567', P_NAME = '����', P_PRICE = 3000, P_REGION = '���'
INSERT INTO PRO_TABLE (P_CODE, P_NAME, P_PRICE, P_REGION) VALUES ('wa567', '����', 3000, '���');

SELECT P_CODE, P_NAME, P_PRICE, P_REGION FROM PRO_TABLE;

-- ����8) ORDER_INFO_COPY OI_AMOUNT >= 70, ��� 5���ϱ�
UPDATE ORDER_INFO_COPY SET OI_AMOUNT = OI_AMOUNT+5  WHERE OI_AMOUNT>=70;

-- ����9) ORDER_INFO_COPY C_ID = 'c1' �� �ڷ���� OI_AMOUNT 3���� ����
UPDATE ORDER_INFO_COPY SET OI_AMOUNT = OI_AMOUNT-5 WHERE C_ID = 'c1';

-- ����10) ORDER_INFO_COPY OI_AMOUNT 70 �̻� �ڷ� ��� ����
DELETE FROM ORDER_INFO_COPY WHERE OI_AMOUNT >= 70;

-- ����11) ORDER_INFO_COPY ���̺��� C_ID���� OI_AMOUNT �հ�, ���, �ִ�, �ּ�, �����˻�
-- �����Լ�(=�׷��Լ�) = WHERE������ �׷��Լ� ���Ұ�
-- SUM(�÷���) = �հ�
-- AVG(�÷���) = ���
-- MAX(�÷���) = �ִ밪
-- MIN(�÷���) = �ּҰ�
-- COUNT(*) = NULL�� ������ ����
-- COUNT(�÷���) = NULL�� ������ ����
-- ~~�� = GROUP
-- GROUP BY = �׷����� �÷���
-- HAVING = �׷����� ����
-- ORDER BY ������ �ɷ��� ASC �Ǵ� DESC
-- ASC = ��������, DESC = ��������
SELECT SUM(OI_AMOUNT), AVG(OI_AMOUNT), MAX(OI_AMOUNT), MIN(OI_AMOUNT), COUNT(OI_AMOUNT)
FROM ORDER_INFO_COPY GROUP BY C_ID;

-- ���� 12) ORDER_INFO_COPY ���̺��� OI_AMOUNT�� 30 �̻��� �ڷ���� ã�Ƽ� �� �ڷῡ��
-- C_ID�� 'c1', 'c3', 'c4'�� ������ ���� OI_AMOUNT�� �հ� �˻�

SELECT C_ID AS ����, SUM(OI_AMOUNT) AS �հ�
FROM ORDER_INFO_COPY 
WHERE OI_AMOUNT>=30 -- ��ü���� ����
GROUP BY C_ID HAVING C_ID IN('c1', 'c3', 'c4');

SELECT * FROM PRO_TABLE;
SELECT * FROM ORDER_INFO_COPY;

DESC CUS_TABLE;
DESC PRO_TABLE;
DESC ORDER_INFO_COPY;
-- ���� 13) ORDER_INFO_COPY ���̺� PAYMENT��� �÷� �߰�, Ÿ���� ������
ALTER TABLE ORDER_INFO_COPY ADD PAYMENT NUMBER(38);

-- ���� 14) ORDER_INFO_COPY ���̺� OI_ID�� PRIMARY KEY �������Ǽ���, 'PK_OI_ID'
ALTER TABLE ORDER_INFO_COPY ADD CONSTRAINT PK_OI_ID PRIMARY KEY (OI_ID);

-- ���� 15) ORDER_INFO_COPY ���̺��� P_CODE �� ����
ALTER TABLE ORDER_INFO_COPY DROP COLUMN P_CODE;

-- ���� 16) ORDER_INFO_COPY ���̺��� C_ID �ܷ�Ű �������� ����
-- �������Ǹ� 'FK_CUSID'
-- �������̺�� ����Ű = CUS_TABLE�� C_ID

ALTER TABLE ORDER_INFO_COPY ADD CONSTRAINT FK_C_ID FOREIGN KEY (C_ID)
REFERENCES CUS_TABLE(C_ID);

-- ���� 17) ORDER_INFO_COPY ���̺� ����
DROP TABLE ORDER_INFO_COPY;

-- ���� 18) CUS_TABLE ���̺� ���� CUS_TABLE_COPY

CREATE TABLE CUS_TABLE_COPY AS SELECT * FROM CUS_TABLE;

-- ���� 19) CUS_TABLE_COPY ���̺��� ������ ���� ���� ���� ����(TRUNCATE)
TRUNCATE TABLE CUS_TABLE_COPY;

SELECT * FROM CUS_TABLE_COPY;

DROP TABLE CUS_TABLE_COPY;

-- ���� 20) MEMBER ���̺� ����
CREATE TABLE MEMBER(
    M_ID NUMBER PRIMARY KEY,
    M_NAME VARCHAR(10) NOT NULL,
    M_AGE DATE NULL,
    M_GENDER VARCHAR(4) NOT NULL,
    M_EMAIL VARCHAR(50) UNIQUE,
    M_JOINDATE DATE,
    M_SUB_COUNT NUMBER
);
-- ���� 21) M_ID_SEQ ������ ����
CREATE SEQUENCE M_ID_SEQ
INCREMENT BY 1
START WITH 1
MAXVALUE 5000
MINVALUE 1;
-- ���� 22) MEMBER ���̺� ������ ����
-- ȸ���� = ȫ�浿, ����
-- ȸ���� ������� = 1995-05-30, 2000-03-06
-- ȸ���� ���� = ��, ��
-- ȸ���̸��� = hong@hong.com, null
-- ȸ�������� = 2023-5-23(���ó�¥)
-- �������� �� = 1

INSERT INTO MEMBER (M_ID, M_NAME, M_AGE, M_GENDER,
M_EMAIL, M_JOINDATE, M_SUB_COUNT) VALUES
(M_ID_SEQ.NEXTVAL, 'ȫ�浿', '1995-05-30', '��', 'hong@hong.com',
sysdate, 1);

INSERT INTO MEMBER (M_ID, M_NAME, M_AGE, M_GENDER,
M_EMAIL, M_JOINDATE, M_SUB_COUNT) VALUES 
(M_ID_SEQ.NEXTVAL,'����', '2000-03-06', '��', null,
'2023-05-23', 1);

-- ���� 23) COURSES ���̺� ����
CREATE TABLE COURSES(
C_ID NUMBER PRIMARY KEY,
C_SUBJECT VARCHAR(50) NOT NULL,
M_ID NUMBER,
C_COURSE_DATE DATE NOT NULL,
FOREIGN KEY (M_ID) REFERENCES MEMBER(M_ID)
);

SELECT * FROM CUS_TABLE;
SELECT * FROM PRO_TABLE;
SELECT * FROM ORDER_INFO;
-- ���� 24) PRO_TABLE�� ORDER_INFO ���̺��� �̿��Ͽ� ���� ���ǿ� �˸°� �˻�
-- OI_AMOUNT�� OI_AMOUNT ��ü ��� �̻��� �ڷḸ �˻�
SELECT * FROM ORDER_INFO WHERE OI_AMOUNT>=(SELECT AVG(OI_AMOUNT) FROM ORDER_INFO);
-- ���� 25) PRO_TABLE�� ORDER_INFO ���̺��� �̿��Ͽ� ������ �˻�
-- OI_DATE, P_NAME, C_ID, �ݾ�(OI_AMOUNT * P_PRICE)
-- C_ID�� c1, c3, c4 ���ڷḸ �˻�
SELECT O.OI_DATE ������, P.P_NAME ��ǰ��, O.C_ID �����̵�, (O.OI_AMOUNT * P.P_PRICE) �ݾ�
FROM ORDER_INFO O, PRO_TABLE P WHERE O.P_CODE = P.P_CODE AND O.C_ID IN ('c1', 'c3', 'c4');

-- ���� 25) JOINȰ��

SELECT O.OI_DATE �ֹ���, P.P_NAME ��ǰ��, O.C_ID �����̵�, (O.OI_AMOUNT * P.P_PRICE) �ݾ�
FROM PRO_TABLE P INNER JOIN ORDER_INFO O ON P.P_CODE = O.P_CODE
WHERE C_ID IN('c1', 'c3', 'c4');

-- ���� 26) PRO_TABLE�� ORDER_INFO, CUS_TABLE �˻�
-- �ֹ�����(OI_AMOUNT)�� 40 �̻��� �ڷḦ �������
-- OI_DATE, P_NAME, C_NAME, OI_AMOUNT �˻�
SELECT O.OI_DATE, P.P_NAME, C.C_NAME, O.OI_AMOUNT FROM ORDER_INFO O, PRO_TABLE P,
CUS_TABLE C WHERE O.OI_AMOUNT>=40 AND P.P_CODE = O.P_CODE AND C.C_ID = O.C_ID;

-- ���� 26) JOINȰ��
SELECT O.OI_DATE, P.P_NAME, C.C_NAME, O.OI_AMOUNT FROM PRO_TABLE P
INNER JOIN ORDER_INFO O
ON P.P_CODE = O.P_CODE
INNER JOIN CUS_TABLE C
ON O.C_ID = C.C_ID
WHERE O.OI_AMOUNT>=40;
-- ���� 27) CUS_TABLE ORDER_INFO
-- �� ���� �ֹ��� ���� ���� ���� C_ID, C_NAME
-- ������!!!MINUS
SELECT C_ID, C_NAME FROM CUS_TABLE MINUS
SELECT C_ID, C_NAME FROM CUS_TABLE WHERE C_ID
IN (SELECT C_ID FROM ORDER_INFO);
-- NOT EXISTS Ȱ��(��������)
select c_id, c_name
from cus_table
where not exists (select * from order_info where cus_table.c_id = order_info.c_id);

ALTER TABLE MEMBER ADD M_SUB_COUNT NUMBER;
ALTER TABLE MEMBER MODIFY M_AGE DATE;
ALTER TABLE MEMBER ADD CONSTRAINT M_SUB_COUNT_CHK CHECK(M_SUB_COUNT<=3);
SELECT * FROM MEMBER;
