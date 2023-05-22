CREATE DATABASE EXAM;

USE EXAM;

CREATE TABLE USER_INFO(
UI_NUM INT NOT NULL PRIMARY KEY auto_increment,
UI_NAME VARCHAR(30) NOT NULL,
UI_ID VARCHAR(30) NOT NULL,
UI_PWD VARCHAR(30) NOT NULL,
UI_BIRTH CHAR(8) NOT NULL,
UI_PHONE VARCHAR(12),
UI_EMAIL VARCHAR(40),
UI_CREDAT CHAR(8) NOT NULL,
UI_CRETIM CHAR(6) NOT NULL,
-- 유저상태(정상 1, 탈퇴 0)
UI_ACTIVE CHAR(1) DEFAULT '1'
);

CREATE TABLE BOARD_INFO(
BI_NUM INT NOT NULL PRIMARY KEY auto_increment,
BI_TITLE VARCHAR(200) NOT NULL,
BI_CONTENT TEXT NOT NULL,
BI_FILE_PATH VARCHAR(40),
BI_CREDAT CHAR(8) NOT NULL,
BI_CRETIM CHAR(6) NOT NULL,
BI_CNT INT DEFAULT 0,
UI_NUM INT NOT NULL,
FOREIGN KEY(UI_NUM) REFERENCES USER_INFO(UI_NUM)
);

DROP TABLE BOARD_INFO;
DROP TABLE USER_INFO;
DESC USER_INFO;
INSERT INTO USER_INFO (UI_NAME, UI_ID, UI_PWD, UI_BIRTH, 
UI_PHONE, UI_EMAIL, UI_CREDAT, UI_CRETIM)
VALUES ('최재환', 'chlwo796', '1234', '19930122',
'01041160586', 'chlwo796@gmail.com', DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'));

SELECT UI_NUM, UI_NAME, UI_PWD, UI_BIRTH, UI_PHONE, UI_EMAIL, UI_CREDAT, UI_CRETIM, UI_ACTIVE FROM USER_INFO;

INSERT INTO BOARD_INFO (BI_TITLE, BI_CONTENT, BI_CREDAT, BI_CRETIM, 
BI_FILE_PATH, UI_NUM)
VALUES ('아무제목', '내용내용', DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), NULL, 1);

INSERT INTO BOARD_INFO (BI_TITLE, BI_CONTENT, BI_CREDAT, BI_CRETIM, 
BI_FILE_PATH, UI_NUM) SELECT BI_TITLE, BI_CONTENT, BI_CREDAT, BI_CRETIM, BI_FILE_PATH, UI_NUM FROM BOARD_INFO;

-- 컬럼 수
SELECT COUNT(*) FROM BOARD_INFO;
-- 마지막 하나만 호출

SELECT * FROM BOARD_INFO
ORDER BY BI_NUM DESC
LIMIT 0, 10;

ALTER TABLE USER_INFO MODIFY COLUMN UI_ID VARCHAR(30) UNIQUE;