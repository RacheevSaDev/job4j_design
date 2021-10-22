create table lockers(
    id serial primary key,
    color int
);

create table prisoners(
    id serial primary key,
    name varchar(255),
	block_id int,
	locker_id int references lockers(id) unique,
	work_id int
);