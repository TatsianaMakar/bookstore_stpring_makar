DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS covers;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;


CREATE TABLE IF NOT EXISTS covers (
    id BIGSERIAL PRIMARY KEY,
    cover_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS books (
    id BIGSERIAL PRIMARY KEY,
    book_name VARCHAR(20),
    author VARCHAR(20),
    year INTEGER,
    price DECIMAL (4,2),
    isbn CHAR(17) UNIQUE,
    cover_id BIGSERIAL REFERENCES covers
);

CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(20),
    user_email VARCHAR(20) UNIQUE,
    user_password VARCHAR(20),
    role_id BIGSERIAL REFERENCES roles
 );



   
   
