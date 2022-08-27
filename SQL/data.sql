INSERT INTO covers(cover_name) VALUES 
('HARD'),
('SOFT'),
('SPECIAL');

INSERT INTO books (book_name, author, year,price,isbn,cover_id,deleted) 
VALUES ('Book1', 'Author1', 2000, 8.35, '987-0-1234-5680-0',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book2', 'Author2', 2001, 10.35,'987-1-1234-5680-1',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book3', 'Author3', 2002, 11.15,'987-3-1234-5680-2',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book4', 'Author4', 2003, 14.35,'987-4-1234-5680-3',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book5', 'Author5', 2004, 81.35,'987-5-1234-5680-4',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book6', 'Author6', 2005, 82.35,'987-6-1234-5680-5',(SELECT id FROM covers WHERE cover_name='HARD'),FALSE),
('Book7', 'Author7', 2006, 8.65,'987-7-1234-5680-6',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book8', 'Author8', 2007, 88.35,'987-8-1234-5680-7',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book9', 'Author9', 2008,8.39, '987-9-1234-5680-8',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book10', 'Author10', 2009, 8.35,'987-1-0234-5680-9',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book11', 'Author11', 2010, 8.35,'987-1-2234-5681-0',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book12', 'Author12', 2011, 8.35,'987-1-3234-5681-1',(SELECT id FROM covers WHERE cover_name='SOFT'),FALSE),
('Book13', 'Author13', 2012, 8.35,'987-1-4234-5681-2',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book14', 'Author14', 2013, 8.35,'987-1-5234-5681-3',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book15', 'Author15', 2014, 8.35,'987-1-6234-5681-4',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book16', 'Author16', 2015, 8.35,'987-1-7234-5681-5',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book17', 'Author17', 2016, 8.35,'987-1-8234-5681-6',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book18', 'Author2', 2017, 8.35,'987-1-9234-5681-7',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book19', 'Author19', 2018, 8.35,'987-2-0234-5681-8',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE),
('Book20', 'Author20', 2019, 8.35,'987-2-1234-5681-9',(SELECT id FROM covers WHERE cover_name='SPECIAL'),FALSE);

INSERT INTO users (user_name, user_email, user_password, deleted) 
VALUES ('User1', 'Email1', 'Password1',FALSE),
('User2', 'Email2', 'Password2',FALSE),
('User3', 'Email3', 'Password3',FALSE),
('User4', 'Email4', 'Password4',FALSE),
('User5', 'Email5', 'Password5',FALSE),
('User6', 'Email6', 'Password6',FALSE),
('User7', 'Email7', 'Password7',FALSE),
('User8', 'Email8', 'Password8',FALSE),
('User9', 'Email9', 'Password9',FALSE),
('User10', 'Email10', 'Password10',FALSE),
('User11', 'Email11', 'Password11',FALSE),
('User12', 'Email12', 'Password12',FALSE),
('User13', 'Email13', 'Password13',FALSE),
('User14', 'Email14', 'Password14',FALSE),
('User15', 'Email15', 'Password15',FALSE),
('User16', 'Email16', 'Password16',FALSE),
('User17', 'Email17', 'Password17',FALSE),
('User18', 'Email18', 'Password18',FALSE),
('User19', 'Email19', 'Password19',FALSE),
('User20', 'Email20', 'Password20',FALSE);

INSERT INTO status (status_name) VALUES
('PENDING'),
('CONFIRMED'),
('DELIVERED'),
('CANCELED');

INSERT INTO orders (status_id, user_id, deleted) VALUES
((SELECT id FROM status WHERE status_name='PENDING'), (SELECT id FROM users WHERE user_name='User3'),FALSE),
((SELECT id FROM status WHERE status_name='CONFIRMED'), (SELECT id FROM users WHERE user_name='User8'),FALSE),
((SELECT id FROM status WHERE status_name='DELIVERED'), (SELECT id FROM users WHERE user_name='User1'),FALSE),
((SELECT id FROM status WHERE status_name='CANCELED'), (SELECT id FROM users WHERE user_name='User20'),FALSE),
((SELECT id FROM status WHERE status_name='CONFIRMED'), (SELECT id FROM users WHERE user_name='User5'),FALSE);

INSERT INTO order_item (book_id, quantity, price, order_id,deleted) VALUES
((SELECT id FROM books WHERE book_name='Book7'),3, (SELECT price FROM books WHERE book_name='Book7'),1,FALSE),
((SELECT id FROM books WHERE book_name='Book1'),2, (SELECT price FROM books WHERE book_name='Book1'),1,FALSE),
((SELECT id FROM books WHERE book_name='Book8'),1, (SELECT price FROM books WHERE book_name='Book8'),3,FALSE),
((SELECT id FROM books WHERE book_name='Book20'),5, (SELECT price FROM books WHERE book_name='Book20'),3,FALSE),
((SELECT id FROM books WHERE book_name='Book7'),2, (SELECT price FROM books WHERE book_name='Book7'),1,FALSE);

 