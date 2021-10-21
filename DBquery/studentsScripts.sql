create table students(
	id serial primary key,
	name varchar(255),
	age int,
	gender char,
	isForeigner bool
);

insert into students (
    name,
    age,
    gender,
    isForeigner
    )
values (
    'Semyon',
    34,
    'm',
    false
    );

select * from students;

update students set isForeigner = true;

delete from students;