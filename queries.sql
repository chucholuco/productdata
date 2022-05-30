show tables
use mydb;
create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

create table customer(
id int PRIMARY KEY,
name varchar(50),
email varchar(100)
);

select * from product;
delete from product where id  = 1;

use mydb
create table employee(
id int PRIMARY KEY,
name varchar(20)
)
drop table employee

select * from employee;

create table id_gen(
	gen_name varchar(60) PRIMARY KEY,
    gen_val int(20)
)
select * from id_gen
SET SQL_SAFE_UPDATES = 0;
delete from employee;

select * from product;
insert into product values(2, 'iWatch', 'From Apple Inc', 400)
insert into product values(3, 'TV', 'From Samsung', 1000);
insert into product values(4, 'Washer', 'From LG', 2000);
insert into product values(5, 'Dryer', 'From LG', 1500);

update product set description = 'From Apple Inc' where id = 1;

select * from customer;
insert into customer (id, name, email) values(2, "Azalia", "ledtere@gmail.com");

create table student(
	id int primary key auto_increment,
    lname varchar(20),
    fname varchar(20),
    score int
);

select * from student;
use mydb;
insert into student (lname, fname, score) values ("Summer", "Xavier", 100);

create table payment(
	id int primary key,
    pmode varchar(2),
    amount decimal(8,3),
    cardnumber varchar(20),
    checknumber varchar(20)
);
select * from payment;

create table card(
	id int primary key,
    amount decimal(8,3),
    cardnumber varchar(20)
);

create table bankcheck(
	id int primary key,
    amount decimal (8,3),
    checknumber varchar(20)
);
select * from card;
select * from bankcheck;
 
 
create table payment2(
	id int primary key,
    amount decimal(8, 3)
);

create table card2(
	id int,
    cardnumber varchar(20),
    foreign key (id) references payment2(id)
);

create table bankcheck2(
	id int,
    checknumber varchar(20),
    foreign key (id) references payment2(id)
);

select * from payment2;
select * from card2;
select * from bankcheck2;

use mydb;
create table employee2(
	id int,
    name varchar(20),
    streetaddress varchar(30),
    city varchar(20),
    state varchar(20),
    zipcode varchar(20),
    country varchar(20)
);
select * from employee2;

create table customer2(
	id int PRIMARY KEY,
	name varchar(50),
	email varchar(100),
	streetaddress varchar(30),
	city varchar(20),
	state varchar(20),
	zipcode varchar(20),
	country varchar(20)
);

select * from customer2;

create table customer3(
	id int primary key auto_increment,
    name varchar(20)
);

create table phone_number(
	id int primary key auto_increment,
    customer_id int,
    number varchar(20),
    type varchar(20),
    foreign key (customer_id) references customer3(id)
);

SET SQL_SAFE_UPDATES = 0;
select * from customer3; delete from customer3 where id in(3,4);
select * from phone_number;  delete from phone_number where id in(3,4,5,6);

create table programmer(
	id int primary key auto_increment,
    name varchar(20),
    salary int
);

create table project(
	id int primary key auto_increment,
    name varchar(20)
);

create table programmers_projects(
	programmer_id int,
    project_id int,
    foreign key (programmer_id) references programmer(id),
    foreign key (project_id) references project(id)
);

select * from programmer;
select * from project;
select * from programmers_projects;

use mydb;
create table person(
	id int primary key auto_increment,
    first_name varchar(20),
    last_name varchar(20),
    age int
);

create table license(
	id int primary key auto_increment,
    type varchar(20),
    valid_from date,
    valid_to date,
    person_id int,
    foreign key (person_id) references person(id)
);

select * from person;
select * from license;

use mydb;
create table bankaccount (
	accno int,
    lastname varchar(25),
    firstname varchar(25),
    bal int
);
insert into bankaccount values(1,'obama','barack',5000);
insert into bankaccount values(2,'donald','trump',4000);
select * from bankaccount;

drop table bankaccount;

use mydb;
create table image(
	id bigint not null,
    name varchar(100) not null,
    data blob not null,
    primary key (id)
);
select * from image;

select * from product;

DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT *  FROM product;
END //

DELIMITER //

CREATE PROCEDURE GetAllProductsByPrice(IN price_in decimal)
BEGIN
	SELECT *  FROM product where price>price_in;
END //

