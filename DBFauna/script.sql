-- 1) Извлечение данных, у которых имя name содержит подстроку fish
select * from fauna where name like '%fish%';

-- 2) Извлечение данных, у которых сред. продолжительность жизни находится в диапазоне 10 000 и 21 000
select * from fauna where 10000 < avg_age and avg_age < 21000;

-- 3) Извлечение данных, у которых дата открытия не известна (null)
select * from fauna where discovery_date is null;

-- 4) Извлечение данных видов, у которых дата открытия раньше 1950 года
select * from fauna where discovery_date < '1950.01.01';

