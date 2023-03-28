create table patient(
patient_no varchar2(30) not null,
patient_name varchar2(30),
disease_code nvarchar2(3),
patient_age number(3),
primary key (patient_no),
--외래키설정
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

insert into disease values ('A01', '뇌졸증', '어지러움');
insert into disease values ('A02', '콜레라', '설사');
insert into disease values ('A03', '기관지염', '발열');
insert into disease values ('A04', '장티푸스', '발열');

insert into patient values('P1001', '김철수', 'A01', 30);
insert into patient values('P1002', '양길현', 'A03', 29);
insert into patient values('P1003', '임영수', 'A01', 50);

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
--기본키 없이 외래키 설정    
    FOREIGN key(schedule_date) REFERENCES diary(diary_date)
);
insert into schedule values ('2023-3-27', 11, '영어스터디');

insert into diary values('2023-3-27', '과제물이 너무 많음', '맑음');
insert into diary values('2023-3-28', '하루만 참자', '흐림');
insert into diary values('2023-3-29', '오늘 복권 당첨', '비');

insert into schedule values('2023-03-27', 11, '영어스터디');
insert into schedule values('2023-03-29', 12, '자바스터디');
--테이블조회
select * from diary;
select * from schedule;
--테이블삭제
drop table schedule;
drop table diary;