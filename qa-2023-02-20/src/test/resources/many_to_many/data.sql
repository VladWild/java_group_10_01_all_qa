delete from book;
delete from author;
delete from book_author;

insert into book (id, name) values (1, 'Гарри Поттер и Филасовский Камень');
insert into book (id, name) values (2, 'Гарри Поттер и Тайная Комната');
insert into book (id, name) values (3, 'Метро 2033');
insert into book (id, name) values (4, 'Метро 2034');
insert into book (id, name) values (5, 'Голодные игры');

insert into author (id, name) values (1, 'Джоан Роулинг');
insert into author (id, name) values (2, 'Дмитрий Глуховский');
insert into author (id, name) values (3, 'Сьюзен Коллинз');

insert into book_author (book_id, author_id) values (1, 1);
insert into book_author (book_id, author_id) values (1, 2);
insert into book_author (book_id, author_id) values (2, 1);
insert into book_author (book_id, author_id) values (2, 2);
insert into book_author (book_id, author_id) values (2, 3);
insert into book_author (book_id, author_id) values (4, 1);
insert into book_author (book_id, author_id) values (4, 2);
insert into book_author (book_id, author_id) values (4, 3);
insert into book_author (book_id, author_id) values (5, 3);