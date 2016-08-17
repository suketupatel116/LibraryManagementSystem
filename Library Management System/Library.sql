drop table if exists library;

create table library(

	id 		integer auto_increment primary key,
	type 		varchar(10),
	name 		varchar(255),
	info 		varchar(255),
	available	varchar(5),
	number 		integer,
    dbb 		varchar(50) references logentry(dbb)
);

-- insert into library (type, name, info, available, number) values ('tablet', 'Samsung Galaxy Tab 10.7', 'Android 4.4.2', 'Yes', 1);

-- insert into library (type, name, info, available, number) values ('book', 'Introduction to Algorithms', 'Thomas Cormen', 'No', 0);

drop table if exists logentry;

create table logentry(

	id 			integer references library(id),
	sid 		integer auto_increment primary key,
	cin 		varchar(10),
	sname 		varchar(255),
	bdate 		varchar(50),
	rdate		varchar(50),
	dbb 		varchar(50)
);


drop table if exists users;

create table users(

	id		integer auto_increment primary key,
    username	varchar(25),
    password	varchar(25)
);

insert into users values (1, 'cysun', 'abcd');
insert into users values (2, 'suketu', 'abcd');

drop table if exists types;

create table types(

	id 	integer auto_increment primary key,
    type 	varchar(25)
);

insert into types values (1, 'tablet');
insert into types values (2, 'book');