create table engines(
	id serial primary key,
	name text
);

insert into engines (name) values ('M104');
insert into engines (name) values ('M111');
insert into engines (name) values ('M112');
insert into engines (name) values ('M271');
insert into engines (name) values ('M272');
insert into engines (name) values ('1JZ');

select * from engines;

create table transmissions(
	id serial primary key,
	name text
);

insert into transmissions (name) values ('722.5');
insert into transmissions (name) values ('722.6');
insert into transmissions (name) values ('722.7');
insert into transmissions (name) values ('722.8');


create table bodies(
	id serial primary key,
	name text
);

insert into bodies (name) values ('W126');
insert into bodies (name) values ('W202');
insert into bodies (name) values ('W203');
insert into bodies (name) values ('W210');
insert into bodies (name) values ('W211');

create table cars(
	id serial primary key,
	name text,
	engine_id int references engines(id),
	transmission_id int references transmissions(id),
	body_id int references bodies(id)
);

insert into cars(name, engine_id, transmission_id, body_id) values ('Жигули', 1, 1, 1);
insert into cars(name, engine_id, transmission_id, body_id) values ('Лада', 1, 2, 2);
insert into cars(name, engine_id, transmission_id, body_id) values ('Москвич', 1, 2, 3);
insert into cars(name, engine_id, transmission_id, body_id) values ('Запарожец', 1, 1, 4);
insert into cars(name, engine_id, transmission_id, body_id) values ('Инвалидка', 1, 3, 2);
insert into cars(name, engine_id, transmission_id, body_id) values ('Нива', 2, 3, 4);
insert into cars(name, engine_id, transmission_id, body_id) values ('Уаз', 2, 2, 2);

select * from cars;

-- 1) Вывести список всех машин и все привязанные к ним детали.
select
	c.name Марка,
	e.name Двигатель,
	t.name Трансмиссия,
	b.name Кузов
from cars c
join engines e
	on c.engine_id = e.id
join transmissions t
	on c.transmission_id = t.id
join bodies b
	on c.body_id = b.id;

-- 2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
-- двигатель
select e.name from engines e left join cars c on e.id = c.engine_id group by e.name having count(c.id) = 0;
-- трансмиссия
select t.name from transmissions t left join cars c on t.id = c.transmission_id group by t.name having count(c.id) = 0;
-- кузов
select b.name from bodies b left join cars c on b.id = c.body_id group by b.name having count(c.id) = 0;
