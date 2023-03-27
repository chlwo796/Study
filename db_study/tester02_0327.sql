create table student(
    student_no number(7) not null,
    name varchar2(10),
    sin_no nvarchar2(14),
    age number(3),
    teacher_no varchar2(6),
    primary key( student_no ),
    FOREIGN key(teacher_no) REFERENCES teacher(teacher_no)
);

create table teacher(
    teacher_no varchar2(6),
    name varchar2(10),
    major varchar2(10),
    tell varchar2(12),
    location varchar2(6),
    primary key(teacher_no)
    );
alter table student modify(
    name varchar2(30)
);
insert into teacher values('T-100', '정현희', '컴퓨터공학', '01041125567', '이과동');
insert into teacher values('T-200', '이순신', '무용학과', '01012125567', '예술동');
insert into student values (1112988, '최재환', '930122-1209218', 20, 'T-100');
insert into student (student.student_no, name, sin_no, age, teacher_no) values (1212978, '홍길동', '920123-1283730', 21, 'T-200');

select * from student;

select * from teacher;