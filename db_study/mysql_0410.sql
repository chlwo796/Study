create user 'yes_spring_mvc_user'@'%' identified by '1234';
create user 'test01'@'%' identified by '1234';
GRANT EXECUTE, SELECT, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `yes_spring_mvc`.* TO 'yes_spring_mvc_user'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

insert into book(title, categbookory, price) values('제목1','컴퓨터1', 20000);

select * from book;

GRANT EXECUTE, SELECT, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `test`.* TO 'test01'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

create user 'zerock'@'%' identified by '1234';

GRANT EXECUTE, SELECT, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `book_ex`.* TO 'zerock'@'%' WITH GRANT OPTION;

select * from board;

create user 'test01'@'%' identified by '1234';
create user 'sbb' identified by '1234';

GRANT ALL PRIVILEGES ON *.* TO 'sbb' WITH GRANT OPTION;
FLUSH PRIVILEGES;

GRANT EXECUTE, SELECT, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `sbb`.* TO 'sbb' WITH GRANT OPTION;
show databases;

create database nothing;

create table board(
	boa_num int auto_increment primary key,
    boa_title varchar(4000) not null
);

insert into board(boa_title) values('asdbc');

drop table board;

create table board_info(
bi_num int not null auto_increment primary key,
bi_title varchar(1000) not null,
bi_content text not null,
bi_writer varchar(100) not null,
bi_cnt int default 0,
bi_date datetime default now()
);

select date_format(now(), '%Y%m%d'), date_format(now(), '%h%i%s');

select bi_num, bi_title, bi_content, bi_writer, bi_cnt, bi_date from board_info;

insert into board_info (bi_title, bi_content, bi_writer) values ('아무거나', '내용 하하하하', 'RION');

insert into board_info (bi_title, bi_content, bi_writer) values ('다음', '제목뭐야', 'RION'), ('그다음', '제목', 'RION'), ('또다음', '또제목', 'RION');

DESC USER_INFO;

SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO;

SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO WHERE UI_NAME LIKE '%최%' AND UI_ID LIKE '%300%';

UPDATE USER_INFO SET UI_NUM = @count :=@count+1;

CREATE TABLE EMP_SALARY(
ID VARCHAR(10) PRIMARY KEY,
NAME VARCHAR(30) NOT NULL,
PAY INT NOT NULL
);

INSERT INTO EMP_SALARY(ID, NAME, PAY) VALUES ('dragon', '홍길동', 1500000),
('sky', '박문수', 2000000),
('blue', '장영실', 2500000);

SELECT ID, NAME, PAY FROM EMP_SALARY;

CREATE TABLE MEMBER_INFO(
MI_NUM INT PRIMARY KEY NOT NULL auto_increment,
MI_ID VARCHAR(20) UNIQUE NOT NULL,
MI_PWD VARCHAR(20) NOT NULL,
MI_NAME VARCHAR(20) NOT NULL,
MI_PHONE CHAR(14) NOT NULL,
MI_ADDRESS VARCHAR(400)NOT NULL,
MI_EMAIL VARCHAR(30) NOT NULL,
MI_CREDATE DATETIME DEFAULT NOW() NOT NULL
);

CREATE TABLE PRODUCT_INFO(
PI_NUM INT PRIMARY KEY NOT NULL auto_increment,
PI_NAME VARCHAR(100) NOT NULL,
PI_TYPE VARCHAR(20) NOT NULL,
PI_PRICE INT NOT NULL
);

CREATE TABLE CART_INFO(
CI_NUM INT PRIMARY KEY NOT NULL auto_increment,
PI_NUM INT NOT NULL,
MI_NUM INT NOT NULL,
foreign key (PI_NUM) references PRODUCT_INFO(PI_NUM),
FOREIGN KEY (MI_NUM) REFERENCES MEMBER_INFO(MI_NUM)
);
INSERT INTO MEMBER_INFO(MI_ID, MI_PWD, MI_NAME, MI_PHONE, MI_ADDRESS, MI_EMAIL) VALUES ('chlwo796', '1234', '최재환', '010-4116-0586', '경기도 하남시', 'chlwo796@gmail.com');
SELECT MI_NUM, MI_ID, MI_PWD, MI_NAME, MI_PHONE, MI_ADDRESS, MI_EMAIL, MI_CREDATE FROM MEMBER_INFO;
INSERT INTO PRODUCT_INFO(PI_NAME, PI_TYPE, PI_PRICE) VALUES ('새총', '총', 30000);
SELECT PI_NUM, PI_NAME, PI_TYPE, PI_PRICE FROM PRODUCT_INFO;



