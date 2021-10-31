insert into devices (name, price) values ('Laptop xiaomi', 850);
insert into devices (name, price) values ('bluetooth mouse', 35);
insert into devices (name, price) values ('headphones akg', 89);
insert into devices (name, price) values ('sound bar', 105);
insert into devices (name, price) values ('flash drive', 10);
insert into devices (name, price) values ('smartphone poco x3', 280);
insert into devices (name, price) values ('printer epson', 250);
insert into devices (name, price) values ('printer zolotoy', 25000);

select * from devices;

insert into people (name) values ('Petya');
insert into people (name) values ('Vasya');
insert into people (name) values ('Dima');

select * from people;

insert into devices_people(device_id, people_id) values (1,1);
insert into devices_people(device_id, people_id) values (2,1);
insert into devices_people(device_id, people_id) values (3,2);
insert into devices_people(device_id, people_id) values (4,2);
insert into devices_people(device_id, people_id) values (5,3);
insert into devices_people(device_id, people_id) values (6,3);
insert into devices_people(device_id, people_id) values (7,3);
insert into devices_people(device_id, people_id) values (8,3);

select * from devices_people;



-- 3. Используя агрегатные функции вывести среднюю цену устройств.
select avg(d.price) from devices d;

-- 4. Используя группировку вывести для каждого человека среднюю цену его устройств.
select
	p.name,
	avg(d.price)
from devices_people dp
join devices d
	on dp.device_id = d.id
join people p
	on p.id = dp.people_id
group by p.name;

-- 5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.
select
	p.name,
	avg(d.price)
from devices_people dp
join devices d
	on dp.device_id = d.id
join people p
	on p.id = dp.people_id
group by p.name
having avg(d.price) > 5000;