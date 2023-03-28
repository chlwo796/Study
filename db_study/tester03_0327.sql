create table patient(
patient_no varchar2(30) not null,
patient_name varchar2(30),
disease_code nvarchar2(3),
patient_age number(3),
primary key (patient_no),
--�ܷ�Ű����
FOREIGN key (disease_code) REFERENCES disease(disease_code)
);

create table disease(
    disease_code nvarchar2(3),
    disease_name varchar2(30),
    disease_symptom varchar2(30),
    primary key (disease_code)
);

alter table disease modify(
disease_code nvarchar2(3) not null
);

insert into disease values ('A01', '������', '��������');
insert into disease values ('A02', '�ݷ���', '����');
insert into disease values ('A03', '�������', '�߿�');
insert into disease values ('A04', '��ƼǪ��', '�߿�');

insert into patient values('P1001', '��ö��', 'A01', 30);
insert into patient values('P1002', '�����', 'A03', 29);
insert into patient values('P1003', '�ӿ���', 'A01', 50);

create table diary(
    diary_date TIMESTAMP not null,
    memo varchar2(300),
    weather varchar2(30),
    primary key(diary_date)
);

create table schedule(
    schedule_date TIMESTAMP not null,
    schedule_hour number(2),
    to_do varchar2(300),
--�⺻Ű ���� �ܷ�Ű ����    
    FOREIGN key(schedule_date) REFERENCES diary(diary_date)
);
insert into schedule values ('2023-3-27', 11, '����͵�');

insert into diary values('2023-3-27', '�������� �ʹ� ����', '����');
insert into diary values('2023-3-28', '�Ϸ縸 ����', '�帲');
insert into diary values('2023-3-29', '���� ���� ��÷', '��');

insert into schedule values('2023-03-27', 11, '����͵�');
insert into schedule values('2023-03-29', 12, '�ڹٽ��͵�');
--���̺���ȸ
select * from diary;
select * from schedule;
--���̺����
drop table schedule;
drop table diary;