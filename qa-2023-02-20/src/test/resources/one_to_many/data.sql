delete from car;
delete from person;

insert into person (id, name) values (1, 'Илья');
insert into car (name, person_id) values ('Гранта', 1);
insert into car (name, person_id) values ('Мазда', 1);

insert into person (id, name) values (2, 'Саша');
insert into car (name, person_id) values ('Лексус', 2);
insert into car (name, person_id) values ('Додж', 2);
insert into car (name, person_id) values ('Приора', 2);
insert into car (name, person_id) values ('Шкода', 2);

insert into person (id, name) values (3, 'Ярослав');

insert into person (id, name) values (4, 'Саша');
insert into car (name, person_id) values ('Десятка', 4);
insert into car (name, person_id) values ('Семерка', 4);
insert into car (name, person_id) values ('УАЗ', 4);