DROP TABLE students IF EXISTS;

CREATE TABLE students (
  id integer IDENTITY PRIMARY KEY,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45)
);

