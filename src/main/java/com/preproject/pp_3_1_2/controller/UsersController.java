package com.preproject.pp_3_1_2.controller;

import com.preproject.pp_3_1_2.model.User;
import com.preproject.pp_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("title", "Список пользователей");
        model.addAttribute("users", userList);
        return "users";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("user-delete")
    public String deleteUser(@RequestParam(value = "id") String id) {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/users";
    }
    @GetMapping("/user-update")
    public String updateUserForm(@RequestParam(value = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.editeUser(user);
        return "redirect:/users";
    }
}
