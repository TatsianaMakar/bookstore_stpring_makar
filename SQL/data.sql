INSERT INTO books (book_name, author, year, price, isbn, cover, deleted)
VALUES ('Book1', 'Author1', 2000, 8.35, '987-0-1234-5680-0', 'HARD', FALSE),
       ('Book2', 'Author2', 2001, 10.35, '987-1-1234-5680-1', 'HARD', FALSE),
       ('Book3', 'Author3', 2002, 11.15, '987-3-1234-5680-2', 'HARD', FALSE),
       ('Book4', 'Author4', 2003, 14.35, '987-4-1234-5680-3', 'HARD', FALSE),
       ('Book5', 'Author5', 2004, 81.35, '987-5-1234-5680-4', 'HARD', FALSE),
       ('Book6', 'Author6', 2005, 82.35, '987-6-1234-5680-5', 'HARD', FALSE),
       ('Book7', 'Author7', 2006, 8.65, '987-7-1234-5680-6', 'SOFT', FALSE),
       ('Book8', 'Author8', 2007, 88.35, '987-8-1234-5680-7', 'SOFT', FALSE),
       ('Book9', 'Author9', 2008, 8.39, '987-9-1234-5680-8', 'SOFT', FALSE),
       ('Book10', 'Author10', 2009, 8.35, '987-1-0234-5680-9', 'SOFT',FALSE),
       ('Book11', 'Author11', 2010, 8.35, '987-1-2234-5681-0', 'SOFT',FALSE),
       ('Book12', 'Author12', 2011, 8.35, '987-1-3234-5681-1', 'SOFT',FALSE),
       ('Book13', 'Author13', 2012, 8.35, '987-1-4234-5681-2', 'SPECIAL',FALSE),
       ('Book14', 'Author14', 2013, 8.35, '987-1-5234-5681-3', 'SPECIAL',FALSE),
       ('Book15', 'Author15', 2014, 8.35, '987-1-6234-5681-4',  'SPECIAL',FALSE),
       ('Book16', 'Author16', 2015, 8.35, '987-1-7234-5681-5', 'SPECIAL',FALSE),
       ('Book17', 'Author17', 2016, 8.35, '987-1-8234-5681-6', 'SPECIAL',FALSE),
       ('Book18', 'Author2', 2017, 8.35, '987-1-9234-5681-7', 'SPECIAL',FALSE),
       ('Book19', 'Author19', 2018, 8.35, '987-2-0234-5681-8', 'SPECIAL',FALSE),
       ('Book20', 'Author20', 2019, 8.35, '987-2-1234-5681-9', 'SPECIAL',FALSE);

INSERT INTO users (user_name, user_email, user_password, deleted)
VALUES ('User1', 'Email1', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User2', 'Email2', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User3', 'Email3', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User4', 'Email4', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User5', 'Email5', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User6', 'Email6', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User7', 'Email7', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User8', 'Email8', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User9', 'Email9', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User10', 'Email10', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User11', 'Email11', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User12', 'Email12', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User13', 'Email13', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User14', 'Email14', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User15', 'Email15', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User16', 'Email16', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User17', 'Email17', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User18', 'Email18', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User19', 'Email19', '12dea96fec20593566ab75692c9949596833adc9', FALSE),
       ('User20', 'Email20', '12dea96fec20593566ab75692c9949596833adc9', FALSE);

INSERT INTO orders (status, user_id, deleted)
VALUES ('PENDING', (SELECT id FROM users WHERE user_name = 'User3'), FALSE),
       ('CONFIRMED', (SELECT id FROM users WHERE user_name = 'User8'),FALSE),
       ('DELIVERED', (SELECT id FROM users WHERE user_name = 'User1'),FALSE),
       ('CANCELED', (SELECT id FROM users WHERE user_name = 'User20'),FALSE),
       ('CONFIRMED', (SELECT id FROM users WHERE user_name = 'User5'),FALSE);

INSERT INTO order_item (book_id, quantity, price, order_id, deleted)
VALUES ((SELECT id FROM books WHERE book_name = 'Book7'), 3, (SELECT price FROM books WHERE book_name = 'Book7'), 1,
        FALSE),
       ((SELECT id FROM books WHERE book_name = 'Book1'), 2, (SELECT price FROM books WHERE book_name = 'Book1'), 1,
        FALSE),
       ((SELECT id FROM books WHERE book_name = 'Book8'), 1, (SELECT price FROM books WHERE book_name = 'Book8'), 3,
        FALSE),
       ((SELECT id FROM books WHERE book_name = 'Book20'), 5, (SELECT price FROM books WHERE book_name = 'Book20'), 3,
        FALSE),
       ((SELECT id FROM books WHERE book_name = 'Book7'), 2, (SELECT price FROM books WHERE book_name = 'Book7'), 1,
        FALSE);

