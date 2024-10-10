create database books_manager;

use books_manager;

create table authors
(
	id int auto_increment,
    name varchar(50),
    birthDate datetime,
    bio varchar(500),
    primary key(id)
);

create table books
(
	id int auto_increment,
    title varchar(100),
    publisher varchar(100),
    isbn varchar(30),
    genre varchar(30),
    pages_count int,
    price double,
    authorId int,
    primary key(id),
    foreign key (authorId) references authors(id)
);

