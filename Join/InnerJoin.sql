create table professions(
    id serial primary key,
    title varchar(100)
);

select * from professions;

insert into professions (title) values ('Teacher');
insert into professions (title) values ('Coach');
insert into professions (title) values ('Engineer');
insert into professions (title) values ('Artist');
insert into professions (title) values ('Singer');
insert into professions (title) values ('Worker');

create table users(
    id serial primary key,
    name text,
    profession_id int references professions(id)
);

insert into users (name, profession_id) values ('Bob', 1);
insert into users (name, profession_id) values ('Jean', 2);
insert into users (name, profession_id) values ('Mick', 5);
insert into users (name, profession_id) values ('Bill', 4);
insert into users (name, profession_id) values ('Dima', 4);
insert into users (name, profession_id) values ('Vasya', 2);
insert into users (name, profession_id) values ('Petya', 6);
insert into users (name, profession_id) values ('Sveta', 3);
insert into users (name, profession_id) values ('Misha', 6);
insert into users (name, profession_id) values ('Grisha', 6);
insert into users (name, profession_id) values ('Dima', 6);

select * from users;

-- выбираем всё подряд
select * from users u join professions p on u.profession_id = p.id;

-- выбираем только данные со смысловой нагрузкой
select
	u.id as Идентификатор,
	u.name Имя,
	p.title Профессия
from users u join professions p
on
u.profession_id = p.id;

-- выбираем данные со составным условием
select
	u.id as Идентификатор,
	u.name Имя,
	p.title Профессия
from users u join professions p
on
u.profession_id = p.id and p.title = 'Worker';






