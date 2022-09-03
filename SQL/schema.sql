DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS books;
-- DROP TABLE IF EXISTS covers;
DROP TABLE IF EXISTS users;

-- CREATE TABLE IF NOT EXISTS covers (
--     id BIGSERIAL PRIMARY KEY,
--     cover_name VARCHAR(20)
-- );

CREATE TABLE IF NOT EXISTS books (
    id BIGSERIAL PRIMARY KEY,
    book_name VARCHAR(20),
    author VARCHAR(20),
    year INTEGER,
    price DECIMAL (4,2),
    isbn CHAR(17),
    cover CHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(20),
    user_email VARCHAR(20),
    user_password VARCHAR(20),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
 );
 
 CREATE TABLE IF NOT EXISTS status(
 id BIGSERIAL PRIMARY KEY,
 status_name VARCHAR(20)
 );
 
 CREATE TABLE IF NOT EXISTS orders(
 id BIGSERIAL PRIMARY KEY,
 user_id BIGINT REFERENCES users,
 status_id BIGINT REFERENCES status,
 total_cost DECIMAL(8,2),
 deleted BOOLEAN NOT NULL DEFAULT FALSE
  );
        
 CREATE TABLE IF NOT EXISTS order_item(
 id BIGSERIAL PRIMARY KEY,
 book_id BIGINT REFERENCES books,
 quantity INT2,
 price DECIMAL(6,2),
 order_id BIGINT REFERENCES orders,
 deleted BOOLEAN NOT NULL DEFAULT FALSE
);



   
   
