create schema nothing;

CREATE TABLE `USER_INFO2` (
   `UI_NUM` INT(11) NOT NULL AUTO_INCREMENT,
   `UI_ID` CHAR(11) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
   `UI_NAME` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_general_ci',
   `UI_EMAIL` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
   `UI_ADDRESS` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
   `UI_PWD` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
   `UI_BIRTH` CHAR(8) NOT NULL COLLATE 'utf8mb4_general_ci',
   `UI_TRANS` CHAR(1) NOT NULL DEFAULT '1' COLLATE 'utf8mb4_general_ci',
   `CREDAT` CHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
   `CRETIM` CHAR(6) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
   `OUTDAT` CHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
   `ACTIVE` CHAR(1) NULL DEFAULT '1' COLLATE 'utf8mb4_general_ci',
   `UI_LVL` CHAR(1) NULL DEFAULT '2' COLLATE 'utf8mb4_general_ci',
   `UI_DUTIES` VARCHAR(10) NOT NULL DEFAULT '사무' COLLATE 'utf8mb4_general_ci',
   PRIMARY KEY (`UI_NUM`) USING BTREE,
   UNIQUE INDEX `UI_ID` (`UI_ID`) USING BTREE
)
;

SELECT DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s');

INSERT INTO USER_INFO2 (UI_ID, UI_NAME, UI_EMAIL, UI_ADDRESS, UI_PWD, UI_BIRTH, UI_TRANS, CREDAT, CRETIM, ACTIVE, UI_LVL, UI_DUTIES) VALUES 
('chlwo796', '최재환', 'chlwo796@gmail.com', '경기도 하남시', '1234', '19930122', '1', DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), '1', '3', '부장');

SELECT UI_NUM, UI_ID, UI_NAME, UI_EMAIL, UI_ADDRESS, UI_PWD, UI_BIRTH, UI_TRANS, CREDAT, CRETIM, OUTDAT, ACTIVE, UI_LVL, UI_DUTIES FROM USER_INFO2;