
 
INSERT INTO covers(cover_name) VALUES 
('HARD'),
('SOFT'),
('SPECIAL');

INSERT INTO books (book_name, author, year,price,isbn,cover_id) 
VALUES ('Book1', 'Author1', 2000, 8.35, '987-0-1234-5680-0',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book2', 'Author2', 2001, 10.35,'987-1-1234-5680-1',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book3', 'Author3', 2002, 11.15,'987-3-1234-5680-2',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book4', 'Author4', 2003, 14.35,'987-4-1234-5680-3',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book5', 'Author5', 2004, 81.35,'987-5-1234-5680-4',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book6', 'Author6', 2005, 82.35,'987-6-1234-5680-5',(SELECT cover_id FROM covers WHERE cover_name='HARD')),
('Book7', 'Author7', 2006, 8.65,'987-7-1234-5680-6',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book8', 'Author8', 2007, 88.35,'987-8-1234-5680-7',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book9', 'Author9', 2008,8.39, '987-9-1234-5680-8',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book10', 'Author10', 2009, 8.35,'987-1-0234-5680-9',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book11', 'Author11', 2010, 8.35,'987-1-2234-5681-0',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book12', 'Author12', 2011, 8.35,'987-1-3234-5681-1',(SELECT cover_id FROM covers WHERE cover_name='SOFT')),
('Book13', 'Author13', 2012, 8.35,'987-1-4234-5681-2',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book14', 'Author14', 2013, 8.35,'987-1-5234-5681-3',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book15', 'Author15', 2014, 8.35,'987-1-6234-5681-4',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book16', 'Author16', 2015, 8.35,'987-1-7234-5681-5',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book17', 'Author17', 2016, 8.35,'987-1-8234-5681-6',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book18', 'Author2', 2017, 8.35,'987-1-9234-5681-7',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book19', 'Author19', 2018, 8.35,'987-2-0234-5681-8',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL')),
('Book20', 'Author20', 2019, 8.35,'987-2-1234-5681-9',(SELECT cover_id FROM covers WHERE cover_name='SPECIAL'));

INSERT INTO roles(role_name) VALUES 
('ADMIN'), 
('MANAGER'), 
('CUSTOMER');

INSERT INTO users (user_name, user_email, user_password, role_id) 
VALUES ('User1', 'Email1', 'Password1', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User2', 'Email2', 'Password2', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User3', 'Email3', 'Password3', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User4', 'Email4', 'Password4', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User5', 'Email5', 'Password5', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User6', 'Email6', 'Password6', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User7', 'Email7', 'Password7', (SELECT id FROM roles WHERE role_name='ADMIN')),
('User8', 'Email8', 'Password8', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User9', 'Email9', 'Password9', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User10', 'Email10', 'Password10', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User11', 'Email11', 'Password11', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User12', 'Email12', 'Password12', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User13', 'Email13', 'Password13', (SELECT id FROM roles WHERE role_name='MANAGER')),
('User14', 'Email14', 'Password14', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User15', 'Email15', 'Password15', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User16', 'Email16', 'Password16', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User17', 'Email17', 'Password17', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User18', 'Email18', 'Password18', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User19', 'Email19', 'Password19', (SELECT id FROM roles WHERE role_name='CUSTOMER')),
('User20', 'Email20', 'Password20', (SELECT id FROM roles WHERE role_name='CUSTOMER'));



SELECT books.id, books.book_name, books.author, books.year, books.price, books.isbn, covers.cover_name FROM books JOIN covers ON books.cover_id=covers.cover_id;