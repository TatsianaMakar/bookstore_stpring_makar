package com.company.controller;

import com.company.dao.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user";
    }

//    @GetMapping("/getAll")
//    public String getUsers(Model model) {
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
//        return "users";
//    }

//    @GetMapping("/create")
//    public String createUserForm() {
//        return "createUserForm";
//    }

//    @PostMapping("/create")
//    public String createUser(@ModelAttribute User user) {
//        userService.create(user);
//        return "redirect:/users/" + user.getId();
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUserForm(@PathVariable Long id, Model model) {
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//        return "editUserForm";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String editUser(@ModelAttribute User user) {
//        userService.edit(user);
//        return "redirect:/users/" + user.getId();
//    }
//
//    @PostMapping("/delete/{id}")
//    public String editUserForm(@PathVariable Long id) {
//        userService.delete(id);
//        return "redirect:/users/getAll";
//    }
}