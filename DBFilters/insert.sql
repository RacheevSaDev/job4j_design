insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МЯСО');
insert into type(name) values ('РЫБА');
insert into type(name) values ('ПИВО');

select * from type;

insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 1, '2021.09.10', 150);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '2021.12.10', 300);
insert into product(name, type_id, expired_date, price) values ('Сыр российский', 1, '2021.12.10', 250);
insert into product(name, type_id, expired_date, price) values ('Молоко коровье', 2, '2021.11.10', 80);
insert into product(name, type_id, expired_date, price) values ('Молоко козье', 2, '2021.10.10', 70);
insert into product(name, type_id, expired_date, price) values ('Мясо свинина', 3, '2021.11.11', 330);
insert into product(name, type_id, expired_date, price) values ('Мясо говядина', 3, '2021.10.11', 350);
insert into product(name, type_id, expired_date, price) values ('Рыба вобла', 4, '2021.12.11', 170);
insert into product(name, type_id, expired_date, price) values ('Пиво обычное', 5, '2021.12.11', 100);
insert into product(name, type_id, expired_date, price) values ('Пиво крепкое', 5, '2020.12.11', 120);

select * from product;