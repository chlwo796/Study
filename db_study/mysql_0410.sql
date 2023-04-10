create user 'yes_spring_mvc_user'@'%' identified by '1234';

GRANT EXECUTE, SELECT, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `yes_spring_mvc`.* TO 'yes_spring_mvc_user'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

insert into book(title, category, price) values('제목1','컴퓨터1', 20000);

select * from book;

