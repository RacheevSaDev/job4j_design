create table blocks(
    id serial primary key,
    title varchar(255),
	type int
);

create table prisoners(
    id serial primary key,
    name varchar(255),
	block_id int references blocks(id),
	locker_id int,
	work_id int
);