package com.company.controller;

import com.company.dao.connection.DataSourse;
import com.company.dao.impl.BookDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.service.BookService;
import com.company.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static final CommandFactory INSTANCE = new CommandFactory();

    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        BookService bookService = new BookService(new BookDaoImpl(DataSourse.INSTANCE));
        UserService userService = new UserService(new UserDaoImpl(DataSourse.INSTANCE));
        commandMap.put("book", new BookCommand(bookService));
        commandMap.put("user", new UserCommand(userService));
        commandMap.put("books", new BooksCommand(bookService));
        commandMap.put("users", new UsersCommand(userService));
        commandMap.put("error", new ErrorCommand());

    }

    public Command getCommand(String command) {
        return commandMap.get(command);
    }

}
