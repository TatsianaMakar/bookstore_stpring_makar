package com.company.controller;

import com.company.dao.connection.DataSourse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandParam = req.getParameter("command");
        Command command;
        try {
            command = CommandFactory.INSTANCE.getCommand(commandParam);
        } catch (Exception e) {
            command = CommandFactory.INSTANCE.getCommand("error");
        }
        String page=command.execute(req);
           req.getRequestDispatcher(page).forward(req,resp);
      }

    public void destroy() {
        System.out.println("Servlet destroy");
        try {
            DataSourse.INSTANCE.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
