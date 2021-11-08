-- 1. Создать таблицы и заполнить их начальными данными
create table departaments(
	id serial primary key,
	name text
);

create table emploers(
    id serial primary key,
	name text,
	departament_id int references departaments(id)
);

insert into departaments(name) values ('Dep1');
insert into departaments(name) values ('Dep2');
insert into departaments(name) values ('Dep3');
insert into departaments(name) values ('Dep4');
insert into departaments(name) values ('Dep5');

select * from departaments;

insert into emploers (name, departament_id) values ('emp1', 1);
insert into emploers (name, departament_id) values ('emp2', 1);
insert into emploers (name, departament_id) values ('emp3', 2);
insert into emploers (name, departament_id) values ('emp4', 3);
insert into emploers (name, departament_id) values ('emp5', 3);
insert into emploers (name, departament_id) values ('emp6', 3);
insert into emploers (name, departament_id) values ('emp7', null);

select * from emploers;

-- 2. Выполнить запросы с left, right, full, cross соединениями
select e.name, d.name from emploers e left join departaments d on e.departament_id = d.id;

select e.name, d.name from emploers e right join departaments d on e.departament_id = d.id;

select e.name, d.name from emploers e full join departaments d on e.departament_id = d.id;

select e.name, d.name from emploers e cross join departaments d;

-- 3. Используя left join найти департаменты, у которых нет работников
select d.name from departaments d left join emploers e on e.departament_id = d.id group by d.name having count(e.name) = 0;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select e.name, d.name from emploers e left join departaments d on e.departament_id = d.id;
select e.name, d.name from departaments d right join emploers e on e.departament_id = d.id;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
-- Создать таблицу
create table teens (
	id serial primary key,
	name text,
	gender char
);
-- заполнить ее
insert into teens (name, gender) values ('Masha', 'F');
insert into teens (name, gender) values ('Dasha', 'F');
insert into teens (name, gender) values ('Natasha', 'F');
insert into teens (name, gender) values ('Misha', 'M');
insert into teens (name, gender) values ('Vasya', 'M');
insert into teens (name, gender) values ('Petya', 'M');
insert into teens (name, gender) values ('Dima', 'M');

select * from teens;

--составить все возможные разнополые пары
select t.name, tt.name from teens t cross join teens tt where not t.gender = tt.gender;
