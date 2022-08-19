package com.company.app;

import com.company.dao.connection.DataSourse;
import com.company.dao.BookDao;
import com.company.dao.impl.BookDaoImpl;
import com.company.entity.Book;
import com.company.service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl(DataSourse.INSTANCE);
        BookServiceImpl bookService = new BookServiceImpl(bookDao);
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                you can enter:
                all - to see all books in the shop
                get id - to see information about the book with your id
                delete id  - to delete the book with your id
                exit - to leave the application
                updateBook id - to update book
                create book - to create book
                """);
        String[] words = sc.nextLine().split(" ");

        switch (words[0]) {
            case "exit":
                System.out.println("Application is close.");
                break;
            case "all":
                List<Book> books = bookService.getAll();
                System.out.println("All books in the book store:");
                books.forEach(System.out::println);
                break;
            case "get":
                System.out.println("Book by id:");
                Book book = bookService.getById(Long.parseLong(words[1]));
                System.out.println(book);
                break;
            case "delete":
                bookService.delete(Long.parseLong(words[1]));
                break;
            case "updateBook":
                Long id = Long.parseLong(words[1]);
                System.out.println("Enter book cover: ");
                Book.Cover cover = Book.Cover.valueOf(sc.nextLine());
                System.out.println("Enter book isbn: ");
                String isbn = sc.nextLine();
                System.out.println("Enter book name: ");
                String bookName = sc.nextLine();
                System.out.println("Enter book author name: ");
                String author = sc.nextLine();
                System.out.println("Enter year of book edition: ");
                int year = sc.nextInt();
                System.out.println("Enter book price: ");
                BigDecimal price = sc.nextBigDecimal();
                bookService.update(new Book(id, bookName, author, year, price, isbn, cover));
                break;
            case "create":
                System.out.println("Enter book cover: ");
                Book.Cover coverCr = Book.Cover.valueOf(sc.nextLine());
                System.out.println("Enter book isbn: ");
                String isbnCr = sc.nextLine();
                System.out.println("Enter book name: ");
                String bookNameCr = sc.nextLine();
                System.out.println("Enter book author name: ");
                String authorCr = sc.nextLine();
                System.out.println("Enter year of book edition: ");
                int yearCr = sc.nextInt();
                System.out.println("Enter book price: ");
                BigDecimal priceCr = sc.nextBigDecimal();
                bookService.create(new Book(bookNameCr, authorCr, yearCr, priceCr, isbnCr, coverCr));
                break;
        }

        sc.close();
    }
}
