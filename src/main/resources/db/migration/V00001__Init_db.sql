  create table employee (
    id  bigserial not null,
    birthday varchar(255) not null,
    email varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    primary key (id)
    );

  insert into employee(id, birthday, email, first_name,  last_name) values(1, '26.12.2002', 'dima', 'dudka', 'dima@gmail.com');
  insert into employee(id, birthday, email, first_name, last_name) values(2, '06.06.2002', 'josh', 'marston', 'josh@gmail.com');




