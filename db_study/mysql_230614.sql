SELECT * FROM BABSANG_INFO;
SELECT * FROM COMMENT_INFO;
SELECT * FROM USER_INFO;

SELECT last_insert_id(BI_NUM) FROM BABSANG_INFO;

INSERT INTO USER_INFO (UI_NICKNAME, UI_PWD, UI_FILEPATH, UI_GENDER, 
UI_AGE, BI_NUM, UI_CREDAT, UI_ID, 
UI_ACTIVE, UI_DEL) VALUES
('관리자', '1111', '/resources/upload/관리자사진.png', 0, 30, 0, NOW(), 'Administer', 0, null);

SELECT * FROM USER_INFO;
SELECT * FROM KAKAO_USER_INFO;
SELECT * FROM NAVER_USER_INFO;
DELETE FROM USER_INFO WHERE UI_NUM = 93;
DESC comment_info;
commit;

SELECT ui.UI_NUM, ui.UI_NICKNAME, ui.UI_PWD, ui.UI_FILEPATH, 
ui.UI_GENDER, ui.UI_AGE, ui.BI_NUM, ui.UI_CREDAT, 
ui.UI_ID, ui.UI_ACTIVE, ui.UI_DEL, kui.KUI_ID FROM USER_INFO ui, KAKAO_USER_INFO kui WHERE ui.UI_NUM = kui.UI_NUM;

UPDATE USER_INFO SET BI_NUM = 81 WHERE UI_NUM = 2;

SELECT * FROM USER_INFO WHERE BI_NUM = 81;

SELECT * FROM BABSANG_INFO WHERE UI_NUM = 30;

SELECT ui.UI_NUM, ui.UI_NICKNAME, ui.UI_PWD, ui.UI_FILEPATH, 
ui.UI_GENDER, ui.UI_AGE, ui.BI_NUM, ui.UI_CREDAT, 
ui.UI_ID, ui.UI_ACTIVE, ui.UI_DEL 
FROM BABSANG_INFO bi, USER_INFO ui WHERE bi.UI_NUM = ui.UI_NUM and bi.BI_NUM = ui.BI_NUM; 

DELETE FROM BABSANG_INFO WHERE BI_NUM = 81;
DELETE FROM USER_INFO WHERE UI_NUM = 30;
UPDATE USER_INFO SET UI_ACTIVE = 0, UI_DEL = NULL WHERE UI_NUM = 145;

SELECT CI_NUM, CI_CONTENT, date_format(CI_CREDAT,'%Y. %m. %d'), 
date_format(CI_CRETIM, '%H시 %i분') CI_CRETIM, UI_NUM, BI_NUM FROM COMMENT_INFO;

DESC USER_INFO;
DESC BABSANG_INFO;

UPDATE USER_INFO SET BI_NUM = 130 WHERE UI_NUM = 161;

ALTER TABLE BABSANG_INFO ADD column BI_USERCNT INT;
COMMIT;