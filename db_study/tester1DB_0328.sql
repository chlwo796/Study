-- 캠핑장비테이블
create table campingEqu(
    equip_code varchar2(10) not null,
    item_name varchar2(30) not null,
    price number(8),
    count number(4),
    primary key(equip_code)
);

create table customer(
    custom_id varchar2(10) not null,
    custom_name varchar2(30) not null,
    phone varchar2(30) not null,
    address varchar2(30) not null,
    primary key(custom_id)
);

create table rent(
    rent_id varchar2(10) not null,
    equip_code varchar2(10) not null,
    custom_id varchar2(10) not null,
    rent_date date not null,
    rent_amount number(3),
    primary key(rent_id),
    FOREIGN key(equip_code)REFERENCES campingEqu(equip_code)
);

create table return(
    return_id varchar2(10) not null,
    rent_id varchar2(10) not null,
    return_date date not null,
    over_price number(7) not null,
    primary key(return_id),
    FOREIGN key(rent_id)REFERENCES rent(rent_id) 
);

select * from campingEqu;
select * from customer;
select * from rent;
select * from return;

drop table return;
drop table rent;
drop table customer;
drop table campingEqu;

insert into campingequ values('T-100', '텐트', 100000, 30);
insert into campingequ values('C-200', '의자', 10000, 100);
insert into campingequ values('F-300', '그릇', 50000, 70);

insert into customer values('C-100', '홍길동', '01012345678', '서울시 강동구');
insert into customer values('C-101', '이순신', '01056789012', '경기도 하남시');
insert into customer values('C-102', '최수연', '01023456789', '경기도 성남시');

insert into rent values('L-001', 'T-100', 'C-100', '2023-03-28', 2);
insert into rent values('L-002', 'F-300', 'C-102', '2023-03-29', 5);
insert into rent values('L-003', 'T-100', 'C-102', '2023-03-29', 1);

insert into return values('R-001', 'L-001', '2023-04-07', 0);
insert into return values('R-002', 'L-003', '2023-04-10', 50000);

