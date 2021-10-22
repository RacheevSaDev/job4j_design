create table prisoners(
    id serial primary key,
    name varchar(255),
	locker_id int,
	work_id int
);

create table works(
    id serial primary key,
    title varchar(255),
	description varchar(255)
);

create table prisoners_works(
    id serial primary key,
    prisoner_id int references prisoners(id),
    work_id int references works(id)
);