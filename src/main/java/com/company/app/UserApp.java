package com.company.app;

import com.company.dao.connection.DataSource;
import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.company.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl(DataSource.INSTANCE);
        UserServiceImpl userService = new UserServiceImpl(userDaoImpl);
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                you can enter:
                all - to see all users in the shop
                get id - to see information about the user with your id
                delete id  - to delete the user with your id
                exit - to leave the application
                updateUser id - to update user
                create user - to create user
                """);
        String[] words = sc.nextLine().split(" ");

        switch (words[0]) {
            case "exit":
                System.out.println("Application is close.");
                break;
            case "all":
                List<User> users = userService.findAll();
                System.out.println("All users in the book store:");
                users.forEach(System.out::println);
                break;
            case "get":
                System.out.println("User by id:");
                User user = userService.findById(Long.parseLong(words[1]));
                System.out.println(user);
                break;
            case "delete":
                userService.delete(Long.parseLong(words[1]));
                break;
            case "updateUser":
                Long id = Long.parseLong(words[1]);
                System.out.println("Enter user name: ");
                String userName = sc.nextLine();
                System.out.println("Enter user email: ");
                String userEmail = sc.nextLine();
                System.out.println("Enter user password: ");
                String userPassword = sc.nextLine();
                userService.update(new User(id, userName, userEmail, userPassword));
                break;
            case "create":
                System.out.println("Enter user name: ");
                String userNameCr = sc.nextLine();
                System.out.println("Enter user email: ");
                String userEmailCr = sc.nextLine();
                System.out.println("Enter user password: ");
                String userPasswordCr = sc.nextLine();
                userService.create(new User(userNameCr, userEmailCr, userPasswordCr));
                break;
        }
        ;

        sc.close();
    }
}
