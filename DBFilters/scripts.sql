-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select
	p.name,
	t.name
from product p join type t
	on p.type_id = t.id
where t.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select
	p.name,
	t.name
from product p join type t
	on p.type_id = t.id
where p.name like '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select
	p.name,
	p.expired_date,
	t.name
from product p join type t
	on p.type_id = t.id
where p.expired_date < current_date;

-- 4. Написать запрос, который выводит самый дорогой продукт.
select
	p.name,
	p.price
from product p
where p.price = (select max(p.price) from product p);

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select
	t.name,
	count(p.id)
from type t join product p
	on t.id = p.type_id
group by t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select
	p.name
from type t join product p
	on t.id = p.type_id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. Под количеством подразумевается количество продуктов определенного типа. Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
select
	t.name,
	count(p.id)
from type t join product p
	on t.id = p.type_id
group by t.name
having count(p.id) < 10;

-- 8. Вывести все продукты и их тип.
select
	p.name,
	t.name
from product p join type t
	on p.type_id = t.id;