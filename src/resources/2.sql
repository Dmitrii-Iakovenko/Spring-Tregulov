-- DROP TABLE employees;
-- DROP TABLE details;


-- CREATE TABLE details (
--      id  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
--      city varchar(15),
--      phone_number varchar(25),
--      email varchar(30)
-- );
--


CREATE TABLE departments
(
    id         BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name       varchar(15),
    max_salary int,
    min_salary int
);

CREATE TABLE employees
(
    id            BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name          varchar(15),
    surname       varchar(25),
    department_id int,
    salary        int,
    FOREIGN KEY (department_id) REFERENCES departments (id)
);

