package com.company;

import com.company.repository.entity.User;
import com.company.repository.impl.UserDaoImpl;
import com.company.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfiguration.class)) {
//            UserServiceImpl userService=context.getBean(UserServiceImpl.class);
//            User user= userService.findById(5L);
//            user.setUserName("FGFHFH");
//            User updated=userService.update(user);
//            System.out.printf("updated");
        }
    }
}

