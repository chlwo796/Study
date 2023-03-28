
create table customer(
    custom_sinNo		varchar2(20) not null,
custom_name		varchar2(20) not null,
address		varchar2(30) not null,
birthday		date,
email		varchar2(20)not null,
phone		varchar2(20) not null,
job		varchar2(30)not null,
primary key(custom_sinNo)

);

create table account(
    account_no		varchar2(20) not null,
custom_sinNo		varchar2(20) not null,
balance		long not null,
appli_chk		number(1) not null,
open_date		date not null,
primary key(account_no),
foreign key(custom_sinNo) references customer(custom_sinNo)

);

create table card(
card_id		varchar2(20) not null,
custom_sinNo		varchar2(20) not null,
account_no		varchar2(20) not null,
appli_date		date not null,
card_type		varchar2(20) not null,
card_name		varchar2(20) not null,
primary key(card_id),
foreign key(custom_sinNo) references customer(custom_sinNo),
foreign key(account_no) REFERENCES account(account_no)
);

create table account_trans(
trans_no		varchar2(20) not null,
account_no		varchar2(20) not null,
trans_date		date not null,
deposit_type		varchar2(20) not null,
deposit_text		varchar2(30) not null,
trans_money		long not null,
primary key(trans_no),
foreign key(account_no) references account(account_no)

);

create table bank(
bank_id		varchar2(10) not null,
trans_no		varchar2(20) not null,
primary key(bank_id),
foreign key(trans_no) references account_trans(trans_no)
);

select * from customer;
select * from account;
select * from card;
select * from account_trans;
select * from bank;