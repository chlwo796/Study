--����� �����
create user tester1 identified by 1234;
--���� �ο�
grant connect, resource to tester1;
-- stmanager ����� DB �����
create user stmanager identified by 1234;

--�����ֱ�
grant connect, resource to stmanager;

create user orauser1 identified by 1234;
--���Ѻο�
grant create session to orauser1;
--���� ����
revoke create session from orauser1;