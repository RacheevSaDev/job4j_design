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