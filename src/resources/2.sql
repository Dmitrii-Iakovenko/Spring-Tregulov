-- DROP TABLE employees;


CREATE TABLE details (
     id  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
     city varchar(15),
     phone_number varchar(25),
     email varchar(30)
);

CREATE TABLE employees (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name varchar(15),
    surname varchar(25),
    department varchar(20),
    salary int,
    details_id BIGINT,
    FOREIGN KEY (details_id) REFERENCES details(id)
);
