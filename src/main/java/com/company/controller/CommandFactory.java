package com.company.controller;

import com.company.dao.connection.DataSourse;
import com.company.dao.impl.BookDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.service.impl.BookServiceImpl;
import com.company.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static final CommandFactory INSTANCE = new CommandFactory();

    public final Map<String, Command> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        BookServiceImpl bookService = new BookServiceImpl(new BookDaoImpl(DataSourse.INSTANCE));
        UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl(DataSourse.INSTANCE));
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
