CREATE TABLE TBL_VOTE_202005( -- ��ǥ�̷����̺� ����
    V_JUMIN CHAR(13) NOT NULL PRIMARY KEY, -- �ֹι�ȣ
    V_NAME VARCHAR2(20), -- ����
    M_NO CHAR(1), -- �ĺ���ȣ
    V_TIME CHAR(4), -- ��ǥ�ð�
    V_AREA CHAR(20), -- ��ǥ���
    V_CONFIRM CHAR(1) -- ������Ȯ��
);

CREATE TABLE TBL_MEMBER_202005( -- �ĺ������̺� ����
    M_NO CHAR(1) NOT NULL PRIMARY KEY, -- �ĺ���ȣ
    M_NAME VARCHAR2(20), -- ����
    P_CODE CHAR(2), -- �Ҽ�����
    P_SCHOOL CHAR(1), -- �����з�
    M_JUMIN CHAR(13), -- �ֹι�ȣ
    M_CITY VARCHAR2(20) -- ������
);

CREATE TABLE TBL_PARTY_202005( -- �����ڵ����̺� ����
    P_CODE CHAR(2) NOT NULL PRIMARY KEY, -- �����ڵ�
    P_NAME VARCHAR2(20), -- ��Ī
    P_INDATE DATE, -- ��Ͽ�����
    P_READER VARCHAR2(20), -- ��ǥ��
    P_TEL1 CHAR(3), -- ��ȭ��ȣ1
    P_TEL2 CHAR(4), -- ��ȭ��ȣ2
    P_TEL3 CHAR(4) -- ��ȭ��ȣ3
);

INSERT INTO TBL_VOTE_202005 VALUES ('99010110001', '������', '1', '0930', '��1��ǥ��', 'N');
INSERT INTO TBL_VOTE_202005 VALUES ('89010120002', '������', '2', '0930', '��1��ǥ��', 'N');
INSERT INTO TBL_VOTE_202005 VALUES ('69010110003', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('59010120004', 'ȫ����', '4', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010110005', '������', '5', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('89010120006', '������', '1', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('59010110007', '������', '1', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('49010120008', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010110009', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('89010120010', '������', '4', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('99010110011', '������', '5', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010120012', '������', '1', '1130', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('69010110013', '������', '4', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('89010110014', '������', '2', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('99010110015', '������', '3', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010110016', '������', '2', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('89010110017', '������', '4', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('99010110018', '������', '2', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('99010110019', '������', '4', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010110020', 'Ȳ����', '5', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('69010110021', '������', '3', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('79010110022', '������', '3', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('99010110023', '������', '1', '1130', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES ('59010110024', '������', '3', '1130', '��2��ǥ��', 'Y');

INSERT INTO TBL_MEMBER_202005 VALUES ('1' ,'���ĺ�', 'P1', '1', '6603011999991', '����ȭ��');
INSERT INTO TBL_MEMBER_202005 VALUES ('2' ,'���ĺ�', 'P2', '3', '5503011999992', '�ε鷡��');
INSERT INTO TBL_MEMBER_202005 VALUES ('3' ,'���ĺ�', 'P3', '2', '7703011999993', '���Ȳɵ�');
INSERT INTO TBL_MEMBER_202005 VALUES ('4' ,'���ĺ�', 'P4', '2', '8803011999994', '���޷���');
INSERT INTO TBL_MEMBER_202005 VALUES ('5' ,'���ĺ�', 'P5', '3', '9903011999995', '��������');

INSERT INTO TBL_PARTY_202005 VALUES ('P1', 'A����', '2010-01-01', '����ǥ', '02', '1111', '0001');
INSERT INTO TBL_PARTY_202005 VALUES ('P2', 'B����', '2010-02-01', '���ǥ', '02', '1111', '0002');
INSERT INTO TBL_PARTY_202005 VALUES ('P3', 'C����', '2010-03-01', '���ǥ', '02', '1111', '0003');
INSERT INTO TBL_PARTY_202005 VALUES ('P4', 'D����', '2010-04-01', '����ǥ', '02', '1111', '0004');
INSERT INTO TBL_PARTY_202005 VALUES ('P5', 'E����', '2010-05-01', '�Ӵ�ǥ', '02', '1111', '0005');

SELECT * FROM TBL_VOTE_202005;
SELECT * FROM TBL_MEMBER_202005;
SELECT * FROM TBL_PARTY_202005;

COMMIT;

SELECT m.M_NO, m.M_NAME, p.P_NAME, m.P_SCHOOL, m.M_JUMIN,
m.M_CITY, p.P_TEL1, p.P_TEL2, 
p.P_TEL3 FROM TBL_MEMBER_202005 m, TBL_PARTY_202005 p
WHERE m.P_CODE = p.P_CODE;

-- ������Ȯ���� Y�̸鼭, �� �ĺ���ȣ �� �ĺ��̸�, Y�� �� ī����1

SELECT m.M_NO, m.M_NAME, COUNT(CASE WHEN v.V_CONFIRM = 'Y' THEN 1 END) V_COUNT FROM TBL_VOTE_202005 v, TBL_MEMBER_202005 m
WHERE v.M_NO = m.M_NO AND v.V_CONFIRM = 'Y' GROUP BY m.M_NO, m.M_NAME ORDER BY V_COUNT DESC;

select v.m_no, m.m_name, count(v.m_no) count
from  tbl_vote_202005 v, tbl_member_202005 m
where v.m_no=m.m_no and v.v_confirm = 'Y'
group by v.m_no,  m.m_name
order by count desc;

