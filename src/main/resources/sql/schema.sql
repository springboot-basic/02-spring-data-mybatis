create table author(
    id SERIAL PRIMARY KEY ,
    author_name VARCHAR(50) NOT NULL ,
    gender VARCHAR(10) NOT NULL
);

create table books(
    id serial primary key ,
    title varchar(50) not null ,
    published_date timestamp not null ,
    author_id int references author(id) on delete cascade
);

create table categories(
    id serial primary key ,
    category_name varchar(255) not null
);

create table book_category(
    book_id int references books(id) on delete cascade ,
    category_id int references categories(id) on delete cascade
);