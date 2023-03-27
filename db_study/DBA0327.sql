--사용자 만들기
create user tester1 identified by 1234;
--역할 부여
grant connect, resource to tester1;
-- stmanager 사용자 DB 만들기
create user stmanager identified by 1234;

--역할주기
grant connect, resource to stmanager;

create user orauser1 identified by 1234;
--권한부여
grant create session to orauser1;
--권한 삭제
revoke create session from orauser1;