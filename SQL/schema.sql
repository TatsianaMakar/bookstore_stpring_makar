DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS books (
    id BIGSERIAL PRIMARY KEY,
    book_name VARCHAR(20),
    author VARCHAR(20),
    year INTEGER,
    price DECIMAL (4,2),
    isbn VARCHAR(17),
    cover VARCHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(20),
    user_email VARCHAR(20),
    user_password VARCHAR,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
 );
 
 
 CREATE TABLE IF NOT EXISTS orders(
 id BIGSERIAL PRIMARY KEY,
 user_id BIGINT REFERENCES users,
 status VARCHAR(10),
 total_cost DECIMAL(8,2),
 deleted BOOLEAN NOT NULL DEFAULT FALSE
  );
        
 CREATE TABLE IF NOT EXISTS order_item(
 id BIGSERIAL PRIMARY KEY,
 book_id BIGINT REFERENCES books,
 quantity INTEGER,
 price DECIMAL(6,2),
 order_id BIGINT REFERENCES orders,
 deleted BOOLEAN NOT NULL DEFAULT FALSE
);



   
   
