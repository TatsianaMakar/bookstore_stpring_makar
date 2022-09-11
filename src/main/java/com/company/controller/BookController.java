package com.company.controller;

import com.company.dao.entity.Book;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/getAll")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/create")
    public String createBookForm() {
        return "createBookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.create(book);
        return "redirect:/book/" + book.getId();
    }

    @GetMapping("/edit/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "updateBookForm";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute Book book) {
        bookService.create(book);
        return "redirect:/book/" + book.getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "delete";
    }
}
