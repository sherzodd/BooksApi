create table book (
id INT AUTO_INCREMENT PRIMARY KEY, title varchar2(150) not null, author varchar2(150) not null,
description varchar2(150)
);

insert into BOOK (title, author, description) values ('Crime and Punishment', 'F. Dostoevsky', null); insert into BOOK (title, author, description) values ('Anna Karenina', 'L. Tolstoy', null); insert into BOOK (title, author, description)
values ('The Brothers Karamazov', 'F. Dostoevsky', null); insert into BOOK (title, author, description) values ('War and Peace', 'L. Tolstoy', null); insert into BOOK (title, author, description) values ('Dead Souls', 'N. Gogol', null); commit;
