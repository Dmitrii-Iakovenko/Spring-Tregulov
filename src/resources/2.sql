-- CREATE DATABASE  my_db;
-- USE my_db;
--
--

CREATE TABLE employees (
--   id int NOT NULL AUTO_INCREMENT,
--   id BIGSERIAL PRIMARY KEY NOT NULL,
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int
--   PRIMARY KEY (id)
);

